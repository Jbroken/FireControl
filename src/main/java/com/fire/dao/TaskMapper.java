package com.fire.dao;

import com.fire.po.Task;
import com.fire.po.TaskExample;
import com.fire.po.Unitid;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TaskMapper {
    
    int countByExample(TaskExample example);

    int deleteByExample(TaskExample example);

    int deleteByPrimaryKey(Integer taskid);

    int insert(Unitid unitid);

    int insertSelective(Task record);

    List<Task> selectByExample(TaskExample example);

    Task selectByPrimaryKey(Integer taskid);

    int updateByExampleSelective(@Param("record") Task record, @Param("example") TaskExample example);

    int updateByExample(@Param("record") Task record, @Param("example") TaskExample example);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);
  
    //得到场所的周期信息
    @Select("select unit.unitname,task.unitid,task.taskid,task.tasktime,task.settime from unit join task where unit.unitid = task.unitid ")
	List<Task> getTaskInfo();
    @Select("select tasktime,settime from task where unitid = #{unitid}")
	List<Task> selectTaskTime(Integer unitid);
    @Update("update task set settime = #{nowDate} where unitid = #{unitid}")
	int updateSetTime(@Param(value="nowDate")String nowDate,@Param(value="unitid")Integer unitid);
    //更新周期
    @Update("update task set settime = #{settime},tasktime = #{tasktime} where taskid=#{taskid}")
	int updateTaskInfo(@Param(value="settime")String settime, @Param(value="tasktime")int tasktime, @Param(value="taskid")int taskid);
}