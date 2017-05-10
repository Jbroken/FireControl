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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
    <link rel="stylesheet" href="<%=basePath%>plugins/bootstrap/css/bootstrap.css">
    <script type="text/javascript" src="<%=basePath%>js/jquery-1.5.1.min.js"></script>
</head>
<body>
<div class="center-block">
    <table class="table table-bordered table-hover">
        <thead></thead>
        <tbody></tbody>
    </table>
</div>

<script type="text/javascript" src="<%=basePath%>js/pages/manage/polices.js"></script>
</body>
</html>
