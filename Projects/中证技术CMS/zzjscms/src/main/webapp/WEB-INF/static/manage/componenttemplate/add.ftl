<#assign menu="component_template">
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
		<div id="add_component_form"  class="form-horizontal" action="javascript.void(0);"  autocomplete="off"  >
		<div class="row">
			
			<div class="col-lg-12">
				<section class="panel">
					<header class="panel-heading"> 
						增加模板
					</header>
					<div class="panel-body">
						<div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">模板名称</label>
                          <div class="col-sm-10">
                              <input type="text" style="font-size:15px;width: 300px;" class="form-control" 
                              	placeholder="模板名称" id="templateName" >
                              </input>
                          </div>
                        </div>
						
						<div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">选择组件</label>
                          <div class="col-sm-10">
                             	<select class="js_component_check form-control" style="font-size:15px;width: auto;"  id="componentId" >
                             		<option >--请选择--</option>
									<#list componentList as component>
										<option value="${component.componentId!}">${component.componentName!}</option>
									</#list>
								</select>
                          </div>
                        </div>
						<div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">是否默认</label>
                          <div class="col-sm-10">
                             	<select class="js_component_check form-control" style="font-size:15px;width: auto;"  id="isDefault" >
                             		<option >--请选择--</option>
										<option value="0" >否</option>
										<option value="1" >是</option>
								</select>
                          </div>
                        </div>					
						
                        
                        
                        
                       
                        
                        
                        
	                    <div class="form-group">
	                  	  <div class="col-lg-offset-2 col-lg-10">
	                      <button class="btn btn-shadow btn-primary" id='saveTemplate'>保存</button>
	                      <button class="btn btn-shadow btn-primary" type="button" onclick="javascript:history.back(-1);">返回</button>
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
									<th>操作</th>
								</tr>
							</thead>
							<tbody id="templateDataBody" role="alert" aria-live="polite" aria-relevant="all">
										
							</tbody>
						</table>
					</div>
					
				</section>
			</div>
		</div>
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
					<form class="form-horizontal">
					<div class="row">
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
                        
                        <div class="form-group">
                          <label class="col-sm-3 col-sm-3 control-label">json配置代码</label>
                          <div class="col-sm-8">
                          		  <input type="hidden" name="htmlCode" id="htmlCodeHidden"/>
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
					<form class="form-horizontal">
					<div class="row">
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
                        
                        <div class="form-group">
                          <label class="col-sm-3 col-sm-3 control-label">json配置代码</label>
                          <div class="col-sm-8">
                          		  <input type="hidden" name="htmlCode" id="editHtmlCodeHidden"/>
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
					<button type="button" class="btn btn-primary" id="eidtodalOkChoseBtn">
						确定
					</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->

<!-- edit modal end -->


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
      editorJS.setSize(400,300);
      
    
      
       //添加模板数据函数
      $('#addTemplateData').click(function(){
      	editorJS.setValue("");
      	$("#dataJsonName").val("");
      	$("#dataJsonEnName").val("");
      	$("#addTemplateDataModal").modal("show");
      });
      

