import Vue from 'vue';
import App from './App.vue';
import router from './router';
import net from './api';
import auth from './auth';
import ElementUI from 'element-ui';
import VueI18n from 'vue-i18n';
import { messages } from './components/common/i18n';
//import 'element-ui/lib/theme-chalk/index.css'; // 默认主题
//import './assets/css/theme-green/index.css'; // 浅绿色主题
import './assets/css/theme-blue/index.css'; // 浅蓝色主题
import './assets/css/icon.css';
import './assets/css/manuscripticon.css';
import './components/common/directives';
import store from './store';
import 'babel-polyfill';
//引入视频插件
import VideoPlayer from 'vue-video-player';
import 'vue-video-player/src/custom-theme.css';
import 'video.js/dist/video-js.css';
//引入音频插件
import vueAplayer from 'vue-aplayer';
//引入右键菜单插件
import contentmenu from 'v-contextmenu'
import 'v-contextmenu/dist/index.css'

//使用视频插件
Vue.use(VideoPlayer);
//使用音频插件
Vue.use(vueAplayer);
//使用右键菜单插件
Vue.use(contentmenu);
 
// const originalPush = router.prototype.push
// router.prototype.push = function push(location) {
//    return originalPush.call(this, location).catch(err => err)
// }


Vue.config.productionTip = false;
Vue.use(VueI18n);
Vue.use(ElementUI, {
    size: 'medium'
});
//将axios-api挂载到原型net上
Vue.prototype.net = net;
//将axios-认证相关的接口挂载到原型net上
Vue.prototype.auth = auth;
const i18n = new VueI18n({
    locale: 'zh',
    messages
});

//使用钩子函数对路由进行权限跳转
router.beforeEach((to, from, next) => {
    document.title = `${to.meta.title} | manuscript-manage-system`;
    const username = sessionStorage.getItem('userName');
    if (!username && to.path !== '/login' && to.path !== '/processDesignerPage') {
        next('/login');
    } else {
        // 简单的判断IE10及以下不进入富文本编辑器，该组件不兼容
        if (navigator.userAgent.indexOf('MSIE') > -1 && to.path === '/editor') {
            Vue.prototype.$alert('vue-quill-editor组件不兼容IE10及以下浏览器，请使用更高版本的浏览器查看', '浏览器不兼容通知', {
                confirmButtonText: '确定'
            });
        } else {
            next();
        }
    }
    // let token = localStorage.getItem('Authorization');
    // if ((token === 'null' || token === '') && to.path !== '/login') {
    //     next('/login');
    // } else {
    //     // 简单的判断IE10及以下不进入富文本编辑器，该组件不兼容
    //     if (navigator.userAgent.indexOf('MSIE') > -1 && to.path === '/editor') {
    //         Vue.prototype.$alert('vue-quill-editor组件不兼容IE10及以下浏览器，请使用更高版本的浏览器查看', '浏览器不兼容通知', {
    //             confirmButtonText: '确定'
    //         });
    //     } else {
    //         next();
    //     }
    // }
});

new Vue({
    router,
    i18n,
    //使用vuex
    store: store,
    render: h => h(App)
}).$mount('#app');
