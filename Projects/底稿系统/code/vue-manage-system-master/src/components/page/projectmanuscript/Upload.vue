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
        <v-upload-tree :projectid="$route.query.id" :projectStage="$route.query.projectStage" :status_show="status_show"></v-upload-tree>
        <!-- <el-tabs v-model="projectInfo.stage" tab-position="left" @tab-click="handleClick">
                <el-tab-pane
                    v-for="(item, index) in projectStageOptions"
                    :key="item.projectstage"
                    :label="item.stagename"
                    :name="item.projectstage"
                    :lazy=true
                    >
                    {{item.stagename}}
                    <v-tree :index="index" :projectid="$route.query.id" :projectStage="item.projectstage" :status_show="status_show"></v-tree>
                </el-tab-pane>
            </el-tabs> -->
    </div>
</template>

<script>
import vUploadTree from '@/components/common/UploadTree.vue';
export default {
  name: "upload",
  components: {
    vUploadTree
  },
  data() {
    return {
      status_show: true,//正常状态显示标识 若是非正常状态则为false
      projectInfo: {
        id: '',//项目ID
        projectname: '',//项目名称
        projectno: '',//项目编号
        projecttype: '',//项目类型
        stage: '',//项目阶段
        stagename: '',//项目阶段名称
      },
      //项目阶段选项集合
      // projectStageOptions: [],
    };
  },
  created() {
    this.getProjectInfo();
  },
  activated() {
    this.getProjectInfo();
  },
  methods: {
    //通过项目类型查询阶段信息
    // loadProjectStage(currentValue){
    //     this.projectStageOptions = [];
    //     this.net.getListByPage_ProjectStageInfo({
    //         currentPage: 1,
    //         itemsPerPage: 100,
    //         projecttype: currentValue
    //     }).then(res => {
    //         this.projectStageOptions = res.data;
    //     });
    // },
    // 获取项目信息
    getProjectInfo(){
        this.net.get_ProjectInfo({
            id: this.$route.query.id
        }).then(res => {
            this.projectInfo = res.entity;
            // this.loadProjectStage(res.entity.projecttype);
            if(res.entity.status != '11'){
              this.status_show = false;
            }
        // eslint-disable-next-line no-unused-vars
        }).catch(error => {
            this.$message.error('项目信息数据加载失败');
        });
    },
    // handleClick(tab, event) {
    //     // console.log(tab, event);
    //     console.log(tab.index);
    //     bus.$emit('uploadTree_load_'+tab.index);
    // },
  }
};
</script>