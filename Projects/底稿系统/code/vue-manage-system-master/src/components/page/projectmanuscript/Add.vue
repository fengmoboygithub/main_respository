<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 新增项目
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
                        <el-input v-model="form.projectname"></el-input>
                    </el-form-item>
                    <el-form-item label="项目编号" v-if="showBase" prop="projectno">
                        <el-input v-model="form.projectno"></el-input>
                    </el-form-item>
                    <el-form-item label="项目类型" v-if="showBase" prop="projecttype">
                        <el-select v-model="form.projecttype" @change="handleProjectTypeChange">
                            <el-option
                                v-for="item in projectTypeOptions"
                                :key="item.id"
                                :label="item.typename"
                                :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="项目阶段" v-if="showBase" prop="stage">
                        <el-select v-model="form.stage">
                            <el-option
                                v-for="item in projectStageOptions"
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
                        <el-select v-model="form.personnelArr" multiple placeholder="请选择">
                            <el-option
                                v-for="item in personnels"
                                :key="item.id"
                                :label="item.name"
                                :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" ref="optBtn" @click="onSubmit">保存</el-button>
                        <el-button @click="onCancel">取消</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </div>
    </div>
</template>

<script>
    import bus from "@/components/common/bus";
    import { _ } from '@/utils';
    export default {
        name: 'projectManagementAdd',
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
                        projectname: value
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
                        projectno: value
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
                activeIndex:'1',
                //内容标题
                contentTitle: "项目基本信息",
                //内容标题
                contentTitle1: "项目人员信息",
                //项目基本信息显示标识
                showBase: true,
                //项目人员信息显示标识
                showPersonnel: true,
                form: {
                    projectname: '',//项目名称
                    projectno: '',//项目编号
                    projecttype: '',//项目类型
                    stage: '',//项目阶段
                    begindate: '',//开始时间
                    enddate: '',//结束时间
                    projectmanager:'',//项目经理
                    personnel: '',//项目成员
                    personnelArr: [],//项目成员数组
                },
                rules: {
                    projectname: [
                        { required: true, validator: checkProjectName, trigger: 'blur' }
                    ],
                    projectno: [
                        { required: false, validator: checkProjectNo, trigger: 'blur' }
                    ],
                    projecttype: [
                        { required: true, message: '请选择项目类型', trigger: 'change' }
                    ],
                    stage: [
                        { required: true, message: '请选择项目阶段', trigger: 'change' }
                    ],
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
                //项目阶段选项集合
                projectStageOptions: [],
            };
        },
        created() {
            this.getInitData();
        },
        methods: {
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
            // 获取初始化数据
            getInitData(){
                // 获取项目类型数据
                this.net.getListByPage_ProjectTypeInfo({
                    currentPage: 1,
                    itemsPerPage: 100
                }).then(res => {
                    this.projectTypeOptions = res.data;
                });

                this.net.getListByPageForUserSys_PersonnelInfo({
                    currentPage: 1,
                    itemsPerPage: 100
                }).then(res => {
                    // 获取项目经理数据
                    this.projectManagers = res.data;
                    // 获取项目人员数据
                    this.personnels = res.data;
                });
            },
            //更改项目类型时触发操作
            handleProjectTypeChange(currentValue){
                this.projectStageOptions = [];
                this.form.stage = "";
                this.net.getListByMin_ProjectStageInfo({
                    projecttype: currentValue
                }).then(res => {
                    if(res.list.length > 0){
                        this.projectStageOptions = res.list;
                        this.form.stage = this.projectStageOptions[0].projectstage;
                    }
                });
            },
            // eslint-disable-next-line no-unused-vars
            handleBeginDateChange(currentValue){
                this.$refs['form'].validate();
            },
            // eslint-disable-next-line no-unused-vars
            handleEndDateChange(currentValue){
                this.$refs['form'].validate();
            },
            //保存
            onSubmit() {
                this.$refs['form'].validate((valid) => {
                    if (valid) {
                        this.form.personnel = _.join(this.form.personnelArr, '-');
                        let loadingInstance = this.$loading({
                            target: this.$refs['form'].$el,
                            background: "rgba(0, 0, 0, 0.8)",
                            spinner: "el-icon-loading",
                            text: "拼命加载中",
                        });
                        this.net.add_ProjectInfo(this.form).then(res => {
                            loadingInstance.close();
                            if(res.success){
                                bus.$emit('addProject_Evt');
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
