var interotcUrl = "";
var fixedincome = "/fixedincome";
var southportal = "/southportal";
var qingchuang = "/qingchuang";
var newfupin = "/newfupin";
/*var interotcUrl = "http://www.interotc.com";
var fixedincome = "http://bond.interotc.com.cn";
var southportal = "http://pe.interotc.com.cn";
var qingchuang = "http://www.chinayouthstartup.com";
var newfupin = "http://fupin.interotc.com";*/
var downloadIp = interotcUrl+"/zzjsInterface/interface";
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

function toHyfpFun(thisObj){
	//sa.quick('trackHeatMap',thisObj);
	if(window["P_isUserLogin"]){
		window.location.href=interfacePath+"/loginTag/redirectUrlPortal.json?type=fupin";
	} else {
		window.location.href=newfupin;
	}
}
function toScptFun(thisObj){
	//sa.quick('trackHeatMap',thisObj);
	if(window["P_isUserLogin"]){
		window.location.href=interfacePath+"/loginTag/redirectUrlPortal.json?type=qingchuang";
	} else {
		window.location.href= qingchuang;
	}
}
function toTjjdFun(thisObj){
	//sa.quick('trackHeatMap',thisObj);
	window.location.href="http://toujiao.interotc.cn";
}
function toYwtgListFun(){
	window.location.href="";
}
function toYsphyFun(){
	//sa.quick('trackHeatMap',this);
	window.open("https://derivatives.interotc.com.cn");
}

function toGsptDetail(thisObj){
	var href = interotcUrl +fixedincome +"/html/product/productdetail.html?xbrlid="+$(thisObj).attr("data-xblid")+"&cpdm="+$(thisObj).attr("data-cpdm")+"&type=1";
	if(window["P_isUserLogin"]){
		 href = interfacePath+"/loginTag/redirectUrlPortal.json?type=bond&toUri="+encodeURIComponent("html/product/productdetail.html?xbrlid="+$(thisObj).attr("data-xblid")+"&cpdm="+$(thisObj).attr("data-cpdm")+"&type=1");
	}
	window.open(href);
}
function toSmgqDetailFun(thisObj){
	var xblid=$(thisObj).attr("data-xblid");
	var id=$(thisObj).attr("data-id");
	var cpdm=$(thisObj).attr("data-cpdm");
	var zt=$(thisObj).attr("data-zt");
	var cplx=$(thisObj).attr("data-cplx");
	//5801|众创企业融资;5802|扶贫企业融资;5803|众创项目融资;5804|双创企业融资;5805|双创项目融资
	var href = "";
	if(window["P_isUserLogin"]){
		if(cplx=='5801' || cplx=='5802' || cplx=='5804'){
			href = "html/equityFinancing/detail.html?XBRLID="
					+xblid+"&ID="+id+"&CPDM="+cpdm+"&ZT="+zt;
		}else{
			href = "html/equityFinancing/detailxm.html?XBRLID="
					+xblid+"&ID="+id+"&CPDM="+cpdm+"&ZT="+zt;
		}
		href = interfacePath+"/loginTag/redirectUrlPortal.json?type=pe&toUri="+encodeURIComponent(href);
	}else{
		if(cplx=='5801' || cplx=='5802' || cplx=='5804'){
			href = "/html/equityFinancing/detail.html?XBRLID="
					+xblid+"&ID="+id+"&CPDM="+cpdm+"&ZT="+zt;
		}else{
			href = "/html/equityFinancing/detailxm.html?XBRLID="
					+xblid+"&ID="+id+"&CPDM="+cpdm+"&ZT="+zt;
		}
		href = interotcUrl +southportal+ href;
	}
	//sa.quick('trackHeatMap',this);
	window.open(href);
}

