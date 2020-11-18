<#assign pageditorPath=BASE_PATH+"/static/manage/pageditor/">
<#assign codeEditerPath=BASE_PATH+"/static/manage/codeEditer/">
<!DOCTYPE html>
<html lang="cn">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="layoutit bootstrap3"" />
<meta name="description" content="Layout It 是一个在线工具，它可以简单而又快速搭建 Bootstrap 响应式布局，操作基本是使用拖动方式来完成，很简单哦，而元素都是基于Bootstrap框架集成的，所以这工具很适合网页设计师和前端开发人员使用，快捷方便，好吧，接下来大家一起试试这个Layout It布局工具。" />
<meta name="language" content="en" />
<script type="text/javascript">var contextPath = "${BASE_PATH}/WEB-INF/static/manage/pageditor/";var NREUMQ=NREUMQ||[];NREUMQ.push(["mark","firstbyte",new Date().getTime()]);</script>
<title>layoutit bootstrap3中文版可拖放排序在线编辑的bootstrap可视化布局系统</title>
<link href="${pageditorPath}skin/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageditorPath}skin/css/layoutit.css" rel="stylesheet">
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
    var _BasePath = "${BASE_PATH}";
</script>
<script type="text/javascript" src="${pageditorPath}skin/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="${pageditorPath}skin/js/jquery.ui.touch-punch.min.js"></script>
<script type="text/javascript" src="${pageditorPath}skin/js/bootstrap.min.js"></script>

<script type="text/javascript" src="${pageditorPath}skin/js/jquery.htmlClean.js"></script>
<script type="text/babel" src="${pageditorPath}skin/js/scripts.min.js"></script>
<script type="text/javascript" src="${pageditorPath}skin/js/base.js"></script>
<script type="text/javascript" src="${pageditorPath}skin/js/jquery.paging-1.0.1.js"></script>
<script type="text/javascript" src="${pageditorPath}skin/js/common-scripts.js"></script>

<script type="text/javascript" src="${pageditorPath}skin/js/xcConfirm.js"></script>
<script type="text/javascript" src="${pageditorPath}skin/js/lhgdialog.min.js"></script>
<script type="text/javascript" src="${pageditorPath}skin/js/common.js"></script>
<script type="text/javascript" src="${pageditorPath}skin/js/baseInterface.js"></script>
<script type="text/javascript" src="${pageditorPath}skin/js/react.min.js"></script>
<script type="text/javascript" src="${pageditorPath}skin/js/react-dom.min.js"></script>
<script type="text/javascript" src="${pageditorPath}skin/js/babel.min.js"></script>

