<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator=">>">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-redpacket_fill"></i> {{projectInfo.projectname}}--内核发起
                </el-breadcrumb-item>
                <el-breadcrumb-item>{{projectInfo.stagename}}</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <v-examine3-tree :projectid="$route.query.id" :projectStage="$route.query.projectStage" :roles="roles"></v-examine3-tree>
        <!-- <el-tabs v-model="projectInfo.stage" tab-position="left" @tab-click="handleClick">
                <el-tab-pane
                    v-for="(item, index) in projectStageOptions"
                    :key="item.projectstage"
                    :label="item.stagename"
                    :name="item.projectstage"
                    :lazy=true
                    >
                    {{item.stagename}}
                    <v-tree :index="index" :projectid="$route.query.id" :projectStage="item.projectstage" :roles="roles"></v-tree>
                </el-tab-pane>
            </el-tabs> -->
    </div>
</template>

<script>
import vExamine3Tree from '@/components/common/Examine3Tree.vue';
export default {
  name: "exmine3",
  components: {
    vExamine3Tree
  },
  data() {
    return {
      roles: {
          pageid_roles_3: false,//页面对应流程节点值显示权限
          status_show: true,//正常状态显示标识 若是非正常状态则为false
      },
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
              this.roles.status_show = false;
            }
        // eslint-disable-next-line no-unused-vars
        }).catch(error => {
            this.$message.error('项目信息数据加载失败');
        });
    },
    // handleClick(tab, event) {
    //     // console.log(tab, event);
    //     console.log(tab.index);
    //     bus.$emit('examine3Tree_load_'+tab.index);
    // },
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