var name=new Array();
var pieData=new Array();
$.ajax({
    url:"getCountUnit",
    type:"post",
    async:false,
    error:function(errorMsg){
        alert("数据加载出错，请稍后再试！");
    },
    success:function(data){
        for(var i=0;i<data.length;i++){
        	name.push(data[i].unitproperty || "");
        	pieData.push({value:parseInt(data[i].count),name:data[i].unitproperty || 0});
        }
    }
});
var myChart = echarts.init(document.getElementById('main'));
option = {
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient : 'vertical',
        x : 'left',
        data:name
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
            data:pieData
        }
    ]
};
// 使用刚指定的配置项和数据显示图表。
myChart.setOption(option);