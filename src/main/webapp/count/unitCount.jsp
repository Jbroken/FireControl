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
      <meta name="viewport" content="width=device-width, initial-scale=1" />
      <script type="text/javascript" src="js/echarts.min.js"></script>
      <script type="text/javascript" src="js/jquery.js"> </script>
      <style type="text/css">
          .title{
              font-size: 20px;
              color: #CD2626;
              font-weight: bold;
              padding-bottom: 10px;
          }
      </style>
  </head>
  <body>
  <div class="title">场所统计:</div>
  <div id="main" style="width: 100%;height:600px;"></div>
  <script type="text/javascript" >
      var type1=new Array();
      var type2=new Array();
      $.ajax({
          url:"getCountUnit",
          type:"post",
          async:false,
          error:function(errorMsg){
              alert("数据加载出错，请稍后再试！");
          },
          success:function(data){
              for(var i=0;i<data.length;i++){
                  type1.push(data[i].unitproperty || "");
                  type2.push({value:parseInt(data[i].count),name:data[i].unitproperty || 0});
              }
          }
      });
      var myChart = echarts.init(document.getElementById('main'));
      option = {
          tooltip : {
              trigger: 'item',
              formatter: "{a} <br/>{b} : {c} ({d}%)"
          },
          /*  backgroundColor: "#2c343c", */
          legend: {
              orient : 'vertical',
              x : 'left',
              data:type1
          },
          toolbox: {
              show : true,
              feature : {
                  mark : {show: true},
                  dataView : {show: true, readOnly: false},
                  magicType : {
                      show: true,
                      type: ['pie', 'funnel'],
                      option: {
                          funnel: {
                              x: '25%',
                              width: '50%',
                              funnelAlign: 'left',
                              max: 1548
                          }
                      }
                  },
                  restore : {show: true},
                  saveAsImage : {show: true}
              }
          },
          calculable : true,
          series : [
              {
                  name:'场所类型:',
                  type:'pie',
                  radius : '55%',
                  center: ['50%', '60%'],
                  data:type2
              }
          ]
      };
      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option);
  </script>
  </body>
</html>
