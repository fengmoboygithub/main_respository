var interotcUrl = "http://www.interotc.com";
var fixedincome = "http://bond.interotc.com";
var southportal = "http://pe.interotc.com.cn";
var qingchuang = "http://www.chinayouthstartup.com";
var newfupin = "http://fupin.interotc.com";
/**
 * 得到所有查询参数字符串
 * @returns
 */
function getSearch() {
	var url = window.location.search;
	if (url) {
		var length = url.length;
		url = url.substring(0,1) == "?" ? decodeURIComponent(url.substring(1,length)) : decodeURIComponent(url.substring(0,length));
	}
	return "?"+url;
}

/**
 * 得到查询参数对象
 * @returns
 */
function getSearchObj(){
	 var url = getSearch();
	 var searchObj = {};
	 if(url){
		 //去掉?号
		 url = url.substr(1);
		 if(url.length > 0){
			 var arr = url.split("&");
			 for(var i=0;i<arr.length;i++){
				 var keyVal = arr[i];
				 if(keyVal && keyVal.length > 0 && keyVal.indexOf("=") > 0){
					 var keyValArr = keyVal.split("=");
					 var key = keyValArr[0];
					 var val = keyValArr[1];
					 searchObj[key] = val;
				 }
			 }
		 }
	 }
    return  searchObj;
}
/**
 * 返回前三个月的日期与当前日期
 */
function returnCurrDateAndBeforeDate(){
	var result = {};
	var date = new Date();
	var year = date.getFullYear();
	var month = date.getMonth();
	var day = date.getDate();
	var tempMonth = (month+1)+"";
	if(tempMonth.length==1){
		tempMonth = "0"+tempMonth;
	}
	var tempDay = day+"";
	if(tempDay.length==1){
		tempDay = "0"+tempDay;
	}
	result["currDate"] = year+"-"+tempMonth+"-"+tempDay;
	var beforeMonth = 0;
	var beforeYear = 0;
	if(month<=2){
		beforeMonth = 12 + (month-3)+1;
		beforeYear = year-1;
	} else {
		beforeMonth = (month-3)+1;
		beforeYear = year;
	}
	var beforeMonthStr = beforeMonth+"";
	if(beforeMonthStr.length==1){
		beforeMonthStr = "0"+beforeMonthStr;
	}
	result["threeDate"] = beforeYear+"-"+beforeMonthStr+"-"+tempDay;
	return result;
}
/**
 * 统一调用弹出提示消息框
 */
function baseAlert(type, message, option){
	var txt = message;
	switch( type ) {
		case 'info':
			if(option){
				window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info, option);
			} else {
				window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
			}
		break;
		case 'confirm':
			if(option){
				window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.confirm, option);
			} else {
				window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.confirm);
			}
		break;
		case 'warning':
			if(option){
				window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.warning, option);
			} else {
				window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.warning);
			}
		break;
		case 'error':
			if(option){
				window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.error, option);
			} else {
				window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.error);
			}
		break;
		case 'success':
			if(option){
				window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.success, option);
			} else {
				window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.success);
			}
			break;
		case 'input':
			if(option){
				window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.input, option);
			} else {
				window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.input);
			}
		break;
		case 'tips':
			if(option){
				if(option.onOk){
					var callbackMethod = option.onOk;
					baseTips(message, callbackMethod, null, null);
				} else {
					baseTips(message,null, option.times, null);
				}
			} else {
				baseTips(message);
			}
		break;
		case 'custom':
			if(option){
				window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.custom, option);
			} else {
				window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.custom);
			}
		break;
	}
}
/**
 * 统一调用弹出提醒框
 */
function baseTips(message, callbackMethod, times, icon){
	if(callbackMethod){
		$.dialog.tips(message,times?times:2,icon?icon:'',callbackMethod);
	} else {
		$.dialog.tips(message,times?times:2,icon?icon:'');
	}
}
var fileUrl = "http://172.16.101.25/report/otc/download_do_support_tm.g_form_ctrl?attachmentId=";
/**
 * 产品中心提供文件下载地址
 * @param id:文件id
 */
function downLoadFile(id){
	window.open(fileUrl+id);
}

/**
 * 数字，金额用逗号隔开 调用：fmoney("12345.675910", 3)，返回12,345.676 
 * 例如： 
	12345格式化为12,345.00 
	12345.6格式化为12,345.60 
	12345.67格式化为 12,345.67 
	只留两位小数。 
 * @param s
 * @param n
 * @returns {String}
 */
function fmoney(s, n){  
   if(!s){
	   return 0.00;
   }
   if(isNaN(s)){
	   return 0.00;
   }
   n = n > 0 && n <= 20 ? n : 2;   
   s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(n) + "";   
   var l = s.split(".")[0].split("").reverse(),   
   r = s.split(".")[1];   
   t = "";   
   for(i = 0; i < l.length; i ++ )   
   {   
      t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? "," : "");   
   }   
   return t.split("").reverse().join("") + "." + r;   
}
function fmoney_int(s, n){  
	   if(!s){
		   return 0;
	   }
	   if(isNaN(s)){
		   return 0;
	   }
	   n = n > 0 && n <= 20 ? n : 2;   
	   s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(n) + "";   
	   var l = s.split(".")[0].split("").reverse(),   
	   t = "";   
	   for(i = 0; i < l.length; i ++ )   
	   {   
	      t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? "," : "");   
	   }   
	   return t.split("").reverse().join("");   
	}
function fmoney_toZhengshu(s){ 
	   if(!s){
		   return 0;
	   }
	   if(isNaN(s)){
		   return 0;
	   }
	   var l = "";
	   var sNew=s+"";
	   if(sNew.indexOf(".")>-1){
		   l = sNew.split(".")[0].split("").reverse();  
	   }else{
		   l = s+"";
		   l =l.split("").reverse(); 
	   }
	   //var l = s.split(".")[0].split("").reverse(),   
	   t = "";   
	   for(i = 0; i < l.length; i ++ )   
	   {   
	      t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? "," : "");   
	   }   
	   return t.split("").reverse().join("");   
	}
function subStrFun(strVal){
	var newStr="";
	if(strVal.length>50){
		newStr=strVal.substr(0,50)+"...";
	}else{
		newStr=strVal;
	}
	return newStr;
}

//用于拼接资源图像路径
function imgSrcById(id){
	return interotcUrl+"/zzjsInterface/lbdocument/showImg.htm?id="+(!id?"":id);
}