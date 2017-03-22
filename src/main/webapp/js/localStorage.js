//查询浏览器是否可以使用localStorage
//页面缓存机制
if(window.localStorage){
	//储存页面内容,以JSON格式保存
	function saveSettings(){
		var data = new Object();
		$("input:text").each(function(){
			data[this.name] = this.value;
    	});
		$("input:hidden").each(function(){
			data[this.name] = this.value;
    	});
    		    		
    	$("input:radio:checked").each(function(){
    		data[this.name] = this.value;
    	});
    		
    	$("input:checkbox:checked").each(function(){
    		data[this.name] = this.value;
    	});
    	
    	var str = JSON.stringify(data);
    	
    	localStorage.setItem(str.unitname+"+"+str.tableType,str);
    	console.info(localStorage)
    	location.hash = '#list';
    	
    }
	function findStorage(){
		var find = document.getElementById("find").value;
		var str = localStorage.getItem(find);
		var data = JSON.parse(str);
		alert(data.address);
	}
	//清除缓存
	function clearStorage() {
		localStorage.clear();
		localStorage('msg');
	}
}