<template>
    <div class="hit">
        <el-row :gutter="20" class="hit">
            <el-col :span="8" class="hit">
                <el-card shadow="hover" class="mgb20" style="height: 40%;">
                    <div class="user-info" style="height: 100%;">
                        <img src="../../assets/img/img.jpg" class="user-avator" alt />
                        <div class="user-info-cont">
                            <div class="user-info-name">{{name}}</div>
                            <div>{{role}}</div>
                        </div>
                    </div>
                    <!-- <div class="user-info-list">
                        上次登录时间：
                        <span>2019-11-01</span>
                    </div>
                    <div class="user-info-list">
                        上次登录地点：
                        <span>北京</span>
                    </div> -->
                </el-card>
                <el-card shadow="hover" style="height: 60%;text-align: center">
                    <!-- <div slot="header" class="clearfix">
                        <span>我的工作</span>
                    </div> -->
                    <div ref="myCharts" style="width: 100%;height: 160%"></div>
                    <!--Vue-->
                    <el-progress :percentage="71.3" color="#42b983"></el-progress>鸿基一号基金项目
                    <el-progress :percentage="24.1" color="#f1e05a"></el-progress>东方证券1003项目
                    <el-progress :percentage="13.7"></el-progress>东方证券1004项目
                    <el-progress :percentage="5.9" color="#f56c6c"></el-progress>鸿基二号基金项目
                </el-card>
            </el-col>
            <el-col :span="16" class="hit">
                <el-row :gutter="20" class="mgb20">
                    <el-col :span="8">
                        <el-card shadow="hover" :body-style="{padding: '0px'}">
                            <div class="grid-content grid-con-1">
                                <i class="el-icon-upload grid-con-icon"></i>
                                <div class="grid-cont-right">
                                    <div class="grid-num">上传底稿</div>
                                    <div style="margin-right: -50px">78已上传</div>
                                </div>
                            </div>
                        </el-card>
                    </el-col>
                    <el-col :span="8">
                        <el-card shadow="hover" :body-style="{padding: '0px'}">
                            <div class="grid-content grid-con-2">
                                <i class="el-icon-lx-notice grid-con-icon"></i>
                                <div class="grid-cont-right">
                                    <div class="grid-num">备用菜单1</div>
                                    <div style="margin-right: -50px">备用</div>
                                </div>
                            </div>
                        </el-card>
                    </el-col>
                    <el-col :span="8">
                        <el-card shadow="hover" :body-style="{padding: '0px'}">
                            <div class="grid-content grid-con-3">
                                <i class="el-icon-lx-goods grid-con-icon"></i>
                                <div class="grid-cont-right">
                                    <div class="grid-num">备用菜单2</div>
                                    <div style="margin-right: -50px">备用</div>
                                </div>
                            </div>
                        </el-card>
                    </el-col>
                </el-row>
                <el-card shadow="hover" style="height:78%;">
                    <div slot="header" class="clearfix">
                        <span>待办事项</span>
                        <!-- <el-button style="float: right; padding: 3px 0" type="text">添加</el-button> -->
                    </div>
                    <el-table :show-header="false" :data="dealtList" style="width:100%;">
                        <el-table-column>
                            <template slot-scope="scope">
                                <div class="todo-item">{{scope.row.projectname}}>>{{scope.row.sname}}{{scope.row.processnodename}}</div>
                            </template>
                        </el-table-column>
                        <el-table-column width="60">
                            <template slot-scope="scope">
                                <el-button
                                        type="text"
                                        icon="el-icon-tickets"
                                        @click="handleView(scope.$index, scope.row)"
                                >查看</el-button>
                            </template>
                        </el-table-column>
                        
                        <!-- <el-table-column width="40">
                            <template slot-scope="scope">
                                <el-checkbox v-model="scope.row.status"></el-checkbox>
                            </template>
                        </el-table-column>
                        <el-table-column>
                            <template slot-scope="scope">
                                <div
                                    class="todo-item"
                                    :class="{'todo-item-del': scope.row.status}"
                                >{{scope.row.title}}</div>
                            </template>
                        </el-table-column> -->
                        <!-- <el-table-column width="60">
                            <template>
                                <i class="el-icon-edit"></i>
                                <i class="el-icon-delete"></i>
                            </template>
                        </el-table-column> -->
                    </el-table>
                    <div class="pagination">
                        <el-pagination
                                background
                                layout="total, prev, pager, next"
                                :current-page="query.currentPage"
                                :page-size="query.itemsPerPage"
                                :total="pageTotal"
                                @current-change="handlePageChange"
                        ></el-pagination>
                    </div>
                </el-card>
            </el-col>
        </el-row>
        <!--<el-row :gutter="20">-->
            <!--<el-col :span="12">-->
                <!--<el-card shadow="hover">-->
                    <!--<schart ref="bar" class="schart" canvasId="bar" :options="options"></schart>-->
                <!--</el-card>-->
            <!--</el-col>-->
            <!--<el-col :span="12">-->
                <!--<el-card shadow="hover">-->
                    <!--<schart ref="line" class="schart" canvasId="line" :options="options2"></schart>-->
                <!--</el-card>-->
            <!--</el-col>-->
        <!--</el-row>-->
    </div>
