/**
 * base基础方法
 *   base_getCachetime :  通过容器id或classid来获取缓存时间
 *   base_load :  加载内容
 *   base_mainLoad   : 加载主页面内容
 *   base_mainRihtLoad  : 加载右侧内容
 *   base_mainLeftLoad   : 加载左侧内容
 *   base_ajaxPost ： ajax同步请求处理
 *   base_initAutocomplete ： 初始化autocomplete
 *   base_initDialog　：　  初始化dialog
 *   loginConfirm : 登入确认
 *   base_showTip : tooltip提示信息
 *   Alert : alert信息提示
 *   Prompt : prompt提示
 *   Confirm : cofnirm确认框
 *
 *   base_Timer ： 定时循环执行函数 @param settings  {interval:定时执行时间 秒, run : 定时执行的function函数}
 *
 *   base_initPjax:
  *         初始化pajx  异步加载内容
  *         定义 a标签的 class="pjax"  containerId="目标容器的id"
  *         要求href链接的是完整的地址,href_pajx.do是局部加载的内容
  *         如：请求 :/mall/sglist.do, url 将自动转换为：/mall/sglist_pjax.do的内容
 *         注：href_pajx.do页面需要设置header属性X-PJAX-URL，即浏览器url改变的地址，刷新页面仍然可停留在当前页面
  *              response.setHeader("X-PJAX-URL", helper.toURL("mall", "lclist") + "?" + request.getQueryString());
 *
 *   base_pjax：
 *           处理异步加载内容（相当于直接调用base_initPajx a标签的click事件）
  *     @param href  href链接的是完整的地址,href_pajx.do是局部加载的内容  如果不是_pajx.do结尾的链接会转换为_pajx.do的链接
 *              注：href_pajx.do页面需要设置header属性X-PJAX-URL，即浏览器url改变的地址，刷新页面仍然可停留在当前页面
 *              response.setHeader("X-PJAX-URL", helper.toURL("mall", "lclist") + "?" + request.getQueryString());
  *     @param containerId 加载的容器id 默认为 mainRightContainerId
  *  base_selectYear:
 *      处理年份选择控件，选择指定年份的前后N年选择框
 *      @param target 需要被初始化为年份的控件
 *      @param start    指定的年份选择器
 *      @param setup  指定N年的范围
 *      @case     base_selectYear(a, 2012, 5)    把$(# + a) 的控件初始化为年份从 2007 - 2017的选择器
 *  base_initPageLoading:
 *       Version 1.1
 *      根据配置初始化页面加载方法,多个事件都将被延迟3毫秒执行
 *      @param option    页面初始化配置
 *      @param mainid    页面外层容器ID
 *  base_exportTable2Excel
 *      table导出为excel格式
 *      @param title 导出名称
 *      @param theadTR thead tr对象作为excel表头，th可以设置_columnWidth属性来设置excel的列宽，默认25
 *      @param tbodyTR tbody tr对象
 *  base_initScrollArea
 *      控制容器div的滚动，当window也有滚动时，鼠标放在当前容器区域里滚动滑轮使window的滚动失效
 *      @param container
 *  base_removeBlankDom
 *      移除指定容器内多余的空白节点以防止浏览器换行或者空白格出现
 *      @param container 指定容器对象
 *  base_iterDomArr
 *      迭代循环dom节点，将所有子孙节点根据节点类型筛选返回
 *      @param oElement 普通的dom节点对象
 *      @param arrEle       节点node数组
 *      @param type          筛选节点类型
 *  base_removeDom
 *      多级删除dom节点的方法
 *      @param oElem  节点dom对象
 *      @param level     层级，如果输入0表示删除当前层级，1会把父节点连同下面所有节点删除，2会把祖父节点下所有节点删除
 *  base_init_table_color
 *      version: 1.0.1   支持render-head属性来控制是否渲染第一行的数据
 *      初始化表格浮动样式，table上加上noInterleave样式的将不会被渲染
 *      @param container   支持外层容器定义
 *      @param className 样式名
 */

var loadingHtml = '<img style="float:left;padding:5px;" src="images/waiting.gif" title="加载中"/><div>加载中...</div>';

/**
 * 通过容器id或classid来获取缓存时间
 * @param containerId 容器id 或 classid
 */
function base_getCachetime(containerId){
    var result = 0;
    var id = "";
    try{
        if(typeof containerId == "string"){
            id = containerId;
        }else{
            id = $(containerId).attr("id");
        }

        id = id.replace("\.","").replace("#","");
        if(CACHE_TIME[id] != undefined){
            result = CACHE_TIME[id];
        }
    }catch(e){

    }
    return result;

}
/**
 * 加载内容
 * @param uri       请求uri
 * @param params    {}
 * @param callback   回调函数
 * @param containerId 指定加载的容器ID，如:"#mainContainerId"（可选）
 */
