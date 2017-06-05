package com.fire.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fire.dao.FiretableMapper;
import com.fire.dao.UnitMapper;
import com.fire.po.PersonalCondition;
import com.fire.po.PoliceCheckInfo;
import com.fire.po.PoliceStInfo;
import com.fire.po.PolicestationList;
import com.fire.po.Policestationid;
import com.fire.po.SingleUnit;
import com.fire.po.TestModel;
import com.fire.po.UnitInformation;
import com.fire.utils.DivisionUtil;
import com.fire.utils.StringToDate;
import com.fire.utils.DateUtil;

@Service
public class CountService {
	@Autowired
	FiretableMapper firetableMapper;
	@Autowired
	UnitMapper unitMapper;

	// 得到各类商铺的总数
	public List<TestModel> getCountByType() {

		return unitMapper.queryCountByType();
	}

	public JSONObject getSingleUnitCheckTimesByCategory(Date date1, Date date2) {

		List<SingleUnit> singleUnit = unitMapper.getSingleUnitCheckTimesByCategory(date1, date2);
		// 无重复的数组
		Set<String> name = new HashSet<String>();
		SortedSet<String> time = new TreeSet<String>();
		for (int i = 0; i < singleUnit.size(); i++) {
			name.add(singleUnit.get(i).getCategory());
			time.add(singleUnit.get(i).getWeek());
		}
		List<String> time1 = new ArrayList<String>(time);
		JSONArray count = new JSONArray();
		JSONArray data = new JSONArray();
		JSONObject series = new JSONObject();
		JSONObject result = new JSONObject();
		// 将count初始化为长度与time相同的全为0的数组；
		for (int i = 0; i < time1.size(); i++) {
			count.add(i, "0");
		}
		Iterator<String> it = name.iterator();
		try {
			while (it.hasNext()) {
				String name1 = it.next();
				for (int j = 0; j < singleUnit.size(); j++) {
					if (singleUnit.get(j).getCategory().equals(name1)) {
						Integer a = time1.indexOf(singleUnit.get(j).getWeek());
						count.set(a, singleUnit.get(j).getCount());
					}
				}
				series.put("name", name1);
				series.put("type", "bar");
				series.put("data", count);
				data.add(series);
				count.clear();
				for (int i = 0; i < time1.size(); i++) {
					count.add(i, "0");
				}
			}
			result.put("legend", name);
			result.put("xAxis", time1);
			result.put("yAxis", data);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		return result;
	}

	public JSONObject getunitbydate(Date date1, Date date2) {

		List<SingleUnit> singleUnit = unitMapper.getunitbydate(date1, date2);
		// 无重复的数组
		Set<String> name = new HashSet<String>();
		SortedSet<String> time = new TreeSet<String>();
		for (int i = 0; i < singleUnit.size(); i++) {
			name.add(singleUnit.get(i).getCategory());
			time.add(singleUnit.get(i).getWeek());
		}
		List<String> time1 = new ArrayList<String>(time);
		JSONArray count = new JSONArray();
		JSONArray data = new JSONArray();
		JSONObject series = new JSONObject();
		JSONObject result = new JSONObject();
		// 将count初始化为长度与time相同的全为0的数组；
		for (int i = 0; i < time1.size(); i++) {
			count.add(i, "0");
		}
		Iterator<String> it = name.iterator();
		try {
			while (it.hasNext()) {
				String name1 = it.next();
				for (int j = 0; j < singleUnit.size(); j++) {
					if (singleUnit.get(j).getCategory().equals(name1)) {
						Integer a = time1.indexOf(singleUnit.get(j).getWeek());
						count.set(a, singleUnit.get(j).getCount());
					}
				}
				series.put("name", name1);
				series.put("type", "bar");
				series.put("data", count);
				data.add(series);
				count.clear();
				for (int i = 0; i < time1.size(); i++) {
					count.add(i, "0");
				}
			}
			result.put("legend", name);
			result.put("xAxis", time1);
			result.put("yAxis", data);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		return result;
	}

	public List<PersonalCondition> CheckPersonalCondition(String checker, int userid) {
		// TODO Auto-generated method stub
		if(checker != null && checker.length()>0){
			return firetableMapper.CountPersonalByChecker(checker);
		}

		return firetableMapper.CountPersonalByUserid(userid);
	}

	public List<UnitInformation> checkFiretableByTime(Date date1, Date date2) {
		// TODO Auto-generated method stub
		return firetableMapper.getFiretableBytime(date1, date2);
	}

	public List<PoliceCheckInfo> getPoliceStationCheckCondition() {
		// TODO Auto-generated method stub
		List<PoliceCheckInfo> policeCheckInfo = unitMapper.selectPoliceStationCheckCondition();
		for (int i = 0; i < policeCheckInfo.size(); i++) {
			if(policeCheckInfo.get(i).getCheckunitsum() == null){
				policeCheckInfo.get(i).setCheckunitsum(0);
			}
			String coverage = DivisionUtil.Division(policeCheckInfo.get(i)
					.getCheckunitsum(), policeCheckInfo.get(i).getUnitsum());
			policeCheckInfo.get(i).setCoverage(coverage);
		}
		return policeCheckInfo;
	}
	/**
	 * Datetype 1、2、3 分别表示时间类型为 天、周、月
	 * @param policestationList
	 * @param policeid
	 * @return
	 */
	public List getPoliceStInfo(PolicestationList policestationList, Policestationid policeid) {
		// TODO Auto-generated method stub
		List<PoliceStInfo> policeCheckInfos;
		List<PoliceCheckInfo> unitsum= firetableMapper.getUnitSum(policeid);
		if(policestationList.getDatetype().equals("1")){
			//根据结束日期和天数，得到日期列表
			List<String> dateList = new ArrayList<String>();
			for(int i=Integer.valueOf(policestationList.getNumber())-1;i>0;i--){
				String date = DateUtil.date(policestationList.getEnddate(),i);
				dateList.add(date);
			}
			dateList.add(policestationList.getEnddate());
			List<PoliceStInfo> Info = new ArrayList<PoliceStInfo>();
			for (String day : dateList) {
				PoliceStInfo policeCheckInfo = firetableMapper.getPoliceStInfoByDay(StringToDate.singleDate(day),policeid);
				policeCheckInfo.setTime(day);
				Info.add(policeCheckInfo);
			}
			return Info;
		}
		//按周查询派出所检查情况
		if (policestationList.getDatetype().equals("2")) {
			policeCheckInfos = firetableMapper.getPoliceStInfoByWeek(StringToDate.singleDate(policestationList.getEnddate()),policestationList.getNumber(),policeid);
			for (int i = 0; i < policeCheckInfos.size(); i++) {
				String coverage = DivisionUtil.ReturnDecimals(Integer.valueOf(policeCheckInfos.get(i).getTablesum()),unitsum.get(0).getUnitsum());//得出覆盖率 =表册数/场所总数
				policeCheckInfos.get(i).setCoverage(coverage);
				policeCheckInfos.get(i).setUnitsum(unitsum.get(0).getUnitsum());
			}
			return policeCheckInfos;
		}
		//按月查询派出所检查情况
		policeCheckInfos = firetableMapper.getPoliceStInfoByMouth(StringToDate.singleDate(policestationList.getEnddate()),policestationList.getNumber(),policeid);
		for (int i = 0; i < policeCheckInfos.size(); i++) {
			String coverage = DivisionUtil.ReturnDecimals(Integer.valueOf(policeCheckInfos.get(i).getTablesum()),unitsum.get(0).getUnitsum());//得出覆盖率 =表册数/场所总数
			policeCheckInfos.get(i).setCoverage(coverage);
			policeCheckInfos.get(i).setUnitsum(unitsum.get(0).getUnitsum());
		}
		return policeCheckInfos;
	}

}
