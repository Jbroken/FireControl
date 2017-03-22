$("#subm").bind("mousedown",function(){
    var startdate= $("#startdate").datebox("getValue");
    var enddate = $("#enddate").datebox("getValue");
    var datetype = $("#datetype").val();
    $.post(
        "gettimes",
        {
            startdate:startdate,
            enddate:enddate,
            datetype:datetype,
        },
        function(data){
            //Echarts
            var myChart = echarts.init(document.getElementById('main'));

            option = {
                tooltip : {
                    trigger: 'axis',
                    axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                        type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                legend: {
                    data:data.legend /* ['直接访问','邮件营销','联盟广告','视频广告','搜索引擎','百度','谷歌','必应','其他'] */
                },
                toolbox: {
                    show : true,
                    orient: 'vertical',
                    x: 'right',
                    y: 'center',
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
                        data : data.xAxis
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series :  data.yAxis
            };
            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        }
    );

});