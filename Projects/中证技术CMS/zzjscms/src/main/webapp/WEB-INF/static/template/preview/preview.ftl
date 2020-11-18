<#assign pageditorPath=BASE_PATH+"/static/template/preview/">
<!DOCTYPE html>
<html lang="cn">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="预览页面" />
<meta name="description" content="预览页面" />
<meta name="language" content="en" />
<script type="text/javascript">var contextPath = "${pageditorPath}";var NREUMQ=NREUMQ||[];NREUMQ.push(["mark","firstbyte",new Date().getTime()]);</script>
<title>预览页面</title>
<link href="${pageditorPath}skin/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageditorPath}skin/css/layoutit.css" rel="stylesheet">
<link href="${pageditorPath}skin/css/default.css" rel="stylesheet">
<link href="${pageditorPath}skin/css/base.css" rel="stylesheet">
<link href="${pageditorPath}skin/css/list.css" rel="stylesheet">
<link href="${pageditorPath}skin/css/content.css" rel="stylesheet">

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
<script type="text/javascript" src="${pageditorPath}skin/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="${pageditorPath}skin/js/jquery.ui.touch-punch.min.js"></script>
<script type="text/javascript" src="${pageditorPath}skin/js/bootstrap.min.js"></script>

<script type="text/javascript" src="${pageditorPath}skin/js/jquery.htmlClean.js"></script>
<script type="text/javascript" src="${pageditorPath}skin/js/scripts.min.js"></script>
<script type="text/javascript" src="${pageditorPath}skin/js/base.js"></script>
<script type="text/javascript" src="${pageditorPath}skin/js/jquery.paging-1.0.1.js"></script>

</head>
<body style="margin-left:0px;">
	${sourceCode!}
</body>

</html>
