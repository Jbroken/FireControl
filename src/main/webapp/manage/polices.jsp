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
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
    <link rel="stylesheet" href="<%=basePath%>plugins/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>plugins/bootstrap-select/css/bootstrap-select.css">
    <link rel="stylesheet" href="<%=basePath%>css/custom.css">
    <script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>plugins/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript" src="<%=basePath%>plugins/bootstrap-select/js/bootstrap-select.js"></script>
</head>
<body>
<div class="container-fluid">
    <div class="page-bar">
        <ul class="page-breadcrumb">
            <li><span class="glyphicon glyphicon-home"></span>系统管理<span
                    class="glyphicon glyphicon-menu-right"></span></li>
            <li>警员管理</li>
        </ul>
        <div class="tool-icon-bar">
            <a title="添加" onclick="addPolice()" class="icon" href="javascript:void(0)">
                <span class="glyphicon glyphicon-plus-sign"></span></a>
            <a title="删除" onclick="" class="icon" href="javascript:void(0)">
                <span class="glyphicon glyphicon-trash"></span></a>

        </div>
    </div>
    <table class="table table-bordered table-hover">
        <thead></thead>
        <tbody></tbody>
    </table>
</div>
<!-- Modal -->
<div class="modal fade bs-example-modal-sm" id="addPolice" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">添加警员信息</h4>
            </div>
            <div class="modal-body">
                <form action="" id="polices">
                    <div class="form-group">
                        <label for="userid" class="control-label">警号</label>
                        <input type="text" class="form-control" id="userid" name="userid">
                    </div>
                    <div class="form-group">
                        <label for="policeid" class="control-label">所属派出所</label>
                        <select id="policeid" name="policeid" class="form-control selectpicker text-left"
                                data-style="btn-sm">
                            <option value="" class="text-left">Please select</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="relname" class="control-label">姓名</label>
                        <input type="text" class="form-control" id="relname" name="relname">
                    </div>
                    <div class="form-group">
                        <label for="tel" class="control-label">电话号码</label>
                        <input type="text" class="form-control" id="tel" name="tel">
                    </div>
                    <div class="form-group">
                        <label for="password" class="control-label">密码</label>
                        <input type="text" class="form-control" id="password" name="password">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="insertPolice()">保存</button>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="<%=basePath%>js/pages/manage/polices.js"></script>
</body>
</html>