function base_load_me(uri, params, callback, containerId) {
    params = params || {};
    containerId = containerId || "";
    if(containerId == ""){
        alert("containerId参数未传入");
        return false;
    }
    $(containerId).empty();
    $(containerId).html(loadingHtml);
    
    $(containerId).load(uri, params, function(text, status, res) {
        if (callback) {
            callback.call(this);
        }
    });
}
/**
 * 加载内容
 * @param uri       请求uri
 * @param params    {}
 * @param callback   回调函数
 * @param containerId 指定加载的容器ID，如:"#mainContainerId"（可选）
 */
function base_load(uri, params, callback, containerId) {
    params = params || {};
    containerId = containerId || "";
    if(containerId == ""){
        alert("containerId参数未传入");
        return false;
    }
    $(containerId).empty();
    $(containerId).html(loadingHtml);

    //ajax loading缓存处理
    var cachekey = encodeURI(uri+object2ParamStr(params));
    var cache = getCache(cachekey);
    if(cache != null){
        $(containerId).html(cache);
         if (callback) {
            callback.call(this);
        }
    }else{
       $(containerId).load(uri, params, function(text, status, res) {
            var cachetime = parseInt($(containerId).attr("cachetime"));
            cachetime = !isNaN(cachetime) && cachetime > 0 ? cachetime : base_getCachetime(containerId);
            setCache(cachekey, text, cachetime);
            if (callback) {
                callback.call(this);
            }
        });
    }
}
/**
 * 加载主页面内容
 * @param uri       请求uri
 * @param params    {}
 * @param callback   回调函数
 */
function base_mainLoad(uri, params, callback) {
    base_load(uri, params,callback, "#mainContainerId");
}


/**
 * 加载右侧内容
 * @param uri       请求uri
 * @param params    {}
 * @param callback   回调函数
 */
function base_mainRihtLoad(uri, params, callback) {
    base_load(uri, params,callback, "#mainrightContainerId");
}
/**
 * 加载左侧内容
 * @param uri       请求uri
 * @param params    {}
 * @param callback   回调函数
 */
function base_mainLeftLoad(uri, params, callback) {
    base_load(uri, params,callback, "#mainleftContainerId");
}

/**
 * ajax同步请求处理
 * @param url     请求的url
 * @param async   是否异步
 * @param params      请求的参数 {param1:value1,param2:value2}
 * @param dataType  html、json、jsonp、script、text ，默认json
 * @param callback(json, status)
 * @param errorCallback(XMLHttpRequest, textStatus, errorThrown)
 */
function base_ajaxPost(url, async ,params,dataType, callback, errorCallback, targetId){
  $.ajax({
       type: "POST",
       url: url,
       data: params,
       dataType : dataType ? dataType : "json",
       async: async,//是否异步
       success: function(json,statu){
       		try{
	           if(callback){
	           		callback(json, statu, targetId).call(this);
	           }
           }catch(e){
           }
       },
       error:function (XMLHttpRequest, textStatus, errorThrown) {
            // 通常 textStatus 和 errorThrown 之中
            // 只有一个会包含信息
            //this; // 调用本次AJAX请求时传递的options参数
           if(errorCallback){
               errorCallback(XMLHttpRequest, textStatus, errorThrown);
           }else{
               if(XMLHttpRequest.responseText != "" && XMLHttpRequest.responseText.indexOf("reloginAlert") != -1){
                   Alert(XMLHttpRequest.responseText);
               }
           }
        }
  });
};

//初始化autocomplete
//设置input属性search="true", uri="获取数据的请求地址":返回json格式的数据，如：[{"item1"},{"item2"}] 或 [{"item1Value","item1Name"},{"item2Value","item2Name"}]
function base_initAutocomplete(){
    //初始化autocomplete
    //设置input属性search="true", uri="获取数据的请求地址":返回json格式的数据，如：[{"item1"},{"item2"}] 或 [{"item1Value","item1Name"},{"item2Value","item2Name"}]
    $('input[search="true"][uri!=""][autocomplete!="off"]').each(function(i, n){
           var search_input = $(n);
            search_input.autocomplete(search_input.attr("uri"), {
                minChars: 1,
                width: search_input.attr("auto_width") && search_input.attr("auto_width")!= undefined  ? parseInt(search_input.attr("auto_width")) : 200,
                scrollHeight:search_input.attr("auto_scrollHeight") && search_input.attr("auto_scrollHeight")!= undefined  ? parseInt(search_input.attr("auto_scrollHeight")) : 200,
                matchContains: true,
                cacheLength : 0,
                autoFill: false,
                selectFirst: false,
                dataType : "json",
                parse : function(data){
                    var _this=this;
                    var parsed = [];
                    var rows = data;
                    for (var i=0; i < rows.length; i++) {
                        var row = rows[i];
                        if (row) {
                            parsed[parsed.length] = {
                                data: row,
                                value: row[0],
                                result: _this.formatResult && _this.formatResult(row, row[0]) || row[0]
                            };
                        }
                    }
                    return parsed;
                },
                formatItem: function(row, i, max) {
                    var arr = [];
                    if(row == "")
                        return "";
                    if(typeof row !='string' && row.length >= 2){
                        if(row[1] != ""){
                           arr.push("<span class='resultTitle'>" + row[1]+ "</span>");
                           arr.push("(");
                        }
                        arr.push("<span class='resultTitle'>" + row[0] + "</span>");
                        if(row[1] != ""){
                            arr.push(")");
                        }
                    }else{
                         arr.push("<span class='resultTitle'>" + row + "</span>");
                    }
                    return arr.join("");
                    //return "<span class='resultTitle'>" + row[0] + "</span><span class='resultCount'>约" + row[1] + "个结果</span>";
                },
                formatMatch: function(row, i, max) {
                    if(typeof row !='string'){
                        return row[0];
                    }else{
                        return row;
                    }
                    //return row[0] + " " + row[1];
                },
                formatResult: function(row) {
                    if(typeof row !='string'){
                        return row[0];
                    }else{
                        return row;
                    }
                }
            });

    });
}

