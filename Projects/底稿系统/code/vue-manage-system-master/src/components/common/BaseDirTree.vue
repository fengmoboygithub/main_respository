<template>
    <div ref="allRef">
        <!-- 右键菜单 -->
        <v-rightmenu ref="rightmenu" :list="rightMenuList" :subList="rightMenuSubList"></v-rightmenu>
        <!-- 基础目录树形组件 -->
        <div class="container" >
          <el-row :gutter="20" v-if="showNotRootInfo">
            <el-col :span="12" style="border-right: 1px solid;">
              <!--搜索框相关 start-->
              <el-select
                v-model="value"
                class="me-filter-select"
                filterable
                remote
                reserve-keyword
                placeholder="请输入目录名称"
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
                ref="treeRef"
                :setting="setting"
                :nodes="nodes"
                style="min-height: 150px;margin-bottom: 145px;"
                @onClick="onClick"
                @onRightClick="onRightClick"
                @onCreated="handleCreated"
              />
            </el-col>
            <el-col :span="12">
              <div class="form-box" v-if="showInfo">
                  <el-form ref="formBase" :model="formBase" :rules="rulesBase" label-width="80px">
                      <el-form-item label="目录简称" prop="sname">
                          <el-input v-model="formBase.sname"></el-input>
                      </el-form-item>
                      <el-form-item label="目录全称" prop="fullname">
                          <el-input v-model="formBase.fullname"></el-input>
                      </el-form-item>
                      <el-form-item label="目录顺序" prop="direntoryno">
                          <el-input v-model="formBase.direntoryno"></el-input>
                      </el-form-item>
                      <!-- <el-form-item label="是否适用">
                          <el-select v-model="formBase.isapp">
                              <el-option
                                  v-for="item in isappOptions"
                                  :key="item.code"
                                  :label="item.value"
                                  :value="item.code">
                              </el-option>
                          </el-select>
                      </el-form-item> -->
                      <el-form-item v-if="isAdd && roles.add_base_dir">
                          <el-button  type="primary" @click="onSubmit">保存</el-button>
                      </el-form-item>
                      <el-form-item v-else-if="!isAdd && roles.edit_base_dir">
                          <el-button  type="primary" @click="onSubmit">保存</el-button>
                      </el-form-item>
                  </el-form>
              </div>
            </el-col>
          </el-row>
          <div class="form-box" v-if="showRootInfo && roles.add_base_dir">
              <el-form ref="formRoot" :model="formRoot" :rules="rulesRoot" label-width="80px">
                  <el-form-item label="目录简称" prop="sname">
                      <el-input v-model="formRoot.sname"></el-input>
                  </el-form-item>
                  <el-form-item label="目录全称" prop="fullname">
                      <el-input v-model="formRoot.fullname"></el-input>
                  </el-form-item>
                  <el-form-item label="目录顺序" prop="direntoryno">
                      <el-input v-model="formRoot.direntoryno"></el-input>
                  </el-form-item>
                  <!-- <el-form-item label="是否适用">
                      <el-select v-model="form.isapp">
                          <el-option
                              v-for="item in isappOptions"
                              :key="item.code"
                              :label="item.value"
                              :value="item.code">
                          </el-option>
                      </el-select>
                  </el-form-item> -->
                  <el-form-item>
                      <el-button type="primary" @click="onSubmit">保存</el-button>
                  </el-form-item>
              </el-form>
          </div>
        </div>
    </div>
</template>

