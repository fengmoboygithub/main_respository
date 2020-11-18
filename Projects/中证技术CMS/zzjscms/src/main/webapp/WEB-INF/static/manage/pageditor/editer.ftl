<#assign pageditorPath=BASE_PATH+"/static/manage/pageditor/">
<#assign codeEditerPath=BASE_PATH+"/static/manage/codeEditer/">
<!DOCTYPE html>
<html lang="cn">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="layoutit bootstrap3"" />
<meta name="description" content="布局编辑器工作台" />
<meta name="language" content="en" />
<script type="text/javascript">var contextPath = "${BASE_PATH}/WEB-INF/static/manage/pageditor/";var NREUMQ=NREUMQ||[];NREUMQ.push(["mark","firstbyte",new Date().getTime()]);</script>
<title>布局编辑器工作台</title>
<link href="${pageditorPath}skin/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageditorPath}skin/css/layoutit.css" rel="stylesheet">
<link href="${pageditorPath}skin/css/bootstrap.extend.css" rel="stylesheet">
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
<script src="${pageditorPath}skin/js/html5shiv.js"></script>
<![endif]-->
<!-- Fav and touch icons -->
<link rel="apple-touch-icon-precomposed" sizes="144x144" href="${pageditorPath}skin/img/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114" href="${pageditorPath}skin/img/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72" href="${pageditorPath}skin/img/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed" href="${pageditorPath}skin/img/apple-touch-icon-57-precomposed.png">
<link rel="shortcut icon" href="${pageditorPath}skin/img/favicon.png">

<script type="text/javascript" src="${pageditorPath}skin/js/jquery.min.js"></script>
<script src="${BASE_PATH}/static/manage/js/jquery.form.min.js"></script>
<script src="${BASE_PATH}/static/manage/js/bootbox.min.js"></script>
<link rel="stylesheet" href="${codeEditerPath}js/CodeMirror-2.25/lib/codemirror.css">
<link rel="stylesheet" href="${codeEditerPath}js/CodeMirror-2.25/theme/night.css">
<script type="text/javascript" src="${codeEditerPath}js/CodeMirror-2.25/lib/codemirror.js"></script>
<script type="text/javascript" src="${codeEditerPath}js/CodeMirror-2.25/addon/selection/selection-pointer.js"></script>
<script type="text/javascript" src="${codeEditerPath}js/CodeMirror-2.25/mode/xml/xml.js"></script>
<script type="text/javascript" src="${codeEditerPath}js/CodeMirror-2.25/mode/javascript/javascript.js"></script>
<script type="text/javascript" src="${codeEditerPath}js/CodeMirror-2.25/mode/css/css.js"></script>
<script type="text/javascript" src="${codeEditerPath}js/CodeMirror-2.25/mode/vbscript/vbscript.js"></script>
<script type="text/javascript" src="${codeEditerPath}js/CodeMirror-2.25/mode/htmlmixed/htmlmixed.js"></script>
<script type="text/javascript">
    var _pageditorPath = "${pageditorPath}";
    var _BasePath = "${BASE_PATH}";
    //操作类型   page：可视化编辑入口 modal：模态弹窗
	var optType = "${optType!}";
	//页面id
	var fileId = "${fileId!}";
	//var mapCodeMap = ${mapCodeJson!};
</script>
<script type="text/javascript" src="${pageditorPath}skin/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="${pageditorPath}skin/js/jquery.ui.touch-punch.min.js"></script>
<script type="text/javascript" src="${pageditorPath}skin/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageditorPath}skin/js/jquery.htmlClean.js"></script>

<script type="text/javascript" src="${pageditorPath}skin/js/common-scripts.js"></script>
<script type="text/javascript" src="${pageditorPath}skin/js/scripts.min.js"></script>

<script type="text/javascript" src="${pageditorPath}skin/js/baseInterface.js"></script>
<script type="text/javascript" src="${pageditorPath}skin/js/jquery.paging-1.0.1.js"></script>
<script type="text/javascript" src="${pageditorPath}skin/js/jquery.table-assi-1.0.1.js"></script>

