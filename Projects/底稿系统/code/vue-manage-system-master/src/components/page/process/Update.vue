<template>
    <div id="app">
        <div class="container" style="width: 100%;height: 100%">
            <el-row type="flex">
                <el-col :span="8">
                    <div class="root">
                        <div class="crumbs">
                            <el-breadcrumb separator="/">
                                <el-breadcrumb-item>
                                    <i class="el-icon-s-operation"></i> 阶段信息
                                </el-breadcrumb-item>
                            </el-breadcrumb>
                        </div>
                        <!-- 展示阶段信息 -->
                        <el-card style="width: 100%" v-for="(item, index) in items" :key="index"  shadow="hover">
                            {{item.stagename}}
                            <el-button style="float: right" @click="handleClick(item)"
                                       :type="item.id === selectId1?'danger':'primary'"
                                       :icon="item.id === selectId1?'el-icon-caret-right':'el-icon-more'" circle></el-button>

                        </el-card>
                    </div>
                </el-col>
                <el-col :span="16">
                       <div class="crumbs">
                            <el-breadcrumb separator="/">
                                <el-breadcrumb-item>
                                    <i class="el-icon-s-operation"></i> <span style="color: blue;">{{selectName}}</span>流程设计
                                </el-breadcrumb-item>
                            </el-breadcrumb>
                        </div>
                        <p>
                            说明：<br>
                            1、点击设计按钮，进入流程图设计器。<br>
                            2、通过流程图设计器完成流程信息更改。<br>
                            2、可直接拖拽流程节点及节点上连线完成编辑。<br>
                            3、点击保存按钮，保存流程信息。
                        </p>
                        <el-button v-if="selectId1" type="warning" round icon="el-icon-edit" @click="toProcessDesignerDialog">设计</el-button>
                </el-col>
            </el-row>
        </div>

        <el-dialog
            title="流程图设计器"
            :visible.sync="dialogVisible"
            :fullscreen=true
            :before-close="handleClose">
             <G6Editor mode="edit" :projectType="projecttype" :projectStage="projectstage" :graphData="graphData"></G6Editor>
        </el-dialog>
    </div>
</template>

<script>
    import eventBus from "@/components/common/bus";
    import G6Editor from '@/components/ProcessDesign/G6Editor';
    export default {
        name: 'processManagementUpdate',
        components:{G6Editor},
        data() {
            return {
                dialogVisible: false,
                dynamicValidateForm: {
                    domains: [{
                        value: ''
                    }]
                },
                //图像信息
                graphData: {},
                //阶段信息
                items: [],
                selectId1: '',              // 当前阶段ID
                selectName: '',             // 当前阶段name
                projecttype: '',            // 当前阶段项目类型
                projectstage: '',            // 当前项目阶段标记
            };
        },
        created(){
            //初始化数据
            this.initData();
            //监听自定义事件
            this.bindEvent();
        },
        methods: {
            //对话框关闭触发回调函数
            handleClose(done) {
                this.$confirm('确认关闭？')
                    // eslint-disable-next-line no-unused-vars
                    .then(_ => {
                        done();
                    })
                    // eslint-disable-next-line no-unused-vars
                    .catch(_ => {});
            },
            //监听自定义事件
            bindEvent(){
                let self = this;
                //设计器里保存按钮后响应的回调函数
                eventBus.$on("getGraphInfo", item => {
                    if( item && item.graph ){
                        // eslint-disable-next-line no-console
                        console.log(JSON.stringify(item.graph));
                    }
                    //关闭对话框
                    self.dialogVisible = false;
                    //保存流程图像数据
                    self.net.ProcessInfo_saveGraphInfo({
                        projecttype: self.projecttype, 
                        projectstage: self.projectstage,
                        graphdata: JSON.stringify(item.graph)
                    }).then(res => {
                        if(!res.success){
                            self.$message.error('保存流程图像数据失败！');
                        } else {
                             self.$message.success('保存流程图像数据成功');
                        }
                    // eslint-disable-next-line no-unused-vars
                    }).catch(error => {
                        // eslint-disable-next-line no-console
                        console.log(error);
                        self.$message.error('网络问题，请联系管理员！');
                    });
                });
            },
            //初始化数据 
            //查询阶段信息
            initData(){
                //根据项目类型id查询项目阶段数据
                this.net.ProcessInfo_getStageByType({id: this.$route.query.id}).then(res => {
                    this.items = res.data;
                });
            },
            //点击阶段信息触发的回调函数
            async handleClick(data){
                if (this.selectId1 === data.id){
                    this.selectId1 = '';
                    this.selectName = '';
                } else {
                    this.selectId1 = data.id;
                    this.selectName = data.stagename;
                    // 按钮展开时再请求流程信息
                    let {projecttype, projectstage} = data;
                    this.projecttype= projecttype;
                    this.projectstage = projectstage;
                    //获取图像json数据
                    //根据项目类型id和项目阶段查询流程图像数据
                    let res = await this.net.ProcessInfo_getGraphInfo({projecttype, projectstage});
                    //流程图像数据
                    if(res.entity && res.entity.graphdata){
                        this.graphData = JSON.parse(res.entity.graphdata);
                        // eslint-disable-next-line no-console
                        //console.log(this.graphData);
                    }
                }

            },
            //打开流程图设计器 Dialog对话框
            toProcessDesignerDialog(){
                this.dialogVisible = true;
            },
        }
    };
