/**
 * 用于上传缓存数据
 */
var keysList = window.android.getKey();
var dailyTabList = new Array();
var checkTabList = new Array();
var reportTabList = new Array();
var transferTabList = new Array();
var troubleTabList = new Array();
var infoList = new Array();
//获取到缓存数据中场所名称，将数据类型和数据放到tableData对象中
for(var key in keysList){
	var tableData = new Object();
	var str = localStorage.getItem(key);
	var data = JSON.parse(str);	//得到JSON格式的缓存数据
	var tableInfo = key.split("+");	//拆分key
	if(tableInfo[1] == "日常检查表"){
		dailyTabList.push(tableInfo[0]);
	}
	if(tableInfo[1] =="营业前检查表"){
		checkTabList.push(tableInfo[0]);
	}
	if(tableInfo[1] =="举报表"){
		reportTabList.push(tableInfo[0]);	
		}
	if(tableInfo[1] =="移交书"){
		transferTabList.push(tableInfo[0]);
	}
	if(tableInfo[1] =="报告书"){
		troubleTabList.push(tableInfo[0]);
	}
	tableData.tableType = tableInfo[1];
	tableData.tableInfo = data;
	infoList.push(tableData);
	//清空数组
	tableInfo.splice(0,tableInfo.length);
}
//上传所有缓存数据
function uploadTableInfo(){
	 
}