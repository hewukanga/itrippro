package com.itrip.model;

public class HotelView {
    private Long id;
    private String hotelname;
    private String imgurl;
    private Long cityid;
    private double roomprice;

    public HotelView(Long id) {
        this.id = id;
    }

    public HotelView() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public Long getCityid() {
        return cityid;
    }

    public void setCityid(Long cityid) {
        this.cityid = cityid;
    }

    public double getRoomprice() {
        return roomprice;
    }

    public void setRoomprice(double roomprice) {
        this.roomprice = roomprice;
    }
}
