<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 消息管理
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="handle-box">
                <el-row>
                    <el-col :span="6">
                        <el-select v-model="query.mgtype" placeholder="消息类型" class="handle-input mr10">
                            <el-option
                                v-for="item in mgtypeOptions"
                                :key="item.code"
                                :label="item.label"
                                :value="item.code">
                            </el-option>
                        </el-select>
                    </el-col>
                    <el-col :span="6">
                        <el-select v-model="query.mgstate" placeholder="消息状态" class="handle-input mr10">
                            <el-option
                                v-for="item in mgstateOptions"
                                :key="item.code"
                                :label="item.label"
                                :value="item.code">
                            </el-option>
                        </el-select>
                    </el-col>
                    <el-col :span="6">
                       <el-input v-model="query.mgcontent" placeholder="消息内容" class="handle-input mr10"></el-input>
                    </el-col>
                    <el-col :span="6">
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="24">
                        <span>&nbsp;</span>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="24">
                        <div style="float: left" >
                            <el-button type="primary" v-if="roles.add_msg" icon="el-icon-plus" @click="handleAdd">新增</el-button>
                            <el-button type="success" v-if="roles.publish_msg" icon="el-icon-s-promotion" @click="handlePublish">发布</el-button>
                            <el-button type="danger" v-if="roles.recall_msg" icon="el-icon-s-release" @click="handleRecall">撤回</el-button>
                        </div>
                        <div style="float: right">
                            <el-button type="primary" icon="el-icon-search" @click="handleSearch">搜索</el-button>
                            <el-button type="primary" icon="el-icon-delete" @click="handleReset">重置</el-button>
                        </div>
                    </el-col>
                </el-row>

            </div>
            <el-table
                    :data="tableData"
                    border
                    class="table"
                    ref="multipleTable"
                    header-cell-class-name="table-header"
            >
                <el-table-column prop="mgtype" label="消息类型" :formatter="mgtypeFormatter"></el-table-column>
                <el-table-column prop="mgstate" label="消息状态" :formatter="mgstateFormatter"></el-table-column>
                <el-table-column prop="mgcontent" label="消息内容"></el-table-column>
                <el-table-column label="操作" width="250" align="center">
                    <template slot-scope="scope">
                        <el-button
                                v-if="roles.edit_msg"
                                type="text"
                                icon="el-icon-edit"
                                class="edit-me"
                                @click="handleEdit(scope.$index, scope.row)"
                        >编辑</el-button>
                        <el-button
                            v-if="roles.del_msg && (scope.row.mgstate == '1')"
                            type="text"
                            icon="el-icon-delete"
                            class="red"
                            @click="handleDelete(scope.$index, scope.row)"
                        >删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <div class="pagination">
                <el-pagination
                        background
                        layout="total, prev, pager, next"
                        :current-page="query.currentPage"
                        :page-size="query.itemsPerPage"
                        :total="pageTotal"
                        @current-change="handlePageChange"
                ></el-pagination>
            </div>
        </div>
    </div>
</template>

