(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-0f7b14b4"],{"09a7":function(e,t,o){},"306c":function(e,t,o){"use strict";var n=o("09a7"),s=o.n(n);s.a},"7ed4":function(e,t,o){"use strict";var n=o("a026"),s=new n["default"];t["a"]=s},be3c:function(e,t,o){"use strict";var n=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",[o("div",{staticClass:"container"},[o("el-row",{attrs:{gutter:20}},[o("el-col",{staticStyle:{"border-right":"1px solid"},attrs:{span:12}},[o("tree",{attrs:{setting:e.setting,nodes:e.nodes},on:{onClick:e.onClick,onRightClick:e.onRightClick,onCheck:e.onCheck,onCreated:e.handleCreated}})],1),o("el-col",{attrs:{span:12}},[e.showInfo?o("div",{staticClass:"form-box"},[o("el-form",{ref:"form",attrs:{model:e.form,"label-width":"80px"}},[o("el-form-item",{attrs:{label:"目录简称"}},[o("el-input",{model:{value:e.form.sname,callback:function(t){e.$set(e.form,"sname",t)},expression:"form.sname"}})],1),o("el-form-item",{attrs:{label:"目录全称"}},[o("el-input",{model:{value:e.form.fullname,callback:function(t){e.$set(e.form,"fullname",t)},expression:"form.fullname"}})],1),o("el-form-item",{attrs:{label:"目录顺序"}},[o("el-input",{model:{value:e.form.directoryno,callback:function(t){e.$set(e.form,"directoryno",t)},expression:"form.directoryno"}})],1),o("el-form-item",{attrs:{label:"是否适用"}},[o("el-select",{model:{value:e.form.isapp,callback:function(t){e.$set(e.form,"isapp",t)},expression:"form.isapp"}},e._l(e.isappOptions,(function(e){return o("el-option",{key:e.code,attrs:{label:e.value,value:e.code}})})),1)],1),o("el-form-item",[o("el-button",{attrs:{type:"primary"},on:{click:e.onSubmit}},[e._v("保存")])],1)],1)],1):e._e()])],1)],1)])},s=[],a=(o("7514"),o("ac6a"),o("f419")),i=o.n(a),r={name:"projectDirTree",components:{tree:i.a},props:{projectid:{type:String,require:!0,default:function(){return{}}},projectStage:{type:String,require:!0,default:function(){return{}}},isEdit:{type:Boolean,require:!1,default:function(){return!0}}},data:function(){return{showInfo:!1,isAdd:!1,form:{projectid:this.projectid,stage:this.projectStage,directoryid:"",id:"",parentid:"",level:"",sname:"",fullname:"",directoryno:"",isapp:""},isappOptions:[{code:1,value:"适用"},{code:2,value:"不适用"}],dirInfo:null,ulList:[],nodes:[],ztreeObj:null,setting:{check:{enable:!0,nocheckInherit:!0},data:{simpleData:{enable:!0,pIdKey:"pid"}},view:{showIcon:!1}}}},created:function(){this.initTree()},activated:function(){this.initTree()},methods:{initTree:function(e){var t=this;this.ulList=[],this.net.viewTreeForMe({projectid:this.projectid,projectStage:this.projectStage}).then((function(o){console.log(o);var n=o;n.success&&200===n.code&&(t.nodes=n.list),t.showInfo=!1,t.isAdd=!1;var s=t.nodes;e&&s.length>0&&s.some((function(o){if(console.log(o),o.id==e)return t.ztreeObj.selectNode(o),!0})),t.$message.success("数据加载成功")})).catch((function(e){t.$message.error("数据加载失败"),console.log(e)}))},addUlDom:function(e,t,o,n){var s=this;if(o.classList.add("tree_extra_menu","el-menu","el-menu--popup","el-menu--popup-right-start"),"dir"===t.type){var a=document.createElement("li");a.tabindex="-1",a.classList.add("tree_extra_menuitem","el-menu-item"),a.innerText="新增",a.addEventListener("click",(function(e){e.stopPropagation(),o.classList.add("display_none"),s.form.directoryid="",s.form.id="",s.form.parentid="",s.form.level="",s.form.sname="",s.form.fullname="",s.form.directoryno="",s.form.isapp="",s.showInfo=!0,s.isAdd=!0})),a.addEventListener("mouseover",(function(e){e.stopPropagation(),a.classList.remove("tree_extra_menuitem"),a.classList.add("tree_extra_menuitem_hover")})),a.addEventListener("mouseout",(function(e){e.stopPropagation(),a.classList.add("tree_extra_menuitem"),a.classList.remove("tree_extra_menuitem_hover")})),o.appendChild(a)}if(1===t.isapp){var i=document.createElement("li");i.tabindex="-1",i.classList.add("tree_extra_menuitem","el-menu-item"),i.innerText="不适用",i.addEventListener("click",(function(e){e.stopPropagation(),o.classList.add("display_none"),t.isapp=2,s.handleApp(t)})),i.addEventListener("mouseover",(function(e){e.stopPropagation(),i.classList.remove("tree_extra_menuitem"),i.classList.add("tree_extra_menuitem_hover")})),i.addEventListener("mouseout",(function(e){e.stopPropagation(),i.classList.add("tree_extra_menuitem"),i.classList.remove("tree_extra_menuitem_hover")})),o.appendChild(i)}else if(2===t.isapp){var r=document.createElement("li");r.tabindex="-1",r.classList.add("tree_extra_menuitem","el-menu-item"),r.innerText="适用",r.addEventListener("click",(function(e){e.stopPropagation(),o.classList.add("display_none"),t.isapp=1,s.handleApp(t)})),r.addEventListener("mouseover",(function(e){e.stopPropagation(),r.classList.remove("tree_extra_menuitem"),r.classList.add("tree_extra_menuitem_hover")})),r.addEventListener("mouseout",(function(e){e.stopPropagation(),r.classList.add("tree_extra_menuitem"),r.classList.remove("tree_extra_menuitem_hover")})),o.appendChild(r)}n.appendChild(o)},addHoverDom:function(e,t){if(t){var o=document.getElementById("".concat(t.tId,"_a"));if(console.log(o),o){var n=document.createElement("ul");n.id="".concat(e,"_").concat(t.id,"_ul");var s=!1;if(this.ulList.length>0){this.ulList.forEach((function(e){var t=document.getElementById(e);t.classList.add("display_none")})),n.classList.add("display_none");var a=this.ulList.find((function(e){return e===n.id}));a||(s=!0)}else s=!0;if(console.log(s),s)console.log("不存在"),this.ulList.push(n.id),n.classList.remove("display_none"),this.addUlDom(e,t,n,o);else{console.log("存在");var i=document.getElementById(n.id);i.classList.remove("display_none")}}}},getData:function(e){var t=this;this.net.get_ProjectDirectory({projectid:e.projectid,directoryid:e.id}).then((function(e){console.log(e),e.success?(t.form.directoryid=e.entity.directoryid,t.form.id=e.entity.id,t.form.parentid=e.entity.parentid,t.form.level=e.entity.level,t.form.sname=e.entity.sname,t.form.fullname=e.entity.fullname,t.form.directoryno=e.entity.directoryno,t.form.isapp=e.entity.isapp):t.$message.error("加载目录信息失败！")}))},handleApp:function(e){var t=this,o={};o.id=e.id,o.pid=e.pid,o.isapp=e.isapp,o.type=e.type,this.net.updateIsapp_ProjectDirectory({projectId:this.projectid,projectStage:this.projectStage,treeDag:JSON.stringify([o])}).then((function(e){console.log(e),e.success?t.$message.success("操作成功！"):t.$message.error("操作失败！")}))},onSubmit:function(){var e=this;this.form.parentid=this.dirInfo.id,this.form.level=this.dirInfo.level,this.isAdd?this.net.add_ProjectDirectory(this.form).then((function(t){console.log(t),t.success?(e.$message.success("保存成功！"),e.initTree(t.entity.id)):e.$message.error("保存失败！")})):this.net.update_ProjectDirectory(this.form).then((function(t){console.log(t),t.success?(e.$message.success("保存成功！"),e.initTree(e.form.id)):e.$message.error("保存失败！")}))},onClick:function(e,t,o){console.log(e.type,o),this.showInfo=!0,this.isAdd=!1,this.dirInfo=o,this.getData(o)},onCheck:function(e,t,o){console.log(e.type,o)},onRightClick:function(e,t,o){console.log(e.type,o),this.ztreeObj.selectNode(o,!1,!0),this.dirInfo=o,this.isEdit&&(console.log("触发右键事件"),this.addHoverDom(t,o))},handleCreated:function(e){this.ztreeObj=e,e.expandAll(!0)},enableChk:function(e){if(e){var t=this;t.ztreeObj.setChkDisabled(e,!1,!1,!0)}},noEnableChk:function(e){if(e){var t=this;t.ztreeObj.setChkDisabled(e,!0,!1,!0)}}}},l=r,c=(o("306c"),o("2877")),d=Object(c["a"])(l,n,s,!1,null,null,null);t["a"]=d.exports},ea63:function(e,t,o){"use strict";o.r(t);var n=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",[o("div",{staticClass:"crumbs"},[o("el-breadcrumb",{attrs:{separator:"/"}},[o("el-breadcrumb-item",[o("i",{staticClass:"el-icon-lx-cascades"}),e._v(" 查看项目\n            ")])],1)],1),o("el-menu",{staticClass:"el-menu-demo",attrs:{"default-active":e.activeIndex,mode:"horizontal","background-color":"#EFEFEF","text-color":"#9D9D9D","active-text-color":"#74B4F8"},on:{select:e.handleSelect}},[o("el-menu-item",{attrs:{index:"1"}},[o("i",{staticClass:"el-icon-menu"}),e._v("项目基本信息")]),o("el-menu-item",{attrs:{index:"2"}},[o("i",{staticClass:"el-icon-user-solid"}),e._v("项目人员信息")])],1),o("div",{staticClass:"container"},[o("div",{staticClass:"content-title"},[e._v(e._s(e.contentTitle)+"}")]),o("div",{staticClass:"form-box"},[o("el-form",{ref:"form",attrs:{model:e.form,"label-width":"80px"}},[e.showBase?o("el-form-item",{attrs:{label:"项目名称"}},[o("el-input",{attrs:{disabled:""},model:{value:e.form.projectname,callback:function(t){e.$set(e.form,"projectname",t)},expression:"form.projectname"}})],1):e._e(),e.showBase?o("el-form-item",{attrs:{label:"项目编号"}},[o("el-input",{attrs:{disabled:""},model:{value:e.form.projectno,callback:function(t){e.$set(e.form,"projectno",t)},expression:"form.projectno"}})],1):e._e(),e.showBase?o("el-form-item",{attrs:{label:"项目类型"}},[o("el-select",{attrs:{disabled:""},model:{value:e.form.projecttype,callback:function(t){e.$set(e.form,"projecttype",t)},expression:"form.projecttype"}},e._l(e.projectTypeOptions,(function(e){return o("el-option",{key:e.id,attrs:{label:e.typename,value:e.id}})})),1)],1):e._e(),e.showBase?o("el-form-item",{attrs:{label:"项目阶段"}},[o("el-select",{attrs:{disabled:""},model:{value:e.form.stage,callback:function(t){e.$set(e.form,"stage",t)},expression:"form.stage"}},e._l(e.projectStageOptions,(function(e){return o("el-option",{key:e.projectstage,attrs:{label:e.stagename,value:e.projectstage}})})),1)],1):e._e(),e.showBase?o("el-form-item",{attrs:{label:"项目时间"}},[o("el-col",{attrs:{span:11}},[o("el-date-picker",{staticStyle:{width:"100%"},attrs:{type:"date",placeholder:"选择开始日期","value-format":"yyyy-MM-dd",disabled:""},model:{value:e.form.begindate,callback:function(t){e.$set(e.form,"begindate",t)},expression:"form.begindate"}})],1),o("el-col",{staticClass:"line",attrs:{span:2}},[e._v("-")]),o("el-col",{attrs:{span:11}},[o("el-date-picker",{staticStyle:{width:"100%"},attrs:{type:"date",placeholder:"选择结束日期","value-format":"yyyy-MM-dd",disabled:""},model:{value:e.form.enddate,callback:function(t){e.$set(e.form,"enddate",t)},expression:"form.enddate"}})],1)],1):e._e(),e.showPersonnel?o("el-form-item",{attrs:{label:"项目经理"}},[o("el-select",{attrs:{placeholder:"请选择",disabled:""},model:{value:e.form.projectmanager,callback:function(t){e.$set(e.form,"projectmanager",t)},expression:"form.projectmanager"}},e._l(e.projectManagers,(function(e){return o("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})})),1)],1):e._e(),e.showPersonnel?o("el-form-item",{attrs:{label:"项目成员"}},[o("el-select",{attrs:{placeholder:"请选择",disabled:""},model:{value:e.form.personnel,callback:function(t){e.$set(e.form,"personnel",t)},expression:"form.personnel"}},e._l(e.personnels,(function(e){return o("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})})),1)],1):e._e()],1)],1),o("div",{staticClass:"content-title"},[e._v("项目目录信息")]),o("el-tabs",{attrs:{type:"card"},on:{"tab-click":e.handleClick},model:{value:e.form.stage,callback:function(t){e.$set(e.form,"stage",t)},expression:"form.stage"}},e._l(e.projectStageOptions,(function(t){return o("el-tab-pane",{key:t.projectstage,attrs:{label:t.stagename,name:t.projectstage}},[e._v("\n                "+e._s(t.stagename)+"\n                "),o("v-tree",{attrs:{projectid:e.form.id,projectStage:t.projectstage,isEdit:e.isEdit}})],1)})),1)],1)],1)},s=[],a=(o("7ed4"),o("be3c")),i={name:"projectManagementLookup",components:{vTree:a["a"]},data:function(){return{activeIndex:"1",isEdit:!1,contentTitle:"项目基本信息",showBase:!0,showPersonnel:!1,form:{id:"",projectname:"",projectno:"",projecttype:"",stage:"",begindate:"",enddate:"",projectmanager:"",personnel:""},projectManagers:[{id:"1",name:"测试经理1"},{id:"2",name:"测试经理2"}],personnels:[{id:"1",name:"项目成员1"},{id:"2",name:"项目成员2"}],projectTypeOptions:[],projectStageOptions:[]}},created:function(){this.getInitData(),this.getData()},methods:{handleClick:function(e,t){console.log(e,t)},handleSelect:function(e,t){"1"==e[0]?(this.showBase=!0,this.showPersonnel=!1,this.contentTitle="项目基本信息"):(this.showBase=!1,this.showPersonnel=!0,this.contentTitle="项目人员信息")},getData:function(){var e=this;this.net.get_ProjectInfo({id:this.$route.query.id}).then((function(t){console.log(t),e.loadProjectStage(e.form.projecttype),e.form=t.entity,e.form.projectmanager="1",e.form.personnel="1"}))},getInitData:function(){var e=this;this.net.getListByPage_ProjectTypeInfo({currentPage:1,itemsPerPage:100}).then((function(t){console.log(t),e.form=t.data}))},loadProjectStage:function(e){var t=this;this.projectStageOptions=[],this.net.getListByPage_ProjectStageInfo({currentPage:1,itemsPerPage:100,projecttype:e}).then((function(e){console.log(e),t.projectStageOptions=e.data}))}}},r=i,l=o("2877"),c=Object(l["a"])(r,n,s,!1,null,"4be40524",null);t["default"]=c.exports}}]);