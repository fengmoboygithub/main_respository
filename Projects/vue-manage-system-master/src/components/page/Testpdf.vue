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
          <el-upload 
              v-if="showUpload"
              class="upload-demo"
              drag
              ref="upload"
              :before-upload="beforeAvatarUpload"
              action=""
              accept=".pdf"
              :http-request="submitUpload"
              :multiple="true">
              <i class="el-icon-upload"></i>
              <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
              <div class="el-upload__tip" slot="tip">只能上传pdf文件，且不超过1024M</div>
          </el-upload>
				</el-col>
			</el-row>
        </div>
    </div>
</template>

<script>
import tree from "vue-giant-tree";
import vPdf from '@/components/common/Pdf.vue';
/*const bigData = require("@/mock/big-tree.json");
const testData = require("@/mock/test-tree.json");
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
const dataQueue = [testData.list, simpleData];
*/
export default {
  name: "testPdf",
  components: {
    tree,
	  vPdf
  },
  data() {
    return {
      nodes: [],
      showFile: false, //显示文件预览信息标识
      showDir: false, //显示目录信息标识
      showUpload: false, //显示文件上传录入信息标识
      resourcePath: "http://localhost:8080/file/", //资源目录映射地址
      fileUrl: "", //文件哈希名
      //文件上传录入信息
      uploadFile:{
        projectid:'',
        directoryid:''
      },
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
  created() {
    this.initTree();
  },
  activated() {
    this.initTree();
  },
  /*computed: {
    nodes: function() {
      return dataQueue[this.showIndex];
    }
  },*/
  methods: {
    initTree() {
      //获取目录树数据
      this.net.viewTree({'projectid':'32d2b0ea47c111ea820a507b9d975e7c'}).then(res => {
          console.log(res);
          const respModel = res;
          if(respModel.success && respModel.code === 200){
            this.nodes = respModel.list;
          }
          this.$message.success('数据加载成功');
      }).catch(error => {
          this.$message.error('数据加载失败');
          console.log(error);
      });
    },
    addHoverDom(treeid, treeNode) {
      const item = document.getElementById(`${treeNode.tId}_a`);
      if(item){
        //操作菜单
        if(!item.querySelector('.tree_extra_menu')){
          const ul = document.createElement('ul');
          ul.id = `${treeid}_${treeNode.id}_ul`;
          ul.classList.add('tree_extra_menu','el-menu','el-menu--popup','el-menu--popup-right-start');
          if(treeNode.isParent){
            //上传
            const uploadLi = document.createElement('li');
            uploadLi.tabindex = "-1";
            uploadLi.classList.add('tree_extra_menuitem','el-menu-item');
            uploadLi.innerText = "上传";
            uploadLi.addEventListener('click', (e) => {
              e.stopPropagation();
              this.uploadFileHover(e, treeid, treeNode);
            });
            uploadLi.addEventListener('mouseover', (e) => {
              e.stopPropagation();
              uploadLi.classList.remove('tree_extra_menuitem');
              uploadLi.classList.add('tree_extra_menuitem_hover');
            });
            uploadLi.addEventListener('mouseout', (e) => {
              e.stopPropagation();
              uploadLi.classList.add('tree_extra_menuitem');
              uploadLi.classList.remove('tree_extra_menuitem_hover');
            });
            ul.appendChild(uploadLi);
            item.appendChild(ul);
          }
          //删除
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
          //查看
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
          //this.fileUrl="http://file.dakawengu.com/file/2018-05-29/20180527-tianfeng.pdf";
          this.fileUrl=this.resourcePath+treeNode.hashname;
        } else {
          this.showFile = false;
          this.showDir = true;
        }
      } else {
        this.showFile = false;
        this.showDir = false;
      }
    },
    uploadFileHover: function(evt, treeId, treeNode) {
      // 点击事件
      console.log(evt.type, treeNode);
      if(treeNode) {
        if(treeNode.isParent){
          this.showFile = false;
          this.showDir = false;
          this.showUpload = true;
          this.uploadFile = {
            projectid:treeNode.projectid,
            directoryid:treeNode.id
          };
        }
      } else {
        this.showFile = false;
        this.showDir = false;
        this.showUpload = false;
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
    },
    /*************  文件校验  **********/
    beforeAvatarUpload(file){
        const isLt2M = file.size / 1024 / 1024 < 1024;
        if (!isLt2M) {
            this.$message.error('上传文件大小不能超过 1024MB!');
        }
        return isLt2M;
    },
    /*************  获取底稿信息  **********/
    seeFileNet(param){
      this.net.getManuscriptInfo({id:param.id}).then(res => {
          if (res.code === 200) {
            this.$message.success("底稿信息获取成功");
            this.fileUrl=this.resourcePath+res.entity.hashname;
          } else {
            this.$message.error("底稿信息获取失败");
          }
      }).catch((e)=>{
        this.$message.error("服务器错误，底稿信息获取失败！");
      });
    },
    /*************  重写默认的上传行为  **********/
    submitUpload(param){
        let that = this;
        //file就是当前添加的文件
        var fileObj = param.file;
        // FormData 对象
        var form = new FormData();
        // 文件对象,key是后台接受的参数名称
        form.append("file", fileObj);
        form.append("projectid", this.uploadFile.projectid);
        form.append("directoryid", this.uploadFile.directoryid);
        this.net.addManuscriptInfo(form).then(res => {
            if (res.code === 200) {
              this.$message.success("上传成功");
              this.showFile = true;
              this.showDir = false;
              this.showUpload = false;
              this.fileUrl=this.resourcePath+res.entity.hashname;
              //重新加载树形结构
              this.initTree();
            } else {
              this.$message.error("上传失败");
            }
        }).catch((e)=>{
          this.$message.error("服务器错误，上传文件失败！");
        });
    },
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