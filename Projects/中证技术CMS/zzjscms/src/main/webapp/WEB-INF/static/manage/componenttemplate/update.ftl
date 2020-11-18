<#assign menu="component_template">
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
		<div id="update_component_form" class="form-horizontal"    autocomplete="off"  >
			<fieldset>
		<div class="row">
			<input type="hidden" id="templateId" value="${templateId!}">
			<div class="col-lg-12">
				<section class="panel">
					<header class="panel-heading"> 
						编辑模板
					</header>
					<div class="panel-body">
					
						<div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">模板名称</label>
                          <div class="col-sm-10">
                              <input  type="text" style="font-size:15px;width: 300px;" class="form-control" 
                              	placeholder="模板名称" id="templateName" value="${templateName!}">
                              </input>
                          </div>
                        </div>
                        
                        <div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">组件名称</label>
                          <div class="col-sm-10">
                             	<select class="js_component_check form-control" style="font-size:15px;width: auto;"   id="componentId"  >
                             		<option >--请选择--</option>
									<#list componentList as component>
										<option value="${component.componentId!}" <#if componentId == component.componentId >selected="selected"</#if>>${component.componentName!}</option>
									</#list>
								</select>
                          </div>
                        </div>
                        
                        <div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">是否默认</label>
                          <div class="col-sm-10">
                             	<select class="js_component_check form-control" style="font-size:15px;width: auto;"   id="isDefault" value="${isDefault!}">
                             		<option >--请选择--</option>
											<option value="0" <#if isDefault == '0' >selected="selected"</#if> >否</option>											
											<option value="1" <#if isDefault =='1' >selected="selected"</#if>>是</option>
								</select>
                          </div>
                        </div>
                        
                        <div class="form-group">
                      	  <div class="col-lg-offset-2 col-lg-10">
                          	<button class="btn btn-shadow btn-primary" type="submit" id="updateTemplate">编辑</button>
                          	<a href='${BASE_PATH}/manage/componentTemplate/list.htm'><button class="btn btn-shadow btn-primary" type="button" >返回</button></a>
                          </div>
                      </div>
					</div>
				</section>
				
<section class="panel" style="float:left;width:100%;">
					<header class="panel-heading">
		                <div class="row">
						   <div class="col-lg-12">
						<a class="btn btn-primary" style="float:right;" id="addTemplateData">增加数据源模板表</a>
						   </div>
						</div>
					</header>
					<header class="panel-heading">数据源模板表</header>
					<div class="panel-body">
						<table class="table">
							<thead>
								<tr>
									<th>数据源配置名称</th>
									<th>数据源配置英文名称</th>
									<th>最后更新时间</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody id="templateDataBody" role="alert" aria-live="polite" aria-relevant="all">
									<#list pageVo as e>
										<tr class="gradeA odd" >
											<td class='dataJsonName'>
											     <textarea  dataJsonName="${e.dataJsonName}" data_id='${e.id!}'  id="htmlCode${e.id!}"  style="display:none">${e.dataJsonCode!}</textarea>
											     ${e.dataJsonName!}</td>
											<td class='dataJsonEnName'>${e.dataJsonEnName!}</td>
											<td>
												<#if (e.updateTime)??>
                                    			${e.updateTime?string("yyyy-MM-dd")}
                                    		<#else>
                                    			<#if (e.createTime)??>
	                                    			${e.createTime?string("yyyy-MM-dd")}
                                    			</#if>
                                    		</#if>
											</td>
											<td>
												<a class='js_template_data_edit' title="编辑">
                  								编辑
                  							</a>
                  							 | 
                  							<a class='js_template_data_delete' title="是否删除组件">
                  								删除
                  							</a>
											</td>
										</tr>
									</#list>			
							</tbody>
						</table>
					</div>
					
				</section>
			
			
				
				
			</div>
		</div>
		</fieldset>
		</div>
		<!-- page end-->
	</section>
</section>
<!--main content end-->