//设置标签的属性dialog="true", needLogin="true"表示只有登入后才能打开dialog（默认false） ,uri="请求地址" params : url参数，如：a=1&b=2 dialogWidth：dialog宽度，dialogHeight:dialog高度 ，dialogTitle：弹出框标题
function base_initDialog(){
    //dialog方式打开初始化
   $("[dialog='true'][uri!='']").unbind("click");
   $("[dialog='true'][uri!='']").click(function(){
       var _this = $(this);
       var params = _this.attr("params") != undefined ? paramStr2Obj(_this.attr("params")) : {};
       var newParams = {};
       for(var p in params){
          newParams[p] = encodeURIComponent(params[p]);
       }

       if(_this.attr("needLogin") == "true" && window["P_isUserLogin"] != "true"){
            //登入判断
            loginConfirm(location.href, "需要登入后才能继续操作，是否现在登入!");
           return false;
       }

       var uri = _this.attr("uri");
       if(uri != undefined && uri.lastIndexOf("?") != -1){
           uri = uri + "&t=" + new Date().getTime();
       }else{
           uri = uri + "?t=" + new Date().getTime();
       }

       var cfg={
           title : _this.attr("dialogTitle"),
           url : uri,
           params:newParams,
           onClose : null
       };

       //打开的uri是否单独页面，iframe方式打开
       _this.attr("frame") != undefined ? cfg.frame = _this.attr("frame") == "true" : "";
       _this.attr("dialogWidth") != undefined ? cfg.width = _this.attr("dialogWidth") : "";
       _this.attr("dialogHeight") != undefined ? cfg.height = _this.attr("dialogHeight") : "";

       openDialog(cfg);
   });
}

// 初始化设置标签为需要登录后才能进行操作
function base_initLogin(){
    $("[needLogin='true'][dialog!='true']").die("click").live("click", function(){
        if( window["P_isUserLogin"] != "true" ){
            //登入判断
//            loginConfirm(location.href, "需要登入后才能继续操作，是否现在登入!");
            var code = $(this).attr("code");
            var menuStyle = $(this).attr("menuStyle");
            var href = $(this).attr("href");
            href = href.substr(1, href.length);
            window.location.href = "../common/kjdl.do?code=" + code + "&style=" + menuStyle + "&href=" + href;
            return false;
        }else {
            return true;
        }
    });
}

/**
 * 登录确认窗口
 * @param returnUrl 登录成功后重定向的地址
 * @param msg 提示信息
 */
function loginConfirm(returnUrl, msg){
    var index = returnUrl.indexOf("?");
    if(index != -1){
        var url = returnUrl.substring(0, index);
        var query = returnUrl.substring(index + 1, returnUrl.length);
        var params = paramStr2Obj(query);
        var newParams = {};
        for(var p in params){
            newParams[p] = encodeURIComponent(params[p]);
        }
        returnUrl = url + "?" + object2ParamStr(newParams);
    }
    var loginDialog = base_openDialog({
        content: {
            text:'<div style="width: 300px;">加载中...</div>',
            ajax: {
                url: "../common/login_confirm.do?returnUrl=" + encodeURIComponent(returnUrl) + "&msg=" + encodeURIComponent(encodeURIComponent(msg)) + "&t=" + new Date().getTime()
            },
            title: {
                text: '登录提示',
                button: false
            }
        }
    });
    //取消
    $(".login_cancelBtnClassID").die("click").live("click", function(){
        loginDialog.qtip("destroy");
    });
}

/*---------------required tip2 plugin begin-------------------*/
/**
 * 提示成功信息
 * @param msg 消息
 */
function base_showTipSuccess(msg){
    base_showTip($('<div />'),msg,{ my: "center",at: "center",target: $(window)},"qtip-blue");
}
/**
 * tooltip提示信息
 * @param target  提示目标
 * @param content 提示内容
 * @param position {my,at} 显示位置
 * @param classes 指定qtip的class样式
 * @param hideEvent 隐藏窗体的事件
 */
