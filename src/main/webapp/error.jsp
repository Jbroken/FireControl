<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>404</title>
  </head>
  <body>
<div style="text-align: center;">
	<img src="images/404.jpg" alt="" id="returnIndex">
</div>
  <script>
      document.getElementById("returnIndex").onclick = function () {
            window.location.replace("logout");
      }
  </script>
  </body>
</html>
