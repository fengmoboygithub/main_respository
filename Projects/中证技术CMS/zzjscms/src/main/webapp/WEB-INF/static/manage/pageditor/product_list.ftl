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
<title>固收市场--产品认购</title>
<link href="${pageditorPath}skin/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageditorPath}skin/css/layoutit.css" rel="stylesheet">
<link href="${pageditorPath}skin/css/default.css" rel="stylesheet">
<link href="${pageditorPath}skin/css/base.css" rel="stylesheet">
<link href="${pageditorPath}skin/css/list.css" rel="stylesheet">
<link href="${pageditorPath}skin/css/content.css" rel="stylesheet">
<link href="${pageditorPath}skin/css/productList.css" rel="stylesheet">
<link href="${pageditorPath}skin/css/tabulous.css" rel="stylesheet">
<link href="${pageditorPath}skin/css/tabs2.css" rel="stylesheet">

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
	////////////////////////////////声明组件脚本开始///////////////////////////////////////////////////
	var TablePage = React.createClass({
	  getInitialState: function() {
	    return {
	      success:true,
	      pageIndex: 1,
	      pageSize: 10,
	      matchedTotal: 0,
	      resultSet:[]
	    };
	  },
	  componentRequest: function(optionsParam) {
	  var interUrl = this.props.source.url;
	  var param = this.props.source.param;
	  var info = this.props.info;
	  //条件项组件
	  var myContainer = $(ReactDOM.findDOMNode(info.refs.myContainer));
	  var myContainerTarget = myContainer.find(".selected");
	  //条件Tab页签组件
	  var tabPage = $(ReactDOM.findDOMNode(info.refs.tabPage));
	  var tabPageTarget = tabPage.find(".current");
	  var tabPageParam = tabPageTarget.attr("data-option-param");
	  var tabPageValue = tabPageTarget.attr("data-option-value");
	  //排序组件
	  var sortQuery = $(ReactDOM.findDOMNode(info.refs.tabPage.refs.sortQuery));
	  var sortQueryTarget = sortQuery.find(".active_option");
	  var sortQueryParam = sortQueryTarget.attr("data-option-param");
	  var sortQueryValue = sortQueryTarget.attr("data-option-value");
	  var sortQueryType = sortQueryTarget.attr("data-option-type");
	  //输入框
	  var userInput = $(ReactDOM.findDOMNode(info.refs.tabPage.refs.userInput));
	  var userInputParam = userInput.attr("data-option-param");
	  var userInputValue = userInput.val();
	  var defaultOptions1 = param;
	  if(myContainerTarget.length > 0){
	  	myContainerTarget.each(function(){
	  		var myContainerParam = $(this).attr("data-option-param");
	  		var myContainerValue =  $(this).attr("data-option-value");
	  		if(myContainerParam){
		    	var str = myContainerParam.split("-");
		    	var str1 = myContainerValue.split("-");
		    	if(str[0] && str1[0]){
		    		defaultOptions1[str[0]] = str1[0];
		    	}
		    	if(str[1] && str1[1]){
		    		defaultOptions1[str[1]] = str1[1];
		    	}
		    }
	  	});
	  }
	  if(tabPageTarget.length > 0){
	  	defaultOptions1[tabPageParam] = tabPageValue;
	  }
	  if(sortQueryTarget.length > 0){
	  	defaultOptions1[sortQueryParam] = sortQueryValue+" "+sortQueryType;
	  }
	  if(userInput.length > 0){
	  	defaultOptions1[userInputParam] = userInputValue;
	  }
	  
	  var optionsParam1 = $.extend(defaultOptions1, optionsParam||{});;
	  var optionCallback = {
				"onSuccess":function(json, textStatus, xhr){
					this.setState({
					    success:true,
						pageIndex: json.pageIndex,
					    pageSize: json.pageSize,
					    matchedTotal: json.matchedTotal,
				        resultSet: json.resultSet
				      });
				}.bind(this),
				"onFailure": function(xhr, textStatus, error){
					this.setState({
					    success:false
				      });
				}.bind(this)
		};
	    this.serverRequest = getNotPageListDataByParam(interUrl ,optionsParam1, optionCallback);
	  },
	  //在组件从 DOM 中移除的时候立刻被调用
	  componentWillUnmount: function() {
	    this.serverRequest.abort();
	  },
	  //在组件完成更新后立即调用。在初始化时不会被调用
	  componentDidUpdate: function() {
	    if(this.state.success){
	    	var data_me = this.props.data_me;
	    	//渲染表头
		    var dataThead = $(this.refs.dataThead);
		    dataThead.empty();
		    var tr = $("<tr>");
	    	$.each(data_me.head, function(i, headItem){
		    	var th = $("<th>",headItem);
		    	tr.append(th);
		    });
		    dataThead.append(tr);
		    //渲染表格数据
		    var dataTbody = $(this.refs.dataTbody);
		    dataTbody.empty();
		    $.each(this.state.resultSet, function(i, rowItem){
		    	var rowtr = $("<tr>");
		    	$.each(data_me.body, function(i, bodyItem){
		    		var td = $("<td>",{"html":"--"});
		    		if(bodyItem.isshow){
		    			var tdHtml = bodyItem.callbackFun(rowItem[bodyItem.key]);
			    		td = $("<td>",{"html":tdHtml});
		    		}
			    	rowtr.append(td);
			    });
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
					<div>数据加载中。。。</div>
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
				pageInfo.componentRequest({
					pageIndex: pageIndexHolder,
				    pageSize: pageSizeHolder
			      });
			});
			pageBar.find("#" + idPrefix + "nextPage").on("click", function(){
				pageIndexHolder++;
				$(this).siblings().removeClass(currentPageNumberClass);
				pageBar.find("#" + idPrefix + "page_" + pageIndexHolder).addClass(currentPageNumberClass);//在此附加css，是为了能立即显示出当前页的css样式
				pageInfo.componentRequest({
					pageIndex: pageIndexHolder,
				    pageSize: pageSizeHolder
			      });
			});
			pageBar.find("[id^=" + idPrefix + "page_" + "]").on("click", function(){
				pageIndexHolder = parseInt($(this).text());
				$(this).siblings().removeClass(currentPageNumberClass);
				$(this).addClass(currentPageNumberClass);//在此附加css，是为了能立即显示出当前页的css样式
				pageInfo.componentRequest({
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
	
	
	var ContainerDiv = React.createClass({
		getInitialState: function() {
		  return {
		    query_info:"",
		  };
		},
		//绑定条件项点击事件
		myClick: function(event){
		  if(this.state.query_info){
		    $(event.target).parent("a").siblings().find("span").removeClass("selected");
		    $(event.target).addClass("selected");
		  	this.state.query_info.componentRequest({
		  		pageIndex: 1,
			    pageSize: 10
		  	});
		  }
		},
		render: function() {
		var list = this.props.data_me;
		var lis = list.map(function (item) {
		  var paramInfo = item.title.param_info;
		  var optionList = item.options;
		  var optList = optionList.map(function (optItem) {
		  	 return  (
		  	 <a className="a_option_container" href="#"><span onClick={this.myClick.bind(this)} data-option-param={paramInfo.param_field} data-option-value={optItem.value} >{optItem.name}</span></a>
					);
		  }.bind(this));
		  return  (
		    <p className="p_container">
					<a className="a_title_container" href="#">{item.title.name}</a>
					{optList}
			</p>
		  );
		}.bind(this));
        return (
		<div id="tabs_container">
			<div id="tabs-1" ref="div_container">
				{lis}
			</div>
		</div>
        );
      }
	});
	
	var SortSpan = React.createClass({
		getInitialState: function() {
		  return {
		    query_info:"",
		  };
		},
		//绑定排序项点击事件
		myClick: function(event){
		  if(this.state.query_info){
		    $(".div_option_sort").removeClass("active_option");
			$(event.target).addClass("active_option");
		  	this.state.query_info.componentRequest({
		  		pageIndex: 1,
			    pageSize: 10
		  	});
		  }
		},
		render: function() {
		var list = this.props.data_me;
		var lis = list.map(function (item) {
		  var optionList = item.param_info;
		  var optList = optionList.map(function (optItem) {
		  	 return  (
		  	 <div className="div_option_sort" data-option-type={optItem.param_type} data-option-param={optItem.param_field} data-option-value={optItem.param_value} onClick={this.myClick.bind(this)}></div>
					);
		  }.bind(this));
		  return  (
			<span>
				<span className="span_title_sort">{item.title}</span>
				<span className="span_option_sort">
					{optList}
				</span>
			</span>
		  );
		}.bind(this));
        return (
			<div style={{display: 'contents'}}>{lis}</div>
        );
      }
	});
	
	var ContainerTabUl = React.createClass({
		getInitialState: function() {
		  return {
		    query_info:"",
		  };
		},
		//绑定查询按钮事件
		handleQuery: function(event){
			this.state.query_info.componentRequest({
    			pageIndex: 1,
			    pageSize: 10
    		});
		},
		//绑定条件tab页签切换事件
		myClick: function(event){
		  if(this.state.query_info){
		  	$(event.target).parent("li").siblings().find("a").removeClass("current");
			$(event.target).addClass("current");
		  	this.state.query_info.componentRequest({
		  		pageIndex: 1,
			    pageSize: 10
		  	});
		  }
		},
		componentDidUpdate: function() {
    		//将条件tab页签切 渲染对象通过状态来传递
    		this.refs.sortQuery.setState({
    			query_info:this.state.query_info
    		});
	    },
		render: function() {
		var list = this.props.data_me;
		var lis = list.map(function (item) {
		  return  (
		    <li>
				<a href="javascript:void(0);" className={item.current ? 'current' : ''} data-option-param={item.param_field} data-option-value={item.param_value} onClick={this.myClick.bind(this)}>{item.title}</a>
			</li>
		  );
		}.bind(this));
        return (
		<ul id="tabs">
			{lis}
			<em>
				<SortSpan ref="sortQuery" data_me={this.props.data_sort}/>
				<input ref="userInput" className="input_option_container" data-option-param="issuer" placeholder="承销人/管理人/发行人" type="text"/>
				<span className="querybtn" onClick={this.handleQuery}>查询</span>
			</em>
		</ul>
        );
      }
	});
	
	//复合主组件 tab页签转化组件
	var TabDiv = React.createClass({
		getInitialState: function() {
		  return {
		    current_source:"",
		  };
		},
		myClick: function(obj){
		  this.setState({
			current_source:obj.source,
	      });
		},
		componentDidMount: function() {
			//第一次渲染 默认是第一个页签
			this.myClick(this.props.data_me[0]);
    	},
    	componentDidUpdate: function() {
    		//渲染分页组件
    		this.refs.myPageInfo.componentRequest({
    			pageIndex: 1,
			    pageSize: 10
    		});
    		//将条件组件 渲染对象通过状态来传递
    		this.refs.myContainer.setState({
    			query_info:this.refs.myPageInfo
    		});
    		//将条件tab页签切 渲染对象通过状态来传递
    		this.refs.tabPage.setState({
    			query_info:this.refs.myPageInfo
    		});
	    },
		render: function() {
		var list = this.props.data_me;
		var lis = list.map(function (item) {
		  return  (
		    <li className={item.active ? 'active': ''}>
		      <a href="#" data-toggle="tab" onClick={this.myClick.bind(this,item)}>{item.text}</a>
		    </li>
		  );
		}.bind(this));
        return (
          <div>
            <ul ref="myTab" className="nav nav-tabs">
				{lis}
			</ul>
			<div ref="myTabContent" className="tab-content">
				<ContainerDiv ref="myContainer" data_me={this.props.data_container}/>
				
				<ContainerTabUl ref="tabPage" data_me={this.props.data_container_tabinfo} data_sort={this.props.data_sort_info}/>
				
				<TablePage ref="myPageInfo" data_me={this.props.data_table_page} source={this.state.current_source} info={this}/>
			</div>
          </div>
        );
      }
	});
	////////////////////////////////声明组件脚本结束///////////////////////////////////////////////////
	
	
	////////////////////////////////调用组件脚本开始///////////////////////////////////////////////////
	//tab页签数据集
	var tabList = [
	{
		"active":true,
		"text":"发行",
		"source":{
			"url":interfacePath+"/fixedIncome/productList.json",
			"param":{
				productStatus:"",
				sortIdentifier:"",
				issuer:"",
				productClassify:"",	
				timeDownLimit:"",
				timeUpLimit:""
			}
		}
	},
	{
		"active":false,
		"text":"转让",
		"source":{
			"url":interfacePath+"/fixedIncome/transferProductList.json",
			"param":{
				productStatus:"",
				sortIdentifier:"",
				issuer:"",
				productClassify:"",	
				timeDownLimit:"",
				timeUpLimit:""
			}
		}
	}
	];
	//条件组件数据集
	var dataContainer = [
		{
			"title":{
				"name":"产品类型",
				"param_info":{
						"param_field":"productClassify",
						"param_value":"value"
				}
			},
			"options":[
				{
					"name":"不限",
					"value":""
				},
				{
					"name":"收益凭证",
					"value":"57"
				},
				{
					"name":"资产支持证券",
					"value":"55"
				},
				{
					"name":"非公开发行公司债",
					"value":"52"
				},
				{
					"name":"资管计划",
					"value":"51"
				}
			]
		},
		{
			"title":{
				"name":"产品期限",
				"param_info":{
						"param_field":"timeDownLimit-timeUpLimit",
						"param_value":"value_1"
					}
			},
			"options":[
				{
					"name":"不限",
					"value":""
				},
				{
					"name":"1月以下",
					"value":"0-30"
				},
				{
					"name":"1-3月（含3月）",
					"value":"30-90"
				},
				{
					"name":"3-6月（含6月）",
					"value":"90-180"
				},
				{
					"name":"6-12月（含12月)",
					"value":"180-365"
				},
				{
					"name":"1-3年（含3年）",
					"value":"365-1095"
				},
				{
					"name":"3-5年（含5年）",
					"value":"1095-1825"
				},
				{
					"name":"5年以上",
					"value":"1825"
				}
			]
		}
	];
	//条件tab页签组件数据集
	var data_container_tabinfo = [
		{
			title:"发行中",
			current:true,
			param_field:"productStatus",
			param_value:"0;1;2"
		},
		{
			title:"已完成",
			current:false,
			param_field:"productStatus",
			param_value:"3"
		},
		{
			title:"全部",
			current:false,
			param_field:"productStatus",
			param_value:""
		}
	];
	//排序选项组件数据集
	var data_sort_info = [
		{
			title:"时间",
			param_info:[
				{
					param_type:"DESC",
					param_field:"sortIdentifier",
					param_value:"FXKSR"
				}
			]
		},
		{
			title:"收益率",
			param_info:[
				{
					param_type:"ASC",
					param_field:"sortIdentifier",
					param_value:"GDSYL"
				},
				{
					param_type:"DESC",
					param_field:"sortIdentifier",
					param_value:"GDSYL"
				}
			]
		}
	];
	//表格分页组件数据集
	var data_table_page = {
		head:[
			{
				"html":"产品代码",
				"class":"",
				"style":"",
				"rowspan":1,
				"colspan":1
			},
			{
				"html":"产品名称",
				"class":"",
				"style":"",
				"rowspan":1,
				"colspan":1
			},
			{
				"html":"发行人",
				"class":"",
				"style":"",
				"rowspan":1,
				"colspan":1
			},
			{
				"html":"类型",
				"class":"",
				"style":"",
				"rowspan":1,
				"colspan":1
			},
			{
				"html":"年化收益率",
				"class":"",
				"style":"",
				"rowspan":1,
				"colspan":1
			},
			
		],
		body:[
			{
				"key":"CPDM",
				"isshow":true,
				"callbackFun":function(objVal){
					return objVal;
				}
			},
			{
				"key":"CPMC",
				"isshow":true,
				"callbackFun":function(objVal){
					return objVal;
				}
			},
			{
				"key":"FXFMC",
				"isshow":true,
				"callbackFun":function(objVal){
					return objVal;
				}
			},
			{
				"key":"CPLXMC",
				"isshow":true,
				"callbackFun":function(objVal){
					return objVal;
				}
			},
			{
				"key":"GDSYL",
				"isshow":true,
				"callbackFun":function(objVal){
					return objVal;
				}
			}
		]
	};
	ReactDOM.render(
      <TabDiv data_me={tabList} data_container={dataContainer} data_container_tabinfo={data_container_tabinfo} data_sort_info={data_sort_info} data_table_page={data_table_page}/>,
      document.getElementById('example')
    );
    ////////////////////////////////调用组件脚本结束///////////////////////////////////////////////////
</script>
</html>
