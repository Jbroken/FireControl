/**
 * 树形JS
 * 
 */
$('#tt').tree({
		url:'getTree',
		checkbox:true,
		onBeforeExpand:function(node){
			if(node.attributes=="branch"){
				//根据分局ID得到派出所信息
				$('#tt').tree('options').url = "getTree?branchid="+node.id;
			}
			else if (node.attributes=="police") {
				//根据派出所ID得到商铺信息
				$('#tt').tree('options').url = "getTree?policeid="+node.id;
			}
		},
		onLoadSuccess:function(node){
			getRoot();//数据加载成功时触发
		},
		onCheck:function(node){
			getRoot();//点击复选框时触发
		}
	});