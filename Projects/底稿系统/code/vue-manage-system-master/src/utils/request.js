import axios from 'axios';
import router from '@/router';
import qs from "qs";
import configMe from "@/config";
// import authModuels from '../store/modules/authModules';
//配置全局的axios默认值（可选）
//axios.defaults.headers.common['Authorization'] = AUTH_TOKEN;
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
//axios.defaults.baseURL = 'http://localhost:8091/api/';
//axios.defaults.timeout = 5000;
const service = axios.create({
    // process.env.NODE_ENV === 'development' 来判断是否开发环境
    // easy-mock服务挂了，暂时不使用了
    // baseURL: 'https://www.easy-mock.com/mock/592501a391470c0ac1fab128',
	baseURL: configMe.API_BASEURL,
    timeout: configMe.API_TIMEOUT
});
//service.defaults.headers.common['userId'] = `${sessionStorage.getItem("userId")}`;
// 拦截器配置，在请求或响应被 then 或 catch 处理前拦截它们。
// 添加请求拦截器
service.interceptors.request.use(
    config => {
        // 认证token信息添加
        // if (localStorage.getItem('Authorization')) {
        //     config.headers.Authorization = localStorage.getItem('Authorization');
        // }
        // 参数格式转换
        if(config.method=="post"||config.method=="put"){
            // ********************************************************
            // 序列化 导入文件无须序列化 以下为示例          *
            // let data = qs.stringify({                              *
            //     "username":'123',                                  *
            //     "password":'456'                                   *
            // });                                                    *
            // 其序列化后变成 username=123&password=456                  *
            // *********************************************************
            if (!/^.*(upload)$/.test(config.url)) {
                config.data = qs.stringify(config.data);
            }
        }
        // 新增和修改方法修改下请求头
        if (/^.*(add|update|updateProcess|reCallForAll|reCallForPart|saveGraphInfo)$/i.test(config.url)) {
            config.data = qs.parse(config.data);
            config.headers.post['Content-Type'] = 'application/json; charset=UTF-8';
        }
        config.headers.common['userId'] = `${sessionStorage.getItem("userId")}`;
        config.headers.common['userName'] = encodeURIComponent(`${sessionStorage.getItem("userName")}`);
        config.headers.common['rolelist'] = `${sessionStorage.getItem("rolelist")}`;
        return config;
    },
    error => {
        // 对请求错误做些什么
        // eslint-disable-next-line no-console
        console.log(error);
        return Promise.reject();
    }
);
// 添加响应拦截器
service.interceptors.response.use(
    // 对响应数据做点什么
    response => {
        if (response.status === 200) {
            return response.data;
        } else {
            if (response.status === 404) {
                // 自定义404页面
                router.replace({
                    path: '/404'
                });
            } else if(response.status === 401) {
                //状态码为401，就清除token信息并跳转到登录页面
                // localStorage.removeItem('Authorization');
                router.replace({
                    path: '/login'
                });
            }
            Promise.reject();
        }
    },
    // 对响应错误做点什么
    error => {
        // eslint-disable-next-line no-console
        console.log(error);
        if (error.response.status === 404) {
            // 自定义404页面
            router.replace({
                path: '/404'
            });
        } else if(error.response.status === 401) {
            //状态码为401，就清除token信息并跳转到登录页面
            //localStorage.removeItem('Authorization');
            router.replace({
                path: '/login'
            });
        }
        return Promise.reject('请求异常：' + error.message);
    }
);

export default service;
