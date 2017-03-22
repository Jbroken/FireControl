package com.fire.po;

public class UnitInformation {
	private Integer branchid;
	
	private Integer policeid;
	
	private Integer unitid;
	
	private String firetableid;
	
	private String branchname;
	
	private String policename;
	
	private String unitname;
	
	private String address;
	
	private  String master;
	
	private String checker;
	
	private String checkdate;
	

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
	public String getFiretableid() {
		return firetableid;
	}

	public void setFiretableid(String firetableid) {
		this.firetableid = firetableid;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	public String getChecker() {
		return checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	public String getCheckdate() {
		return checkdate;
	}

	public void setCheckdate(String checkdate) {
		this.checkdate = checkdate;
	}

	@Override
	public String toString() {
		return "UnitInformation [branchid=" + branchid + ", policeid="
				+ policeid + ", firetableid=" + firetableid + ", branchname="
				+ branchname + ", policename=" + policename + ", unitname="
				+ unitname + ", address=" + address + ", master=" + master
				+ ", checker=" + checker + ", checkdate=" + checkdate + "]";
	}

	


	

	
	
	

}
