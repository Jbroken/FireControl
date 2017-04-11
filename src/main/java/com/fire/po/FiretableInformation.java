package com.fire.po;

import java.util.Date;
import java.util.List;

public class FiretableInformation {

	private String policestation;

	private Integer unitid;

    private Integer policeid;

    private String unitname;

    private String master;

    private String address;

    private String unitproperty;

    private String area;

    private Integer floors;

    private Integer height;
    
    private String firetableid;
    
    private String checker;

    private String otherchecker;

    private String checkdate;
    
    private String problem;

    private String remarks;
    
    private List<Picture> picture;

	public String getPolicestation() {
		return policestation;
	}

	public void setPolicestation(String policestation) {
		this.policestation = policestation;
	}

	public List<Picture> getPicture() {
		return picture;
	}

	public void setPicture(List<Picture> picture) {
		this.picture = picture;
	}

	public Integer getUnitid() {
		return unitid;
	}

	public void setUnitid(Integer unitid) {
		this.unitid = unitid;
	}
	
	public Integer getPoliceid() {
		return policeid;
	}

	public void setPoliceid(Integer policeid) {
		this.policeid = policeid;
	}

	public String getUnitname() {
		return unitname;
	}

	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}

	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUnitproperty() {
		return unitproperty;
	}

	public void setUnitproperty(String unitproperty) {
		this.unitproperty = unitproperty;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Integer getFloors() {
		return floors;
	}

	public void setFloors(Integer floors) {
		this.floors = floors;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public String getFiretableid() {
		return firetableid;
	}

	public void setFiretableid(String firetableid) {
		this.firetableid = firetableid;
	}

	public String getChecker() {
		return checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	public String getOtherchecker() {
		return otherchecker;
	}

	public void setOtherchecker(String otherchecker) {
		this.otherchecker = otherchecker;
	}


	public String getCheckdate() {
		return checkdate;
	}

	public void setCheckdate(String checkdate) {
		this.checkdate = checkdate;
	}
	 
	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	@Override
	public String toString() {
		return "FiretableInformation{" +
				"policestation='" + policestation + '\'' +
				", unitid=" + unitid +
				", policeid=" + policeid +
				", unitname='" + unitname + '\'' +
				", master='" + master + '\'' +
				", address='" + address + '\'' +
				", unitproperty='" + unitproperty + '\'' +
				", area='" + area + '\'' +
				", floors=" + floors +
				", height=" + height +
				", firetableid='" + firetableid + '\'' +
				", checker='" + checker + '\'' +
				", otherchecker='" + otherchecker + '\'' +
				", checkdate='" + checkdate + '\'' +
				", problem='" + problem + '\'' +
				", remarks='" + remarks + '\'' +
				", picture=" + picture +
				'}';
	}
}
