<template>
    <div class="sidebar">
        <el-menu
            class="sidebar-el-menu"
            :default-active="onRoutes"
            :collapse="collapse"
            :background-color="theme.SIDEBAR_BACKGROUND_COLOR"
            :text-color="theme.SIDEBAR_TEXT_COLOR"
            unique-opened
            router
            @select="handleSelect"
        >
            <template v-for="item in items">
                <template v-if="item.children">
                    <el-submenu :index="item.url" :key="item.menuId" v-show="item.visible">
                        <template slot="title">
                            <i :class="item.icon"></i>
                            <span slot="title">{{ item.menuName }}</span>
                        </template>
                        <template v-for="subItem in item.children">
                            <el-submenu
                                v-show="item.visible"
                                v-if="subItem.children[0] && subItem.children.length !== 0"
                                :index="subItem.url"
                                :key="subItem.menuId"
                            >
                                <template slot="title">{{ subItem.menuName }}</template>
                                <el-menu-item
                                    v-show="item.visible"
                                    v-for="(threeItem,i) in subItem.children"
                                    :key="i"
                                    :index="threeItem.url"
                                >1{{ threeItem.menuName}}</el-menu-item>
                            </el-submenu>
                            <el-menu-item
                                v-else
                                v-show="item.visible"
                                @click="handleClick(subItem.menuId)"
                                :index="subItem.url"
                                :key="subItem.menuId"
                            >{{ subItem.menuName }}</el-menu-item>
                        </template>
                    </el-submenu>
                </template>
                <template v-else>
                    <el-menu-item v-show="item.visible" :index="item.url" :key="item.menuId" @click="handleClick(item.menuId)">
                        <i :class="item.icon"></i>
                        <span slot="title">{{ item.menuName }}</span>
                    </el-menu-item>
                </template>
            </template>
        </el-menu>
    </div>
</template>

<script>
import bus from "@/components/common/bus";
import { _ } from '@/utils';
import config from "@/config";
export default {
    data() {
        return {
            //侧边栏主题选择
            theme: config.THEME.BLUE,
            collapse: false,
            items: [
                {
                    icon: 'el-icon-lx-home',
                    index: 'dashboard',
                    title: '系统首页'
                },
                {
                    icon: 'el-icon-lx-calendar',
                    index: '9',
                    title: '底稿管理',
                    subs: [
                        {
                            icon: 'el-icon-lx-redpacket_fill',
                            index: '/projectManagementSelect',
                            title: '项目底稿管理'
                        },
                        {
                            icon: 'el-icon-lx-redpacket_fill',
                            index: '/projectTypeManagementSelect',
                            title: '项目类型管理'
                        },
                        {
                            icon: 'el-icon-lx-redpacket_fill',
                            index: '/projectStageManagementSelect',
                            title: '项目阶段管理'
                        },
                        {
                            icon: 'el-icon-lx-redpacket_fill',
                            index: '/baseDirManagementSelect',
                            title: '基础目录管理'
                        },
                        {
                            icon: 'el-icon-lx-redpacket_fill',
                            index: '/esManagementSelect',
                            title: '底稿文件检索'
                        },
                    ]
                },
            ]
        };
    },
    computed: {
        onRoutes() {
            return this.$route.path.replace('/', '');
        }
    },
    created() {
        // console.log(this.theme);
        // 通过 Event Bus 进行组件间通信，来折叠侧边栏
        bus.$on('collapse', msg => {
            this.collapse = msg;
            bus.$emit('collapse-content', msg);
        });
        this.getSidebar();
    },
    methods: {
        filterSidebar(item){
            // 过滤权限菜单，将按钮级别权限删除
            // 未处理重复的权限
            let that = this;
            _(item).forEach(function(data) {

                if(data.children.length !== 0){
                    that.filterSidebar(data.children);
                }
                if(data.menuType === 'C'){
                    data.children = {};
                } else if(data.menuType === 'F'){
                    that.$store.dispatch("authModuels/saveButtonsAll", [data]);
                }
            })
            return item;

        },
        // 动态获取后台侧边栏菜单
        async getSidebar() {
            let that = this;
            let userId = sessionStorage.getItem("userId");
            let userdata = await this.net.user_selectUserById({userId});
            let rolelist = userdata.roleIds;
            // rolelist是权限集合，针对多菜单权限的交集合并操作
            if ( !rolelist || rolelist.length === 0 ){
                this.$message.error("当前用户未分配任何权限，请联系管理员");
                return
            }
            //将角色ID集合转化为-拼接的角色字符串
            let rolelistStr = _.join(rolelist, ',');
            sessionStorage.setItem("rolelist", rolelistStr);
            // 循环调接口 来取权限并集             **过于频繁调接口，期望后台根据数组返回接口并集
            let authlist = [];
            for (let i = 0;i<rolelist.length; i++){
                let res = await that.net.menu_selectMenusByRole({roleId: rolelist[i]});
                authlist = _.defaultsDeep(res.data, authlist)
            } 
            this.items = that.filterSidebar(authlist);
            // eslint-disable-next-line no-console
            console.log("按钮权限集：",this.$store.state.authModuels.buttonsAll);

        },
        handleClick(menuId){
            this.$store.commit("authModuels/SAVEMENUID", menuId);
        },
        handleSelect(index,indexPath){
            // eslint-disable-next-line no-console
            console.log(index, indexPath);
        }
    }
};
</script>

<style scoped>
.sidebar {
    display: block;
    position: absolute;
    left: 0;
    top: 70px;
    bottom: 0;
    overflow-y: scroll;
}
.sidebar::-webkit-scrollbar {
    width: 0;
}
.sidebar-el-menu:not(.el-menu--collapse) {
    width: 250px;
}
.sidebar > ul {
    height: 100%;
}
</style>
