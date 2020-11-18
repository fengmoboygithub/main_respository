<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator=">>">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-redpacket_fill"></i> {{projectInfo.projectname}}
                </el-breadcrumb-item>
                <!-- <el-breadcrumb-item>{{projectInfo.stagename}}</el-breadcrumb-item> -->
            </el-breadcrumb>
        </div>
        <div class="container">
          <el-row :gutter="20">
            <el-col :span="24">
                <el-date-picker
                  type="datetime"
                  placeholder="选择日期时间"
                  v-model="reptdatetime"
                  value-format="yyyy-MM-dd HH:mm:ss"
                  style="width: 100%;"
                ></el-date-picker>
            </el-col>
          </el-row>
          

			<el-row :gutter="20">
				<el-col :span="12" >
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
            <div class="content-title">{{fileInfo.hashname}}</div>
          </div>
          <!-- 展示目录上传文件 -->
          <div v-if="showDir">
              <el-row :gutter="20">
                <el-col :span="24">
                  <div class="plugins-tips">{{dirInfo.name}}</div>
                </el-col>
              </el-row>
              <el-row>
                <el-button type="primary" @click="onExport">导出</el-button>
              </el-row>
          </div>
				</el-col>
			</el-row>
        </div>
    </div>
</template>

<script>
import tree from "vue-giant-tree";
import config from "@/config";
import qs from "qs";
export default {
  name: "upload",
  components: {
    tree
  },
  data() {
    return {
      query: {
          directoryId: '',//目录id
          projectId: '',//项目id
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
      reptdatetime: "",//导出报送目录日期时间
      dirInfo: null,
      fileInfo: {
        hashname: '',//文件哈希名
      },
      opinion: "",//意见
      hisOpinionTableData: [],
      pageTotal: 0,
      nodes: [],
      showFile: false, //显示文件预览信息标识
      showDir: false, //显示上传目录标识
      resourcePath: config.ME_IP_INFO+config.FILE_BASEURL, //资源目录映射地址
      //文件上传录入信息
      uploadFile:{
        projectid:'',
        directoryid:''
      },
      ztreeObj: null,
      setting: {
        check: {
          enable: false,
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
          removeHoverDom: this.removeHoverDom,
          addDiyDom: this.addDiyDom,
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
    //获取目录树数据
    // eslint-disable-next-line no-unused-vars
    initTree(reptDatetime) {
      //this.ulList = [];
      this.net.viewTreeForExport({
        'projectid': this.$route.query.id,
        //'projectStage': this.$route.query.projectStage,
        'reptDate': this.reptdatetime
        }).then(res => {
          const respModel = res;
          if(respModel.success && respModel.code === 200){
            this.nodes = respModel.list;
          }
          //this.$message.success('数据加载成功');
      // eslint-disable-next-line no-unused-vars
      }).catch(error => {
          this.$message.error('目录树数据加载失败');
      });
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
    addDiyDom(treeid, treeNode) {
      const node_span = document.getElementById(`${treeNode.tId}_span`);
      const item = document.getElementById(`${treeNode.tId}_a`);
      if(item && !item.querySelector('.node_name_me')){
        node_span.classList.add('node_name_me');
        if(treeNode.type == 'file'){
          node_span.innerText = treeNode.hashname;
        }
      }
    },
    onClick: function(evt, treeId, treeNode) {
      // 点击事件
      if(treeNode) {
        if(treeNode.type == 'file'){
          //获取底稿信息
          this.seeFileNet({id: treeNode.id});
          this.showFile = true;
          this.showDir = false;
        } else {
          this.dirInfo = treeNode;
          this.showFile = false;
          this.showDir = true;
        }
      } else {
        this.showFile = false;
        this.showDir = false;
      }
    },
    handleCreated: function(ztreeObj) {
      this.ztreeObj = ztreeObj;
      // onCreated 中操作ztreeObj对象展开第一个节点
      ztreeObj.expandNode(ztreeObj.getNodes()[0], true);
      // ztreeObj.expandAll(true);
    },
    /*************  获取底稿信息  **********/
    seeFileNet(param){
      this.net.get_ManuscriptInfo({id:param.id}).then(res => {
          if (res.code === 200) {
            this.$message.success("底稿信息获取成功");
            this.fileInfo.hashname=res.entity.hashname;//文件哈希名
          } else {
            this.$message.error("底稿信息获取失败");
          }
      // eslint-disable-next-line no-unused-vars
      }).catch((e)=>{
        this.$message.error("服务器错误，底稿信息获取失败！");
      });
    },
    //下载文件
    executeDownload(url) {
        if (!url) {
            return
        }
        let link = document.createElement('a');
        link.style.display = 'none';
        link.href = url;
        document.body.appendChild(link);
        link.click();
        document.body.removeChild(link);
    },
    // eslint-disable-next-line no-unused-vars
    optMenthod(msg){
      var param = {
        'projectid': this.$route.query.id,
        'projectStage': this.$route.query.projectStage,
        'directoryid': this.dirInfo.id
      };
      var url = config.ME_IP_INFO+config.API_BASEURL+config.EXPORT_URL;
      var qsParam = qs.stringify(param);
      url += "?"+qsParam;
      this.executeDownload(url);
    },
    onExport(){
      //导出
      this.optMenthod('导出');
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
.node_name_me{
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
  width: 350px;
}
</style>