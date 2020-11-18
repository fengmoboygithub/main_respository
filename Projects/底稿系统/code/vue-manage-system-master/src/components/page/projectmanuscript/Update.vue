<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 编辑项目
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <!-- <el-menu
            :default-active="activeIndex"
            class="el-menu-demo"
            mode="horizontal"
            @select="handleSelect"
            background-color="#EFEFEF"
            text-color="#9D9D9D"
            active-text-color="#74B4F8">
            <el-menu-item index="1"><i class="el-icon-menu"></i>项目基本信息</el-menu-item>
            <el-menu-item index="2"><i class="el-icon-user-solid"></i>项目人员信息</el-menu-item>
        </el-menu> -->
        <div class="container">
            <div class="form-box" >
                <el-form ref="form" :model="form" :rules="rules" label-width="80px">
                    <div class="content-title" id="contentTitle">{{contentTitle}}</div>
                    <el-form-item label="项目名称" v-if="showBase" prop="projectname">
                        <el-input v-model="form.projectname" disabled></el-input>
                    </el-form-item>
                    <el-form-item label="项目编号" v-if="showBase" prop="projectno">
                        <el-input v-model="form.projectno"></el-input>
                    </el-form-item>
                    <el-form-item label="项目类型" v-if="showBase">
                        <el-select v-model="form.projecttype" disabled>
                            <el-option
                                v-for="item in projectTypeOptions"
                                :key="item.id"
                                :label="item.typename"
                                :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="项目阶段" v-if="showBase">
                        <el-select v-model="form.stage" disabled>
                            <el-option
                                v-for="item in projectStageOptionsForForm"
                                :key="item.projectstage"
                                :label="item.stagename"
                                :value="item.projectstage">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="项目时间" v-if="showBase" required>
                        <el-col :span="11">
                        <el-form-item prop="begindate">
                            <el-date-picker
                                type="date"
                                placeholder="选择开始日期"
                                v-model="form.begindate"
                                @change="handleBeginDateChange"
                                value-format="yyyy-MM-dd"
                                style="width: 100%;"
                            ></el-date-picker>
                        </el-form-item>
                        </el-col>
                        <el-col class="line" :span="2">-</el-col>
                        <el-col :span="11">
                        <el-form-item prop="enddate">
                            <el-date-picker
                                type="date"
                                placeholder="选择结束日期"
                                v-model="form.enddate"
                                @change="handleEndDateChange"
                                value-format="yyyy-MM-dd"
                                style="width: 100%;"
                            ></el-date-picker>
                        </el-form-item>
                        </el-col>
                    </el-form-item>
                    <div class="content-title" id="contentTitle1">{{contentTitle1}}</div>
                    <el-form-item label="项目经理" v-if="showPersonnel" prop="projectmanager">
                        <el-select v-model="form.projectmanager" placeholder="请选择">
                            <el-option
                                v-for="item in projectManagers"
                                :key="item.id"
                                :label="item.name"
                                :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="项目成员" v-if="showPersonnel" prop="personnelArr">
                        <el-select v-model="personnelArr" multiple placeholder="请选择">
                            <el-option
                                v-for="item in personnels"
                                :key="item.id"
                                :label="item.name"
                                :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-form>
            </div>
            <div class="content-title">项目目录信息</div>
            <!-- @tab-click="handleClick" -->
            <el-tabs v-model="form.stageForDir" tab-position="left" >
                <el-tab-pane
                    v-for="(item, index) in projectStageOptions"
                    :key="item.projectstage"
                    :label="item.stagename"
                    :name="item.projectstage"
                    :lazy=true
                    >
                    {{item.stagename}}
                    <v-project-dir-tree :index="index" :projectid="form.id" :projectStage="item.projectstage" :roles="roles" :isEdit="roles.status_show"></v-project-dir-tree>
                </el-tab-pane>
            </el-tabs>
            <div class="form-box" v-if="roles.status_show">
                <el-form>
                    <el-form-item>
                        <el-button type="primary" @click="onSubmit">保存</el-button>
                        <el-button @click="onCancel">取消</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </div>
    </div>
</template>

