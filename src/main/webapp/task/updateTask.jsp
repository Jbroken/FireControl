<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">

	<title>修改周期</title>
	<meta http-equiv="X-UA-Compatible" content="IE=8">
	<link rel="stylesheet" type="text/css" href="css/easyui.css">
	<link rel="stylesheet" type="text/css" href="css/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
</head>

<body>
<div class="easyui-layout"
	 style="width:70%;margin-left: auto;margin-right: auto;">
	<table id="dg"></table>
</div>
<script type="text/javascript">
	$.ajax({
		url : "getTaskInfo",
		type : "post",
		dataType : "json",
		error : function() {
			alert("数据加载失败，请重试！");
		},
		success : function(data) {
			$('#dg').datagrid(
					{
						title : "场所周期详情",
						width : '100%',
						height : 'auto',
						fitColumns : true, // 数据网格（datagrid）底部显示分页工具栏。
						striped : true, //隔行变色特性
						loadMsg : '数据正在加载,请耐心的等待...',
						striped : true,
						pagination : true, //数据网格（datagrid）底部显示分页工具栏。
						rownumbers : true, //行号
						data : data.slice(0, 10),
						frozenColumns : [ [ //冻结列特性 ,不要与fitColumns 特性一起使用
							{
								field : 'ck',
								width : 50,
								checkbox : true
							} ] ],
						columns : [ [ {
							field : 'taskid',
							title : 'taskid',
							hidden : true
						}, {
							field : 'unitname',
							title : '场所名称',
							width : '300',
							sortable : true
						}, {
							field : 'settime',
							title : '起始时间',
							width : '120',
							sortable : true
						}, {
							field : 'tasktime',
							title : '周期（天）',
							width : '120',
							sortable : true
						} ] ],
						toolbar : [
							{
								text : '修改',
								iconCls : 'icon-edit',
								handler : function() {
									getTaskInfo();
								}
							},
							'-',
							{
								text : '删除',
								iconCls : 'icon-remove',
								handler : function() {
									$.messager.confirm('删除周期信息',
											'确定删除该周期信息？', function(r) {
												if (r) {
													delTaskInfo();
												}
											});

								}
							} ]
					});
			//实现分页
			var pager = $('#dg').datagrid("getPager");
			pager.pagination({
				pageSize : 10,//每页显示的记录条数，默认为10
				pageList : [ 10, 20, 30, 40, 50 ],//可以设置每页记录条数的列表
				total : data.length,
				onSelectPage : function(pageNo, pageSize) {
					var start = (pageNo - 1) * pageSize;
					var end = start + pageSize;
					$('#dg').datagrid("loadData", data.slice(start, end));
					pager.pagination('refresh', {
						total : aa.length,
						pageNumber : pageNo
					});
				}
			});
			function getTaskInfo() {
				var nodes = $('#dg').datagrid('getSelections');
				var tasktime = nodes[0].tasktime;
				var settime = nodes[0].settime;
				var unitname = nodes[0].unitname;
				var taskid = nodes[0].taskid;

				$('#settime').datebox('setValue', settime);
				$("#tasktime").val(tasktime);
				$("#unitname").val(unitname);
				$("#taskid").val(taskid);
				var top = $("#updateTask").offset().top + 100;
				var left = $("#updateTask").offset().center;
				$("#updateTask").window('open').window('resize', {
					top : top,
					left : left
				});
			}
		}
	});
	function updateTaskInfo() {
		var settime = $('#settime').datebox('getValue');
		var tasktime = $("#tasktime").val();
		var taskid = $("#taskid").val();
		$.ajax({
			url : "updateTaskInfo",
			type : "POST",
			cache : true,
			data : {
				"tasktime" : tasktime,
				"settime" : settime,
				"taskid" : taskid
			},
			success : function(data) {
				document.location.reload();
			},
			error : function(data) {
				$.messager.show({
					title:'提示！',
					msg:'修改失败，请重试！',
					timeout:3000,
					icon:'info',
					style:{
						right:'',
						bottom:'',
					}
				});
			}
		});
	}
	function delTaskInfo() {
		var taskid = $('#dg').datagrid('getSelections')[0].taskid;
		$.ajax({
			url : "delTaskInfo",
			type : "POST",
			data : {
				"taskid" : taskid
			},
			success : function(data) {
				document.location.reload();
			}
		});
	}
</script>
<div id="updateTask" class="easyui-dialog" title="修改检查周期"
	 style="width:400px;height:200px;text-align:center;"
	 data-options="iconCls:'icon-add',resizable:true,modal:true,closed:true">
	<br />
	<form action="" id="updateTaskTable">
		<input id="taskid" type="hidden"> <label>场所名称：</label><input
			id="unitname" type="text" readonly="readonly"><br /> <label>起始日期：</label><input
			id="settime" type="text" class="easyui-datebox" required="required"><br />
		<label>商铺周期：</label><input type="text" id="tasktime" /><br /> <input
			type="button" value="修 改" onclick="updateTaskInfo()" />
	</form>
</div>
</body>
</html>
