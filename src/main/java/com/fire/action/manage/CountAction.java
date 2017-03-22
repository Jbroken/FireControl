package com.fire.action.manage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fire.po.FiretableAllColumn;
import com.fire.po.PoliceCheckInfo;
import com.fire.po.TestModel;
import com.fire.po.UnitChange;
import com.fire.service.CountService;

@Controller
public class CountAction {

	@Autowired
	CountService countService;

	// 商铺统计
	@RequestMapping(value = "getCountUnit")
	@ResponseBody
	public List<TestModel> CountAllUnitByType() {
		return countService.getCountByType();
	}

	// 问题统计
	@RequestMapping(value = "getProblem")
	@ResponseBody
	public List<FiretableAllColumn> CountTheAllProblem() {
		return countService.getProblemCount();
	}

	// 整改情况查询
	@RequestMapping(value = "unitchange")
	@ResponseBody
	public List<UnitChange> countunitchang() {
		return countService.countunitchange();
	}

	// 派出所检查记录
	@RequestMapping(value = "getPoliceCheckInfo")
	@ResponseBody
	public List<PoliceCheckInfo> getPoliceStationCheckCondition() {
		return countService.getPoliceStationCheckCondition();
	}

}