<!--modal start -->
<div class="modal fade" id="addTemplateDataModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" 
							aria-hidden="true">×
					</button>
					<h4 class="modal-title" id="myModalLabel">
						添加模板数据源
					</h4>
				</div>
				<div class="modal-body">
					<form id='addTemplateDataForm' class="form-horizontal" action="${BASE_PATH}/manage/componentTemplate/addDataJson.json" method="post">
					<div class="row">
					<input type="hidden" name="templateId" id='parentId' value=""/>
					<div class="panel-body">
						<div class="form-group">
                          <label class="col-sm-3 col-sm-3 control-label">json配置英文名称</label>
                          <div class="col-sm-8">
                              <input  type="text" style="font-size:15px;width: 300px;" class="form-control" name="dataJsonEnName"
                              	placeholder="json配置英文名称" id="dataJsonEnName" value="">
                              </input>
                          </div>
                        </div>
                        
                        <div class="form-group">
                          <label class="col-sm-3 col-sm-3 control-label">json配置名称</label>
                          <div class="col-sm-8">
                              <input  type="text" style="font-size:15px;width: 300px;" class="form-control" name="dataJsonName"
                              	placeholder="json配置名称" id="dataJsonName" value="">
                              </input>
                          </div>
                        </div>
                        
                        <h3><span ></span>json配置代码</h3>
                        <div class="form-group">
                          <div class="col-sm-12">
                               <textarea style="display:none" name="dataJsonCode" id="htmlCodeHidden"></textarea>
	                <textarea rows="10" cols="40" id="code_js" style="position: absolute; left: -10000px; width: 10px;"></textarea>
                           </div>
                        </div>
					
					</div>
					</div>
			</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" 
							data-dismiss="modal">取消
					</button>
					<button type="button" class="btn btn-primary" id="modalOkChoseBtn">
						确定
					</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->

<!-- modal end -->


<!--edit modal start -->
<div class="modal fade" id="editTemplateDataModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" 
							aria-hidden="true">×
					</button>
					<h4 class="modal-title" id="myModalLabel1">
						编辑模板数据源
					</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id='editTemplateDataForm'  action="${BASE_PATH}/manage/componentTemplate/updateDataJson.json" method="post">
					<div class="row">
					<input type="hidden" name="id" id='editParentId' value=""/>
					<div class="panel-body">
						<div class="form-group">
                          <label class="col-sm-3 col-sm-3 control-label">json配置英文名称</label>
                          <div class="col-sm-8">
                              <input  type="text" style="font-size:15px;width: 300px;" class="form-control" name="dataJsonEnName"
                              	placeholder="json配置英文名称" id="editDataJsonEnName" value="">
                              </input>
                          </div>
                        </div>
                        
                        <div class="form-group">
                          <label class="col-sm-3 col-sm-3 control-label">json配置名称</label>
                          <div class="col-sm-8">
                              <input  type="text" style="font-size:15px;width: 300px;" class="form-control" name="dataJsonName"
                              	placeholder="json配置名称" id="editDataJsonName" value="">
                              </input>
                          </div>
                        </div>
                        
                         <h3><span ></span>json配置代码</h3>
                         <div class="form-group">
		         <div class="col-sm-12">
			<textarea name="dataJsonCode" id="editHtmlCodeHidden" style="display:none"></textarea>
			<textarea rows="10" cols="40" id="editCode_js" style="position: absolute; left: -10000px; width: 10px;"></textarea>		  
		          </div>
	          </div>
                        
                       			
					</div>
					</div>
			</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" 
							data-dismiss="modal">取消
					</button>
					<button type="button" class="btn btn-primary" id="eidtModalOkChoseBtn">
						确定
					</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
