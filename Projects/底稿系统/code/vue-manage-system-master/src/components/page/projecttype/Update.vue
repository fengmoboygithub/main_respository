<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 编辑项目类型
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="content-title">项目类型信息</div>
            <div class="form-box" >
                <el-form ref="form" :model="form" :rules="rules" label-width="80px">
                    <el-form-item label="名称" prop="typename">
                        <el-input v-model="form.typename"></el-input>
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
        name: 'projectManagementUpdate',
        data() {
            let that = this;
            var checkTypename = (rule, value, callback) => {
                if (!value) {
                    return callback(new Error('请输入项目类型名称'));
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
                    this.net.getTypeNameForOnly_ProjectTypeInfo({
                        typename: value,
                        id: that.form.id
                    }).then(res => {
                        if(res.entity){
                            callback(new Error('项目类型名称已存在，请重新输入！'));
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
                    typename: '',//项目类型名称
                },
                rules: {
                    typename: [
                        { validator: checkTypename, trigger: 'blur' }
                    ],
                },
            };
        },
        created() {
            this.getData();
        },
        methods: {
            // 获取项目类型信息
            getData(){
                this.net.get_ProjectTypeInfo({
                    id: this.$route.query.id
                }).then(res => {
                    this.form = res.entity;
                });
            },
            //保存
            onSubmit() {
                this.$refs['form'].validate((valid) => {
                    if (valid) {
                        this.net.update_ProjectTypeInfo(this.form).then(res => {
                            if(res.success){
                                bus.$emit('editProjectType_Evt');
                                bus.$emit('close_current_tags');
                                this.$router.push({path:"/projectTypeManagementSelect"});
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
                this.$router.push({path:"/projectTypeManagementSelect"});
            }
        }
    };
</script>

<style scoped>
</style>