<script>
    import bus from "@/components/common/bus";
    import vProjectDirTree from '@/components/common/ProjectDirTree.vue';
    import { _ } from '@/utils';
    export default {
        name: 'projectManagementUpdate',
        components: {
            vProjectDirTree
        },
        data() {
            let that = this;
            var checkProjectName = (rule, value, callback) => {
                if (!value) {
                    return callback(new Error('请输入项目名称'));
                }
                var len = value.length;
                var len_flag = false;
                if (len<3) {
                    len_flag = true;
                } else if(len>15){
                    len_flag = true;
                }
                if(len_flag){
                    callback(new Error('长度在 3 到 15 个字符'));
                } else {
                    var params = {
                        projectname: value,
                        idCurr: that.idCurr
                    };
                    this.net.getProjectForOnly_ProjectInfo(params).then(res => {
                        if(res.entity){
                            callback(new Error('项目名称已存在，请重新输入！'));
                        } else {
                            callback();
                        }
                    // eslint-disable-next-line no-unused-vars
                    }).catch((e)=>{
                        callback(new Error('请求错误，验证失败！'));
                    });
                }
            };
            var checkProjectNo = (rule, value, callback) => {
                if (value) {
                   var params = {
                        projectno: value,
                        idCurr: that.idCurr
                    };
                    this.net.getProjectForOnly_ProjectInfo(params).then(res => {
                        if(res.entity){
                            callback(new Error('项目编号已存在，请重新输入！'));
                        } else {
                            callback();
                        }
                    // eslint-disable-next-line no-unused-vars
                    }).catch((e)=>{
                        callback(new Error('请求错误，验证失败！'));
                    });
                } else {
                    callback();
                }
            };
            var checkBegindate = (rule, value, callback) => {
                if (!value) {
                    return callback(new Error('请选择开始时间'));
                }
                var _enddateVal = that.form.enddate;
                if(_enddateVal){
                    var _begindateVal = value;
                    //去除所有-字符
                    _enddateVal = parseInt(_enddateVal.replace(/-+/g,""));
                    _begindateVal = parseInt(_begindateVal.replace(/-+/g,""));
                    if(_begindateVal > _enddateVal){
                        return callback(new Error('选择的开始时间不能大于结束时间'));
                    } else{
                        callback();
                    }
                } else {
                    callback();
                }
            };
            var checkEnddate = (rule, value, callback) => {
                if (!value) {
                    return callback(new Error('请选择结束时间'));
                }
                var _begindateVal = that.form.begindate;
                if(_begindateVal){
                    var _enddateVal = value;
                    //去除所有-字符
                    _enddateVal = parseInt(_enddateVal.replace(/-+/g,""));
                    _begindateVal = parseInt(_begindateVal.replace(/-+/g,""));
                    if(_begindateVal > _enddateVal){
                        return callback(new Error('选择的结束时间不能小于开始时间'));
                    } else{
                        callback();
                    }
                } else {
                    callback();
                }
            };
            return {
                roles: {
                    add_zdydir: false,//新增自定义目录
                    edit_zdydir: false,//编辑自定义目录
                    del_zdydir: false,//删除自定义目录
                    status_show: true,//正常状态显示标识 若是非正常状态则为false
                },
                activeIndex:'1',
                //内容标题
                contentTitle: "项目基本信息",
                //内容标题
                contentTitle1: "项目人员信息",
                //项目基本信息显示标识
                showBase: true,
                //项目人员信息显示标识
                showPersonnel: true,
                idCurr: "",
                form: {
                    id: '',//项目ID
                    projectname: '',//项目名称
                    projectno: '',//项目编号
                    projecttype: '',//项目类型
                    stage: '',//项目阶段
                    stageForDir: '',//项目阶段
                    begindate: '',//开始时间
                    enddate: '',//结束时间
                    projectmanager:'',//项目经理
                    personnel: '',//项目成员
                    personnelArr: [],//项目成员数组
                },
                personnelArr: [],//项目成员数组
                rules: {
                    projectname: [
                        { required: true, validator: checkProjectName, trigger: 'blur' }
                    ],
                    projectno: [
                        { required: false, validator: checkProjectNo, trigger: 'blur' }
                    ],
                    // projecttype: [
                    //     { required: true, message: '请选择项目类型', trigger: 'change' }
                    // ],
                    // stage: [
                    //     { type: 'date', required: true, message: '请选择日期', trigger: 'change' }
                    // ],
                    begindate: [
                        { required: true, validator: checkBegindate, trigger: 'change' }
                    ],
                    enddate: [
                        { required: true, validator: checkEnddate, trigger: 'change' }
                    ],
                    projectmanager: [
                        { required: true, message: '请选择项目经理', trigger: 'change' }
                    ],
                    personnelArr: [
                        { required: true, message: '请选择项目成员', trigger: 'change' }
                    ]
                },
                //项目经理集合
                projectManagers: [],
                //项目成员集合
                personnels: [],
                //项目类型选项集合
                projectTypeOptions: [],
                //项目阶段选项集合用于目录
                projectStageOptions: [],
                //项目阶段选项集合用于form
                projectStageOptionsForForm: [],
            };
        },
        created() {
            this.initAuth();
            this.initRoles();
            this.getInitData();
        },
        watch: {
            personnelArr: {
                // eslint-disable-next-line no-unused-vars
                handler(newVal, oldVal) {
                    this.form.personnelArr = newVal;
                },
                deep: true,
                immediate: true
            }
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
                    add_zdydir: this.hasAuth('add_zdydir'),//新增自定义目录
                    edit_zdydir: this.hasAuth('edit_zdydir'),//编辑自定义目录
                    del_zdydir: this.hasAuth('del_zdydir'),//删除自定义目录
                    status_show: true,//正常状态显示标识 若是非正常状态则为false
                };
            },
            // eslint-disable-next-line no-unused-vars
            handleBeginDateChange(currentValue){
                this.$refs['form'].validate();
            },
            // eslint-disable-next-line no-unused-vars
            handleEndDateChange(currentValue){
                this.$refs['form'].validate();
            },
            //
            // eslint-disable-next-line no-unused-vars
            handleClick(tab, event) {
                // console.log(tab, event);
                // console.log(tab.index);
                // bus.$emit('projectDirTree_load_'+tab.index);
            },
            //项目基本信息或项目人员信息切换
            // eslint-disable-next-line no-unused-vars
            handleSelect(key, keyPath) {
                if(key[0] == "1"){
                    this.showBase = true;
                    this.showPersonnel = true;
                    //this.contentTitle = "项目基本信息";
                    window.location.href="#contentTitle";
                } else {
                    this.showBase = true;
                    this.showPersonnel = true;
                    //this.contentTitle = "项目人员信息";
                    window.location.href="#contentTitle1";
                }
            },
            // 获取项目信息
            getData(){
                
            },
            // 获取初始化数据
            async getInitData(){
                // 获取项目类型数据
                let res = await this.net.getListByPage_ProjectTypeInfo({
                    currentPage: 1,
                    itemsPerPage: 100
                })
                this.projectTypeOptions = res.data;

                let res2 = await this.net.getListByPageForUserSys_PersonnelInfo({
                    currentPage: 1,
                    itemsPerPage: 100
                })
                
                let arr1 = [];
                _(res2.data).forEach(function(entity) {
                   let obj1 = {
                    "id": entity.id+"",
                    "name": entity.name+""
                   };
                   arr1 = _.concat(arr1, obj1);
                });
                // 获取项目经理数据
                this.projectManagers = arr1;
                // 获取项目人员数据
                // eslint-disable-next-line no-console
                console.log(arr1);
                this.personnels = arr1;

                //获取项目信息
                let res3 = await this.net.get_ProjectInfo({
                    id: this.$route.query.id
                })
                //通过项目类型查询阶段信息
                this.loadProjectStage(res3.entity.projecttype);
                this.form = res3.entity;
                this.form.stageForDir = res3.entity.stage;
                this.idCurr= res3.entity.id;
                this.personnelArr = _.split(res3.entity.personnel, '-');
                // eslint-disable-next-line no-console
                console.log(this.personnelArr);
                if(res3.entity.status != '11'){
                    // eslint-disable-next-line no-console
                    console.log('我进来了吧。。。。');
                    this.roles.status_show = false;
                }
            },
            //通过项目类型查询阶段信息
            loadProjectStage(currentValue){
                this.projectStageOptions = [];
                this.projectStageOptionsForForm = [];
                this.net.getListByPage_ProjectStageInfo({
                    currentPage: 1,
                    itemsPerPage: 100,
                    projecttype: currentValue
                }).then(res => {
                    this.projectStageOptions = res.data;
                    this.projectStageOptionsForForm = res.data;
                });
            },
            //保存
            onSubmit() {
                this.$refs['form'].validate((valid) => {
                    if (valid) {
                        this.form.personnel = _.join(this.personnelArr, '-');
                        this.net.update_ProjectInfo(this.form).then(res => {
                            if(res.success){
                                bus.$emit('editProject_Evt');
                                bus.$emit('close_current_tags');
                                this.$router.push({path:"/projectManagementSelect"});
                            } else {
                                this.$message.error('保存失败！');
                            }
                            
                        });
                    } else {
                        //this.$message.error('验证失败！');
                        return false;
                    }
                });
            },
            //取消
            onCancel(){
                bus.$emit('close_current_tags');
                this.$router.push({path:"/projectManagementSelect"});
            }
        }
    };
</script>

<style scoped>
</style>
