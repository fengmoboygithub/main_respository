<template>
    <div id="app">
        <div class="container" style="width: 100%;height: 100%">
            <div class="root">
                <div class="crumbs">
                    <el-breadcrumb separator="/">
                        <el-breadcrumb-item>
                            <i class="el-icon-s-operation"></i> 流程信息
                        </el-breadcrumb-item>
                    </el-breadcrumb>
                </div>


                <!-- 展示阶段信息 -->
                <el-tabs v-model="minStageVal" tab-position="top">
                    <el-tab-pane
                        v-for="item in items"
                        :key="item.projectstage"
                        :label="item.stagename"
                        :name="item.projectstage"
                        :lazy=true
                        >
                        {{item.stagename}}
                        <div class="show_me">
                            <G6Editor mode="edit" :projectType="item.projecttype" :projectStage="item.projectstage"></G6Editor>
                        </div>
                    </el-tab-pane>
                </el-tabs>
            </div>
        </div>
    </div>
</template>

<script>
    // import eventBus from "@/components/common/bus";
    // import _ from 'lodash';
    import G6Editor from '@/components/ProcessDesign/G6Editor';
    export default {
        name: 'processManagementUpdate',
        components:{G6Editor},
        data() {
            return {
                //该项目类型下的最小阶段值
                minStageVal: "",
                //阶段信息
                items: [],
            };
        },
        created(){
            //初始化数据
            this.initData();
        },
        methods: {
            //初始化数据 
            //1、查询阶段信息
            initData(){
                //根据项目类型id查询项目阶段数据
                this.net.ProcessInfo_getStageByType({id: this.$route.query.id}).then(res => {
                    this.items = res.data;
                    if(this.items){
                        this.minStageVal = this.items[0].projectstage;
                    }
                });
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