function base_showTip(target, content, position, classes, hideEvent){
    var hide = "unfocus";
    if ( typeof (hideEvent) != "undefined" && hideEvent != ""){
        hide = hideEvent;
    }
    position = $.extend({
            my: "top left",
            at: "bottom left",
            viewport: $(window)
        },position);

    return target.removeData("qtip").qtip({
        content: {
            text: content,
            title:false
        },
        position: position,
        show: {
            event: false,
            ready: true,
            solo: false
        },
        hide: hide, // Don't specify a hide event either!
        style: {
            classes: 'qtip-shadow '+classes
        }
    });
}
function base_openDialog(config){
    config = config || {};
    config = $.extend({
        content: {
                text: '提示的内容可以是dom对象也可以是字符串',
        //        ajax: {
        //            url: $(this).attr('rel') //也可以通过ajax请求显示
        //        },
                title: {
                    text: '标题',
                    button: "关闭"//关闭按钮： false 不显示
                }
            },
        position: {
            my: 'center', at: 'center',
            target: $(window)
        },
        show: {
            solo:false,//只显示一个dialog?
            ready: true,
            modal: {
                on: true,
                blur: false
            }
        },
        hide: false,
        style: 'qtip-light qtip-rounded qtip-customer2',
        events: {
            render: function(event, api) {
                $('a[class=btn]', api.elements.content).click(api.hide);
            },
            hide: function(event, api) { api.destroy(); }
        }
    },config);

    return $('<div />').qtip(config);
}

/**
 * 打开倒计时的信息窗口
 * @param msg                  面板要显示的内容
 * @param closeEvent       倒计时结束或者closeBtn被点击后要进行的事件
 * @param closeTime        倒计时时间
 * @param closeBtnText    closeBtn要显示的文本
 * @param title                   面板要显示的标题
 * @param config               允许传递更多的个性化配置
 */
function base_openTimerAlert(msg, closeEvent, closeTime, closeBtnText, title, config){
    var config = $.extend({
        content: {
            text: '<div class="loading"></div> 提交请求中...',
            ajax: {
                url: window["P_basePath"] + 'main/timerAlert.do?msg=' + encodeURIComponent(encodeURIComponent(msg)) + "&closetime=" + closeTime + "&btntext=" + encodeURIComponent(encodeURIComponent(closeBtnText))
            },
            title: title
        },
        position: {
            my: 'center', at: 'center',
            target: $(window)
        },
        show: {
            solo:false,//只显示一个dialog?
            ready: true,
            modal: {
                on: true,
                blur: false
            }
        },
        style: 'qtip-light qtip-rounded qtip-dialogue qtip-customer'
    },config);

    $('<div />').qtip(config);
    $(".close_dialog_btn_classid").die("click").live("click", function(){
        $("*").qtip("destroy");
        //  必须是可执行的回调函数
        if ( typeof (closeEvent) == "function" ){
            closeEvent.apply(this);
        }
    })
}

function _dialogue(content, title) {
    $('<div />').qtip({
        content: {
            text: content,
            title: title
        },
        position: {
            my: 'center', at: 'center',
            target: $(window)
        },
        show: {
            ready: true,
            modal: {
                on: true,
                blur: false,
                escape:false
            }
        },
        hide: false,
        style: 'qtip-light qtip-rounded qtip-dialogue qtip-customer2',
        events: {
            render: function(event, api) {
                $('a[class=btn]', api.elements.content).click(api.hide);
            },
            blur: function (event, api) {
                var preQtipZindex = $('#qtip-' + (api.id - 1)).css("z-index");
                var thisQtipZindex = $('#qtip-' + api.id).css("z-index");
                if (preQtipZindex && preQtipZindex >= thisQtipZindex) {
                    $('#qtip-' + api.id).css("z-index", parseInt(preQtipZindex) + 1);
                }
            },
            focus: function (event, api) {
                var preQtipZindex = $('#qtip-' + (api.id - 1)).css("z-index");
                var thisQtipZindex = $('#qtip-' + api.id).css("z-index");
                if (preQtipZindex && preQtipZindex >= thisQtipZindex) {
                    $('#qtip-' + api.id).css("z-index", parseInt(preQtipZindex) + 1);
                }
            },
             visible: function (event, api) {
                 var preQtipZindex = $('#qtip-' + (api.id - 1)).css("z-index");
                 var thisQtipZindex = $('#qtip-' + api.id).css("z-index");
                 if (preQtipZindex && preQtipZindex >= thisQtipZindex) {
                     $('#qtip-' + api.id).css("z-index", parseInt(preQtipZindex) + 1);
                 }
             },
            hide: function(event, api) { api.destroy(); }
        }
    });
}

/**
 * alert信息提示
 * @param message
 * @param callback 回调函数callback()
 * @constructor
 */
function Alert(message, callback){
    var container = $('<div />',{style:"width:300px;"}),
        buttonBar = $('<div/>', {style:"text-align:center;"}),
        ok = $('<a/>', {"class":"btn", "href":'javascript:void(0);',
                                click:function(){
                                       if(typeof callback == "function"){
                                        callback();
                                       }
                                   }
        }).html($('<span/>', {text:'确定'}));

    var message_cnt = $('<div/>', {html: "",  style:"text-align:left;height:auto;" ,"class":"icon_warning"});
    message_cnt.append($('<div/>', {html: message,  style:"text-align:left;height:auto;width:235px;" ,"class":"fl"}));
    message_cnt.append($('<div/>', {html: "&ensp;",  style:"height:45px;width:1px;" ,"class":"fr"}));
    message_cnt.append($("<div />",{'class':'clear'}));

    _dialogue(container.append(message_cnt).append(buttonBar.html(ok)), '消息提示' );
}

