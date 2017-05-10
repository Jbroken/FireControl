package com.fire.service;

import com.fire.dao.UserMapper;
import com.fire.po.PoliceStation;
import com.fire.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fire.dao.FiretableMapper;
import com.fire.dao.PoliceMapper;
import com.fire.dao.TaskMapper;
import com.fire.po.Police;
import com.fire.po.PoliceInfo;
import com.fire.utils.DivisionUtil;

import java.util.List;

@Service
public class PoliceManageService {

	@Autowired
	PoliceMapper policeMapper;
	@Autowired
	UserMapper userMapper;

	public PoliceInfo findPoliceByName(String tel) {

		PoliceInfo police = policeMapper.selectPoliceByName(tel);

		// 商铺总数
		int unitConut = police.getUnitCount();
		// 已检查总数
		Integer CheckCount = police.getNoCheckCount();

		if(CheckCount == null){
			CheckCount = 0;
		}

		// 覆盖率=被检查数/商铺总数
		String CoverageRate = DivisionUtil.Division(CheckCount, unitConut);

		police.setCoverageRate(CoverageRate);

		return police;

	}

    public List<PoliceStation> getPoliceStationList() {
        return policeMapper.getPoliceStationList();
    }

    public List<User> getPoliceList() {
        return userMapper.getPoliceList();
    }
}
