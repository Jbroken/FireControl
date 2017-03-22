package com.fire.po;

public class CheckCondition {
	
	private String checkdate;
	
	private String count;

	public String getCheckdate() {
		return checkdate;
	}

	public void setCheckdate(String checkdate) {
		this.checkdate = checkdate;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "CheckCondition [checkdate=" + checkdate + ", count=" + count
				+ "]";
	}

}
