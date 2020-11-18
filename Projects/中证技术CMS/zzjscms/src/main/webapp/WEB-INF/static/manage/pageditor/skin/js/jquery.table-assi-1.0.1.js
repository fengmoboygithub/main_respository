
/*
 * jquery赋值插件  用于表格
 * Author : Yangyanchao
 * Date: 2017/06/11
 * Version: v1.0.0
 */

(function($) {
	/**
	 * jsonObj 接口返回的json实体信息 一般用于列表页展示
	 * 将options.rowData按照sortList(排序数组)顺序赋值到tr(表格中tbody标签中最后一个tr)写入
	 * 这里说明一下column-assi属性(columname_text、columname_rmb_amt、columname_plain_amt、columname_percent、columname_callbackName(回调函数名)_converter、columname_configJson(内容拼接json信息 ${optNo}、${optCont})_array)定义标准：
	 * 1、column-assi属性值第一个分隔符的值是指列名
	 * 2、column-assi属性值最后一个分隔符的值是指赋值格式化包括text、amt、percent、converter(可自定义转化器)
	 * 3、column-assi属性值中间分隔符是指：如amt中的rmb(￥123，123)、plain(123，123)、dollar($123，123),如converter里面是自定义的转化器
	 */
	$.fn.columnAssi = function(options) {
		var _this = this;
		var $_assi_table = $(_this);
//		var extendCloumnData = '<a href="javascript:void(0);" title="查看" class="js_details">查看详情</a>|';
//			extendCloumnData += '<a href="javascript:void(0);" title="修改" class="js_update">修改</a>|';
//			extendCloumnData += '<a href="javascript:void(0);" title="删除" class="js_delete">删除</a>';
		//复选框列数据 一般是复选框列表项数据
		var checkedClumnData = "";
		//序号列数据 一般是序号列表项数据
		var sortClumnData = "";
		//扩展列数据 一般是操作列表项数据
		var extendCloumnData = "";
		var defaultOptions = {
				//行数据
				"rowData":{},
				//排序数组 要与jsonObj属性名称匹配
				"sortList":[],
				//复选框列数据 一般是复选框列表项数据
				"checkedClumnData":checkedClumnData,
				//序号列数据 一般是序号列表项数据
				"sortClumnData":sortClumnData,
				//扩展列数据 一般是操作列表项数据
				"extendCloumnData":extendCloumnData
		};
		var options = $.extend(defaultOptions, options||{});
		var jsonObjOld = options.rowData;
		var jsonObj = {};
		var sortList = options.sortList;
		//将重构jsonObj属性按照sortArr排序 
		$.each(sortList, function(i,attrName){
			$.each(jsonObjOld, function(objKey,objVal){
				if(attrName==objKey){
					var columnAssiVal = $_assi_table.find("[column-assi^='"+objKey+"_']").eq(0).attr("column-assi");
					jsonObj[objKey] = {"columnAssiVal":columnAssiVal,"objVal":objVal};
					return false;
				}
			});
		});
		var tr = $_assi_table.find("tbody").find("tr:last");
		//添加复选框td
		if(options.checkedClumnData){
			var td = $("<td>",{"html":options.checkedClumnData});
			tr.append(td);
		}
		//添加序号td
		if(options.sortClumnData){
			var td = $("<td>",{"html":options.sortClumnData});
			tr.append(td);
		}
		$.each(jsonObj,function (objKey, objValObj) {
			//该属性对应的值
			var objVal = objValObj.objVal;
			//该属性对应的column-assi 属性值
			var columnAssiVal = objValObj.columnAssiVal;
			if(!columnAssiVal){
				return true;
			}
			var columnAssiStrArr = columnAssiVal.split("_");
			var columnAssiStrArrLen = columnAssiStrArr.length;
			//column-assi属性值最后一个分隔符
			var columnAssiStrLast = columnAssiStrArr[columnAssiStrArrLen-1];
			var targetVal = "";
			if(objVal === 0){
				objVal = "0";
			}
			if(!objVal){
				objVal = "--";
			}
			//赋值类型判断逻辑
			if("text" == columnAssiStrLast){
				targetVal = objVal;
			} else if("number" == columnAssiStrLast){
				targetVal = parseInt(objVal);
			}  else if("float" == columnAssiStrLast){
				targetVal = parseFloat(objVal);
			} else if("amt" == columnAssiStrLast){
				var two = columnAssiStrArr[1];
				targetVal = fmoney(objVal, 2);
				if("rmb" == two){
					targetVal = "￥"+targetVal;
				} else if("dollar" == two){
					targetVal = "$"+targetVal;
				}
			} else if("percent" == columnAssiStrLast) {
				targetVal = objVal+"%";
			} else if("converter" == columnAssiStrLast) {
				var callbackName = columnAssiStrArr[1];//回调函数
				//动态执行js脚本将字符串转化为function
				var callbackFun = eval(callbackName);
				//执行回调函数
				targetVal = callbackFun.call(undefined,objVal);
			} else if("array" == columnAssiStrLast) {
				var configJson = columnAssiStrArr[1];//内容拼接json信息
				var list = objVal;
				var results = "";
				$.each(list, function(i, itemObj){
					var rowStr = configJson;
					$.each(itemObj, function(key, val){
						rowStr = rowStr.replace(new RegExp("\\$\\{"+key+"\\}","gi"),val);
					});
					results += rowStr + "<br/>"
				});
				targetVal = results;
			}
			if("hidden" == columnAssiStrLast) {
			} else {
				var td = $("<td>",{"html":targetVal});
				tr.append(td);
			}
		});
		var operationTh = $_assi_table.find("thead").find("tr:first").find("th:last");
		var roleFunctionok = operationTh.attr("roleFunctionok");
		var roleFunction = operationTh.attr("roleFunction");
		//添加扩展td
		if(options.extendCloumnData){
			if(roleFunctionok && roleFunctionok.length > 0){
				var td = $("<td>",{"html":options.extendCloumnData});
				tr.append(td);
			} else if(!roleFunction || roleFunction.length == 0){
				var td = $("<td>",{"html":options.extendCloumnData});
				tr.append(td);
			}
		}
		
	};

})(jQuery);




