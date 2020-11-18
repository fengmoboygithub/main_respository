<template>
    <div>
        <!-- 右键菜单 -->
        <v-rightmenu ref="rightmenu" :list="rightMenuList" :subList="rightMenuSubList"></v-rightmenu>
        <!-- 项目目录树形组件 -->
        <div class="container">
          <el-row :gutter="20">
            <el-col :span="12" style="border-right: 1px solid;" ref="treeRef">
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
                  <el-form ref="form" :model="form" :rules="rules" label-width="80px">
                      <el-form-item label="目录简称" prop="sname">
                          <el-input v-model="form.sname" :disabled=isDisabled||isDisabledForData></el-input>
                      </el-form-item>
                      <el-form-item label="目录全称" prop="fullname">
                          <el-input v-model="form.fullname" :disabled=isDisabled||isDisabledForData></el-input>
                      </el-form-item>
                      <el-form-item label="目录顺序" prop="directoryno">
                          <el-input v-model="form.directoryno" :disabled=isDisabled||isDisabledForData></el-input>
                      </el-form-item>
                      <!-- <el-form-item label="是否适用" prop="isapp">
                          <el-select v-model="form.isapp" @change="handleIsAppChange" :disabled=isDisabled||isDisabledForData>
                              <el-option
                                  v-for="item in isappOptions"
                                  :key="item.code"
                                  :label="item.value"
                                  :value="item.code">
                              </el-option>
                          </el-select>
                      </el-form-item> -->
                      <el-form-item v-if="showRemarks" label="备注" prop="remarks">
                          <el-input 
                            type="textarea"
                            :rows="5"
                            placeholder="请输入备注"
                            v-model="form.remarks"
                            :disabled=isDisabled||isDisabledForData>
                          </el-input>
                      </el-form-item>
                      <el-form-item v-if="isAdd && roles.add_zdydir && roles.status_show">
                          <el-button  type="primary" @click="onSubmit">保存</el-button>
                      </el-form-item>
                      <el-form-item v-else-if="!isAdd && roles.edit_zdydir && roles.status_show && (!(isDisabled||isDisabledForData))">
                          <el-button  type="primary" @click="onSubmit">保存</el-button>
                      </el-form-item>
                  </el-form>
              </div>
            </el-col>
          </el-row>
        </div>
        <el-dialog title="记录备注信息" :visible.sync="dialogFormVisible" @close="handleClose">
        <el-form ref="form_1" :model="form" :rules="rules_1">
          <el-form-item label="备注" prop="remarks_dialog">
              <el-input 
                type="textarea"
                :rows="5"
                placeholder="请输入备注"
                v-model="form.remarks_dialog">
              </el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button ref="optBtn" type="primary" @click="handleApp">确 定</el-button>
        </div>
      </el-dialog>
    </div>
</template>

