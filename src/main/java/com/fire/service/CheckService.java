package com.fire.service;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fire.dao.CheckrecordMapper;
import com.fire.dao.FiretableMapper;
import com.fire.dao.PictureMapper;
import com.fire.dao.TaskMapper;
import com.fire.dao.UnitMapper;
import com.fire.po.CheckData;
import com.fire.po.Checkrecord;
import com.fire.po.Firetable;
import com.fire.po.FiretableInformation;
import com.fire.po.Picture;
import com.fire.po.Task;
import com.fire.po.TreeModel;
import com.fire.po.UnitChildren;
import com.fire.po.UnitInformation;
import com.fire.po.UnitMasterInfo;
import com.fire.po.UnitType;
import com.fire.po.Unitname;
import com.fire.utils.DateUtil;

@Service
public class CheckService {

	@Autowired
	FiretableMapper firetableMapper;
	@Autowired
	UnitMapper unitMapper;
	@Autowired
	TaskMapper taskMapper;
	@Autowired
	CheckrecordMapper checkrecordMapper;
	@Autowired
	PictureMapper pictureMapper;

	public List<UnitInformation> queryBranch() {
		// TODO Auto-generated method stub

		return firetableMapper.SelectBranch();
	}

	public List<UnitInformation> queryPolice(Integer branchid) {

		return firetableMapper.SelectPolice(branchid);
	}

	public List<UnitInformation> queryInformation(Integer policeid) {

		return firetableMapper.SelectInformation(policeid);
	}

	/**
	 * 得到分局信息,通过循环将每组数据的状态设置为closed；
	 * 为分局信息添加一个附属属性,便于前台通过判断得到派出所信息；
	 * @param
	 * 
	 */
	public List<TreeModel> getTree() {
		// TODO Auto-generated method stub
		List<TreeModel> tree = firetableMapper.getTree();
		for (int i = 0; i < tree.size(); i++) {
			tree.get(i).setState("closed");
			tree.get(i).setAttributes("branch");
		}
		return tree;
	}

	/**
	 * 根据分局id得到派出所信息,通过循环 ，将每组数据的状态设置为closed
	 * 为派出所信息添加一个附属属性 ，便于前台通过判断得到派商铺信息；
	 * @param branchid
	 *
	 * 
	 */
	public List<TreeModel> getpolicename(Integer branchid) {
		List<TreeModel> tree = firetableMapper.getpolicename(branchid);
		for (int i = 0; i < tree.size(); i++) {
			tree.get(i).setState("closed");
			tree.get(i).setAttributes("police");
		}
		return tree;
	}

	/**
	 * 根据派出所id得到商铺信息,通过循环将每组数据的状态设为open
	 * 为商铺信息添加一个附属属性，便于前台通过判断得到被选中的商铺信息
	 * @param  policeid
	 *
	 */
	public List<TreeModel> getunit(Integer policeid) {
		// TODO Auto-generated method stub
		List<TreeModel> tree = firetableMapper.getunit(policeid);
		for (int i = 0; i < tree.size(); i++) {
			tree.get(i).setState("open");
			tree.get(i).setAttributes("unit");
		}
		return tree;
	}

	/**
	 * 常规检查
	 * @param policestation
     * @return
	 */
	public JSONObject findDailyCheck(String policestation) {
		// TODO Auto-generated method stub
		// 由派出所得到该派出所下的所有商铺类型
		List<UnitChildren> unitType = unitMapper.getType(policestation);
		JSONObject jsonObject = new JSONObject();
		JSONObject jObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();

		for (int i = 0; i < unitType.size(); i++) {
			// 根据派出所名称和商铺类型得到商铺信息
			List<UnitType> unitInformation = unitMapper.getUnit(policestation,
					unitType.get(i).getType());
			// 计算剩余天数
			for (int j = 0; j < unitInformation.size(); j++) {

				String nowDate = DateUtil.getNowDate();

				String endDate = DateUtil.getSpecifiedDayAfter(unitInformation
						.get(j).getSetTime(), unitInformation.get(j)
						.getTasktime());// 最后期限
				// 如果超期就为负数
				long day = DateUtil.minusDate(endDate, nowDate);
				unitInformation.get(j).setDay(day);
			}
			// 判断商铺是否存在
			if (unitInformation.size() > 0) {

				// 得到商铺类型
				jsonObject.put("type", unitType.get(i).getType());
				// 得到改商铺类型下所有商铺
				jsonObject.put("children", unitInformation);

				jsonArray.add(jsonObject);
			}
		}
		jObject.put("result", jsonArray);
		return jObject;
	}

