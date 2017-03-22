package com.fire.po;

import java.util.Date;

public class Inspectionrecord {
    
    private Integer id;

    private String nstitution;

    private String personincharge;

    private String address;

    private String category;

    private Double area;

    private Integer floors;

    private Integer height;

    private String inspector;

    private String entourage;

    private Date checkdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNstitution() {
        return nstitution;
    }

    public void setNstitution(String nstitution) {
        this.nstitution = nstitution;
    }

    public String getPersonincharge() {
        return personincharge;
    }

    public void setPersonincharge(String personincharge) {
        this.personincharge = personincharge;
    }
 
    public String getAddress() {
        return address;
    }
 
    public void setAddress(String address) {
        this.address = address;
    }

   
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
 
    public Double getArea() {
        return area;
    }
 
    public void setArea(Double area) {
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
 
    public String getInspector() {
        return inspector;
    }
 
    public void setInspector(String inspector) {
        this.inspector = inspector;
    }
 
    public String getEntourage() {
        return entourage;
    }
 
    public void setEntourage(String entourage) {
        this.entourage = entourage;
    }
 
    public Date getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(Date checkdate) {
        this.checkdate = checkdate;
    }
}