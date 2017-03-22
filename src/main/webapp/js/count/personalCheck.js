$("#subm").bind("mousedown",function(){
    var count = new Array;
    var time =   new Array;
    var name=  new Array;

    var checker = $("#checker").val();
    $.post(
        "getPersonal",
        {
            checker:checker,
        },
        function(data){
            if (data==null) {
                alert("你查询的检查人员不存在，请重新输入！");
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
});