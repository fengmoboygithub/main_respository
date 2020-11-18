<template>
<div class="pdf" ref="testPdf" id="testPdf">  
	<el-row :gutter="24" id="optinfo">
		<el-col :span="8">
      &nbsp;
			<!-- <el-button type="primary" @click="clock">顺时针</el-button> -->
			<!-- <el-button type="primary" @click="counterClock">逆时针</el-button> -->
		</el-col>
		<el-col :span="3">
      <el-button type="primary" @click="prePage">上一页</el-button>
		</el-col>
    <el-col :span="3">
			<el-button type="primary" @click="nextPage">下一页</el-button>
		</el-col>
    <el-col :span="2">
      <el-button type="primary" @click="handleFullScreen">{{fullscreen?`取消全屏`:`全屏`}}</el-button>
		</el-col>
		<el-col :span="8">
      &nbsp;
			<!-- <el-button type="primary" @click="pdfPrintAll">全部打印</el-button> -->
			<!-- <el-button type="primary" @click="pdfPrint">部分打印</el-button> -->
		</el-col>
	</el-row>
	<el-row :gutter="24" id="loadinfo">
		<el-col :span="8">
      &nbsp;
		</el-col>
		<el-col :span="11">
      &nbsp;
		</el-col>
		<el-col :span="2">
			<!-- <el-tag type="success">进度：{{loadedRatio}}</el-tag> -->
			<el-tag type="primary">{{pageNum}}/{{pageTotalNum}}</el-tag>
		</el-col>
    <el-col :span="2">
			<el-tag type="primary">页面加载成功: {{curPageNum}}</el-tag>
		</el-col>
    <el-col :span="1">
      &nbsp;
		</el-col>
	</el-row>
	<el-row :gutter="24">
		<el-col :span="24">
			<pdf 
				ref="pdf"
        id="pdf_id"
				:src="url"
				:page="pageNum"
				:rotate="pageRotate"
				:style="pdfStyle"
				@password="password"
				@progress="loadedRatio = $event"
				@page-loaded="pageLoaded($event)"
				@num-pages="pageTotalNum=$event" 
				@error="pdfError($event)"
				@link-clicked="page = $event">
      </pdf>
		</el-col>
	</el-row>
</div>
</template>
<script>
import pdf from 'vue-pdf'
export default {
  name: 'Pdf',
  components:{
      pdf
  },
  props: {
    url: {
      type: String,
      require: true,
      default: function(){
        return {}
      }
    },
	pdfStyle: {
      type: String,
      require: false,
      default: function(){
        return {}
      }
    },
  },
  data(){
      return {
          pageNum:1,
          pageTotalNum:1,
          pageRotate:0,
          // 加载进度
          loadedRatio:0,
          curPageNum:0,
          dialogVisible:true,
          fullscreen: false,
      }
  },
  mounted: function() {
  },
  methods: {
    prePage(){
      var p = this.pageNum
      p = p>1?p-1:this.pageTotalNum
      this.pageNum = p
    },
    nextPage(){
      var p = this.pageNum
      p = p<this.pageTotalNum?p+1:1
      this.pageNum = p
    },
    clock(){
      this.pageRotate += 90 
    },
    counterClock(){
      this.pageRotate -= 90 
    },
    // eslint-disable-next-line no-unused-vars
    password(updatePassword, reason) {
      updatePassword(prompt('password is "123456"'))
    },
    pageLoaded(e){
      this.curPageNum = e
    },
    pdfError(error){
      // eslint-disable-next-line no-console
      console.error(error)
    },
    pdfPrintAll(){
      this.$refs.pdf.print()
    },
    pdfPrint(){
      this.$refs.pdf.print(100,[1,2])
    },
    // 全屏事件
    handleFullScreen() {
        //let element = document.documentElement;
        let element = document.getElementById('testPdf');
        // let element = this.$refs['pdf'];
        if (this.fullscreen) {
            if (document.exitFullscreen) {
                document.exitFullscreen();
            } else if (document.webkitCancelFullScreen) {
                document.webkitCancelFullScreen();
            } else if (document.mozCancelFullScreen) {
                document.mozCancelFullScreen();
            } else if (document.msExitFullscreen) {
                document.msExitFullscreen();
            }
        } else {
            if (element.requestFullscreen) {
                element.requestFullscreen();
            } else if (element.webkitRequestFullScreen) {
                element.webkitRequestFullScreen();
            } else if (element.mozRequestFullScreen) {
                element.mozRequestFullScreen();
            } else if (element.msRequestFullscreen) {
                // IE11
                element.msRequestFullscreen();
            }
        }
        //显示工具条的div
        let optinfo_element = document.getElementById('optinfo');
        //显示进度条的div
        let loadinfo_element = document.getElementById('loadinfo');
        //pdf上级的div
        let pdfdiv_element = document.getElementById("pdf_id").parentNode;
        if(this.fullscreen){
          //取消全屏
          optinfo_element.classList.remove("white_bg");
          loadinfo_element.classList.remove("white_bg");
          pdfdiv_element.classList.remove("scroll_show");
        } else {
          //全屏
          optinfo_element.classList.add("white_bg");
          loadinfo_element.classList.add("white_bg");
          pdfdiv_element.classList.add("scroll_show");
        }
        this.fullscreen = !this.fullscreen;
    }
  }
}
</script>
<style scoped>
  .white_bg{
    background-color: #ffffff;
  }
  .scroll_show{
    height:1200px;
    overflow:auto;
  }
</style>