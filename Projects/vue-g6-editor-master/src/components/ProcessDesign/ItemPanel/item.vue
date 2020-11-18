<template>
  <ul>
    <li
      v-for="(item,index) in list"
      :key="index"
      class="getItem"
      :data-shape="item.shape"
      :data-type="item.type"
      :data-size="item.size"
      draggable
      @dragstart="handleDragstart"
      @dragend="handleDragEnd($event,item)"
    >
      <span class="pannel-type-icon" :style="{background:'url('+item.image+')'}"></span>
      {{item.name}}
    </li>
  </ul>
</template>

<script>
import eventBus from "@/utils/eventBus";
import okSvg from "@/assets/icons/ok.svg";
// import bgImg from "@/assets/bg.jpg";
export default {
  data() {
    return {
      page: null,
      command: null,
      offsetX: 0,
      offsetY: 0,
      list: [

        {
          id: "node1",
          name: "录入",
          label: "录入",
          changeStageFlag: "1", //变更阶段标识 1为否 4为是
          changeNodeType: "1", //节点状态  1为开始节点 2为普通节点 3为结束节点
          size: "170*34",
          type: "node",
          x: 0,
          y: 0,
          shape: "customNode",
          color: "#1890ff",
          image:
            "https://gw.alipayobjects.com/zos/rmsportal/czNEJAmyDpclFaSucYWB.svg",
          stateImage: okSvg,
          inPoints: [[0, 0.5]],
          outPoints: [[1, 0.5]],
          isDoingStart: true
        },

        {
          id: "node2",
          name: "项目组审核",
          label: "项目组审核",
          changeStageFlag: "1", //变更阶段标识 1为否 4为是
          changeNodeType: "2", //节点状态  1为开始节点 2为普通节点 3为结束节点
          size: "170*34",
          type: "node",
          x: 0,
          y: 0,
          shape: "customNode",
          color: "#1890ff",
          image:
            "https://gw.alipayobjects.com/zos/rmsportal/czNEJAmyDpclFaSucYWB.svg",
          stateImage: okSvg,
          inPoints: [[0, 0.5]],
          outPoints: [[1, 0.4], [1, 0.6]]
        },

        {
          id: "node3",
          name: "质控验收",
          label: "质控验收",
          changeStageFlag: "1", //变更阶段标识 1为否 4为是
          changeNodeType: "2", //节点状态  1为开始节点 2为普通节点 3为结束节点
          size: "170*34",
          type: "node",
          x: 0,
          y: 0,
          shape: "customNode",
          color: "#1890ff",
          image:
            "https://gw.alipayobjects.com/zos/rmsportal/czNEJAmyDpclFaSucYWB.svg",
          stateImage: okSvg,
          inPoints: [[0, 0.5]],
          outPoints: [[1, 0.4], [1, 0.6]]
        },
        
        {
          id: "node4",
          name: "内核审议",
          label: "内核审议",
          changeStageFlag: "1", //变更阶段标识 1为否 4为是
          changeNodeType: "3", //节点状态  1为开始节点 2为普通节点 3为结束节点
          size: "170*34",
          type: "node",
          x: 0,
          y: 0,
          shape: "customNode",
          color: "#1890ff",
          image:
            "https://gw.alipayobjects.com/zos/rmsportal/czNEJAmyDpclFaSucYWB.svg",
          stateImage: okSvg,
          inPoints: [[0, 0.5]],
          outPoints: [[1, 0.5]],
          // outPoints: [],
          isDoingEnd: true
        }
      ]
    };
  },
  created() {
    this.bindEvent();
  },
  methods: {
    handleDragstart(e) {
      this.offsetX = e.offsetX;
      this.offsetY = e.offsetY;
    },
    handleDragEnd(e, item) {
      let data = {};
      Object.assign(data, item);
      data.offsetX = this.offsetX;
      data.offsetY = this.offsetY;
      if (this.page) {
        const graph = this.page.graph;
        // const size = e.target.dataset.size.split("*");
        // eslint-disable-next-line no-console
        console.log('事件x/y坐标分别为:',e.screenX, e.screenY-100)
        const point = graph.getPointByClient(e.screenX, e.screenY-100);
        // eslint-disable-next-line no-console
        console.log('视口x/y坐标分别为:', point.x, point.y)
        data.x = point.x;
        data.y = point.y;
        data.size = item.size.split("*");
        data.type = "node";
        const nodeId = graph.findById(data.id);
        if(!nodeId){
          //不存在
          this.command.executeCommand("add", [data]);
        } else {
          this.$message.error(`已存在该节点，不要重复拖拽。`);
        }
      }
    },
    bindEvent() {
      let self = this;
      eventBus.$on("afterAddPage", page => {
        self.page = page;
        self.command = page.command;
      });
    }
  }
};
</script>

<style scoped>
.itempannel {
  height: 100%;
  position: absolute;
  left: 0px;
  z-index: 2;
  background: #f7f9fb;
  width: 200px;
  padding-top: 8px;
  border-right: 1px solid #e6e9ed;
}
.itempannel ul {
  padding: 0px;
  padding-left: 16px;
}
.itempannel li {
  color: rgba(0, 0, 0, 0.65);
  border-radius: 4px;
  width: 160px;
  height: 28px;
  line-height: 26px;
  padding-left: 8px;
  border: 1px solid rgba(0, 0, 0, 0);
  list-style-type: none;
}
.itempannel li:hover {
  background: white;
  border: 1px solid #ced4d9;
  cursor: move;
}

.itempannel .pannel-type-icon {
  width: 16px;
  height: 16px;
  display: inline-block;
  vertical-align: middle;
  margin-right: 8px;
}
</style>