<script>
// import bus from "@/components/common/bus";
import tree from "vue-giant-tree";
import vRightmenu from '@/components/common/RightMenu.vue';
export default {
  name: "projectDirTree",
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
    projectid: {
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
    },
    isDisabled: {
      type: Boolean,
      require: false,
      default: function(){
        return false;
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
            projectid: this.projectid,
            parentid: this.dirInfo.id,
            sname: value
          };
          if(!this.isAdd){
              params = {
                projectid: this.projectid,
                parentid: this.dirInfo.pid,
                id: this.dirInfo.id,
                sname: value
              };
          }
          this.net.getNameOrSnameForOnly_ProjectDirectory(params).then(res => {
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
            projectid: this.projectid,
            parentid: this.dirInfo.id,
            fullname: value
          };
          if(!this.isAdd){
              params = {
                projectid: this.projectid,
                parentid: this.dirInfo.pid,
                id: this.dirInfo.id,
                fullname: value
              };
          }
          this.net.getNameOrSnameForOnly_ProjectDirectory(params).then(res => {
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
      rightMenuList: [],
      rightMenuSubList:[],
      showInfo: false,
      isAdd: false,
      showRemarks: false,
      dialogFormVisible: false,
      isDisabledForData: false,
      form: {
        projectid:this.projectid,//项目id
        stage:this.projectStage,//项目阶段
        directoryid:'',//目录id
        id:'',//主键id
        parentid:'',//父目录id
        level:'',//目录级别
        processnode: '11',//流程
        sname:'',//目录简称
        fullname:'',//目录全称
        directoryno:'',//目录顺序
        // isapp:'',//是否适用
        remarks:'',//备注
      },
      rules: {
          sname: [
              { required: true, validator: checkSname, trigger: 'blur' }
          ],
          fullname: [
              { required: true, validator: checkFullname, trigger: 'blur' }
          ],
          directoryno: [
              { required: true, validator: checkNo, trigger: 'blur' }
          ],
          // isapp: [
          //   { required: true, message: '请选择是否适用', trigger: 'change' }
          // ],
          remarks: [
              { required: false, message: '请输入备注', trigger: 'blur' },
              { min: 3, max: 250, message: '长度在 3 到 250 个字符', trigger: 'blur' }
          ],
      },
      rules_1: {
        remarks_dialog: [
            { required: true, message: '请输入备注', trigger: 'blur' },
            { min: 3, max: 250, message: '长度在 3 到 250 个字符', trigger: 'blur' }
        ],
      },
      // isappOptions: [
      //   {
      //     code: 1,
      //     value: '适用'
      //   },
      //   {
      //     code: 2,
      //     value: '不适用'
      //   }
      // ],
      dirInfo: null,
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
    // bus.$on('projectDirTree_load_'+this.index, () => {
    //     this.initTree();
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
    //更改是否适用时触发操作
    // handleIsAppChange(currentValue){
    //   this.isAppChangeMethod(currentValue);
    // },
    isAppChangeMethod(currentValue){
      if(currentValue == 2 || currentValue == '2'){
          this.showRemarks = true;
          this.roles.remarks = [
              { required: true, message: '请输入备注', trigger: 'blur' },
              { min: 3, max: 250, message: '长度在 3 到 250 个字符', trigger: 'blur' }
          ];
        } else {
          this.showRemarks = false;
          this.roles.remarks = [
              { required: false, message: '请输入备注', trigger: 'blur' },
              { min: 3, max: 250, message: '长度在 3 到 250 个字符', trigger: 'blur' }
          ];
        }
    },
    addDiyDom(treeid, treeNode) {
      const node_span = document.getElementById(`${treeNode.tId}_span`);
      const item = document.getElementById(`${treeNode.tId}_a`);
      if(item && !item.querySelector('.node_name_me')){
        node_span.classList.add('node_name_me');
        if(treeNode.type === 'dir' && treeNode.isapp === 2){
          node_span.innerHTML= '(不适用)'+treeNode.name;
        }
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
        treeRef = this.$refs['treeRef'];
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
      this.net.viewTreeForMe({
        'projectid':this.projectid,
        'projectStage':this.projectStage
        }).then(res => {
          if(loadingInstance != null){
            loadingInstance.close();
          }
          const respModel = res;
          if(respModel.success && respModel.code === 200){
            this.nodes = respModel.list;
          }
          this.showInfo = false;
          this.isAdd = false;
          /**搜索框相关 start*/
          this.list = this.nodes.map(item => {
            return { value: `${item.id}`, label: `${item.name}` };
          });
          /**搜索框相关 end*/
      // eslint-disable-next-line no-unused-vars
      }).catch(error => {
        if(loadingInstance != null){
          loadingInstance.close();
        }
        this.$message.error('数据加载失败');
      });
    },
    // 添加右键菜单数据
    addHoverDom(evt, treeid, treeNode) {
      if(treeNode) {
        this.rightMenuList = [];
        this.rightMenuSubList = [];
        //目录
        if(((treeNode.type === 'dir' && treeNode.isapp == 1) || treeNode.type === 'root') && this.roles.add_zdydir){
          //console.log("目录----" + treeNode.isapp);
          //新增
          let menuItem = {
            id: treeid+"_1",
            label: '新增',
            // eslint-disable-next-line no-unused-vars
            onClick: (evt) => {
              //新增操作
              this.form.directoryid = '',//目录id
              this.form.id = '',//主键id
              this.form.parentid = '',//父目录id
              this.form.level = '',//目录级别
              this.form.sname = '',//目录简称
              this.form.fullname = '',//目录全称
              this.form.directoryno = '',//目录顺序
              this.form.isapp = '1',//是否适用
              this.showInfo = true;
              this.isAdd = true;
              this.isDisabledForData = false;
            },
          };
          this.rightMenuList.push(menuItem);
        }

        if(treeNode.type === 'dir' && this.roles.del_zdydir && treeNode.isdel) {
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
        if(treeNode.type === 'dir' && this.roles.edit_zdydir){
          if(treeNode.isapp === 1){
            //不适用
            let menuItem = {
              id: treeid+"_2",
              label: '不适用',
              // eslint-disable-next-line no-unused-vars
              onClick: (evt) => {
                //不适用操作
                //treeNode.isapp = 2;
                this.dirInfo = treeNode;
                //
                //开启记录备注对话框  点击保存-->>this.handleApp
                this.dialogFormVisible = true;
                this.$refs['optBtn'].disabled = false;
                //treeNode.remarks
                //不适用操作
                //this.handleApp(treeNode);
              },
            };
            this.rightMenuList.push(menuItem);
          } else if(treeNode.isapp === 2){
            //适用
            let menuItem = {
              id: treeid+"_2",
              label: '适用',
              // eslint-disable-next-line no-unused-vars
              onClick: (evt) => {
                //适用操作
                //treeNode.isapp = 1;
                this.handleApp(treeNode);
              },
            };
            this.rightMenuList.push(menuItem);
          }
        }
      }
    },
    //加载目录信息
    getData(treeNode) {
      this.net.get_ProjectDirectory({
        'projectid': treeNode.projectid,
        'directoryid': treeNode.id
      }).then(res => {
          if(res.success){
              this.form.directoryid = res.entity.directoryid;//目录id
              this.form.id = res.entity.id;//主键id
              this.form.parentid = res.entity.parentid;//父目录id
              this.form.level = res.entity.level;//目录级别
              this.form.sname = res.entity.sname;//目录简称
              this.form.fullname = res.entity.fullname;//目录全称
              this.form.directoryno = res.entity.directoryno;//目录顺序
              //this.form.isapp = res.entity.isapp;//是否适用
              this.form.remarks = res.entity.remarks;//不适用备注
              this.isAppChangeMethod(res.entity.isapp);
              if(treeNode.isdel){
                //自定义目录可以修改
                this.isDisabledForData = false;
              } else {
                //基础目录不能修改
                this.isDisabledForData = true;
              }
              this.$refs['form'].validate();
          } else {
              this.$message.error('加载目录信息失败！');
          }
      });
    },
    //删除
    clickRemove(treeNode) {
      // 二次确认删除
      this.$confirm('确定要删除吗？', '提示', {
          type: 'warning'
      })
      .then(() => {
        this.net.del_ProjectDirectory({id:treeNode.id}).then(res => {
            if (res.code === 200) {
              this.ztreeObj && this.ztreeObj.removeNode(treeNode);
              this.initTree();
              this.selectNodeById(treeNode.tId);
              this.$message.success("目录信息删除成功");
            } else {
              this.$message.error("目录信息删除失败");
            }
        // eslint-disable-next-line no-unused-vars
        }).catch((e)=>{
            this.$message.error("服务器错误，目录信息删除失败！");
        });
      })
      .catch(() => {});
    },
    //打开对话框的回调函数
    handleClose(){
      this.form.remarks_dialog="";
    },
    //适用或不适用操作
    handleApp(treeNode) {
      var flag = false;
      if(!treeNode.id && !treeNode.pid) {
        treeNode = this.dirInfo;
        flag = true;
      }
      if(treeNode.isapp === 1){
        treeNode.isapp = 2;
      } else if(treeNode.isapp === 2){
        treeNode.isapp = 1;
      }
      var treedag = {};
      treedag.id = treeNode.id;
      treedag.pid = treeNode.pid;
      treedag.isapp = treeNode.isapp;
      treedag.type = treeNode.type;
      if (treeNode.isapp == 2){
        treedag.remarks = this.form.remarks_dialog;
        // eslint-disable-next-line no-console
        console.log(JSON.stringify([treedag]));
        this.$refs['form_1'].validate((valid) => {
          if (valid) {
            this.$refs['optBtn'].disabled = true;
            this.net.updateIsapp_ProjectDirectory({
              'projectId': this.projectid,
              'projectStage': this.projectStage,
              'treeDag': JSON.stringify([treedag])
            }).then(res => {
                if(res.success){
                    this.$message.success('操作成功！');
                    if(flag){
                      this.dialogFormVisible = false;
                    }
                    this.initTree();
                    this.selectNodeById(treeNode.tId);
                } else {
                    this.$refs['optBtn'].disabled = false;
                    this.$message.error('操作失败！');
                }
            });
          } else {
              return false;
          }
        });
        
      } else {
        // eslint-disable-next-line no-console
        console.log(JSON.stringify([treedag]));
        this.$refs['optBtn'].disabled = true;
        this.net.updateIsapp_ProjectDirectory({
          'projectId': this.projectid,
          'projectStage': this.projectStage,
          'treeDag': JSON.stringify([treedag])
        }).then(res => {
            if(res.success){
                this.$message.success('操作成功！');
                if(flag){
                  this.dialogFormVisible = false;
                }
                this.initTree();
                this.selectNodeById(treeNode.tId);
            } else {
                this.$refs['optBtn'].disabled = false;
                this.$message.error('操作失败！');
            }
        });
      }
    },
    //保存
    onSubmit() {
      this.$refs['form'].validate((valid) => {
          if (valid) {
            let loadingInstance = this.$loading({
                target: this.$refs['form'].$el,
                background: "rgba(0, 0, 0, 0.8)",
                spinner: "el-icon-loading",
                text: "拼命加载中",
            });
            this.form.level = this.dirInfo.level;//目录级别
            if(this.isAdd){
              this.form.parentid = this.dirInfo.id;//父目录id
              this.formBase.level = this.dirInfo.level+1;
              this.net.add_ProjectDirectory(this.form).then(res => {
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
              this.form.parentid = this.dirInfo.pid;//父目录id
              this.form.stage = "";
              this.net.update_ProjectDirectory(this.form).then(res => {
                loadingInstance.close();
                if(res.success){
                    this.$message.success('保存成功！');
                    this.initTree();
                    this.selectNodeById(this.form.id);
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
        
    },
    onClick: function(evt, treeId, treeNode) {
      // 点击事件 加载目录信息 进行修改操作
      this.showInfo = true;
      this.isAdd = false;
      this.dirInfo = treeNode;
      this.getData(treeNode);
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