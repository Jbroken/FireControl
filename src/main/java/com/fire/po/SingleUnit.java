package com.fire.po;

public class SingleUnit {
	
	private String Category;
	
	private String week;
	
	private String count;

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "SingleUnit [Category=" + Category + ",  week=" + week + ", count="
				+ count + "]";
	}


}
