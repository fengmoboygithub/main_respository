<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator=">>">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-redpacket_fill"></i> {{projectInfo.projectname}}
                </el-breadcrumb-item>
                <el-breadcrumb-item>{{projectInfo.stagename}}</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
			<el-row :gutter="20">
				<el-col :span="12" style="border-right: 1px solid;">
					<!--搜索框相关 start-->
          <el-select
            v-model="value"
            class="me-filter-select"
            filterable
            remote
            reserve-keyword
            placeholder="请输入目录名称或底稿名称"
            @change="handleMdirChange"
            :remote-method="remoteMethod"
            :loading="loading">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
          <!--搜索框相关 end-->
          <tree
            :setting="setting"
            :nodes="nodes"
            style="min-height: 150px;margin-bottom: 100px;"
            @onClick="onClick"
            @onCreated="handleCreated"
					/>
				</el-col>
				<el-col :span="12">
          <!-- 展示文件 -->
          <div v-if="showFile">
            <el-row :gutter="20">
                <el-col :span="18">
                  <div class="content-title">
                    {{fileInfo.docname}}
                    <el-tag type="danger" v-if="fileInfo.status == '11'">未阅</el-tag>
                    <el-tag type="success" v-if="fileInfo.status == '12'">已阅</el-tag>
                  </div>
                </el-col>
                <el-col :span="4">
                </el-col>
                <el-col :span="2">
                </el-col>
              </el-row>
            <!-- <el-row :gutter="24" v-if="showNotFileVersion">
                <el-col :span="8">
                  <el-tag type="success">上传人:{{fileInfo.docname}}</el-tag>
                </el-col>
                <el-col :span="8">
                  <el-tag type="success">修改次数:{{fileInfo.updatecount}}</el-tag>
                </el-col>
                <el-col :span="8">
                  <el-tag type="success">上传时间:{{fileInfo.uploaddate}}</el-tag>
                </el-col>
            </el-row> -->
            <el-row>
              <v-pdf v-if="fileInfo.fileType == '11'" :url="fileInfo.fileUrl" pdfStyle="display: inline-block; width: 100%; height: 100%;border: solid 1px;"></v-pdf>
              <v-audio v-if="fileInfo.fileType == '12'" :url="fileInfo.fileUrl" audioStyle="display: inline-block; width: 100%; height: 100%;border: solid 1px;"></v-audio>
              <v-video v-if="fileInfo.fileType == '13'" :url="fileInfo.fileUrl" videoStyle="display: inline-block; width: 100%; height: 100%;border: solid 1px;"></v-video>
            </el-row>
          </div>
          <!-- 展示目录上传文件 -->
          <div v-if="showDir">
              <el-row :gutter="20">
                <el-col :span="20">
                  <div class="plugins-tips">{{dirInfo.name}}</div>
                </el-col>
                <el-col :span="4">
                </el-col>
              </el-row>
              <div class="content-title">历史意见</div>
              <el-table
                        :data="hisOpinionTableData"
                        border
                        class="table"
                        ref="hisOpinionTable"
                        header-cell-class-name="table-header"
                >
                    <!-- <el-table-column prop="id" label="ID" width="75" align="center"></el-table-column> -->
                    <el-table-column prop="createUser" label="意见人"></el-table-column>
                    <el-table-column prop="createTime" label="时间"></el-table-column>
                    <el-table-column prop="contents" label="意见"></el-table-column>
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

                <div class="content-title">底稿备注信息</div>
                <el-table
                          :data="manuscriptListTableData"
                          border
                          class="table"
                          ref="manuscriptListTable"
                          header-cell-class-name="table-header"
                  >
                      <!-- <el-table-column prop="id" label="ID" width="75" align="center"></el-table-column> -->
                      <el-table-column prop="docname" label="文件名称"></el-table-column>
                      <el-table-column prop="remarks" label="备注"></el-table-column>
                  </el-table>
                  <div class="pagination">
                      <el-pagination
                              background
                              layout="total, prev, pager, next"
                              :current-page="manuscriptList_query.currentPage"
                              :page-size="manuscriptList_query.itemsPerPage"
                              :total="manuscriptList_pageTotal"
                              @current-change="manuscriptList_handlePageChange"
                      ></el-pagination>
                  </div>
                
          </div>
          <!-- 展示目录审核目录 -->
          <div v-if="showExamineDir">
              <el-row :gutter="20">
                <el-col :span="20">
                  <div class="plugins-tips">{{dirInfo.name}}</div>
                </el-col>
                <el-col :span="4">
                </el-col>
              </el-row>
              <div class="content-title">历史意见</div>
              <el-table
                        :data="hisOpinionTableData"
                        border
                        class="table"
                        ref="hisOpinionTable"
                        header-cell-class-name="table-header"
                >
                    <!-- <el-table-column prop="id" label="ID" width="75" align="center"></el-table-column> -->
                    <el-table-column prop="createUser" label="意见人" :formatter="userNameFormatter"></el-table-column>
                    <el-table-column prop="createTime" label="时间" :formatter="dateFormatter"></el-table-column>
                    <el-table-column prop="contents" label="意见"></el-table-column>
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

                <div class="content-title">底稿备注信息</div>
                <el-table
                          :data="manuscriptListTableData"
                          border
                          class="table"
                          ref="manuscriptListTable"
                          header-cell-class-name="table-header"
                  >
                      <!-- <el-table-column prop="id" label="ID" width="75" align="center"></el-table-column> -->
                      <el-table-column prop="docname" label="文件名称"></el-table-column>
                      <el-table-column prop="remarks" label="备注"></el-table-column>
                  </el-table>
                  <div class="pagination">
                      <el-pagination
                              background
                              layout="total, prev, pager, next"
                              :current-page="manuscriptList_query.currentPage"
                              :page-size="manuscriptList_query.itemsPerPage"
                              :total="manuscriptList_pageTotal"
                              @current-change="manuscriptList_handlePageChange"
                      ></el-pagination>
                  </div>
          </div>
				</el-col>
			</el-row>
        </div>
    </div>
