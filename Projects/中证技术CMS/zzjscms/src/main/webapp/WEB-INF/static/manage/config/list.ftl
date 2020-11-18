<#assign menu="config">
<#assign submenu="config_list">
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
		<#if SESSION_ADMIN.isAdmin>
			<div class="row">
	                  <div class="col-lg-12">
	                      <!--breadcrumbs start -->
	                      <ul class="breadcrumb">
					<li>
						<a href="#"><i class="icon-pushpin"></i>&nbsp;&nbsp;配置管理</a>
					</li>
	                      </ul>
	                     	
	                      <!--breadcrumbs end -->
	                  </div>
	              </div>
              </#if>		
        	<!-- page start-->
            <section class="panel">
	        	<header class="panel-heading">
		                <div class="row">
						   <div class="col-lg-12">
								<a class="btn btn-primary" style="float:right;" href="${BASE_PATH}/manage/config/add.htm">增加配置</a>
						   </div>
						</div>
				</header>
                <div class="panel-body">
                	<div class="adv-table">
                    	<div role="grid" class="dataTables_wrapper" id="hidden-table-info_wrapper">
                            <table class="table table-striped table-advance table-hover">
                            	<thead>
                                	<tr>
										<th>配置key</th>
										<th>配置内容</th>
										<th>配置描述</th>
                						<th>最后更新时间</th>
                						<th>操作</th>
              						</tr>
                                </thead>
                            	<tbody role="alert" aria-live="polite" aria-relevant="all">
                            		<#list pageVo.list as e>
                            		<tr class="gradeA odd">
               							<td>
               								<a href="${BASE_PATH}/manage/config/update.htm?key=${e.key}">${e.key}</a>
               							</td>
               							<td>
               								${e.value!}
               							</td>
               							<td>
               								${e.description!}
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
                  							<a href="${BASE_PATH}/manage/config/update.htm?key=${e.key}" title="修改">
                  								编辑
                  							</a>
                  							 | 
                  							<a href="javascript:void(0);" class="js_config_delete" key="${e.key}" title="是否删除组件">
                  								删除
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
	$('.js_config_delete').click(function(){
		var key = $(this).attr('key');
		var status= "trash";
		bootbox.dialog({
			message : $(this).attr('title'),
			title : "提示",
			buttons : {
				"delete" : {
					label : "确定",
					className : "btn-success",
					callback : function() {
						$.post("${BASE_PATH}/manage/config/delete.json", { "key": key},function(data){
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
			"${BASE_PATH}/manage/config/check.json", 
			{"componentId": $(this).attr("componentId"),check:$(this).val()},
			function(data){
				if(data.result){
					window.location.href="${BASE_PATH}/manage/config/list.htm?p="+pageNum;
				}else{
					bootbox.alert(data.msg,
	                function() {
	                    window.location.href="${BASE_PATH}/manage/config/list.htm?p="+pageNum;
	                });
				}
        },"json");  	
    });		
});
</script>
<#include "/manage/foot.ftl">
