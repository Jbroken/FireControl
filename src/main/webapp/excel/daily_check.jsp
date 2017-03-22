<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>

<html>

<head>
<base href="<%=basePath%>">

<title></title>
<meta name="viewport"
	content="width=device-width, initial-scale=1,user-scalable=no"
	name="viewport">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/tablehead.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/localStorage.js"></script>

<script type="text/javascript">
	function getUnit(policestation, unitid, title, address, master, userid) {
		$("#header_policestation").innerHTML = (policestation);
		$("#unitid").val(unitid);
		$("#unitname").val(title);
		$("#address").val(address);
		$("#master").val(master);
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
	};
</script>
</head>

<body>
	<div class="container-fluid table-responsive">
			<div class="header">
				<div class="header_policestation" id="header_policestation"></div>
				<div class="header_title">公安派出所日常消防监督检查记录</div>
				<div class="header_number">
					编号：[ <input id="unitid" name="unitid" class="input_number"
						disabled="disabled" style="width:30px;">]第 <input id="id"
						name="firetableid" class="input_number" disabled="disabled"
						style="width: 115px;">号
				</div>
			</div>
			<div>
				<input name="tableType" value="日常检查表" type="hidden" /> 
				<input id="userid" name="userid" type="hidden">
				<span>单位（场地）名称
					<input type="text" name="unitname" id="unitname"class="input_header">
				</span>
				<hr />

				<span>法定代表人/主要负责人<input type="text" name="master" id="master"
					class="input_header"></span>
				<hr />

				<span>地址<input type="text" name="address" id="address"
					class="input_header"></span>
				<hr />

				<span>单位性质<input type="text" name="unitproperty"
					class="input_header"></span>
				<hr />
				<span>使用的建筑面积<input type="text" name="area"
					class="input_header"></span>
				<hr />

				<span>使用的建筑具体层数<input type="text" name="floors"
					class="input_header"></span>
				<hr />

				<span>所在建筑高度(m)<input type="text" name="hight"
					class="input_header"></span>
				<hr />

				<span>监督检查人员<input type="text" name="checker"
					class="input_header"></span>
				<hr />

				<span>单位随同检查人员<input type="text" name="otherchecker"
					class="input_header"></span>
				<hr />
			</div>
			<div>
				<p style="text-align: right;">
					检查日期: <input id="checkdate" class="input_number" name="checkdate"
						disabled="disabled" style="width:80px;" />
				</p>
				<script type="text/javascript" src="js/date.js"></script>
				<script type="text/javascript">
					var id = $("#id").val();
					window.android.getFormId(id);
					window.android.takePhoto(id);
					window.android.sign(id);
				</script>
			</div>
			<span class="remarks">存在问题</span><br>
				<textarea  name="question" id="question" rows="5" class="textarea-style"></textarea><hr/>
			<span class="remarks">备注</span><br>
				<textarea  name="remarks" id="remarks"  rows="4" class="textarea-style"></textarea><hr/>
			<div>
				是否需要被整改: 
				<select name="checktype" id="checktype" class="form-control" style="width: 35%;float: right">
					<option value="0">不需要</option>
					<option value="1">需要</option>
				</select>
			</div>
		</div>
			<div style="text-align:right;">
				<button type="button" class="btn btn-primary"
					onclick="uploadCheckInfo()">提交</button>
			</div>
	<script type="text/javascript">
		function uploadCheckInfo() {
			var data = new Object();
			$("input").each(function() {
				data[this.name] = this.value;
			});
			$("textarea").each(function () {
				data[this.name] = this.value;
            })
			data.checktype = $("#checktype").val();

			delete data.checkdate;

			$.ajax({
				type : "POST",
				url : "getCheckRecord",
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
</body>

</html>