</template>

<script>
import tree from "vue-giant-tree";
import vPdf from '@/components/common/Pdf.vue';
import vAudio from '@/components/common/Audio.vue';
import vVideo from '@/components/common/Video.vue';
import config from "@/config";
import { _ } from '@/utils';
export default {
  name: "view",
  components: {
    tree,
    vPdf,
    vAudio,
    vVideo
  },
  data() {
    return {
      /**搜索框相关 start*/
      options: [],
      value: "",
      list: [],
      loading: false,
      /**搜索框相关 end*/
      query: {
          directoryId: '',//目录id
          projectId: '',//项目id
          currentPage: 1,
          itemsPerPage: 10
      },
      manuscriptList_query: {
          directoryid: '',//目录id
          projectid: '',//项目id
          currentPage: 1,
          itemsPerPage: 10
      },
      projectInfo: {
        id: '',//项目ID
        projectname: '',//项目名称
        projectno: '',//项目编号
        projecttype: '',//项目类型
        stage: '',//项目阶段
        stagename: '',//项目阶段名称
      },
      dirInfo: null,
      fileInfo: {
        tId: '',//唯一主键
        id: '',//底稿ID
        docname: '',//文件名称
        userid: '',//上传人
        uploaddate: '',//上传时间
        status: '',//状态
        fileType: '',//文件类型
        fileUrl: '', //文件哈希名
        remarks: "",//备注
      },
      opinion: "",//意见
      hisOpinionTableData: [],
      manuscriptListTableData: [],
      pageTotal: 0,
      manuscriptList_pageTotal: 0,
      nodes: [],
      showUserId: false, //显示文件备注标识
      showFile: false, //显示文件预览信息标识
      showNotFileVersion: false,
      showDir: false, //显示上传目录标识
      showExamineDir: false, //显示审核目录标识
      resourcePath: config.ME_IP_INFO+config.FILE_BASEURL, //资源目录映射地址
      //文件上传录入信息
      uploadFile:{
        projectid:'',
        directoryid:'',
        fileType:'11', //11:PDF 12:音频 13:视频
      },
      //文件类型选项集合
      fileTypeOptions: [
        {
          id: '11',
          name: 'PDF',
          accept: '.pdf',
        },
        {
          id: '12',
          name: '音频',
          accept: '.mp3,.wma,.rm,.wav,.midi,.ape,.flac',
        },
        {
          id: '13',
          name: '视频',
          accept: '.mp4',
        },
      ],
      fileAccept: '.pdf',
      ztreeObj: null,
      setting: {
        check: {
          enable: true,
          nocheckInherit: true,
          chkboxType: { "Y": "s", "N": "ps" }
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
          addDiyDom: this.addDiyDom,
          removeHoverDom: this.removeHoverDom,
        }
      }
    };
  },
  created() {
    this.getProjectInfo();
    this.initTree();
  },
  activated() {
    this.getProjectInfo();
    this.initTree();
  },
  methods: {
    /**搜索框相关 start*/
    remoteMethod(query) {
      if (query !== '') {
        this.loading = true;
        setTimeout(() => {
          this.loading = false;
          this.options = this.list.filter(item => {
            let arr = query.split(" ");
            var falg = false;
            arr.forEach(queryItem => {
              falg = falg || item.label.toLowerCase().indexOf(queryItem.toLowerCase()) > -1;
            });
            return falg;
          });
        }, 200);
      } else {
        this.options = [];
      }
    },
    //选择搜索结果的触发的事件
    handleMdirChange(currentValue){
      var selectId = currentValue;
      if(selectId){
        var node = this.ztreeObj && this.ztreeObj.getNodeByParam("id", selectId, null);
        this.ztreeObj && this.ztreeObj.selectNode(node, false, true);
        this.onClick({'type':'me'}, node.id, node);
      }
    },
    /**搜索框相关 end*/
    // 日期格式化
    // eslint-disable-next-line no-unused-vars
    dateFormatter (row, column) {
      let datetime = row.createTime;
      return datetime;
    },
    // 禁用状态格式化
    // eslint-disable-next-line no-unused-vars
    userNameFormatter(row, column) {
      let userTar = row.createUser;
      if(userTar){
        return decodeURIComponent(userTar);
      } else {
        return '';
      }
    },
    //更改文件类型时触发操作
    handleFileTypeeChange(currentValue){
      let that = this;
      let findIndexVal = _.findIndex(that.fileTypeOptions, function(o) { return o.id == currentValue; });
      let currentObj = that.fileTypeOptions[findIndexVal];
      this.fileAccept = currentObj.accept;
    },
    //获取暂存意见信息
    getOpinionData(){
      this.opinion = "";
      var param = {};
      param.directoryId = this.dirInfo.id;//目录id
      param.projectId = this.dirInfo.projectid;//项目id
      param.opinionType = "0";//意见类型
      this.net.get_DirectoryOpinion(param).then(res => {
          if(res && res.entity){
            this.opinion = res.entity.contents;
          }
      });
    },
    // 获取历史意见的数据
    getHisOpinionTableData() {
      this.query.directoryId = this.dirInfo.id;//目录id
      this.query.projectId = this.dirInfo.projectid;//项目id
      this.net.getListByPage_DirectoryOpinion(this.query).then(res => {
          this.hisOpinionTableData = res.data;
          this.pageTotal = res.recordsTotal || 0;
      });
    },
    // 获取该项目目录下该用户上传的底稿信息
    getManuscriptListTableData() {
      this.manuscriptList_query.directoryid = this.dirInfo.id;//目录id
      this.manuscriptList_query.projectid = this.dirInfo.projectid;//项目id
      this.net.viewManuscriptListByUserId(this.manuscriptList_query).then(res => {
          this.manuscriptListTableData = res.data;
          this.manuscriptList_pageTotal = res.recordsTotal || 0;
      });
    },
    // 分页导航
    handlePageChange(val) {
        this.$set(this.query, 'currentPage', val);
        this.getHisOpinionTableData();
    },
    // 分页导航
    manuscriptList_handlePageChange(val) {
        this.$set(this.manuscriptList_query, 'currentPage', val);
        this.getManuscriptListTableData();
    },
    // 获取项目信息
    getProjectInfo(){
        this.net.get_ProjectInfo({
            id: this.$route.query.id
        }).then(res => {
            this.projectInfo = res.entity;
        // eslint-disable-next-line no-unused-vars
        }).catch(error => {
            this.$message.error('项目信息数据加载失败');
        });
    },
    selectNodeById(selectId) {
      var that_nodes = this.nodes;
      if(selectId){
        //选中节点
        if (that_nodes.length>0) {
          that_nodes.some(node=>{  
              if(node.id==selectId) {
                this.ztreeObj && this.ztreeObj.selectNode(node);
                this.onClick(null, selectId, node);
                return true;
              }
          });
        }
      }
    },
    //获取目录树数据
    initTree() {
      this.showFile=false;//显示文件预览信息标识
      this.showNotFileVersion=false;
      this.showDir=false;//显示上传目录标识
      this.showExamineDir=false;//显示审核目录标识
      this.net.viewTree({
        'projectid': this.$route.query.id,
        'projectStage': this.$route.query.projectStage
        }).then(res => {
          const respModel = res;
          if(respModel.success && respModel.code === 200){
            this.nodes = respModel.list;
            /**搜索框相关 start*/
            this.list = this.nodes.map(item => {
              return { value: `${item.id}`, label: `${item.name}` };
            });
            /**搜索框相关 end*/
          }
          //this.$message.success('数据加载成功');
      // eslint-disable-next-line no-unused-vars
      }).catch(error => {
          this.$message.error('目录树数据加载失败');
      });
    },
    addDiyDom(treeid, treeNode) {
      const node_span = document.getElementById(`${treeNode.tId}_span`);
      const item = document.getElementById(`${treeNode.tId}_a`);
      if(item && !item.querySelector('.node_name_me')){
        node_span.classList.add('node_name_me');
      }
      if(item && !item.querySelector('.tree_extra_btn')){
        const btn = document.createElement('sapn');
        btn.id = `${treeNode.tId}_btn`;
        btn.classList.add('tree_extra_btn');
        var offset_me = 0;
        if(treeNode.type === 'dir'){
          btn.classList.add('tree_extra_btn_'+treeNode.processnode);
          btn.innerText = treeNode.processnodename;
        } else {
          offset_me = 6;
          btn.innerText = treeNode.status;
        }
        var width_me = 110-20*treeNode.level+offset_me;
        btn.style.width = width_me+'px';
        item.appendChild(btn);
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
    onClick: function(evt, treeId, treeNode) {
      // 点击事件
      if(treeNode) {
        if(treeNode.type == 'file'){
          this.fileInfo.tId = treeNode.tId;
          //获取底稿信息
          this.seeFileNet({id: treeNode.id});
          this.showFile = true;
          this.showNotFileVersion = true;
          this.showDir = false;
          this.showExamineDir = false;
        } else {
          var processnodeStr = treeNode.processnode;
          if(processnodeStr){
            this.net.getList_PageProcessnodeMap({pagevalue:'1'}).then(res => {
              if (res.code === 200) {
                var results = _.some(res.list, item => {
                  return item.processnode == processnodeStr;
                });
                if(results){
                  //上传
                  this.uploadFileHover(evt, treeId, treeNode);
                } else {
                  //审核
                  this.exmineFileHover(evt, treeId, treeNode);
                }
              } else {
                this.$message.error("流程映射信息获取失败");
              }
            // eslint-disable-next-line no-unused-vars
            }).catch((e)=>{
              this.$message.error("服务器错误，流程映射信息获取失败！");
            });
          } else {
            // eslint-disable-next-line no-console
            console.log('该目录流程节点为空。。。。');
          }
        }
      } else {
        this.showFile = false;
        this.showNotFileVersion = false;
        this.showDir = false;
        this.showExamineDir = false;
      }
    },
    //显示上传操作的页面
    uploadFileHover: function(evt, treeId, treeNode) {
      // 点击事件
      if(treeNode) {
        if(treeNode.type == 'dir'){
          this.dirInfo = treeNode;
          this.uploadFile.projectid = treeNode.projectid;
          this.uploadFile.directoryid = treeNode.id;
          this.getHisOpinionTableData();
          this.getOpinionData();
          this.getManuscriptListTableData();
          this.showFile = false;
          this.showNotFileVersion = false;
          this.showDir = true;
          this.showExamineDir = false;
        }
      } else {
        this.showFile = false;
        this.showNotFileVersion = false;
        this.showDir = false;
        this.showExamineDir = false;
      }
    },
    //显示审核操作的页面
    exmineFileHover: function(evt, treeId, treeNode) {
      // 点击事件
      if(treeNode) {
        // if(treeNode.isParent){
          this.dirInfo = treeNode;
          this.getHisOpinionTableData();
          this.getOpinionData();
          this.getManuscriptListTableData();
          this.showFile = false;
          this.showNotFileVersion = false;
          this.showDir = false;
          this.showExamineDir = true;
        // }
      } else {
        this.showFile = false;
        this.showNotFileVersion = false;
        this.showDir = false;
        this.showExamineDir = false;
      }
    },
    handleCreated: function(ztreeObj) {
      this.ztreeObj = ztreeObj;
      // onCreated 中操作ztreeObj对象展开第一个节点
      ztreeObj.expandNode(ztreeObj.getNodes()[0], true);
      // ztreeObj.expandAll(true);
    },
    /*************  文件校验  **********/
    beforeAvatarUpload(file){
        const isLt2M = file.size / 1024 / 1024 < config.FILE_UPLOAD_MAX_SIZE;
        if (!isLt2M) {
            this.$message.error('上传文件大小不能超过 '+config.FILE_UPLOAD_MAX_SIZE+'MB!');
        }
        return isLt2M;
    },
    /*************  获取底稿信息  **********/
    seeFileNet(param){
      this.net.get_ManuscriptInfo({id:param.id}).then(res => {
          if (res.code === 200) {
            this.$message.success("底稿信息获取成功");
            this.fileInfo.id = res.entity.id;
            this.fileInfo.fileUrl=this.resourcePath+res.entity.hashname;//网络传输链接
            this.fileInfo.docname=res.entity.docname;//文件名称
            this.fileInfo.uploaddate=res.entity.uploaddate;//上传时间
            this.fileInfo.fileType = res.entity.filetype;//文件类型
            this.fileInfo.userid=res.entity.userid;//上传人
            this.fileInfo.status=res.entity.status;//状态
            if(this.fileInfo.userid == sessionStorage.getItem("userId")){
              this.fileInfo.remarks=res.entity.remarks;//备注
              this.showUserId = true;
            }
          } else {
            this.$message.error("底稿信息获取失败");
          }
      // eslint-disable-next-line no-unused-vars
      }).catch((e)=>{
        this.$message.error("服务器错误，底稿信息获取失败！");
      });
    },
    /*************  预览底稿版本信息  **********/
    showFileVersionInfo(param){
      this.fileInfo.fileUrl = this.resourcePath+param.hashname;
      this.fileInfo.docname = param.docname;
      this.showFile = true;
      this.showNotFileVersion = false;
      this.showDir = false;
      this.showExamineDir = false;
    },
  }
};
</script>

<style>
/* 自定义按钮样式 */
.tree_extra_btn{
  display: inline-block;
  padding: 0 3px;
  width: 110px;
  text-align: right;
  height: 22px;
}
.tree_extra_btn_11{
  color:#fe9903;
}
.tree_extra_btn_12{
  color:#f34336;
}
.tree_extra_btn_21{
  color:#009788;
}
.tree_extra_btn_22{
  color:#fe5722;
}
.tree_extra_btn_29{
  color:#3f51b5;
}
.tree_extra_btn_31{
  color:#2196f3;
}
.tree_extra_btn_32{
  color:#e71e62;
}
.tree_extra_btn_39{
  color:#03a9f3;
}
.tree_extra_btn_41{
  color:#fdbf08;
}
.tree_extra_btn_49{
  color:#00bcd2;
}
.vertical_me{
  position: absolute;
  top: 58px; 
  left: 200px; 
  z-index: 2096;
}
.display_none{
  display: none;
}
.display_block{
  display: block;
}
.node_name_me{
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
  width: 350px;
}
</style>