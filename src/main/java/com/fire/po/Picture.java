package com.fire.po;

public class Picture {

    private Integer pictureid;

    private String firetableid;

    private String PicType;

    private String pictureurl;

    private String uploaddate;

    public Integer getPictureid() {
        return pictureid;
    }

    public void setPictureid(Integer pictureid) {
        this.pictureid = pictureid;
    }

    public String getFiretableid() {
        return firetableid;
    }

    public void setFiretableid(String firetableid) {
        this.firetableid = firetableid;
    }

    public String getPictureurl() {
        return pictureurl;
    }

    public String getPicType() {
		return PicType;
	}

	public void setPicType(String picType) {
		PicType = picType;
	}

    public void setPictureurl(String pictureurl) {
        this.pictureurl = pictureurl;
    }

    public String getUploaddate() {
        return uploaddate;
    }

    public void setUploaddate(String uploaddate) {
        this.uploaddate = uploaddate;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "pictureid=" + pictureid +
                ", firetableid='" + firetableid + '\'' +
                ", PicType='" + PicType + '\'' +
                ", pictureurl='" + pictureurl + '\'' +
                ", uploaddate='" + uploaddate + '\'' +
                '}';
    }
}