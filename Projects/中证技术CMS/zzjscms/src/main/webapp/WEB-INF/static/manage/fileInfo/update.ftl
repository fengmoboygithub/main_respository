<#assign menu="site">
<#assign submenu="update_fileInfo">
<#assign codeEditerPath=BASE_PATH+"/static/manage/codeEditer/">
<#include "/manage/head.ftl">
<link rel="stylesheet" href="${codeEditerPath}js/CodeMirror-2.25/lib/codemirror.css">
<link rel="stylesheet" href="${codeEditerPath}js/CodeMirror-2.25/theme/night.css">
<script type="text/javascript" src="${codeEditerPath}js/jquery/jquery.js"></script>
<script type="text/javascript" src="${codeEditerPath}js/CodeMirror-2.25/lib/codemirror.js"></script>
<script type="text/javascript" src="${codeEditerPath}js/CodeMirror-2.25/addon/selection/selection-pointer.js"></script>
<script type="text/javascript" src="${codeEditerPath}js/CodeMirror-2.25/mode/xml/xml.js"></script>
<script type="text/javascript" src="${codeEditerPath}js/CodeMirror-2.25/mode/javascript/javascript.js"></script>
<script type="text/javascript" src="${codeEditerPath}js/CodeMirror-2.25/mode/css/css.js"></script>
<script type="text/javascript" src="${codeEditerPath}js/CodeMirror-2.25/mode/vbscript/vbscript.js"></script>
<script type="text/javascript" src="${codeEditerPath}js/CodeMirror-2.25/mode/htmlmixed/htmlmixed.js"></script>
<script type="text/javascript">
    var _BasePath = "${BASE_PATH}";
</script>
<!--main content start-->
<style type="text/css">

</style>
<section id="main-content">
	<section class="wrapper">
		<!-- page start-->
		<form id="update_fileInfo_form" class="form-horizontal" action="${BASE_PATH}/manage/fileInfo/update.json"  autocomplete="off"  method="post"
			enctype="multipart/form-data">
			<fieldset>
		<div class="row">
			<input type="hidden" name="fileId" value="${fileInfo.fileId}">
			<div class="col-lg-12">
			
			<section class="panel">
					<header class="panel-heading"> 
						修改文件
					</header>
					<div class="panel-body">
                        <div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">目录</label>
                          <div class="col-sm-10">
                              <select class="form-control" name="folderId" style="font-size:15px;width: 300px;">
                              		<#list folderAll as folder>
			                        	<option value="${folder.folderId}" <#if folder.folderId==fileInfo.folderId>selected</#if>>
			                        	${folder.pathName}
			                        	</option>
			                        </#list>
	                            </select>			
                          </div>
                        </div> 
                        <div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">中文名称</label>
                          <div class="col-sm-10">
                              <input type="text" style="font-size:15px;" class="form-control" name="name"
                              	placeholder="中文名称" id="name" value="${fileInfo.name}">
                              </input>
                          </div>
                        </div>
                        <div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">英文名称</label>
                          <div class="col-sm-10">
                              <input type="text" style="font-size:15px;" class="form-control" name="ename"
                              	placeholder="英文名称" id="ename" value="${fileInfo.ename}">
                              </input>
                          </div>
                        </div> 
                        
                        <!--暂时隐藏掉，文件编辑器和源码内容移到fileInfo/list.htm
                        <div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">布局编辑器</label>
                          <div class="col-sm-10">
                              <a class="fancybox fancybox.iframe" href="${BASE_PATH}/manage/pageditor/editer.htm?type=modal&fileId=${fileInfo.fileId}">打开文件编辑器</a>
                          </div>
                        </div>     
                        
                        <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">源码内容</label>
                              <div class="col-sm-10">
                                  <input type="hidden" name="sourceCode" id="sourceCodeHidden"/>
                                  <textarea id="source_code_html_hidden" style="display:none">${fileInfo.sourceCode!}</textarea>
                          		  <textarea rows="10" cols="40" id="source_code_html" style="position: absolute; left: -10000px; width: 10px;"></textarea>
                              </div>
                        </div>
                        <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">编辑区内容</label>
                              <div class="col-sm-10">
                                  <input type="hidden" name="htmlCodeByEdit" id="htmlCodeHidden"/>
                                  <textarea id="code_html_hidden" style="display:none">${fileInfo.htmlCodeByEdit!}</textarea>
                          		  <textarea rows="10" cols="40" id="code_html" style="position: absolute; left: -10000px; width: 10px;"></textarea>
                              </div>
                        </div>-->
                                                             
                        <div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">文件状态</label>
                          <div class="col-sm-10" style="margin-bottom:10px;">
                          	<input name="status" value="display" type="radio" <#if fileInfo.status=="display" || fileInfo.status=="init">checked</#if>> 显示
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="status" value="hidden" type="radio" <#if fileInfo.status=="hidden">checked</#if>> 隐藏
                          </div>
                        </div>                       
                        <div class="form-group">
                      	  <div class="col-lg-offset-2 col-lg-10">
                          <button class="btn btn-shadow btn-primary" type="submit">修改</button>
                          <button class="btn btn-shadow btn-primary" type="button" onclick="javascript:history.back(-1);">返回</button>
                          </div>
                      </div>
					</div>
				</section>
	
			<section class="panel" style="float:left;width:50%">
					<header class="panel-heading"> ${fileInfo.name}的资源文件列表 </header>
					<div class="panel-body">
						<table class="table">
							<thead>
								<tr>
									<th>顺序</th>
									<th>文件名</th>
									<th>所属目录</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<#list mediaFileList as mediaFile>
										<tr>
											<td class="mediaFileSort"><input type="text"
												mediaId="${mediaFile.media.mediaId!}" value="${mediaFile.sort!}" name="sort"
												class="js_mediaFile_sort" style="width: 40px;"></td>
											<td>${mediaFile.media.name!}</td>
											<td>${mediaFile.media.pathName!}</td>
											<td>
												<a href="javascript:void(0);" title="移除" class="btn btn-danger btn-xs js_media_remove" mediaId="${mediaFile.media.mediaId!}">移除</a> 
											</td>
										</tr>
	                        	</#list>					
							</tbody>
						</table>
					</div>
					<div>
						<button class="btn btn-info js_update_sort" type="button">
							<i class="icon-refresh"></i> 更新排序
						</button>
					</div>
				</section>
			
			
				<section class="panel" style="float:right;width:50%">
					<header class="panel-heading"> 该站点下的资源文件列表 </header>
					<div class="panel-body">
						<table class="table">
							<thead>
								<tr>
									<th>文件名</th>
									<th>所属目录</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<#list mediaAll as media>
		                   			<#if media.owner == "no">
										<tr>
											<td>${media.name!}</td>
											<td>${media.pathName!}</td>
											<td>
												<a href="javascript:void(0);" title="引入" class="btn btn-danger btn-xs js_media_move" mediaId="${media.mediaId!}">引入</a> 
											</td>
										</tr>
		                   			</#if>
	                        	</#list>					
							</tbody>
						</table>
						
						<div id="attachment"></div>
						<div id="sortDiv" style="float:right;"></div>
					</div>
				</section>	
				
			</div>
		</div>
		</fieldset>
		</form>
		<!-- page end-->
	</section>
