<#assign menu="site"> 
<#assign submenu="update_folder"> 
<#include "/manage/head.ftl">
<style type="text/css">
</style>
<!--main content start-->
<section id="main-content">
	<section class="wrapper">
		<!-- page start-->
		<div class="row">
			<form id="update_folder_form" method="post"
				class="form-horizontal" autocomplete="off"
				action="${BASE_PATH}/manage/folder/update.json">
				<input type="hidden" name="siteId" value="${folder.siteId}">
				<div class="col-lg-12">
					<input type="hidden" class="form-control" name="folderId"
						value="${folder.folderId}">						
					<section class="panel">
						<header class="panel-heading"> 
						修改目录
						</header>
						<div class="panel-body">
                        	<div class="form-group">
	                          <label class="col-sm-2 col-sm-2 control-label">目录中文名</label>
	                          <div class="col-sm-10">
	                              <input type="text" style="font-size:15px;width: 300px;" class="form-control" name="name"
	                              	placeholder="目录中文名" id="name" value="${folder.name}">
	                              </input>
	                          </div>
	                        </div>
                        	<div class="form-group">
	                          <label class="col-sm-2 col-sm-2 control-label">目录英文名</label>
	                          <div class="col-sm-10">
	                              <input type="text" style="font-size:15px;width: 300px;" class="form-control" name="ename"
	                              	placeholder="目录英文名" id="ename" value="${folder.ename}">
	                              </input>
	                          </div>
	                        </div>
	                          <div class="form-group">
	                              <label class="col-sm-2 col-sm-2 control-label">目录状态</label>
	                              <div class="col-sm-10">
	                              	<label class="radio-inline">
	                            		<input type="radio" name="status" value="display" <#if folder.status=="display">checked</#if>/> 显示
	                          		</label>
	                          		<label class="radio-inline">
	                            		<input type="radio" name="status" value="hidden" <#if folder.status=="hidden">checked</#if>/> 隐藏
	                          		</label>
	                              </div>
	                          </div>	                        
	                        <div class="form-group">
	                      	  <div class="col-lg-offset-2 col-lg-10">
	                         	<button class="btn btn-shadow btn-primary" type="submit">更新目录</button>
	                         	<button class="btn btn-shadow btn-primary" type="button" onclick="javascript:history.back(-1);">返回</button>
	                          </div>
	                      </div>
						</div>
					</section>
					<section class="panel" style="float:left;width:50%">
						<header class="panel-heading"> 所有资源文件列表(排除该目录) </header>
						<div class="panel-body">
							<div id="attachmentAll"></div>
						</div>
					</section>
					<section class="panel" style="float:right;width:50%">
						<header class="panel-heading"> ${folder.name}的资源文件列表 </header>
						<div class="panel-body">
							<div id="attachment"></div>
							<div id="sortDiv" style="float:right;"></div>
							<button id="file_upload" uploadAttr="file_upload"  class="btn btn-shadow btn-info" type="button"><i class="icon-cloud-upload"></i> 添加附件</button>
						</div>
					</section>		
				</div>
			</form>
		</div>

		<!-- page end-->
	</section>
</section>
<!--main content end-->
<!--上传文件（Modal） -->
<div id="fileModalDiv">
	<div class="modal fade" id="fileModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel1" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel1">上传文件</h4>
				</div>
				<div class="modal-body">
					<div id="post-container" class="container">
						<div class="page-container">
							<p>您可以尝试文件拖拽，或者点击添加按钮，上传附件.</p>
							<div id="uploader" class="wu-example">
								<div class="queueList">
									<div id="dndArea" class="placeholder">
										<div id="filePicker"></div>
										<p>请上传附件</p>
									</div>
								</div>
								<div class="statusBar" style="display: none;">
									<div class="progress">
										<span class="text">0%</span> <span class="percentage"></span>
									</div>
									<div class="info"></div>
									<div class="btns">
										<div id="filePicker2"></div>
										<div class="uploadBtn">开始上传</div>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
		<input name="itemName" id="itemName" type="hidden" />
   </div>  