/**===================添加数据源的确认按钮事件==============================*/
$("#modalOkChoseBtn").click(function(){
	
	var dataJsonEnName=$("#dataJsonEnName").val();
	var dataJsonName=$("#dataJsonName").val();
	var htmlCode = editorJS.getValue();
	if(dataJsonEnName == null || dataJsonEnName ==""){
		alert("json配置英文名称不能为空");
		return false;
	}
	if(dataJsonName == null || dataJsonName ==""){
		alert("json配置名称不能为空");
		return false;
	}
	if(htmlCode == null || htmlCode ==""){
		alert("json配置代码不能为空");
		return false;
	}
	var  templateDataBody=$("#templateDataBody");
	var tr_size=templateDataBody.children('tr').size();
	var tr_1=$('<tr>',{"class":"gradeA odd","htmlCode":htmlCode,'id':'tr_'+(tr_size+1)});
	var tr_1_td_1=$('<td>',{"html":dataJsonEnName,"class":"dataJsonEnName"});
	var tr_1_td_2=$('<td>',{"html":dataJsonName,"class":"dataJsonName"});
	var tr_1_td_3=$('<td>',{});
	var tr_1_td_3_a1=$('<a>',{"class":"js_template_data_edit","title":"编辑","html":"编辑"});
	var tr_1_td_3_span=$('<span>',{ "html":"|"});
	var tr_1_td_3_a2=$('<a>',{"class":"js_template_data_delete","title":"删除数据源","html":"删除"});
	tr_1_td_3.append(tr_1_td_3_a1);
	tr_1_td_3.append(tr_1_td_3_span);
	tr_1_td_3.append(tr_1_td_3_a2);
	tr_1.append(tr_1_td_2);
	tr_1.append(tr_1_td_1);
	
	tr_1.append(tr_1_td_3);
	templateDataBody.append(tr_1);
	$("#addTemplateDataModal").modal("hide");
	
	/**===================删除点击时间绑定 start==============================*/
	tr_1_td_3_a2.click(function(){
      	console.log("==============");
      	var target_data=$(this).parent().parent();
		var status= "trash";
		bootbox.dialog({
			message : $(this).attr('title'),
			title : "提示",
			buttons : {
					"delete" : {
						label : "确定",
						className : "btn-success",
						callback : function() {
							target_data.remove();
						}
					},
					"cancel" : {
						label : "取消",
						className : "btn-primary",
						callback : function() {}
								}
					}
					});	
      
      		});
     /**===================删除点击时间绑定 end==============================*/	
     /**===================编辑点击时间绑定 start==============================*/	
		tr_1_td_3_a1.click(function(){
			console.log("==========");
			var target_tr=$(this).parent().parent();
			var dataJsonEnName=target_tr.children('td.dataJsonEnName').html();
			var dataJsonName=target_tr.children('td.dataJsonName').html();
			$('#editDataJsonEnName').val(dataJsonEnName);
			$('#editDataJsonName').val(dataJsonName);
			editEditorJS.setValue(target_tr.attr('htmlCode'));
			$("#editTemplateDataModal").attr('target_tr_id',target_tr.attr('id'));
			$("#editTemplateDataModal").modal("show");
						});	
     /**===================编辑点击时间绑定 end==============================*/	
});

/**===================编辑框设定 start==============================*/	
	var editmixedModeJS = {
        name: "javascript"
      };
	//编辑框
  	var editEditorJS = CodeMirror.fromTextArea(document.getElementById("editCode_js"), {
        mode: editmixedModeJS,
        selectionPointer: true,
		theme:"night",
		lineNumbers: true
      });
      editEditorJS.setSize(400,300);
/**===================编辑框设定 end==============================*/	


/**===================编辑modal的确认事件==============================*/	
$('#eidtodalOkChoseBtn').click(function(){
	var dataJsonEnName=$('#editDataJsonEnName').val();
	var dataJsonName=$('#editDataJsonName').val();
	var htmlCode=editEditorJS.getValue();
	if(dataJsonEnName == null || dataJsonEnName ==""){
		alert("json配置英文名称不能为空");
		return false;
		}
	if(dataJsonName == null || dataJsonName ==""){
		alert("json配置名称不能为空");
		return false;
		}
	if(htmlCode == null || htmlCode ==""){
		alert("json配置代码不能为空");
		return false;
		}	
	var target_tr_id=$('#editTemplateDataModal').attr('target_tr_id');
	
	var target_tr=$('#'+target_tr_id);
	target_tr.attr('htmlCode',htmlCode);
	target_tr.children('td.dataJsonEnName').html(dataJsonEnName);
	target_tr.children('td.dataJsonName').html(dataJsonName);
	$('#editTemplateDataModal').modal('hide');
	

	});   
	
/**===================保存模板的按钮点击事件==============================*/  
$('#saveTemplate').click(function(){
		var templateName=$('#templateName').val();
		var componentId=$('#componentId option:selected').val();
		var isDefault=$('#isDefault option:selected').val();
		var templateObj={'templateName':templateName,'componentId':componentId,'isDefault':isDefault};
		
		//获取模板的数据源
		var templateDataArray=[];
		$('#templateDataBody').children('tr').each(function(){
				var dataJsonEnName=$(this).children('td.dataJsonEnName').html();
				var dataJsonName=$(this).children('td.dataJsonName').html();
				var htmlCode=$(this).attr('htmlCode');
				var templateData={'dataJsonEnName':dataJsonEnName,'dataJsonName':dataJsonName,'htmlCode':htmlCode};
				templateDataArray.push(templateData);
			});
		templateObj['templateDataArray']=templateDataArray;
		
		$.ajax({
			url:'${BASE_PATH}/manage/componentTemplate/addTemplate.json',
			type:"POST",  
            dataType:"json",  
            async:false, 
            contentType : 'application/json',
            data:JSON.stringify(templateObj),
            success:function(data){  
                console.log('返回result='+data);
				window.location.href='${BASE_PATH}/manage/componentTemplate/list.htm'; 
            },  
		});
	
		

	});

});



</script>
<#include "/manage/foot.ftl">