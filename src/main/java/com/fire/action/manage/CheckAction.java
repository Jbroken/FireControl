package com.fire.action.manage;

import java.util.Date;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fire.po.FiretableInformation;
import com.fire.po.PersonalCondition;
import com.fire.po.PoliceStInfo;
import com.fire.po.PolicestationList;
import com.fire.po.Policestationid;
import com.fire.po.TreeModel;
import com.fire.po.UnitInformation;
import com.fire.po.Unitname;
import com.fire.service.CheckService;
import com.fire.service.CountService;
import com.fire.utils.StringToDate;

@Controller
public class CheckAction {
	@Autowired
	CheckService checkService;
	@Autowired
	CountService countService;

	/**
	 * 按时间格式来查询检查情况
	 * @param datetype
	 * @param startdate
	 * @param enddate
	 * @return
	 */
	@RequestMapping(value = "gettimes")
	@ResponseBody
	public JSONObject gettimes(int datetype, String startdate, String enddate) {
		Date startDate = StringToDate.singleDate(startdate);
		Date endDate = StringToDate.singleDate(enddate);
		if (datetype == 1) {
			// 按周查询
			return countService.getSingleUnitCheckTimesByCategory(startDate,endDate);
		} 
			// 按月查询
		return countService.getunitbydate(startDate,endDate);
	}

	/**
	 * 分区查询商铺信息
	 * @param branchid
	 * @param policeid
	 * @return
	 */
	@RequestMapping(value = "getInformation")
	@ResponseBody
	public List<UnitInformation> CheckStation(Integer branchid, Integer policeid) {
		// 得到分局信息
		if (branchid == null && policeid == null) {
			return checkService.queryBranch();
		}  
		if (policeid == null) {
			// 根据分局ID得到派出所信息
			return checkService.queryPolice(branchid);
		}
		// 根据派出ID得到商铺信息
		return checkService.queryInformation(policeid);
	}

	/**
	 * 异步加载数据，得到树形
	 * @param branchid
	 * @param policeid
	 * @return
	 */
	@RequestMapping(value = "getTree")
	@ResponseBody
	public List<TreeModel> getTree(Integer branchid, Integer policeid) {
		if (branchid == null && policeid == null) {
			// 得到分局信息
			List<TreeModel> unitList = checkService.getTree();
			return unitList;
		}
		if (policeid == null) {
			// 根据分局id，得到对应的派出所信息
			List<TreeModel> unitList = checkService.getpolicename(branchid);
			return unitList;
		} 
			// 根据派出所id，得到对应的商铺信息
			List<TreeModel> unitList = checkService.getunit(policeid);
			return unitList;
	}

	/**
	 * 按时间查询消防表册
	 * @param startdate
	 * @param enddate
	 * @return
	 */
	@RequestMapping(value = "getFiretable")
	@ResponseBody
	public List<UnitInformation> checkFiretable(String startdate, String enddate) {
		return countService.checkFiretableByTime(
				StringToDate.singleDate(startdate),
				StringToDate.singleDate(enddate));
	}

	// 模糊查询场所
	@RequestMapping(value = "checkUnitname")
	@ResponseBody
	public List<Unitname> checkUnitname(String unitname) {
		return checkService.checkUnitname(unitname);
	}

	// 查询个人检查情况
	@RequestMapping(value = "/getPersonal")
	@ResponseBody
	public List<PersonalCondition> countPersonal(String checker,int userid) {
		return countService.CheckPersonalCondition(checker,userid);
	}

	// 根据场所得到表册列表
	@RequestMapping(value = "getTableByUnitname")
	@ResponseBody
	public List<UnitInformation> getUnitCondition(String unitname) {
		return checkService.CheckUnitnameCondition(unitname);
	}

	// 根据场所检查日期和场所ID得到具体的场所信息
	@RequestMapping(value = "getTableInfo")
	@ResponseBody
	public List<FiretableInformation> getTableInfo(String checkdate, String firetableid) {
		return checkService.findtableById(firetableid);
	}
	/**
	 * 数据类型data_type：默认为覆盖率，
	 * 时间end_time：默认为当前时间，
	 * 个数number：默认为10个，
	 * 时间单位date_type：默认为天
	 * @param policestationList 查看派出所检查记录的实体类
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "getPoliceStInfo")
	@ResponseBody
	public JSONObject getPoliceStInfo(PolicestationList policestationList){		
		JSONObject result = new JSONObject();
		JSONObject series = new JSONObject();
		JSONArray PoliceStationList = new JSONArray();
		JSONArray dataList = new JSONArray();
		JSONArray allSeries = new JSONArray();
		SortedSet<String> dateList = new TreeSet<String>();
		for(Policestationid policeid : policestationList.getPolicestationid()){			
			List<PoliceStInfo> PoliceCheckInfo= countService.getPoliceStInfo(policestationList,policeid);
			PoliceStationList.add(PoliceCheckInfo.get(0).getPoliceStation());	//得到派出所列表
			if(policestationList.getDatatype().equals("1")){		//得到检查覆盖率的数据
				for(int i=0;i<PoliceCheckInfo.size();i++){
					dataList.add(PoliceCheckInfo.get(i).getCoverage());//得到覆盖率
					dateList.add(PoliceCheckInfo.get(i).getTime());	//得到日期列表
				}
			}
			else {		//得到表册检查数据
				for(int i=0;i<PoliceCheckInfo.size();i++){
					dataList.add(PoliceCheckInfo.get(i).getTablesum());
					dateList.add(PoliceCheckInfo.get(i).getTime());
				}
			}
			series.put("name", PoliceCheckInfo.get(0).getPoliceStation());
			series.put("type", "bar");
			series.put("data", dataList);
			allSeries.add(series);
			dataList.clear();
		}
		result.put("legend", PoliceStationList);
		result.put("xAxis", dateList);
		result.put("yAxis", allSeries);
	return result;
	}
}