</div>
<!-- 上传文件 end -->
<script type="text/javascript">
var entityId = "${folder.folderId}";
var entity = "folder";
var _BasePath = "${BASE_PATH!}";
$.extend({
	//得到该目录下资源文件列表
	getAttachment:function(){
		$.getJSON("${BASE_PATH}/manage/attachment/list.json?entityId="+entityId+"&entity="+entity+"&v="+Math.random(),function(data){
			$('#attachment').html("");
			$('#sortDiv').html("");
			$.addAttachment(data.attachmentList);
		});
	},
	addAttachment:function(list){
		//var html = '<table class="table"><thead><tr><th>顺序</th><th>文件名</th><th>大小</th><th>操作</th></tr></thead><tbody>';
		var html = '<div><table class="table"><thead><tr><th>顺序</th><th>文件名</th><th>操作</th></tr></thead><tbody>';
		for(i=0;i<list.length;i++){
			var attachment = list[i];
			html += '<tr>';
			html += '<td class="mediaFolderSort"><input type="text" relaId="'+attachment.relaId+'" value="'+attachment.sort+'" name="sort" class="js_mediaFolder_sort" style="width: 40px;"></td>';
			html += '<td>'+attachment.media.name+'</td>';
			//html += '<td>'+attachment.media.size+'</td>';
			html += '<td><a href="javascript:void(0);" title="移除" name="'+attachment.media.name+'" class="btn btn-danger btn-xs js_move" relaId="'+attachment.relaId+'">移除</a> ';
			html += '</td></tr>';
		}
		html += '</tbody></table></div>';
		$('#attachment').prepend(html);
		var sortHtml = '<button class="btn btn-info js_update_sort" type="button"><i class="icon-refresh"></i> 更新排序</button>';
		$('#sortDiv').html(sortHtml);
		//更新排序
		$('.js_update_sort').click(function() {
	        var mediaFolderSort = new Array();
	        $('.js_mediaFolder_sort').each(function(i, element) {
	            var mediaFolder = {};
	            mediaFolder.relaId = $(element).attr('relaId');
	            mediaFolder.sort = $(element).val();
	            mediaFolderSort.push(mediaFolder);
	        });
	        $.post("${BASE_PATH}/manage/mediaEntity/sort.json", {
	            "sortJson": $.toJSON(mediaFolderSort)
	        },
	        function(data) {
	            if (data.result) {
	                bootbox.alert("更新成功",
	                function() {
	                    $.getAttachment();
	                });
	            } else {
	                bootbox.alert(data.msg,
	                function() {
	          		});
	            }
	        },
	        "json");
	    });
		//移除目录与资源文件关系
		$('#attachment .js_move').click(function(){
			var file = $(this);
			bootbox.confirm("是否要"+file.attr("title")+"【"+file.attr("name")+"】文件？", function(result) {
				if (result) {
					$.post("${BASE_PATH}/manage/mediaEntity/delete.json",{'relaId':file.attr("relaId")},function(data){
						if(data.result){
							$.getAttachment();
							$.getAttachmentAll();
						}
					},"json");
				}
			});		
		});
	},
	//得到所有资源文件列表(排除该目录)
	getAttachmentAll:function(){
		$.getJSON("${BASE_PATH}/manage/attachment/listAll.json?entityId="+entityId+"&v="+Math.random(),function(data){
			$('#attachmentAll').html("");
			$.addAttachmentAll(data.attachmentList);
		});
	},
	addAttachmentAll:function(list){
		//var html = '<table class="table"><thead><tr><th>文件名</th><th>大小</th><th>操作</th></tr></thead><tbody>';
		var html = '<div><table class="table"><thead><tr><th>文件名</th><th>操作</th></tr></thead><tbody>';
		for(i=0;i<list.length;i++){
			var attachment = list[i];
			html += '<tr>';
			html += '<td>'+attachment.name+'</td>';
			//html += '<td>'+attachment.size+'</td>';
			html += '<td><a href="javascript:void(0);" title="删除" name="'+attachment.name+'" class="btn btn-danger btn-xs js_media_delete" mediaId="'+attachment.mediaId+'">删除</a>';
			html += ' | <a href="javascript:void(0);" title="引入" name="'+attachment.name+'" class="btn btn-danger btn-xs js_media_move" mediaId="'+attachment.mediaId+'">引入</a> ';
			html += '</td></tr>';
		}
		html += '</tbody></table></div>';
		$('#attachmentAll').prepend(html);
		//引入目录与资源文件关系
		$('#attachmentAll .js_media_move').click(function(){
			var file = $(this);
			bootbox.confirm("是否要"+file.attr("title")+"【"+file.attr("name")+"】文件？", function(result) {
				if (result) {
					$.post("${BASE_PATH}/manage/mediaEntity/add.json",{'mediaId':file.attr("mediaId"),'entityId':entityId,'entity':entity},function(data){
						if(data.result){
							$.getAttachment();
							$.getAttachmentAll();
						} else {
			                bootbox.alert(data.msg,
			                function() {
			          		});
			            }
					},"json");
				}
			});		
		});
		//删除资源文件
		$('#attachmentAll .js_media_delete').click(function(){
			var file = $(this);
			bootbox.confirm("是否要"+file.attr("title")+"【"+file.attr("name")+"】文件？", function(result) {
				if (result) {
					$.post("${BASE_PATH}/manage/attachment/delete.json",{'mediaId':file.attr("mediaId")},function(data){
						if(data.result){
							$.getAttachment();
							$.getAttachmentAll();
						}
					},"json");
				}
			});		
		});
	}
});
	$(function() {
		$('#update_folder_form').ajaxForm({
			dataType : 'json',
			success : function(data) {
				if (data.result) {
					bootbox.alert("保存成功，将刷新页面", function() {
						window.location.reload();
					});
				}else{
					showErrors($('#update_folder_form'),data.errors);
				}
			}
		});
		//得到该目录下资源文件列表
		$.getAttachment();
		//得到所有资源文件列表(排除该目录)
		$.getAttachmentAll();
	});	
</script>
<!--webuploader  -->
<script src="${BASE_PATH}/static/manage/vendor/webuploader/js/webuploader.js"></script>
<script src="${BASE_PATH}/static/manage/vendor/webuploader/js/Upload.js"></script>
<#include "/manage/foot.ftl">
