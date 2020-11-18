<#assign menu="component">
<#assign submenu="update_component">
<#assign codeEditerPath=BASE_PATH+"/static/manage/codeEditer/">
<#include "/manage/head.ftl">
<link rel="stylesheet" href="${codeEditerPath}js/CodeMirror-2.25/lib/codemirror.css">
<link rel="stylesheet" href="${codeEditerPath}js/CodeMirror-2.25/theme/night.css">
<script type="text/javascript" src="${codeEditerPath}js/jquery/jquery.js"></script>
<script type="text/javascript" src="${codeEditerPath}js/CodeMirror-2.25/lib/codemirror.js"></script>
<script type="text/javascript" src="${codeEditerPath}js/CodeMirror-2.25/addon/selection/selection-pointer.js"></script>
<script type="text/javascript" src="${codeEditerPath}js/CodeMirror-2.25/mode/xml/xml.js"></script>
<script type="text/javascript" src="${codeEditerPath}js/CodeMirror-2.25/mode/javascript/javascript.js"></script>
<script type="text/javascript" src="${codeEditerPath}js/CodeMirror-2.25/mode/css/css.js"></script>
<script type="text/javascript" src="${codeEditerPath}js/CodeMirror-2.25/mode/vbscript/vbscript.js"></script>
<script type="text/javascript" src="${codeEditerPath}js/CodeMirror-2.25/mode/htmlmixed/htmlmixed.js"></script>
<script type="text/javascript">
    var _BasePath = "${BASE_PATH}";
</script>
<!--main content start-->
<style type="text/css">

</style>
<section id="main-content">
	<section class="wrapper">
		<!-- page start-->
		<form id="update_component_form" class="form-horizontal" action="${BASE_PATH}/manage/component/update.json"  autocomplete="off"  method="post">
			<fieldset>
		<div class="row">
			<input type="hidden" name="componentId" value="${componentVo.componentId}">
			<div class="col-lg-12">
				<section class="panel">
					<header class="panel-heading"> 
						编辑组件
					</header>
					<div class="panel-body">
					
						<div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">组件类型</label>
                          <div class="col-sm-10">
                             	<select class="js_component_check form-control" style="font-size:15px;width: auto;" name="compTypeId" id="compTypeId" value="${componentVo.compTypeId}">
                             		<option >--请选择--</option>
									<#list componentTypes as type>
										<#if '${type.compTypeId}'=='${componentVo.compTypeId}'>
											<option value="${type.compTypeId}" selected="selected" >${type.compTypeName}</option>											
										<#else>
											<option value="${type.compTypeId}"  >${type.compTypeName}</option>
										</#if>
									</#list>
								</select>
                          </div>
                        </div>
					
						<div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">组件名称</label>
                          <div class="col-sm-10">
                              <input type="text" style="font-size:15px;width: 300px;" class="form-control" name="componentName"
                              	placeholder="组件名称" id="componentName" value="${componentVo.componentName}">
                              </input>
                          </div>
                        </div>
                        
                        <div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">组件Class名称</label>
                          <div class="col-sm-10">
                             	<input type="text" style="font-size:15px;width: 300px;" class="form-control" name="className"
                              	placeholder="组件Class名称" id="className" value="${componentVo.className!}">
                              </input>
                          </div>
                        </div>
                        
                        <div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">排序</label>
                          <div class="col-sm-10">
                             	<input type="text" style="font-size:15px;width: 300px;" class="form-control" name="sort"
                              	placeholder="排序" id="sort"  value="${componentVo.sort}">
                          </div>
                        </div>
                        
                        <div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">组件React代码</label>
                          <div class="col-sm-10">
                          		<input type="hidden" name="htmlCode" id="htmlCodeHidden"/>
                          		<textarea id="code_js_hidden" style="display:none">${componentVo.htmlCode!}</textarea>
                          		<textarea rows="10" cols="40" id="code_js" style="position: absolute; left: -10000px; width: 10px;"></textarea>		  
                          </div>
                        </div>
                        
                        <div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">测试组件代码</label>
                          <div class="col-sm-10">
                          	<button class="btn btn-info js_all_code" type="button" componentId="${componentVo.componentId}">代码测试器</button>
                          </div>
                        </div>
                        
                        <div class="form-group">
                      	  <div class="col-lg-offset-2 col-lg-10">
                          	<button class="btn btn-shadow btn-primary" type="submit">编辑</button>
                          	<button class="btn btn-shadow btn-primary" type="button" onclick="javascript:history.back(-1);">返回</button>
                          </div>
                      </div>
					</div>
				</section>
				
				<section class="panel" style="float:left;width:50%">
					<header class="panel-heading"> ${componentVo.className!}的引入组件列表 </header>
					<div class="panel-body">
						<table class="table">
							<thead>
								<tr>
									<th>顺序</th>
									<th>组件名称</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<#list componentImportList as componentImport>
										<tr>
											<td class="mediaFileSort"><input type="text"
												relaId="${componentImport.id}" value="${componentImport.sort}" name="sort"
												class="js_sort_item" style="width: 40px;"></td>
											<td>
												<a href="${BASE_PATH}/manage/component/update.htm?componentId=${componentImport.importId}">${componentImport.componentName!}</a>	
											</td>
											<td>
												<a href="javascript:void(0);" title="移除" class="btn btn-danger btn-xs js_media_remove" relaId="${componentImport.id}">移除</a> 
											</td>
										</tr>
	                        	</#list>					
							</tbody>
						</table>
					</div>
					<div>
						<button class="btn btn-info js_update_sort" type="button">
							<i class="icon-refresh"></i> 更新排序
						</button>
					</div>
				</section>
			
			
				<section class="panel" style="float:right;width:50%">
					<header class="panel-heading"> 全部组件列表 </header>
					<div class="panel-body">
						<table class="table">
							<thead>
								<tr>
									<th>组件名称</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<#list componentAll as component>
		                   			<#if component.owner == "no">
										<tr>
											<td>${component.componentName}</td>
											<td>
												<a href="javascript:void(0);" title="引入" class="btn btn-danger btn-xs js_move" importId="${component.componentId}">引入</a> 
											</td>
										</tr>
		                   			</#if>
	                        	</#list>					
							</tbody>
						</table>
					</div>
				</section>	
				
			</div>
		</div>
		</fieldset>
		</form>
		<!-- page end-->
	</section>
