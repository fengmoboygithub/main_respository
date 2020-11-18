/*
 * 控制渲染脚本调试工作台  js
 * Author : 杨延超
 * Date: 2018/01/23
 * Version: v1.0.1
 */
 $(function() {
	 function html_decode_iframe(str)
	 {
	   var s = "";
	   if (str.length == 0) return "";
	   s = str.replace(/&gt;/g, ">");
	   s = s.replace(/&lt;/g, "<");
	   s = s.replace(/&gt;/g, ">");
	   s = s.replace(/ /g, " ");
	   s = s.replace(/&#39;/g, "'");
	   s = s.replace(/&quot;/g, "\"");
	   return s;
	 }
	//当div.editor发生变化时重新设置编辑器大小
	function resizeTextArea(){
		$(".editor").each(function(){
		  if($(this).hasClass("html")){
			  editorHTML.setSize($(this).width()-5,$(this).height()-5);
		  } else if($(this).hasClass("js")){
			  editorJS.setSize($(this).width()-5,$(this).height()-5);
		  } else if($(this).hasClass("css")){
			  editorCSS.setSize($(this).width()-5,$(this).height()-5);
		  } else if($(this).hasClass("preview")){
			  
		  }
		});
	}
	//当fieldset.editorSet发生变化时重新设置div.editor宽度
	function resizeEditor(){
		$(".editorSet").each(function(){
		  $(this).find(".editor").width($(this).width());
		});
		resizeTextArea();
	}
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
      var url = "";
      var paramInfo = {};
      if("component" == _parma_type){
    	  url = _BasePath+"/manage/componentImport/allCode.json";
    	  paramInfo = {
    			  "id": _parma_id
    	  };
      } else if("instance" == _parma_type){
    	  url = _BasePath+"/manage/componentInstance/allCode.json";
    	  paramInfo = {
    			  "id": _parma_id
    	  };
      }  else if("page" == _parma_type){
    	  url = _BasePath+"/manage/pageditor/allCode.json";
    	  paramInfo = {
    			  "id": _parma_id
    	  };
      }
      
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
		console.log(_html);
		//获取js
		var _js = editorJS.getValue();
		//var _js_str = "\n<script>\ntry{\n"+_js+"\n}catch(e){\n}\n<\/script>\n";
		var _js_str = "\n<script type=\"text/babel\">\n"+_js+"\n<\/script>\n";
		_html+=_js_str;

		//获取css
		var _css = editorCSS.getValue();
		var _css_str = "\n<style>\n"+_css+"\n<\/style>\n";
		_html+=_css_str;
		_html+="<\/body>\n<\/html>";
		console.log(_html);
		// 2. 将CSS，HTML字符串转换为Blob对象
		var blob = new Blob([_html], {
		  'type': 'text/html'
		});
		// 3. 使用URL.createObjectURL()方法将...
		$("#preview").attr("src",URL.createObjectURL(blob));
		
	  });
	//将js编辑器赋初始值
      $.post(url, paramInfo,
      function(dataQuery) {
          if (dataQuery.result) {
        	  if(dataQuery.t.jsCode){
        		  editorJS.setValue(html_decode_iframe(dataQuery.t.jsCode));
        	  }
        	  if(dataQuery.t.htmlCode){
        		  editorHTML.setValue(html_decode_iframe(dataQuery.t.htmlCode));
        	  }
        	  if(dataQuery.t.cssCode){
        		  editorCSS.setValue(html_decode_iframe(dataQuery.t.cssCode));
        	  }
        	  $("textarea").keydown();
          }
      },"json");
	  //保存按钮
	  /*$("#save").click( function() { 
		
	  });*/
	//代码区域自适应
	$(window).resize(function(){
	  var _winHeight = $(this).height();
	  _winHeight = _winHeight-18;
	  var wrapperHeight = (_winHeight-53);
	  $(".editor_wrapper").css('height',wrapperHeight+'px');
      $(".handler_horizontal").css('top',((wrapperHeight/2)-5)+'px');
	  var _winWidth = $(this).width();
	  $(".handler_vertical").css('left',((_winWidth/2)-18)+'px');
	  resizeTextArea();
	});
	//垂直定位条  改变左右框宽度
	$(".handler_vertical").mousedown(function(e){
		console.log("--mousedown--"+e.pageX);
		//显示鼠标相对于文件的左侧和顶部边缘的位置
		/*var _winWidth = $(window).width();
		$(".left").width(e.pageX);
		var leftWidth = $(".left").width();
		$(this).css('left',(leftWidth+3)+'px');
		var verticalWidth = $(this).width();
		$(".right").width(_winWidth-leftWidth-verticalWidth);
		resizeEditor();*/
	});
	//全屏操作
	$(".quick_tools").find("img").click(function() {
	  if ( $(this).hasClass("on") ){
		//恢复以前布局
		$(".editorSet").css('width','50%');
		$(".editor").css('height','50%');
		$(this).removeClass("on");
		$(this).attr("src",_codeEditerPath+"img/arrow-out.png");
		$(window).resize();
	  }	else {
		//全屏布局
		var _editorSet = $(this).parents(".editorSet");
		var _editor = $(this).parents(".editor");
		if ( _editorSet.hasClass("left") ){
			$(".right").css('width','0px');
			_editorSet.css('width','100%');
			//左布局
			if( _editor.hasClass("top") ){
				_editorSet.find(".bottom").css('height','0px');
				_editor.css('width','100%');
				_editor.css('height','100%');
			} else if( _editor.hasClass("bottom") ){
				//左下块 JS
				_editorSet.find(".top").css('height','0px');
				_editor.css('width','100%');
				_editor.css('height','100%');
			}
		} else if( _editorSet.hasClass("right") ){
			$(".left").css('width','0px');
			_editorSet.css('width','100%');
			//右布局
			if( _editor.hasClass("top") ){
				//右上块  CSS
				_editorSet.find(".bottom").css('height','0px');
				_editor.css('width','100%');
				_editor.css('height','100%');
			} else if( _editor.hasClass("bottom") ){
				//右下块 预览
				_editorSet.find(".top").css('height','0px');
				_editor.css('width','100%');
				_editor.css('height','100%');
			}
		}
		$(this).addClass("on");
		$(this).attr("src",_codeEditerPath+"img/arrow-in.png");
		resizeTextArea();
	  }
	});
	$(window).resize();
	//当聚焦代码区时显示右上角图标
	$(".editor").mouseenter(function() {
	  $(this).find(".quick_tools").css('display','inline');
	});
	$(".editor").mouseleave(function() {
	  $(this).find(".quick_tools").hide();
	});
 });