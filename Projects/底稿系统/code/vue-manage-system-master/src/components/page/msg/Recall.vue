<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 撤回消息
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="content-title">撤回信息</div>
            <div class="form-box" >
                <el-form ref="form" :model="form" :rules="rules" label-width="80px">
                    <el-form-item label="选择消息" prop="mgid">
                        <el-select v-model="form.mgid" style="width: 680px" placeholder="请选择" @change="handlemgidChange">
                            <el-option
                                v-for="item in mgidOptions"
                                :key="item.code"
                                :label="item.label"
                                :value="item.code">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="选择用户" prop="userList">
                        <el-select v-model="form.userList" style="width: 680px" multiple collapse-tags placeholder="请选择">
                            <el-option
                                v-for="item in userListOptions"
                                :key="item.code"
                                :label="item.label"
                                :value="item.code">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="onSubmit">全部撤回</el-button>
                        <el-button type="primary" @click="onSubmitForPart">部分撤回</el-button>
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
        name: 'msgManagementRecall',
        data() {
            return {
                mgidOptions: [],//消息列表
                userListOptions: [],//用户列表
                form: {
                    mgid: '',//消息信息
                    userList: [],//用户信息
                },
                rules: {
                    mgid: [
                        { required: true, message: '请选择消息', trigger: 'change' }
                    ],
                    userList: [
                        { required: true, message: '请选择用户', trigger: 'change' }
                    ],
                },
            };
        },
        created() {
            this.getInitData();
        },
        methods: {
            // 获取发布消息列表数据与用户列表数据
            getInitData(){
                //获取发布消息列表数据
                this.net.getList_MessageCenter({
                    mgstate: '2'
                }).then(res => {
                    let _mgidOptions = [];
                    _(res.list).forEach(function(value) {
                        let _value = {};
                        _value.code=value.id;
                        _value.label=value.mgcontent;
                        _mgidOptions.push(_value);
                    });
                    this.mgidOptions = _mgidOptions;
                });
            },
            //更改选择消息时触发操作
            handlemgidChange(currentValue){
                //根据消息ID查询用户列表
                this.net.getUserListByMgId_UserMessageRela({
                    mgId: currentValue
                }).then(res => {
                    let _userListOptions = [];
                    let _userList = [];
                    _(res.list).forEach(function(value) {
                        let _value = {};
                        _value.code=value.userid;
                        _value.label=value.username;
                        _userListOptions.push(_value);
                        _userList.push(value.userid);
                    });
                    this.userListOptions = _userListOptions;
                    this.form.userList = _userList;
                });
            },
            //全部撤回
            onSubmit() {
                this.rules.userList = [
                    { required: false, message: '请选择用户', trigger: 'change' }
                ];
                this.$refs['form'].validate((valid) => {
                    if (valid) {
                        this.net.reCallForAll_UserMessageRela(this.form).then(res => {
                            if(res.success){
                                bus.$emit('recallMsg_Evt');
                                bus.$emit('close_current_tags');
                                this.$router.push({path:"/msgManagementSelect"});
                            } else {
                                this.$message.error('全部撤回失败！');
                            }
                            
                        });
                    } else {
                        // this.$message.error('验证失败！');
                        return false;
                    }
                });
            },
            //部分撤回
            onSubmitForPart() {
                this.rules.userList = [
                    { required: true, message: '请选择用户', trigger: 'change' }
                ];
                this.$refs['form'].validate((valid) => {
                    if (valid) {
                        this.net.reCallForPart_UserMessageRela(this.form).then(res => {
                            if(res.success){
                                bus.$emit('recallMsg_Evt');
                                bus.$emit('close_current_tags');
                                this.$router.push({path:"/msgManagementSelect"});
                            } else {
                                this.$message.error('部分撤回失败！');
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
