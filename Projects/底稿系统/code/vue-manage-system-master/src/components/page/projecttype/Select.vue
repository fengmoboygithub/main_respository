<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 项目类型管理
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="handle-box">
                <el-row type="flex">
                    <el-col :span="2">
                        <div style="float: left">
                            <el-button v-if="roles.add_project_type" type="primary" icon="el-icon-plus" @click="handleAdd">新增</el-button>
                        </div>
                    </el-col>
                    <el-col :span="2"></el-col>
                    <el-col :span="8">
                        <el-input v-model="query.typename" placeholder="项目类型名称" class="handle-input mr10"></el-input>
                    </el-col>
                    <el-col :span="6">
                        
                    </el-col>
                    <el-col :span="6">
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
                <!-- <el-table-column prop="id" label="项目类型ID" width="75" align="center"></el-table-column> -->
                <el-table-column prop="typename" label="项目类型名称"></el-table-column>
                <el-table-column label="操作" width="250" align="center">
                    <template slot-scope="scope">
                        <el-button
                                v-if="roles.edit_project_type"
                                type="text"
                                icon="el-icon-edit"
                                class="edit-me"
                                @click="handleEdit(scope.$index, scope.row)"
                        >编辑</el-button>
                        <el-button
                            v-if="roles.del_project_type"
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
        name: 'projectTypeManagementSelect',
        data() {
            return {
                roles: {
                    add_project_type: false,//新增项目类型
                    edit_project_type: false,//编辑项目类型
                    del_project_type: false,//删除项目类型
                },
                query: {
                    typename: '',           // 项目类型名称
                    currentPage: 1,
                    itemsPerPage: 10
                },
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
                // eslint-disable-next-line no-console
                console.log(buttonsAll);
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
                    add_project_type: this.hasAuth('add_project_type'),//新增项目类型
                    edit_project_type: this.hasAuth('edit_project_type'),//编辑项目类型
                    del_project_type: this.hasAuth('del_project_type'),//删除项目类型
                };
            },
            // 分页查询项目信息
            getData() {
                this.net.getListByPage_ProjectTypeInfo(this.query).then(res => {
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
                this.query.typename = '';
            },
            // 删除操作
            handleDelete(index, row) {
                // 二次确认删除
                this.$confirm('确定要删除吗？', '提示', {
                    type: 'warning'
                })
                .then(() => {
                    this.net.del_ProjectTypeInfo({id:row.id}).then(res => {
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
            // 查看项目类型
            // handleLookup(index, row) {
            //     var _that = this;
            //     _that.idx = index;
            //     _that.form = row;
            //     let query = {
            //         id: row.id
            //     };
            //     this.$router.push({path:"/projectTypeManagementLookup",query:query});
            // },
            // 新增项目类型
            handleAdd() {
                this.$router.push({path:"/projectTypeManagementAdd"});
                var _that = this;
                bus.$on('addProjectType_Evt', () => {
                    _that.$message.success(`新增成功`);
                    this.getData();
                });
            },
            // 编辑项目类型
            handleEdit(index, row) {
                var _that = this;
                _that.idx = index;
                _that.form = row;
                let query = {
                    id: row.id
                };
                this.$router.push({path:"/projectTypeManagementUpdate",query:query});
                //开启监听只要编辑页面出发保存编辑时触发
                bus.$on('editProjectType_Evt', () => {
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
