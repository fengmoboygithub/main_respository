<#assign menu="site">
<#assign submenu="site_list">
<#include "/manage/head.ftl">
<style type="text/css">
.pagination {
    border-radius: 4px;
    display: inline-block;
    margin: 0;
    padding-left: 0;
}

.howto, .nonessential, #edit-slug-box, .form-input-tip, .subsubsub {
    color: #666666;
}

.subsubsub {
    float: left;
    font-size: 12px;
    list-style: none outside none;
    margin: 8px 0 5px;
    padding: 0;
}

.form-group{
	width:100%;
}

.count{
	position:absolute ;
	right:0px;
}

.arrticle_status{
	float:left;
}
</style>
	<!--main content start-->
	<section id="main-content">
		<section class="wrapper">
        	<!-- page start-->
            <section class="panel">
	        	<header class="panel-heading">
		                <div class="row">
						   <div class="col-lg-12">
								<a class="btn btn-primary" style="float:right;" href="${BASE_PATH}/manage/site/add.htm">增加站点</a>
						   </div>
						</div>
				</header>
                <div class="panel-body">
                	<div class="adv-table">
                    	<div role="grid" class="dataTables_wrapper" id="hidden-table-info_wrapper">
                            <table class="table table-striped table-advance table-hover">
                            	<thead>
                                	<tr>
										<th>站点中文名称</th>
										<th>站点英文名称</th>
										<th>站点地址</th>
                						<th>最后更新时间</th>
                						<th>操作</th>
              						</tr>
                                </thead>
                            	<tbody role="alert" aria-live="polite" aria-relevant="all">
                            		<#list pageVo.list as e>
                            		<tr class="gradeA odd">
               							<td>
               								<a href="${BASE_PATH}/manage/site/update.htm?siteId=${e.siteId}">${e.siteName}</a>
               							</td>
               							<td>
               								<a href="${BASE_PATH}/manage/site/update.htm?siteId=${e.siteId}">${e.siteEname}</a>
               							</td>
               							<td>
               								${e.siteAddress}
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
                  							<a href="${BASE_PATH}/manage/site/update.htm?siteId=${e.siteId}" title="修改">
                  								编辑
                  							</a>
                  							<!-- 隐藏掉删除 -->
                  							<!-- | -->
                  							<a href="javascript:void(0);" style="display: none;" class="js_site_delete" siteId="${e.siteId}" title="是否删除站点">
                  								删除
                  							</a>
                  							| 
                  							<a href="${BASE_PATH}/manage/folder/list.htm?folderId=0&siteId=${e.siteId}">
                  								站点结构
                  							</a>
                  							| 
                  							<a href="javascript:void(0);" class="js_site_export" siteId="${e.siteId}" title="是否导出站点">
                  								导出
                  							</a>
                						</td>
                                	</tr>
                                	</#list>
                               	</tbody>
                              </table>
                              <div style="height: 30px;">
                             	<div class="pagination">${pageVo.pageNumHtml} </div>
                              </div>
                           </div>
                        </div>
                  </div>
              </section>
              <!-- page end-->
          </section>
		</section>
		<!--main content end-->
<script>
$(function(){
var pageNum = "${p}";
	$('.js_site_export').click(function(){
		var siteId = $(this).attr('siteId');
		bootbox.dialog({
			message : $(this).attr('title'),
			title : "提示",
			buttons : {
				"delete" : {
					label : "确定",
					className : "btn-success",
					callback : function() {
						$.post("${BASE_PATH}/manage/site/export.json", { "siteId": siteId},function(data){
								if(data.result){
									bootbox.alert(data.msg,
					                function() {
					                });
								}else{
									bootbox.alert(data.msg,
					                function() {
					                });
								}
						}, "json");
					}
				},
				"cancel" : {
					label : "取消",
					className : "btn-primary",
					callback : function() {
						
					}
				}
			}
		});					
	});	
	$('.js_site_delete').click(function(){
		var siteId = $(this).attr('siteId');
		var status= "trash";
		bootbox.dialog({
			message : $(this).attr('title'),
			title : "提示",
			buttons : {
				"delete" : {
					label : "确定",
					className : "btn-success",
					callback : function() {
						$.post("${BASE_PATH}/manage/site/delete.json", { "siteId": siteId},function(data){
								window.location.reload();
						}, "json");
					}
				},
				"cancel" : {
					label : "取消",
					className : "btn-primary",
					callback : function() {
						
					}
				}
			}
		});					
	});	
});
</script>
<#include "/manage/foot.ftl">
