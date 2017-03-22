package com.fire.po;

public class Branch {
	
	private Integer branchid;
	
	private String branchname; 

	public Integer getBranchid() {
		return branchid;
	}

	public void setBranchid(Integer branchid) {
		this.branchid = branchid;
	}

	public String getBranchname() {
		return branchname;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}

	@Override
	public String toString() {
		return "Branch [branchid=" + branchid + ", branchname=" + branchname
				+ "]";
	}
	
	

}
