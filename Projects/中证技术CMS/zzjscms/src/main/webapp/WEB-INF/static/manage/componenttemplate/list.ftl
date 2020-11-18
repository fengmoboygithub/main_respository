<#assign menu="component_template">
<#assign submenu="component_list">
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
              
              <section class="panel">
						<header class="panel-heading"> 查询条件 </header>
							<div class="panel-body">
				            	<form id="add_viewproject_form" class="form-horizontal" action="${BASE_PATH}/manage/componentTemplate/list.htm" method="get" >
									<div class="row">
					                   <label class="col-sm-2 col-sm-2 control-label">模板名称</label>
					                   <div class="col-lg-2">
											<input type="text" class="form-control" name="templateName"
				                              	placeholder="模板名称" id="name" value="${templateName!}">
				                            </input>	
									   </div>
									   
									   
					                  <div class="col-lg-4">
										  <button class="btn btn-shadow btn-primary" style="float:center;" type="submit">查询</button>
									   </div>
									</div>
								</form>
						</div>
					</section>	
              
        	<!-- page start-->
            <section class="panel">
	        	<header class="panel-heading">
		                <div class="row">
						   <div class="col-lg-12">
								<a class="btn btn-primary" style="float:right;" href="${BASE_PATH}/manage/componentTemplate/add.htm">增加模板</a>
						   </div>
						</div>
				</header>
                <div class="panel-body">
                	<div class="adv-table">
                    	<div role="grid" class="dataTables_wrapper" id="hidden-table-info_wrapper">
                            <table class="table table-striped table-advance table-hover">
                            	<thead>
                                	<tr>
										<th>模板名称</th>
										<th>是否默认模版</th>
                						<th>最后更新时间</th>
                						<th>操作</th>
              						</tr>
                                </thead>
                            	<tbody role="alert" aria-live="polite" aria-relevant="all">
								<#list pageVo.list as e>
								<tr class="gradeA odd">
									<td>
               								<a href="${BASE_PATH}/manage/componentTemplate/update.htm?templateId=${e.id!}">${e.templateName!}</a>
               						</td>
               						<td>
               								 ${(e.isDefault == '0')?string('否','是')?html}  
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
               							<a href="${BASE_PATH}/manage/componentTemplate/update.htm?templateId=${e.id!}" title="编辑">
                  								编辑
                  							</a>
                  							 | 
                  							<a href="javascript:void(0);" class="js_component_delete" templateId="${e.id!}" title="是否删除模板">
                  								删除
                  							</a>
               						</td>
								</tr>
								</#list>
                               	</tbody>
                              </table>
                              <div style="height: 30px;">
                             	<div class="pagination">${pageVo.pageNumHtml}</div>
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
	$('.js_component_delete').click(function(){
		var templateId = $(this).attr('templateId');
		var status= "trash";
		bootbox.dialog({
			message : $(this).attr('title'),
			title : "提示",
			buttons : {
				"delete" : {
					label : "确定",
					className : "btn-success",
					callback : function() {
						$.post("${BASE_PATH}/manage/componentTemplate/deleteLogical.json", { "id": templateId},function(data){
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
	$(".js_component_check").change(function(){
		$.post(
			"${BASE_PATH}/manage/component/check.json", 
			{"componentId": $(this).attr("componentId"),check:$(this).val()},
			function(data){
				if(data.result){
					window.location.href="${BASE_PATH}/manage/component/list.htm?p="+pageNum;
				}else{
					bootbox.alert(data.msg,
	                function() {
	                    window.location.href="${BASE_PATH}/manage/component/list.htm?p="+pageNum;
	                });
				}
        },"json");  	
    });		
});
</script>
<#include "/manage/foot.ftl">