</script>

<style scoped>
    .show_me{
        overflow-y: scroll;
        height: 550px;
        width: 800px;
    }
    .iptwidth{
        width: 60%;
    }
    .root {
        margin-right: 3rem;
    }
    a {
        text-decoration:none
    }
    a:hover {
        text-decoration:underline
    }
    ul {
        list-style-type:none;
        padding:0
    }
    li {
        padding:10px
    }
    pre {
        border-radius:20px;
        padding:20px;
        background:#fefefe
    }
    .list,
    pre {
        width:80%;
        max-width:500px
    }
    .list {
        max-height:80vh;
        margin:0 auto;
        padding:0;
        overflow:auto;
        background-color:#f3f3f3;
        border:1px solid #efefef;
        border-radius:3px
    }
    .list-item {
        display:-webkit-box;
        display:-ms-flexbox;
        display:flex;
        -webkit-box-align:center;
        -ms-flex-align:center;
        align-items:center;
        width:100%;
        padding:20px;
        background-color:#fff;
        border-bottom:1px solid #efefef;
        box-sizing:border-box;
        -webkit-user-select:none;
        -moz-user-select:none;
        -ms-user-select:none;
        user-select:none;
        color:#333;
        font-weight:400
    }

    .gridItem .wrapper {
        display:-webkit-box;
        display:-ms-flexbox;
        display:flex;
        -webkit-box-align:center;
        -ms-flex-align:center;
        align-items:center;
        -webkit-box-pack:center;
        -ms-flex-pack:center;
        justify-content:center;
        width:100%;
        height:100%;
        background:#fff;
        border:1px solid #efefef;
        font-size:28px
    }
    .gridItem .wrapper span {
        display:none
    }
    .category {
        height:auto
    }
    .category .categoryHeader {
        display:-webkit-box;
        display:-ms-flexbox;
        display:flex;
        -webkit-box-orient:horizontal;
        -webkit-box-direction:normal;
        -ms-flex-flow:row nowrap;
        flex-flow:row nowrap;
        -webkit-box-align:center;
        -ms-flex-align:center;
        align-items:center;
        padding:10px 14px;
        background:#f9f9f9;
        border-bottom:1px solid #efefef
    }
    .category .categoryList {
        height:auto
    }
    .divider {
        padding:10px 20px;
        background:#f9f9f9;
        border-bottom:1px solid #efefef;
        text-transform:uppercase;
        font-size:14px;
        color:#333
    }
    .helper {
        box-shadow:0 5px 5px -5px rgba(0,0,0,.2),0 -5px 5px -5px rgba(0,0,0,.2)
    }
    .stylizedHelper {
        box-shadow:0 10px 20px rgba(0,0,0,.2);
        background-color:rgba(31,136,255,.8);
        color:#fff;
        cursor:row-resize;
        border:1px solid #fff
    }
    .stylizedHelper.horizontalItem {
        cursor:col-resize
    }
    .stylizedHelper.gridItem {
        background-color:transparent;
        white-space:nowrap;
        box-shadow:none
    }
    .stylizedHelper.gridItem .wrapper {
        background-color:hsla(0,0%,100%,.8);
        box-shadow:0 0 7px rgba(0,0,0,.15)
    }
    .shrinkedHelper {
        height:20px!important
    }
    html, body {
        overflow: hidden;
        margin: 0;
        font-size: 12px;
    }
    #app{
    margin: 0;
    padding: 0;
    }
</style>
