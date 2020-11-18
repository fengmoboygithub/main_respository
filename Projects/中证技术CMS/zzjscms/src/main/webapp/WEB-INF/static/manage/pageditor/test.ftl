<#assign pageditorPath=BASE_PATH+"/static/manage/pageditor/">
<!DOCTYPE html>
<html lang="cn">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="layoutit bootstrap3"" />
<meta name="description" content="" />
<meta name="language" content="en" />
<script type="text/javascript">var contextPath = "${BASE_PATH}/WEB-INF/static/manage/pageditor/";var NREUMQ=NREUMQ||[];NREUMQ.push(["mark","firstbyte",new Date().getTime()]);</script>
<title>layoutit bootstrap3中文版可拖放排序在线编辑的bootstrap可视化布局系统</title>
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
<script type="text/javascript" src="${pageditorPath}skin/js/xcConfirm.js"></script>
<script type="text/javascript" src="${pageditorPath}skin/js/lhgdialog.min.js"></script>
<script type="text/javascript" src="${pageditorPath}skin/js/common.js"></script>
<script type="text/javascript" src="${pageditorPath}skin/js/baseInterface.js"></script>
<script type="text/javascript" src="${pageditorPath}skin/js/react.min.js"></script>
<script type="text/javascript" src="${pageditorPath}skin/js/react-dom.min.js"></script>
<script type="text/javascript" src="${pageditorPath}skin/js/babel.min.js"></script>
</head>
<body>
	<div id="example"></div>
