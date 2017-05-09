<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <meta http-equiv="X-UA-Compatible" content="IE=8">
  <title></title>
  <link rel="stylesheet" type="text/css" href="<%=basePath%>css/easyui.css">
  <link rel="stylesheet" type="text/css" href="<%=basePath%>css/icon.css">
  <link rel="stylesheet" type="text/css" href="<%=basePath%>css/demo.css">
  <link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap.min.css">
  <script type="text/javascript" src="<%=basePath%>js/echarts.min.js"></script>
  <script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
  <script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
  <script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="<%=basePath%>js/easyui-lang-zh_CN.js"></script>
  <style type="text/css">
    body {
      width: 100%;
    }
    .query{
      width: 600px;
      margin-left: auto;
      margin-right: auto;
      font-size: 18px;
      margin-top:200px;
      text-align: center;
    }
    #checker{
      width: 350px;
      height: 38px;
      font-size: 18px;
    }
    #subm{
      width:60px;
      height: 38px;
    }
  </style>

</head>

<body>
<div class="query">
    <span>
        <input id="checker" type="text"  name="name" placeholder="请输入检查人员名字或警员ID！">
    </span>
    <span>
        <input id="subm" type="submit" class="btn btn-primary" value="查询">
    </span>
</div>
<div id="main" style="width: 100%;height:500px;"></div>
<script type="text/javascript" src="<%=basePath%>js/pages/count/personalCheck.js"></script>
</body>
</html>
