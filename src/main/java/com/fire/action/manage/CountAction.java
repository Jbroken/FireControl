package com.fire.action.manage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fire.po.PoliceCheckInfo;
import com.fire.po.TestModel;
import com.fire.service.CountService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountAction {

	@Autowired
	CountService countService;

	/**
	 * 场所统计
	 * @return
	 */
	@RequestMapping(value = "getCountUnit")
	public List<TestModel> CountAllUnitByType() {
		return countService.getCountByType();
	}

	/**
	 * 派出所统计
	 * @return
	 */
	@RequestMapping(value = "getPoliceCheckInfo")
	public List<PoliceCheckInfo> getPoliceStationCheckCondition() {
		return countService.getPoliceStationCheckCondition();
	}

}
