	var isLogin = false;
	var sysDate = "";
	var userTypeCode = -1;
	var userName = "";
	var MAINYH = "";
	var HYDM = "";
	var attributes;
	var toLoginUrl ="";
	var toOutUrl ="";
	 //获取登陆信息中的客户类别
	$.ajax({
		type : "POST",
		url : interfacePath+"/loginTag/isLogin.json?t=" + new Date().getTime(),
		dataType : "json",
		async : false,
		success : function(json, textStatus, xhr) {
			if (json.code > 0) {
				isLogin = json.etcetera.isLogin;
	        	sysDate = json.etcetera.sysDate;
	        	if(isLogin){
	        		userTypeCode = json.etcetera.userTypeCode;
	        		userName = json.etcetera.userInfo.attributes.KHXM;
	        		MAINYH = json.etcetera.userInfo.attributes.MAINYH;//131101
	        		HYDM = json.etcetera.userInfo.attributes.HYDM;//131101001
	        		//HYDM = HYDM == undefined ? userName : HYDM;
	        		isMainUser=json.etcetera.userInfo.attributes.isMainHy;
	        		attributes = json.etcetera.userInfo.attributes;
	        		outlogin();
	        	} else{
	        		sysDate = "";
	        		userTypeCode = -1;
	        		userName = "";
	        		MAINYH = "";
	        		HYDM = "";
	        		attributes="";
	        		login();
	        	}
	        	window["P_attributes"] = attributes;
	        	window["P_MAINYH"] = MAINYH;
	    		window["P_HYDM"] = HYDM;
	    		window["P_userType"] = userTypeCode;//-1:未登录
	    		window["P_userName"] = userName;
	    		window["P_userType_ParticipantOperator"] = 0;
	    		window["P_userType_ParticipantMaster"] = 1;
	    		window["P_userType_Investor"] = 2;
	    	    window["P_isUserLogin"] = isLogin;//js脚本使用
	    	    window["P_basePath"] = "/";//'';//js脚本使用
	    	    window["P_contextPath"] = "/";
	    	    window["P_cache_enable"] = 'true';
	    	    window["P_sysDate"] = sysDate; //格式为MM-dd-yyyy用于js转换
	    	    window["P_isFzjyMode"] = 'false';
			}
		},
		error : function(xhr, textStatus, error) {

		}
	   });
		
		function userTypeIsParticipantOperator(){
			return window["P_userType"] === window["P_userType_ParticipantOperator"];
		}
		function userTypeIsParticipantMaster(){
			return window["P_userType"] === window["P_userType_ParticipantMaster"];
		}
		function userTypeIsInvestor(){
			return window["P_userType"] === window["P_userType_Investor"];
		}
		function isUserLogin(){
			return window["P_isUserLogin"] === window["P_isUserLogin"];
		}
//登陆事件
function login(){
	 $.ajax({
		type: "POST",
		url:interfacePath+"/loginTag/loginInfo.json",
		data: {
			"tagType":"a",
			"cssClass":"",
			"cssStyle":"",
			"text":"登录",
			"target":"_self",
			"loginFalg":"1",
			"toUri":window.location.pathname+window.location.search
		},
		dataType: "json",
		async: false,
		success: function(json, textStatus, xhr){
			//访问成功则
			if(json.code > 0) {
				toLoginUrl = json.etcetera.toUrl;
				//window.location.href=toUrl;
			}
		},
		error: function(xhr, textStatus, error){
		}
	}); 
}

/**
 * 
 */
function clearCookie(){
	$.ajax({
		type: "POST",
		url: interfacePath+"/loginTag/ajaxLogout.json?t="+new Date().getTime(),
		data: {},
		dataType: "json",
		async: false,
		success: function(json, textStatus, xhr){
		},
		error: function(xhr, textStatus, error){
		}
	});
}

/**
 * 退出事件
 */
function outlogin(){
	$.ajax({
		type: "POST",
		url: interfacePath+"/loginTag/loginInfo.json?t="+new Date().getTime(),
		data: {
			"tagType":"a",
			"cssClass":"",
			"cssStyle":"",
			"text":"退出",
			"target":"_self",
			"loginFalg":"2",
			"toUri":window.location.pathname+window.location.search
		},
		dataType: "json",
		async: false,
		success: function(json, textStatus, xhr){
			//访问成功则
			if(json.code > 0) {
			//	clearCookie();
				toOutUrl = json.etcetera.toUrl; 
			 //	window.location.href = json.etcetera.toUrl;
			}
		},
		error: function(xhr, textStatus, error){
			alert(error);
		}
	}); 
	
 }

function doLogin(type){
	if(type == "loginOut"){
		clearCookie();
		window.location.href=toOutUrl;
	}else if(type == "login"){
		 window.location.href=toLoginUrl;
	}else if(type == "register"){
		 window.location.href="http://www.interotc.com.cn/user/investorRegister.do";
	}
}
