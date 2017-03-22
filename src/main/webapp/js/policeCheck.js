/**
 *
 */
$.ajax({
    url:"getPoliceCheckInfo",
    type:"post",
    datatype:'json',
    error:function(errorMeg){
        alert("数据加载异常，请重试！");
    },
    success:function(data){
        $('#dg').datagrid({
            title:"派出所检查情况",
            width:'100%',
            height:'auto',
            fitColumns:true , 		// 数据网格（datagrid）底部显示分页工具栏。
            striped: true ,					//隔行变色特性 
            loadMsg: '数据正在加载,请耐心的等待...' ,
            striped:true,
            //pagination: true, 		//数据网格（datagrid）底部显示分页工具栏。
            rownumbers:true,		//行号
            data:data.slice(0,data.length),
            frozenColumns:[[				//冻结列特性 ,不要与fitColumns 特性一起使用 
                {
                    field:'ck',
                    width:50,
                    checkbox: true
                }
            ]],
            columns:[[{
                field:'policeid',
                title:'派出所编号',
                width:'120',
                sortable:true
            },{
                field:'policeStation',
                title:'派出所',
                width:'300',
                sortable:true
            },{
                field:'unitsum' ,
                title:'场所总数' ,
                width:'120',
                sortable : true
            },{
                field:'checkunitsum',
                title:'被检查数',
                width:'120',
                sortable:true
            },{
                field:'coverage',
                title:'覆盖率',
                width:'120',
                sortable:true
            }
            ]],
            toolbar: [{
                text:'查看',
                iconCls: 'icon-search',
                handler: function(){
                    getPoliceInfo();
                }
            }]
        });
    }
});
//查看派出所具体检查记录
function getPoliceInfo(){
    var nodes = $('#dg').datagrid('getSelections');
    if(nodes.length<=0){
        $.messager.alert('提示！','你未选中任何派出所！','info');
    }else if(nodes.length>5){
        $.messager.alert('提示！','选中的派出所个数不超过5个！','info');
    }else{
    	getPoliceInfoImpl();
    }
}
//请求数据
function getPoliceInfoImpl(){
	var datatype,datetype,number,enddate,policestationList = {};
	var nodes = $('#dg').datagrid('getSelections');
    datatype = $("#datatype").val();
    datetype = $("#datetype").val();
    number = $("#number").val();
    enddate = $('#enddate').datebox('getValue');
    for (var i = 0; i < nodes.length; i++) {
    	policestationList["policestationid[" + i + "].policeid"] = nodes[i].policeid;	
    }
    if(enddate.length == 0){
        enddate = getNowDate();			//如果日期为空，就取当前日期
    }
    policestationList["datatype"] = datatype;
    policestationList["datetype"] = datetype;
    policestationList["number"] =  number;
    policestationList["enddate"] = enddate;
    $.ajax({
        url:'getPoliceStInfo',
        data:policestationList,
        dataType:"JSON",
        type:'post',
        async:false,//同步执行
        traditional:true,
        success:function(data){
        	console.info(data);
            Echarts(data);
        },
        error:function(){
            $.messager.alert('错误！','请求数据出错，请重试！','error');
        }
    });
}
//数据请求成功，调用Echarts
function Echarts(data){
	//打开dialog
    var top = $("#policeInfo").offset().top;
    var left = $("#policeInfo").offset().center;
    $('#policeInfo').window('open').window('resize',{top: top,left:left});
    var myChart = echarts.init(document.getElementById('main'));
    option = {
        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            data:data.legend 
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
        series :data.yAxis
    };
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}
//获取当前日期  时间格式为YYYY-mm-dd
function getNowDate(){
    var date = new Date();
    var seperator = "-";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if(month >=1 && month <=9){
        month = "0" + month;
    }
    if (strDate >=0 && strDate <=9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator + month + seperator + strDate;
    return currentdate;
}