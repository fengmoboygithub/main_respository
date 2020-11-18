<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 编辑项目阶段
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="content-title">项目阶段信息</div>
            <div class="form-box" >
                <el-form ref="form" :model="form" :rules="rules" label-width="80px">
                    <el-form-item label="项目类型" prop="projecttype">
                        <el-select v-model="form.projecttype">
                            <el-option
                                v-for="item in projectTypeOptions"
                                :key="item.id"
                                :label="item.typename"
                                :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="阶段值" prop="projectstage">
                        <el-input v-model="form.projectstage"></el-input>
                    </el-form-item>
                    <el-form-item label="阶段名称" prop="stagename">
                        <el-input v-model="form.stagename"></el-input>
                    </el-form-item>
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
    export default {
        name: 'projectStageManagementUpdate',
        data() {
            let that = this;
            var checkStage = (rule, value, callback) => {
                if (!value) {
                    return callback(new Error('请输入阶段值'));
                }
                var regPos = /^[1-9]\d*$/; // 正整数
                if(!regPos.test(value)){
                    callback(new Error('请输入正整数值'));
                } else {
                    value = parseInt(value);
                    if (value < 100) {
                        callback(new Error('必须大于等于100'));
                    } else {
                        this.net.getStageIdForOnly_ProjectStageInfo({
                            projectstage: value,
                            projecttype: that.form.projecttype,
                            idCurr: that.idCurr
                        }).then(res => {
                            if(res.entity){
                                callback(new Error('该项目类型下阶段值已存在，请重新输入！'));
                            } else {
                                callback();
                            }
                        // eslint-disable-next-line no-unused-vars
                        }).catch((e)=>{
                            callback(new Error('请求错误，验证失败！'));
                        });
                    }
                }
            };
            var checkStageName = (rule, value, callback) => {
                if (!value) {
                    return callback(new Error('请输入项目阶段名称'));
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
                        stagename: value,
                        projecttype: that.form.projecttype,
                        idCurr: that.idCurr
                    };
                    this.net.getStageNameForOnly_ProjectStageInfo(params).then(res => {
                        if(res.entity){
                            callback(new Error('项目阶段名称已存在，请重新输入！'));
                        } else {
                            callback();
                        }
                    // eslint-disable-next-line no-unused-vars
                    }).catch((e)=>{
                        callback(new Error('请求错误，验证失败！'));
                    });
                }
            };
            return {
                form: {
                    projecttype: '',//项目类型
                    projectstage: '',//项目阶段
                    stagename: '',//项目阶段名称
                },
                rules: {
                    projecttype: [
                        { required: true, message: '请选择项目类型', trigger: 'change' }
                    ],
                    projectstage: [
                        { required: true, validator: checkStage, trigger: 'blur' }
                    ],
                    stagename: [
                        { required: true, validator: checkStageName, trigger: 'blur' }
                    ],
                },
                //项目类型选项集合
                projectTypeOptions: [],
            };
        },
        created() {
            this.getInitData();
            this.getData();
        },
        methods: {
            // 获取项目阶段信息
            getData(){
                this.net.get_ProjectStageInfo({
                    id: this.$route.query.id
                }).then(res => {
                    this.form = res.entity;
                    this.idCurr= res.entity.id;
                });
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
            //保存
            onSubmit() {
                this.$refs['form'].validate((valid) => {
                    if (valid) {
                        this.net.update_ProjectStageInfo(this.form).then(res => {
                            if(res.success){
                                bus.$emit('editProjectStage_Evt');
                                bus.$emit('close_current_tags');
                                this.$router.push({path:"/projectStageManagementSelect"});
                            } else {
                                this.$message.error('保存失败！');
                            }
                            
                        });
                    } else {
                        // this.$message.error('验证失败！');
                        return false;
                    }
                });
            },
            //取消
            onCancel(){
                bus.$emit('close_current_tags');
                this.$router.push({path:"/projectStageManagementSelect"});
            }
        }
    };
</script>

<style scoped>
</style>
