<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 查看项目
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <!-- <el-menu
            :default-active="activeIndex"
            class="el-menu-demo"
            mode="horizontal"
            @select="handleSelect"
            background-color="#EFEFEF"
            text-color="#9D9D9D"
            active-text-color="#74B4F8">
            <el-menu-item index="1"><i class="el-icon-menu"></i>项目基本信息</el-menu-item>
            <el-menu-item index="2"><i class="el-icon-user-solid"></i>项目人员信息</el-menu-item>
        </el-menu> -->
        <div class="container">
            <div class="content-title">{{contentTitle}}</div>
            <div class="form-box" >
                <el-form ref="form" :model="form" :rules="rules" label-width="80px">
                    <el-form-item label="项目名称" v-if="showBase" prop="projectname">
                        <el-input v-model="form.projectname" disabled></el-input>
                    </el-form-item>
                    <el-form-item label="项目编号" v-if="showBase">
                        <el-input v-model="form.projectno" disabled></el-input>
                    </el-form-item>
                    <el-form-item label="项目类型" v-if="showBase">
                        <el-select v-model="form.projecttype" disabled>
                            <el-option
                                v-for="item in projectTypeOptions"
                                :key="item.id"
                                :label="item.typename"
                                :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="项目阶段" v-if="showBase">
                        <el-select v-model="form.stage" disabled>
                            <el-option
                                v-for="item in projectStageOptions"
                                :key="item.projectstage"
                                :label="item.stagename"
                                :value="item.projectstage">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="项目时间" v-if="showBase">
                        <el-col :span="11">
                        <el-form-item prop="begindate">
                            <el-date-picker
                                disabled
                                type="date"
                                placeholder="选择开始日期"
                                v-model="form.begindate"
                                value-format="yyyy-MM-dd"
                                style="width: 100%;"
                            ></el-date-picker>
                        </el-form-item>
                        </el-col>
                        <el-col class="line" :span="2">-</el-col>
                        <el-col :span="11">
                        <el-form-item prop="enddate">
                            <el-date-picker
                                disabled
                                type="date"
                                placeholder="选择结束日期"
                                v-model="form.enddate"
                                value-format="yyyy-MM-dd"
                                style="width: 100%;"
                            ></el-date-picker>
                        </el-form-item>
                        </el-col>
                    </el-form-item>
                    <el-form-item label="项目经理" v-if="showPersonnel">
                        <el-select disabled v-model="form.projectmanager" placeholder="请选择">
                            <el-option
                                v-for="item in projectManagers"
                                :key="item.id"
                                :label="item.name"
                                :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="项目成员" v-if="showPersonnel">
                        <el-select disabled v-model="personnelArr" multiple placeholder="请选择">
                            <el-option
                                v-for="item in personnels"
                                :key="item.id"
                                :label="item.name"
                                :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-form>
            </div>
            <div class="content-title">项目目录信息</div>
            <el-tabs v-model="form.stage" tab-position="left" @tab-click="handleClick">
                <el-tab-pane
                    v-for="(item, index) in projectStageOptions"
                    :key="item.projectstage"
                    :label="item.stagename"
                    :name="item.projectstage"
                    :lazy=true
                    >
                    {{item.stagename}}
                    <v-project-dir-tree :index="index" :projectid="form.id" :projectStage="item.projectstage" :roles="roles" :isDisabled=true></v-project-dir-tree>
                </el-tab-pane>
            </el-tabs>
        </div>
    </div>
</template>

<script>
    import bus from "@/components/common/bus";
    import vProjectDirTree from '@/components/common/ProjectDirTree.vue';
    import { _ } from '@/utils';
    export default {
        name: 'projectManagementLookup',
        components: {
            vProjectDirTree
        },
        data() {
            return {
                roles: {
                    add_zdydir: false,//新增自定义目录
                    edit_zdydir: false,//编辑自定义目录
                },
                activeIndex:'1',
                isEdit: false,
                //内容标题
                contentTitle: "项目基本信息",
                //项目基本信息显示标识
                showBase: true,
                //项目人员信息显示标识
                showPersonnel: true,
                form: {
                    id: '',//项目ID
                    projectname: '',//项目名称
                    projectno: '',//项目编号
                    projecttype: '',//项目类型
                    stage: '',//项目阶段
                    begindate: '',//开始时间
                    enddate: '',//结束时间
                    projectmanager:'',//项目经理
                    personnel: '',//项目成员
                },
                personnelArr: [],//项目成员数组
                rules: {
                    projectname: [
                        { required: true, message: '请输入项目名称', trigger: 'blur' },
                        { min: 3, max: 15, message: '长度在 3 到 15 个字符', trigger: 'blur' }
                    ],
                    // projecttype: [
                    //     { required: true, message: '请选择项目类型', trigger: 'change' }
                    // ],
                    // stage: [
                    //     { type: 'date', required: true, message: '请选择日期', trigger: 'change' }
                    // ],
                    begindate: [
                        { required: true, message: '请选择开始时间', trigger: 'change' }
                    ],
                    enddate: [
                        { required: true, message: '请选择结束时间', trigger: 'change' }
                    ]
                },
                //项目经理集合
                projectManagers: [],
                //项目成员集合
                personnels: [],
                //项目类型选项集合
                projectTypeOptions: [],
                //项目阶段选项集合
                projectStageOptions: [],
            };
        },
        created() {
            this.getInitData();
        },
        methods: {
            // eslint-disable-next-line no-unused-vars
            handleClick(tab, event) {
                // console.log(tab, event);
                // eslint-disable-next-line no-console
                console.log(tab.index);
                bus.$emit('projectDirTree_load_'+tab.index);
            },
            //项目基本信息或项目人员信息切换
            // handleSelect(key, keyPath) {
            //     if(key[0] == "1"){
            //         this.showBase = true;
            //         this.showPersonnel = false;
            //         this.contentTitle = "项目基本信息";
            //     } else {
            //         this.showBase = false;
            //         this.showPersonnel = true;
            //         this.contentTitle = "项目人员信息";
            //     }
            // },
            // 获取项目信息
            getData(){
                
            },
            // 获取初始化数据
            async getInitData(){
                // 获取项目类型数据
                let res = await this.net.getListByPage_ProjectTypeInfo({
                    currentPage: 1,
                    itemsPerPage: 100
                })
                this.projectTypeOptions = res.data;

                let res2 = await this.net.getListByPageForUserSys_PersonnelInfo({
                    currentPage: 1,
                    itemsPerPage: 100
                })
                
                let arr1 = [];
                _(res2.data).forEach(function(entity) {
                   let obj1 = {
                    "id": entity.id+"",
                    "name": entity.name+""
                   };
                   arr1 = _.concat(arr1, obj1);
                });
                // 获取项目经理数据
                this.projectManagers = arr1;
                // 获取项目人员数据
                this.personnels = arr1;

                //获取项目信息
                let res3 = await this.net.get_ProjectInfo({
                    id: this.$route.query.id
                })
                //通过项目类型查询阶段信息
                this.loadProjectStage(res3.entity.projecttype);
                this.form = res3.entity;
                this.personnelArr = _.split(res3.entity.personnel, '-');
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
                });
            },
        }
    };
</script>

<style scoped>
</style>