/**
 * alert信息提示
 * @param message
 * @param callback 回调函数callback()
 * @constructor
 */
function AlertSuccess(message, callback){
    var container = $('<div />',{style:"width:300px;"}),
        buttonBar = $('<div/>', {style:"text-align:center;"}),
        ok = $('<a/>', {"class":"btn", "href":'javascript:void(0);',
                                click:function(){
                                       if(typeof callback == "function"){
                                        callback();
                                       }
                                   }
        }).html($('<span/>', {text:'确定'}));

    var message_cnt = $('<div/>', {html: "",  style:"text-align:left;height:auto;" ,"class":"icon_succeed"});
    message_cnt.append($('<div/>', {html: message,  style:"text-align:left;height:auto;width:235px;" ,"class":"fl"}));
    message_cnt.append($('<div/>', {html: "&ensp;",  style:"height:45px;width:1px;" ,"class":"fr"}));
    message_cnt.append($("<div />",{'class':'clear'}));

    _dialogue(container.append(message_cnt).append(buttonBar.html(ok)), '消息提示' );
}

/**
 * prompt提示
 * @param question
 * @param initial input初始值
 * @param callback 回调函数callback(?)，?=input输入值
 * @constructor
 */
function Prompt(question, initial, callback){
    var container = $('<div />',{style:"width:300px;"}),
        message = $('<div/>', {html: question,  style:"text-align:left;"}),
        input = $('<input />', { val: initial }),
        buttonBar = $('<div/>', {style:"text-align:center;"}),
        ok = $('<a/>', {"class":'btn', "href":'javascript:void(0);',
                           click:function(){
                               if(typeof callback == "function"){
                                callback(input.val());
                               }
                           }
                        }).html($('<span/>', {text:'确定'})),
        cancel = $('<a/>', {"class":'btn', "href":'javascript:void(0);',
                                   click:function(){
                                       if(typeof callback == "function"){
                                            callback(input.val());
                                        }
                                   }}).html($('<span/>', {text:'取消'}));

    _dialogue(container.append(message).append(input).append(buttonBar.append(ok).append(cancel)), '输入提示' );
}

/**
 * cofnirm确认框
 * @param question
 * @param callback 回调函数callback(?)，?=boolean:确定：true||取消：false
 * @constructor
 */
function Confirm(question, callback){
    var container = $('<div />',{style:"width:300px;"}),
            buttonBar = $('<div/>', {style:"text-align:center;"}),
            ok = $('<a/>', {"class":'btn', "href":'javascript:void(0);',
                               click:function(){
                                   if(typeof callback == "function"){
                                    callback(true);
                                   }
                               }
                            }).html($('<span/>', {text:'确定'})),
            cancel = $('<a/>', {"class":'btn', "href":'javascript:void(0);',
                                       click:function(){
                                           if(typeof callback == "function"){
                                                callback(false);
                                            }
                                       }}).html($('<span/>', {text:'取消'}));

    var message_cnt = $('<div/>', {html: "",  style:"text-align:left;height:auto;" ,"class":"icon_question"});
    message_cnt.append($('<div/>', {html: question,  style:"text-align:left;height:auto;width:235px;" ,"class":"fl"}));
    message_cnt.append($('<div/>', {html: "&ensp;",  style:"height:45px;width:1px;" ,"class":"fr"}));
    message_cnt.append($("<div />",{'class':'clear'}));

    _dialogue(container.append(message_cnt).append(buttonBar.append(ok).append(cancel)), '消息确认' );
}

/**
 * cofnirm确认框
 * @param question
 * @param title 窗口标题
 * @param qdmc 确定名称
 * @param qxmc 取消名称
 * @param callback 回调函数callback(?)，?=boolean:确定：true||取消：false
 * @constructor
 */
function confirm_custom(question, title, qdmc, qxmc, callback) {
    if (title == null || title == "undefined" || title == "") title = "消息确认";
    if (qdmc == null || qdmc == "undefined" || qdmc == "") qdmc = "确定";
    if (qxmc == null || qxmc == "undefined" || qxmc == "") qxmc = "取消";
    var container = $('<div />', {style: "width:300px;"}),
        buttonBar = $('<div/>', {style: "text-align:center;"}),
        ok = $('<a/>', {"class": 'btn', "href": 'javascript:void(0);',
            click: function () {
                if (typeof callback == "function") {
                    callback(true);
                }
            }
        }).html($('<span/>', {html: qdmc})),
        cancel = $('<a/>', {"class": 'btn', "href": 'javascript:void(0);',
            click: function () {
                if (typeof callback == "function") {
                    callback(false);
                }
            }}).html($('<span/>', {html: qxmc}));

    var message_cnt = $('<div/>', {html: "",  style:"text-align:left;height:auto;" ,"class":"icon_question"});
    message_cnt.append($('<div/>', {html: question,  style:"text-align:left;height:auto;width:235px;" ,"class":"fl"}));
    message_cnt.append($('<div/>', {html: "&ensp;",  style:"height:45px;width:1px;" ,"class":"fr"}));
    message_cnt.append($("<div />",{'class':'clear'}));

    _dialogue(container.append(message_cnt).append(buttonBar.append(ok).append(cancel)), title);
}