</section>
<!--main content end-->
<script type="text/javascript">
var fileId = ${fileInfo.fileId};
$(function(){
	 $('.js_update_sort').click(function() {
        var mediaFileSort = new Array();
        $('.js_mediaFile_sort').each(function(i, element) {
            var mediaFile = {};
            mediaFile.mediaId = $(element).attr('mediaId');
            mediaFile.fileId = fileId;
            mediaFile.sort = $(element).val();
            mediaFileSort.push(mediaFile);
        });
        $.post("${BASE_PATH}/manage/fileinfoMedia/sort.json", {
            "sortJson": $.toJSON(mediaFileSort)
        },
        function(data) {
            if (data.result) {
                bootbox.alert("更新成功",
                function() {
                    window.location.reload();
                });
            } else {
                bootbox.alert(data.msg,
                function() {
          		});
            }
        },
        "json");
    });
	/*$(".fancybox").fancybox({
		'width':$("body").width()*0.9,
		'height':$("body").height()*0.9
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
      editorHTML.setSize(795,300);
      editorHTML.setValue($("#code_html_hidden").val());
      var sourceEditorHTML = CodeMirror.fromTextArea(document.getElementById("source_code_html"), {
        mode: mixedModeHTML,
        selectionPointer: true,
		theme:"night",
		lineNumbers: true
      });
      sourceEditorHTML.setSize(795,300);
      sourceEditorHTML.setValue($("#source_code_html_hidden").val());
      */
	$('#update_fileInfo_form').ajaxForm({
			dataType : 'json',
			/*beforeSerialize : function(formObj,optionObj){
				var htmlCode = editorHTML.getValue();
				$('#htmlCodeHidden').val(htmlCode);
				var sourceCode = sourceEditorHTML.getValue();
				$('#sourceCodeHidden').val(sourceCode);
				return true;
			},*/
			success : function(data) {
				if (data.result) {
					bootbox.alert("保存成功，将刷新页面", function() {
						window.location.reload();
						
					});
				}else{
					showErrors($('#add_fileInfo_form'),data.errors);
				}
			}
		});
    //引入
    $('.js_media_move').click(function() {
        var mediaId = $(this).attr('mediaId');
        bootbox.dialog({
            message: "是否" + $(this).attr('title') + "资源文件",
            title: "提示",
            buttons: {
                "delete": {
                    label: $(this).attr('title'),
                    className: "btn-success",
                    callback: function() {
                        $.post("${BASE_PATH}/manage/fileinfoMedia/add.json", {
                            "fileId": fileId,
                            "mediaId": mediaId
                        },
                        function(data) {
                            if (data.result) {
                                window.location.reload();
                            } else {
                                bootbox.alert(data.msg,
                                function() {});
                            }
                        },
                        "json");
                    }
                },
                "cancel": {
                    label: "取消",
                    className: "btn-primary",
                    callback: function() {}
                }
            }
        });
    });
    //移除
    $('.js_media_remove').click(function() {
        var mediaId = $(this).attr('mediaId');
        bootbox.dialog({
            message: "是否" + $(this).attr('title') + "资源文件",
            title: "提示",
            buttons: {
                "delete": {
                    label: $(this).attr('title'),
                    className: "btn-success",
                    callback: function() {
                        $.post("${BASE_PATH}/manage/fileinfoMedia/delete.json", {
                            "fileId": fileId,
                            "mediaId": mediaId
                        },
                        function(data) {
                            if (data.result) {
                                window.location.reload();
                            } else {
                                bootbox.alert(data.msg,
                                function() {});
                            }
                        },
                        "json");
                    }
                },
                "cancel": {
                    label: "取消",
                    className: "btn-primary",
                    callback: function() {}
                }
            }
        });
    });
    var entityId = '${fileInfo.fileId}';
    
});
</script>
<#include "/manage/foot.ftl">
