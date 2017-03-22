<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="X-UA-Compatible" content="IE=8">
	<title></title>
	<link rel="stylesheet" type="text/css" href="css/easyui.css">
	<link rel="stylesheet" type="text/css" href="css/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/echarts.min.js"></script>
</head>
<body>
<div class="easyui-layout" style="width:80%;margin-left: auto;margin-right: auto;">
	<table id="dg" ></table>
</div>
<div id="policeInfo" class="container-fluid table-responsive easyui-window" title="派出所检查情况"style="width:100%;height:600px;"data-options="iconCls:'icon-save',modal:true,closed:true">
	<div>
		<table>
			<tr>
				<td>数据类型:</td>
				<td>
					<select name="datatype" id="datatype">
						<option value="1"selected="selected">检查覆盖率</option>
						<option value="2" >检查场所数</option>
					</select>
				</td>
				<td>时间类型:</td>
				<td>
					<select name="datetype" id="datetype">
						<option value="1"selected="selected">天</option>
						<option value="2" >周</option>
						<option value="3" >月</option>
					</select>
				</td>
				<td>结束时间:</td>
				<td>
					<input id="enddate" name="enddate" type="text" class="easyui-datebox" />
				</td>
				<td>个数:</td>
				<td>
					<select name="number" id="number">
						<option value="10"selected="selected">10</option>
						<option value="11" >11</option>
						<option value="12" >12</option>
					</select>
				</td>
				<td><input type="submit" value="查询" onclick = "getPoliceInfoImpl()"></td>
			</tr>
		</table>
	</div>
	<div id="main" style="width: 100%;height:100%;"></div>
</div>
<script type="text/javascript" src="js/policeCheck.js"></script>
</body>
</html>
