//interotc项目地址
	var interotc ="";
//接口调用项目地址
	var interfacePath = "http://www.interotc.com/zzjsInterface/interface";
//项目路径地址
	var basePathMe = "/portal3.0";
//展示项目图片地址
	var productImg =interotc+"/xbrl/product/otc/openFile.g_form_ctrl?proxyType=true&attachmentId=";
/**
 * 封装公共接口调用js
 * Author : YangYanChao
 * Date: 2017/03/01
 * Version: v1.0.0
 */
/**
 * 用于封装查询详情或者不分页的列表接口   js获取筛选条件
 * @param interUrl      接口调用地址
 * @param optionsParam  查询条件的json对象
 * @param optionCallback 处理成功和失败的回调函数
 *        {"onSuccess": function(){return false;},"onFailure": function(){return false;}} 
 * @param isAsync true为同步 false 为异步
 * @param isResubmit true为防止重复提交 false 为不处理
 */
function getNotPageListData(interUrl ,optionsParam, optionCallback, isAsync, isResubmit, $operable){
	   //筛选条件值
	   var defaultOptions = {"methodType":"POST"};
	   var options = $.extend(defaultOptions, optionsParam||{});
	   var sessionId = options.sessionId?options.sessionId:"";
	   var defaultOptions2 = {
				"onSuccess": function(){return false;},
				"onFailure": function(){return false;}
	   };
	   var options2 = $.extend(defaultOptions2, optionCallback||{});
	   var asyncBoo = true;
	   if(isAsync){
		   asyncBoo = false;
	   }
	   var newOpt = {};
	   //把值为空的属性过滤掉
	   $.each(options, function(key,value){
		   if(value){
			   newOpt[key] = value;
		   }
	   });
	   var _btnHtml = "";
	   if(isResubmit) {
		   _btnHtml = $operable.html();
	   }
	   //调用接口 执行渲染
	   $.ajax({
			type: newOpt.methodType,
			url: interUrl,
			data: JSON.stringify(newOpt),
			dataType: "json",
			contentType:"application/json",
			async: asyncBoo,
			beforeSend: function(xhr) {
				xhr.setRequestHeader("sessionId", sessionId);
				if(isResubmit) {
					$operable.html("请求发送中。。。");
					$operable.attr("operable", false);
					baseAlert("tips","请求发送中。。。",{times:100000});
				}
			},
			success: function(json, textStatus, xhr){
				if(json.code==0){
					options2.onSuccess.call(undefined, json, textStatus, xhr);
				}else if(json.code==1){
					if(isResubmit) {
						$operable.attr("operable", true);
						$operable.html(_btnHtml);
					}
					baseAlert("tips",json.msg);
				}else if(json.code==-1){
					if(isResubmit) {
						$operable.attr("operable", true);
						$operable.html(_btnHtml);
					}
					baseAlert("tips",json.msg);
				}else if(json.code==-2){
					if(isResubmit) {
						$operable.attr("operable", true);
						$operable.html(_btnHtml);
					}
					baseAlert("tips",json.msg);
				}else if(json.code==-3){
					if(isResubmit) {
						$operable.attr("operable", true);
						$operable.html(_btnHtml);
					}
					baseAlert("tips",json.msg,{
						onOk: function(){
							//清除浏览器缓存
							//sessionStorage.removeItem("userInfo");
							//会话无效 则返回登录
							window.location.href=basePathMe+"/login.html";
						}
					});
				}
			},
			error: function(xhr, textStatus, error){
				options2.onFailure.call(undefined, xhr, textStatus, error);
			}
		});
}
/**
 * 用于封装查询分页列表接口   js获取筛选条件
 * @param interUrl      接口调用地址
 * @param pageBar       分页导航条的DIV juery对象
 * @param container     渲染列表的DIV  juery对象
 * @param pageSize      每页显示的最大记录数
 * @param pageInfoJson  由于返回的分页json数据中定义的总条数和页码和每页最大记录数属性名不一致故需要声明一下
 * 						{
 * 							"matchedTotal": "matchedTotal",
 * 							"pageSize": "pageSize",
 * 							"pageIndex": "pageIndex"
 * 						}
 * @param optionsParam  查询条件的json对象
 * @param optionCallback 处理成功和失败的回调函数
 *        {"onSuccess": function(){return false;},"onFailure": function(){return false;}} 
 */
