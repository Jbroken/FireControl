package com.fire.po;

public class Troubletable {
    private String troubletableid;

    private Integer userid;

    private Integer unitid;

    private String organization;

    private String year;

    private String month;

    private String day;

    private String unitname;

    private Integer risk1;

    private Integer risk2;

    private Integer risk3;

    private Integer risk4;

    private Integer risk5;

    private Integer risk6;

    private Integer otherrisk;

    private String checkdate;

    public String getTroubletableid() {
        return troubletableid;
    }

    public void setTroubletableid(String troubletableid) {
        this.troubletableid = troubletableid == null ? null : troubletableid.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getUnitid() {
        return unitid;
    }

    public void setUnitid(Integer unitid) {
        this.unitid = unitid;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization == null ? null : organization.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day == null ? null : day.trim();
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname == null ? null : unitname.trim();
    }

    public Integer getRisk1() {
        return risk1;
    }

    public void setRisk1(Integer risk1) {
        this.risk1 = risk1;
    }

    public Integer getRisk2() {
        return risk2;
    }

    public void setRisk2(Integer risk2) {
        this.risk2 = risk2;
    }

    public Integer getRisk3() {
        return risk3;
    }

    public void setRisk3(Integer risk3) {
        this.risk3 = risk3;
    }

    public Integer getRisk4() {
        return risk4;
    }

    public void setRisk4(Integer risk4) {
        this.risk4 = risk4;
    }

    public Integer getRisk5() {
        return risk5;
    }

    public void setRisk5(Integer risk5) {
        this.risk5 = risk5;
    }

    public Integer getRisk6() {
        return risk6;
    }

    public void setRisk6(Integer risk6) {
        this.risk6 = risk6;
    }

    public Integer getOtherrisk() {
        return otherrisk;
    }

    public void setOtherrisk(Integer otherrisk) {
        this.otherrisk = otherrisk;
    }

    public String getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(String checkdate) {
        this.checkdate = checkdate == null ? null : checkdate.trim();
    }
}