<!--新建配置-->
<#assign menu="config">
<#assign submenu="add_config">
<#include "/manage/head.ftl">
<!--main content start-->
<section id="main-content">
	<section class="wrapper">
		<!-- page start-->
		<form id="add_config_form" class="form-horizontal" action="${BASE_PATH}/manage/config/add.json"  autocomplete="off"  method="post">
		<div class="row">
			<input type="hidden" name="adminId" value="${adminId}">
			<div class="col-lg-12">
				<section class="panel">
					<header class="panel-heading"> 
						增加配置
					</header>
					<div class="panel-body">
						
						<div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">配置key</label>
                          <div class="col-sm-10">
                              <input type="text" style="font-size:15px;width: 300px;" class="form-control" name="key"
                              	placeholder="配置key" id="key" >
                              </input>
                          </div>
                        </div>
                     
                     	<div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">配置内容</label>
                          <div class="col-sm-10">
                              <input type="text" style="font-size:15px;width: 300px;" class="form-control" name="value"
                              	placeholder="配置内容" id="value" >
                              </input>
                          </div>
                        </div>
						
						<div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">配置描述</label>
                           <div class="col-sm-10">
                             	<textarea  style="font-size:15px;width: 300px;" rows="5" class="form-control" name="description"
                              		placeholder="配置描述" id="description"></textarea>
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
	$('#add_config_form').ajaxForm({
		dataType : 'json',
		success : function(data) {
			if (data.result) {
				bootbox.alert("保存成功，将刷新页面", function() {
					window.location.reload();
				});
			}else{
				showErrors($('#add_config_form'),data.errors);
			}
		}
	});
});
</script>
<#include "/manage/foot.ftl">