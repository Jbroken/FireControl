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
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/checktable_bytime.js"></script>
	<style type="text/css">
		.header_policestation{
			text-align: center;
			font-weight:bold;
			font-size: 25px;
		}
		.header_title{
			text-align: center;
			font-weight:bold;
			font-size: 20px;
		}
		.header_number{
			text-align: right;
			font-size: 18px;
		}
		.padding-style{
			padding-left:10px;
		}
		.table-style{
			margin:0 0 0 70px;
		}
	</style>
</head>
  
<body>
<div>
	<table class="table-style">
		<tr>
			<td class="padding-style">开始时间:</td>
			<td>
				<input id="startdate" type="text" class="easyui-datebox" style="height:30px;font-size: 20px"/>
			</td>
			<td class="padding-style">结束时间:</td>
			<td>
				<input id="enddate" type="text" class="easyui-datebox" style="height:30px;font-size: 20px" />
			</td>
			<td class="padding-style"><input type="submit" value="查询" class="btn btn-primary" onclick="getfiretable()"></td>
		</tr>
	</table>
</div>
<div class="easyui-layout" style="width: 100%;height:100%;margin-top:20px" >
	<table id="dg"></table>
</div>
<div id="return_jsp" class="container-fluid table-responsive easyui-window"title="日常表格" style="width:80%;height:auto"
	 data-options="iconCls:'icon-save',modal:true,closed:true">
	<div class="header">
		<div class="header_policestation"></div>
		<div class="header_title">公安派出所日常消防监督检查记录 </div>
		<div class="header_number">编号：<span id="unitid">[]</span>第 <span id="firetableid">号</span></div>
	</div>
	<div class="check table">
		<table class="table table-bordered" id="table">
			<tr>
				<td>单位（场地）名称</td>
				<td id="unitname" colspan="2"></td>
				<td>法定代表人/主要负责人</td>
				<td id="master" colspan="2"></td>
			</tr>
			<tr>
				<td>地址</td>
				<td id="address" colspan="2"></td>
				<td>单位性质</td>
				<td id="unitproperty" colspan="2"></td>
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