</head>
<body class="edit">
	<div class="navbar navbar-inverse navbar-fixed-top navbar-layoutit">
    <div class="navbar-header">
      <button data-target="navbar-collapse" data-toggle="collapse" class="navbar-toggle" type="button">
        <span class="glyphicon-bar"></span>
        <span class="glyphicon-bar"></span>
        <span class="glyphicon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">可视化布局<span class="label label-default">BETA</span></a>
    </div>
    <div class="collapse navbar-collapse">
      
      <ul class="nav" id="menu-layoutit">
        <li>
          <div class="btn-group" data-toggle="buttons-radio">
            <button type="button" id="edit" class="active btn btn-xs btn-primary"><i class="glyphicon glyphicon-edit "></i> 编辑</button>
            <button type="button" class="btn btn-xs btn-primary" id="devpreview"><i class="glyphicon-eye-close glyphicon"></i> 布局编辑</button>
            <button type="button" class="btn btn-xs btn-primary" id="sourcepreview"><i class="glyphicon-eye-open glyphicon"></i> 预览</button>
          </div>
          <div class="btn-group">	
            <button class="btn btn-xs btn-primary" id="button-share-modal" href="${pageditorPath}template/saveLayout.html" role="button" data-toggle="modal" data-target="#shareModal"><i class="glyphicon-share glyphicon"></i> 保存</button>
            <button class="btn btn-xs btn-primary" href="#clear" id="clear" ><i class="glyphicon-trash glyphicon"></i> 清空</button>
            <button class="btn btn-xs btn-primary" href="#exit" id="exit" ><i class="glyphicon-remove glyphicon"></i> 退出</button>
          </div>
        </li>
      </ul>
    </div><!--/.navbar-collapse -->
	</div><!--/.navbar-fixed-top -->
	
	<div class="container">
		<div class="row">
	<div class="">
		<div class="sidebar-nav">
			
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
	<!-- 保存 -->
	<div class="modal fade" id="shareModal" tabindex="-1" role="dialog" aria-labelledby="shareModalLabel" aria-hidden="true"></div>
	<!--模态框（Modal） -->
	<div class="modal fade" id="addInstanceModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" 
							aria-hidden="true">×
					</button>
					<h4 class="modal-title" id="myModalLabel">
						新增<span id="componentName"></span>组件实例
					</h4>
				</div>
				<div class="modal-body">
					<button type="button" class="btn btn-default" 
							data-dismiss="modal">取消
					</button>
					<button type="button" class="btn btn-primary" id="modalOkAddBtn">
						确定
					</button>
					<form id="add_instance_form" class="form-horizontal" action="${BASE_PATH}/manage/componentInstance/add.json" method="post">
						<div class="panel-body">
	                        <h3>React代码</h3>
							<input type="hidden" name="fileId" value="${fileId!}"/>
							<input type="hidden" name="componentId" value=""/>
							<input type="hidden" name="htmlCode" id="htmlCodeAddMe"/>
		                    <textarea rows="10" cols="40" id="code_add_js" style="position: absolute; left: -10000px; width: 10px;"></textarea>
                        	</div>
                        </div> 
					</form>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	
	<div class="modal fade" id="editInstanceModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" 
							aria-hidden="true">×
					</button>
					<h4 class="modal-title" id="myModalLabel">
						编辑<span id="componentName"></span>组件实例
					</h4>
				</div>
				<div class="modal-body">
					<button type="button" class="btn btn-default" 
							data-dismiss="modal">取消
					</button>
					<button type="button" class="btn btn-primary" id="modalOkEditBtn">
						确定
					</button>
					<form id="edit_instance_form" class="form-horizontal" action="${BASE_PATH}/manage/componentInstance/update.json" method="post">
						<div class="panel-body">
							<h3>React代码</h3>
							<input type="hidden" name="id" value=""/>
							<input type="hidden" name="fileId" value=""/>
							<input type="hidden" name="componentId" value=""/>
	                        <div class="form-group">
	                              <div class="col-sm-12">
									  <input type="hidden" name="htmlCode" id="htmlCodeEditMe"/>
		                          	  <textarea rows="10" cols="40" id="code_edit_js" style="position: absolute; left: -10000px; width: 10px;"></textarea>		  
	                              </div>
                        	</div>
                        </div> 
					</form>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
