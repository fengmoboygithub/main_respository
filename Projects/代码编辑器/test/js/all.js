/*
 * 控制渲染脚本调试工作台  js
 * Author : 杨延超
 * Date: 2018/01/23
 * Version: v1.0.1
 */
 $(function() {
	//代码区域自适应
	$(window).resize(function(){
	  var _winHeight = $(this).height();
	  _winHeight = _winHeight-18;
	  var wrapperHeight = (_winHeight-53);
	  $(".editor_wrapper").css('height',wrapperHeight+'px');
      $(".handler_horizontal").css('top',((wrapperHeight/2)-5)+'px');
	  var _winWidth = $(this).width();
	  $(".handler_vertical").css('left',((_winWidth/2)-18)+'px');	  
	});
	$(window).resize();
	//当聚焦代码区时显示右上角图标
	$(".editor").mousemove(function() {
	  $(this).find(".quick_tools").css('display','inline');
	});
	$(".editor").focusin(function() {
	  $(this).find(".quick_tools").css('display','inline');
	});
	$(".editor").find("iframe").mousemove(function() {
	  $(this).siblings(".quick_tools").css('display','inline');
	});
	$(".editor").mouseleave(function() {
	  $(this).find(".quick_tools").hide();
	});
	$(".editor").focusout(function() {
	  $(this).find(".quick_tools").hide();
	});
	$(".editor").find("iframe").mouseleave(function() {
	  $(this).siblings(".quick_tools").hide();
	});
	//全屏操作
	$(".quick_tools").find("img").click(function() {
	  if ( $(this).hasClass("on") ){
		//恢复以前布局
		$(".editorSet").css('width','50%');
		$(".editor").css('height','50%');
		$(this).removeClass("on");
		$(this).attr("src","img/arrow-out.png");
	  }	else {
		//全屏布局
		var _editorSet = $(this).parents(".editorSet");
		var _editor = $(this).parents(".editor");
		if ( _editorSet.hasClass("left") ){
			$(".right").css('width','0px');
			_editorSet.css('width','100%');
			//左布局
			if( _editor.hasClass("top") ){
				//左上块
				_editorSet.find(".bottom").css('height','0px');
				_editor.css('width','100%');
				_editor.css('height','100%');
			} else if( _editor.hasClass("bottom") ){
				//左下块
				_editorSet.find(".top").css('height','0px');
				_editor.css('width','100%');
				_editor.css('height','100%');
			}
		} else if( _editorSet.hasClass("right") ){
			$(".left").css('width','0px');
			_editorSet.css('width','100%');
			//右布局
			if( _editor.hasClass("top") ){
				//右上块
				_editorSet.find(".bottom").css('height','0px');
				_editor.css('width','100%');
				_editor.css('height','100%');
			} else if( _editor.hasClass("bottom") ){
				//右下块
				_editorSet.find(".top").css('height','0px');
				_editor.css('width','100%');
				_editor.css('height','100%');
			}
		}
		$(this).addClass("on");
		$(this).attr("src","img/arrow-in.png");
	  }
	});
	//hmtl编辑器初始化
	  var mixedModeHTML = {
        name: "htmlmixed",
        scriptTypes: [{matches: /\/x-handlebars-template|\/x-mustache/i,
                       mode: null},
                      {matches: /(text|application)\/(x-)?vb(a|script)/i,
                       mode: "vbscript"}]
      };
      var editorHTML = CodeMirror.fromTextArea(document.getElementById("code_html"), {
        mode: mixedModeHTML,
        selectionPointer: true,
		theme:"night",
		lineNumbers: true
      });
	//css编辑器初始化
	  var mixedModeCSS = {
        name: "css"
      };
      var editorCSS = CodeMirror.fromTextArea(document.getElementById("code_css"), {
        mode: mixedModeCSS,
        selectionPointer: true,
		theme:"night",
		lineNumbers: true
      });
	//js编辑器初始化
	  var mixedModeJS = {
        name: "javascript"
      };
      var editorJS = CodeMirror.fromTextArea(document.getElementById("code_js"), {
        mode: mixedModeJS,
        selectionPointer: true,
		theme:"night",
		lineNumbers: true
      });
	  //监听文本域按键按下事件 渲染预览窗口
	  $("textarea").keydown( function() {
		var _contentsHtml = $("#preview").contents().find("html");
		//将预览窗口内容清空
		_contentsHtml.empty();
		//获取html
		var _html = editorHTML.getValue();
		
		var len = _html.indexOf("<\/body>");
		if(len>0){
			_html = _html.substring(0,len);
		}
		//获取js
		var _js = editorJS.getValue();
		//var _js_str = "\n<script>\ntry{\n"+_js+"\n}catch(e){\n}\n<\/script>\n";
		var _js_str = "\n<script>\n"+_js+"\n<\/script>\n";
		_html+=_js_str;

		//获取css
		var _css = editorCSS.getValue();
		var _css_str = "\n<style>\n"+_css+"\n<\/style>\n";
		_html+=_css_str;
		_html+="<\/body>\n<\/html>";
		// 2. 将CSS，HTML字符串转换为Blob对象
		var blob = new Blob([_html], {
		  'type': 'text/html'
		});
		// 3. 使用URL.createObjectURL()方法将...
		$("#preview").attr("src",URL.createObjectURL(blob));
		
	  });
	  //保存按钮
	  $("#save").click( function() { 
		
	  });

 });