<script>
    import bus from "@/components/common/bus";
    import { _ } from '@/utils';
    export default {
        name: 'msgManagementSelect',
        data() {
            return {
                roles: {
                    add_msg: false,// 新增消息
                    edit_msg: false,// 编辑消息
                    del_msg: false,// 删除消息
                    publish_msg: false,// 发布消息
                    recall_msg: false,// 撤回消息
                },
                query: {
                    mgtype: '',           // 消息类型
                    mgstate: '',          // 消息状态
                    mgcontent: '',        // 消息内容
                    currentPage: 1,
                    itemsPerPage: 10
                },
                mgtypeOptions: [
                    {
                        code: '1',
                        label: '系统',
                    },
                    {
                        code: '2',
                        label: '普通',
                    },
                ],
                mgstateOptions: [
                    {
                        code: '1',
                        label: '草稿',
                    },
                    {
                        code: '2',
                        label: '发布',
                    },
                ],
                tableData: [],
                multipleSelection: [],
                delList: [],
                pageTotal: 0,
                form: {},
                idx: -1,
                id: -1
            };
        },
        created() {
            this.initAuth();
            this.initRoles();
            this.getData();
        },
        methods: {
            // 初始化菜单权限
            initAuth(){
                // 获取当前用户下所有的按钮权限集
                let vuex = JSON.parse(window.sessionStorage.vuex);
                let buttonsAll = vuex.buttonsAll;
                this.menulist = buttonsAll;
            },
            hasAuth(perms){
                let obj = _.find(this.menulist,function(data) {
                    return data.perms === perms
                });
                return !!obj
            },
            initRoles(){
                this.roles = {
                    add_msg: this.hasAuth('add_msg'),//新增消息
                    edit_msg: this.hasAuth('edit_msg'),//编辑消息
                    del_msg: this.hasAuth('del_msg'),//删除消息
                    publish_msg: this.hasAuth('publish_msg'),//发布消息
                    recall_msg: this.hasAuth('recall_msg'),//撤回消息
                };
            },
            //消息类型格式化
            // eslint-disable-next-line no-unused-vars
            mgtypeFormatter(row, column) {
                let mgtype = row.mgtype;
                var mgtypeStr = '';
                if(mgtype){
                    if(mgtype == '1'){
                        mgtypeStr = '系统';
                    } else if(mgtype == '2'){
                        mgtypeStr = '普通';
                    } else if(mgtype == '3'){
                        mgtypeStr = '异常终止';
                    } else if(mgtype == '4'){
                        mgtypeStr = '终止';
                    }
                }
                return mgtypeStr;
            },
            //消息状态格式化
            // eslint-disable-next-line no-unused-vars
            mgstateFormatter(row, column) {
                let mgstate = row.mgstate;
                var mgstateStr = '';
                if(mgstate){
                    if(mgstate == '1'){
                        mgstateStr = '草稿';
                    } else if(mgstate == '2'){
                        mgstateStr = '发布';
                    } else if(mgstate == '3'){
                        mgstateStr = '部分撤回';
                    } else if(mgstate == '4'){
                        mgstateStr = '完全撤回';
                    }
                }
                return mgstateStr;
            },
            // 分页查询项目信息
            getData() {
                this.net.getListByPage_MessageCenter(this.query).then(res => {
                    this.tableData = res.data;
                    this.pageTotal = res.recordsTotal || 0;
                });
            },
            // 触发搜索按钮
            handleSearch() {
                this.getData();
            },
            // 触发重置按钮
            handleReset() {
                this.query = {
                    mgtype: '',           // 消息类型
                    mgstate: '',          // 消息状态
                    mgcontent: '',        // 消息内容
                    currentPage: 1,
                    itemsPerPage: 10
                };
            },
            // 删除操作
            handleDelete(index, row) {
                // 二次确认删除
                this.$confirm('确定要删除吗？', '提示', {
                    type: 'warning'
                })
                .then(() => {
                    this.net.del_MessageCenter({id:row.id}).then(res => {
                        if (res.code === 200) {
                            this.$message.success('删除成功');
                            this.tableData.splice(index, 1);
                        } else {
                            this.$message.error("服务器错误，删除失败");
                        }
                    // eslint-disable-next-line no-unused-vars
                    }).catch((e)=>{
                        this.$message.error("请求错误，删除失败！");
                    });
                })
                .catch(() => {});
            },
            // 发布消息
            handlePublish() {
                this.$router.push({path:"/msgManagementPublish"});
                var _that = this;
                bus.$on('publishMsg_Evt', () => {
                    _that.$message.success(`发布成功`);
                    this.getData();
                });
            },
            // 撤回消息
            handleRecall() {
                this.$router.push({path:"/msgManagementRecall"});
                var _that = this;
                bus.$on('recallMsg_Evt', () => {
                    _that.$message.success(`撤回成功`);
                    this.getData();
                });
            },
            // 新增消息
            handleAdd() {
                this.$router.push({path:"/msgManagementAdd"});
                var _that = this;
                bus.$on('addMsg_Evt', () => {
                    _that.$message.success(`新增成功`);
                    this.getData();
                });
            },
            // 编辑消息
            handleEdit(index, row) {
                var _that = this;
                _that.idx = index;
                _that.form = row;
                let query = {
                    id: row.id
                };
                this.$router.push({path:"/msgManagementUpdate",query:query});
                //开启监听只要编辑页面出发保存编辑时触发
                bus.$on('editMsg_Evt', () => {
                    _that.$message.success(`编辑成功`);
                    this.getData();
                });
            },
            // 分页导航
            handlePageChange(val) {
                this.$set(this.query, 'currentPage', val);
                this.getData();
            }
        }
    };
</script>

<style scoped>
    .handle-box {
        margin-bottom: 20px;
    }

    .handle-select {
        width: 120px;
    }

    .handle-input {
        width: 60%;
        display: inline-block;
    }
    .table {
        width: 100%;
        font-size: 14px;
    }
    .red {
        color: #ff0000;
    }
    .lookup-me{
        color: rgb(81,166,253);
    }
    .edit-me{
        color: rgb(110,78,253);
    }
    .view-me{
        color: rgb(71,118,253);
    }
    .examine-me{
        color: rgb(253,172,88);
    }
    .upload-me{
        color: rgb(253,84,84);
    }
    .file-me{
        color: rgb(82,221,112);
    }
    .export-me{
        color: rgb(71,161,253);
    }
    .mr10 {
        margin-right: 10px;
    }
    .table-td-thumb {
        display: block;
        margin: auto;
        width: 40px;
        height: 40px;
    }
</style>
