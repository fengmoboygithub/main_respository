(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-33814497"],{"24e4":function(e,t,o){"use strict";o.r(t);var n=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",[o("div",{staticClass:"crumbs"},[o("el-breadcrumb",{attrs:{separator:"/"}},[o("el-breadcrumb-item",[o("i",{staticClass:"el-icon-lx-cascades"}),e._v(" 基础目录管理\n            ")])],1)],1),o("div",{staticClass:"container"},[o("div",{staticClass:"content-title"},[e._v("选择项目类型")]),o("div",{staticClass:"form-box"},[o("el-form",{ref:"form",attrs:{model:e.form,"label-width":"80px"}},[o("el-form-item",{attrs:{label:"项目类型"}},[o("el-select",{on:{change:e.handleProjectTypeChange},model:{value:e.form.projecttype,callback:function(t){e.$set(e.form,"projecttype",t)},expression:"form.projecttype"}},e._l(e.projectTypeOptions,(function(e){return o("el-option",{key:e.id,attrs:{label:e.typename,value:e.id}})})),1)],1)],1)],1),o("div",{staticClass:"content-title"},[e._v("基础目录信息")]),o("el-tabs",{attrs:{type:"card"},on:{"tab-click":e.handleClick},model:{value:e.form.stage,callback:function(t){e.$set(e.form,"stage",t)},expression:"form.stage"}},e._l(e.projectStageOptions,(function(t){return o("el-tab-pane",{key:t.projectstage,attrs:{label:t.stagename,name:t.projectstage}},[e._v("\n                "+e._s(t.stagename)+"\n                "),o("v-tree",{attrs:{projecttype:e.form.projecttype,projectStage:t.projectstage}})],1)})),1)],1)])},s=[],i=(o("7ed4"),function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",[o("div",{staticClass:"container"},[e.showNotRootInfo?o("el-row",{attrs:{gutter:20}},[o("el-col",{staticStyle:{"border-right":"1px solid"},attrs:{span:12}},[o("tree",{attrs:{setting:e.setting,nodes:e.nodes},on:{onClick:e.onClick,onRightClick:e.onRightClick,onCheck:e.onCheck,onCreated:e.handleCreated}})],1),o("el-col",{attrs:{span:12}},[e.showInfo?o("div",{staticClass:"form-box"},[o("el-form",{ref:"form",attrs:{model:e.form,"label-width":"80px"}},[o("el-form-item",{attrs:{label:"目录简称"}},[o("el-input",{model:{value:e.form.sname,callback:function(t){e.$set(e.form,"sname",t)},expression:"form.sname"}})],1),o("el-form-item",{attrs:{label:"目录全称"}},[o("el-input",{model:{value:e.form.fullname,callback:function(t){e.$set(e.form,"fullname",t)},expression:"form.fullname"}})],1),o("el-form-item",{attrs:{label:"目录顺序"}},[o("el-input",{model:{value:e.form.direntoryno,callback:function(t){e.$set(e.form,"direntoryno",t)},expression:"form.direntoryno"}})],1),o("el-form-item",[o("el-button",{attrs:{type:"primary"},on:{click:e.onSubmit}},[e._v("保存")])],1)],1)],1):e._e()])],1):e._e(),e.showRootInfo?o("div",{staticClass:"form-box"},[o("el-form",{ref:"form",attrs:{model:e.form,"label-width":"80px"}},[o("el-form-item",{attrs:{label:"目录简称"}},[o("el-input",{model:{value:e.form.sname,callback:function(t){e.$set(e.form,"sname",t)},expression:"form.sname"}})],1),o("el-form-item",{attrs:{label:"目录全称"}},[o("el-input",{model:{value:e.form.fullname,callback:function(t){e.$set(e.form,"fullname",t)},expression:"form.fullname"}})],1),o("el-form-item",{attrs:{label:"目录顺序"}},[o("el-input",{model:{value:e.form.direntoryno,callback:function(t){e.$set(e.form,"direntoryno",t)},expression:"form.direntoryno"}})],1),o("el-form-item",[o("el-button",{attrs:{type:"primary"},on:{click:e.onSubmit}},[e._v("保存")])],1)],1)],1):e._e()],1)])}),r=[],a=(o("7514"),o("ac6a"),o("f419")),l=o.n(a),c={name:"baseDirTree",components:{tree:l.a},props:{projecttype:{type:String,require:!0,default:function(){return{}}},projectStage:{type:String,require:!0,default:function(){return{}}},isEdit:{type:Boolean,require:!1,default:function(){return!0}}},data:function(){return{showInfo:!1,isAdd:!1,showNotRootInfo:!1,showRootInfo:!1,form:{projecttype:this.projecttype,projectstage:this.projectStage,id:"",parentid:"",level:"",sname:"",fullname:"",direntoryno:"",isapp:""},dirInfo:null,isappOptions:[{code:1,value:"适用"},{code:2,value:"不适用"}],ulList:[],nodes:[],ztreeObj:null,setting:{check:{enable:!0,nocheckInherit:!0},data:{simpleData:{enable:!0,pIdKey:"pid"}},view:{showIcon:!1}}}},created:function(){this.initTree()},activated:function(){this.initTree()},methods:{selectNodeById:function(e){var t=this,o=this.nodes;e&&o.length>0&&o.some((function(o){if(console.log(o),o.id==e)return console.log(t.ztreeObj),t.ztreeObj&&t.ztreeObj.selectNode(o,!1,!0),!0}))},initTree:function(){var e=this;this.ulList=[],this.net.baseViewTreeForMe({projecttype:this.projecttype,projectStage:this.projectStage}).then((function(t){console.log(t);var o=t;o.success&&200===o.code&&(e.nodes=o.list,e.nodes&&e.nodes.length>0?(e.showRootInfo=!1,e.showNotRootInfo=!0,e.showInfo=!1,e.isAdd=!1):(e.showRootInfo=!0,e.showNotRootInfo=!1))})).catch((function(t){e.$message.error("数据加载失败"),console.log(t)}))},addUlDom:function(e,t,o,n){var s=this;if(o.classList.add("tree_extra_menu","el-menu","el-menu--popup","el-menu--popup-right-start"),"dir"===t.type){var i=document.createElement("li");i.tabindex="-1",i.classList.add("tree_extra_menuitem","el-menu-item"),i.innerText="新增",i.addEventListener("click",(function(e){e.stopPropagation(),o.classList.add("display_none"),s.form.id="",s.form.parentid="",s.form.level="",s.form.sname="",s.form.fullname="",s.form.direntoryno="",s.form.isapp="",s.showInfo=!0,s.isAdd=!0})),i.addEventListener("mouseover",(function(e){e.stopPropagation(),i.classList.remove("tree_extra_menuitem"),i.classList.add("tree_extra_menuitem_hover")})),i.addEventListener("mouseout",(function(e){e.stopPropagation(),i.classList.add("tree_extra_menuitem"),i.classList.remove("tree_extra_menuitem_hover")})),o.appendChild(i);var r=document.createElement("li");r.tabindex="-1",r.classList.add("tree_extra_menuitem","el-menu-item"),r.innerText="删除",r.addEventListener("click",(function(e){e.stopPropagation(),o.classList.add("display_none"),s.clickRemove(t)})),r.addEventListener("mouseover",(function(e){e.stopPropagation(),r.classList.remove("tree_extra_menuitem"),r.classList.add("tree_extra_menuitem_hover")})),r.addEventListener("mouseout",(function(e){e.stopPropagation(),r.classList.add("tree_extra_menuitem"),r.classList.remove("tree_extra_menuitem_hover")})),o.appendChild(r)}n.appendChild(o)},addHoverDom:function(e,t){if(t){var o=document.getElementById("".concat(t.tId,"_a"));if(console.log(o),o){var n=document.createElement("ul");n.id="".concat(e,"_").concat(t.id,"_ul");var s=!1;if(this.ulList.length>0){this.ulList.forEach((function(e){var t=document.getElementById(e);t.classList.add("display_none")})),n.classList.add("display_none");var i=this.ulList.find((function(e){return e===n.id}));i||(s=!0)}else s=!0;if(console.log(s),s)console.log("不存在"),this.ulList.push(n.id),n.classList.remove("display_none"),this.addUlDom(e,t,n,o);else{console.log("存在");var r=document.getElementById(n.id);r.classList.remove("display_none")}}}},getData:function(e){var t=this;this.net.get_BaseDirectory({id:e.id}).then((function(e){console.log(e),e.success?(t.form.id=e.entity.id,t.form.parentid=e.entity.parentid,t.form.level=e.entity.level,t.form.sname=e.entity.sname,t.form.fullname=e.entity.fullname,t.form.direntoryno=e.entity.direntoryno,t.form.isapp=e.entity.isapp):t.$message.error("加载目录信息失败！")}))},handleApp:function(e){var t=this;this.net.update_BaseDirectory({id:e.id,isapp:e.isapp}).then((function(e){console.log(e),e.success?t.$message.success("操作成功！"):t.$message.error("操作失败！")}))},clickRemove:function(e){var t=this;console.log("remove",e),this.net.del_BaseDirectory({id:e.id}).then((function(o){200===o.code?(t.ztreeObj&&t.ztreeObj.removeNode(e),t.$message.success("删除成功")):t.$message.error("服务器错误，删除失败！")})).catch((function(e){t.$message.error("请求错误，删除失败！")}))},onSubmit:function(){var e=this;this.showRootInfo?(this.form.level=1,this.form.isapp=1,this.form.parentid=null,this.net.add_BaseDirectory(this.form).then((function(t){console.log(t),t.success?(e.$message.success("保存成功！"),e.initTree(),e.selectNodeById(t.entity.id)):e.$message.error("保存失败！")}))):(this.form.parentid=this.dirInfo.id,this.form.level=this.dirInfo.level,this.form.isapp=1,this.isAdd?this.net.add_BaseDirectory(this.form).then((function(t){console.log(t),t.success?(e.$message.success("保存成功！"),e.initTree(),e.selectNodeById(t.entity.id)):e.$message.error("保存失败！")})):this.net.update_BaseDirectory(this.form).then((function(t){console.log(t),t.success?(e.$message.success("保存成功！"),e.initTree(e.form.id),e.selectNodeById(e.form.id)):e.$message.error("保存失败！")})))},onClick:function(e,t,o){console.log(e.type,o),this.showInfo=!0,this.isAdd=!1,this.dirInfo=o,this.getData(o)},onCheck:function(e,t,o){console.log(e.type,o)},onRightClick:function(e,t,o){this.ztreeObj.selectNode(o,!1,!0),this.dirInfo=o,this.isEdit&&(console.log("触发右键事件"),this.addHoverDom(t,o))},handleCreated:function(e){this.ztreeObj=e,e.expandAll(!0)},enableChk:function(e){if(e){var t=this;t.ztreeObj.setChkDisabled(e,!1,!1,!0)}},noEnableChk:function(e){if(e){var t=this;t.ztreeObj.setChkDisabled(e,!0,!1,!0)}}}},d=c,m=(o("fdfc"),o("2877")),f=Object(m["a"])(d,i,r,!1,null,null,null),u=f.exports,p={name:"baseDirManagementSelect",components:{vTree:u},data:function(){return{form:{projecttype:"",stage:""},projectTypeOptions:[],projectStageOptions:[]}},created:function(){this.getInitData()},methods:{handleClick:function(e,t){console.log(e,t)},getInitData:function(){var e=this;this.net.getListByPage_ProjectTypeInfo({currentPage:1,itemsPerPage:100}).then((function(t){console.log(t),e.projectTypeOptions=t.data}))},handleProjectTypeChange:function(e){this.loadProjectStage(e)},loadProjectStage:function(e){var t=this;this.projectStageOptions=[],this.net.getListByPage_ProjectStageInfo({currentPage:1,itemsPerPage:100,projecttype:e}).then((function(o){console.log(o),t.projectStageOptions=o.data,t.net.getListByMin_ProjectStageInfo({projecttype:e}).then((function(e){console.log(e),t.form.stage=e.list[0].projectstage}))}))}}},h=p,g=Object(m["a"])(h,n,s,!1,null,"49d48c09",null);t["default"]=g.exports},"7ed4":function(e,t,o){"use strict";var n=o("a026"),s=new n["default"];t["a"]=s},"82c2":function(e,t,o){},fdfc:function(e,t,o){"use strict";var n=o("82c2"),s=o.n(n);s.a}}]);