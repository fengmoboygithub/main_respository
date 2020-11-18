<template>
<div class="pdf">  
	<el-row :gutter="24">
		<el-col :span="4">
			<el-button type="primary" @click="prePage">上一页</el-button>
		</el-col>
		<el-col :span="4">
			<el-button type="primary" @click="nextPage">下一页</el-button>
		</el-col>
		<el-col :span="4">
			<el-button type="primary" @click="clock">顺时针</el-button>
		</el-col>
		<el-col :span="4">
			<el-button type="primary" @click="counterClock">逆时针</el-button>
		</el-col>
		<el-col :span="4">
			<el-button type="primary" @click="pdfPrintAll">全部打印</el-button>
		</el-col>
		<el-col :span="4">
			<el-button type="primary" @click="pdfPrint">部分打印</el-button>
		</el-col>
	</el-row>
	<el-row :gutter="24">
		<el-col :span="8">
			<el-tag type="success">{{pageNum}}/{{pageTotalNum}}</el-tag>
		</el-col>
		<el-col :span="8">
			<el-tag type="success">进度：{{loadedRatio}}</el-tag>
		</el-col>
		<el-col :span="8">
			<el-tag type="success">页面加载成功: {{curPageNum}}</el-tag>
		</el-col>
	</el-row>
	<el-row :gutter="24">
		<el-col :span="24">
			<pdf 
				ref="pdf"
				:src="pdfUrl"
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
          pdfUrl:this.url,
          pageNum:1,
		  pageTotalNum:1,
		  pageRotate:0,
		  // 加载进度
		  loadedRatio:0,
		  curPageNum:0,
		  dialogVisible:true
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
    password(updatePassword, reason) {
      updatePassword(prompt('password is "123456"'))
      console.log('...reason...')
      console.log(reason)
      console.log('...reason...')
    },
    pageLoaded(e){
      this.curPageNum = e
    },
    pdfError(error){
      console.error(error)
    },
    pdfPrintAll(){
      this.$refs.pdf.print()
    },
    pdfPrint(){
      this.$refs.pdf.print(100,[1,2])
    },
  }
}
</script>