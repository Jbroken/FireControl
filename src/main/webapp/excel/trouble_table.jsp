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
	window.onload = function() //用window的onload事件，窗体加载完毕的时候
	{
		$("input:radio").click(function() {
			var checkedState = $(this).attr('checked'); //记录当前选中状态  
			$(this).attr('checked', true); //2.  
			if (checkedState == 'checked') {
				$(this).attr('checked', false); //3.  
			}
		});
	}
</script>
</head>

<body>
	<div class="container-fluid table-responsive">
		<form id="troubletable">
			<div class="header">
				<div class="header_title">严重威胁公共安全的火灾隐患报告书</div>
				<hr />
				<div class="header_number">
					编号：[ <input id="unitid" name="unitid" class="input_number"
						disabled="disabled" style="width:30px;">]第 <input id="id"
						name="troubletableid" class="input_number" disabled="disabled"
						style="width: 115px;">号
				</div>
				<script type="text/javascript">
					var id = $("#id").val();
					window.android.getFormId(id);
					window.android.takePhoto(id);
					window.android.sign(id);
				</script>
			</div>
			<p>
				<input name="tableType" value="报告书" type="hidden" /> <input
					id="userid" name="userid" type="hidden"> <input type="text"
					name="organization" style="width:98%;" class="input_border"
					placeholder="乡镇人民政府 、街道办事处 、公安机关消防机构名称">: <br> 我所于 <input
					type="text" name="year" size="4" style="border:none">年 <input
					type="text" style="border:none" name="mouth" size="2">月 <input
					type="text" style="border:none" name="day" size="2">日 ，对于 <input
					type="text" name="unitname" class="input_border">(单位或场所名称)依法实施消防监督检查时
				,发现现场存在以下火灾隐患，很可能严重威胁公共安全 <br>
			<ol>
				<li><label class="checkbox" for="risk1"> <input
						name="risk1" type="checkbox" value="1" id="risk1">甲、乙类厂房设置在建筑的地下
						、半地下室 ；
				</label></li>
				<li><label class="checkbox" for="risk2"> <input
						name="risk2" type="checkbox" value="2" id="risk2">甲、乙类厂房、库房或丙类厂房与人员密集场所、住宅或宿舍混合设置在同一建筑内；
				</label></li>
				<li><label class="checkbox" for="risk3"> <input
						name="risk3" type="checkbox" value="3" id="risk3">疏散通道、安全出口数量不足或者严重堵塞,
						已不具备安全疏散条件；
				</label></li>
				<li><label class="checkbox" for="risk4"> <input
						name="risk4" type="checkbox" value="4" id="risk4">建筑消防设施严重损坏
						,不再具备防火灭火功能 ；
				</label></li>
				<li><label class="checkbox" for="risk5"> <input
						name="risk5" type="checkbox" value="5" id="risk5">人员密集场所违反消防安全规定,使用、储存易燃易爆危险品
						；
				</label></li>
				<li><label class="checkbox" for="risk6"> <input
						name="risk6" type="checkbox" value="6" id="risk6">公众聚集场所违反消防技术标准,采用易燃、
						可燃材料装修装饰 ,可能导致重大人员伤亡；
				</label></li>
				<li><label class="checkbox" for="otherrisk"> <input
						name="otherrisk" type="checkbox" value="" id="otherrisk">其他可能严重威胁公共安全的火灾隐患情况；
				</label></li>

			</ol>
			根据 «消防监督检查规定 »第三十四条的规定 ,特此报告。
			<hr />
			<p align="right">(公安派出所印章)</p>
			<p align="right">
				<input id="checkdate" type="text" class="input_number" disabled="disabled"
					style="width: 80px;" />
			</p>
			<hr />
			<p>一式三份 ,一份存档 ,接受报告的乡镇人民政府或者街道办事处和主管公安机关消防机构各一份 。</p>
			<hr />
			<div style="text-align: right; ">
				<button type="button" class="btn btn-primary "
					onclick="uploadTroubletInfo()">提交</button>
			</div>
		</form>
		<script type="text/javascript" src="js/date.js"></script>
	</div>
	<script type="text/javascript">
		function uploadTroubletInfo() {
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
				url : 'uploadTroubleInfo',
				type : "POST",
				data : data,
				success : function(data) {
					window.android.commitSuccess();
				},
				error : function(data) {
					alert("上传失败，请重试 ");
				}
			});
		}
	</script>
</body>

</html>