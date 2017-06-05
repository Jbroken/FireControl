package com.fire.po;

public class PoliceInfo {

    private Integer userid;

    private String state;

    private String tel;

    private String password;

    private String idcard;

    private String policeStation;

    private Integer unitCount;

    private Integer noCheckCount;
    //覆盖率
    private String CoverageRate;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPoliceStation() {
        return policeStation;
    }

    public void setPoliceStation(String policeStation) {
        this.policeStation = policeStation;
    }

    public Integer getUnitCount() {
        return unitCount;
    }

    public void setUnitCount(Integer unitCount) {
        this.unitCount = unitCount;
    }

    public String getCoverageRate() {
        return CoverageRate;
    }

    public void setCoverageRate(String coverageRate) {
        CoverageRate = coverageRate;
    }

    public Integer getNoCheckCount() {
        return noCheckCount;
    }

    public void setNoCheckCount(Integer noCheckCount) {
        this.noCheckCount = noCheckCount;
    }


}
