package com.fire.po;

public class Task {
	
    private Integer taskid;
    
    private String unitid;

    private Integer tasktime;

    private String settime;
    
    private String unitname;

    public Integer getTaskid() {
        return taskid;
    }

    public void setTaskid(Integer taskid) {
        this.taskid = taskid;
    }

    public String getUnitid() {
        return unitid;
    }

    public void setUnitid(String unitid) {
        this.unitid = unitid;
    }

    public Integer getTasktime() {
        return tasktime;
    }

    public void setTasktime(Integer tasktime) {
        this.tasktime = tasktime;
    }

    public String getSettime() {
        return settime;
    }

    public void setSettime(String settime) {
        this.settime = settime;
    }

	public String getUnitname() {
		return unitname;
	}

	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}
    
}