<script>
import tree from "vue-giant-tree";
import vRightmenu from '@/components/common/RightMenu.vue';
export default {
  name: "baseDirTree",
  components: {
    tree,
    vRightmenu
  },
  props: {
    index: {
      type: [Number],
      require: true,
      default: function(){
        return {}
      }
    },
    projecttype: {
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
    roles: {
      type: Object,
      require: true,
      default: function(){
        return {}
      }
    },
    isEdit: {
      type: Boolean,
      require: false,
      default: function(){
        return true;
      }
    }
  },
  data() {
    var checkNo = (rule, value, callback) => {
        if (!value) {
            return callback(new Error('请输入目录顺序'));
        }
        var regPos = /^[1-9]\d*$/; // 正整数
        if(!regPos.test(value)){
            callback(new Error('请输入正整数值'));
        } else {
          callback();
        }
    };
    var checkSname = (rule, value, callback) => {
      if (!value) {
          return callback(new Error('请输入目录简称'));
      }
      var len = value.length;
      var len_flag = false;
      if (len<3) {
          len_flag = true;
      } else if(len>250){
          len_flag = true;
      }
      if(len_flag){
          callback(new Error('长度在 3 到 250 个字符'));
      } else {
          var params = {
            projecttype: this.projecttype,
            parentid: '',
            sname: value
          };
          if(!this.showRootInfo){
              if(this.isAdd){
                  params = {
                    projecttype: this.projecttype,
                    parentid: this.dirInfo.id,
                    sname: value
                  };
              } else {
                  params = {
                    projecttype: this.projecttype,
                    parentid: this.dirInfo.pid,
                    id: this.dirInfo.id,
                    sname: value
                  };
              }
          }
          this.net.getNameOrSnameForOnly_BaseDirectory(params).then(res => {
              if(res.entity){
                  callback(new Error('目录简称已存在，请重新输入！'));
              } else {
                  callback();
              }
          // eslint-disable-next-line no-unused-vars
          }).catch((e)=>{
              callback(new Error('请求错误，验证失败！'));
          });
      }
    };
    var checkFullname = (rule, value, callback) => {
      if (!value) {
          return callback(new Error('请输入目录全称'));
      }
      var len = value.length;
      var len_flag = false;
      if (len<3) {
          len_flag = true;
      } else if(len>250){
          len_flag = true;
      }
      if(len_flag){
          callback(new Error('长度在 3 到 250 个字符'));
      } else {
          var params = {
            projecttype: this.projecttype,
            parentid: '',
            fullname: value
          };
          if(!this.showRootInfo){
              if(this.isAdd){
                  params = {
                    projecttype: this.projecttype,
                    parentid: this.dirInfo.id,
                    fullname: value
                  };
              } else {
                  params = {
                    projecttype: this.projecttype,
                    parentid: this.dirInfo.pid,
                    id: this.dirInfo.id,
                    fullname: value
                  };
              }
          }
          this.net.getNameOrSnameForOnly_BaseDirectory(params).then(res => {
              if(res.entity){
                  callback(new Error('目录全称已存在，请重新输入！'));
              } else {
                  callback();
              }
          // eslint-disable-next-line no-unused-vars
          }).catch((e)=>{
              callback(new Error('请求错误，验证失败！'));
          });
      }
    };
    return {
      /**搜索框相关 start*/
      options: [],
      value: "",
      list: [],
      loading: false,
      /**搜索框相关 end*/
      /**右键菜单相关 start*/
      rightMenuList: [],
      rightMenuSubList:[],
      /**右键菜单相关 start*/
      showInfo: false,
      isAdd: false,
      showNotRootInfo: false,
      showRootInfo: false,
      formBase: {
        projecttype:this.projecttype,//项目类型id
        projectstage:this.projectStage,//项目阶段
        id:'',//主键id
        parentid:'',//父目录id
        level:'',//目录级别
        sname:'',//目录简称
        fullname:'',//目录全称
        direntoryno:'',//目录顺序
        isapp:'',//是否适用
      },
      formRoot: {
        projecttype:this.projecttype,//项目类型id
        projectstage:this.projectStage,//项目阶段
        id:'',//主键id
        parentid:'',//父目录id
        level:'',//目录级别
        sname:'',//目录简称
        fullname:'',//目录全称
        direntoryno:'',//目录顺序
        isapp:'',//是否适用
      },
      rulesBase: {
          sname: [
              { required: true, validator: checkSname, trigger: 'blur' }
          ],
          fullname: [
              { required: true, validator: checkFullname, trigger: 'blur' }
          ],
          direntoryno: [
              { required: true, validator: checkNo, trigger: 'blur' }
          ],
      },
      rulesRoot: {
          sname: [
              { required: true, validator: checkSname, trigger: 'blur' }
          ],
          fullname: [
              { required: true, validator: checkFullname, trigger: 'blur' }
          ],
          direntoryno: [
              { required: true, validator: checkNo, trigger: 'blur' }
          ],
      },
      dirInfo: null,
      isappOptions: [
        {
          code: 1,
          value: '适用'
        },
        {
          code: 2,
          value: '不适用'
        }
      ],
      nodes: [],
      ztreeObj: null,
      setting: {
        check: {
          enable: true,
          nocheckInherit: true
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
    // bus.$on('baseDirTree_load_'+this.index, () => {
        //this.initTree();
    // });
  },
  // activated() {
  //   this.initTree();
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
    addDiyDom(treeid, treeNode) {
      const node_span = document.getElementById(`${treeNode.tId}_span`);
      const item = document.getElementById(`${treeNode.tId}_a`);
      if(item && !item.querySelector('.node_name_me')){
        node_span.classList.add('node_name_me');
      }
    },
    selectNodeById(selectId) {
      var that_nodes = this.nodes;
      if(selectId){
        //选中节点
        if (that_nodes.length>0) {
          that_nodes.some(node=>{  
              if(node.id==selectId) {
                this.ztreeObj && this.ztreeObj.selectNode(node, false, true);
                return true;
              }
          });
        }
      }
    },
    initTree() {
      let treeRef = this.$refs['treeRef'];
      if(!treeRef){
        treeRef = this.$refs['allRef'];
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
      //获取项目目录树数据
      this.net.baseViewTreeForMe({
        'projecttype':this.projecttype,
        'projectStage':this.projectStage
        }).then(res => {
          if(loadingInstance != null){
            loadingInstance.close();
          }
          const respModel = res;
          if(respModel.success && respModel.code === 200){
            this.nodes = respModel.list;
            if(this.nodes && this.nodes.length > 0) {
              this.showRootInfo = false;
              this.showNotRootInfo = true;
              this.showInfo = false;
              this.isAdd = false;
              /**搜索框相关 start*/
              this.list = this.nodes.map(item => {
                return { value: `${item.id}`, label: `${item.name}` };
              });
              /**搜索框相关 end*/
            } else {
              this.showRootInfo = true;
              this.showNotRootInfo = false;
            }
          }
      }).catch(error => {
        if(loadingInstance != null){
          loadingInstance.close();
        }
        // eslint-disable-next-line no-console
        console.log(error);
        this.$message.error('数据加载失败');
      });
    },
    // 添加右键菜单数据
    addHoverDom(evt, treeid, treeNode) {
      if(treeNode){
        this.rightMenuList = [];
        this.rightMenuSubList = [];
        //目录
        if(treeNode.type === 'dir' || treeNode.type === 'root') {
          if(this.roles.add_base_dir){
            //新增
            let menuItem = {
              id: treeid+"_1",
              label: '新增',
              // eslint-disable-next-line no-unused-vars
              onClick: (evt) => {
                //新增操作
                this.formBase.id='';//主键id
                this.formBase.parentid='';//父目录id
                this.formBase.level='';//目录级别
                this.formBase.sname='';//目录简称
                this.formBase.fullname='';//目录全称
                this.formBase.direntoryno='';//目录顺序
                this.formBase.isapp='';//是否适用
                this.showInfo = true;
                this.isAdd = true;
              },
            };
            this.rightMenuList.push(menuItem);
          }
          if(this.roles.del_base_dir) {
            //删除
            let menuItem = {
              id: treeid+"_2",
              label: '删除',
              // eslint-disable-next-line no-unused-vars
              onClick: (evt) => {
                //删除操作
                this.clickRemove(treeNode);
              },
            };
            this.rightMenuList.push(menuItem);
          }
        }
      }
    },
    //加载目录信息
    getData(treeNode) {
      this.net.get_BaseDirectory({
        'id': treeNode.id
      }).then(res => {
          if(res.success){
              this.formBase.id = res.entity.id;//主键id
              this.formBase.parentid = res.entity.parentid;//父目录id
              this.formBase.level = res.entity.level;//目录级别
              this.formBase.sname = res.entity.sname;//目录简称
              this.formBase.fullname = res.entity.fullname;//目录全称
              this.formBase.direntoryno = res.entity.direntoryno;//目录顺序
              this.formBase.isapp = res.entity.isapp;//是否适用
          } else {
              this.$message.error('加载目录信息失败！');
          }
      });
    },
    //适用或不适用操作
    handleApp(treeNode) {
      this.net.update_BaseDirectory({
        'id': treeNode.id,
        'isapp': treeNode.isapp
      }).then(res => {
          if(res.success){
              this.$message.success('操作成功！');
          } else {
              this.$message.error('操作失败！');
          }
      });
    },
    clickRemove(treeNode) {
      // 二次确认删除
      this.$confirm('确定要删除吗？', '提示', {
          type: 'warning'
      })
      .then(() => {
          this.net.del_BaseDirectory({id:treeNode.id}).then(res => {
              if (res.code === 200) {
                this.ztreeObj && this.ztreeObj.removeNode(treeNode);
                this.$message.success("删除成功");
                this.formBase={
                  projecttype:this.projecttype,//项目类型id
                  projectstage:this.projectStage,//项目阶段
                  id:'',//主键id
                  parentid:'',//父目录id
                  level:'',//目录级别
                  sname:'',//目录简称
                  fullname:'',//目录全称
                  direntoryno:'',//目录顺序
                  isapp:'',//是否适用
                };
                this.formRoot={
                  projecttype:this.projecttype,//项目类型id
                  projectstage:this.projectStage,//项目阶段
                  id:'',//主键id
                  parentid:'',//父目录id
                  level:'',//目录级别
                  sname:'',//目录简称
                  fullname:'',//目录全称
                  direntoryno:'',//目录顺序
                  isapp:'',//是否适用
                };
                this.initTree();
                if(treeNode.pid){
                  this.selectNodeById(treeNode.pid);
                  var node = this.ztreeObj && this.ztreeObj.getNodeByParam("id", treeNode.pid, null);
                  this.onClick({'type':'me'}, treeNode.pid, node);
                }
              } else {
                this.$message.error("服务器错误，删除失败！");
              }
          }).catch((e)=>{
              // eslint-disable-next-line no-console
              console.log(e);
              this.$message.error("请求错误，删除失败！");
          });
      })
      .catch(() => {});
      
    },
    //保存
    onSubmit() {
      if(this.showRootInfo){
        this.$refs['formRoot'].validate((valid) => {
          if (valid) {
            this.formRoot.level = 1;//目录级别
            this.formRoot.isapp = 1;//适用
            this.formRoot.parentid = null;
            let loadingInstance = this.$loading({
                target: this.$refs['formRoot'].$el,
                background: "rgba(0, 0, 0, 0.8)",
                spinner: "el-icon-loading",
                text: "拼命加载中",
            });
            this.net.add_BaseDirectory(this.formRoot).then(res => {
              loadingInstance.close();
              if(res.success){
                  this.$message.success('保存成功！');
                  this.initTree();
                  this.selectNodeById(res.entity.id);
              } else {
                  this.$message.error('保存失败！');
              }
            });
          } else {
              //this.$message.error('验证失败！');
              return false;
          }
        });
        
      } else {
        this.$refs['formBase'].validate((valid) => {
          if (valid) {
            this.formBase.level = this.dirInfo.level;//目录级别
            this.formBase.isapp = 1;//适用
            let loadingInstance = this.$loading({
                target: this.$refs['formBase'].$el,
                background: "rgba(0, 0, 0, 0.8)",
                spinner: "el-icon-loading",
                text: "拼命加载中",
            });
            if(this.isAdd){
              this.formBase.parentid = this.dirInfo.id;//父目录id
              this.formBase.level = this.dirInfo.level+1;
              this.formBase.projectstage = this.projectStage;
              this.net.add_BaseDirectory(this.formBase).then(res => {
                loadingInstance.close();
                if(res.success){
                    this.$message.success('保存成功！');
                    this.initTree();
                    this.selectNodeById(res.entity.id);
                } else {
                    this.$message.error('保存失败！');
                }
              });
            } else {
              this.formBase.parentid = this.dirInfo.pid;//父目录id
              this.formBase.projectstage = "";
              this.net.update_BaseDirectory(this.formBase).then(res => {
                loadingInstance.close();
                if(res.success){
                    this.$message.success('保存成功！');
                    this.initTree();
                    this.selectNodeById(this.formBase.id);
                } else {
                    this.$message.error('保存失败！');
                }
              });
            }
          } else {
              //this.$message.error('验证失败！');
              return false;
          }
        });
        
      }
      
    },
    onClick: function(evt, treeId, treeNode) {
      // 点击事件 加载目录信息 进行修改操作
      if(treeNode.type != "root"){
        this.showInfo = true;
        this.isAdd = false;
        this.dirInfo = treeNode;
        this.getData(treeNode);
      }
    },
    onRightClick(evt, treeId, treeNode) {
      // 点击事件
      this.ztreeObj.selectNode(treeNode, false, true);
      this.dirInfo = treeNode;
      if(this.isEdit){
        // 添加右键菜单数据
        this.addHoverDom(evt, treeId, treeNode);
        // 显示右键菜单
        this.handleShow(evt);
      }
    },
    handleCreated: function(ztreeObj) {
      this.ztreeObj = ztreeObj;
      // onCreated 中操作ztreeObj对象展开第一个节点
      ztreeObj.expandNode(ztreeObj.getNodes()[0], true);
      // ztreeObj.expandAll(true);
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
  color: red;
}
.display_none{
  display: none;
}
.node_name_me{
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
  width: 350px;
}
</style>