<#assign codeEditerPath=BASE_PATH+"/static/manage/codeEditer/">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="在线编写、展示html、js、css代码">
<meta name="keywords" content="JavaScript CSS HTML 在线运行 展示 效果">
<title>代码测试器工作台</title>
<link rel="stylesheet" href="${codeEditerPath}css/theme.css" type="text/css">
<link rel="stylesheet" href="${codeEditerPath}css/zebra_dialog.css" type="text/css">
<link rel="stylesheet" href="${codeEditerPath}css/style1.css" type="text/css">
<link rel="stylesheet" href="${codeEditerPath}js/CodeMirror-2.25/lib/util/simple-hint.css" type="text/css">
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
	var _parma_type = "${type!}";
    var _parma_id = "${id!}";
    var _BasePath = "${BASE_PATH}";
    var _codeEditerPath = "${codeEditerPath}";
</script>
<script type="text/javascript" src="${codeEditerPath}js/all.js"></script>
</head>
<body class="NightTheme">
	<!-- 主体开始 -->
	<div id="main_container">
		<!-- 头部开始 -->
		<div class="header">
			<!-- logo开始 -->
			<div class="logo">
				<h1>RunJs</h1>
			</div>
			<!-- logo结束 -->
			<!-- 头部菜单开始 -->
			<div class="headerMenu">
				
				<!--<div class="btnGroup menuItem view_btn">
					<div class="btn" id="save">保存</div>
				</div>-->
			</div>
			<!-- 头部菜单结束 -->
		</div>
		<!-- 头部结束 -->
		<!-- 代码展示开始 -->
		<div id="core" class="core core_margin1">
			<!-- editor_wrapper开始 -->
			<div class="editor_wrapper" style="height: 218px;">
				<!-- editorSet left开始 -->
				<fieldset class="editorSet left">
					<!-- editor HTML开始 -->
					<div class="editor html top">
						<span class="quick_tools" style="display: none;"><span>HTML</span><img src="${codeEditerPath}img/arrow-out.png" width="14"></span>
						<textarea rows="10" cols="40" id="code_html" style="position: absolute; left: -10000px; width: 10px;"></textarea>
					</div>
					<!-- editor HTML结束 -->
					<div class="handler handler_horizontal" style="top: 104px;"></div>
					<!-- editor JS开始 -->
					<div class="editor js bottom">
						<span class="quick_tools" style="display: none;"><span onclick="runjs.editor.chooseJsType();">JavaScript</span><img src="${codeEditerPath}img/arrow-out.png" width="14"></span>
								<textarea rows="10" cols="40" id="code_js" style="position: absolute; left: -10000px; width: 10px;"></textarea>
					</div>
					<!-- editor JS结束 -->
				</fieldset>
				<!-- editorSet left结束 -->
				<div class="handler handler_vertical" style="left: 665px;"></div>
				<!-- editorSet right开始 -->
				<fieldset class="editorSet right">
					<!-- editor CSS开始 -->
					<div class="editor css top">
						<span class="quick_tools"><span onclick="runjs.editor.chooseCssType();">CSS</span><img src="${codeEditerPath}img/arrow-out.png" width="14"></span>
						<textarea rows="10" cols="40" id="code_css" style="position: absolute; left: -10000px; width: 10px;"></textarea>
					</div>
					<!-- editor CSS结束 -->
					<div class="handler handler_horizontal" style="top: 104px;"></div>
					<!-- editor 预览开始 -->
					<div class="editor preview bottom">
						<span class="quick_tools" style="display: none;"><span>预览</span><img src="${codeEditerPath}img/arrow-out.png" width="14"></span>
						<iframe id="preview" frameborder="0"></iframe>
					</div>
					<!-- editor 预览结束 -->
				</fieldset>
				<!-- editorSet right结束 -->
			</div>
			<!-- editor_wrapper结束 -->
		</div>
		<!-- 代码展示结束 -->
	</div>
	<!-- 主体结束 -->
</body></html>