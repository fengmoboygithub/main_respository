/*
 * jquery分页插件
 * Author : Yangyanchao
 * Date: 2018/04/09
 * Version: v1.0.0
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
				type: "POST",
				ajaxData: {},
				matchedTotalPropertyName: "matchedTotal",//ajax响应中的总记录数属性名
				pageSizeParamName: "pageSize",//ajax请求中的每页记录数的参数名
				pageIndexParamName: "pageIndex",//ajax请求中的页码参数名
				pageIndex: 1,
				pageSize: 10,
				pageSizeStep: 5,
				pageSizeStepQuantity: 4,
				showPageLengh : 10,//显示当前页码前面和后面一截的页码数
				onSuccess: function(){return false;},        
				onFailure: function(){return false;},        
				prevPageText: "上一页",
				nextPageText: "下一页",
				headPageText: '<img src="img/sy_btn.png" class="sy_btn">首页',
				tailPageText: '尾页<img src="img/wy_btn.png" class="wy_btn">',
				centerPageButtonQuantity: 5,
				edgePageButtonQuantity: 2
		};
		var options = $.extend(defaultOptions, options||{});
		var optionsHolder = options;
		var pageIndexHolder = options.pageIndex;
		var pageSizeHolder = options.pageSize;
		var pageTotalHolder;
		
		var ajaxUrl = options.ajaxUrl;
		var type = options.type;
		var ajaxData = options.ajaxData;
		var onSuccess = options.onSuccess;
		var onFailure = options.onFailure;
		var container = options.container;
		var pageSizeParamName = options.pageSizeParamName;
		var pageIndexParamName = options.pageIndexParamName;
		var showPageLengh=options.showPageLengh;
		showLoading(container);
		
		var pagingParam = {};
		pagingParam[pageSizeParamName]  = options.pageSize;
		pagingParam[pageIndexParamName] = options.pageIndex;
		
		$.ajax({
			type: type,
			url: ajaxUrl,
			data: $.extend(ajaxData, pagingParam),
			dataType: "json",
			success: function(json, textStatus, xhr){
				$(container).html("无相应数据！");
				renderPagingBar(json, _this, options);
				if(!firstLoadSuccess){
					firstLoadSuccess = true;
				}
				onSuccess.call(undefined, json, textStatus, xhr);
			},
			error: function(xhr, textStatus, error){
				showLoadFailure(container);
				onFailure.call(undefined, xhr, textStatus, error);
			}
		});

		
		/*
		 ************************************************************************
		 ****************************pagingBar实现逻辑****************************
		 ************************************************************************
		 */
		var idPrefix = "__id_ax_paging_";
		var namePrefix = "__name_ax_paging_";
		
		var pageNameClass = "pageName";
		var pageNumberClass = "page_number";
		var currentPageNumberClass = "current_page_number";
		var pageNumberSeparatorClass = "page_number_separator";
		var totalPageNumberClass = "totalpage_number";
		
		
		function showLoading(container){
			//TODO 这里要用js api获取contextPath，这样才不会依赖使用该插件的项目
			$(container).html("<div style='width: 150px; height: 32px;line-height:32px;padding-left:23px; background: url(img/waiting.gif) no-repeat 0 5px'>加载中...</div>");
		}
		
		function showLoadFailure(container){
			//用事件转发实现重新加载
			$(container).html("<div>加载失败, <a id='" + idPrefix + "reload' href='javascript:;' style='color: blue;'>重新加载</a></div>");
			if(firstLoadSuccess){
				$("#" + idPrefix + "reload").on("click", function(){
					$("#" + idPrefix + "page_" + pageIndexHolder).trigger("click");
				});
			}else{
				$("#" + idPrefix + "reload").on("click", function(){
					$_pagingBar.paging(optionsHolder);
				});
			}
		}
		
		function renderPagingBar(json, container, options){
			// 分页   
			var headPageText = options.headPageText || "首页";
			var tailPageText = options.tailPageText || "尾页";
			var prevPageText = options.prevPageText || "上一页";
			var nextPageText = options.nextPageText || "下一页";
			var matchedTotalPropertyName = options.matchedTotalPropertyName;
			var pageSizeStep = options.pageSizeStep || 5;
			var pageSizeStepQuantity = options.pageSizeStepQuantity || 4;
			var centerPageButtonQuantity = options.centerPageButtonQuantity || 5;
			var edgePageButtonQuantity = options.edgePageButtonQuantity || 2;
			var pageTotal = Math.floor((json[matchedTotalPropertyName] - 1) / pageSizeHolder) + 1;
			pageTotalHolder = pageTotal;
			showPageLengh=pageTotal<showPageLengh?pageTotal:showPageLengh;
			var front_block = parseInt(pageIndexHolder) - showPageLengh;// 当前页码前面一截   
			var back_block = parseInt(pageIndexHolder) + showPageLengh;// 当前页码后面一截 
			var pagingBarHtml = "";
			
			pagingBarHtml += "<a id='" + idPrefix + "headPage' href='javascript:;' class='" + pageNameClass + "'>" + headPageText + "</a>";
			pagingBarHtml += "<a id='" + idPrefix + "prevPage' href='javascript:;' class='" + pageNameClass + "'>" + prevPageText + "</a>";
			
			if(pageTotal == 1){
				pagingBarHtml += "<a id='" + idPrefix + "page_1' class='" + pageNumberClass + "' href='javascript:;'>" + 1 + "</a>";
			}else{
				//有多页
				var tempBack_block = pageTotal;
				var tempFront_block = 1;
				if (back_block < pageTotal)
					tempBack_block = back_block;
				if (front_block > 1)
					tempFront_block = front_block;

                var back_length = parseInt(showPageLengh/2);
                if(showPageLengh%2 != 0){
                    back_length= back_length + 1;
                }

                tempFront_block = pageIndexHolder > (showPageLengh - back_length) ? ( pageIndexHolder -(showPageLengh - back_length)) : 1;
                back_length=back_length-1;
                tempBack_block = (parseInt(pageIndexHolder) + back_length) <  pageTotal ? (parseInt(pageIndexHolder) + back_length) : pageTotal;

                if(tempBack_block < pageTotal
                        && (tempBack_block - tempFront_block + 1) <showPageLengh ){
                    tempBack_block = tempBack_block + (showPageLengh-(tempBack_block-tempFront_block)-1);
                }

                if(tempBack_block == pageTotal
                        && (tempBack_block - tempFront_block + 1) <showPageLengh ){
                    tempFront_block = tempFront_block - (showPageLengh-(tempBack_block-tempFront_block)-1);
                }
                tempFront_block = tempFront_block <=0 ? 1 : tempFront_block;

				for (var i = tempFront_block; i <= tempBack_block; i++) {
					pagingBarHtml += "<a id='" + idPrefix + "page_" + i + "' class='" + pageNumberClass + "' href='javascript:;'>" + i + "</a>";
				}
			}
			
			pagingBarHtml += "<a id='" + idPrefix + "nextPage' href='javascript:;' class='" + pageNameClass + "'>" + nextPageText + "</a>";
			pagingBarHtml += "<a id='" + idPrefix + "tailPage' href='javascript:;' class='" + pageNameClass + "'>" + tailPageText + "</a>";
			
			$_pagingBar.html(pagingBarHtml);
			
			$_pagingBar.find("#" + idPrefix + "prevPage").on("click", function(){
				pageIndexHolder--;
				$(this).siblings().removeClass(currentPageNumberClass);
				$_pagingBar.find("#" + idPrefix + "page_" + pageIndexHolder).addClass(currentPageNumberClass);//在此附加css，是为了能立即显示出当前页的css样式
				$_pagingBar.paging($.extend(optionsHolder, {pageIndex: pageIndexHolder, pageSize: pageSizeHolder}));
				
				//在这里先处理一次，是为了防止ajax请求失败，所以预先调用
				handlePageChange();
			});
			
			$_pagingBar.find("#" + idPrefix + "nextPage").on("click", function(){
				pageIndexHolder++;
				$(this).siblings().removeClass(currentPageNumberClass);
				$_pagingBar.find("#" + idPrefix + "page_" + pageIndexHolder).addClass(currentPageNumberClass);//在此附加css，是为了能立即显示出当前页的css样式
				$_pagingBar.paging($.extend(optionsHolder, {pageIndex: pageIndexHolder, pageSize: pageSizeHolder}));
				
				//在这里先处理一次，是为了防止ajax请求失败，所以预先调用
				handlePageChange();
			});
			
			$_pagingBar.find("#" + idPrefix + "headPage").on("click", function(){
				pageIndexHolder = 1;
				$(this).siblings().removeClass(currentPageNumberClass);
				$_pagingBar.find("#" + idPrefix + "page_" + pageIndexHolder).addClass(currentPageNumberClass);//在此附加css，是为了能立即显示出当前页的css样式
				$_pagingBar.paging($.extend(optionsHolder, {pageIndex: pageIndexHolder, pageSize: pageSizeHolder}));
				
				//在这里先处理一次，是为了防止ajax请求失败，所以预先调用
				handlePageChange();
			});
			
			$_pagingBar.find("#" + idPrefix + "tailPage").on("click", function(){
				pageIndexHolder = pageTotalHolder;
				$(this).siblings().removeClass(currentPageNumberClass);
				$_pagingBar.find("#" + idPrefix + "page_" + pageIndexHolder).addClass(currentPageNumberClass);//在此附加css，是为了能立即显示出当前页的css样式
				$_pagingBar.paging($.extend(optionsHolder, {pageIndex: pageIndexHolder, pageSize: pageSizeHolder}));
				
				//在这里先处理一次，是为了防止ajax请求失败，所以预先调用
				handlePageChange();
			});
			
			$_pagingBar.find("[id^=" + idPrefix + "page_" + "]").on("click", function(){
				pageIndexHolder = parseInt($(this).text());
				$(this).siblings().removeClass(currentPageNumberClass);
				$(this).addClass(currentPageNumberClass);//在此附加css，是为了能立即显示出当前页的css样式
				$_pagingBar.paging($.extend(optionsHolder, {pageIndex: pageIndexHolder, pageSize: pageSizeHolder}));
				
				//在这里先处理一次，是为了防止ajax请求失败，所以预先调用
				handlePageChange();
			});
			
			$_pagingBar.find("#" + idPrefix + "pageSize").on("change", function(){//1.9,1.9+
				pageSizeHolder = parseInt($_pagingBar.find("#" + idPrefix + "pageSize option:selected").text());
				$_pagingBar.paging($.extend(optionsHolder, {pageIndex: pageIndexHolder, pageSize: pageSizeHolder}));
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
			//maybe only one ,so not use else
			if(pageIndexHolder == 1){
				$_pagingBar.find("#" + idPrefix + "page_1").unbind("click");
				$_pagingBar.find("#" + idPrefix + "prevPage").unbind("click");
				$_pagingBar.find("#" + idPrefix + "headPage").unbind("click");
			} 
			
			if(pageIndexHolder == pageTotalHolder){
				$_pagingBar.find("#" + idPrefix + "page_" + pageTotalHolder).unbind("click");
				$_pagingBar.find("#" + idPrefix + "nextPage").unbind("click");
				$_pagingBar.find("#" + idPrefix + "tailPage").unbind("click");
			}
			
			if(pageTotalHolder == 0){
				$_pagingBar.find("#" + idPrefix + "page_1").unbind("click");
				$_pagingBar.find("#" + idPrefix + "prevPage").unbind("click");
				$_pagingBar.find("#" + idPrefix + "page_" + pageTotalHolder).unbind("click");
				$_pagingBar.find("#" + idPrefix + "nextPage").unbind("click");
				$_pagingBar.find("#" + idPrefix + "headPage").unbind("click");
				$_pagingBar.find("#" + idPrefix + "tailPage").unbind("click");
			} 
		}
		
		function handleCurrentPageButtonClass(){
			$_pagingBar.find("#" + idPrefix + "page_" + pageIndexHolder).addClass(currentPageNumberClass);
		}
		
		function handleScale(){
			$_pagingBar.find("#" + idPrefix + "pageIndex").text(pageIndexHolder);
		}
	};

})(jQuery);