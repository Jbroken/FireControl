<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	  <meta http-equiv="X-UA-Compatible" content="IE=Edge">
	  <title></title>
	  <link rel="stylesheet" type="text/css" href="css/easyui.css">
	  <link rel="stylesheet" type="text/css" href="css/icon.css">
	  <link rel="stylesheet" type="text/css" href="css/demo.css">
	  <script type="text/javascript" src="js/jquery.min.js"></script>
	  <script type="text/javascript" src="js/jquery.js"></script>
	  <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	  <script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
  </head>
  
  <body>
  <div class="easyui-layout" >
	  <table id="dg" ></table>
  </div>
  <script type="text/javascript">
	  $.ajax({
		  url:'getProblem',
		  type:"post",
		  async:false,
		  success:function(data){
			  for (var i = 0; i < data.length; i++) {
				  if (data[i].column_name=="firetableid"||data[i].column_name=="unitid"||data[i].column_name=="checker") {
					  data.splice(i,1);
				  }
			  }
			  $('#dg').datagrid({
				  title:"日常检查问题统计",
				  width:'100%',
				  height:'auto',
				  fitColumns:true , 		// 数据网格（datagrid）底部显示分页工具栏。
				  striped: true ,					//隔行变色特性
				  loadMsg: '数据正在加载,请耐心的等待...' ,
				  striped:true,
				  rownumbers:true,		//行号
				  data:data.slice(0,data.length),
					
				  columns:[[{
					  field:'column_comment',
					  title:'单项',
					  width:'300',
					  sortable:true
				  },{
					  field:'first_rate' ,
					  title:'（没问题）比例' ,
					  width:'120',
					  sortable : true
				  },{
					  field:'second_rate',
					  title:'(小问题)比例',
					  width:'120',
					  sortable:true
				  },{
					  field:'third_rate',
					  title:'(中等问题)比例',
					  width:'120',
					  sortable:true
				  }
					  ,{
						  field:'fourth_rate',
						  title:'(大问题)比例',
						  width:'120',
						  sortable:true
					  }
					  ,{
						  field:'fifth_rate',
						  title:'(严重问题)比例',
						  width:'120',
						  sortable:true
					  }
				  ]]
			  });
		  }
	  });
  </script>
  </body>
</html>
