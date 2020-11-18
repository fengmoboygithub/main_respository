<template>
    <div class="">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-lx-copy"></i> 消息中心</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <el-tabs v-model="message" tab-position="left">
                <el-tab-pane :label="`未读消息(${unreadPageTotal})`" name="first">
                    <el-table :data="unread" :show-header="false" style="width: 100%">
                        <el-table-column>
                            <template slot-scope="scope">
                                <span class="message-title">{{scope.row.mgcontent}}</span>
                            </template>
                        </el-table-column>
                        <el-table-column prop="createTime" width="180"></el-table-column>
                        <el-table-column width="120">
                            <template slot-scope="scope">
                                <el-button size="small" @click="handleRead(scope.row)">标为已读</el-button>
                            </template>
                        </el-table-column>
                    </el-table>
                    <div class="pagination">
                        <el-pagination
                                background
                                layout="total, prev, pager, next"
                                :current-page="unreadQuery.currentPage"
                                :page-size="unreadQuery.itemsPerPage"
                                :total="unreadPageTotal"
                                @current-change="handlePageChangeForUnread"
                        ></el-pagination>
                    </div>
                    <div class="handle-row" v-if="unreadPageTotal > 0">
                        <el-button type="primary"  @click="handleAllRead()">全部标为已读</el-button>
                    </div>
                </el-tab-pane>
                <el-tab-pane :label="`已读消息(${readPageTotal})`" name="second">
                    <template v-if="message === 'second'">
                        <el-table :data="read" :show-header="false" style="width: 100%">
                            <el-table-column>
                                <template slot-scope="scope">
                                    <span class="message-title">{{scope.row.mgcontent}}</span>
                                </template>
                            </el-table-column>
                            <el-table-column prop="createTime" width="150"></el-table-column>
                            <el-table-column width="120">
                                <template slot-scope="scope">
                                    <el-button type="danger" @click="handleDel(scope.row)">删除</el-button>
                                </template>
                            </el-table-column>
                        </el-table>
                        <div class="pagination">
                            <el-pagination
                                    background
                                    layout="total, prev, pager, next"
                                    :current-page="readQuery.currentPage"
                                    :page-size="readQuery.itemsPerPage"
                                    :total="readPageTotal"
                                    @current-change="handlePageChangeForRead"
                            ></el-pagination>
                        </div>
                        <div class="handle-row" v-if="readPageTotal > 0">
                            <el-button type="danger" @click="handleAllDel()">删除全部</el-button>
                        </div>
                    </template>
                </el-tab-pane>
                <el-tab-pane :label="`回收站(${recyclePageTotal})`" name="third">
                    <template v-if="message === 'third'">
                        <el-table :data="recycle" :show-header="false" style="width: 100%">
                            <el-table-column>
                                <template slot-scope="scope">
                                    <span class="message-title">{{scope.row.mgcontent}}</span>
                                </template>
                            </el-table-column>
                            <el-table-column prop="createTime" width="150"></el-table-column>
                            <el-table-column width="120">
                                <template slot-scope="scope">
                                    <el-button @click="handleRestore(scope.row)">还原</el-button>
                                </template>
                            </el-table-column>
                        </el-table>
                        <div class="pagination">
                            <el-pagination
                                    background
                                    layout="total, prev, pager, next"
                                    :current-page="recycleQuery.currentPage"
                                    :page-size="recycleQuery.itemsPerPage"
                                    :total="recyclePageTotal"
                                    @current-change="handlePageChangeForRecycle"
                            ></el-pagination>
                        </div>
                        <div class="handle-row" v-if="recyclePageTotal > 0">
                            <el-button type="danger" @click="handleAllClear()">清空回收站</el-button>
                        </div>
                    </template>
                </el-tab-pane>
            </el-tabs>
        </div>
    </div>
</template>

