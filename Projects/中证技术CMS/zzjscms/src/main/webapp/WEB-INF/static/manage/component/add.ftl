<#assign menu="component">
<#assign submenu="add_component">
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
<section id="main-content">
	<section class="wrapper">
		<!-- page start-->
		<form id="add_component_form" class="form-horizontal" action="${BASE_PATH}/manage/component/add.json"  autocomplete="off"  method="post">
		<div class="row">
			
			<div class="col-lg-12">
				<section class="panel">
					<header class="panel-heading"> 
						增加组件
					</header>
					<div class="panel-body">
						
						<div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">组件类型</label>
                          <div class="col-sm-10">
                             	<select class="js_component_check form-control" style="font-size:15px;width: auto;" name="compTypeId" id="compTypeId" value="${compTypeId!}">
                             		<option >--请选择--</option>
									<#list componentTypes as type>
										<option value="${type.compTypeId}" <#if (((compTypeId)!'') == '${type.compTypeId}')>selected="selected"</#if> >${type.compTypeName}</option>
									</#list>
								</select>
                          </div>
                        </div>
											
						<div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">组件名称</label>
                          <div class="col-sm-10">
                              <input type="text" style="font-size:15px;width: 300px;" class="form-control" name="componentName"
                              	placeholder="组件名称" id="componentName" >
                              </input>
                          </div>
                        </div>
                        
                        <div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">组件Class名称</label>
                          <div class="col-sm-10">
                             	<input type="text" style="font-size:15px;width: 300px;" class="form-control" name="className"
                              	placeholder="组件Class名称" id="className" >
                              </input>
                          </div>
                        </div>
                        
                        <div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">排序</label>
                          <div class="col-sm-10">
                             	<input type="text" style="font-size:15px;width: 300px;" class="form-control" name="sort"
                              	placeholder="排序" id="sort" >
                          </div>
                        </div>
                        
                        <div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">组件React代码</label>
                          <div class="col-sm-10">
                          		  <input type="hidden" name="htmlCode" id="htmlCodeHidden"/>
	                          		<textarea rows="10" cols="40" id="code_js" style="position: absolute; left: -10000px; width: 10px;"></textarea>
                              </div>
                        </div>
                        
	                    <div class="form-group">
	                  	  <div class="col-lg-offset-2 col-lg-10">
	                      <button class="btn btn-shadow btn-primary" type="submit">保存</button>
	                      <button class="btn btn-shadow btn-primary" type="button" onclick="javascript:history.back(-1);">返回</button>
	                      </div>
	                  </div>
					</div>
				</section>
			</div>
		</div>
		</form>
		<!-- page end-->
	</section>
</section>
<!--main content end-->
<script type="text/javascript">
$(function(){
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
	$('#add_component_form').ajaxForm({
		dataType : 'json',
		//数据序列化之前
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
					window.top.location.href="${BASE_PATH}" + "/manage/component/list.htm";
				});
			}else{
				showErrors($('#add_component_form'),data.errors);
			}
		}
	});
});
</script>
<#include "/manage/foot.ftl">