<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>">
  <meta http-equiv="X-UA-Compatible" content="IE=8">
  <title></title>
  <link rel="stylesheet" type="text/css" href="css/easyui.css">
  <link rel="stylesheet" type="text/css" href="css/icon.css">
  <link rel="stylesheet" type="text/css" href="css/demo.css">
  <script type="text/javascript" src="js/echarts.min.js"></script>
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/jquery.js"></script>
  <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
  <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
  <style type="text/css">
    body {
      width: 100%;
    }
    .query{
      width: 600px;
      margin-left: auto;
      margin-right: auto;
      font-size: 18px;
      margin-top:200px;
      text-align: center;
    }
    #checker{
      width: 350px;
      height: 38px;
      font-size: 18px;
    }
    #subm{
      width:60px;
      height: 38px;
    }
  </style>

</head>

<body>
<div class="query">
  <span>
    <input id="checker" type="text"  name="name" placeholder="请输入检查人员名字或警员ID！">
  </span>
  <span>
    <input id="subm" type="submit" class="btn btn-primary" value="查询">
  </span>
</div>
<div id="main" style="width: 100%;height:500px;"></div>
<script type="text/javascript">
  $("#subm").bind("mousedown",function(){
    var count = new Array;
    var time =   new Array;
    var name=  new Array;

    var checker = $("#checker").val();
    if (checker != ""){
      $.post(
              "getPersonal",
              {
                checker:checker,
              },
              function(data){
                if (data.length == 0) {
                  $.messager.alert('警告','你查询的检查人员不存在或还没有检查记录，请重新输入！','warning');
                } else {
                  for(var i = 0;i<data.length;i++){
                    count.push(data[i].count);
                    time.push(data[i].time);
                  }
                  name.push(data[0].checker);

                  var myChart = echarts.init(document.getElementById('main'));

                  option = {
                    tooltip : {
                      trigger: 'axis'
                    },
                    legend: {
                      data:name,
                      x:'left',
                      padding:[10,0,0,200]
                    },
                    toolbox: {
                      show : true,
                      feature : {
                        mark : {show: true},
                        dataView : {show: true, readOnly: false},
                        magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
                        restore : {show: true},
                        saveAsImage : {show: true}
                      }
                    },
                    calculable : true,
                    xAxis : [
                      {
                        type : 'category',
                        boundaryGap : false,
                        data :time,
                      }
                    ],
                    yAxis : [
                      {
                        type : 'value'
                      }
                    ],
                    series : [
                      {
                        name:name,
                        type:'line',
                        stack: '总量',
                        data:count
                      },
                    ]
                  };
                  // 使用刚指定的配置项和数据显示图表。
                  myChart.setOption(option);
                }
              }
      );
    }
    else {
      $.messager.alert('警告', '输入不能为空！', 'warning');
    }
  });
</script>
</body>
</html>
