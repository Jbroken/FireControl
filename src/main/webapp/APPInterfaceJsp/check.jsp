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
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/tablehead.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/mui.min.css" >
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
</head>

<body>
	<div class="container-fluid table-responsive">
		<form action="">
				<div class="header">
					<%--<div class="header_policestation"></div>--%>
					<div class="header_title">公安派出所日常消防监督检查记录</div>
					<div class="header_number">编号：[${table.unitid}]第${table.firetableid}号</div>
				</div>
				<div class="check table">
					<ul class="mui-table-view">
    					<li class="mui-table-view-cell mui-media">
            				<div class="mui-media-body">
                				单位（场地）名称
                				<p class='mui-ellipsis'>${table.unitname}</p>
            				</div>
    					</li>
    					<li class="mui-table-view-cell mui-media">
            				<div class="mui-media-body">
              					  法定代表人/主要负责人
                				<p class='mui-ellipsis'>${table.master}</p>
            				</div>
    					</li>
					    <li class="mui-table-view-cell mui-media">
					    	<div class="mui-media-body">
					    		地址
					    		<p class='mui-ellipsis'>${table.address}</p>
					   		</div>
					    </li>
					    <li class="mui-table-view-cell mui-media">
					    	<div class="mui-media-body">
					    		单位性质
					    		<p class='mui-ellipsis'>${table.unitproperty}</p>
					   		</div>
					    </li>
					    <li class="mui-table-view-cell mui-media">
					    	<div class="mui-media-body">
					    		使用的建筑面积(m²)
					    		<p class='mui-ellipsis'>${table.area}</p>
					   		</div>
					    </li>
					    <li class="mui-table-view-cell mui-media">
					    	<div class="mui-media-body">
					    		使用的建筑具体层数
					    		<p class='mui-ellipsis'>${table.floors}</p>
					   		</div>
					    </li>
					    <li class="mui-table-view-cell mui-media">
					    	<div class="mui-media-body">
					    		所在建筑高度(m)
					    		<p class='mui-ellipsis'>${table.height}</p>
					   		</div>
					    </li>
					    <li class="mui-table-view-cell mui-media">
					    	<div class="mui-media-body">
					    		检查人员
					    		<p class='mui-ellipsis'>${table.checker}</p>
					   		</div>
					    </li>
					    <li class="mui-table-view-cell mui-media">
					    	<div class="mui-media-body">
					    		单位随同检查人员
					    		<p class='mui-ellipsis'>${table.otherchecker}</p>
					   		</div>
					    </li>
					    <li class="mui-table-view-cell mui-media">
					    	<div class="mui-media-body">
					    		检查日期
					    		<p class='mui-ellipsis'>${table.checkdate}</p>
					   		</div>
					    </li>
					    <li class="mui-table-view-cell mui-media">
					    	<div class="mui-media-body">
					    		存在的问题
					    		<p class='mui-ellipsis'>${table.problem}</p>
					   		</div>
					    </li>
					    <li class="mui-table-view-cell mui-media">
					    	<div class="mui-media-body">
					    		备注
					    		<p class='mui-ellipsis'>${table.remarks}</p>
					   		</div>
					    </li>
						<c:forEach items="${table.picture}" var="picture">
							<c:choose>
								<c:when test="${picture.picType == 'CheckerPic'}">
									<li class="mui-table-view-cell mui-media">
										<div class="mui-media-body">
											身份信息
											<img class="img-responsive" src="${picture.pictureurl}">
										</div>
									</li>
								</c:when>
								<c:when test="${picture.picType == 'UnitPic'}">
									<li class="mui-table-view-cell mui-media">
										<div class="mui-media-body">
											场所信息
											<img class="img-responsive" src="${picture.pictureurl}">
										</div>
									</li>
								</c:when>
								<c:when test="${picture.picType == 'SignPic'}">
									<li class="mui-table-view-cell mui-media">
										<div class="mui-media-body">
											签名
											<img class="img-responsive" src="${picture.pictureurl}">
										</div>
									</li>
								</c:when>
							</c:choose>
						</c:forEach>
					</ul>
				</div>
		</form>
	</div>
</body>
</html>