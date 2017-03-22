package com.fire.po;

public class PoliceCheckInfo {
	
	private Integer policeid;
	
	private String policeStation;
	
	private Integer unitsum;
	
	private Integer checkunitsum;
	
	private String coverage;
	

	public Integer getPoliceid() {
		return policeid;
	}

	public void setPoliceid(Integer policeid) {
		this.policeid = policeid;
	}

	public String getPoliceStation() {
		return policeStation;
	}

	public void setPolicestation(String policeStation) {
		this.policeStation = policeStation;
	}

	public Integer getUnitsum() {
		return unitsum;
	}

	public void setUnitsum(Integer unitsum) {
		this.unitsum = unitsum;
	}

	public Integer getCheckunitsum() {
		return checkunitsum;
	}

	public void setCheckunitsum(Integer checkunitsum) {
		this.checkunitsum = checkunitsum;
	}

	public void setPoliceStation(String policeStation) {
		this.policeStation = policeStation;
	}

	public String getCoverage() {
		return coverage;
	}

	public void setCoverage(String coverage) {
		this.coverage = coverage;
	}
	
	
}
