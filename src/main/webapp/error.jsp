<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>404</title>
  </head>
  
  <body>
    <%-- <pre>
<%
    Enumeration<String> attributeNames = request.getAttributeNames();
    while (attributeNames.hasMoreElements())
    {
        String attributeName = attributeNames.nextElement();
        Object attribute = request.getAttribute(attributeName);
   out.println("request.attribute['" + attributeName + "'] = " + attribute); 
    }
%>
</pre> --%>
<div style="width: 100%;text-align: center;padding-top: 20%">
	<h1>出现未知错误！</h1>
	<a href="returnLogin">返回主页</a>
</div>
  </body>
</html>
