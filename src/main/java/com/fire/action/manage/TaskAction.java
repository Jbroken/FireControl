package com.fire.action.manage;

import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fire.po.Task;
import com.fire.po.UnitListForm;
import com.fire.po.Unitid;
import com.fire.service.TaskService;

@Controller
public class TaskAction {
	@Autowired
	TaskService taskService;

	/**
	 * 
	 * @param 对树形中选中的商铺进行检查周期发布
	 */
	@RequestMapping("addTime")
	@ResponseBody
	public JSONObject ReleaseTask(UnitListForm unitidform) {
		JSONObject jsonObject = new JSONObject();
		for (Unitid unitid : unitidform.getUnitid()) {
			taskService.addTasktime(unitid);
		}
		jsonObject.put("result", "success");
		return jsonObject;
	}

	// 得到周期具体信息
	@RequestMapping("getTaskInfo")
	@ResponseBody
	public List<Task> getTaskInfo() {
		List<Task> task = taskService.getTaskInfo();
		return task;
	}

	// 修改周期
	@RequestMapping(value = "updateTaskInfo")
	@ResponseBody
	public Object updateTaskInfo(String settime, int tasktime, int taskid) {
		return taskService.updateTaskInfo(settime, tasktime, taskid);
	}

	// 删除周期
	@RequestMapping("delTaskInfo")
	@ResponseBody
	public int delTaskInfo(int taskid) {
		return taskService.delTaskInfo(taskid);
	}
}
