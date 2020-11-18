<script src="${BASE_PATH}/static/manage/js/htmlformat.js"></script>
<script src="${BASE_PATH}/static/manage/js/jsformat.js"></script>
<#if pageVo??>
<#list pageVo.list as e>
	<div id="sC">
		${e.sourceCode!""}
	</div>
<script type="text/javascript">
<!--获取div块中源码-->
	var code = document.getElementById("sC").innerText;
<!--将源码格式化（htmlformat.js）-->	
	var gshCode = style_html(code);
<!--清空并赋值-->
	document.getElementById("sC").innerHTML="";
	document.getElementById("sC").innerText=gshCode;
</script>

</#list>
</#if>