</template>

<script>
import Schart from 'vue-schart';
import echarts from 'echarts'
export default {
    name: 'dashboard',
    data() {
        return {
            name: sessionStorage.getItem('userName'),
            dealtList: [],
            query: {
                currentPage: 1,
                itemsPerPage: 5,
            },
            pageTotal: 0,
            todoList: [
                {
                    title: '鸿基一号基金项目待审批',
                    status: false
                },
                {
                    title: '东方证券1003项目已退回',
                    status: false
                },
                {
                    title: '鸿基一号基金项目待审批',
                    status: false
                },
                {
                    title: '东方证券1003项目已退回',
                    status: false
                },
                {
                    title: '鸿基一号基金项目待审批',
                    status: true
                },
                {
                    title: '东方证券1003项目已退回',
                    status: true
                },
            ],
            data: [
                {
                    name: '2018/09/04',
                    value: 1083
                },
                {
                    name: '2018/09/05',
                    value: 941
                },
                {
                    name: '2018/09/06',
                    value: 1139
                },
                {
                    name: '2018/09/07',
                    value: 816
                },
                {
                    name: '2018/09/08',
                    value: 327
                },
                {
                    name: '2018/09/09',
                    value: 228
                },
                {
                    name: '2018/09/10',
                    value: 1065
                }
            ],
            options: {
                type: 'bar',
                title: {
                    text: '最近一周各品类销售图'
                },
                xRorate: 25,
                labels: ['周一', '周二', '周三', '周四', '周五'],
                datasets: [
                    {
                        label: '家电',
                        data: [234, 278, 270, 190, 230]
                    },
                    {
                        label: '百货',
                        data: [164, 178, 190, 135, 160]
                    },
                    {
                        label: '食品',
                        data: [144, 198, 150, 235, 120]
                    }
                ]
            },
            options2: {
                type: 'line',
                title: {
                    text: '最近几个月各品类销售趋势图'
                },
                labels: ['6月', '7月', '8月', '9月', '10月'],
                datasets: [
                    {
                        label: '家电',
                        data: [234, 278, 270, 190, 230]
                    },
                    {
                        label: '百货',
                        data: [164, 178, 150, 135, 160]
                    },
                    {
                        label: '食品',
                        data: [74, 118, 200, 235, 90]
                    }
                ]
            }
        };
    },
    components: {
        // eslint-disable-next-line vue/no-unused-components
        Schart
    },
    computed: {
        role() {
            return this.name === 'admin' ? '超级管理员' : '普通用户';
        }
    },
    mounted() {
        this.initCharts();
    },
    created() {
        //this.initCharts();
        // this.handleListener();
        // this.changeDate();
        this.getData();
    },

    // activated() {
    //     this.handleListener();
    // },
    // deactivated() {
    //     window.removeEventListener('resize', this.renderChart);
    //     bus.$off('collapse', this.handleBus);
    // },
    methods: {
        // 分页查询待办信息
        getData() {
            this.net.getListByPageForDealt_ProjectInfo(this.query).then(res => {
                this.dealtList = res.data;
                this.pageTotal = res.recordsTotal || 0;
            });
        },
        // 分页导航
        handlePageChange(val) {
            this.$set(this.query, 'currentPage', val);
            this.getData();
        },
        // 查看底稿
        handleView(index, row) {
            let query = {
                id: row.projectid,
                projectStage: row.stage
            };
            this.$router.push({path:"/projectManagementView",query:query});
        },
        changeDate() {
            const now = new Date().getTime();
            this.data.forEach((item, index) => {
                const date = new Date(now - (6 - index) * 86400000);
                item.name = `${date.getFullYear()}/${date.getMonth() + 1}/${date.getDate()}`;
            });
        },
        initCharts(){
            let chartRef = this.$refs.myCharts;
            // console.log(chartRef);
            let myChart = echarts.init(chartRef);
            let option = {
                title: {
                    text: '我的工作',
                    left: 'left'
                },
                tooltip: {
                    trigger: 'item',
                    formatter: '{a} <br/>{b} : {c} ({d}%)'  // 自定义提示框信息格式
                },
                legend: {
                    orient: 'horizontal',                   // 布局方式
                    bottom: 'left',                         // 注解说明位置
                    data: ['待提交', '复核通过', '验收通过', '补正待提交', '复核不通过', '验收不通过', '待复核', '待验收']
                },
                series: [
                    {
                        name: '数量',
                        type: 'pie',
                        radius: '40%',                      // 饼状图大小
                        center: ['50%', '30%'],             // 饼状图相对位置：横，纵
                        data: [
                            {value: 335, name: '待提交'},
                            {value: 310, name: '复核通过'},
                            {value: 134, name: '验收通过'},
                            {value: 58, name: '补正待提交'},
                            {value: 32, name: '复核不通过'},
                            {value: 76, name: '验收不通过'},
                            {value: 600, name: '待复核'},
                            {value: 299, name: '待验收'}
                        ],
                        emphasis: {
                            itemStyle: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }
                ]
            }
            myChart.setOption(option)
        }
        // handleListener() {
        //     bus.$on('collapse', this.handleBus);
        //     // 调用renderChart方法对图表进行重新渲染
        //     window.addEventListener('resize', this.renderChart);
        // },
        // handleBus(msg) {
        //     setTimeout(() => {
        //         this.renderChart();
        //     }, 200);
        // },
        // renderChart() {
        //     this.$refs.bar.renderChart();
        //     this.$refs.line.renderChart();
        // }
    }
};
</script>


<style scoped>
    .hit{
        height: 99%;
    }
.el-row {
    margin-bottom: 20px;
}

.grid-content {
    display: flex;
    align-items: center;
    height: 100px;
}

.grid-cont-right {
    flex: 1;
    text-align: center;
    font-size: 14px;
    color: #999;
}

.grid-num {
    font-size: 30px;
    font-weight: bold;
}

.grid-con-icon {
    font-size: 50px;
    width: 100px;
    height: 100px;
    text-align: center;
    line-height: 100px;
    color: #fff;
}

.grid-con-1 .grid-con-icon {
    background: rgb(45, 140, 240);
}

.grid-con-1 .grid-num {
    color: rgb(45, 140, 240);
}

.grid-con-2 .grid-con-icon {
    background: rgb(100, 213, 114);
}

.grid-con-2 .grid-num {
    color: rgb(45, 140, 240);
}

.grid-con-3 .grid-con-icon {
    background: rgb(242, 94, 67);
}

.grid-con-3 .grid-num {
    color: rgb(242, 94, 67);
}

.user-info {
    display: flex;
    align-items: center;
    padding-bottom: 20px;
    border-bottom: 2px solid #ccc;
    margin-bottom: 20px;
}

.user-avator {
    width: 120px;
    height: 120px;
    border-radius: 50%;
}

.user-info-cont {
    padding-left: 50px;
    flex: 1;
    font-size: 14px;
    color: #999;
}

.user-info-cont div:first-child {
    font-size: 30px;
    color: #222;
}

.user-info-list {
    font-size: 14px;
    color: #999;
    line-height: 25px;
}

.user-info-list span {
    margin-left: 70px;
}

.mgb20 {
    margin-bottom: 20px;
}

.todo-item {
    font-size: 14px;
}

.todo-item-del {
    text-decoration: line-through;
    color: #999;
}

.schart {
    width: 100%;
    height: 300px;
}
</style>
