<template>
  <div class="page">
    <div :id="pageId" class="graph-container" style="position: relative;z-index: 1;"></div>
  </div>
</template>


<script>
import G6 from "@antv/g6/build/g6";
import { initBehavors } from "@/behavior";
import Grid from "@antv/g6/build/grid";
export default {
  data() {
    return {
      pageId: "graph-container",
      graph: null
    };
  },
  props: {
    height: {
      type: Number,
      default: 0
    },
    width: {
      type: Number,
      default: 0
    },
    data: {
      type: Object,
      default: () => {}
    }
  },
  created() {
    initBehavors();
  },
  mounted() {
    this.$nextTick(() => {
      this.init();
    });
  },
  methods: {
    init() {
      const height =  this.height - 42 
      const width =  this.width - 400

      this.graph = new G6.Graph({
        container: "graph-container",
        height: height,
        width: width,
        modes: {
          // 支持的 behavior
          default: [
            "drag-canvas",
            "zoom-canvas",
            "hover-node",
            "select-node",
            "hover-edge",
            "keyboard",
            "customer-events",
            "add-menu"
          ],
          mulitSelect: ["mulit-select"],
          addEdge: ["add-edge"],
          moveNode:[ "drag-item"]
        }
      });
      const { editor, command } = this.$parent;
      this.graph.addPlugin(new Grid());
      editor.emit("afterAddPage", { graph: this.graph, command });

      this.readData();
    },
    readData() {
      let data = this.data;
      if(!data){
        data = {"nodes":[{"id":"node1","name":"录入","label":"录入","changeStageFlag":"1","changeNodeType":"1","size":["170","34"],"type":"node","x":112,"y":143,"shape":"customNode","color":"#1890ff","image":"static/img/icon1.62158737.svg","stateImage":"static/img/ok.463ab0e4.svg","inPoints":[[0,0.5]],"outPoints":[[1,0.5]],"isDoingStart":true,"offsetX":55,"offsetY":15},{"id":"node2","name":"项目组审核","label":"项目组审核","changeStageFlag":"1","changeNodeType":"2","size":["170","34"],"type":"node","x":386,"y":144,"shape":"customNode","color":"#1890ff","image":"static/img/icon1.62158737.svg","stateImage":"static/img/ok.463ab0e4.svg","inPoints":[[0,0.5]],"outPoints":[[1,0.4],[1,0.6]],"offsetX":32,"offsetY":19},{"id":"node3","name":"质控验收","label":"质控验收","changeStageFlag":"1","changeNodeType":"2","size":["170","34"],"type":"node","x":645,"y":148,"shape":"customNode","color":"#1890ff","image":"static/img/icon1.62158737.svg","stateImage":"static/img/ok.463ab0e4.svg","inPoints":[[0,0.5]],"outPoints":[[1,0.4],[1,0.6]],"offsetX":50,"offsetY":19},{"id":"node4","name":"内核审议","label":"内核审议","changeStageFlag":"1","changeNodeType":"3","size":["170","34"],"type":"node","x":895,"y":151,"shape":"customNode","color":"#1890ff","image":"static/img/icon1.62158737.svg","stateImage":"static/img/ok.463ab0e4.svg","inPoints":[[0,0.5]],"outPoints":[[1,0.5]],"isDoingEnd":true,"offsetX":88,"offsetY":14}],"edges":[{"id":"edge105","source":"node1","target":"node2","sourceId":"node1","targetId":"node2","start":{"x":0,"y":17},"end":{"x":0,"y":-17},"shape":"customEdge","color":"#b8c3ce","unSelectColor":"#b8c3ce","selectColor":"#6ab7ff","type":"edge","startPoint":{"x":197.5,"y":143.31204379562044},"endPoint":{"x":300.5,"y":143.68795620437956}},{"id":"edge152","source":"node2","target":"node3","sourceId":"node2","targetId":"node3","start":{"x":17,"y":17},"end":{"x":0,"y":-17},"shape":"customEdge","color":"#b8c3ce","unSelectColor":"#b8c3ce","selectColor":"#6ab7ff","type":"edge","startPoint":{"x":471.5,"y":145.32046332046332},"endPoint":{"x":559.5,"y":146.67953667953668}},{"id":"edge192","source":"node3","target":"node4","sourceId":"node3","targetId":"node4","start":{"x":17,"y":17},"end":{"x":0,"y":-17},"shape":"customEdge","color":"#b8c3ce","unSelectColor":"#b8c3ce","selectColor":"#6ab7ff","type":"edge","startPoint":{"x":730.5,"y":149.026},"endPoint":{"x":809.5,"y":149.974}},{"id":"edge246","source":"node4","target":"node3","sourceId":"node4","targetId":"node3","start":{"x":0,"y":17},"end":{"x":0,"y":-17},"shape":"customEdge","color":"#FF0000","unSelectColor":"#FF0000","selectColor":"#6ab7ff","type":"edge","startPoint":{"x":809.5,"y":149.974},"endPoint":{"x":730.5,"y":149.026}},{"id":"edge294","source":"node3","target":"node2","sourceId":"node3","targetId":"node2","start":{"x":-17,"y":17},"end":{"x":0,"y":-17},"shape":"customEdge","color":"#FF0000","unSelectColor":"#FF0000","selectColor":"#6ab7ff","type":"edge","startPoint":{"x":559.5,"y":146.67953667953668},"endPoint":{"x":471.5,"y":145.32046332046332}},{"id":"edge327","source":"node2","target":"node1","sourceId":"node2","targetId":"node1","start":{"x":-17,"y":17},"end":{"x":0,"y":-17},"shape":"customEdge","color":"#FF0000","unSelectColor":"#FF0000","selectColor":"#6ab7ff","type":"edge","startPoint":{"x":300.5,"y":143.68795620437956},"endPoint":{"x":197.5,"y":143.31204379562044}}],"groups":[]};
      }
      if (data) {
        // eslint-disable-next-line no-console
        //console.log(data);
        this.graph.read(data);
      }
    }
  }
};
</script>

<style scoped>
.page{
  margin-left:200px;
  margin-right: 200px;
}
</style>