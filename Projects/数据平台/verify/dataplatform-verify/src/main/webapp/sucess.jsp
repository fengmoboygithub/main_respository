<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<head>
	<meta charset="UTF-8">
	<title>Row Editing in DataGrid - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/demo.css">
	<script type="text/javascript" src="<%=basePath%>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/jquery.easyui.min.js"></script>
</head>
<body>
	<h2>Row Editing in DataGrid</h2>
	<p>Click the row to start editing.</p>
	<div style="margin:20px 0;"></div>
	
	<table id="dg" class="easyui-datagrid" title="Row Editing in DataGrid" style="width:700px;height:auto"
			
				data-options="rownumbers:true,singleSelect:true,pagination:true,url: '<%=basePath%>back/item1',method:'get'">
		<thead>
			<tr>
				
						<th data-options="field:'M_ID',width:250,editor:'textbox'">字段名</th>
						<th data-options="field:'STATUS',width:250,editor:'textbox'">模板类型</th>
				
				<!--  
				<th data-options="field:'unitcost',width:80,align:'right',editor:{type:'numberbox',options:{precision:2}}">Unit Cost</th>
				<th data-options="field:'attr1',width:250,editor:'textbox'">Attribute</th>
				<th data-options="field:'status',width:60,align:'center',editor:{type:'checkbox',options:{on:'P',off:''}}">Status</th>-->
			</tr>
		</thead>
	</table>

	<div id="tb" style="height:auto">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="append()">Append</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeit()">Remove</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="accept()">Accept</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-undo',plain:true" onclick="reject()">Reject</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="getChanges()">GetChanges</a>
	</div>
	
	<script type="text/javascript">
	$(function(){
		var pager = $('#dg').datagrid().datagrid('getPager');	// get the pager of datagrid
		pager.pagination({
			buttons:[{
				iconCls:'icon-search',
				handler:function(){
					alert('search');
				}
			},{
				iconCls:'icon-add',
				handler:function(){
					alert('add');
				}
			},{
				iconCls:'icon-edit',
				handler:function(){
					alert('edit');
				}
			}]
		});			
	})
		var editIndex = undefined;
		function endEditing(){
			if (editIndex == undefined){return true}
			if ($('#dg').datagrid('validateRow', editIndex)){
				$('#dg').datagrid('endEdit', editIndex);
				editIndex = undefined;
				return true;
			} else {
				return false;
			}
		}
		function onClickCell(index, field){
			if (editIndex != index){
				if (endEditing()){
					$('#dg').datagrid('selectRow', index)
							.datagrid('beginEdit', index);
					var ed = $('#dg').datagrid('getEditor', {index:index,field:field});
					if (ed){
						($(ed.target).data('textbox') ? $(ed.target).textbox('textbox') : $(ed.target)).focus();
					}
					editIndex = index;
				} else {
					setTimeout(function(){
						$('#dg').datagrid('selectRow', editIndex);
					},0);
				}
			}
		}
		function onEndEdit(index, row){
			var ed = $(this).datagrid('getEditor', {
				index: index,
				field: 'T_TEMPLATE_TYPE'
			});
			row.productname = $(ed.target).combobox('getText');
		}
		function append(){
			if (endEditing()){
				$('#dg').datagrid('appendRow',{D_FIELD:'123'});
				editIndex = $('#dg').datagrid('getRows').length-1;
				$('#dg').datagrid('selectRow', editIndex)
						.datagrid('beginEdit', editIndex);
			}
		}
		function removeit(){
			if (editIndex == undefined){return}
			$('#dg').datagrid('cancelEdit', editIndex)
					.datagrid('deleteRow', editIndex);
			editIndex = undefined;
		}
		function accept(){
			if (endEditing()){
				$('#dg').datagrid('acceptChanges');
			}
			var data=$('#dg').datagrid('getRows');
			$.messager.progress({
	            title: '提示',
	            msg: '请稍候……',
	            text: '数据保存中……'
	        });
			// 保存数据
			$.ajax({
				type : 'post',
				url : '<%=basePath%>back/doSave',
				contentType : "application/json;charset=utf-8",
				data: JSON.stringify(data),
				//data: formObj,
				dataType : 'json',
				//traditional : true,
				success : function(result) {
					$.messager.progress('close');//进度条关闭
					if (result.code == 1) {
						var messag = "保存成功";
						alert(messag);
						refreshParentTable();
						
					}else{
						//showTimeoutMsg(resData.message.replace("系统异常：", "") || '操作失败，请联系系统管理员或稍后再试！',500,null);
						$.messager.alert("操作提示", result.message.replace("系统异常：", "") || '操作失败，请联系系统管理员或稍后再试！');
					}
				},
				error : function(xmlHttpRequest, error) { // 设置表单提交出错
					$.messager.progress('close');//进度条关闭
					alert('操作失败，请联系系统管理员或稍后再试！');
					//showTimeoutMsg('操作失败，请联系系统管理员或稍后再试！',1000,null);
				},
			});
				
		}
		function reject(){
			$('#dg').datagrid('rejectChanges');
			editIndex = undefined;
		}
		function getChanges(){
			var rows = $('#dg').datagrid('getChanges');
			alert(rows.length+' rows are changed!');
		}
	</script>
</body>
</html>