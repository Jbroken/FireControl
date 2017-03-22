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
	<script type="text/javascript" src="js/jquery.js"> </script>
	<script type="text/javascript" src="js/echarts.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
	<link rel="stylesheet" type="text/css" href="css/icon.css">
	<link rel="stylesheet" type="text/css" href="css/easyui.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<style type="text/css">
		.padding-style{
			padding-left:10px;
		}
		.table-style{
			margin:0 0 0 70px;
		}
	</style>
</head>
  
<body>
<div style="margin:20px 0;"></div>
<table class="table-style">
	<tr>
		<td class="padding-style">开始时间:</td>
		<td>
			<input id="startdate" type="text" class="easyui-datebox" style="height:30px;font-size: 20px" />
		</td>
		<td class="padding-style">结束时间:</td>
		<td>
			<input id="enddate" type="text" class="easyui-datebox" style="height:30px;font-size: 20px"/>
		</td>
		<td class="padding-style">显示格式:</td>
		<td class="padding-style">
			<select name="datetype" id="datetype" style="height:30px;font-size: 20px">
				<option value="1"selected="selected">按周</option>
				<option value="2" >按月</option>
			</select>
		</td>
		<td class="padding-style"><input id="subm" type="submit" class="btn btn-primary" value="查询"></td>
	</tr>
</table>
<div id="main" style="width: 100%;height:500px;"></div>
    
<script type="text/javascript">
    
	$("#subm").bind("mousedown",function(){
		var startdate= $("#startdate").datebox("getValue");
		var enddate = $("#enddate").datebox("getValue");
		var datetype = $("#datetype").val();
		$.post(
				"gettimes",
				{
					startdate:startdate,
					enddate:enddate,
					datetype:datetype,
				},
				function(data){
					if(data == null)
					{
						$.messager.alert('错误提示！', '该日期段内没有数据，请重新选择日期段！', 'error');
					}
					//Echarts
					else {
						var myChart = echarts.init(document.getElementById('main'));
						option = {
							tooltip : {
								trigger: 'axis',
								axisPointer : {            // 坐标轴指示器，坐标轴触发有效
									type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
								}
							},
							legend: {
								data:data.legend
							},
							toolbox: {
								show : true,
								orient: 'vertical',
								x: 'right',
								y: 'center',
								feature : {
									mark : {show: true},
									dataView : {show: true, readOnly: false},
									magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
									restore : {show: true},
									saveAsImage : {show: true}
								}
							},
							calculable : true,
							xAxis : [
								{
									type : 'category',
									data : data.xAxis
								}
							],
							yAxis : [
								{
									type : 'value'
								}
							],
							series :  data.yAxis
						};
						//使用刚指定的配置项和数据显示图表。
						myChart.setOption(option);
					}
				}
		);
	});
</script>
</body>
</html>