</body>
<script type="text/babel">
    
    var TablePage = React.createClass({
	  getInitialState: function() {
	    return {
	      success:true,
	      searshData:{},
	      pageIndex: 1,
	      pageSize: 10,
	      matchedTotal: 0,
	      columnInfo:[],
	      resultSet:[]
	    };
	  },
	  //在第一次渲染后调用
	  componentDidMount: function(optionsParam) {
	  var interUrl = this.props.source;
	  var defaultOptions = {};
	  var optionsParam = $.extend(defaultOptions, optionsParam||{});;
	  var optionCallback = {
				"onSuccess":function(json, textStatus, xhr){
					this.setState({
					    success:true,
						pageIndex: json.pageIndex,
					    pageSize: json.pageSize,
					    matchedTotal: json.matchedTotal,
				        columnInfo: json.columnInfo,
				        resultSet: json.resultSet
				      });
				}.bind(this),
				"onFailure": function(xhr, textStatus, error){
					alert(111);
					this.setState({
					    success:false
				      });
				}.bind(this)
		};
	    this.serverRequest = getNotPageListDataByParam(interUrl ,optionsParam, optionCallback);
	  },
	  //在组件从 DOM 中移除的时候立刻被调用
	  componentWillUnmount: function() {
	    this.serverRequest.abort();
	  },
	  //在组件完成更新后立即调用。在初始化时不会被调用
	  componentDidUpdate: function() {
	  	alert("stateSuccess:  "+this.state.success);
	    if(this.state.success){
	    	//渲染表头
		    var dataThead = $(this.refs.dataThead);
		    dataThead.empty();
		    var tr = $("<tr>");
		    $.each(this.state.columnInfo, function(i, columnItem){
		    	if(columnItem.isShow){
			    	var th = $("<th>",{"html":columnItem.name});
			    	tr.append(th);
		    	}
		    });
		    dataThead.append(tr);
		    //渲染表格数据
		    var dataTbody = $(this.refs.dataTbody);
		    dataTbody.empty();
		    $.each(this.state.resultSet, function(i, rowItem){
		    	var rowtr = $("<tr>");
		    	var td1 = $("<td>",{"html":rowItem.name});
		    	rowtr.append(td1);
		    	var td2 = $("<td>",{"html":rowItem.mobile});
		    	rowtr.append(td2);
		    	var td3 = $("<td>",{"html":rowItem.deptName});
		    	rowtr.append(td3);
		    	var td4 = $("<td>",{"html":rowItem.email});
		    	rowtr.append(td4);
		    	var td5 = $("<td>",{"html":rowItem.createTime});
		    	rowtr.append(td5);
		    	dataTbody.append(rowtr);
		    });
	    } else {
	    	var dataTbody = $(this.refs.dataTbody);
	    	dataTbody.html("<div>加载失败, 请联系管理人员。</div>");
	    }
	  },
      render: function() {
        //  当组件插入到 DOM 后，ref 属性添加一个组件的引用于到 this.refs
        return (
          <div>
            <table className="table table-striped table-bordered table-hover dataTable no-footer dtr-inline">
				<thead ref="dataThead">
				</thead>
				<tbody ref="dataTbody" role="alert" aria-live="polite" aria-relevant="all">
				</tbody>
			</table>
            <PageBar pageIndex={this.state.pageIndex} pageSize={this.state.pageSize} matchedTotal={this.state.matchedTotal} pageInfo={this}/>
          </div>
        );
      }
    });
    
    var PageBar = React.createClass({
	    render: function () {
	        var idPrefix = "__id_ax_paging_";
			var pageNumberClass = "page_number";
			var currentPageNumberClass = "active";
			var pageNumberSeparatorClass = "page_number_separator";
			var prevPageText = "上一页";
			var nextPageText = "下一页";
	        var pageInfo = this.props.pageInfo;
			var pageBar = $(this.refs.pageBar);
			/*页码*/
			var pageIndex = this.props.pageIndex;
			var pageIndexHolder = pageIndex;
			/*每页显示最大条数*/
			var pageSize = this.props.pageSize;
			var pageSizeHolder = pageSize;
			/*总条数*/
			var matchedTotal = this.props.matchedTotal;
			/*总页数*/
			var pageTotal = Math.floor((matchedTotal - 1) / pageSize) + 1;
			var pageTotalHolder = pageTotal;
			alert("pageBar:"+matchedTotal);
			/*中间显示多少页码数*/
			var centerPageButtonQuantity = 5;
			/*前后各显示多少页码数*/
			var edgePageButtonQuantity = 2;
			var entryQuantity = centerPageButtonQuantity + edgePageButtonQuantity + edgePageButtonQuantity;
			var pagingBarHtml = "";
			pagingBarHtml += "<li><a id='" + idPrefix + "prevPage' href='javascript:;' >" + prevPageText + "</a></li>";
			// 12 345 67   12 345..78     12..456..89    12..456..9 10
			var entryQuantity = centerPageButtonQuantity + edgePageButtonQuantity + edgePageButtonQuantity;
			if(entryQuantity >= pageTotal){
				for(var i = 1; i <= pageTotal; i++){
					pagingBarHtml += "<li><a id='" + idPrefix + "page_" + i + "'  href='javascript:;'>" + i + "</a></li>";
				}
			}else{
				var overflow = pageTotal - entryQuantity;
				var center = Math.round(pageTotal / 2);
				// 4567    345678    23456789
				var centerStart, centerEnd;
				if(centerPageButtonQuantity % 2 == 0){
					var half = Math.floor(centerPageButtonQuantity / 2);
					centerStart = center - half + 1;
					centerEnd = center + half;
				}else{
					var half = Math.floor(centerPageButtonQuantity / 2);
					centerStart = center - half;
					centerEnd = center + half;
				}
				
				for(var i = 1; i <= edgePageButtonQuantity; i++){
					pagingBarHtml += "<li><a id='" + idPrefix + "page_" + i + "' class='" + pageNumberClass + "' href='javascript:;'>" + i + "</a></li>";
				}
				
				if(overflow > 1){
					pagingBarHtml += "<li><span class='" + pageNumberSeparatorClass + "'>...</span></li>";
				}
				
				for(var i = centerStart; i <= centerEnd; i++){
					pagingBarHtml += "<li><a id='" + idPrefix + "page_" + i + "' href='javascript:;'>" + i + "</a></li>";
				}
				
				pagingBarHtml += "<li><span class='" + pageNumberSeparatorClass + "'>...</span></li>";
				
				for(var i = pageTotal - edgePageButtonQuantity + 1; i <= pageTotal; i++){
					pagingBarHtml += "<li><a id='" + idPrefix + "page_" + i + "' href='javascript:;'>" + i + "</a></li>";
				}
					
			}
			pagingBarHtml += "<li><a id='" + idPrefix + "nextPage' href='javascript:;'>" + nextPageText + "</a></li>";
			pageBar.html(pagingBarHtml);
			pageBar.find("#" + idPrefix + "prevPage").on("click", function(){
				pageIndexHolder--;
				$(this).siblings().removeClass(currentPageNumberClass);
				pageInfo.componentDidMount({
					pageIndex: pageIndexHolder,
				    pageSize: pageSizeHolder
			      });
			});
			pageBar.find("#" + idPrefix + "nextPage").on("click", function(){
				pageIndexHolder++;
				$(this).siblings().removeClass(currentPageNumberClass);
				pageBar.find("#" + idPrefix + "page_" + pageIndexHolder).addClass(currentPageNumberClass);//在此附加css，是为了能立即显示出当前页的css样式
				pageInfo.componentDidMount({
					pageIndex: pageIndexHolder,
				    pageSize: pageSizeHolder
			      });
			});
			pageBar.find("[id^=" + idPrefix + "page_" + "]").on("click", function(){
				pageIndexHolder = parseInt($(this).text());
				$(this).siblings().removeClass(currentPageNumberClass);
				$(this).addClass(currentPageNumberClass);//在此附加css，是为了能立即显示出当前页的css样式
				pageInfo.componentDidMount({
					pageIndex: pageIndexHolder,
				    pageSize: pageSizeHolder
			      });
			});
			handlePageChange();
			function handlePageChange(){
				handlePageButtonAbled();
				handleCurrentPageButtonClass();
				handleScale();
			}
			
			//首页与码页1与上一页：在第一页时不可用，尾页与码页最大值与下一页：在最大页时不可用
			function handlePageButtonAbled(){
				if(pageIndexHolder == 1){
					pageBar.find("#" + idPrefix + "page_1").unbind("click");
					pageBar.find("#" + idPrefix + "prevPage").unbind("click");
				}
				if(pageIndexHolder >= pageTotalHolder){
					pageBar.find("#" + idPrefix + "page_" + pageTotalHolder).unbind("click");
					pageBar.find("#" + idPrefix + "nextPage").unbind("click");
				}
			}
			
			function handleCurrentPageButtonClass(){
				pageBar.find("#" + idPrefix + "page_" + pageIndexHolder).parent().addClass(currentPageNumberClass);
			}
			
			function handleScale(){
				pageBar.find("#" + idPrefix + "pageIndex").text(pageIndexHolder);
			}
			return (
			    <div>
			      <ul className="pagination" ref="pageBar"></ul>
			    </div>
			  );
	    }
	});
	
	
	//ReactDOM.render(
      //<TablePage source="${BASE_PATH}/interface/tablePageTest.htm"/>,
      //document.getElementById('example')
    //);
    
    const renderAges = [<TablePage source="${BASE_PATH}/interface/tablePageTest.htm"/>, document.getElementById('example')];
	Reflect.apply(ReactDOM.render, ReactDOM, renderAges);
</script>
</html>
