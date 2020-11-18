<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 项目底稿管理
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="handle-box">
                <el-row>
                    <el-col :span="6">
                        <el-select v-model="query.status" placeholder="项目状态" class="handle-input mr10">
                            <el-option
                                v-for="item in statusOptions"
                                :key="item.code"
                                :label="item.label"
                                :value="item.code">
                            </el-option>
                        </el-select>
                    </el-col>
                    <el-col :span="6">
                        <el-input v-model="query.projectName" placeholder="项目名称" class="handle-input mr10"></el-input>
                    </el-col>
                    <el-col :span="6">
                        <el-select v-model="query.projectType" placeholder="项目类型" class="handle-input mr10" @change="handleProjectTypeChange">
                            <el-option
                                v-for="item in projectTypeOptions"
                                :key="item.id"
                                :label="item.typename"
                                :value="item.id">
                            </el-option>
                        </el-select>
                    </el-col>
                    <el-col :span="6">
                        <el-select v-model="query.projectStage" placeholder="项目阶段" class="handle-input mr10">
                            <el-option
                                v-for="item in projectStageOptions"
                                :key="item.projectstage"
                                :label="item.stagename"
                                :value="item.projectstage">
                            </el-option>
                        </el-select>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="24">
                        <span>&nbsp;</span>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="6">
                       <el-date-picker v-model="query.beginDate" type="date" value-format="yyyy-MM-dd" placeholder="开始时间" class="handle-input mr10"></el-date-picker>
                    </el-col>
                    <el-col :span="6">
                        <el-date-picker v-model="query.endDate" type="date" value-format="yyyy-MM-dd" placeholder="结束时间" class="handle-input mr10"></el-date-picker>
                    </el-col>
                    <el-col :span="6">
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
                        <div style="float: left" v-if="roles.add_project">
                            <el-button type="primary" icon="el-icon-plus" @click="handleAdd">新增</el-button>
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
                <!-- <el-table-column prop="id" label="项目ID" width="75" align="center"></el-table-column> -->
                <el-table-column prop="status" label="项目状态" :formatter="statusFormatter"></el-table-column>
                <el-table-column prop="projectname" label="项目名称"></el-table-column>
                <el-table-column prop="projectno" label="项目编号"></el-table-column>
                <el-table-column prop="projecttypename" label="项目类型"></el-table-column>
                <el-table-column prop="stagename" label="项目阶段"></el-table-column>
                <el-table-column prop="begindate" label="开始时间"></el-table-column>
                <el-table-column prop="enddate" label="结束时间"></el-table-column>
                <el-table-column label="操作" width="250" align="center">
                    <template slot-scope="scope">
                        <el-button
                                v-if="roles.view_project"
                                type="text"
                                icon="el-icon-tickets"
                                class="lookup-me"
                                @click="handleLookup(scope.$index, scope.row)"
                        >查看项目</el-button>
                        <el-button
                                v-if="roles.edit_project"
                                type="text"
                                icon="el-icon-edit"
                                class="edit-me"
                                @click="handleEdit(scope.$index, scope.row)"
                        >编辑项目</el-button>
                        <el-button
                                v-if="roles.view_manuscript"
                                type="text"
                                icon="el-icon-view"
                                class="view-me"
                                @click="handleView(scope.$index, scope.row)"
                        >查看底稿</el-button>
                        <el-button
                                v-if="roles.upload_manuscript"
                                type="text"
                                icon="el-icon-upload"
                                class="upload-me"
                                @click="handleUpload(scope.$index, scope.row)"
                        >上传底稿</el-button>
                        <el-button
                                v-if="roles.stagechange_manuscript"
                                type="text"
                                icon="el-icon-arrow-right"
                                class="examine-me"
                                @click="handleStageChange(scope.$index, scope.row)"
                        >阶段改变</el-button>
                        <el-button
                                v-if="roles.suspend_project && scope.row.status == '11'"
                                type="text"
                                icon="el-icon-lock"
                                class="examine-me"
                                @click="handleSuspend(scope.$index, scope.row)"
                        >暂停</el-button>
                        <el-button
                                v-if="roles.abend_project && scope.row.status == '11'"
                                type="text"
                                icon="el-icon-forbidden"
                                class="examine-me"
                                @click="handleAbend(scope.$index, scope.row)"
                        >异常终止</el-button>
                        <el-button
                                v-if="roles.restart_project && (scope.row.status == '12' || scope.row.status == '13')"
                                type="text"
                                icon="el-icon-unlock"
                                class="examine-me"
                                @click="handleRestart(scope.$index, scope.row)"
                        >重启</el-button>
                        <el-button
                                v-if="roles.stop_project && scope.row.status == '11'"
                                type="text"
                                icon="el-icon-close"
                                class="examine-me"
                                @click="handleStop(scope.$index, scope.row)"
                        >终止</el-button>
                        <el-button
                                v-if="roles.examine_manuscript_1"
                                type="text"
                                icon="el-icon-flow"
                                class="examine-me"
                                @click="handleExamine_1(scope.$index, scope.row)"
                        >项目组审核底稿</el-button>
                        <el-button
                                v-if="roles.examine_manuscript_2"
                                type="text"
                                icon="el-icon-flow"
                                class="examine-me"
                                @click="handleExamine_2(scope.$index, scope.row)"
                        >质检审核底稿</el-button>
                        <el-button
                                v-if="roles.examine_manuscript_3"
                                type="text"
                                icon="el-icon-flow"
                                class="examine-me"
                                @click="handleExamine_3(scope.$index, scope.row)"
                        >内核发起</el-button>
                        <el-button
                                v-if="roles.examine_manuscript_4"
                                type="text"
                                icon="el-icon-flow"
                                class="examine-me"
                                @click="handleExamine_4(scope.$index, scope.row)"
                        >内核审核底稿</el-button>
                        <el-button
                                v-if="roles.examine_manuscript_5"
                                type="text"
                                icon="el-icon-flow"
                                class="examine-me"
                                @click="handleExamine_5(scope.$index, scope.row)"
                        >内核结束</el-button>
                        <el-button
                                v-if="roles.place_file"
                                type="text"
                                icon="el-icon-order"
                                class="file-me"
                                @click="handleFile(scope.$index, scope.row)"
                        >归档</el-button>
                        <el-button
                                v-if="roles.export_file"
                                type="text"
                                icon="el-icon-forward"
                                class="export-me"
                                @click="handleExport(scope.$index, scope.row)"
                        >监管报送</el-button>
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
        name: 'projectManagementSelect',
        data() {
            return {
                roles: {
                    add_project: false,//新增项目
                    view_project: false,//查看项目
                    edit_project: false,//编辑项目
                    view_manuscript: false,//查看底稿
                    stagechange_manuscript: false,//阶段改变
                    suspend_project: false,//暂停
                    abend_project: false,//异常终止
                    restart_project: false,//重启
                    stop_project: false,//终止
                    examine_manuscript_1: false,//项目组审核底稿
                    examine_manuscript_2: false,//质检审核底稿
                    examine_manuscript_3: false,//内核发起
                    examine_manuscript_4: false,//内核审核底稿
                    examine_manuscript_5: false,//内核结束
                    upload_manuscript: false,//上传底稿
                    place_file: false,//归档
                    export_file: false,//监管报送
                },
                query: {
                    status: '11',                // 项目状态
                    projectName: '',           // 项目名称
                    projectType: '',           // 项目类型
                    projectStage: '',          // 项目阶段
                    beginDate: '',             // 开始时间
                    endDate: '',               // 结束时间
                    currentPage: 1,
                    itemsPerPage: 10
                },
                tableData: [],
                statusOptions: [
                    {
                        code:  '11',
                        label: '正常',
                    },
                    {
                        code:  '12',
                        label: '暂停',
                    },
                    {
                        code:  '13',
                        label: '异常终止',
                    },
                    {
                        code:  '14',
                        label: '终止',
                    },
                ],
                projectTypeOptions: [],
                projectStageOptions: [],
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
            this.getInitData();
            this.getData();
        },
        methods: {
            // 初始化菜单权限
            initAuth(){
                // 获取当前用户下所有的按钮权限集
                let vuex = JSON.parse(window.sessionStorage.vuex);
                let buttonsAll = vuex.buttonsAll;
                // console.log(buttonsAll);
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
                    add_project: this.hasAuth('add_project'),//新增项目
                    view_project: this.hasAuth('view_project'),//查看项目
                    edit_project: this.hasAuth('edit_project'),//编辑项目
                    view_manuscript: this.hasAuth('view_manuscript'),//查看底稿
                    stagechange_manuscript: this.hasAuth('stagechange_manuscript'),//阶段改变
                    suspend_project: this.hasAuth('suspend_project'),//暂停
                    abend_project: this.hasAuth('abend_project'),//异常终止
                    restart_project: this.hasAuth('restart_project'),//重启
                    stop_project: this.hasAuth('stop_project'),//终止
                    examine_manuscript_1: this.hasAuth('examine_manuscript_1'),//项目组审核底稿
                    examine_manuscript_2: this.hasAuth('examine_manuscript_2'),//质检审核底稿
                    examine_manuscript_3: this.hasAuth('examine_manuscript_3'),//内核发起
                    examine_manuscript_4: this.hasAuth('examine_manuscript_4'),//内核审核底稿
                    examine_manuscript_5: this.hasAuth('examine_manuscript_5'),//内核结束
                    upload_manuscript: this.hasAuth('upload_manuscript'),//上传底稿
                    place_file: this.hasAuth('place_file'),//归档
                    export_file: this.hasAuth('export_file'),//监管报送
                };
            },
            // 获取项目类型数据
            getInitData(){
                this.net.getListByPage_ProjectTypeInfo({
                    currentPage: 1,
                    itemsPerPage: 100
                }).then(res => {
                    this.projectTypeOptions = res.data;
                });
            },
            //更改项目类型时触发操作
            handleProjectTypeChange(currentValue){
                this.projectStageOptions = [];
                this.net.getListByPage_ProjectStageInfo({
                    currentPage: 1,
                    itemsPerPage: 100,
                    projecttype: currentValue
                }).then(res => {
                    this.projectStageOptions = res.data;
                });
            },
            // 分页查询项目信息
            getData() {
                this.net.getListByPage_ProjectInfo(this.query).then(res => {
                    this.tableData = res.data;
                    this.pageTotal = res.recordsTotal || 0;
                });
            },
            // 状态格式化
            // eslint-disable-next-line no-unused-vars
            statusFormatter(row, column) {
                let status = row.status;
                var statusStr = '';
                if(status){
                    if(status == '11'){
                        statusStr = '正常';
                    } else if(status == '12'){
                        statusStr = '暂停';
                    } else if(status == '13'){
                        statusStr = '异常终止';
                    } else if(status == '14'){
                        statusStr = '终止';
                    }
                }
                return statusStr;
            },
            // 触发搜索按钮
            handleSearch() {
                this.getData();
            },
            // 触发重置按钮
            handleReset() {
                this.query.status = '11';
                this.query.projectName = '';
                this.query.projectType = '';
                this.query.projectStage = '';
                this.query.beginDate = '';
                this.query.endDate = '';
                this.projectStageOptions = [];
            },
            // 删除操作
            // handleDelete(index, row) {
            //     // 二次确认删除
            //     this.$confirm('确定要删除吗？', '提示', {
            //         type: 'warning'
            //     })
            //         .then(() => {
            //             this.$message.success('删除成功');
            //             this.tableData.splice(index, 1);
            //         })
            //         .catch(() => {});
            // },
            // 多选操作
            // handleSelectionChange(val) {
            //     this.multipleSelection = val;
            // },
            // delAllSelection() {
            //     const length = this.multipleSelection.length;
            //     let str = '';
            //     this.delList = this.delList.concat(this.multipleSelection);
            //     for (let i = 0; i < length; i++) {
            //         str += this.multipleSelection[i].name + ' ';
            //     }
            //     this.$message.error(`删除了${str}`);
            //     this.multipleSelection = [];
            // },
            // 新增项目
            handleAdd() {
                this.$router.push({path:"/projectManagementAdd"});
                var _that = this;
                bus.$on('addProject_Evt', () => {
                    _that.$message.success(`新增成功`);
                    this.getData();
                });
            },
            // 查看项目
            handleLookup(index, row) {
                var _that = this;
                _that.idx = index;
                _that.form = row;
                let query = {
                    id: row.id
                };
                this.$router.push({path:"/projectManagementLookup",query:query});
            },
            // 编辑项目
            handleEdit(index, row) {
                var _that = this;
                _that.idx = index;
                _that.form = row;
                let query = {
                    id: row.id
                };
                this.$router.push({path:"/projectManagementUpdate",query:query});
                //开启监听只要编辑页面出发保存编辑时触发
                bus.$on('editProject_Evt', () => {
                    _that.$message.success(`编辑成功`);
                    this.getData();
                });
            },
            // 查看底稿
            handleView(index, row) {
                var _that = this;
                _that.idx = index;
                _that.form = row;
                let query = {
                    id: row.id,
                    projectStage: row.stage
                };
                this.$router.push({path:"/projectManagementView",query:query});
            },
            // 项目组审核底稿
            handleExamine_1(index, row) {
                var _that = this;
                _that.idx = index;
                _that.form = row;
                let query = {
                    id: row.id,
                    projectStage: row.stage
                };
                this.$router.push({path:"/projectManagementExamine1",query:query});
            },
            // 质检审核底稿
            handleExamine_2(index, row) {
                var _that = this;
                _that.idx = index;
                _that.form = row;
                let query = {
                    id: row.id,
                    projectStage: row.stage
                };
                this.$router.push({path:"/projectManagementExamine2",query:query});
            },
            // 内核发起底稿
            handleExamine_3(index, row) {
                var _that = this;
                _that.idx = index;
                _that.form = row;
                let query = {
                    id: row.id,
                    projectStage: row.stage
                };
                this.$router.push({path:"/projectManagementExamine3",query:query});
            },
            // 内核审核底稿
            handleExamine_4(index, row) {
                var _that = this;
                _that.idx = index;
                _that.form = row;
                let query = {
                    id: row.id,
                    projectStage: row.stage
                };
                this.$router.push({path:"/projectManagementExamine4",query:query});
            },
            // 内核发起结束
            handleExamine_5(index, row) {
                var _that = this;
                _that.idx = index;
                _that.form = row;
                let query = {
                    id: row.id,
                    projectStage: row.stage
                };
                this.$router.push({path:"/projectManagementExamine5",query:query});
            },
            // 上传底稿
            handleUpload(index, row) {
                var _that = this;
                _that.idx = index;
                _that.form = row;
                let query = {
                    id: row.id,
                    projectStage: row.stage
                };
                this.$router.push({path:"/projectManagementUpload",query:query});
            },
            // 阶段改变
            handleStageChange(index, row) {
                this.$confirm('确定阶段改变吗？', '提示', {
                    type: 'warning'
                })
                .then(() => {
                    var _that = this;
                    _that.idx = index;
                    _that.form = row;
                    let param = {
                        'projectid': row.id,
                        'projectStage': row.stage,
                        'operId': '4'
                    };
                    this.net.updateProcess_ProcessNodeInfo(param).then(res => {
                        if (res.code === 200) {
                            this.$message.success(res.message);
                        } else {
                            this.$message.error(res.message);
                        }
                    // eslint-disable-next-line no-unused-vars
                    }).catch((e)=>{
                        this.$message.error("网络问题，阶段改变失败！");
                    });
                })
                .catch(() => {});
            },
            // 暂停
            handleSuspend(index, row) {
                this.$confirm('确定暂停吗？', '提示', {
                    type: 'warning'
                })
                .then(() => {
                    var _that = this;
                    _that.idx = index;
                    _that.form = row;
                    let param = {
                        'id': row.id,
                        'status': '12'
                    };
                    this.net.update_ProjectInfo(param).then(res => {
                        if(res.success){
                            this.$message.success('暂停成功');
                            this.getData();
                        } else {
                            this.$message.error('暂停失败！');
                        }
                        
                    // eslint-disable-next-line no-unused-vars
                    }).catch((e)=>{
                        this.$message.error("网络问题，暂停失败！");
                    });
                })
                .catch(() => {});
            },
            // 异常终止
            handleAbend(index, row) {
                this.$confirm('确定异常终止吗？', '提示', {
                    type: 'warning'
                })
                .then(() => {
                    var _that = this;
                    _that.idx = index;
                    _that.form = row;
                    let param = {
                        'id': row.id,
                        'status': '13'
                    };
                    this.net.update_ProjectInfo(param).then(res => {
                        if(res.success){
                            this.$message.success('异常终止成功');
                            this.getData();
                        } else {
                            this.$message.error('异常终止失败！');
                        }
                        
                    // eslint-disable-next-line no-unused-vars
                    }).catch((e)=>{
                        this.$message.error("网络问题，异常终止失败！");
                    });
                })
                .catch(() => {});
            },
            // 重启
            handleRestart(index, row) {
                this.$confirm('确定重启吗？', '提示', {
                    type: 'warning'
                })
                .then(() => {
                    var _that = this;
                    _that.idx = index;
                    _that.form = row;
                    let param = {
                        'id': row.id,
                        'status': '11'
                    };
                    this.net.update_ProjectInfo(param).then(res => {
                        if(res.success){
                            this.$message.success('重启成功');
                            this.getData();
                        } else {
                            this.$message.error('重启失败！');
                        }
                        
                    // eslint-disable-next-line no-unused-vars
                    }).catch((e)=>{
                        this.$message.error("网络问题，重启失败！");
                    });
                })
                .catch(() => {});
            },
            // 终止
            handleStop(index, row) {
                this.$confirm('确定要终止项目吗？', '提示', {
                    type: 'warning'
                })
                .then(() => {
                    var _that = this;
                    _that.idx = index;
                    _that.form = row;
                    let param = {
                        'id': row.id,
                        'status': '14'
                    };
                    this.net.update_ProjectInfo(param).then(res => {
                        if(res.success){
                            this.$message.success('终止成功');
                            this.getData();
                        } else {
                            this.$message.error('终止失败！');
                        }
                        
                    // eslint-disable-next-line no-unused-vars
                    }).catch((e)=>{
                        this.$message.error("网络问题，终止失败！");
                    });
                })
                .catch(() => {});
            },
            // 归档
            handleFile(index, row) {
                var _that = this;
                _that.idx = index;
                _that.form = row;
                // eslint-disable-next-line no-unused-vars
                let query = {
                    id: row.id
                };
                //this.$router.push({path:"/projectManagementFile",query:query});
            },
            // 监管报送
            handleExport(index, row) {
                var _that = this;
                _that.idx = index;
                _that.form = row;
                let query = {
                    id: row.id,
                    projectStage: row.stage
                };
                this.$router.push({path:"/projectManagementExport",query:query});
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
