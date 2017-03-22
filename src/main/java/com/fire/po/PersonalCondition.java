package com.fire.po;

public class PersonalCondition {
	private Integer uerid;
	
	private String checker;
	
	private String time;
	
	private String count;

	public Integer getUerid() {
		return uerid;
	}

	public void setUerid(Integer uerid) {
		this.uerid = uerid;
	}

	public String getChecker() {
		return checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "PersonalCondition [checker=" + checker + ", time=" + time
				+ ", count=" + count + "]";
	}
	
	

}
