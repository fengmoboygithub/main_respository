<#assign menu="site">
<#assign submenu="add_site">
<#include "/manage/head.ftl">
<!--main content start-->
<section id="main-content">
	<section class="wrapper">
		<!-- page start-->
		<form id="add_site_form" class="form-horizontal" action="${BASE_PATH}/manage/site/add.json"  autocomplete="off"  method="post"
			enctype="multipart/form-data">
		<div class="row">
			<input type="hidden" name="adminId" value="${adminId}">
			<div class="col-lg-12">
				<section class="panel">
					<header class="panel-heading"> 
						增加站点
					</header>
					<div class="panel-body">
						<div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">站点中文名称</label>
                          <div class="col-sm-10">
                              <input type="text" style="font-size:15px;width: 300px;" class="form-control" name="siteName"
                              	placeholder="站点中文名称" id="siteName" >
                              </input>
                          </div>
                        </div>
                        <div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">站点英文名称</label>
                          <div class="col-sm-10">
                              <input style="font-size:15px;width: 300px;" onkeyup="value=value.replace(/[\W]/g,'') " onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" 
	                                       class="form-control" name="siteEname" placeholder="站点英文名称" ></input>
	                                       <p class="help-block">注意:英文名称只能是数字或者英文字母或者是下划线组成</p>
                          </div>
                        </div>
                        <div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">站点地址</label>
                          <div class="col-sm-10">
                              <input type="text" style="font-size:15px;" class="form-control" name="siteAddress"
                              	placeholder="站点地址" id="siteAddress" >
                              </input>
                          </div>
                        </div>
                        <div class="form-group">
                      	  <div class="col-lg-offset-2 col-lg-10">
                          <button class="btn btn-shadow btn-primary" type="submit">新建</button>
                          <button class="btn btn-shadow btn-primary" type="button" onclick="javascript:history.back(-1);">返回</button>
                          </div>
                   
                      </div>
					</div>
				</section>
			</div>
		</div>
		</form>
		<!-- page end-->
	</section>
</section>
<!--main content end-->
<script type="text/javascript">
$(function(){
	$('#add_site_form').ajaxForm({
		dataType : 'json',
		success : function(data) {
			if (data.result) {
				bootbox.alert("保存成功，将刷新页面", function() {
					window.location.reload();
				});
			}else{
				showErrors($('#add_site_form'),data.errors);
			}
		}
	});
});
</script>
<#include "/manage/foot.ftl">