/*---------------required tip2 plugin end-------------------*/

/**
 * 定时循环执行
 * @param settings  {interval:定时执行时间 秒, run : 定时执行的function函数}
 * @return {*}
 */
function base_Timer(settings){
	this.settings = settings;
	this.timer = null;

	this.interval = (settings.interval || 30) * 1000;
	this.timeInit = null;

	return this;
}
base_Timer.prototype = {
	run: function(){
		var $this = this;

		this.settings.run.apply($this, []);
		this.timeInit += this.interval;

		this.timer = setTimeout(function(){$this.run()}, this.timeInit - (new Date).getTime());
	},

	start: function(){
		if(this.timer == null)
		{
			this.timeInit = (new Date).getTime();
			this.run();
		}
	},

	stop: function(){
		clearTimeout(this.timer);
		this.timer = null;
	}
}

/**
 * 获取请求地址
 *    处理调用base_pajx方法，没有$.support.pjax支持时获取href特殊处理（取hash）
 * @return {String}
 */
function base_getPajxHref(){
    var href = location.pathname;
    if(typeof $.support.pjax == "undefined"){
        if(location.hash.indexOf(".do") != -1){
            href = location.hash.substr(1, location.hash.indexOf(".do") + 2);
        }
    }else{
        href = location.pathname;
    }

    return href;

}

function _getContainer(containerId){
    if(containerId != ""
        && containerId != null
        && containerId != undefined
        && $("#" + containerId).length > 0){
        return  $("#" + containerId);
    }

    var container = $("#mainRightContainerId");
    if(container.length == 0){
        container =$("#mainrightContainerId");
    }
    return container;
}

function _getContainerId(href){
    var containerId = "";
    if(href.indexOf("&&containerId=") != - 1){
        containerId = href.substr(href.indexOf("&&containerId=") + "&&containerId=".length);
        containerId = containerId.substr(0, containerId.indexOf("&&"));
    }
    return containerId;
}

function _setContainerId(href, containerId){
    if(href.indexOf("?") != -1){
        href = href + "&&containerId=" + containerId + "&&";
    }else{
        href = href + "?&&containerId=" + containerId + "&&";
    }
    return href;
}

/**
 * 初始化pajx  异步加载内容
 * 定义 a标签的 class="pjax"  containerId="目标容器的id"
 * 要求href链接的是完整的地址,href_pajx.do是局部加载的内容
 * 如：请求 :/mall/sglist.do, url 将自动转换为：/mall/sglist_pjax.do的内容
 */
function base_initPjax(){
    //页面刷新初始化处理
    if(typeof $.support.pjax == "undefined"
        && $.History.handlers.generic.length == 0){
        $.History.bind(function(state){
            if(state.indexOf("_pjax.do") != -1){
                var containerId = _getContainerId(state);
                base_load(state,{}, null, _getContainer(containerId));
            }
        });

        $(document).keydown(function(event){
           if(event.keyCode == 116){
               if(location.hash.indexOf("_pjax.do") != -1){
                   window.event.returnValue = false;
                   location.href = location.hash.substr(1).replaceAll("_pjax.do",".do");
               }
           }
        });
    }

    $("a.pjax").click(function(event){
        var me = $(this);
        var href = me.attr("href");
        if(href.indexOf("_pjax.do") == -1){
            href = href.replaceAll(".do", "_pjax.do");
        }
        me.attr("href", href);
        var containerId = me.attr("containerId");
        containerId = containerId != undefined && containerId != "" && containerId != null
            ?  me.attr("containerId") : "mainRightContainerId";

        if(typeof $.support.pjax == "undefined"){
            href = _setContainerId(href, containerId);
            $.History.go(href);
        }else{
            _getContainer(containerId).html(loadingHtml);
            $.pjax.click(event, {container: _getContainer(containerId)});
        }
        return false;
    });
}

function base_pajx(href, containerId){
    base_pjax(href, containerId);
}
/**
 * 处理异步加载内容
 * @param href  href链接的是完整的地址,href_pajx.do是局部加载的内容  如果不是_pajx.do结尾的链接会转换为_pajx.do的链接
 * @param containerId 加载的容器id 默认为 mainRightContainerId
 */
function base_pjax(href, containerId){
    containerId = containerId != undefined && containerId != "" && containerId != null
            ? containerId : "mainRightContainerId";

    if(href.indexOf("_pjax.do") == -1){
          href = href.replaceAll(".do", "_pjax.do");
    }

    if(typeof $.support.pjax == "undefined"){
        href = _setContainerId(href, containerId);
        $.History.go(href);
    }else{
        _getContainer(containerId).html(loadingHtml);
        $("<a />", {href:href}).click(function(event){
                $.pjax.click(event, {container: _getContainer(containerId)});

            }).click();
    }
}

