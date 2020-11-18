<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 底稿文件检索
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="handle-box">
                <el-row type="flex">
                    <el-col :span="5">
                        <el-input v-model="query.keyword" placeholder="全文检索" class="handle-input mr10"></el-input>
                    </el-col>
                    <el-col :span="5">
                        <el-input v-model="query.docname" placeholder="文件名称" class="handle-input mr10"></el-input>
                    </el-col>
                    <el-col :span="5">
                        <el-input v-model="query.projectname" placeholder="项目名称" class="handle-input mr10"></el-input>
                    </el-col>
                    <el-col :span="5">
                        <el-select v-model="query.historyFlag" placeholder="历史版本" class="handle-input mr10" >
                            <el-option
                                v-for="item in historyFlagOptions"
                                :key="item.value"
                                :label="item.label"
                                :value="item.value">
                            </el-option>
                        </el-select>
                    </el-col>
                    <el-col :span="4">
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
                <!-- <el-table-column prop="id" label="文件ID" width="75" align="center"></el-table-column> -->
                <el-table-column prop="docname" label="文件名称"></el-table-column>
                <el-table-column prop="projectname" label="项目名称"></el-table-column>
                <el-table-column prop="directoryfullname" label="所属目录"></el-table-column>
                <el-table-column prop="uploadtime" label="上传时间"></el-table-column>
                <!-- <el-table-column prop="version" label="文件版本"></el-table-column> -->
                <el-table-column label="操作" width="250" align="center">
                    <template slot-scope="scope">
                        <el-button
                                type="text"
                                icon="el-icon-tickets"
                                class="lookup-me"
                                @click="handleLookup(scope.$index, scope.row)"
                        >查看</el-button>
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
    export default {
        name: 'esManagementSelect',
        data() {
            return {
                query: {
                    projectname: '',            // 项目名称
                    docname: '',                // 文件名称
                    keyword: '',                // 关键字
                    historyFlag: '1',           // 是否显示历史版本
                    currentPage: 1,
                    itemsPerPage: 10
                },
                tableData: [],
                historyFlagOptions: [
                    {
                        value: '0',
                        label: '历史版本'
                    },
                    {
                        value: '1',
                        label: '新版本'
                    }
                ],
                pageTotal: 0,
                id: -1
            };
        },
        created() {
            this.getData();
        },
        methods: {
            // 分页查询文件搜索信息
            getData() {
                this.net.searchByPage_Es(this.query).then(res => {
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
                    projectname: '',            // 项目名称
                    keyword: '',                // 关键字
                    historyFlag: '1',           // 是否显示历史版本
                    currentPage: 1,
                    itemsPerPage: 10
                };
            },
            // 查看
            handleLookup(index, row) {
                let query = {
                    id: row.id
                };
                this.$router.push({path:"/esManagementLookup",query:query});
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
