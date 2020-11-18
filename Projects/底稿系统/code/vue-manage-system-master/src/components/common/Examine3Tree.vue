<template>
    <div ref="allRef">
        <!-- 右键菜单 -->
        <v-rightmenu ref="rightmenu" :list="rightMenuList" :subList="rightMenuSubList"></v-rightmenu>
        <!-- 内核发起操作树形组件 -->
        <div class="container">
          <el-row :gutter="20">
            <el-col :span="12" style="border-right: 1px solid;" ref="treeRef">
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
                @onRightClick="onRightClick"
                @onCreated="handleCreated"
              />
            </el-col>
            <el-col :span="12" ref="rootDirRef">
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
                      <el-button v-if="fileInfo.status == '11' && roles.status_show" type="primary" @click="onManuscriptStatus">标记为已阅</el-button>
                      <el-button v-if="fileInfo.status == '12' && roles.status_show" type="primary" @click="onManuscriptStatus">标记为未阅</el-button>
                    </el-col>
                    <el-col :span="2">

                    </el-col>
                  </el-row>
                <el-row>
                  <v-pdf v-if="fileInfo.fileType == '11'" :url="fileInfo.fileUrl" pdfStyle="display: inline-block; width: 100%; height: 100%;border: solid 1px;"></v-pdf>
                  <v-audio v-if="fileInfo.fileType == '12'" :url="fileInfo.fileUrl" audioStyle="display: inline-block; width: 100%; height: 100%;border: solid 1px;"></v-audio>
                  <v-video v-if="fileInfo.fileType == '13'" :url="fileInfo.fileUrl" videoStyle="display: inline-block; width: 100%; height: 100%;border: solid 1px;"></v-video>
                </el-row>

                <div class="content-title">记录备注</div>
                <el-input 
                  type="textarea"
                  :rows="10"
                  placeholder="请输入备注"
                  v-model="fileInfo.remarks">
                </el-input>
                <el-row>
                    <el-button type="primary" v-if="roles.status_show" @click="onRemarks">保存</el-button>
                </el-row>
              </div>
              <!-- 展示目录上传文件 -->
              <div v-if="showDir">
                  <el-row :gutter="20">
                    <el-col :span="20">
                      <div class="plugins-tips">{{dirInfo.name}}</div>
                    </el-col>
                    <el-col :span="4">
                      <el-button type="primary" @click="onExport">导出意见</el-button>
                    </el-col>
                  </el-row>
                  <div class="content-title">文件上传</div>
                  <div class="form-box" >
                    <el-form ref="file_form" :model="uploadFile" label-width="80px">
                        <el-form-item label="文件类型" prop="fileType">
                            <el-select v-model="uploadFile.fileType" @change="handleFileTypeeChange">
                                <el-option
                                    v-for="item in fileTypeOptions"
                                    :key="item.id"
                                    :label="item.name"
                                    :value="item.id">
                                </el-option>
                            </el-select>
                        </el-form-item>
                    </el-form>
                  </div>
                  <el-upload 
                      class="upload-demo"
                      drag
                      ref="upload"
                      :before-upload="beforeAvatarUpload"
                      action=""
                      :accept="fileAccept"
                      :http-request="submitUpload"
                      :multiple="true">
                      <i class="el-icon-upload"></i>
                      <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
                      <div class="el-upload__tip" slot="tip">上传文件大小，不超过1024M</div>
                  </el-upload>
                  <div class="content-title">历史意见</div>
                  <el-table
                            :data="hisOpinionTableData"
                            border
                            class="table"
                            ref="hisOpinionTable"
                            header-cell-class-name="table-header"
                    >
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

                    <el-row>
                      <el-button type="primary" v-if="roles.status_show" @click="onSubmit">提交</el-button>
                    </el-row>
                    
              </div>
              <!-- 展示目录审核目录 -->
              <div v-if="showExamineDir">
                  <el-row :gutter="20">
                    <el-col :span="20">
                      <div class="plugins-tips">{{dirInfo.name}}</div>
                    </el-col>
                    <el-col :span="4">
                      <el-button type="primary" @click="onExport">导出意见</el-button>
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

              <!-- 展示目录根目录 -->
              <div v-if="showRootDir">
                  <el-row :gutter="20">
                    <el-col :span="20">
                      <div class="plugins-tips">{{dirInfo.name}}</div>
                    </el-col>
                    <el-col :span="4">
                      <el-button type="primary" @click="onExport">导出意见</el-button>
                    </el-col>
                  </el-row>
                  <div class="form-box" v-if="roles.pageid_roles_3 && roles.status_show">
                    <el-form ref="form_1" :model="form" :rules="rules" label-width="80px">
                        <div class="content-title" id="contentTitle">选择内核人员</div>
                        <el-form-item label="内核人员" prop="personnelArr">
                            <el-select v-model="form.personnelArr" multiple placeholder="请选择">
                                <el-option
                                    v-for="item in personnels"
                                    :key="item.id"
                                    :label="item.name"
                                    :value="item.id">
                                </el-option>
                            </el-select>
                        </el-form-item>
                    </el-form>
                </div>
                <el-row>
                  <el-button v-if="roles.pageid_roles_3 && roles.status_show" type="success" plain  @click="onAgree">发起</el-button>
                </el-row>
              </div>
            </el-col>
          </el-row>
        </div>
    </div>