/**
 * 处理年份选择控件，选择指定年份的前后N年选择框
 *      @param target 需要被初始化为年份的控件
 *      @param start    指定的年份选择器
 *      @param setup  指定N年的范围
 *      @case     base_selectYear(a, 2012, 5)    把$(# + a) 的控件初始化为年份从 2007 - 2017的选择器
 */
function base_selectYear(target,start,setup){
    var $target =  $('#'+ target);
    $target.append($("<option value=''>请选择年份</option>"));

    for( var i = start - setup; i < start + setup; i++){
        $target.append($("<option value='"+i+"'>"+i+"</option>"));
    }

    var checkYear = function(target,setup){
        var $target =  $('#'+ target);
        if( $target.val() != "" ){
            var index = $target.val();
            var firstIndex = getReduce(index,setup);
            var lastIndex = getSum(index,setup);
            $target.empty();
            for(var i = firstIndex; i < lastIndex; i++){
                $target.append($("<option value='" + i + "'>"+i+"</option>"));
            }
            $('select[ctype="yearinit"] option').each(function(){
                if($(this).val() == index){
                    $(this).attr("selected","selected");
                }
            });
        }
    };

    var getSum = function(a,b){
        return parseInt(a)+parseInt(b);
    };

    var getReduce = function(a,b){
        return parseInt(a)-parseInt(b);
    };

    $target.change(function() {
        checkYear(target,setup);
    });
}

/**
 * 根据配置初始化页面加载方法
 * @param option    页面初始化配置
 * @param mainid    页面外层容器对象
 */
function base_initPageLoading(option, mainid){
    var warper = document.body;
    if ( typeof ( mainid ) != "undefined" ){
        warper = $(mainid);
    }
    var timeout = 0;
    if ( option && typeof (option) == "object" ){
        for( var item in option ){
            if ( typeof (item) == "string" ){
                var container = $(item, warper);
                if ( container.length > 0 ) {
                    var _param = {};
                    var _url = "";
                    var _callback = null;
                    if ( typeof ( option[item].param ) == "object" )   {
                        _param = option[item].param;
                    }
                    if ( typeof (option[item].url) == "undefined" ){
                        continue;
                    } else {
                        _url = option[item].url;
                    }
                    if ( typeof ( option[item].callback ) != "undefined" ){
                        _callback = option[item].callback;
                    }
                    if ( typeof ( option[item].cachetime) != "undefined" ) {
                        container.attr("cachetime", option[item].cachetime);
                    }
                    if ( timeout == 0 ) {
                        base_load( _url, _param, _callback, container);
                    } else {
                        timeout += 10;       // 每个时间延迟10毫秒执行
                        setTimeout(base_load( _url, _param, _callback, container), timeout);
                    }
                }
            }
        }
    }
}

/**
 * 导出当前table 到 excel
 * @param title 导出名称
 * @param theadTR thead tr对象作为excel表头，th可以设置_columnWidth属性来设置excel的列宽，默认25
 * @param tbodyTR tbody tr对象
 */
function base_exportTable2Excel(title, theadTR, tbodyTR){
    var heads = [];
    var columnWidths = [];
    $.each($("th", theadTR), function (i, n) {
        heads.push($.trim($(n).text()));
        var width = $(n).attr("_columnWidth");
        if(isNaN(width)){
            width = 25;
        }
        columnWidths.push(width);
    });

    var datas = [];
    if($("td", tbodyTR).length > 1){
        $.each(tbodyTR, function (i, n) {
            var dataItems = [];
            $.each($("td", n), function (i, n) {
                dataItems.push($.trim($(n).text()) + " ");
            });
            datas.push(dataItems.join("_c_"));
        });
    }

    if($(".export_excel_form_classid").length > 0){
        $(".export_excel_form_classid").empty();
    }

    var formHTML = '<div style="display: none;" class="export_excel_form_classid">\
        <form action="{submit_url}" method="post" target="blanktarget"  > \
            <input type="text" name="title" value="{title}"/>\
            <textarea name="heads">{heads}</textarea>       \
            <textarea name="columnWidths">{columnWidths}</textarea>        \
            <textarea name="datas">{datas}</textarea>\
        </form>   \
        <iframe name="blanktarget" src="about:blank"></iframe>\
    </div>' ;
    $(document.body).after(
        String.format(formHTML, {
            submit_url:window["P_basePath"] + "common/export_excel.do",//导出的url
            title:encodeURIComponent(title),
            heads:encodeURIComponent(heads.join("_r_")),
            columnWidths :encodeURIComponent(columnWidths.join("_r_")),
            datas: encodeURIComponent(datas.join("_r_"))
        })
    );

    $(".export_excel_form_classid form").submit();
}

/**
 * 控制容器div的滚动，当window也有滚动时，鼠标放在当前容器区域里滚动滑轮使window的滚动失效
 * @param container
 */
