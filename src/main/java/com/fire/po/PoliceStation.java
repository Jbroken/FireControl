package com.fire.po;

import java.util.List;

public class PoliceStation {
	
	private Integer policeid;
	
	private String policeStation;
	
	private List<TreeUnit> unit;

	public Integer getPoliceid() {
		return policeid;
	}

	public void setPoliceid(Integer policeid) {
		this.policeid = policeid;
	}


	public String getPoliceStation() {
		return policeStation;
	}

	public void setPoliceStation(String policeStation) {
		this.policeStation = policeStation;
	}

	
	public List<TreeUnit> getUnit() {
		return unit;
	}

	public void setUnit(List<TreeUnit> unit) {
		this.unit = unit;
	}

	@Override
	public String toString() {
		return "PoliceStation [policeid=" + policeid + ", policeStation="
				+ policeStation + "]";
	}

}
