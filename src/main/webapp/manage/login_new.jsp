<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>泸州消防APP后台管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/login.css">
<script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
</head>

<body>
	<div
		style="width:100%;height:645px;position: absolute;top:50%;left:50%;margin-top:-320px;margin-left:-50%;">
		<div class="header"></div>
		<div class="center">
			<div class="login_right">
				<div style="width:100%;height:auto;margin-top:150px;">
					<form action="admin" method="post" name="loginForm"
						onsubmit="return check();">
						<div class="login_title">管理员登录</div>
						<div class="login_info">
							<label>用户名：</label><input type="text" name="username"
								id="username" class="login_input" value="${username }" /> &nbsp;<span
								id="nameerr" class="errInfo"></span>
						</div>
						<div class="login_info">
							<label>密 码：</label><input type="password" name="password"
								id="password" class="login_input" value="${password }" /> &nbsp;<span
								id="pwderr" class="errInfo"></span>
						</div>
						<div class="login_info">
							<label>验证码：</label><input type="text" name="code" id="code"
								class="login_code" />&nbsp;&nbsp; <img id="codeImg" alt="点击更换"
								title="点击更换" src="" /> &nbsp;<span id="codeerr" class="errInfo"></span>
						</div>
						<div class="login_info">
							<input type="submit" name="loginBtn" value="登录" class="btn" /> <input
								type="reset" name="cancelBtn" value="取消" class="btn" />
						</div>
					</form>
				</div>
			</div>
			<div class="login_left">
				<div style="width:100%;height:auto;margin-top:150px;">
					<div class="logo"></div>
					<div class="left_txt"></div>
				</div>
			</div>
		</div>
		<div class="bottom">&copy;2016 WNCG版权所有 ICP证：川CP备12021469号-3</div>
	</div>
	<script type="text/javascript">
		var errInfo = "${errInfo}";
		$(document).ready(function() {
			changeCode();
			$("#codeImg").bind("click", changeCode);
			if (errInfo != "") {
				if (errInfo.indexOf("验证码") > -1) {
					$("#codeerr").show();
					$("#codeerr").html(errInfo);
					$("#code").focus();
				} else {
					$("#nameerr").show();
					$("#nameerr").html(errInfo);
				}
			}
			$("#username").focus();
		});

		function genTimestamp() {
			var time = new Date();
			return time.getTime();
		}

		function changeCode() {
			$("#codeImg").attr("src", "code?t=" + genTimestamp());
		}

		function resetErr() {
			$("#nameerr").hide();
			$("#nameerr").html("");
			$("#pwderr").hide();
			$("#pwderr").html("");
			$("#codeerr").hide();
			$("#codeerr").html("");
		}

		function check() {
			resetErr();
			if ($("#username").val() == "") {
				$("#nameerr").show();
				$("#nameerr").html("用户名不得为空！");
				$("#username").focus();
				return false;
			}
			if ($("#password").val() == "") {
				$("#pwderr").show();
				$("#pwderr").html("密码不得为空！");
				$("#password").focus();
				return false;
			}
			if ($("#code").val() == "") {
				$("#codeerr").show();
				$("#codeerr").html("验证码不得为空！");
				$("#code").focus();
				return false;
			}
			return true;
		}
	</script>
</body>
</html>