</section>
<!--main content end-->
<script type="text/javascript">
var componentId = ${componentVo.componentId};
$(function(){
	//排序
	$('.js_update_sort').click(function() {
        var sortArr = new Array();
        $('.js_sort_item').each(function(i, element) {
            var itemInfo = {};
            itemInfo.relaId = $(element).attr('relaId');
            itemInfo.sort = $(element).val();
            sortArr.push(itemInfo);
        });
        if(sortArr.length == 0){
        	bootbox.alert("没有可排序的条目",
                function() {
                });
        } else {
        	$.post("${BASE_PATH}/manage/componentImport/sort.json", {
            "sortJson": $.toJSON(sortArr)
        },
        function(data) {
            if (data.result) {
                bootbox.alert("更新成功",
                function() {
                    window.location.reload();
                });
            } else {
                bootbox.alert(data.msg,
                function() {
          		});
            }
        },
        "json");
        }
    });
    //引入
    $('.js_move').click(function() {
        var importId = $(this).attr('importId');
        bootbox.dialog({
            message: "是否" + $(this).attr('title') + "组件",
            title: "提示",
            buttons: {
                "delete": {
                    label: $(this).attr('title'),
                    className: "btn-success",
                    callback: function() {
                        $.post("${BASE_PATH}/manage/componentImport/add.json", {
                            "componentId": componentId,
                            "importId": importId
                        },
                        function(data) {
                            if (data.result) {
                                window.location.reload();
                            } else {
                                bootbox.alert(data.msg,
                                function() {});
                            }
                        },
                        "json");
                    }
                },
                "cancel": {
                    label: "取消",
                    className: "btn-primary",
                    callback: function() {}
                }
            }
        });
    });
    //移除
    $('.js_media_remove').click(function() {
        var relaId = $(this).attr('relaId');
        bootbox.dialog({
            message: "是否" + $(this).attr('title') + "组件",
            title: "提示",
            buttons: {
                "delete": {
                    label: $(this).attr('title'),
                    className: "btn-success",
                    callback: function() {
                        $.post("${BASE_PATH}/manage/componentImport/delete.json", {
                            "id": relaId
                        },
                        function(data) {
                            if (data.result) {
                                window.location.reload();
                            } else {
                                bootbox.alert(data.msg,
                                function() {});
                            }
                        },
                        "json");
                    }
                },
                "cancel": {
                    label: "取消",
                    className: "btn-primary",
                    callback: function() {}
                }
            }
        });
    });
    //js编辑器初始化
	  var mixedModeJS = {
        name: "javascript"
      };
      var editorJS = CodeMirror.fromTextArea(document.getElementById("code_js"), {
        mode: mixedModeJS,
        selectionPointer: true,
		theme:"night",
		lineNumbers: true
      });
      editorJS.setSize(795,300);
      editorJS.setValue($("#code_js_hidden").val());
	$('#update_component_form').ajaxForm({
			dataType : 'json',
			beforeSerialize : function(formObj,optionObj){
				//组件html代码赋值
				var htmlCode = editorJS.getValue();
				$('#htmlCodeHidden').val(htmlCode);
				return true;
			},
			beforeSubmit : function(formData,formObj,optionObj){
				return $(formObj).validate({"basePath":"${BASE_PATH}"});
			},
			success : function(data) {
				if (data.result) {
					bootbox.alert("保存成功，将刷新页面", function() {
						window.location.reload();
					});
				}else{
					showErrors($('#update_site_form'),data.errors);
				}
			}
	});
	
	//点击查看按钮 弹出查看代码模态框
	$(".js_all_code").unbind("click").click(function() {
		//查看该组件的代码块
		window.open("${BASE_PATH}/manage/codeEditer/view.htm?type=component&id="+$(this).attr("componentId"));
	});
});
</script>
<#include "/manage/foot.ftl">
