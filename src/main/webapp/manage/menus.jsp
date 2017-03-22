<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单管理</title>
<link type="text/css" rel="stylesheet" href="css/main.css"/>
</head>
<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
		<tr class="main_head">
			<th>序号</th>
			<th style="width:50%;">名称</th>
			<th>资源路径</th>
			<th>操作</th>
		</tr>
		<c:choose>
			<c:when test="${not empty menuList}">
				<c:forEach items="${menuList}" var="menu" varStatus="vs">
				<tr class="main_info" id="tr${menu.menuid }">
				<td>${vs.index+1}</td>
				<td>${menu.menuname }</td>
				<td>${menu.menurel }</td>
				<td><a href="###" onclick="openClose(${menu.menuid },this,${vs.index })">展开</a> | 
				<a href="###" onclick="editmenu(${menu.menuid })">修改</a> | 
				<a href="###" onclick="delmenu(${menu.menuid },true)">删除</a></td>
				</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr class="main_info">
				<td colspan="4">没有相关数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
	
	<div class="page_and_btn">
		<div>
			<a href="javascript:addmenu();" class="myBtn"><em>新增</em></a>
		</div>
	</div>
	
	<script type="text/javascript" src="js/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		function addmenu(){
			var dg = new $.dialog({
				title:'新增菜单',
				id:'menu_new',
				width:330,
				height:220,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'menu/addmenu'
				});
    		dg.ShowDialog();
		}
		
		function editmenu(menuid){
			var dg = new $.dialog({
				title:'修改菜单',
				id:'menu_edit',
				width:330,
				height:220,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				page:'menu/editmenu?menuid='+menuid
				});
    		dg.ShowDialog();
		}
		
		function delmenu(menuid,isParent){
			var flag = false;
			if(isParent){
				if(confirm("确定要删除该菜单吗？其下子菜单将一并删除！")){
					flag = true;
				}
			}else{
				if(confirm("确定要删除该菜单吗？")){
					flag = true;
				}
			}
			if(flag){
				var url = "menu/delMenu?menuid="+menuid;
				$.get(url,function(data){
					document.location.reload();
				});
			}
		}
		
		function openClose(menuid,curObj,trIndex){
			var txt = $(curObj).text();
			if(txt=="展开"){
				$(curObj).text("折叠");
				$("#tr"+menuid).after("<tr class='main_info' id='tempTr"+menuid+"'><td colspan='4'>数据载入中</td></tr>");
				if(trIndex%2==0){
					$("#tempTr"+menuid).addClass("main_table_even");
				}
				var url = "menu/getSub?menuid="+menuid;
				$.get(url,function(data){
					//alert(data);
					if(data.length>0){
						var html = "";
						$.each(data,function(i){
							html = "<tr style='height:24px;line-height:24px;' name='subTr"+menuid+"'>";
							html += "<td></td>";
							html += "<td><span style='width:80px;display:inline-block;'></span>";
							if(i==data.length-1)
								html += "<img src='images/joinbottom.gif' style='vertical-align: middle;'/>";
							else
								html += "<img src='images/join.gif' style='vertical-align: middle;'/>";
							html += "<span style='width:100px;text-align:left;display:inline-block;'>"+this.menuname+"</span>";
							html += "</td>";
							html += "<td>"+this.menurel+"</td>";
							html += "<td><a href='###' onclick='editmenu("+this.menuid+")'>修改</a> | <a href='###' onclick='delmenu("+this.menuid+",false)'>删除</a></td>";
							html += "</tr>";
							$("#tempTr"+menuid).before(html);
						});
						$("#tempTr"+menuid).remove();
						if(trIndex%2==0){
							$("tr[name='subTr"+menuid+"']").addClass("main_table_even");
						}
						//alert($(".main_table").html());
					}else{
						$("#tempTr"+menuid+" > td").html("没有相关数据");
					}
				},"json");
			}else{
				$("#tempTr"+menuid).remove();
				$("tr[name='subTr"+menuid+"']").remove();
				$(curObj).text("展开");
			}
		}
		
	</script>	
</body>
</html>