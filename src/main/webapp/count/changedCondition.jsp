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
	<script type="text/javascript" src="js/echarts.min.js"></script>
	<script type="text/javascript" src="js/jquery.js"></script>
</head>

<body>
	<div id="main" style="width: 100%;height:500px;"></div>
	<script type="text/javascript">
		var type1 = new Array();
		var type2 = new Array();
		$.ajax({
			url : "unitchange",
			type : "post",
			async : false,
			error: function(erroreMsg){
				alert("数据加载出错，请稍后再试！");
			},
			success : function(data) {
				for (var i = 0; i < data.length; i++) {
					//时间
					type1.push(data[i].time || "");
					//整改数量
					type2.push(data[i].count || "");

				}
			}
		});

		var myChart = echarts.init(document.getElementById('main'));

		option = {
			title : {
				text : '每个月场所整改情况',
			},
			tooltip : {
				trigger : 'axis'
			},
			legend : {
				data : [ '整改量' ]
			},
			toolbox : {
				show : true,
				feature : {
					mark : {
						show : true
					},
					dataView : {
						show : true,
						readOnly : false
					},
					magicType : {
						show : true,
						type : [ 'line', 'bar' ]
					},
					restore : {
						show : true
					},
					saveAsImage : {
						show : true
					}
				}
			},
			calculable : true,
			xAxis : [ {
				type : 'category',
				data : [ '1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月',
						'10月', '11月', '12月' ]
			} ],
			yAxis : [ {
				type : 'value'
			} ],
			series : [
					{
						name : '整改量',
						type : 'bar',
						data : [ 2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2,
								32.6, 20.0, 6.4, 3.3 ],
						markPoint : {
							data : [ {
								type : 'max',
								name : '最大值'
							}, {
								type : 'min',
								name : '最小值'
							} ]
						},
						markLine : {
							data : [ {
								type : 'average',
								name : '平均值'
							} ]
						}
					},
			]
		};
		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	</script>
</body>
</html>
