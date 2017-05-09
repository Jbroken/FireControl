<%--
  Created by IntelliJ IDEA.
  User: bo.e.zhao
  Date: 5/8/2017
  Time: 5:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
    <title>Title</title>
    <style rel="stylesheet" href="<%=basePath%>plugins/bootstrap/css/bootstrap.css"></style>
</head>
<body>
    <table class="table table-bordered table-hover">

    </table>
</body>
</html>
