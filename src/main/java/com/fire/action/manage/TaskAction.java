package com.fire.action.manage;

import java.util.List;

import com.fire.po.Unitid;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fire.po.Task;
import com.fire.po.UnitListForm;
import com.fire.service.TaskService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskAction {
	@Autowired
	TaskService taskService;

	/**
	 * 对树形中选中的商铺进行检查周期发布
	 * @param unitidform
	 * @return
	 */
	@RequestMapping("addTime")
	public JSONObject ReleaseTask(UnitListForm unitidform) {
		JSONObject jsonObject = new JSONObject();
		for (Unitid unitid : unitidform.getUnitid()) {
			taskService.addTasktime(unitid);
		}
		jsonObject.put("result", "success");
		return jsonObject;
	}

	/**
	 * 得到周期具体信息
	 * @return
	 */
	@RequestMapping("getTaskInfo")
	public List<Task> getTaskInfo() {
		return taskService.getTaskInfo();
	}

	/**
	 * 修改周期
	 * @param settime
	 * @param tasktime
	 * @param taskid
	 * @return
	 */
	@RequestMapping(value = "updateTaskInfo")
	public Object updateTaskInfo(String settime, int tasktime, int taskid) {
		return taskService.updateTaskInfo(settime, tasktime, taskid);
	}

	/**
	 * 删除周期
	 * @param taskid
	 * @return
	 */
	@RequestMapping("delTaskInfo")
	public int delTaskInfo(int taskid) {
		return taskService.delTaskInfo(taskid);
	}
}