<script type="text/javascript">
$(function() {
	   //初始添加数据源编辑器
	   var mixedModeJS = {
	     name : "javascript"
	 };

	var editorJS = CodeMirror.fromTextArea(document
			.getElementById("code_js"), {
		mode : mixedModeJS,
		selectionPointer : true,
		theme : "night",
		lineNumbers : true
	});
	editorJS.setSize(500, 400);

	  //初始化修改数据源编辑器
	  var editmixedModeJS = {
		name : "javascript"
	};
	//编辑框
	var editEditorJS = CodeMirror.fromTextArea(document
			.getElementById("editCode_js"), {
		mode : editmixedModeJS,
		selectionPointer : true,
		theme : "night",
		lineNumbers : true
	});
	editEditorJS.setSize(500, 400);
	//为初始加入进来的td赋值id  数据源模板列表
	$('#templateDataBody').children('tr').each(function(i, tar) {
		$(tar).attr('id', 'tr_' + (i + 1));
	});
	
	//删除组件数据源
	$(".js_template_data_delete").unbind("click").click(function() {
		console.log("====删除开始======");
		var target_data = $(this).parent().parent();
		var data_id = target_data.children('td').children('textarea').attr('data_id');
		$.post(
		       "${BASE_PATH}/manage/componentTemplate/deleteDataJson.json", 
		       {"id": data_id},
              	                      function(dataQuery) {
		               if (dataQuery.result) {
		            	      bootbox.alert("删除数据源成功",function() {$(target_data).remove();});
		            }
                   } ,"json");
	   });
	//编辑按钮点击事件
	$('.js_template_data_edit').click(
			function() {
				console.log("====编辑开始======");
				var target_tr = $(this).parent().parent();
				var dataJsonEnName = target_tr.children('td.dataJsonEnName').html();
				var data_id = target_tr.children('td').children('textarea').attr('data_id');
				var dataJsonName = $("#htmlCode"+data_id).attr("dataJsonName");
				var dataJsonCode = $("#htmlCode"+data_id).val();
				$('#editDataJsonEnName').val(dataJsonEnName);
				$('#editDataJsonName').val(dataJsonName);
				editEditorJS.setValue(dataJsonCode);
				$("#editTemplateDataModal").attr('target_tr_id',target_tr.attr('id'));
				$("#editTemplateDataModal").attr('data_id', data_id);
				$('#editParentId').val(data_id);
				$("#editTemplateDataModal").modal("show");
				console.log("====编辑结束======");
			});

	//修改数据源模板-确认-的点击事件
	$('#eidtModalOkChoseBtn').unbind('click').click(
	   function() {
		var dataJsonEnName = $('#editDataJsonEnName').val();
		var dataJsonName = $('#editDataJsonName').val();
		var htmlCode = editEditorJS.getValue();
		$('#editHtmlCodeHidden').val(htmlCode);
		if (dataJsonEnName == null || dataJsonEnName == "") {
			alert("json配置英文名称不能为空");
			return false;
		}
		if (dataJsonName == null || dataJsonName == "") {
			alert("json配置名称不能为空");
			return false;
		}
		if (htmlCode == null || htmlCode == "") {
			alert("json配置代码不能为空");
			return false;
		}
	        $('#editTemplateDataForm').submit();
	   });
	//修改数据源表单 的form事件
	$('#editTemplateDataForm').ajaxForm({
	      dataType : 'json',
	      success : function(data) {
		if (data.result) {
		var target_tr_id = $('#editTemplateDataModal').attr('target_tr_id');
		var target_tr = $('#' + target_tr_id);
		var data_id = $('#editParentId').val();
		target_tr.children('td.dataJsonEnName').html($('#editDataJsonEnName').val());
		var td_textarea = $("<textarea>",{"dataJsonName":$('#editDataJsonName').val(),"data_id":data_id,"id":"htmlCode"+data_id,"style":"display:none","html":editEditorJS.getValue()});
		target_tr.children('td.dataJsonName').html($('#editDataJsonName').val());
		target_tr.children('td.dataJsonName').append(td_textarea);//+
		target_tr.children('td.data_createTime').html(getNowDateStr());
		$('#editTemplateDataModal').modal('hide');
		bootbox.alert("编辑数据源实例成功", function() {});
		}
	        }
	 });
		
	//初始化添加 数据源模板函数
	$('#addTemplateData').click(function() {
		editorJS.setValue("");
		$("#dataJsonName").val("");
		$("#dataJsonEnName").val("");
		$("#addTemplateDataModal").modal("show");
	});
	
	//新加数据源-确认-按钮点击事件
	$('#modalOkChoseBtn').unbind('click').click(function() {
		console.log("=====新加数据源开始=========");
		var templateId = $('#templateId').val();
		$('#parentId').val(templateId)
		var dataJsonEnName = $("#dataJsonEnName").val();
		var dataJsonName = $("#dataJsonName").val();
		var htmlCode = editorJS.getValue();
		$('#htmlCodeHidden').val(htmlCode);
		if (dataJsonEnName == null || dataJsonEnName == "") {
			alert("json配置英文名称不能为空");
			return false;
		}
		if (dataJsonName == null || dataJsonName == "") {
			alert("json配置名称不能为空");
			return false;
		}
		if (htmlCode == null || htmlCode == "") {
			alert("json配置代码不能为空");
			return false;
		}
		$('#addTemplateDataForm').submit();
	});

	//新加数据源实例模态框提交表单
	$('#addTemplateDataForm').ajaxForm({
		dataType : 'json',
		success : function(data) {
			if (data.result) {
				        var  templateDataBody=$("#templateDataBody");
						var tr_size=templateDataBody.children('tr').size();
						var tr_1=$('<tr>',{"class":"gradeA odd",'id':'tr_'+(tr_size+1)});
						var tr_1_td_1=$('<td>',{"html":$("#dataJsonEnName").val(),"class":"dataJsonEnName"});
						var tr_1_td_2=$('<td>',{"html":$("#dataJsonName").val(),"class":"dataJsonName"});
						var td_textarea = $("<textarea>",{"dataJsonName":$("#dataJsonName").val(),"data_id":data.dataJsonId,"id":"htmlCode"+data.dataJsonId,"style":"display:none","html":editorJS.getValue()});
			                                              tr_1_td_2.append(td_textarea);
						var tr_1_td_3=$('<td>',{});
						var tr_1_td_3_a1=$('<a>',{"class":"js_template_data_edit","title":"编辑","html":"编辑"});
						var tr_1_td_3_span=$('<span>',{ "html":"|"});
						var tr_1_td_3_a2=$('<a>',{"class":"js_template_data_delete","title":"删除数据源","html":"删除"});
						var data_createTime=getNowDateStr();
						var tr_1_td_4=$('<td>',{"html":data_createTime,"class":"data_createTime"});
						tr_1_td_3.append(tr_1_td_3_a1);
						tr_1_td_3.append(tr_1_td_3_span);
						tr_1_td_3.append(tr_1_td_3_a2);
						tr_1.append(tr_1_td_2);
						tr_1.append(tr_1_td_1);
						tr_1.append(tr_1_td_4);
						tr_1.append(tr_1_td_3);
						templateDataBody.append(tr_1);
						$("#addTemplateDataModal").modal("hide");
						bootbox.alert("添加数据源实例成功", function() {});
						
					     
			}
		}
	});
	
                   //编辑按钮 点击事件
	    $('#updateTemplate').click(
			function() {
			   var templateName = $('#templateName').val();
			   var templateId = $('#templateId').val();
			   var componentId = $('#componentId option:selected').val();
			   var isDefault = $('#isDefault option:selected').val();
			   var templateObj = {  'templateId' : templateId,
				         'templateName' : templateName,
				         'componentId' : componentId,
				         'isDefault' : isDefault
				         };

			$.ajax({
			url : '${BASE_PATH}/manage/componentTemplate/updateTemplate.json',
			type : "POST",
			dataType : "json",
			async : false,
			contentType : 'application/json',
			data : JSON.stringify(templateObj),
			success : function(data) {
			window.location.href = '${BASE_PATH}/manage/componentTemplate/update.htm?templateId='+ templateId;
				},
			});
		});

	/**-----------获取当前时间字符串-----------------------*/
	function getNowDateStr() {
		var createTime = new Date();
		var data_year = createTime.getFullYear();
		var data_month = createTime.getMonth() + 1;
		var data_month_str = data_month + '';
		if (data_month < 10) {
			data_month_str = '0' + data_month_str;
		}
		var data_day = createTime.getDate();
		var data_day_str = data_day + '';
		if (data_day < 10) {
			data_day_str = '0' + data_day_str;
		}
		var data_createTime = data_year + '-' + data_month_str + '-'
				+ data_day_str;
		return data_createTime;
	}

});
</script>
<#include "/manage/foot.ftl">
