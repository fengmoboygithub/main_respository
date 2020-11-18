<#assign menu="site">
<#assign submenu="add_fileInfo">
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
		<form id="add_fileInfo_form" class="form-horizontal" action="${BASE_PATH}/manage/fileInfo/add.json"  autocomplete="off"  method="post">
		<div class="row">
			<div class="col-lg-12">
				<section class="panel">
					<header class="panel-heading"> 
						增加文件
					</header>
					<div class="panel-body">
						<input type="hidden" name="siteId" id="siteId" value="${siteId}"/>
                        <div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">所属目录</label>
                          <div class="col-sm-10">
                              <select class="form-control" name="folderId" style="font-size:15px;width: 300px;">
			                   		<#list folderAll as folder>
			                        	<option value="${folder.folderId}" <#if folder.folderId==folderId>selected</#if>>
			                        	${folder.pathName}
			                        	</option>
			                        </#list>							
	                            </select>			
                          </div>
                        </div>  
                        <div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">中文名称</label>
                          <div class="col-sm-10">
                              <input type="text" style="font-size:15px;" class="form-control" name="name"
                              	placeholder="中文名称" id="name" >
                              </input>
                          </div>
                        </div>
                        <div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">英文名称</label>
                          <div class="col-sm-10">
                              <input type="text" style="font-size:15px;" class="form-control" name="ename"
                              	placeholder="英文名称" id="ename" >
                              </input>
                          </div>
                        </div>   
                        <div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">文件状态</label>
                          <div class="col-sm-10" style="margin-bottom:10px;">
                          	<input name="status" value="display" type="radio" checked> 显示
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="status" value="hidden" type="radio"> 隐藏
                          </div>
                        </div>
                        <div class="form-group">
                      	  <div class="col-lg-offset-2 col-lg-10">
                          <button class="btn btn-shadow btn-primary" type="submit">新建</button>
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
	$(".fancybox").fancybox({
		'width':$("body").width()*0.9,
		'height':$("body").height()*0.9,
		'autoScale': true,
	});
	$('#add_fileInfo_form').ajaxForm({
		dataType : 'json',
		success : function(data) {
			if (data.result) {
				bootbox.alert("保存成功，将刷新页面", function() {
					window.location.reload();
				});
			}else{
				showErrors($('#add_fileInfo_form'),data.errors);
			}
		}
	});
});
</script>
<#include "/manage/foot.ftl">