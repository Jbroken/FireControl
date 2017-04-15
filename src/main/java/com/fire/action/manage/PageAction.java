package com.fire.action.manage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Broken on 2016/10/21.
 */
@Controller
@RequestMapping(value = "manage")
public class PageAction {
	private static final String DATA_COUNT = "count/";
	private static final String TABLE_CHECK = "check/";
	private static final String ADD_TASK = "task/";

	// 获得场所统计页面
	@RequestMapping(value = "unitCount")
	public String unitCount() {
		return DATA_COUNT + "unitCount";
	}

	// 获得问题统计页面
	@RequestMapping(value = "problemCount")
	public String problemCount() {
		return DATA_COUNT + "problemCount";
	}

	// 获得检查统计页面
	@RequestMapping(value = "checkCount")
	public String checkCount() {
		return DATA_COUNT + "checkCount";
	}

	// 获取整改情况页面
	@RequestMapping(value = "changedCondition")
	public String changedCondition() {
		return DATA_COUNT + "changedCondition";
	}

	// 获取个人检查记录页面
	@RequestMapping(value = "personalCheck")
	public String personalCheck() {
		return DATA_COUNT + "personalCheck";
	}

	// 获取派出所检查记录
	@RequestMapping(value = "policeCheck")
	public String policeCheck() {
		return DATA_COUNT + "policeCheck";
	}

	// 获取按场所查询表册页面
	@RequestMapping(value = "checktable_byunit")
	public String checkTableByUnit() {
		return TABLE_CHECK + "checktable_byunit";
	}

	// 获取按时间查询表册页面
	@RequestMapping(value = "checktable_bytime")
	public String checkTableByTime() {
		return TABLE_CHECK + "checktable_bytime";
	}

	// 获取发布周期页面
	@RequestMapping(value = "addTask")
	public String addTask() {
		return ADD_TASK + "addTask";
	}

	// 获取修改周期页面
	@RequestMapping(value = "updateTask")
	public String updateTask() {
		return ADD_TASK + "updateTask";
	}

	//返回登陆页面
	@RequestMapping(value = "returnLogin")
	public String returnLogin(){
		return "manage/login_new";
	}
}