function base_initScrollArea(container) {
    if ($(container).length > 0) {
        var target = $(container)[0];
        if (jQuery.browser.mozilla) {
            target.addEventListener('DOMMouseScroll', function (e) {
                if($(container).height() < target.scrollHeight){
                    target.scrollTop += e.detail > 0 ? 60 : -60;
                }else{
                    target.scrollLeft += e.detail > 0 ? 60 : -60;
                }
                e.preventDefault();
            }, false);
        } else {
            target.onmousewheel = function (e) {
                e = e || window.event;
                if($(container).height() < target.scrollHeight){
                    target.scrollTop += e.wheelDelta > 0 ? -60 : 60;
                }else{
                    target.scrollLeft += e.wheelDelta > 0 ? -60 : 60;
                }
                e.returnValue = false
            };
        }
    }
}

/**
 * 去除浏览器中多余的空白节点问题
 * @param container  指定去除节点的容器
 */
function base_removeBlankDom(container) {
    var warpper = null;
    if ( arguments.length == 0 ) {
        warpper = document.body;
    } else if ( container instanceof jQuery ){ 
        warpper = container.get(0);
    } else {
        warpper = container;
    }
    var textArr = base_iterDomArr(warpper, [], 3);
    for ( var i = 0, len = textArr.length; i < len ; i ++ ) {
        var _node = textArr[i];
        var text = $.trim(_node.nodeValue.replace(/\r\n/g,""));
        if ( text === "" ) {
            // 因为构造jQuery对象需要耗费资源，所以使用原生的移除方案。
            if ( typeof (_node.parentNode) != "undefined" ) {
                _node.parentNode.removeChild(_node);
            } else {
                try {
                    $(_node).remove();
                } catch (e) {

                }
            }
        }
    }
}

/**
 * 迭代循环dom节点，将所有子孙节点根据节点类型筛选返回
 * @param oElement 普通的dom节点对象
 * @param arrEle       节点node数组
 * @param type          筛选节点类型
 * @return                   迭代遍历后的节点数组
 */
function base_iterDomArr(oElement, arrEle, type) {
    if ( arguments.length == 3 ) {
        if( oElement.hasChildNodes ){
            for (var i = 0; i < oElement.childNodes.length; i++){
                arguments.callee(oElement.childNodes[i], arrEle, type);
            }
            if( oElement.nodeType == type ){
                arrEle.push(oElement);
            }
        }
        return arrEle;
    }
}

/**
 * 多级删除dom节点的方法
 * @param oElem  节点dom对象
 * @param level     层级，如果输入0表示删除当前层级
 */
function base_removeDom( oElem, level ) {
    if ( level > 0 && oElem.parentNode ) {
        level --;
        arguments.callee(oElem.parentNode, level);
    } else {
        try {
            oElem.parentNode.removeChild(oElem);
        } catch (e) {
            $(oElem).remove();
        }
    }
}

/**
 * 初始化表格浮动样式，table上加上noInterleave样式的将不会被渲染
 * @param container   支持外层容器定义
 * @param className 样式名
 */
function base_init_table_color( container, className ) {
    var warpper = $(document.body);
    if ( arguments.length >0 ) {
        warpper = $(container);
    }
    if ( arguments.length <= 1 ) {
        var tableArr = ["infotable", "dataTable", "infoTable"];
        // 处理Table的鼠标滑过与悬停效果
        for ( var index in tableArr ) {
            if ( typeof (tableArr[index]) == "string" ) {
                var jObj = $("." + tableArr[index]);
                $.each(jObj, function(i, n) {
                    var _this = $(n);
                    var bNeedInter = typeof ( _this.attr("noInterleave")) == "undefined" ? false : !!_this.attr("noInterleave");
                    if ( !bNeedInter ) {
                        var bNeedRenderHead = typeof ( _this.attr("render-head")) == "undefined" ? false : !! _this.attr("render-head");
                        var _stratRender = $("tr:gt(0)", _this);
                        if ( bNeedRenderHead ) {
                            _stratRender = $("tr", _this);
                        }
                        _stratRender.hover(function(){
                            $(this).addClass("hover");
                        },function(){
                            $(this).removeClass("hover");
                        }).click(function(){
                            $(this).siblings("tr").removeClass("current");
                            $(this).addClass("current");
                        });
                    }
                })
            }
        }
    }  else if ( arguments.length == 2 ) {
        var $table =  $("." + className , warpper);
        var bNeedInter = typeof ( $table.attr("noInterleave")) == "undefined" ? false : !!$table.attr("noInterleave");
        if ( !bNeedInter ) {
            var bNeedRenderHead = typeof ( $table.attr("render-head")) == "undefined" ? false : !! $table.attr("render-head");
            var _stratRender = " tr:gt(0)";
            if ( bNeedRenderHead ) {
                _stratRender = " tr";
            }
            var $table_tr = $("." + className + _stratRender, warpper);
            $table_tr.hover(function(){
                $(this).addClass("hover");
            },function(){
                $(this).removeClass("hover");
            }).click(function(){
                $(this).siblings("tr").removeClass("current");
                $(this).addClass("current");
            });
        }
    }
}