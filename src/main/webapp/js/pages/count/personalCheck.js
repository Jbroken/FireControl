/**
 * Created by bo.e.zhao on 5/7/2017.
 */
$("#subm").bind("click",function(){
    var checker = $("#checker").val();
    if (checker != ""){
      loadData(inputData(checker));
    }
    else {
      $.messager.alert('警告', '输入不能为空！', 'warning');
    }
  });

/**
 * 请求数据
 * @param data
 */
var loadData = function (data) {
    $.ajax({
        url:'../getPersonal',
        type:'post',
        dataType:'JSON',
        data:data,
        success:function (rdata) {
            personalChar(rdata);
        },
        error:function () {
            $.messager.alert('错误', '数据加载出错！', 'error');
        }
    })
}

/**
 * 加载chart
 * @param dataList
 */
var personalChar = function (dataList) {
    if (dataList.length == 0) {
        $.messager.alert('警告','你查询的检查人员不存在或还没有检查记录，请重新输入！','warning');
    } else {
        var count = new Array;
        var time =  new Array;
        var name =  new Array;
        for(var i = 0;i<dataList.length;i++){
            count.push(dataList[i].count);
            time.push(dataList[i].time);
        }
        name.push(dataList[0].checker);

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

/**
 * 处理输入数据
 * @param input
 * @returns {{}}
 */
var inputData = function (input) {
    var result={};
    if (isNaN(input)){
        
        result.checker = input;
        result.userid = 0;
    }
    else {
        result.checker = null;
        result.userid = input;
    }
    return result;
}