/**
 * Created by Broken on 2016/10/20.
 */
function getfiretable(){
    //获取日期
    var startdate= $("#startdate").datebox("getValue");
    var enddate = $("#enddate").datebox("getValue");
    $.ajax({
        url:"getFiretable",
        type:"post",
        datatype:'json',
        data:{startdate:startdate,enddate:enddate},
        error:function(){
            $.message.alert('错误提示！','请求失败，稍后再试！','error');
        },
        success:function(data){
            $('#dg').datagrid({
                title:"表册列表",
                width:'100%',
                height:'auto',
                singleSelect:true,
                fitColumns:true , 		// 数据网格（datagrid）底部显示分页工具栏。
                striped: true ,					//隔行变色特性
                loadMsg: '数据正在加载,请耐心的等待...' ,
                striped:true,
                pagination: true, 		//数据网格（datagrid）底部显示分页工具栏。
                rownumbers:true,		//行号
                data:data.slice(0,10),
                frozenColumns:[[
                    {
                        field:'ck' ,
                        width:50 ,
                        checkbox: true
                    }
                ]],
                columns:[[
                    {
                        field:'firetableid',
                        title:'编号',
                        width:'120',
                        sortable:true
                    },{
                        field:'unitname' ,
                        title:'场所名' ,
                        width:200 ,
                        sortable : true
                    },{
                        field:'address',
                        title:'地址',
                        width:'250',
                        sortable:true
                    },{
                        field:'master',
                        title:'所属',
                        width:'120',
                        sortable:true
                    },
                    {
                        field:'checker',
                        title:'检查人员',
                        width:'120',
                        sortable:true
                    },
                    {
                        field:'checkdate',
                        title:'检查日期',
                        width:'120',
                        sortable:true
                    },
                ]] ,
                toolbar:[{
                    text:'查看',
                    iconCls: 'icon-search',
                    handler: function(){
                        var nodes = $('#dg').datagrid('getSelected');//获得选中行的数据
                        var checkdate = nodes.checkdate;
                        var firetableid = nodes.firetableid;
                        $.ajax({
                            url:'getTableInfo',
                            data:{"checkdate":checkdate,"firetableid":firetableid},
                            dataType:'json',
                            cache:false,
                            type: "get",
                            success:function(data){
                            	var tabInfo = data[0];
                                console.info(tabInfo);
                            	for(var key in tabInfo){
                            		if(tabInfo.hasOwnProperty(key)){
                            			if(tabInfo[key] != null && key != "picture" && document.getElementById(key) != null){
                            				document.getElementById(key).innerHTML = (tabInfo[key]);
                            			}
                            		}
                            	}
                                var top = $("#return_jsp").offset().top;
                                var left = $("#return_jsp").offset().center;
                                $('#return_jsp').window('open').window('resize',{top: top,left:left});
                            },
                            error:function(data){
                                $.message.alert('错误提示！','请求失败，稍后再试！','error');
                            }
                        });
                    },
                }],
            });
            //实现分页
            var pager = $('#dg').datagrid("getPager");
            pager.pagination({
                total:data.length,
                onSelectPage:function(pageNo,pageSize){
                    var start = (pageNo-1)*pageSize;
                    var end = start + pageSize;
                    $('#dg').datagrid("loadData",data.slice(start,end));
                    pager.pagination('refresh',{
                        total:data.length,
                        pageNumber:pageNo
                    });
                }
            });
        }
    });
}