</head>
<body class="edit">
	<div class="navbar navbar-inverse navbar-fixed-top navbar-layoutit">
    <div class="navbar-header">
      <button data-target="navbar-collapse" data-toggle="collapse" class="navbar-toggle" type="button">
        <span class="glyphicon-bar"></span>
        <span class="glyphicon-bar"></span>
        <span class="glyphicon-bar"></span>
      </button>
      <a class="navbar-brand" href="javascript:void(0);">可视化布局<span class="label label-default">BETA</span></a>
    </div>
    <div class="collapse navbar-collapse">
      
      <ul class="nav" id="menu-layoutit">
        <li>
          <div class="btn-group" data-toggle="buttons-radio">
            <!--<button type="button" id="edit" class="active btn btn-xs btn-primary"><i class="glyphicon glyphicon-edit "></i> 编辑</button>
            <button type="button" class="btn btn-xs btn-primary" id="devpreview"><i class="glyphicon-eye-close glyphicon"></i> 布局编辑</button>-->
            <button type="button" class="btn btn-xs btn-primary" id="sourcepreview"><i class="glyphicon-eye-open glyphicon"></i> 预览</button>
          </div>
          <div class="btn-group">	
            <button class="btn btn-xs btn-primary" id="button-share-modal" href="javascript:void(0);"><i class="glyphicon-share glyphicon"></i> 保存</button>
            <button class="btn btn-xs btn-primary" href="#clear" id="clear" ><i class="glyphicon-trash glyphicon"></i> 清空</button>
            <#if optType??>
            	<#if optType=='modal'>
		            <button class="btn btn-xs btn-primary" href="#exit" id="exit" ><i class="glyphicon-remove glyphicon"></i> 退出</button>
            	</#if>
            </#if>
            
          </div>
        </li>
      </ul>
    </div><!--/.navbar-collapse -->
	</div><!--/.navbar-fixed-top -->
	
	<div class="container">
		<div class="row">
	<div class="">
		<div class="sidebar-nav">
			<!--组件类型列表及其组件列表-->
			<#list allTypeList as typeItem>  
				<ul class="nav nav-list accordion-group">
					<li class="nav-header">
						<i class="glyphicon-plus glyphicon"></i> ${typeItem.compTypeName!}  
						<div class="pull-right popover-info">
						<i class="glyphicon glyphicon-question-sign"></i>
						<#if typeItem.components?size != 0>
							<div class="popover fade right">
								<div class="arrow"></div>
								<h3 class="popover-title">提示：</h3>
								<div class="popover-content">${typeItem.compTypeTip!}</div>
								</div>
							</div>
						</#if>
					</li>
					<#if typeItem.components?size = 0>
						<li class="boxes mute">
							<div class="preview">建设中...</div>
						</li>
					<#else>
						<#if typeItem.htmlId = 'estRows'>
							<!--布局组件-->
							<li id="${typeItem.htmlId!}" class="rows">
								<#list typeItem.components as objItem>
									<div class="lyrow">
										<a class="remove label label-danger" href="#close">
											<i class="glyphicon-remove glyphicon"></i>删除
										</a>
										<span class="drag label label-default" htmlid="estRows">
											<i class="glyphicon glyphicon-move"></i>拖动
										</span>
										<div class="preview">
											<input class="form-control" value="${objItem.componentName!}" type="text">
										</div>
										<div class="view">
											${objItem.htmlCode!}
										</div>
									</div>
								</#list>
							</li>
						<#else>
							<!--功能组件-->
							<li id="${typeItem.htmlId!}" class="boxes">
								<#list typeItem.components as objItem>
									<div class="box box-element">
										<a class="remove label label-danger js_delete" href="#close">
											<i class="glyphicon-remove glyphicon"></i>删除
										</a>
										<span class="drag label label-default" componentId="${objItem.componentId!}" componentName="${objItem.componentName!}">
											<i class="glyphicon glyphicon-move"></i>拖动
										</span>
										<span class="configuration">
											<a class="btn btn-xs btn-info js_startedit off_me" href="javascript:void(0);">开启编辑模式</a>
											<a class="btn btn-xs btn-info js_setup" href="javascript:void(0);">设置模板</a>
											<a class="btn btn-xs btn-info js_chose" href="javascript:void(0);">选择模板</a>
											<a class="btn btn-xs btn-info js_test" href="javascript:void(0);">代码测试器</a>
										</span>
										<div class="preview">${objItem.componentName!}</div>
										<div class="view">
											<div class="render">
											</div>
										</div>
									</div>
								</#list>
							</li>
						</#if>
					</#if>
				</ul>
			</#list> 
		</div>
	</div>
	<!--内容区域 开始-->
	<div class="demo">
		<#if htmlCodeByEdit??>
			${htmlCodeByEdit!}
		</#if>
	</div>
	<!--内容区域 结束-->
	<div id="download-layout">
		<!-- 可编辑内容区域 开始 -->
		<div class="container"></div>
		<!-- 可编辑内容区域 结束 -->
	</div>
