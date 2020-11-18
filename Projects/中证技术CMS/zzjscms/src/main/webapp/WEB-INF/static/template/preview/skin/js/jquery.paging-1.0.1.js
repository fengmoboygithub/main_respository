
/*
 * jquery分页插件
 * Author : 杨延超
 * Date: 2016/08/08
 * Version: v1.0.1
 */

(function($) {
	
	
	/**
	 * options							required?		defaultValue		min
	 * -----------------------------------------------------------------------
	 * 	container							true			--
	 * 	ajaxUrl								true			--
	 * 	ajaxData							false			--
	 * 	matchedTotalPropertyName			false			matchedTotal
	 * 	pageSizePropertyName				false			pageSize
	 * 	pageIndexPropertyName?---------------------unused-----------------------
	 * 	pageTotal?				---------------------unused-----------------------
	 * 	pageSizeStep						false			5
	 * 	pageSizeStepQuantity				false			4
	 * 	pageSize				---------------------unused-----------------------
	 * 	callback:function(json){}			false			--
	 * 	prevPageText:						false			上一页
	 * 	nextPageText:						false			下一页
	 * 	headPageText:						false			首页
	 * 	tailPageText:						false			尾页
	 * 	centerPageButtonQuantity					false			5				3
	 * 	edgePageButtonQuantity					false			2				1
	 */
	
	$.fn.paging = function(options) {
		var firstLoadSuccess = false;
		var _this = this;
		var $_pagingBar = $(_this);
		
		var defaultOptions = {
				ajaxUrl: "",
				ajaxData: {},
//				container: $(""),
				matchedTotalPropertyName: "matchedTotal",//ajax响应中的总记录数属性名
				pageSizeParamName: "pageSize",//ajax请求中的每页记录数的参数名
//				pageSizeParamName: "limit",//ajax请求中的每页记录数的参数名
				pageIndexParamName: "pageIndex",//ajax请求中的页码参数名
				pageIndex: 1,
				pageSize: 10,
				pageSizeStep: 5,
				pageSizeStepQuantity: 4,
				onSuccess: function(){return false;},        
				onFailure: function(){return false;},        
				prevPageText: "上一页",
				nextPageText: "下一页",
//				headPageText: "首页",
//				tailPageText: "尾页",
				centerPageButtonQuantity: 5,
				edgePageButtonQuantity: 2
		};
		var options = $.extend(defaultOptions, options||{});
		
		var optionsHolder = options;
		var pageIndexHolder = options.pageIndex;
		var pageSizeHolder = options.pageSize;
		var pageTotalHolder;
		
		var ajaxUrl = options.ajaxUrl;
		var ajaxData = options.ajaxData;
		var onSuccess = options.onSuccess;
		var onFailure = options.onFailure;
		var container = options.container;
		var pageSizeParamName = options.pageSizeParamName;
		var pageIndexParamName = options.pageIndexParamName;
		
		showLoading(container);
		
		var pagingParam = {};
		pagingParam[pageSizeParamName] = pageSizeHolder;
		pagingParam[pageIndexParamName] = pageIndexHolder;

		
		/*
		 ************************************************************************
		 ****************************pagingBar实现逻辑****************************
		 ************************************************************************
		 */
		var idPrefix = "__id_ax_paging_";
		var namePrefix = "__name_ax_paging_";
		
		var pageNameClass = "pageName";
		var pageNumberClass = "page_number";
		var currentPageNumberClass = "active";
		var pageCountClass = "pageCount";
		var pageSizeSelectClass = "pageSizeSelect";
		var pagebarClass = "pagebar";
		var pageNumberSeparatorClass = "page_number_separator";
		var totalPageNumberClass = "totalpage_number";
		var mt10Class = "mt10";
		var frClass = "fr";
		var pageBarContentClass = "pagebarcontent";
		
		$.ajax({
			type: "POST",
			url: ajaxUrl,
			data: $.extend(ajaxData, pagingParam),
			dataType: "json",
			success: function(json, textStatus, xhr){
				$_pagingBar.empty();
				renderPagingBar(json, _this, options);
				if(!firstLoadSuccess){
					firstLoadSuccess = true;
				}
				onSuccess.call(undefined, json, textStatus, xhr,container);
			},
			error: function(xhr, textStatus, error){
				showLoadFailure(container);
				onFailure.call(undefined, xhr, textStatus, error,container);
			}
		});
		
		function showLoading(container){
			//TODO 这里要用js api获取contextPath，这样才不会依赖使用该插件的项目
			$(container).html("<img src='"+contextPath+"skin/images/loading_pic.gif' width='22'/>加载中...</div>");
		}
		
		function showLoadFailure(container){
			//用事件转发实现重新加载
			$(container).html("<div>加载失败, <a id='" + idPrefix + "reload' href='javascript:;' style='color: blue;'>重新加载</a></div>");
			if(firstLoadSuccess){
				$("#" + idPrefix + "reload").on("click", function(){
//					if(document.dispatchEvent){
//						var clickEvent = document.createEvent("HTMLEvents");
//						clickEvent.initEvent("click", true, true);
//						document.getElementById(idPrefix + "page_" + pageIndexHolder).dispatchEvent(clickEvent);
//					}else if (document.fireEvent){
//						var clickEvent = document.createEventObject();
//						document.fireEvent("onclick", clickEvent);
//					}
					$("#" + idPrefix + "page_" + pageIndexHolder).trigger("click");
				});
			}else{
				$("#" + idPrefix + "reload").on("click", function(){
					$_pagingBar.paging(optionsHolder);
				});
			}
		}
		
		function renderPagingBar(json, container, options){
//			var container = options.container;
//			var headPageText = options.headPageText || "首页";
//			var tailPageText = options.tailPageText || "尾页";
			var prevPageText = options.prevPageText || "上一页";
			var nextPageText = options.nextPageText || "下一页";
			var matchedTotalPropertyName = options.matchedTotalPropertyName;
			var pageSizeStep = options.pageSizeStep || 5;
			var pageSize = options.pageSize || 10;
//			pageSizeHolder = pageSize;
			var pageSizeStepQuantity = options.pageSizeStepQuantity || 4;
			var centerPageButtonQuantity = options.centerPageButtonQuantity || 5;
			var edgePageButtonQuantity = options.edgePageButtonQuantity || 2;
			var pageTotal = Math.floor((json[matchedTotalPropertyName] - 1) / pageSize) + 1;
			pageTotalHolder = pageTotal;
			
			var pagingBarHtml="";
			
//			pagingBarHtml = "<div class='" + mt10Class + "'>";
//			pagingBarHtml = "<div class='" + frClass + "'>";
//			pagingBarHtml = "<div class='" + pageBarContentClass + "'>";
			
//			pagingBarHtml += "<div class='" + pageCountClass + "'>共" + json[matchedTotalPropertyName] + "条数据</div>&nbsp;&nbsp;";
//			pagingBarHtml += "<div class='" + pageSizeSelectClass + "'><label for='" + idPrefix + "pageSize'>每页显示</label><select id='" + idPrefix + "pageSize' >"
			
//			for(var i = 1; i <= pageSizeStepQuantity; i++){
//				var pageSizeOption = pageSizeStep * i;
//				pagingBarHtml += "<option " + (pageSizeOption == pageSize ? "selected='selected'" : "") + ">" + pageSizeOption + "</option>";
//			}
			
//			pagingBarHtml += "</select></div>&nbsp;&nbsp;";
//			pagingBarHtml += "<div class='" + pagebarClass + "'>";
			
//			pagingBarHtml += "<a id='" + idPrefix + "headPage' href='javascript:;' class='" + pageNameClass + "'>" + headPageText + "</a>";
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
//			pagingBarHtml += "<a id='" + idPrefix + "tailPage' href='javascript:;' class='" + pageNameClass + "'>" + tailPageText + "</a>";
			
//			pagingBarHtml += "<span id='" + idPrefix + "pageIndex' style='color: rgb(255, 0, 0); font-size: 15px;'>" + pageIndexHolder + "</span>";
//			pagingBarHtml += "<span> / </span>";
//			pagingBarHtml += "<span class='" + totalPageNumberClass + "' style='font-size: 15px;'>" + pageTotalHolder + "</span>";
//			pagingBarHtml += "</div>";
//			pagingBarHtml += "</div>";
//			pagingBarHtml += "</div>";
//			pagingBarHtml += "</div>";
			//console.log(pagingBarHtml);
			$_pagingBar.html(pagingBarHtml);
			
			$_pagingBar.find("#" + idPrefix + "prevPage").on("click", function(){
				pageIndexHolder--;
				$(this).parent().siblings().removeClass(currentPageNumberClass);
				$_pagingBar.find("#" + idPrefix + "page_" + pageIndexHolder).parent().addClass(currentPageNumberClass);//在此附加css，是为了能立即显示出当前页的css样式
				$_pagingBar.paging($.extend(optionsHolder, {pageIndex: pageIndexHolder, pageSize: pageSizeHolder}));
				
				//在这里先处理一次，是为了防止ajax请求失败，所以预先调用
				handlePageChange();
			});
			
			$_pagingBar.find("#" + idPrefix + "nextPage").on("click", function(){
				pageIndexHolder++;
				$(this).parent().siblings().removeClass(currentPageNumberClass);
				$_pagingBar.find("#" + idPrefix + "page_" + pageIndexHolder).parent().addClass(currentPageNumberClass);//在此附加css，是为了能立即显示出当前页的css样式
				$_pagingBar.paging($.extend(optionsHolder, {pageIndex: pageIndexHolder, pageSize: pageSizeHolder}));
				
				//在这里先处理一次，是为了防止ajax请求失败，所以预先调用
				handlePageChange();
			});
			
			$_pagingBar.find("[id^=" + idPrefix + "page_" + "]").on("click", function(){
				pageIndexHolder = parseInt($(this).text());
				$(this).parent().siblings().removeClass(currentPageNumberClass);
				$(this).parent().addClass(currentPageNumberClass);//在此附加css，是为了能立即显示出当前页的css样式
				$_pagingBar.paging($.extend(optionsHolder, {pageIndex: pageIndexHolder, pageSize: pageSizeHolder}));
				
				//在这里先处理一次，是为了防止ajax请求失败，所以预先调用
				handlePageChange();
			});
			
			handlePageChange();
		}
		
		//TODO 用事件转发机制来处理页面改变事件，应该会更优雅一些
		function handlePageChange(){
			handlePageButtonAbled();
			handleCurrentPageButtonClass();
			handleScale();
		}
		
		//首页与码页1与上一页：在第一页时不可用，尾页与码页最大值与下一页：在最大页时不可用
		function handlePageButtonAbled(){
			if(pageIndexHolder == 1){
				$_pagingBar.find("#" + idPrefix + "page_1").unbind("click");
				$_pagingBar.find("#" + idPrefix + "prevPage").unbind("click");
			}
			if(pageIndexHolder >= pageTotalHolder){
				$_pagingBar.find("#" + idPrefix + "page_" + pageTotalHolder).unbind("click");
				$_pagingBar.find("#" + idPrefix + "nextPage").unbind("click");
			}
		}
		
		function handleCurrentPageButtonClass(){
			$_pagingBar.find("#" + idPrefix + "page_" + pageIndexHolder).parent().addClass(currentPageNumberClass);
		}
		
		function handleScale(){
			$_pagingBar.find("#" + idPrefix + "pageIndex").text(pageIndexHolder);
		}
		
	};

})(jQuery);