</body>
<script type="text/javascript">
			var sourceCode;
			var htmlCodeByEdit;
			var fileId = "${fileId!}";
			//源码
			function writeSourceHtml(meHtml){
				//console.log("writeSourceHtml："+meHtml);
				if(meHtml){
					sourceCode = html_decode(meHtml);
				} else {
					sourceCode = "";
				}
			}
			
			//编辑区域源代码
			function writeEditHtml(meHtml) {
				//console.log("writeEditHtml："+meHtml);
				if(meHtml){
					htmlCodeByEdit = html_decode(meHtml);
				} else {
					htmlCodeByEdit = "";
				}
			}
			
			//保存源码
			function saveHtml() {
				$.ajax({
					type : "post",
					url : "${BASE_PATH}/manage/pageditor/saveHtmlCodeByEdit.json",
					dataType : "json",
					data : {"sourceCode":sourceCode,"htmlCodeByEdit":htmlCodeByEdit,"fileId":fileId},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						console.log("保存失败："+textStatus+"--"+errorThrown);
					},
					success : function(json) {
						if (json.result) {
							console.log("保存成功："+json.msg);
						} else {
							console.log("保存失败："+json.msg);
						}
						
					}
				});
			}
			
			$(document).ready(function() {
				// 加载组件类型
				initComponentTypes();
			});


			/**
			 * 初始化组件类型
			 */
			function initComponentTypes() {
				$.ajax({
					type : "get",
					url : "${BASE_PATH}/manage/component/getAllComponentTypes.json",
					dataType : "json",
					data : {},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						console.log("获取数据失败："+textStatus+"--"+errorThrown);
					},
					success : function(json) {
						if (json.result) {
							if (json.list != null && json.list.length > 0) {
								var siderbar = $(".sidebar-nav");
								
								//处理组件类型数据
								$.each(json.list, function(index, obj){
									//组件父节点
									var siderUl = $("<ul>",{"class":"nav nav-list accordion-group"});
									
									var typeHeader = $("<li>",{"class":"nav-header"});
									var typei = $("<i>",{"class":"glyphicon-plus glyphicon"});
									var text = " "+obj.compTypeName+" ";
									var rightDiv = $("<div>",{"class":"pull-right popover-info"});
									var righti = $("<i>",{"class":"glyphicon glyphicon-question-sign"});
									var rightFadeDiv = $("<div>",{"class":"popover fade right"})
										.append($("<div>",{"class":"arrow"}))
										.append($("<h3>",{"class":"popover-title",html:"提示："}))
										.append($("<div>",{"class":"popover-content",html:(obj.compTypeTip)}));
																		
									typeHeader.append(typei);
									typeHeader.append(text);
									typeHeader.append(rightDiv);
									rightDiv.append(righti);
									rightDiv.append(rightFadeDiv);
									siderUl.append(typeHeader);
									
									
									//子节点
									if (obj.components != null && obj.components.length > 0) {
										//组件类型下的组件
										initComponents(obj, siderUl);
									} else {
										var box = $("<li>",{"class":"boxes mute"})
										.append($("<div>",{"class":"preview"}).append("建设中..."));
										siderUl.append(box);
										rightDiv.css("display","none");
									}
									
									siderbar.append(siderUl);
									
								});
								
							}
							
						} else {
							console.log("获取数据失败："+json.msg);
						}
						//初始化各事件
						initEvent();
					}
				});
			}
			
			/**
			 * 初始化组件
			 */
			function initComponents(typeObj,compTypeObj) {
				//子节点
				if (typeObj.components != null && typeObj.components.length > 0) {
					//TODO 等待添加
					var compli =$("<li>",{"id":typeObj.htmlId,"class":"rows"});
					//动态添加组件内容
					$.each(typeObj.components, function(index, obj){
						var comDiv = $("<div>",{"class":"lyrow ui-draggable"});
						var a = $("<a>",{"class":"remove label label-danger js_delete","href":"#close"})
							.append($("<i>",{"class":"glyphicon-remove glyphicon"}))
							.append("删除");
						
						var span = $("<span>",{"class":"drag label label-default","htmlId":typeObj.htmlId,"componentId":obj.componentId,"componentName":obj.componentName})
							.append($("<i>",{"class":"glyphicon glyphicon-move"}))
							.append("拖动");
						var spanConfiguration = $("<span>",{"class":"configuration"})
							.append($("<a>",{"class":"btn btn-xs btn-default js_update","href":"#","html":"编辑"}));
						
						var divPreView = "";
						
						//布局设置
						if ("estRows"==typeObj.htmlId) {
							comDiv = $("<div>",{"class":"lyrow"});
							divPreView = $("<div>",{"class":"preview"})
								.append($("<input>",{"class":"form-control","value":obj.componentName, "type":"text"})); 
						} else {
							comDiv = $("<div>",{"class":"box box-element"});
							divPreView = $("<div>",{"class":"preview"})
							.append(obj.componentName); 
							//修改样式
							compli.attr("class","boxes");
						}
						
						
						
						comDiv.append(a);
						comDiv.append(span);
						if ("estRows"==typeObj.htmlId) {
						} else {
							comDiv.append(spanConfiguration);
						}
						comDiv.append(divPreView);
						if ("estRows"==typeObj.htmlId) {
							var divView = $("<div>",{"class":"view"}).append(obj.htmlCode);
						} else {
							var divView = $("<div>",{"class":"view"}).append($("<div>",{"class":"render"}));
						}
						comDiv.append(divView);
						compli.append(comDiv);
						
					});
					$(compTypeObj).append(compli);
				} 
			}
</script>
</html>