</div>
<!--/row-->

	</div><!--/.fluid-container-->
	<div class="modal fade" id="editDataJsonModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" 
							aria-hidden="true">×
					</button>
					<h4 class="modal-title" id="myModalLabel">
						编辑数据源实例
					</h4>
				</div>
				<div class="modal-body">
					<form id="edit_data_json_form" class="form-horizontal" action="${BASE_PATH}/manage/componentInstance/updateByDataJsonInstance.json" method="post">
						<div class="panel-body">
							<h3><span id="dataJsonName"></span>json配置代码</h3>
							<input type="hidden" name="id" value=""/>
							<input type="hidden" name="instanceId" value=""/>
	                        <div class="form-group">
	                              <div class="col-sm-12">
									  <textarea name="dataJsonCode" id="dataJsonCode" style="display:none"></textarea>
		                          	  <textarea rows="10" cols="40" id="code_edit_js" style="position: absolute; left: -10000px; width: 10px;"></textarea>		  
	                              </div>
                        	</div>
                        </div> 
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" 
							data-dismiss="modal">取消
					</button>
					<button type="button" class="btn btn-primary" id="modalOkEditBtn">
						确定
					</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	
	<!-- 设置模板 模态框（Modal）-->
	<div class="modal fade" id="setupTemplateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" 
							aria-hidden="true">×
					</button>
					<h4 class="modal-title" id="myModalLabel">
						设置模板
					</h4>
				</div>
				<div class="modal-body">
					<form id="setup_template_form" class="form-horizontal" action="${BASE_PATH}/manage/componentInstance/setupTemplate.json" method="post">
							<input type="hidden" name="id" value=""/>
							<input type="hidden" name="componentId" value=""/>
							<div class="row org_row_two">
								<label class="col-sm-2 control-label">模板名称</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" name="templateName" id="templateName" placeholder="请输入模板名称" validateAttr="模板名称"/>
									</input>
								</div>
							</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" 
							data-dismiss="modal">取消
					</button>
					<button type="button" class="btn btn-primary" id="modalOkSetupBtn">
						确定
					</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	<!-- 选择组件模板 模态框（Modal）-->
	<div class="modal fade" id="choseTemplateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" 
							aria-hidden="true">×
					</button>
					<h4 class="modal-title" id="myModalLabel">
						选择<span id="componentName"></span>组件模板
					</h4>
				</div>
				<div class="modal-body">
					<form id="chose_template_form" action="${BASE_PATH}/manage/componentInstance/update.json" method="post">
							<input type="hidden" name="id" value=""/>
							<input type="hidden" name="fileId" value=""/>
							<input type="hidden" name="componentId" value=""/>
							<input type="hidden" name="templateId" value=""/>
					</form>
					<!-- 查询条件块start -->
					<section class="panel top_content">
						<div class="panel-body">
							<form id="search_form_question" class="form-horizontal" method="post">
								<div class="row org_row_two">
									<label class="col-sm-2 control-label">模板名称</label>
									<div class="col-sm-6">
										<input type="hidden" id="templateComponentId" name="templateComponentId" value=""/>
										<input type="text" class="form-control" name="templateName" id="templateName" placeholder="请输入模板名称" validateAttr="模板名称"/>
										</input>
									</div>
									<div class="col-sm-4">
										<button class="btn btn-shadow btn-primary" style="float:center;" type="button" id="searchTemplateBtn">查询</button>
									</div>
								</div>
							</form>
						</div>
					</section>
					<!-- 查询条件块end -->
					<!-- 列表 start-->
					<section class="panel">
						<div class="">
							<div class="adv-table">
								<div role="grid" class="dataTables_wrapper questionGridTable" id="hidden-table-info_wrapper">
									<table class="table table-striped table-advance table-hover" id="listTable">
										<thead>
											<tr>
												<th width="3%"><input type="checkbox" class="js_checkbox_all" id="allCheckQuesBtn"/></th>
												<th width="10%">序号</th>
												<th column-assi="templateName_text">模板名称</th>
												<th column-assi="isDefault_isDefaultConverter_converter">是否默认</th>
											</tr>
										</thead>
										<tbody role="alert" aria-live="polite" aria-relevant="all" class="list_data">
										</tbody>
									</table>
									<div style="height: 30px;">
										<div class="pagination">
										</div>
									</div>
								</div>
							</div>
						</div>
					</section>
					<!-- 列表 end-->
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
</body>
</html>
