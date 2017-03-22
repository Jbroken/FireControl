var myloader = function(param,success,error){
        var q = param.q || '';          
        if (q.length <=0) {
            return false;  
        } 
        else {
            $.ajax({
                url: 'checkUnitname',
                type: "POST",
                dataType: 'json',
                data: {'unitname': q},
                success: function(data){                        
                    var items = $.each(data, function(value){      
                        return value;
                    }); 
                    success(items);
                }
            });
        }
    };
	function getTableByUnit(){
	var unitname = $("#unitname").combobox('getValue');
	$.ajax({
		url:"getTableByUnitname",
		type:"POST", 
	 	data:{"unitname":unitname},
	 	error:function(errorMeg){
	 		alert("数据加载异常，请重试！");
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
								title:'id' ,
								hidden:true
							},{
								field:'unmber',
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
									var unitid = nodes.unitid;
										$.ajax({
											url:'getTableInfo',
											data:{"checkdate":checkdate,"unitid":unitid},
											dataType:'json',
											cache:false,
											type: "get",
											success:function(data){
												var tabInfo = data;
												for (var i = 0; i < tabInfo.length; i++) {
													//用Jquery初始化复选框
													if(tabInfo.length>0){
														$(":checkbox").attr("name","init")
														$("input[name='init']").attr("checked",false);  
													}
													if(tabInfo[i].unitid != null){
														document.getElementById("unitid").innerHTML = (tabInfo[i].unitid);
													}
													if(tabInfo[i].firetableid != null){
														document.getElementById("firetableid").innerHTML = (tabInfo[i].firetableid);
													}
													if(tabInfo[i].unitname != null){
														document.getElementById("unitname").innerHTML = (tabInfo[i].unitname);
													}
													if(tabInfo[i].master != null){
														document.getElementById("master").innerHTML = (tabInfo[i].master);
													}
													if(tabInfo[i].address != null){
														document.getElementById("address").innerHTML = (tabInfo[i].address);
													}
													if(tabInfo[i].unitproperty != null){
														document.getElementById("unitproperty").innerHTML = (tabInfo[i].unitproperty);
													}
													if(tabInfo[i].area != null){
														document.getElementById("area").innerHTML = (tabInfo[i].area);
													}
													if(tabInfo[i].floors != null){
														document.getElementById("floors").innerHTML = (tabInfo[i].floors);
													}
													if(tabInfo[i].hight != null){
														document.getElementById("hight").innerHTML = (tabInfo[i].hight);
													}
													if(tabInfo[i].checker != null){
														document.getElementById("checker").innerHTML = (tabInfo[i].checker);
													}
													if(tabInfo[i].otherchecker != null){
														document.getElementById("otherchecker").innerHTML = (tabInfo[i].otherchecker);
													}
													if(tabInfo[i].checkdate != null){
														document.getElementById("checkdate").innerHTML = (tabInfo[i].checkdate);
													}
													if(tabInfo[i].buildingname != null){
														document.getElementById("buildingname").innerHTML = (tabInfo[i].buildingname);
													}
													if(tabInfo[i].legal==0){
														document.getElementById("legal0").checked = true;
													}
													if(tabInfo[i].legal==1){
														document.getElementById("legal1").checked = true;
													}
													if(tabInfo[i].legal==2){
														document.getElementById("legal2").checked = true;
													}
													if(tabInfo[i].publicplace == 0){
														document.getElementById("publicplace0").checked = true;
													}
													if(tabInfo[i].publicplace == 1){
														document.getElementById("publicplace1").checked = true;
													}
													if(tabInfo[i].safecheck == 0){
														document.getElementById("safecheck0").checked = true;
													}
													if(tabInfo[i].safecheck == 1){
														document.getElementById("safecheck1").checked = true;
													}
													if(tabInfo[i].securitysystem == 0){
														document.getElementById("securitysystem0").checked = true;
													}
													if(tabInfo[i].securitysystem== 1){
														document.getElementById("securitysystem1").checked = true;
													}
													if(tabInfo[i].safetyeducation == 0){
														document.getElementById("safetyeducation0").checked = true;
													}
													if(tabInfo[i].safetyeducation == 1){
														document.getElementById("safetyeducation1").checked = true;
													}
													if(tabInfo[i].firecheck == 0){
														document.getElementById("firecheck0").checked = true;
													}
													if(tabInfo[i].firecheck0 == 1){
														document.getElementById("firecheck1").checked = true;
													}
													if(tabInfo[i].othercondition1 != null){
														document.getElementById("othercondition1").innerHTML = (tabInfo[i].othercondition1);
													}
													if(tabInfo[i].fireexit == 0){
														document.getElementById("fireexit0").checked = true;
													}
													if(tabInfo[i].fireexit == 1){
														document.getElementById("fireexit1").checked = true;
													}
													if(tabInfo[i].fireexit == 2){
														document.getElementById("fireexit2").checked = true;
													}
													if(tabInfo[i].evacuation == 0){
														document.getElementById("evacuation0").checked = true;
													}
													if(tabInfo[i].evacuation == 1){
														document.getElementById("evacuation1").checked = true;
													}
													if(tabInfo[i].evacuation == 2){
														document.getElementById("evacuation2").checked = true;
													}
													if(tabInfo[i].export == 0){
														document.getElementById("export0").checked = true;
													}
													if(tabInfo[i].export == 1){
														document.getElementById("export1").checked = true;
													}
													if(tabInfo[i].export == 2){
														document.getElementById("export2").checked = true;
													}
													if(tabInfo[i].firedoors == 0){
														document.getElementById("firedoors0").checked = true;
													}
													if(tabInfo[i].firedoors == 1){
														document.getElementById("firedoors1").checked = true;
													}
													if(tabInfo[i].firedoors == 2){
														document.getElementById("firedoors2").checked = true;
													}
													if(tabInfo[i].firedoors == 3){
														document.getElementById("firedoors3").checked = true;
													}
													if(tabInfo[i].sign == 0){
														document.getElementById("sign0").checked = true;
													}
													if(tabInfo[i].sign == 1){
														document.getElementById("sign1").checked = true;
													}
													if(tabInfo[i].sign == 2){
														document.getElementById("sign2").checked = true;
													}
													if(tabInfo[i].sign == 3){
														document.getElementById("sign3").checked = true;
													}
													if(tabInfo[i].emergencylighting == 0){
														document.getElementById("emergencylighting0").checked = true;
													}
													if(tabInfo[i].emergencylighting == 1){
														document.getElementById("emergencylighting1").checked = true;
													}
													if(tabInfo[i].emergencylighting == 2){
														document.getElementById("emergencylighting2").checked = true;
													}
													if(tabInfo[i].emergencylighting == 3){
														document.getElementById("emergencylighting3").checked = true;
													}
													if(tabInfo[i].obstacle == 0){
														document.getElementById("obstacle0").checked = true;
													}
													if(tabInfo[i].obstacle == 1){
														document.getElementById("obstacle1").checked = true;
													}
													if(tabInfo[i].othercondition2 != null){
														document.getElementById("othercondition2").innerHTML = (tabInfo[i].othercondition2);
													}
													if(tabInfo[i].firehydrant == 0){
														document.getElementById("firehydrant0").checked = true;
													}
													if(tabInfo[i].firehydrant == 1){
														document.getElementById("firehydrant1").checked = true;
													}
													if(tabInfo[i].firehydrant == 2){
														document.getElementById("firehydrant2").checked = true;
													}
													if(tabInfo[i].firehydrant == 3){
														document.getElementById("firehydrant3").checked = true;
													}
													if(tabInfo[i].extinguisher == 0){
														document.getElementById("extinguisher0").checked = true;
													}
													if(tabInfo[i].extinguisher == 1){
														document.getElementById("extinguisher1").checked = true;
													}
													if(tabInfo[i].extinguisher == 2){
														document.getElementById("extinguisher2").checked = true;
													}
													if(tabInfo[i].firefacilities == 0){
														document.getElementById("firefacilities0").checked = true;
													}
													if(tabInfo[i].firefacilities == 1){
														document.getElementById("firefacilities1").checked = true;
													}
													if(tabInfo[i].firefacilities == 2){
														document.getElementById("firefacilities2").checked = true;
													}
													if(tabInfo[i].firefacilities == 3){
														document.getElementById("firefacilities3").checked = true;
													}
													if(tabInfo[i].firefacilities == 4){
														document.getElementById("firefacilities4").checked = true;
													}
													if(tabInfo[i].maintain == 0){
														document.getElementById("maintain0").checked = true;
													}
													if(tabInfo[i].maintain == 1){
														document.getElementById("maintain1").checked = true;
													}
													if(tabInfo[i].maintain == 2){
														document.getElementById("maintain2").checked = true;
													}
													if(tabInfo[i].flame == 0){
														document.getElementById("flame0").checked = true;
													}
													if(tabInfo[i].flame == 1){
														document.getElementById("flame1").checked = true;
													}
													if(tabInfo[i].flame == 2){
														document.getElementById("flame2").checked = true;
													}
													if(tabInfo[i].explosive == 0){
														document.getElementById("explosive0").checked = true;
													}
													if(tabInfo[i].explosive == 1){
														document.getElementById("explosive1").checked = true;
													}
													if(tabInfo[i].explosive == 2){
														document.getElementById("explosive2").checked = true;
													}
													if(tabInfo[i].live == 0){
														document.getElementById("live0").checked = true;
													}
													if(tabInfo[i].live == 1){
														document.getElementById("live1").checked = true;
													}
													if(tabInfo[i].administrator == 0){
														document.getElementById("administrator0").checked = true;
													}
													if(tabInfo[i].administrator == 1){
														document.getElementById("administrator1").checked = true;
													}
													if(tabInfo[i].worksystem == 0){
														document.getElementById("worksystem0").checked = true;
													}
													if(tabInfo[i].worksystem == 1){
														document.getElementById("worksystem1").checked = true;
													}
													if(tabInfo[i].convention == 0){
														document.getElementById("convention0").checked = true;
													}
													if(tabInfo[i].convention == 1){
														document.getElementById("convention1").checked = true;
													}
													if(tabInfo[i].propaganda == 0){
														document.getElementById("propaganda0").checked = true;
													}
													if(tabInfo[i].propaganda == 1){
														document.getElementById("propaganda1").checked = true;
													}
													if(tabInfo[i].firepatrol == 0){
														document.getElementById("firepatrol0").checked = true;
													}
													if(tabInfo[i].firepatrol == 1){
														document.getElementById("firepatrol1").checked = true;
													}
													if(tabInfo[i].fireequipment == 0){
														document.getElementById("fireequipment0").checked = true;
													}
													if(tabInfo[i].fireequipment == 1){
														document.getElementById("fireequipment1").checked = true;
													}
													if(tabInfo[i].firegroup == 0){
														document.getElementById("firegroup0").checked = true;
													}
													if(tabInfo[i].firegroup == 1){
														document.getElementById("firegroup1").checked = true;
													}
													if(tabInfo[i].term == 1){
														document.getElementById("term1").checked = true;
													}
													if(tabInfo[i].term == 2){
														document.getElementById("term2").checked = true;
													}
													if(tabInfo[i].term == 3){
														document.getElementById("term3").checked = true;
													}
													if(tabInfo[i].legalnamenumber != null){
														document.getElementById("legalnamenumber").innerHTML = (tabInfo[i].legalnamenumber);
													}
													if(tabInfo[i].remarks != null){
														document.getElementById("remarks").innerHTML = (tabInfo[i].remarks);
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