(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-64b3cf40"],{"5a72":function(e,t,a){"use strict";a.r(t);var l=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-lx-cascades"}),e._v(" "+e._s(e.$route.meta.title)+"\n            ")])],1)],1),a("div",{staticClass:"container"},[a("el-row",{attrs:{type:"flex"}},[a("el-col",{attrs:{span:8}}),a("el-col",{attrs:{span:8}},[a("div",{staticClass:"form-box"},[a("el-form",{ref:"form",attrs:{model:e.form,"label-width":"80px"}},[a("el-form-item",{attrs:{label:"应用ID"}},[a("el-input",{attrs:{disabled:""},model:{value:e.form.id,callback:function(t){e.$set(e.form,"id",t)},expression:"form.id"}})],1),a("el-form-item",{attrs:{label:"角色ID"}},[a("el-input",{attrs:{disabled:""},model:{value:e.form.address,callback:function(t){e.$set(e.form,"address",t)},expression:"form.address"}})],1),a("el-form-item",{attrs:{label:"角色名"}},[a("el-input",{attrs:{disabled:""},model:{value:e.form.address,callback:function(t){e.$set(e.form,"address",t)},expression:"form.address"}})],1),a("el-form-item",{attrs:{label:"角色菜单"}},[a("el-tree",{ref:"tree",attrs:{data:e.data,"show-checkbox":"","default-expand-all":"","node-key":"id","highlight-current":"",props:e.defaultProps}})],1),a("el-form-item",[a("div",{staticClass:"line"},[a("el-button",{attrs:{type:"primary"},on:{click:e.onSubmit}},[e._v("确定")]),a("el-button",{on:{click:e.onCancel}},[e._v("取消")])],1)])],1)],1)]),a("el-col",{attrs:{span:8}})],1)],1)])},s=[],r=a("7ed4"),i={name:"roleMenu",data:function(){return{form:{id:this.$route.query.id,username:"张三",useId:"",userrole:""},data:[{id:1,label:"菜单权限",children:[{id:4,label:"菜单1",children:[{id:5,label:"子菜单1"},{id:6,label:"子菜单2"},{id:7,label:"子菜单3"}]},{id:9,label:"菜单2"},{id:10,label:"菜单3"}]}]}},methods:{onSubmit:function(){r["a"].$emit("saveEdit",this.form),r["a"].$emit("close_current_tags")},getCheckedKeys:function(){console.log(this.$refs.tree.getCheckedKeys())},onCancel:function(){r["a"].$emit("close_current_tags"),this.$router.push({path:"/userManagementSelect"})}}},o=i,n=a("2877"),d=Object(n["a"])(o,l,s,!1,null,"ee56b354",null);t["default"]=d.exports},"7ed4":function(e,t,a){"use strict";var l=a("a026"),s=new l["default"];t["a"]=s}}]);