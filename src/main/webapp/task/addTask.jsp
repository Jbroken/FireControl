<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

	<title></title>
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
<div style="width: 100%;height: auto;">
	<div style="width:50%;float:left;">
		<div class="easyui-panel" style="padding:5px;">
			<ul id="tt" class="easyui-tree"></ul>
		</div>
	</div>
	<div style="width: 50%;height:auto;float:right;">
		<div class="easyui-layout">
			<table id="dg" style="width:100%"></table>
		</div>
	</div>
</div>
<script type="text/javascript">
	$('#tt').tree(
			{
				url : 'getTree',
				checkbox : true,
				onBeforeExpand : function(node) {
					if (node.attributes == "branch") {
						//根据分局ID得到派出所信息
						$('#tt').tree('options').url = "getTree?branchid="
								+ node.id;
					} else if (node.attributes == "police") {
						//根据派出所ID得到商铺信息
						$('#tt').tree('options').url = "getTree?policeid="
								+ node.id;
					}
				},
				onLoadSuccess : function(node) {
					getRoot();//数据加载成功时触发
				},
				onCheck : function(node) {
					getRoot();//点击复选框时触发
				}
			});
	//获取选中的节点
	function getRoot() {
		var nodes = $('#tt').tree('getChecked');
		var aa = new Array();
		for (var i = 0; i < nodes.length; i++) {
			if (nodes[i].attributes == "unit") {
				aa.push(nodes[i]);//得到属于商铺的数据
			}
		}
		$('#dg').datagrid({
			title : "选中场所列表",
			width : '100%',
			height : 'auto',
			fitColumns : true, // 数据网格（datagrid）底部显示分页工具栏。
			striped : true, //隔行变色特性
			loadMsg : '数据正在加载,请耐心的等待...',
			striped : true,
			pagination : true, //数据网格（datagrid）底部显示分页工具栏。
			rownumbers : true, //行号
			data : aa.slice(0, 10),
			frozenColumns : [ [ //冻结列特性 ,不要与fitColumns 特性一起使用
				{
					field : 'ck',
					width : 50,
					checkbox : true
				} ] ],
			columns : [ [ {
				field : 'id',
				title : 'id',
				hidden : true
			}, {
				field : 'text',
				title : '场所名',
				width : 60,
				sortable : true
			} ] ],
			toolbar : [ {
				text : '发布平时任务',
				iconCls : 'icon-edit',
				handler : function() {
					addTime();
				}
			} ]
		});
		//实现分页
		var pager = $('#dg').datagrid("getPager");
		pager.pagination({
			total : aa.length,
			onSelectPage : function(pageNo, pageSize) {
				var start = (pageNo - 1) * pageSize;
				var end = start + pageSize;
				$('#dg').datagrid("loadData", aa.slice(start, end));
				pager.pagination('refresh', {
					total : aa.length,
					pageNumber : pageNo
				});
			}

		});
		function addTime() {
			var left = $("#addTime").offset().center;
			$("#addTime").window('open').window('resize', {
				left : left
			});
		}
	}

	function addTimeInfo() {
		var row = $('#dg').datagrid('getSelections');
		var SetTime = $("#SetTime").datebox("getValue");
		var unitidform = {};
		var tasktime = $.trim($("#tasktime").val());
		for (var i = 0; i < row.length; i++) {
			unitidform["unitid[" + i + "].unitid"] = row[i].id;
			unitidform["unitid[" + i + "].Tasktime"] = tasktime;
			unitidform["unitid[" + i + "].settime"] = SetTime;
		}
		if (row.length <= 0) {
			$.messager.show({
				title:'提示！',
				msg:'请选中需要发布周期的场所！',
				timeout:3000,
				icon:'info',
				style:{
					right:'',
                    top:document.body.scrollTop+document.documentElement.scrollTop,
					bottom:'',
				}
			});
		} else if (tasktime == "") {
			$.messager.show({
				title:'提示！',
				msg:'周期不能为空！',
				timeout:3000,
				icon:'info',
				style:{
					right:'',
                    top:document.body.scrollTop+document.documentElement.scrollTop,
					bottom:'',
				}
			});
		} else {
			$.ajax({
				url : 'addTime',
				data : unitidform,
				dataType : "json",
				type : "POST",
				traditional : true,
				success : function(data) {
					$.messager.alert({
						title:'提示！',
						msg:'恭喜你成功设置' + row.length + '条数据！',
						timeout:3000,
						icon:'info',
						style:{
							right:'',
                            top:document.body.scrollTop+document.documentElement.scrollTop,
							bottom:'',
						}
					});
					$("#addTime").dialog('close');

				},
				error : function() {
					$.messager.alert({
						title:'错误提示！',
						msg:'周期设置失败，请重试！',
						timeout:3000,
						icon:'error',
						style: {
							right: '',
                            top:document.body.scrollTop+document.documentElement.scrollTop,
							bottom: '',
						}
					});
					$("#addTime").dialog('close');
				}

			});
		}
	}
</script>
<div id="addTime" class="easyui-dialog" title="发布检查周期"
	 style="width:400px;height:200px;text-align:center;"
	 data-options="iconCls:'icon-add',resizable:true,modal:true,closed:true">
	<br />
	起始日期：<input id="SetTime" type="text" class="easyui-datebox" required="required"><br />
	场所周期(天)：<input type="text" id="tasktime" /><br /> <br />
	<input type="button" value=" 添 加 " onclick="addTimeInfo()" />
</div>
</body>
</html>
