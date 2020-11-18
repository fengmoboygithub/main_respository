/*
 * ������Ⱦ�ű����Թ���̨  js
 * Author : ���ӳ�
 * Date: 2018/01/23
 * Version: v1.0.1
 */
 $(function() {
	//������������Ӧ
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
	//���۽�������ʱ��ʾ���Ͻ�ͼ��
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
	//ȫ������
	$(".quick_tools").find("img").click(function() {
	  if ( $(this).hasClass("on") ){
		//�ָ���ǰ����
		$(".editorSet").css('width','50%');
		$(".editor").css('height','50%');
		$(this).removeClass("on");
		$(this).attr("src","img/arrow-out.png");
	  }	else {
		//ȫ������
		var _editorSet = $(this).parents(".editorSet");
		var _editor = $(this).parents(".editor");
		if ( _editorSet.hasClass("left") ){
			$(".right").css('width','0px');
			_editorSet.css('width','100%');
			//�󲼾�
			if( _editor.hasClass("top") ){
				//���Ͽ�
				_editorSet.find(".bottom").css('height','0px');
				_editor.css('width','100%');
				_editor.css('height','100%');
			} else if( _editor.hasClass("bottom") ){
				//���¿�
				_editorSet.find(".top").css('height','0px');
				_editor.css('width','100%');
				_editor.css('height','100%');
			}
		} else if( _editorSet.hasClass("right") ){
			$(".left").css('width','0px');
			_editorSet.css('width','100%');
			//�Ҳ���
			if( _editor.hasClass("top") ){
				//���Ͽ�
				_editorSet.find(".bottom").css('height','0px');
				_editor.css('width','100%');
				_editor.css('height','100%');
			} else if( _editor.hasClass("bottom") ){
				//���¿�
				_editorSet.find(".top").css('height','0px');
				_editor.css('width','100%');
				_editor.css('height','100%');
			}
		}
		$(this).addClass("on");
		$(this).attr("src","img/arrow-in.png");
	  }
	});
	//hmtl�༭����ʼ��
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
	//css�༭����ʼ��
	  var mixedModeCSS = {
        name: "css"
      };
      var editorCSS = CodeMirror.fromTextArea(document.getElementById("code_css"), {
        mode: mixedModeCSS,
        selectionPointer: true,
		theme:"night",
		lineNumbers: true
      });
	//js�༭����ʼ��
	  var mixedModeJS = {
        name: "javascript"
      };
      var editorJS = CodeMirror.fromTextArea(document.getElementById("code_js"), {
        mode: mixedModeJS,
        selectionPointer: true,
		theme:"night",
		lineNumbers: true
      });
	  //�����ı��򰴼������¼� ��ȾԤ������
	  $("textarea").keydown( function() {
		var _contentsHtml = $("#preview").contents().find("html");
		//��Ԥ�������������
		_contentsHtml.empty();
		//��ȡhtml
		var _html = editorHTML.getValue();
		
		var len = _html.indexOf("<\/body>");
		if(len>0){
			_html = _html.substring(0,len);
		}
		//��ȡjs
		var _js = editorJS.getValue();
		//var _js_str = "\n<script>\ntry{\n"+_js+"\n}catch(e){\n}\n<\/script>\n";
		var _js_str = "\n<script>\n"+_js+"\n<\/script>\n";
		_html+=_js_str;

		//��ȡcss
		var _css = editorCSS.getValue();
		var _css_str = "\n<style>\n"+_css+"\n<\/style>\n";
		_html+=_css_str;
		_html+="<\/body>\n<\/html>";
		// 2. ��CSS��HTML�ַ���ת��ΪBlob����
		var blob = new Blob([_html], {
		  'type': 'text/html'
		});
		// 3. ʹ��URL.createObjectURL()������...
		$("#preview").attr("src",URL.createObjectURL(blob));
		
	  });
	  //���水ť
	  $("#save").click( function() { 
		
	  });

 });