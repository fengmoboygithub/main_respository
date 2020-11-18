<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-redpacket_fill"></i> 测试例子
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
			<el-row :gutter="20">
				<el-col :span="8">
					<tree
					  :setting="setting"
					  :nodes="nodes"
					  @onClick="onClick"
					  @onRightClick="onRightClick"
					  @onCheck="onCheck"
					  @onCreated="handleCreated"
					/>
				</el-col>
				<el-col :span="16">
					<v-pdf v-if="showFile" :url="fileUrl" pdfStyle="display: inline-block; width: 100%; height: 100%;border: solid 1px;"></v-pdf>
				</el-col>
			</el-row>
        </div>
    </div>
</template>

<script>
import tree from "vue-giant-tree";
import vPdf from '@/components/common/Pdf.vue';
const bigData = require("@/mock/big-tree.json");
const simpleData = [
  { id: 1, pid: 0, name: "随意勾选 1", open: true },
  { id: 11, pid: 1, name: "随意勾选 1-1", open: true },
  { id: 111, pid: 11, name: "随意勾选 1-1-1" },
  { id: 112, pid: 11, name: "随意勾选 1-1-2" },
  { id: 12, pid: 1, name: "随意勾选 1-2", open: true },
  { id: 121, pid: 12, name: "随意勾选 1-2-1" },
  { id: 122, pid: 12, name: "随意勾选 1-2-2" },
  { id: 2, pid: 0, name: "随意勾选 2", checked: true, open: true },
  { id: 21, pid: 2, name: "随意勾选 2-1" },
  { id: 22, pid: 2, name: "随意勾选 2-2", open: true },
  { id: 221, pid: 22, name: "随意勾选 2-2-1", checked: true },
  { id: 222, pid: 22, name: "随意勾选 2-2-2" },
  { id: 23, pid: 2, name: "随意勾选 2-3" }
];
const dataQueue = [bigData.data, simpleData];

export default {
  name: "testPdf",
  components: {
    tree,
	vPdf
  },
  data() {
    return {
      showIndex: 0,
	  showFile: false,
	  showDir: false,
	  fileUrl: "",
      ztreeObj: null,
      setting: {
        check: {
          enable: true,
		  nocheckInherit: true
        },
        data: {
          simpleData: {
            enable: true,
            pIdKey: "pid"
          }
        },
        view: {
          showIcon: false,
          //addHoverDom: this.addHoverDom,
          removeHoverDom: this.removeHoverDom,
        }
      }
    };
  },
  computed: {
    nodes: function() {
      return dataQueue[this.showIndex];
    }
  },
  methods: {
    addHoverDom(treeid, treeNode) {
      const item = document.getElementById(`${treeNode.tId}_a`);
      if(item){
		//操作菜单
		if(!item.querySelector('.tree_extra_menu')){
			const ul = document.createElement('ul');
			ul.id = `${treeid}_${treeNode.id}_ul`;
			ul.classList.add('tree_extra_menu','el-menu','el-menu--popup','el-menu--popup-right-start');
			const delLi = document.createElement('li');
			delLi.tabindex = "-1";
			delLi.classList.add('tree_extra_menuitem','el-menu-item');
			delLi.innerText = "删除";
			delLi.addEventListener('click', (e) => {
			  e.stopPropagation()
			  this.clickRemove(treeNode)
			});
			delLi.addEventListener('mouseover', (e) => {
			  e.stopPropagation();
			  delLi.classList.remove('tree_extra_menuitem');
			  delLi.classList.add('tree_extra_menuitem_hover');
			});
			delLi.addEventListener('mouseout', (e) => {
			  e.stopPropagation();
			  delLi.classList.add('tree_extra_menuitem');
			  delLi.classList.remove('tree_extra_menuitem_hover');
			});
			ul.appendChild(delLi);
			const otherLi = document.createElement('li');
			otherLi.tabindex = "-1";
			otherLi.classList.add('tree_extra_menuitem','el-menu-item');
			otherLi.innerText = "查看";
			otherLi.addEventListener('click', (e) => {
			  e.stopPropagation();
			  this.onClick(e, treeid, treeNode);
			});
			otherLi.addEventListener('mouseover', (e) => {
			  e.stopPropagation();
			  otherLi.classList.remove('tree_extra_menuitem');
			  otherLi.classList.add('tree_extra_menuitem_hover');
			});
			otherLi.addEventListener('mouseout', (e) => {
			  e.stopPropagation();
			  otherLi.classList.add('tree_extra_menuitem');
			  otherLi.classList.remove('tree_extra_menuitem_hover');
			});
			ul.appendChild(otherLi);
			item.appendChild(ul);
		}        
      }

    },
    removeHoverDom(treeid, treeNode) {
      const item = document.getElementById(`${treeNode.tId}_a`);
      if(item){
        const ul = item.querySelector('.tree_extra_menu');
        if(ul){
          item.removeChild(ul)
        }
      }
    },
    clickRemove(treeNode) {
      console.log('remove', treeNode)
      this.ztreeObj && this.ztreeObj.removeNode(treeNode)
    },
    onClick: function(evt, treeId, treeNode) {
      // 点击事件
      console.log(evt.type, treeNode);
	  if(treeNode) {
		if(!treeNode.isParent){
			this.showFile = true;
			this.showDir = false;
			this.fileUrl="http://file.dakawengu.com/file/2018-05-29/20180527-tianfeng.pdf";
		} else {
			this.showFile = false;
			this.showDir = true;
		}
	  } else {
		this.showFile = false;
		this.showDir = false;
	  }
    },
    onCheck: function(evt, treeId, treeNode) {
      // 选中事件
      console.log(evt.type, treeNode);
    },
	onRightClick(evt, treeId, treeNode) {
      // 点击事件
      console.log(evt.type, treeNode);
	  this.addHoverDom(treeId, treeNode);
    },
    handleCreated: function(ztreeObj) {
      this.ztreeObj = ztreeObj;
      // onCreated 中操作ztreeObj对象展开第一个节点
      ztreeObj.expandNode(ztreeObj.getNodes()[0], true);
    }
  }
};
</script>

<style>
/* 自定义按钮样式 */
.tree_extra_btn{
  display: inline-block;
  padding: 0 3px;
  color: red;
}
.tree_extra_menu{
  background-color: rgb(50, 65, 87);
}
.tree_extra_menuitem{
  padding-left: 20px;
  color: rgb(191, 203, 217);
  background-color: rgb(50, 65, 87);
}
.tree_extra_menuitem_hover{
  padding-left: 20px;
  color: rgb(191, 203, 217);
  background-color: rgb(40, 52, 70) !important;
}
</style>