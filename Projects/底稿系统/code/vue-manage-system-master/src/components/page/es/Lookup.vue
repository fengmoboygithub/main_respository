<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 查看文件
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
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
        </div>
</template>

<script>
    import vPdf from '@/components/common/Pdf.vue';
    import vAudio from '@/components/common/Audio.vue';
    import vVideo from '@/components/common/Video.vue';
    import config from "@/config";
    export default {
        name: 'esManagementLookup',
        components: {
            vPdf,
            vAudio,
            vVideo
        },
        data() {
            return {
                fileInfo: {
                    id: '',//底稿ID
                    docname: '',//文件名称
                    userid: '',//上传人
                    uploaddate: '',//上传时间
                    status: '',//状态
                    fileType: '',//文件类型
                    fileUrl: '', //文件哈希名
                    remarks: "",//备注
                },
                resourcePath: config.ME_IP_INFO+config.FILE_BASEURL, //资源目录映射地址
            };
        },
        created() {
            this.getData();
        },
        methods: {
            // 获取文件信息
            getData(){
                this.net.get_ManuscriptInfo({
                    id: this.$route.query.id
                    }).then(res => {
                    if (res.code === 200) {
                        this.$message.success("底稿信息获取成功");
                        this.fileInfo.id = res.entity.id;
                        this.fileInfo.fileUrl=this.resourcePath+res.entity.hashname;//网络传输链接
                        this.fileInfo.docname=res.entity.docname;//文件名称
                        this.fileInfo.userid=res.entity.userid;//上传人
                        this.fileInfo.uploaddate=res.entity.uploaddate;//上传时间
                        this.fileInfo.status=res.entity.status;//状态
                        this.fileInfo.fileType = res.entity.filetype;//文件类型
                    } else {
                        this.$message.error("底稿信息获取失败");
                    }
                // eslint-disable-next-line no-unused-vars
                }).catch((e)=>{
                    this.$message.error("服务器错误，底稿信息获取失败！");
                });
            },
        }
    };
</script>

<style scoped>
</style>
