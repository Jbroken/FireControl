package com.fire.po;

public class Institution {
  
    private Integer id;

    private String institutionname;

    private String institutionstation;

    private String institutioncategory;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInstitutionname() {
        return institutionname;
    }

    public void setInstitutionname(String institutionname) {
        this.institutionname = institutionname;
    }

    public String getInstitutionstation() {
        return institutionstation;
    }

    public void setInstitutionstation(String institutionstation) {
        this.institutionstation = institutionstation;
    }

    public String getInstitutioncategory() {
        return institutioncategory;
    }

	public void setInstitutioncategory(String institutioncategory) {
        this.institutioncategory = institutioncategory;
    }
	
	
    @Override
	public String toString() {
		return "Institution [id=" + id + ", institutionname=" + institutionname
				+ ", institutionstation=" + institutionstation
				+ ", institutioncategory=" + institutioncategory + "]";
	}
}