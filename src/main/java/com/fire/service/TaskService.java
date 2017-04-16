package com.fire.service;

import java.util.List;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fire.dao.TaskMapper;
import com.fire.po.Task;
import com.fire.po.Unitid;

@Service
public class TaskService {
	@Autowired
	TaskMapper taskMapper;

	/**
	 * 添加周期，如果该场所已经存在周期，就不再添加
	 * @param unitid
	 * @return
	 */
	public int addTasktime(Unitid unitid) {
		// TODO Auto-generated method stub
		List<Task> taskList = taskMapper.selectTaskTime(Integer.valueOf(unitid.getUnitid()));
		if (!taskList.isEmpty() && taskList.size() > 0){
			return 1;
		}

		return taskMapper.insert(unitid);
	}

	public List<Task> getTaskInfo() {
		// TODO Auto-generated method stub
		return taskMapper.getTaskInfo();
	}

	public Object updateTaskInfo(String settime, int tasktime, int taskid) {
		// TODO Auto-generated method stub
		return taskMapper.updateTaskInfo(settime, tasktime, taskid);
	}

	public int delTaskInfo(int taskid) {
		// TODO Auto-generated method stub
		return taskMapper.deleteByPrimaryKey(taskid);
	}
}
