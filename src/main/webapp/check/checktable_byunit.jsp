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
    <meta http-equiv="X-UA-Compatible" content="IE=8">
	<title></title>
	<link rel="stylesheet" type="text/css" href="css/easyui.css">
	<link rel="stylesheet" type="text/css" href="css/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<link rel="stylesheet" type="text/css" href="css/tablehead.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/checktable_byunit.js"></script>
</head>

<body>
<div class="query">
	<label for="unit_name">场所名称：</label>
	<input id="unit_name" class="easyui-combobox" style="height: 35px;width:300px;"
		   data-options="valueField:'unitname' , textField:'unitname', loader : myloader, mode : 'remote'">
	<input id="subm" type="submit" class="btn btn-primary" value="查询"
		   onclick="getTableByUnit()">
</div>
<div class="easyui-layout" style="width: 100%;height:100%">
	<table id="dg"></table>
</div>
<div id="return_jsp"
	 class="container-fluid table-responsive easyui-window" title="日常表格"
	 style="width:90%;height:auto"
	 data-options="iconCls:'icon-save',modal:true,closed:true">
	<div class="header">
		<div class="header_policestation"></div>
		<div class="header_title">公安派出所日常消防监督检查记录</div>
		<div class="header_number">
			编号：<span id="unitid">[]</span>第<span id="firetableid">号</span>
		</div>
	</div>
	<div class="check table">
		<table class="table table-bordered" id="table">
			<tr>
				<td>单位（场地）名称</td>
				<td colspan="2" id="unitname"></td>
				<td>法定代表人/主要负责人</td>
				<td colspan="2" id="master"></td>
			</tr>
			<tr>
				<td>地址</td>
				<td colspan="2" id="address"></td>
				<td>单位性质</td>
				<td colspan="2" id="unitproperty"></td>
			</tr>
			<tr>
				<td>使用的建筑面积(m²)</td>
				<td id="area"></td>
				<td>使用的建筑具体层数</td>
				<td id="floors"></td>
				<td>所在建筑高度(m)</td>
				<td id="height"></td>
			</tr>
			<tr>
				<td>监督检查人员(签名)</td>
				<td id="checker"></td>
				<td>单位随同检查人员(签名)</td>
				<td id="otherchecker"></td>
				<td>检查日期</td>
				<td id="checkdate"></td>
			</tr>
			<tr>
				<td>存在的问题</td>
				<td colspan="5" id="problem"></td>
			</tr>
			<tr>
				<td>备注</td>
				<td colspan="5" id="remarks"></td>
			</tr>
			<tr>
				<td>身份信息</td>
				<td>场所信息</td>
				<td>签名</td>
			</tr>
			<tr>
				<td><img id="CheckerPic" src="" alt="" width="195px" height="263px" style="vertical-align:middle;"></td>
				<td><img id="UnitPic" src="" alt="" width="195px" height="263px" style="vertical-align:middle;"></td>
				<td><img id="SignPic" src="" alt="" width="195px" height="263px" style="vertical-align:middle;"></td>
			</tr>

		</table>
	</div>
</div>
</body>
</html>
