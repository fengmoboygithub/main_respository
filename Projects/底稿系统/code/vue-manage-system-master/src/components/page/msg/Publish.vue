<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 发布消息
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="content-title">发布信息</div>
            <div class="form-box" >
                <el-form ref="form" :model="form" :rules="rules" label-width="80px">
                    <el-form-item label="选择消息" prop="mgList">
                        <el-select v-model="form.mgList" style="width: 680px" multiple collapse-tags placeholder="请选择">
                            <el-option
                                v-for="item in mgListOptions"
                                :key="item.code"
                                :label="item.label"
                                :value="item.code">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="选择用户" prop="userMapList">
                        <el-select v-model="form.userMapList" style="width: 680px" multiple collapse-tags placeholder="请选择">
                            <el-option
                                v-for="item in userMapListOptions"
                                :key="item.code"
                                :label="item.label"
                                :value="item.code">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="onSubmit">发布</el-button>
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
        name: 'msgManagementPublish',
        data() {
            return {
                mgListOptions: [],//消息列表
                userMapListOptions: [],//用户列表
                form: {
                    mgList: [],//消息信息
                    userMapList: [],//用户信息
                },
                rules: {
                    mgList: [
                        { required: true, message: '请选择消息', trigger: 'change' }
                    ],
                    userMapList: [
                        { required: true, message: '请选择用户', trigger: 'change' }
                    ],
                },
            };
        },
        created() {
            this.getInitData();
        },
        methods: {
            // 获取草稿消息列表数据与用户列表数据
            getInitData(){
                //获取草稿消息列表数据
                this.net.getList_MessageCenter({
                    mgstate: '1'
                }).then(res => {
                    let _mgListOptions = [];
                    _(res.list).forEach(function(value) {
                        let _value = {};
                        _value.code=value.id;
                        _value.label=value.mgcontent;
                        _mgListOptions.push(_value);
                    });
                    this.mgListOptions = _mgListOptions;
                });
                //获取用户列表数据
                this.net.getListByPageForUserSys_PersonnelInfo({
                    currentPage: 1,
                    itemsPerPage: 100
                }).then(res => {
                    let _userMapListOptions = [];
                    _(res.data).forEach(function(value) {
                        let _value = {};
                        _value.code=value.id;
                        _value.label=value.name;
                        _userMapListOptions.push(_value);
                    });
                    this.userMapListOptions = _userMapListOptions;
                });
            },
            //发布
            onSubmit() {
                this.$refs['form'].validate((valid) => {
                    if (valid) {
                        //全部用户列表[ {code:'xxxx',label:'xxxxxx'}, {code:'zzzz',label:'yyyyyyyy'}]
                        let _userMapListAll = this.userMapListOptions;
                        //所选择的用户列表['xxxx','zzzz']
                        let _userMapList = this.form.userMapList;
                        let _arrList = [];
                        _(_userMapList).forEach(function(value) {
                            let userMap = _.find(_userMapListAll, function(o) { 
                                return o.code == value; 
                            });
                            _arrList.push(userMap);
                        });
                        this.form.userMapList = _arrList;
                        this.net.add_UserMessageRela(this.form).then(res => {
                            if(res.success){
                                bus.$emit('publishMsg_Evt');
                                bus.$emit('close_current_tags');
                                this.$router.push({path:"/msgManagementSelect"});
                            } else {
                                this.$message.error('发布失败！');
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
