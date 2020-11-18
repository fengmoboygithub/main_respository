(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-4807da3c"],{5063:function(e,t,a){"use strict";a.r(t);var l=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-lx-cascades"}),e._v(" "+e._s(e.$route.meta.title)+"\n            ")])],1)],1),a("div",{staticClass:"container"},[a("div",{staticClass:"handle-box"},[a("el-row",{attrs:{type:"flex"}},[a("el-col",{attrs:{span:2}},[a("div",{staticStyle:{float:"left"}},[a("el-button",{attrs:{type:"primary",icon:"el-icon-plus"},on:{click:e.handleAdd}},[e._v("新增")])],1)]),a("el-col",{attrs:{span:4}},[e._v("\n                    用户类型：\n                    "),a("el-select",{staticClass:"handle-input mr10",model:{value:e.query.userType,callback:function(t){e.$set(e.query,"userType",t)},expression:"query.userType"}},[a("el-option",{attrs:{value:"0",label:"所有"}}),a("el-option",{attrs:{value:"1",label:"正式用户"}}),a("el-option",{attrs:{value:"2",label:"临时用户"}})],1)],1),a("el-col",{attrs:{span:4}},[e._v("\n                    状态：\n                    "),a("el-select",{staticClass:"handle-input mr10",model:{value:e.query.status,callback:function(t){e.$set(e.query,"status",t)},expression:"query.status"}},[a("el-option",{attrs:{value:"0",label:"所有"}}),a("el-option",{attrs:{value:"1",label:"正常"}}),a("el-option",{attrs:{value:"2",label:"失效"}})],1)],1),a("el-col",{attrs:{span:4}}),a("el-col",{attrs:{span:4}}),a("el-col",{attrs:{span:6}},[a("div",{staticStyle:{float:"right"}},[a("el-button",{attrs:{type:"primary",icon:"el-icon-search"},on:{click:e.handleSearch}},[e._v("搜索")]),a("el-button",{attrs:{type:"primary",icon:"el-icon-delete"},on:{click:e.handleClear}},[e._v("重置")]),a("el-button",{attrs:{type:"danger",icon:"el-icon-delete"},on:{click:e.delAllSelection}},[e._v("批量删除")])],1)])],1)],1),a("el-table",{ref:"multipleTable",staticClass:"table",attrs:{data:e.tableData,border:"","header-cell-class-name":"table-header"},on:{"selection-change":e.handleSelectionChange}},[a("el-table-column",{attrs:{type:"selection",width:"55",align:"center"}}),a("el-table-column",{attrs:{prop:"userId",label:"用户ID",width:"125",align:"center"}}),a("el-table-column",{attrs:{prop:"userName",label:"用户名",align:"center"}}),a("el-table-column",{attrs:{prop:"loginName",label:"登录账号",align:"center"}}),a("el-table-column",{attrs:{prop:"createBy",label:"创建人",align:"center"}}),a("el-table-column",{attrs:{prop:"status",label:"状态",align:"center",formatter:e.statusFormat}}),a("el-table-column",{attrs:{label:"操作",width:"250",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{type:"text",icon:"el-icon-edit"},on:{click:function(a){return e.handleEdit(t.$index,t.row)}}},[e._v("编辑")]),a("el-button",{staticClass:"red",attrs:{type:"text",icon:"el-icon-delete"},on:{click:function(a){return e.handleDelete(t.$index,t.row)}}},[e._v("删除")])]}}])})],1),a("div",{staticClass:"pagination"},[a("el-pagination",{attrs:{background:"",layout:"total, prev, pager, next","current-page":e.query.pageIndex,"page-size":e.query.pageSize,total:e.pageTotal},on:{"current-change":e.handlePageChange}})],1)],1)])},n=[],s=a("7ed4"),i={name:"userManagementSelect",data:function(){return{query:{userType:"",status:"",pageNum:1,pageSize:50},tableData:[],multipleSelection:[],delList:[],pageTotal:0,form:{},idx:-1,id:-1}},created:function(){this.getData()},methods:{getData:function(){var e=this;this.net.user_selectUserList(this.query).then((function(t){0===t.code&&(e.tableData=t.rows,e.pageTotal=t.total)}))},handleSearch:function(){this.$set(this.query,"pageIndex",1),this.getData()},handleDelete:function(e,t){var a=this;this.$confirm("确定要删除吗？","提示",{type:"warning"}).then((function(){a.$message.success("删除成功"),a.tableData.splice(e,1)})).catch((function(){}))},handleSelectionChange:function(e){this.multipleSelection=e},delAllSelection:function(){var e=this,t=this.multipleSelection.length,a="";this.delList=this.delList.concat(this.multipleSelection);for(var l=0;l<t;l++)a+=this.multipleSelection[l].userId+",";this.net.user_deleteUserByIds({ids:a}).then((function(t){0===t.code&&e.$message.success(t.msg)})),this.multipleSelection=[]},handleAdd:function(e,t){var a=this;this.$router.push({path:"/userManagementAdd"}),s["a"].$on("saveEdit",(function(e){a.getData()}))},handleEdit:function(e,t){var a=this,l={userId:t.userId};this.$router.push({path:"/userManagementUpdate",query:l}),s["a"].$on("saveEdit",(function(e){a.getData()}))},handleRole:function(e,t){var a=this,l={userId:t.userId};this.$router.push({path:"/userRole",query:l}),s["a"].$on("saveEdit",(function(e){a.getData()}))},handlePageChange:function(e){this.$set(this.query,"pageIndex",e),this.getData()},handleClear:function(){this.query={userType:"",status:"",pageNum:1,pageSize:50}},statusFormat:function(e,t,a,l){return"1"===a?"停用":"正常"}}},r=i,o=(a("a6e0"),a("2877")),c=Object(o["a"])(r,l,n,!1,null,"065dd0ea",null);t["default"]=c.exports},"7ed4":function(e,t,a){"use strict";var l=a("a026"),n=new l["default"];t["a"]=n},a6e0:function(e,t,a){"use strict";var l=a("b9d9"),n=a.n(l);n.a},b9d9:function(e,t,a){}}]);