<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 基础目录管理
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="content-title">选择项目类型</div>
            <div class="form-box" >
                <el-form ref="form" :model="form" label-width="80px">
                    <el-form-item label="项目类型">
                        <el-select v-model="form.projecttype" @change="handleProjectTypeChange">
                            <el-option
                                v-for="item in projectTypeOptions"
                                :key="item.id"
                                :label="item.typename"
                                :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-form>
            </div>
            <div class="content-title">基础目录信息</div>
            <!--@tab-click="handleClick"-->
            <el-tabs v-model="form.stage" tab-position="left" >
                <el-tab-pane
                    v-for="(item, index) in projectStageOptions"
                    :key="item.projectstage"
                    :label="item.stagename"
                    :name="item.projectstage"
                    :lazy=true
                    >
                    {{item.stagename}}
                    <v-base-dir-tree :index="index" :projecttype="form.projecttype" :projectStage="item.projectstage" :roles="roles"></v-base-dir-tree>
                </el-tab-pane>
            </el-tabs>
        </div>
    </div>
</template>

<script>
    import vBaseDirTree from '@/components/common/BaseDirTree.vue';
    import { _ } from '@/utils';
    export default {
        name: 'baseDirManagementSelect',
        components: {
            vBaseDirTree
        },
        data() {
            return {
                roles: {
                    add_base_dir: false,//新增基础目录
                    edit_base_dir: false,//编辑基础目录
                    del_base_dir: false,//删除基础目录
                },
                form: {
                    projecttype: '',//项目类型
                    stage: '',//项目阶段
                },
                //项目类型选项集合
                projectTypeOptions: [],
                //项目阶段选项集合
                projectStageOptions: [],
            };
        },
        created() {
            this.initAuth();
            this.initRoles();
            this.getInitData();
        },
        methods: {
            // 初始化菜单权限
            initAuth(){
                // 获取当前用户下所有的按钮权限集
                let vuex = JSON.parse(window.sessionStorage.vuex);
                let buttonsAll = vuex.buttonsAll;
                this.menulist = buttonsAll;
            },
            hasAuth(perms){
                let obj = _.find(this.menulist,function(data) {
                    return data.perms === perms
                });
                return !!obj
            },
            initRoles(){
                this.roles = {
                    add_base_dir: this.hasAuth('add_base_dir'),//新增基础目录
                    edit_base_dir: this.hasAuth('edit_base_dir'),//编辑基础目录
                    del_base_dir: this.hasAuth('del_base_dir'),//删除基础目录
                };
            },
            //
            // handleClick(tab, event) {
            //     // console.log(tab, event);
            //     // console.log(tab.index);
            //     //bus.$emit('baseDirTree_load_'+tab.index);
            // },
            // 获取项目类型数据
            getInitData(){
                this.net.getListByPage_ProjectTypeInfo({
                    currentPage: 1,
                    itemsPerPage: 100
                }).then(res => {
                    this.projectTypeOptions = res.data;
                });
            },
            //更改项目类型时触发操作
            handleProjectTypeChange(currentValue){
                this.loadProjectStage(currentValue);
            },
            //通过项目类型查询阶段信息
            loadProjectStage(currentValue){
                this.projectStageOptions = [];
                this.net.getListByPage_ProjectStageInfo({
                    currentPage: 1,
                    itemsPerPage: 100,
                    projecttype: currentValue
                }).then(res => {
                    this.projectStageOptions = res.data;
                    this.net.getListByMin_ProjectStageInfo({
                        projecttype: currentValue
                    }).then(res => {
                        if(res.list[0]){
                            this.form.stage = res.list[0].projectstage;
                        }
                    });
                });
            },
        }
    };
</script>

<style scoped>
</style>
