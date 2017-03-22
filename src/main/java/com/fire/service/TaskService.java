package com.fire.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fire.dao.TaskMapper;
import com.fire.po.Task;
import com.fire.po.Unitid;

@Service
public class TaskService {
	@Autowired
	TaskMapper taskMapper;

	public int addTasktime(Unitid unitid) {
		// TODO Auto-generated method stub
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
