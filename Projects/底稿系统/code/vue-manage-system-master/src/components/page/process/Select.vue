<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 流程设计管理
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="handle-box">
                <el-row type="flex">
                    <el-col :span="8">
                        <el-input v-model="query.typename" placeholder="项目类型" class="handle-input mr10"></el-input>
                    </el-col>
                    <el-col :span="10">

                    </el-col>
                    <el-col :span="6"  >
                        <div style="float: right">
                            <el-button type="primary" icon="el-icon-search" @click="handleSearch">搜索</el-button>
                            <el-button type="primary" icon="el-icon-delete" @click="handleReset">重置</el-button>
                        </div>
                    </el-col>
                </el-row>

            </div>
            <el-table
                    :data="tableData"
                    border
                    class="table"
                    ref="multipleTable"
                    header-cell-class-name="table-header"
            >
                <el-table-column prop="typename" label="项目类型"></el-table-column>
                <el-table-column label="操作" width="250" align="center">
                    <template slot-scope="scope">
                        <el-button
                                type="text"
                                icon="el-icon-edit"
                                class="edit-me"
                                @click="handleEdit(scope.$index, scope.row)"
                        >流程设计</el-button>
                    </template>
                </el-table-column>
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
        </div>
    </div>
</template>

<script>
    import bus from "@/components/common/bus";
    // eslint-disable-next-line no-unused-vars
    import { _ } from '@/utils';
    export default {
        name: 'processManagementSelect',
        data() {
            return {
                query: {
                    typename: '',
                    currentPage: 1,
                    itemsPerPage: 10
                },
                tableData: [],
                pageTotal: 0
            };
        },
        created(){
            this.getData();
        },
        methods: {
            getData(){
                //分页查询项目类型数据
                this.net.projectInfo_getListByPage(this.query).then(res => {
                    this.tableData = res.data;
                    this.pageTotal = res.recordsTotal || 0;
                });
            },
            // 触发搜索按钮
            handleSearch() {
                this.getData();
            },
            // 触发重置按钮
            handleReset() {
                this.query = {
                    typename: '',
                    currentPage: 1,
                    itemsPerPage: 10
                };
            },
            // 流程设计
            handleEdit(index, row) {
                let {id} = row;
                let _that = this;
                this.$router.push({path:"/processManagementUpdate",query:{id}});
                //开启监听只要编辑页面出发保存编辑时触发
                bus.$on('editProcess_Evt', () => {
                    _that.$message.success(`编辑成功`);
                    this.getData();
                });
            },
            // 分页导航
            handlePageChange(val) {
                this.$set(this.query, 'currentPage', val);
                this.getData();
            }
        }
    };
</script>

<style scoped>
    .handle-box {
        margin-bottom: 20px;
    }

    .handle-select {
        width: 120px;
    }

    .handle-input {
        width: 60%;
        display: inline-block;
    }
    .table {
        width: 100%;
        font-size: 14px;
    }
    .red {
        color: #ff0000;
    }
    .lookup-me{
        color: rgb(81,166,253);
    }
    .edit-me{
        color: rgb(110,78,253);
    }
    .view-me{
        color: rgb(71,118,253);
    }
    .examine-me{
        color: rgb(253,172,88);
    }
    .upload-me{
        color: rgb(253,84,84);
    }
    .file-me{
        color: rgb(82,221,112);
    }
    .export-me{
        color: rgb(71,161,253);
    }
    .mr10 {
        margin-right: 10px;
    }
    .table-td-thumb {
        display: block;
        margin: auto;
        width: 40px;
        height: 40px;
    }
</style>