	public List<UnitMasterInfo> getUnitInformation(int unitid) {
		// TODO Auto-generated method stub
		return unitMapper.getUnitInformation(unitid);
	}


	public List<CheckData> getCheckdateById(Integer unitid) {
		// TODO Auto-generated method stub
		return firetableMapper.getCheckdateById(unitid);
	}

	public List<FiretableInformation> findtableById(String firetableid) {
			List<FiretableInformation> tableInfo = firetableMapper.getTableById(firetableid);
			try {
				List<Picture> picture = pictureMapper.findPictureById(firetableid);
				if(picture != null){
					tableInfo.get(0).setPicture(picture);
				}
				return tableInfo;
			} catch (Exception e) {
				// TODO: handle exception
				return tableInfo;
			}
		}
	
	public int UploadCheckRecord(Firetable firetable) {
		// TODO Auto-generated method stub
		return firetableMapper.insert(firetable);
	}

	public int uploadBusinessInfor(Checkrecord checkrecord) {
		// TODO Auto-generated method stub
		return checkrecordMapper.insert(checkrecord);
	}

	/***
	 * 整改检查
	 * 
	 * @param policestation
	 * @return
	 */
	public JSONObject findRectifyCheck(String policestation) {
		// TODO Auto-generated method stub
		// 由派出所得到该派出所下的所有商铺类型
		List<UnitChildren> unitType = unitMapper.getType(policestation);
		JSONObject jsonObject = new JSONObject();
		JSONObject jObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		for (int i = 0; i < unitType.size(); i++) {
			List<UnitType> unitInformation = unitMapper.getRectifyCheckInfo(
                    policestation, unitType.get(i).getType());
			// 判断商铺是否存在
			if (unitInformation.size() > 0) {
				// 得到商铺类型
				jsonObject.put("type", unitType.get(i).getType());
				// 得到该商铺类型下所有商铺
				jsonObject.put("children", unitInformation);

				jsonArray.add(jsonObject);
			}
		}
		jObject.put("result", jsonArray);
		return jObject;
	}

	/***
	 * 举报检查
	 * 
	 * @param policestation
     * @return
	 */
	public JSONObject findReportCheck(String policestation) {
		// TODO Auto-generated method stub
		// 由派出所得到该派出所下的所有商铺类型
		List<UnitChildren> unitType = unitMapper.getType(policestation);
		JSONObject jsonObject = new JSONObject();
		JSONObject jObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		for (int i = 0; i < unitType.size(); i++) {
			List<UnitType> unitInformation = unitMapper.getReportCheck(
                    policestation, unitType.get(i).getType());
			if (unitInformation.size() > 0) {
				// 得到商铺类型
				jsonObject.put("type", unitType.get(i).getType());
				// 得到改商铺类型下所有商铺
				jsonObject.put("children", unitInformation);

				jsonArray.add(jsonObject);
			}
		}
		jObject.put("result", jsonArray);
		return jObject;
	}

	public List<Task> selectTaskTime(Integer unitid) {
		// TODO Auto-generated method stub
		return taskMapper.selectTaskTime(unitid);
	}

	public Object updateSetTime(String nowDate, Integer unitid) {
		// TODO Auto-generated method stub
		return taskMapper.updateSetTime(nowDate, unitid);
	}

	public List<Unitname> checkUnitname(String unitname) {
		// TODO Auto-generated method stub
		return unitMapper.checkUnitname(unitname);
	}

	public List<UnitInformation> CheckUnitnameCondition(String unitname) {
		// TODO Auto-generated method stub
		return firetableMapper.getTableByunit(unitname);
	}

}