<script>
import bus from "@/components/common/bus";
    export default {
        name: 'tabs',
        data() {
            return {
                message: 'first',
                showHeader: false,
                //未读--列表
                unread: [],
                //未读--分页参数信息
                unreadQuery:{
                    currentPage: 1,
                    itemsPerPage: 10,
                    usermgstate: '1',
                },
                //未读--列表总条数
                unreadPageTotal: 0,
                //已读--列表
                read: [],
                //已读--分页参数信息
                readQuery:{
                    currentPage: 1,
                    itemsPerPage: 10,
                    usermgstate: '2',
                },
                //已读--列表总条数
                readPageTotal: 0,
                //回收站--列表
                recycle: [],
                //回收站--分页参数信息
                recycleQuery:{
                    currentPage: 1,
                    itemsPerPage: 10,
                    usermgstate: '3',
                },
                //回收站--列表总条数
                recyclePageTotal: 0,
            }
        },
        created() {
            //初始化或重新获取全部数据
            this.initAllData();
        },
        methods: {
            //初始化或重新获取全部数据
            initAllData(){
                //获取未读的数据
                this.getUnreadData();
                //获取已读的数据
                this.getReadData();
                //获取回收站的数据
                this.getRecycleData();
            },

            // 未读--分页获取未读的数据
            getUnreadData() {
                this.net.getListByPage_UserMessageRela(this.unreadQuery).then(res => {
                    this.unread = res.data;
                    this.unreadPageTotal = res.recordsTotal || 0;
                });
            },
            // 未读--分页导航
            handlePageChangeForUnread(val) {
                this.$set(this.unreadQuery, 'currentPage', val);
                //获取未读的数据
                this.getUnreadData();
            },

            // 已读--分页获取未读的数据
            getReadData() {
                this.net.getListByPage_UserMessageRela(this.readQuery).then(res => {
                    this.read = res.data;
                    this.readPageTotal = res.recordsTotal || 0;
                });
            },
            // 已读--分页导航
            handlePageChangeForRead(val) {
                this.$set(this.readQuery, 'currentPage', val);
                //获取已读的数据
                this.getReadData();
            },

            // 回收站--分页获取未读的数据
            getRecycleData() {
                this.net.getListByPage_UserMessageRela(this.recycleQuery).then(res => {
                    this.recycle = res.data;
                    this.recyclePageTotal = res.recordsTotal || 0;
                });
            },
            // 回收站--分页导航
            handlePageChangeForRecycle(val) {
                this.$set(this.recycleQuery, 'currentPage', val);
                //获取回收站的数据
                this.getRecycleData();
            },

            //标为已读
            handleRead(row) {
                //将数据状态由未读变为已读
                this.net.update_UserMessageRela(
                    {
                        id:row.id,//主键
                        usermgstatebefore:'1',//修改前状态
                        usermgstate:'2',//修改后状态
                    }
                ).then(res => {
                    if(res.success){
                        //初始化或重新获取全部数据
                        this.initAllData();
                        bus.$emit('header_Evt');
                    } else {
                        this.$message.error('标为已读失败！');
                    }
                });
                
            },
            //删除
            handleDel(row) {
                //将数据状态由已读变为回收站
                this.net.update_UserMessageRela(
                    {
                        id:row.id,//主键
                        usermgstatebefore:'2',//修改前状态
                        usermgstate:'3',//修改后状态
                    }
                ).then(res => {
                    if(res.success){
                        //初始化或重新获取全部数据
                        this.initAllData();
                    } else {
                        this.$message.error('删除失败！');
                    }
                });
            },
            //还原
            handleRestore(row) {
                //将数据状态由回收站变为已读
                this.net.update_UserMessageRela(
                    {
                        id:row.id,//主键
                        usermgstatebefore:'3',//修改前状态
                        usermgstate:'2',//修改后状态
                    }
                ).then(res => {
                    if(res.success){
                        //初始化或重新获取全部数据
                        this.initAllData();
                    } else {
                        this.$message.error('还原失败！');
                    }
                });
            },

            //全部标为已读
            handleAllRead(){
                this.net.allChangeState_UserMessageRela(
                    {
                        usermgstate:'2',
                    }
                ).then(res => {
                    if(res.success){
                        //初始化或重新获取全部数据
                        this.initAllData();
                        bus.$emit('header_Evt');
                    } else {
                        this.$message.error('全部标为已读失败！');
                    }
                });
            },

            //删除全部
            handleAllDel(){
                this.net.allChangeState_UserMessageRela(
                    {
                        usermgstate:'3',
                    }
                ).then(res => {
                    if(res.success){
                        //初始化或重新获取全部数据
                        this.initAllData();
                    } else {
                        this.$message.error('删除全部失败！');
                    }
                });
            },

            //清空回收站
            handleAllClear(){
                this.net.allChangeState_UserMessageRela(
                    {
                        usermgstate:'4',
                    }
                ).then(res => {
                    if(res.success){
                        //初始化或重新获取全部数据
                        this.initAllData();
                    } else {
                        this.$message.error('清空回收站失败！');
                    }
                });
            },
        },
        // computed: {
        //     unreadNum(){
        //         return this.unread.length;
        //     }
        // }
    }

</script>

<style>
.message-title{
    cursor: pointer;
}
.handle-row{
    margin-top: 30px;
}
</style>

