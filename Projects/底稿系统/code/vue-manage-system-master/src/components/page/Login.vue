<template>
    <div class="login-wrap">
        <div class="ms-login">
            <el-form :model="param" :rules="rules" ref="login" label-width="0px" class="ms-content">
                <el-form-item prop="username" class="form-item-me">
                    <el-input v-model="param.username" placeholder="账号" class="form-item-input-me">
                        <el-button slot="prepend" icon="el-icon-lx-people" class="login-icon-i"></el-button>
                    </el-input>
                </el-form-item>
                <el-form-item prop="password" class="form-item-me">
                    <el-input
                        type="password"
                        placeholder="密码"
                        show-password
                        v-model="param.password"
                        class="form-item-input-me"
                        @keyup.enter.native="submitForm()"
                    >
                        <el-button slot="prepend" icon="el-icon-lx-lock" class="login-icon-i"></el-button>
                    </el-input>
                </el-form-item>
                <div class="login-btn">
                    <el-button type="primary" round @click="submitForm()">登录</el-button>
                </div>
            </el-form>
        </div>
    </div>
</template>

<script>
import { mapMutations } from 'vuex';

export default {
    data: function() {
        return {
            param: {
                username: 'admin1',
                password: 'AAAbbb111',
            },
            rules: {
                username: [{ required: true, message: '请输入用户名', trigger: 'blur' }],
                password: [{ required: true, message: '请输入密码', trigger: 'blur' }],
            },
        };
    },
    methods: {
        ...mapMutations(['changeLogin']),
        submitForm() {
            this.$refs.login.validate(valid => {
                if (valid) {
                    sessionStorage.setItem("userName", "admin");
                    sessionStorage.setItem("userId", "admin");
                    this.$router.push('/');
                    this.$message.success('登录成功');

                    // this.net.login_getUser(this.param).then(res => {
                    //     if (res.success){
                    //         let {entity} = res;
                    //         const userinfo = JSON.parse(entity);
                    //         if (userinfo.status === '1'){
                    //             this.$message.error("用户已被禁用，请联系管理员");
                    //             return;
                    //         }
                    //         sessionStorage.setItem("userName", userinfo.userName);
                    //         sessionStorage.setItem("userId", userinfo.userId);
                    //         //this.$store.dispatch("authModuels/addUserid", userinfo.userId)
                    //         this.$router.push('/');
                    //         this.$message.success('登录成功');
                    //     } else {
                    //         this.$message.warning("用户名或密码错误！")
                    //     }
                    //     // _this.userToken = 'Bearer ' + res.token;
                    //     // 将用户token保存到vuex中
                    //     // _this.changeLogin({ Authorization: _this.userToken });

                    // // eslint-disable-next-line no-unused-vars
                    // }).catch(error => {
                    //     this.$message.error('账号或密码错误');
                    // });
                } else {
                    this.$message.error('请输入账号和密码');
                    return false;
                }
            });
        },
    },
};
</script>

