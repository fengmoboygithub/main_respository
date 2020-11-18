<#assign menu="site">
<#assign submenu="site_admin">
<#include "/manage/head.ftl">
<style type="text/css">
.pagination {
	border-radius: 4px;
	display: inline-block;
	margin: 0;
	padding-left: 0;
}
</style>
<!--main content start-->
<section id="main-content">
	<section class="wrapper">
		<!-- page start-->
		<div class="row">
			<div class="col-lg-12">
				<!--breadcrumbs start -->
				<ul class="breadcrumb">
					<li><a href="#"><i class="icon-home"></i>分享站点</a></li> 
					<button class="btn btn-info" style="float:right" type="button" onclick="javascript:history.back(-1);">返回</button>
				</ul>
				<!--breadcrumbs end -->
			</div>
		</div>
		
		<div class="row">
			<div class="col-lg-6">
				<section class="panel">
					<header class="panel-heading"> 添加用户 </header>
					<div class="panel-body">
						 <form id="add_adminSite_form" method="post" class="form-horizontal" autocomplete="off" action="${BASE_PATH}/manage/adminSite/addSite.json">
							<fieldset>
								<input type="hidden" name="siteId" value="${site.siteId}">
								<div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">站点</label>
                                      <div class="col-sm-10">
                                        <p style="margin-top:15px;"> ${site.siteName}</p>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">用户</label>
                                      <div class="col-sm-10">
                                          <!--
                                          <select class="form-control" name="adminId" style="font-size:15px;width: 200px;">
					                   		<#list adminAll as admin>
					                   			<#if admin.owner == "no">
					                   			<option value="${admin.adminId}"> ${admin.name} </option>
																	                   			
					                   			</#if>
					                        </#list>							
			                            </select> -->
			                            <table class="table table-striped table-advance table-hover" style="width: 100%">
			                            	<#list adminAll as admin>
					                   			<#if admin.owner == "no">
					                   			<tr>  
					                   				<td> ${admin.name}</td>
					                   				<td>
                                					<!-- Icons -->
                              			 			<a href="javascript:void(0);" title="分享给${admin.name}" class="js_site_share" adminId="${admin.adminId}">分享</a>
                            						</td>
					                   			</tr>
					                   			</#if>
					                    	</#list>		
			                            </table>
                                      </div>
                                  </div>
                                  <!-- <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label"></label>
                                      <button class="btn btn-danger" type="submit">增加</button>
                                      <button class="btn btn-danger" type="button" onclick="javascript:history.back(-1);">返回</button>
                                  </div>		 -->
							</fieldset>
						</form>
					</div>
				</section>
			</div>
			<div class="col-lg-6">
				<section class="panel">
					<header class="panel-heading"> 分享用户列表 </header>
					<div class="panel-body">
						<div class="adv-table">
							<div role="grid" class="dataTables_wrapper"
								id="hidden-table-info_wrapper">
								<table class="table table-striped table-advance table-hover">
                              <thead>
                                  <tr>
                            <th>用户</th>
                          </tr>
                                </thead>
                              <tbody role="alert" aria-live="polite" aria-relevant="all">
                                  <#list adminAll as admin>
					                 <tr class="gradeA odd" <#if admin.owner == "no">style="display:none;"</#if>>
                                      <td>${admin.name}</td>
                                      <td>
                                		<!-- Icons -->
                              			 <a href="javascript:void(0);" title="删除${admin.name}" class="js_site_delete" adminId="${admin.adminId}">删除</a>
                            			</td>
                                  	</tr>
                                  </#list>
                                </tbody>
                              </table>
                              <div style="height: 30px;">
                              </div>
                           </div>
						</div>
					</div>
				</section>
			</div>
			<!-- page end-->
	</section>
</section>
<!--main content end-->
<script type="text/javascript">
var siteId = "${site.siteId}";
$(function() {
	$('#add_adminSite_form').ajaxForm({
			dataType : 'json',
			success : function(data) {
				if (data.result) {
					window.location.reload();
				}else{
					bootbox.alert(data.msg, function() {
						window.location.reload();
					});
				}
			}
		});
	
	//分享
	$(".js_site_share").click(function(){
		var adminId = $(this).attr('adminId');
		bootbox.dialog({
            message: "是否将站点" + $(this).attr('title'),
            title: "提示",
            buttons: {
                "delete": {
                    label: "分享",
                    className: "btn-success",
                    callback: function() {
                        $.post("${BASE_PATH}/manage/adminSite/addSite.json", {
                            "siteId": siteId,
                            "adminId": adminId
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
	
	$('.js_site_delete').click(function() {
        var adminId = $(this).attr('adminId');
        bootbox.dialog({
            message: "是否" + $(this).attr('title') + "站点",
            title: "提示",
            buttons: {
                "delete": {
                    label: "删除",
                    className: "btn-success",
                    callback: function() {
                        $.post("${BASE_PATH}/manage/adminSite/delete.json", {
                            "siteId": siteId,
                            "adminId": adminId
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
});
</script>
<#include "/manage/foot.ftl">