<<<<<<< .mine
<#assign menu="config">
<#assign submenu="update_config">
<#include "/manage/head.ftl">
<!--main content start-->
<style type="text/css">

</style>
<section id="main-content">
	<section class="wrapper">
		<!-- page start-->
		<form id="update_config_form" class="form-horizontal" action="${BASE_PATH}/manage/config/update.json"  autocomplete="off"  method="post"
			>
			<fieldset>
		<div class="row">
		
		<input type="hidden" name="key" value="${config.key}">
			<div class="col-lg-12">
				<section class="panel">
					<header class="panel-heading"> 
						修改配置
					</header>
					<div class="panel-body">
						
                        
						<div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">配置内容</label>
                          <div class="col-sm-10">
                              <input type="text" style="font-size:15px;" class="form-control" name="value"
                              	placeholder="配置内容" id="value" value="${config.value}">
                              </input>
                          </div>
                        </div> 
                        
                        
                        <div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">配置描述</label>
                          <div class="col-sm-10">
                              <input type="text" style="font-size:15px;width: 300px;" class="form-control" name="description"
                              	placeholder="配置描述" id="description" value="${config.description}">
                              </input>
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
			</div>
		</div>
		</fieldset>
		</form>
		<!-- page end-->
	</section>
</section>
<!--main content end-->
<script type="text/javascript">
$(function(){
	$('#update_config_form').ajaxForm({
			dataType : 'json',
			success : function(data) {
				if (data.result) {
					bootbox.alert("保存成功，将刷新页面", function() {
						window.location.reload();
						
					});
				}else{
					showErrors($('#update_config_form'),data.errors);
				}
			}
		});
});
</script>
<#include "/manage/foot.ftl">
=======
<#assign menu="config">
<#assign submenu="update_config">
<#include "/manage/head.ftl">
<!--main content start-->
<style type="text/css">

</style>
<section id="main-content">
	<section class="wrapper">
		<!-- page start-->
		<form id="update_config_form" class="form-horizontal" action="${BASE_PATH}/manage/config/update.json"  autocomplete="off"  method="post"
			>
			<fieldset>
		<div class="row">
			<input type="hidden" name="key" value="${config.key}">
			<div class="col-lg-12">
				<section class="panel">
					<header class="panel-heading"> 
						修改组件
					</header>
					<div class="panel-body">
					
						<div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">配置内容</label>
                          <div class="col-sm-10">
                              <input type="text" style="font-size:15px;width: 300px;" class="form-control" name="value"
                              	placeholder="配置内容" id="value" value="${config.value}">
                              </input>
                          </div>
                        </div>
                        
                        <div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">配置描述</label>
                          <div class="col-sm-10">
                             	<textarea  style="font-size:15px;width: 300px;" rows="5" class="form-control" name="description"
                              		placeholder="配置描述" id="description">${config.description}</textarea>
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
			</div>
		</div>
		</fieldset>
		</form>
		<!-- page end-->
	</section>
</section>
<!--main content end-->
<script type="text/javascript">
$(function(){
	$('#update_config_form').ajaxForm({
			dataType : 'json',
			success : function(data) {
				if (data.result) {
					bootbox.alert("保存成功，将刷新页面", function() {
						window.location.reload();
						
					});
				}else{
					showErrors($('#update_site_form'),data.errors);
				}
			}
		});
});
</script>
<#include "/manage/foot.ftl">
>>>>>>> .r3567