function getPageListData(interUrl, pageBar, container, pageSize, pageInfoJson, optionsParam, optionCallback){
	   //筛选条件 值
	   var defaultOptions = {};
	   var options = $.extend(defaultOptions, optionsParam||{});
	   var newOpt = {};
	   //把值为空的属性过滤掉
	   $.each(options, function(key,value){
		   if(value){
			   newOpt[key] = value;
		   }
	   });
	   //回调函数
	   var defaultOptions2 = {
				"onSuccess": function(){return false;},
				"onFailure": function(){return false;}
	   };
	   var options2 = $.extend(defaultOptions2, optionCallback||{});
	   //声明条数json对象
	   var defaultOptions3 = {
			   "matchedTotal": "matchedTotal",
			   "pageSize": "pageSize",
			   "pageIndex": "pageIndex",
			   "type": "POST"
	   };
	   var options3 = $.extend(defaultOptions3, pageInfoJson||{});
	   //调用接口 执行渲染
	   pageBar.paging({
			container: container,
			ajaxUrl: interUrl,
			type: defaultOptions3.type,
			ajaxData:newOpt,
			pageIndex: 1,
			pageSize: pageSize,
			matchedTotalPropertyName: options3.matchedTotal,//ajax响应中的总记录数属性名
			pageSizeParamName: options3.pageSize,//ajax请求中的每页记录数的参数名
			pageIndexParamName: options3.pageIndex,//ajax请求中的页码
			onSuccess: options2.onSuccess,
			onFailure: options2.onFailure
		}); 
}
/**
 * 统一加载数据字典方法
 */
function loadDictionary(){
	
	//级联数据字典
	$("select[source]").each(function(){
		var _this = $(this);
		var key = _this.attr("source_dictionary");
		var source = _this.attr("source");
		$(source).bind("change", function(){
			var $this = $(this);
			var value = $this.val();
			// 请求开始
			var interUrl = interfacePath + "/doQueryInfo.json";
			var defaultOptions = {"fuctionType":"FN_016","key":key,"value":value};
			var optionsParam = $.extend(defaultOptions, optionsParam||{});
			var optionCallback = {
					"onSuccess":function(json, textStatus, xhr){
						_this.empty();
						_this.append($("<option>",{"value":"","html":"请选择"}));
						$.each(json.data,function(i, dataObj){
							var opt = $("<option>",{"value":dataObj.VALUE,"html":dataObj.TEXT});
							_this.append(opt);
						});
					},
					"onFailure": function(xhr, textStatus, error){
						
					}
			};
			getNotPageListData(interUrl ,optionsParam, optionCallback, true);
		});
	});
	
	//渲染数据字典
	$("select[dictionary]").each(function(){
		var _this = $(this);
		var key = _this.attr("dictionary");
		var isNull = _this.attr("isNull");
		var multipleFlag = false;
		multipleFlag = _this.hasClass("selectpicker");
		// 请求开始
		var interUrl = interfacePath + "/doQueryInfo.json";
		var defaultOptions = {"fuctionType":"FN_016","key":key};
		var optionsParam = $.extend(defaultOptions, optionsParam||{});
		var optionCallback = {
				"onSuccess":function(json, textStatus, xhr){
					_this.empty();
					if("MainAreasOfHelp" != isNull){//主要帮扶方向
						_this.append($("<option>",{"value":"","html":"请选择"}));
					}
					$.each(json.data,function(i, dataObj){
						var opt = $("<option>",{"value":dataObj.VALUE,"html":dataObj.TEXT});
						_this.append(opt);
					});
					if(multipleFlag){
						_this.selectpicker('refresh');
					} else {
						_this.val(_this.find("option").eq(0).val());
						_this.change();
					}
					
				},
				"onFailure": function(xhr, textStatus, error){
					
				}
		};
		getNotPageListData(interUrl ,optionsParam, optionCallback, true);
	});
}