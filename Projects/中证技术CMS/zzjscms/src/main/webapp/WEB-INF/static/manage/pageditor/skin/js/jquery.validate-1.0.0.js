/*
 * jquery验证插件
 * Author : Yangyanchao
 * Date: 2016/09/21
 * Version: v1.0.0
 */
(function($){
	$.fn.validate=function(options){
		var $_validate = $(this);
		//项目根目录
		var basePath = "";
		//正则表达式
		var regexObj = {
				"number":{"regex":/^\d+$/,"tipMsg":"text格式不对，请输入正确数值类型。"},
				"href":{"regex":/(http|ftp|https):\/\/[\w\-_]+(\.[\w\-_]+)+([\w\-\.,@?^=%&:/~\+#]*[\w\-\@?^=%&/~\+#])?/,"tipMsg":"text格式不对，请输入正确text，例如：http://xxxx.xxxx.xxx"},
				"money":{"regex":/^\d+\.\d{2}$/,"tipMsg":"text格式不对，请输入正确text，例如：999.99"},
				"mail":{"regex":/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/,"tipMsg":"text格式不对，请输入正确text，例如：xxxx@xxx.com"},
				"mobile":{"regex":/^((13[0-9])|(15[^4,\D])|(18[0,0-9]))\d{8}$/,"tipMsg":"text格式不对，请输入手机号码格式数据，例如：18612610693"},
				"fixedphone":{"regex":/(?:(\(\+?86\))(0[0-9]{2,3}\-?)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?)|(?:(86-?)?(0[0-9]{2,3}\-?)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?)/,"tipMsg":"text格式不对，请输入固定电话格式数据，例如：010-82078138"}
		};
		//提示内容对象
		var tipMsg = {
				"required_me": "text不能为空。",
				"maxlength_me": "text长度不能超过value。",
				"minlength_me": "text长度不能小于value。",
				"compare_me": "text不能大于value。",
				"compareNum_me": "text不能大于value。",
				"regex_me":  "value",
				"ajax_me":  "text值已存在，请重新输入。"
		};
		var validate = {
				//验证非空
				"required_me": function(attr_val,obj_val){
					if(attr_val){
						if(obj_val){
							return true;
						} else {
							return false;
						}
					} else {
						return true;
					}
				},
				//验证最大值
				"maxlength_me": function(attr_val,obj_val){
					var max_len = parseInt(attr_val);
					if(obj_val && obj_val.length > max_len){
						return false;
					} else {
						return true;
					}
				},
				//验证最小值
				"minlength_me": function(attr_val,obj_val){
					var min_len = parseInt(attr_val);
					if(obj_val && obj_val.length < min_len){
						return false;
					} else {
						return true;
					}
				},
				//验证比较值 attr_val=比较文本框的name属性值  比较文本
				"compare_me": function(attr_val,obj_val){
					var compareToVal = $('input[name='+attr_val+']', $_validate).val();
					if(obj_val && compareToVal && obj_val > compareToVal){
						return false;
					} else {
						return true;
					}
				},
				//验证比较值 attr_val=比较文本框的name属性值  比较数值
				"compareNum_me": function(attr_val,obj_val){
					var compareToVal = $('input[name='+attr_val+']', $_validate).val();
					if(obj_val && compareToVal && parseFloat(obj_val) > parseFloat(compareToVal)){
						return false;
					} else {
						return true;
					}
				},
				//验证正则表达式  attr_val=mail 
				"regex_me":  function(attr_val,obj_val){
					if(obj_val){
						var reg = regexObj[attr_val].regex;
						return reg.test(obj_val);
					} else {
						return true;
					}
				},
				//验证obj_val 是否已存在 存在则返回false 不存在则返回true
				"ajax_me":  function(attr_val,obj_val){
					if(obj_val){
						var _basePath = options?options.basePath:"";
						var re=new RegExp("'","g");
						attr_val = attr_val.replace(re,"\"");
						var attr_obj = jQuery.parseJSON(attr_val);
						var dataObj = {};
						dataObj[attr_obj.name] = obj_val;
						dataObj['uuid'] = attr_obj.uuid;
						var bolen = false;
					    $.ajax({
							type: "post",
							url: _basePath+attr_obj.url,
							data: dataObj,
							dataType: "json",
							async: false,
							success: function(json, textStatus, xhr){
								bolen = !json.result;
							},
							error: function(xhr, textStatus, error){
								alert("验证接口出错。。");
								bolen = false;
							}
						});
						return bolen;
					} else {
						return true;
					}
				}
		};
		var defaults={
				"basePath":options?options.basePath:"",
				"tipMsg":$.extend(tipMsg,options?options.tipMsg:{}),
				"regexObj":$.extend(regexObj,options?options.regexObj:{}),
				"validate":$.extend(validate,options?options.validate:{})
		};
		var defaultser=$.extend(defaults,options);
		var targetArr = $_validate.find('input,select,textarea');
		var errors = {};
		//查找将要验证的文本域下拉框文本区，进行验证
		targetArr.each(function(i){
			var targetObj = $(this);
			var msg = "";
			var t_name = targetObj.attr("name");
			var t_text = targetObj.attr("placeholder");
			var t_val = targetObj.val();
			var repObj = {"text":t_text};
			for(var tip_key in defaultser.tipMsg){
				var attr_val = targetObj.attr(tip_key);
				repObj["value"] = attr_val;
				if(attr_val && !attr_val.match("^\{(.+:.+,*){1,}\}$") && $('input[name='+attr_val+']', $_validate).length>0){
					repObj["value"] = $('input[name='+attr_val+']', $_validate).attr("placeholder");
				}
				var obj_val = t_val;
				var validateMethod = defaultser.validate[tip_key];
				if(attr_val && !validateMethod.call(undefined, attr_val, obj_val)){
					msg = repMethod(defaultser.tipMsg[tip_key],repObj,tip_key);
					break;
				}
			}
			if(msg){
				errors[t_name] = msg;
			}
		});
		//显示错误的信息
		showErrors($_validate, errors);
		return jQuery.isEmptyObject(errors);
		//替换文本
		function repMethod(repStr, repObj,tipKey){
			if("regex_me"==tipKey){
				for(var rep_key in repObj){
					var re=new RegExp(rep_key,"g");
					repStr = repStr.replace(re,repObj[rep_key]);
				}
				repStr = defaultser.regexObj[repStr].tipMsg;
				for(var rep_key in repObj){
					var re=new RegExp(rep_key,"g");
					repStr = repStr.replace(re,repObj[rep_key]);
				}
			} else {
				for(var rep_key in repObj){
					var re=new RegExp(rep_key,"g");
					repStr = repStr.replace(re,repObj[rep_key]);
				}
			}
			
			return repStr;
		}
		
		//显示错误的信息
		function showErrors(formObj,errors){
			formObj.find('p[class=help-block]').hide();
			formObj.find('input,select,textarea').parent().parent().removeClass("has-error");
			for(var name in errors){
				var e = formObj.find('p[for='+name+']');
				formObj.find('input[name='+name+'],select[name='+name+'],textarea[name='+name+']').parent().parent().addClass("has-error");
				if(e.length==0){
					formObj.find('input[name='+name+'],select[name='+name+'],textarea[name='+name+']').after('<p for="'+name+'" class="help-block"></p>');
					e = formObj.find('p[for='+name+']');
				}
				if(errors[name]!=""){
					e.html(errors[name]);
					e.show();
				}
			}
		}
	}
})(jQuery);

