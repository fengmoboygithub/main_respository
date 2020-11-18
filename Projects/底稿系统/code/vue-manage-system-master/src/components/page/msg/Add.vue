<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 新增消息
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="content-title">消息信息</div>
            <div class="form-box" >
                <el-form ref="form" :model="form" :rules="rules" label-width="80px">
                    <el-form-item label="消息类型" prop="mgtype">
                        <el-select v-model="form.mgtype" placeholder="消息类型">
                            <el-option
                                v-for="item in mgtypeOptions"
                                :key="item.code"
                                :label="item.label"
                                :value="item.code">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="消息内容" prop="mgcontent">
                        <el-input 
                            type="textarea"
                            :rows="10"
                            placeholder="请输入消息内容"
                            v-model="form.mgcontent">
                            </el-input>
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
        name: 'msgManagementAdd',
        data() {
            var checkMgContent = (rule, value, callback) => {
                if (!value) {
                    return callback(new Error('请输入消息内容'));
                }
                var len = value.length;
                var len_flag = false;
                if (len<3) {
                    len_flag = true;
                } else if(len>150){
                    len_flag = true;
                }
                if(len_flag){
                    callback(new Error('长度在 3 到 150 个字符'));
                } else {
                    callback();
                }
                
            };
            return {
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
                form: {
                    mgtype: '',//消息类型
                    mgcontent: '',//消息内容
                },
                rules: {
                    mgtype: [
                        { required: true, message: '请选择消息类型', trigger: 'change' }
                    ],
                    mgcontent: [
                        { required: true, validator: checkMgContent, trigger: 'blur' }
                    ],
                },
            };
        },
        created() {
            
        },
        methods: {
            //保存
            onSubmit() {
                this.$refs['form'].validate((valid) => {
                    if (valid) {
                        this.net.add_MessageCenter(this.form).then(res => {
                            if(res.success){
                                bus.$emit('addMsg_Evt');
                                bus.$emit('close_current_tags');
                                this.$router.push({path:"/msgManagementSelect"});
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
                this.$router.push({path:"/msgManagementSelect"});
            }
        }
    };
</script>

<style scoped>
</style>
