<!DOCTYPE html>
<html lang="cn">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="${pageInfo.name!}" />
<meta name="description" content="${pageInfo.name!}" />
<meta name="language" content="en" />
<script type="text/javascript">var contextPath = "${outputPath}";</script>
<title>${pageInfo.name!}</title>
<#list mediaFileList as fmrv>
	<#--<#assign hrefStr=outputPath+fmrv.pathEname>-->
	<#assign hrefStr=fmrv.pathEname>
	<#if fmrv.media.suffix == "css">
		<link href="${hrefStr}" rel="stylesheet">
	</#if>
	<#if fmrv.media.suffix == "js">
		<script type="text/javascript" src="${hrefStr}"></script>
	</#if>
</#list>
</head>
<body>
	${sourceCode!}
	<script type="text/babel">
		${pageAllCode!}
	</script>
</body>
</html>