function sylChangeFun(value){
	var sylPart=$("<div>");
	var li_01 = $("<div>",{"id":"syl_part","class":"syl_part"});
	var li_01_p2 = $("<p>",{"id":"tab1_p2"});
	var li_01_p2_span1 = "";
	var li_01_p2_span2 = "";
	var li_01_p2_span3 = "";
	var li_01_p2_span4 = "";
	
	if(value.CPFL=="51"){
		li_01_p2_span1 = $("<span>");
		li_01_p2_span2 = $("<span>");
		li_01_p2_span3 = $("<span>");
		li_01_p2_span4 = $("<span>",{"html":"浮","style":"font-size:31px;"});
	}else{
		li_01_p2_span1 = $("<div>",{"class":"gs_rate_val","html":value.GDSYL});
		li_01_p2_span2 = $("<div>",{"html":""});
		if(value.GDSYL!==""&&value.GDSYL!=null&&value.FDSYL!="--"){
			li_01_p2_span3 = $("<span>",{"html":"+"});
		}else{
			li_01_p2_span3 = $("<span>",{"html":""});
		}
		if(value.FDSYL!="" && value.FDSYL!=null && value.FDSYL!="--"){
			li_01_p2_span4 = $("<span>",{"title":"浮动"+value.FDSYL,"html":"浮"});
		}
	}
	li_01_p2.append(li_01_p2_span1);
	li_01_p2.append(li_01_p2_span2);
	li_01_p2.append(li_01_p2_span3);
	li_01_p2.append(li_01_p2_span4);
	li_01.append(li_01_p2);
	
	var li_01_p3 ="";
	if(value.CPFL=="57"){//收益凭证
		li_01_p3 = $("<p>",{"id":"tab1_p3","style":"margin-top: 1px;","html":"年化收益率"});
	}else if(value.CPFL=="52"){//非公开发行公司债
		li_01_p3 = $("<p>",{"id":"tab1_p3","style":"margin-top: 1px;","html":"票面利率"});
	}else if(value.CPFL=="55"||value.CPFL=="51"){//资产支持证券、资管计划
		li_01_p3 = $("<p>",{"id":"tab1_p3","style":"margin-top: 1px;","html":"预期收益率"});
	}
	li_01.append(li_01_p3);
	sylPart.append(li_01);
	return sylPart.html();
}
function fxrChangeFun(value){
	var fxrPart=$("<div>");
	var li_01 = $("<div>",{"id":"gs_fxr_div","class":"gs_fxr_div"});
	
	var li_04_p1 = $("<div>",{"id":"gs_fxr_val","html":value.FXFMC==""?"--":value.FXFMC});
	var li_04_p2 = "";
	if(value.CPFL=="57"){
		li_04_p2 = $("<div>",{"id":"gs_fxr_tips","class":"gs_fxr_tips","html":"发行人"});
	}else if(value.CPFL=="52"){
		li_04_p2 = $("<div>",{"id":"gs_fxr_tips","class":"gs_fxr_tips","html":"承销商"});
	}else if(value.CPFL=="55"||value.CPFL=="51"){
		li_04_p2 = $("<div>",{"id":"gs_fxr_tips","class":"gs_fxr_tips","html":"管理人"});
	}
	li_01.append(li_04_p1);
	li_01.append(li_04_p2);
	fxrPart.append(li_01);
	return fxrPart.html();
}
function setProgressBarValFun(barVal){
	if(barVal<0){
		barVal=0;
	}else if(barVal>100){
		barVal=100;
	}else{
		barVal=barVal;
	}
	return barVal+"%";
}
//进入机构信息详情
function toJgxxDetailFun(hydm){
	var href = "jgxxDetail.html?hydm="+hydm;
	window.open(href);
}

//进入产品公告详情
function toCpggDetailFun(bdid){
	var href = "cpggDetail.html?bdid="+bdid;
	window.open(href);
}
//进入通知公告详情
function toTzggDetailFun(bdid){
	var href = "tzggDetail.html?bdid="+bdid;
	window.open(href);
}
//进入市场动态详情
function toScdtDetailFun(bdid){
	var href = "scdtDetail.html?bdid="+bdid;
	window.open(href);
}
//进入业务规则详情
function toYwgzDetailFun(bdid){
	var href = "ywgzDetail.html?bdid="+bdid;
	window.open(href);
}
//进入操作指引详情
function toCzzyDetailFun(bdid){
	var href = "czzyDetail.html?bdid="+bdid;
	window.open(href);
}
//产品公告附件下载
function loadFileByCpgg(fileName,Id,name){
    window.open(downloadIp+"/lbdocument/downloadWord.json?table=TFP_CPZXXX&column=OTCFJ&fileName="+fileName+"&id="+Id+"&name="+name);
}
//业务规则、操作指引、常见问题、关于我们的附件下载
function loadFileByYwgz(id,name){
	window.open(downloadIp+'/lbdocument/downloadPdf.json?table=tOTC_WebXX_Attachment&column=Document&id='+id+'&name='+name);
}
//通知公告、市场动态的附件下载
function loadFileByTzgg(id){
    window.open(interotcUrl+"/UploadServlet.do?EVENT_SOURCE=DOWNLOAD&Mod=scbxwAttr&ID=" + id);
}
//加载数据项的点击事件
function loadUrlByPlate($_obj){
	$($_obj).find("[data-plate]").click(function(){
		var _this = $(this);
		var url = _this.attr("data-url");
		var plate = _this.attr("data-plate");
		var type = _this.attr("data-type");
		var isLogin = _this.attr("data-is-login");
		var href;
		if(window["P_isUserLogin"]){
			if(plate){
				var type = _this.attr("type");
				if(type){
					href = interfacePath+"/loginTag/redirectUrlPortal.json?type="+plate+"&toUri="+encodeURIComponent("");
				}else{
					if(plate == "no" ){
						href = url;
					}else{
						 if(url == "1"){
							 href = interfacePath+"/loginTag/redirectUrl.json?type="+plate;
						 }else{
							 href = interfacePath+"/loginTag/redirectUrlPortal.json?type="+plate+"&toUri="+encodeURIComponent(url);
						 }
					}
				}
			}else{
				href = interotcUrl +"/"+ url;
			}
		}else{
			if(plate=="pe"){
				href = interotcUrl +southportal +"/"+url;
			}else if(plate=="bond"){
				href = interotcUrl +fixedincome +"/"+ url;
			}else if(plate=="qingchuang"){
				var type = _this.attr("type");
				href = interotcUrl +qingchuang +"/"+ url;
				if(type){
					href = url;
				}
			}else if(plate=="fupin"){
				var type = _this.attr("type");
				href = interotcUrl +newfupin  +"/"+url;
				if(type){
					href = url;
				}
			}else if (plate == "interotc"){
				var cyrzq_font =  _this.attr("id");
				href = interotcUrl+"/"+url;
				if("cyrzq_font" == cyrzq_font){
					href = toLoginUrl;
				}
			}else if (plate=="no"){
				href = url;
			}
			
			if(isLogin){
				 href = toLoginUrl;
			}
		}
		window.location.href = href;
	});
}