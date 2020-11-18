<#assign menu="admin">
<#assign submenu="admin_site">
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
					<li><a href="#"><i
							class="icon-home"></i>用户站点</a></li> 				</ul>
				<!--breadcrumbs end -->
			</div>
		</div>
		
		<div class="row">
			<div class="col-lg-4">
				<section class="panel">
					<header class="panel-heading"> 添加站点 </header>
					<div class="panel-body">
						 <form id="add_adminSite_form" method="post" class="form-horizontal" autocomplete="off" action="${BASE_PATH}/manage/adminSite/addSite.json">
							<fieldset>
								<input type="hidden" name="adminId" value="${admin.adminId}">
								<div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">名称</label>
                                      <div class="col-sm-10">
                                        <p style="margin-top:15px;"> ${admin.name}</p>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">站点</label>
                                      <div class="col-sm-10">
                                          <select class="form-control" name="siteId" style="font-size:15px;width: 200px;">
					                   		<#list siteAll as site>
					                   			<#if site.owner == "no">
					                   			<option value="${site.siteId}"> ${site.siteName} </option>
					                   			</#if>
					                        </#list>							
			                            </select>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label"></label>
                                      <button class="btn btn-danger" type="submit">增加</button>
                                      <!-- <button class="btn btn-shadow btn-primary" type="button" onclick="javascript:history.back(-1);">返回</button> -->
                                      <button class="btn btn-danger" type="button" onclick="javascript:history.back(-1);">返回</button>
                                  </div>		
							</fieldset>
						</form>
					</div>
				</section>
			</div>
			<div class="col-lg-8">
				<section class="panel">
					<header class="panel-heading"> 用户站点列表 </header>
					<div class="panel-body">
						<div class="adv-table">
							<div role="grid" class="dataTables_wrapper"
								id="hidden-table-info_wrapper">
								<table class="table table-striped table-advance table-hover">
                              <thead>
                                  <tr>
                            <th>站点</th>
                          </tr>
                                </thead>
                              <tbody role="alert" aria-live="polite" aria-relevant="all">
                                  <#list siteAll as site>
					                 <tr class="gradeA odd" <#if site.owner == "no">style="display:none;"</#if>>
                                      <td>${site.siteName}</td>
                                      <td>
                                		<!-- Icons -->
                              			 <a href="javascript:void(0);" title="删除${site.siteName}" class="js_site_delete" siteId="${site.siteId}">
                                                                                                   		   删除
                                		</a>
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
var adminId = "${admin.adminId}";
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
	$('.js_site_delete').click(function() {
        var siteId = $(this).attr('siteId');
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