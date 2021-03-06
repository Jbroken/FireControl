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

<title></title>

<meta name="viewport"
	content="width=device-width, initial-scale=1,user-scalable=no">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/localStorage.js"></script>
<link rel="stylesheet" type="text/css" href="css/tablehead.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script type="text/javascript">
	function getUnit(policestation,property, unitid, title, address, master, userid) {
		$("#header_policestation").innerHTML = (policestation);
		$("#unitid").val(unitid);
		$("#userid").val(userid);
	}
</script>
</head>

<body>
	<div class="container-fluid table-responsive">
		<form id="reporttable">
			<div class="header">
				<div class="header_policestation"></div>
				<div class="header_title">公安派出所举报投诉消防监督检查记录</div>
				<div class="header_number">
					编号：[ <input id="unitid" name="unitid" class="input_number"
						disabled="disabled" style="width:30px;">]第 <input id="id"
						name="reportid" class="input_number" disabled="disabled"
						style="width: 115px;">号
				</div>
				<hr />
				<input name="tableType" value="举报表" type="hidden"> <input
					id="userid" name="userid" type="hidden"> <span>被查单位(场所)名称<input
					type="text" name="unitname"
					style="width:100%;height:6%;border:none"></span>
				<hr />

				<span>法定代表人/主要负责人<input type="text" name="master"
					style="width:100%;height:6%;border:none"></span>
				<hr />

				<span>地址<input type="text" name="address"
					style="width:100%;height:6%;border:none"></span>
				<hr />
				<span>举报投诉内容<input type="text" name="reportcontent"
					style="width:100%;height:6%;border:none"></span>
				<hr />
				<span>发现的违法行为以及火灾隐患<input type="text" name="problem"
					style="width:100%;height:6%;border:none"></span>
				<hr />
				<span>核查处理情况<input type="text" name="handle"
					style="width:100%;height:6%;border:none"></span>
				<hr />
				<span>备注<input type="text" name="remarks"
					style="width:100%;height:6%;border:none"></span>
				<hr />
				<p align="right">
					检查民警: <input type="text" name="policeman" size="8">
				</p>
				<p align="right">
					被检查单位 (场所)主管人员: <input type="text" name="charge" size="8">
				</p>
				<p align="right">
					检查日期： <input id="checkdate" name="checkdate" class="input_number"
						readOnly="true" style="width: 80px;" />
				</p>
				<script type="text/javascript" src="js/date.js"></script>
				<script type="text/javascript">
					var id = $("#id").val();
					window.android.getFormId(id);
					window.android.takePhoto(id);
					window.android.sign(id);
				</script>
				<hr />
				<div style="text-align: right;">
					<button type="button" class="btn btn-primary"
						onclick="uploadReportInfo()">提交</button>
				</div>
			</div>
		</form>
		<script type="text/javascript">
			function uploadReportInfo() {
				var data = new Object();
				$("input:text").each(function() {
					data[this.name] = this.value;
				});
				$("input:hidden").each(function() {
					data[this.name] = this.value;
				});

				$("input:radio:checked").each(function() {
					data[this.name] = this.value;
				});

				$("input:checkbox:checked").each(function() {
					data[this.name] = this.value;
				});
				$.ajax({
					url : 'uploadReportInfo',
					type : "POST",
					data : data,
					success : function(data) {
						window.android.commitSuccess();
					},
					error : function(data) {
						alert("上传失败，请重试！");
					}
				});
			}
		</script>
	</div>
</body>

</html>