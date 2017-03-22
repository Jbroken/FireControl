package com.fire.po;

public class TreeInformation {
		
	public static Integer branchid;
	
	public static Integer policeid;
	
	public Integer unitid;
	
	public static String branchname;
	
	public String policename;
	
	public String unitname;

	public Integer getBranchid() {
		return branchid;
	}

	public void setBranchid(Integer branchid) {
		this.branchid = branchid;
	}

	public Integer getPoliceid() {
		return policeid;
	}

	public void setPoliceid(Integer policeid) {
		this.policeid = policeid;
	}

	public Integer getUnitid() {
		return unitid;
	}

	public void setUnitid(Integer unitid) {
		this.unitid = unitid;
	}

	public String getBranchname() {
		return branchname;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}

	public String getPolicename() {
		return policename;
	}

	public void setPolicename(String policename) {
		this.policename = policename;
	}

	public String getUnitname() {
		return unitname;
	}

	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}

	@Override
	public String toString() {
		return "TreeInformation [branchid=" + branchid + ", policeid="
				+ policeid + ", unitid=" + unitid + ", branchname="
				+ branchname + ", policename=" + policename + ", unitname="
				+ unitname + "]";
	}
	
	

}