</template>

<script>
// import bus from "@/components/common/bus";
import { _ } from '@/utils';
import tree from "vue-giant-tree";
import vPdf from '@/components/common/Pdf.vue';
import vAudio from '@/components/common/Audio.vue';
import vVideo from '@/components/common/Video.vue';
import vRightmenu from '@/components/common/RightMenu.vue';
import config from "@/config";
export default {
  name: "examine3Tree",
  components: {
    tree,
    vPdf,
    vAudio,
    vVideo,
    vRightmenu
  },
  props: {
    index: {
      type: [Number],
      require: false,
      default: function(){
        return 0;
      }
    },
    projectid: {
      type: String,
      require: true,
      default: function(){
        return {}
      }
    },
    projectStage: {
      type: String,
      require: true,
      default: function(){
        return {}
      }
    },
    status_show:{
      type: Boolean,
      require: false,
      default: function(){
        return true;
      }
    },
    roles: {
      type: Object,
      require: false,
      default: function(){
        return {}
      }
    },
    
  },
  data() {
    return {
      /**搜索框相关 start*/
      options: [],
      value: "",
      list: [],
      loading: false,
      /**搜索框相关 end*/
      rightMenuList: [],
      rightMenuSubList:[],
      form: {
          personnelArr: [],//内核人员数组
      },
      rules: {
          personnelArr: [
              { required: true, message: '请选择内核人员', trigger: 'change' }
          ]
      },
      //内核人员集合
      personnels: [],
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
      showRootDir: false, //显示根目录标识
      showFile: false, //显示文件预览信息标识
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
          addDiyDom: this.addDiyDom,
        }
      }
    };
  },
  mounted() {
    // eslint-disable-next-line no-console
    console.log('我是子组件索引值：'+this.index);
    this.initTree();
    this.getInitData();
    // bus.$on('examine3Tree_load_'+this.index, () => {
    //     this.initTree();
    //     this.getInitData();
    // });
  },
  // activated() {
  //   this.initTree();
  //   this.getInitData();
  // },
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
    //右键菜单显示
    handleShow (evt) {
      this.$refs.rightmenu.handleShow(evt);
    },
    // 获取初始化数据
    getInitData(){
        this.net.getListByPageForUserSys_PersonnelInfo({
            currentPage: 1,
            itemsPerPage: 100
        }).then(res => {
            // 获取内核人员数据
            this.personnels = res.data;
        });
    },
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
    // 历史意见--分页导航
    handlePageChange(val) {
        this.$set(this.query, 'currentPage', val);
        this.getHisOpinionTableData();
    },
    // 底稿备注信息--分页导航
    manuscriptList_handlePageChange(val) {
        this.$set(this.manuscriptList_query, 'currentPage', val);
        this.getManuscriptListTableData();
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
      let treeRef = this.$refs['treeRef'];
      if(!treeRef){
        treeRef = this.$refs['treeRef'];
      }
      let loadingInstance = null;
      if(treeRef){
        loadingInstance = this.$loading({
            target: treeRef.$el,
            background: "rgba(0, 0, 0, 0.8)",
            spinner: "el-icon-loading",
            text: "拼命加载中",
        });
      }
      this.showRootDir = false;//显示根目录标识
      this.showFile = false;//显示文件预览信息标识
      this.showDir = false;//显示上传目录标识
      this.showExamineDir = false;//显示审核目录标识
      this.net.viewTree({
        'projectid': this.$route.query.id,
        'projectStage': this.$route.query.projectStage,
        'nocheck': true,
        }).then(res => {
          if(loadingInstance != null){
            loadingInstance.close();
          }
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
        if(loadingInstance != null){
            loadingInstance.close();
          }
        this.$message.error('目录树数据加载失败');
      });
    },
    //添加每个节点自定义 显示流程状态及底稿已阅未阅状态
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
        if(treeNode.type === 'dir' || treeNode.type === 'root'){
          btn.classList.add('tree_extra_btn_'+treeNode.processnode);
          btn.innerText = treeNode.processnodename;
        } else if(treeNode.type === 'file'){
          offset_me = 6;
          btn.innerText = treeNode.status;
        }
        var width_me = 110-20*treeNode.level+offset_me;
        btn.style.width = width_me+'px';
        item.appendChild(btn);
      }
    },
    //删除操作
    clickRemove(treeNode) {
      // 二次确认删除
      this.$confirm('确定要删除吗？', '提示', {
          type: 'warning'
      })
      .then(() => {
          this.net.del_ManuscriptInfo({id:treeNode.id}).then(res => {
              if (res.code === 200) {
                this.ztreeObj && this.ztreeObj.removeNode(treeNode);
                this.$message.success("底稿信息删除成功");
              } else {
                this.$message.error("底稿信息删除失败");
              }
          // eslint-disable-next-line no-unused-vars
          }).catch((e)=>{
              this.$message.error("服务器错误，底稿信息删除失败！");
          });
      })
      .catch(() => {});
    },
    //左键单击节点事件处理
    onClick: function(evt, treeId, treeNode) {
      // 点击事件
      if(treeNode) {
        if(treeNode.type == 'file'){
          this.fileInfo.tId = treeNode.tId;
          //获取底稿信息
          this.seeFileNet({id: treeNode.id});
          this.showRootDir = false;//显示根目录标识
          this.showFile = true;
          this.showDir = false;
          this.showExamineDir = false;
        } else if(treeNode.type == 'dir' || treeNode.type === 'root') {
          var processnodeStr = treeNode.processnode;
          if(processnodeStr){
            this.net.getList_PageProcessnodeMap({pagevalue:'4'}).then(res => {
              if (res.code === 200) {
                var results = _.some(res.list, item => {
                  return item.processnode == processnodeStr;
                });
                if(results){
                  this.roles.pageid_roles_3 = true;
                } else {
                  this.roles.pageid_roles_3 = false;
                }
                if(treeNode.type == 'dir'){
                  //审核
                  this.exmineFileHover(evt, treeId, treeNode);
                } else if(treeNode.type === 'root'){
                  // eslint-disable-next-line no-console
                  console.log('我是root节点');
                  this.noEnableChk(this.dirInfo);
                  this.enableChk(treeNode);
                  this.dirInfo = treeNode;
                  this.showRootDir = true;//显示根目录标识
                  this.showFile = false;
                  this.showDir = false;
                  this.showExamineDir = false;
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
        this.showRootDir = false;//显示根目录标识
        this.showFile = false;
        this.showDir = false;
        this.showExamineDir = false;
      }
    },
    //显示上传操作的页面
    uploadFileHover: function(evt, treeId, treeNode) {
      // 点击事件
      if(treeNode) {
        if(treeNode.type == 'dir'){
          this.noEnableChk(this.dirInfo);
          this.enableChk(treeNode);
          this.dirInfo = treeNode;
          this.uploadFile.projectid = treeNode.projectid;
          this.uploadFile.directoryid = treeNode.id;
          this.getHisOpinionTableData();
          this.getOpinionData();
          this.getManuscriptListTableData();
          this.showRootDir = false;//显示根目录标识
          this.showFile = false;
          this.showDir = true;
          this.showExamineDir = false;
        }
      } else {
        this.showRootDir = false;//显示根目录标识
        this.showFile = false;
        this.showDir = false;
        this.showExamineDir = false;
      }
    },
    //显示审核操作的页面
    exmineFileHover: function(evt, treeId, treeNode) {
      // 点击事件
      if(treeNode) {
        // if(treeNode.isParent){
          this.noEnableChk(this.dirInfo);
          this.enableChk(treeNode);
          this.dirInfo = treeNode;
          this.getHisOpinionTableData();
          this.getOpinionData();
          this.getManuscriptListTableData();
          this.showRootDir = false;//显示根目录标识
          this.showFile = false;
          this.showDir = false;
          this.showExamineDir = true;
        // }
      } else {
        this.showRootDir = false;//显示根目录标识
        this.showFile = false;
        this.showDir = false;
        this.showExamineDir = false;
      }
    },
    // 右键点击事件
    onRightClick(evt, treeId, treeNode) {
      if(treeNode.type !== 'root') {
        // 选中节点
        this.ztreeObj.selectNode(treeNode, false, true);
        // 添加右键菜单数据
        this.addHoverDom(evt, treeId, treeNode);
        // 显示右键菜单
        this.handleShow(evt);
      }
    },
    // 添加右键菜单数据
    addHoverDom(evt, treeid, treeNode) {
      if(treeNode && this.roles.status_show){
        this.rightMenuList = [];
        this.rightMenuSubList = [];
        //目录
        if(treeNode.type === 'dir'){
          //查看目录信息
          let menuItem = {
            id: treeid+"_1",
            label: '查看目录信息',
            onClick: (evt) => {
              this.onClick(evt, treeid, treeNode)
            },
          };
          this.rightMenuList.push(menuItem);
        } else {
          //文件
          if(treeNode.isdel) {
            //删除
            let menuItem = {
              id: treeid+"_2",
              label: '删除',
              // eslint-disable-next-line no-unused-vars
              onClick: (evt) => {
                this.clickRemove(treeNode)
              },
            };
            this.rightMenuList.push(menuItem);
          }
          let subList = [];
          //获取该底稿的版本信息
          this.net.getListByPage_ManuscriptVersion({
            'currentPage':1,
            'itemsPerPage':10,
            'projectId':treeNode.projectid,
            'docId':treeNode.id
            }).then(res => {
              var i=0;
              res.data.forEach(verInfo=>{  
                  const versionNo = verInfo.version;
                  const versionHashname = verInfo.hashname;
                  let submenuItem = {
                    id: treeid+"_s"+i,
                    label: versionNo,
                    // eslint-disable-next-line no-unused-vars
                    onClick: (evt) => {
                      this.showFileVersionInfo({
                      'hashname':versionHashname,
                      'docname':treeNode.name+'V'+versionNo});
                    },
                  };
                  subList.push(submenuItem);
                  i++;
              });
              if(res.data && res.data.length > 0){
                //历史版本
                let menuItem = {
                  id: treeid+"_3",
                  label: '查看历史版本',
                  subList: subList,
                };
                this.rightMenuSubList.push(menuItem);
              }
          // eslint-disable-next-line no-unused-vars
          }).catch(error => {
          });
        }
      }
    },
    //树控件创建后的回调函数
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
      this.fileInfo.remarks = "";
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
      this.showRootDir = false;//显示根目录标识
      this.showFile = true;
      this.showDir = false;
      this.showExamineDir = false;
    },
    /*************  重写默认的上传行为  **********/
    submitUpload(param){
        //file就是当前添加的文件
        var fileObj = param.file;
        // FormData 对象
        var form = new FormData();
        // 文件对象,key是后台接受的参数名称
        form.append("file", fileObj);
        form.append("projectid", this.uploadFile.projectid);
        form.append("directoryid", this.uploadFile.directoryid);
        form.append("fileType", this.uploadFile.fileType);
        this.net.add_ManuscriptInfo(form).then(res => {
            if (res.code === 200) {
              if(res.success){
                this.$message.success("上传成功");
                this.showRootDir = false;//显示根目录标识
                this.showFile = true;
                this.showDir = false;
                this.fileInfo.fileUrl=this.resourcePath+res.entity.hashname;
                //重新加载树形结构
                this.initTree(res.entity.id);
                this.selectNodeById(res.entity.id);
              } else {
                this.$message.error(res.message);
              }
            } else {
              this.$message.error("上传失败");
            }
        // eslint-disable-next-line no-unused-vars
        }).catch((e)=>{
          this.$message.error("服务器错误，上传文件失败！");
        });
    },
    //统一发起
    optMenthod(operId, msg){
      //调用后台接口流程相关操作 operId==>> 1:发起
      //查找所有目录集合不包括文件及根目录
      var nodes = this.ztreeObj.getNodesByFilter(this.filter);
      //提交的为左侧目录树所有目录（不包含文件及根目录），进行操作时要加提示
      this.$refs['form_1'].validate((valid) => {
          if (valid) {
            //提交的为左侧目录树勾选的目录，进行操作时要加提示，
            //如果当前选中目录不在勾选中的目录中，要给出提示，且不予提交
            var _thart = this;
            var checkedNodes = [];
            nodes.forEach(function(node){  
              var _node = {
                "id":node.id,
                "opinion":_thart.opinion,
                "type":node.type,
                "pid":node.pid,
                "processnode":node.processnode
              };
              checkedNodes.push(_node);
              var _children = node.children;
              if(_children && _children.length > 0){
                _children.forEach(function(childrenNode){
                  if(childrenNode.type == "file"){
                    var _childrenNode = {
                      "id":childrenNode.id,
                      "opinion":"",
                      "type":childrenNode.type,
                      "pid":childrenNode.pid,
                      "processnode":childrenNode.processnode,
                      "hashname":childrenNode.hashname,
                      "docname":childrenNode.docname
                    };
                    checkedNodes.push(_childrenNode);
                  }
                });
              }
            });
            var param = {
              'projectid': this.$route.query.id,
              'projectStage': this.$route.query.projectStage,
              'processnode': this.dirInfo.processnode,
              'operId': operId,
              'treedag': JSON.stringify(checkedNodes),
              'countersignUserIds': JSON.stringify(this.form.personnelArr),//这里新加的参数
            };
            // eslint-disable-next-line no-console
            console.log(checkedNodes);
            if(!_thart.opinion && operId == '2'){
              this.$message.error("退回时意见必须填写。");
            } else {
              let loadingInstance = this.$loading({
                  target: this.$refs['rootDirRef'].$el,
                  background: "rgba(0, 0, 0, 0.8)",
                  spinner: "el-icon-loading",
                  text: "拼命加载中",
              });
              this.net.updateProcess_ProcessNodeInfo(param).then(res => {
                loadingInstance.close();
                if (res.code === 200) {
                  this.$message.success(msg+"成功");
                  this.initTree();
                } else {
                  this.$message.error(res.message);
                }
              // eslint-disable-next-line no-unused-vars
              }).catch((e)=>{
                loadingInstance.close();
                this.$message.error(msg+"失败！");
              });
            }
          } else {
              return false;
          }
      });
    },
    onRemarks(){
      //录入文件备注信息
      this.net.update_ManuscriptInfo({
        id: this.fileInfo.id,
        //status: '12',
        remarks: this.fileInfo.remarks
      }).then(res => {
          if (res.code === 200) {
            this.$message.success("录入文件备注成功");
            this.onClick(null, null, {
              type: 'file',
              id: this.fileInfo.id
            });
          } else {
            this.$message.error("录入文件备注失败");
          }
      // eslint-disable-next-line no-unused-vars
      }).catch((e)=>{
        this.$message.error("录入文件备注失败！");
      });
    },
    onManuscriptStatus(){
      //更改文件状态
      var changeStatus = this.fileInfo.status == '11' ? '12' : '11';
      var changeStatusHtml = this.fileInfo.status == '11' ? '已阅' : '未阅';
      this.net.update_ManuscriptInfo({
        id: this.fileInfo.id,
        status: changeStatus,
      }).then(res => {
          if (res.code === 200) {
            this.$message.success("更改文件状态成功");
            var node = this.ztreeObj.getNodeByTId(this.fileInfo.tId);
            node.status = changeStatus;
            this.ztreeObj.updateNode(node);
            const node_btn = document.getElementById(`${this.fileInfo.tId}_btn`);
            node_btn.innerHTML = changeStatusHtml;
            this.onClick(null, null, {
              type: 'file',
              id: this.fileInfo.id,
              tId: this.fileInfo.tId,
            });
          } else {
            this.$message.error("更改文件状态失败");
          }
      // eslint-disable-next-line no-unused-vars
      }).catch((e)=>{
        this.$message.error("请求失败！");
      });
    },
    onSubmit(){
      //提交
      //判断当前用户是否能进行提交
      this.optMenthod('1', '提交');
    },
    onBack(){
      //退回
      //判断当前用户是否能进行退回
      this.optMenthod('2', '退回');
    },
    onSave(){
      //保存
      //判断当前用户是否能进行保存
      this.optMenthod('3', '保存');
    },
    onAgree(){
      //发起
      //判断当前用户是否能进行发起
      this.optMenthod('1', '发起');
    },
    filter(node) {
        return (node.type == 'dir');
    },
    onExport(){
      //导出意见
    },
    enableChk(treeNode){
      //启用复选框
      if(treeNode) {
        var _thats = this;
        _thats.ztreeObj.setChkDisabled(treeNode, false, false, true);
      }
    },
    noEnableChk(treeNode){
      //禁用复选框
      if(treeNode) {
        var _thats = this;
        _thats.ztreeObj.checkNode(treeNode, false, true);
        _thats.ztreeObj.setChkDisabled(treeNode, true, false, true);
      }
    }
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
  color:#02ff17;
}
.tree_extra_btn_45{
  color:#fccd4a;
}
.tree_extra_btn_47{
  color:#00c3ff;
}
.tree_extra_btn_49{
  color:#6200d2;
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