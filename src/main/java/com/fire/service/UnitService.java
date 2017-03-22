package com.fire.service;

import java.util.Map;

import com.fire.po.Firetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fire.dao.UnitMapper;
import com.fire.po.UnitTable;

@Service
public class UnitService {
	@Autowired
	UnitMapper unitMapper;

	public int insertExcel(Map<String, String> map) {
		// 将Excel里面的表头转化成数据库字
		map.put("branchid", map.get("分局"));
		map.put("policeid", map.get("派出所"));
		map.put("unitname", map.get("单位名称"));
		map.put("master", map.get("主要负责人"));
		map.put("address", map.get("地址"));
		map.put("unitproperty", map.get("单位性质"));
		map.put("area", map.get("建筑面积"));
		map.put("floors", map.get("建筑层数"));
		map.put("hight", map.get("建筑高度"));
		map.remove("分局");
		map.remove("派出所");
		map.remove("单位名称");
		map.remove("主要负责人");
		map.remove("地址");
		map.remove("单位性质");
		map.remove("建筑面积");
		map.remove("建筑高度");
		map.remove("建筑层数");

		return unitMapper.insertSelective(map);

	}

	public int updateCheckstate(Integer unitid, int checkstate, int checktype) {
		// TODO Auto-generated method stub
		return unitMapper.updateCheckstate(unitid, checkstate, checktype);

	}

	public int updateCheckstate(Firetable firetable) {
		// TODO Auto-generated method stub
		return unitMapper.updateCheckstate(firetable);
	}

	/**
	 * 根据场所id删除场所
	 * @param unitid
	 * @return
	 */
	public int deleteUnitById(int unitid){
		return unitMapper.deleteByPrimaryKey(unitid);
	}

}
