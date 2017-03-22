<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title></title>
<meta name="viewport"
	content="width=device-width, initial-scale=1,user-scalable=no"
	name="viewport">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/tablehead.css" />
<link rel="stylesheet" type="text/css" href="css/mui.min.css" >
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>

<body>
	<div class="container-fluid table-responsive">
		<form action="">
			<c:forEach items="${table}" var="tab">
				<div class="header">
					<%--<div class="header_policestation"></div>--%>
					<div class="header_title">公安派出所日常消防监督检查记录</div>
					<div class="header_number">编号：[${tab.unitid}]第${tab.firetableid}号</div>
				</div>
				<div class="check table">
					<ul class="mui-table-view">
    					<li class="mui-table-view-cell mui-media">
            				<div class="mui-media-body">
                				单位（场地）名称
                				<p class='mui-ellipsis'>${tab.unitname}</p>
            				</div>
    					</li>
    					<li class="mui-table-view-cell mui-media">
            				<div class="mui-media-body">
              					  法定代表人/主要负责人
                				<p class='mui-ellipsis'>${tab.master}</p>
            				</div>
    					</li>
					    <li class="mui-table-view-cell mui-media">
					    	<div class="mui-media-body">
					    		地址
					    		<p class='mui-ellipsis'>${tab.address}</p>
					   		</div>
					    </li>
					    <li class="mui-table-view-cell mui-media">
					    	<div class="mui-media-body">
					    		单位性质
					    		<p class='mui-ellipsis'>${tab.unitproperty}</p>
					   		</div>
					    </li>
					    <li class="mui-table-view-cell mui-media">
					    	<div class="mui-media-body">
					    		使用的建筑面积(m²)
					    		<p class='mui-ellipsis'>${tab.area}</p>
					   		</div>
					    </li>
					    <li class="mui-table-view-cell mui-media">
					    	<div class="mui-media-body">
					    		使用的建筑具体层数
					    		<p class='mui-ellipsis'>${tab.floors}</p>
					   		</div>
					    </li>
					    <li class="mui-table-view-cell mui-media">
					    	<div class="mui-media-body">
					    		所在建筑高度(m)
					    		<p class='mui-ellipsis'>${tab.height}</p>
					   		</div>
					    </li>
					    <li class="mui-table-view-cell mui-media">
					    	<div class="mui-media-body">
					    		检查人员
					    		<p class='mui-ellipsis'>${tab.checker}</p>
					   		</div>
					    </li>
					    <li class="mui-table-view-cell mui-media">
					    	<div class="mui-media-body">
					    		单位随同检查人员
					    		<p class='mui-ellipsis'>${tab.otherchecker}</p>
					   		</div>
					    </li>
					    <li class="mui-table-view-cell mui-media">
					    	<div class="mui-media-body">
					    		检查日期
					    		<p class='mui-ellipsis'>${tab.checkdate}</p>
					   		</div>
					    </li>
					    <li class="mui-table-view-cell mui-media">
					    	<div class="mui-media-body">
					    		存在的问题
					    		<p class='mui-ellipsis'>${tab.problem}</p>
					   		</div>
					    </li>
					    <li class="mui-table-view-cell mui-media">
					    	<div class="mui-media-body">
					    		备注
					    		<p class='mui-ellipsis'>${remarks}</p>
					   		</div>
					    </li>
					</ul>
				</div>
			</c:forEach>
		</form>
	</div>
</body>
</html>