<template>
  <div class="detailpannel">
    <div>
      <div v-if="status=='node-selected'" class="pannel" id="node_detailpannel">
        <div class="pannel-title">模型详情</div>
        <div class="block-container">
          <el-row :gutter="10">
            <el-col :span="8">名称</el-col>
            <el-col :span="16">
              <el-input v-model="node.label" @change="handleChangeName" />
            </el-col>
            <el-col :span="8">阶段标识</el-col>
            <el-col :span="16">
              <el-select v-model="node.changeStageFlag" @change="handleStageFlagChange">
                  <el-option v-for="(item, index) in changeStagelist" :value="item.code" :label="item.label" :key="index"></el-option>
              </el-select>
            </el-col>
            <el-col :span="8">节点状态</el-col>
            <el-col :span="16">
              <el-select v-model="node.changeNodeType" @change="handleNodeTypeChange">
                  <el-option v-for="(item, index) in changeNodeTypelist" :value="item.code" :label="item.label" :disabled="item.disabled" :key="index"></el-option>
              </el-select>
            </el-col>
          </el-row>
        </div>
      </div>
      <div v-if="status==='canvas-selected'" class="pannel" id="canvas_detailpannel">
        <div class="pannel-title">画布</div>
        <div class="block-container">
          <el-checkbox v-model="showGrid" @change="changeGridState">网格对齐</el-checkbox>
        </div>
      </div>
      <!-- <div v-if="status==='group-selected'" class="pannel" id="node_detailpannel">
        <div class="pannel-title">群组详情</div>
        <div class="block-container">
          <div class="p">
            名称：
            <el-input v-model="name" />
          </div>
          <div class="p">
            任意属性：
            <el-input v-model="color" />
          </div>
        </div>
      </div>
      -->
    </div>
  </div>
</template>

<script>
import eventBus from "@/utils/eventBus";
import Grid from "@antv/g6/build/grid";
export default {
  data() {
    return {
      status: "canvas-selected",
      showGrid: true,
      page: {},
      graph: {},
      item: {},
      node: {},
      changeStagelist: [
        {
          code: "1",
          label: "否"
        },
        {
          code: "4",
          label: "是"
        }
      ],
      changeNodeTypelist: [
        {
          code: "1",
          label: "开始节点",
          disabled: true
        },
        {
          code: "2",
          label: "普通节点"
        },
        {
          code: "3",
          label: "结束节点"
        }        
      ],
      grid: null
    };
  },
  created() {
    this.init();
    this.bindEvent();
  },
  methods: {
    init() {
    },
    bindEvent() {
      let self = this;
      eventBus.$on("afterAddPage", page => {
        self.page = page;
        self.graph = self.page.graph;
        eventBus.$on("nodeselectchange", item => {
          if (item.select === true && item.target.getType() === "node") {
            self.status = "node-selected";
            self.item = item.target;
            self.node = item.target.getModel();
          } else {
            self.status = "canvas-selected";
            self.item = null;
            self.node = null;
          }
        });
      });
    },
    //变更名称触发操作
    handleChangeName(currentValue) {
      const model = {
        label: currentValue
      };

      this.graph.update(this.item, model);
    },
    //变更阶段标识触发操作
    handleStageFlagChange(currentValue) {
      const model = {
        changeStageFlag: currentValue
      };

      this.graph.update(this.item, model);
    },
    //变更节点类型触发操作
    handleNodeTypeChange(currentValue){
      const model = {
        changeNodeType: currentValue
      };
      if(currentValue == "1"){
        //开始节点
        model.inPoints = [[0, 0.5]];
        model.outPoints = [[1, 0.5]];
        model.isDoingStart = true;
        model.isDoingEnd = false;
      } else if(currentValue == "2"){
        //普通节点
        model.inPoints = [[0, 0.5]];
        model.outPoints = [[1, 0.4], [1, 0.6]];
        model.isDoingStart = false;
        model.isDoingEnd = false;
      } else if(currentValue == "3"){
        //结束节点
        model.inPoints = [[0, 0.5]];
        model.outPoints = [[1, 0.5]];
        model.isDoingStart = false;
        model.isDoingEnd = true;
      }
      this.graph.update(this.item, model);
    },
    changeGridState(value) {
      if (value) {
        this.grid = new Grid();
        this.graph.addPlugin(this.grid);
      } else {
        if(this.grid){
          this.graph.removePlugin(this.grid);
        }
      }
    }
  }
};
</script>

<style scoped>
.detailpannel {
  height: 100%;
  position: absolute;
  right: 0px;
  z-index: 2;
  background: #f7f9fb;
  width: 200px;
  border-left: 1px solid #e6e9ed;
}
.detailpannel .block-container {
  padding: 16px 8px;
}
.block-container .el-col {
  height: 28px;
  display: flex;
  align-items: center;
  margin-bottom: 10px;
}
.pannel-title {
  height: 32px;
  border-top: 1px solid #dce3e8;
  border-bottom: 1px solid #dce3e8;
  background: #ebeef2;
  color: #000;
  line-height: 28px;
  padding-left: 12px;
}
</style>
