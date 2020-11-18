<#assign menu="site">
	<#assign submenu="fileInfo_list">
		<#include "/manage/head.ftl">
			<style type="text/css">
				.pagination {
					border-radius: 4px;
					display: inline-block;
					margin: 0;
					padding-left: 0;
				}
				
				.howto,
				.nonessential,
				#edit-slug-box,
				.form-input-tip,
				.subsubsub {
					color: #666666;
				}
				
				.subsubsub {
					float: left;
					font-size: 12px;
					list-style: none outside none;
					margin: 8px 0 5px;
					padding: 0;
				}
				
				.form-group {
					width: 100%;
				}
				
				.count {
					position: absolute;
					right: 0px;
				}
				
				.arrticle_status {
					float: left;
				}
			</style>
			<!--main content start-->
			
				<section id="main-content">
					<!--1-->
					<section class="wrapper">
						<!-- page start-->
						<!--头部section-->
						<section class="panel">
							<header class="panel-heading">
								<div class="row">
									<div class="col-lg-4">
										<ul class="breadcrumb" style="margin-bottom:0px;">
											<#list pathList as pathFolder>
												<li>
													<a href="${BASE_PATH}/manage/fileInfo/list.htm?folderId=${pathFolder.folderId!}&siteId=${site.siteId!}">${pathFolder.name!}</a>
												</li>
											</#list>
										</ul>
									</div>
									<div class="col-lg-8">
										<a class="btn btn-primary" style="float:right; margin-left: 5px" type="button" onclick="javascript:history.back(-1);">返回</a>
										<a class="btn btn-primary" style="float:right;" href="${BASE_PATH}/manage/fileInfo/add.htm?folderId=${folderId}&siteId=${site.siteId!}">增加文件</a>
									</div>
								</div>
							</header>
							<div class="panel-body">

								<div class="adv-table">
									<div role="grid" class="dataTables_wrapper" id="hidden-table-info_wrapper">
										<table class="table table-striped table-advance table-hover">
											<thead>
												<tr>
													<th>文件名称</th>
													<th>状态</th>
													<th>所属目录</th>
													<th>最后更新时间</th>
													<th>操作</th>
												</tr>
											</thead>
											<tbody role="alert" aria-live="polite" aria-relevant="all">
												<#list pageVo.list as e>
												<tr class="gradeA odd">
													<td>
														<a href="${BASE_PATH}/manage/fileInfo/update.htm?fileId=${e.fileId!}&siteId=${site.siteId!}">${e.name!}</a>
													</td>
													<td>
														<#if e.status=="display">
															显示
															<#else>
																<span style="color:red;">隐藏</span>
														</#if>
													</td>
													<td>
														<a href="${BASE_PATH}/manage/fileInfo/list.htm?folderId=${e.folder.folderId!}&siteId=${site.siteId!}&status=${e.status!}">
															${e.folder.name!}
														</a>
													</td>
													<td>
														<#if (e.updateTime)??>
			                                    			${e.updateTime?string("yyyy-MM-dd")}
			                                    		<#else>
			                                    			<#if (e.createTime)??>
				                                    			${e.createTime?string("yyyy-MM-dd")}
			                                    			</#if>
			                                    		</#if>
													</td>
													<td>
														<!-- Icons -->
														<a href="${BASE_PATH}/manage/fileInfo/update.htm?fileId=${e.fileId!}&siteId=${site.siteId!}" title="编辑">
															编辑
														</a>
														|
														<a href="javascript:void(0);" class="js_fileInfo_delete" fileId="${e.fileId!}" title="是否删除文件">
															删除
														</a>
														|
														<a href="${BASE_PATH}/manage/codeEditer/view.htm?type=page&id=${e.fileId!}" target="_blank" title="代码测试器">
															代码测试器
														</a>
                  										 | 
                  										<a href="${BASE_PATH}/manage/pageditor/editer.htm?type=page&fileId=${e.fileId!}" target="_blank" title="布局编辑器">
                  											布局编辑器
                  										</a>
													</td>
												</tr>
												</#list>
											</tbody>
										</table>
										<div style="height: 30px;">
											<div class="pagination">${pageVo.pageNumHtml!} </div>
										</div>
									</div>
								</div>
							</div>
						</section>
						<!--头部section结束-->
					</section>
					<!-- page end-->
				</section>
			<!--main content end-->
			<script>
				$(function() {
					var pageNum = "${p}";
					var folderId = "${folderId}";
					var siteId = "${site.siteId}";
					$('.js_fileInfo_delete').click(function() {
						var fileId = $(this).attr('fileId');
						var status = "trash";
						bootbox.dialog({
							message: $(this).attr('title'),
							title: "提示",
							buttons: {
								"delete": {
									label: "确定",
									className: "btn-success",
									callback: function() {
										$.post("${BASE_PATH}/manage/fileInfo/delete.json", {
											"fileId": fileId
										}, function(data) {
											window.location.reload();
										}, "json");
									}
								},
								"cancel": {
									label: "取消",
									className: "btn-primary",
									callback: function() {
									}
								}
							}
						});
					});
				});
			</script>
			<#include "/manage/foot.ftl">