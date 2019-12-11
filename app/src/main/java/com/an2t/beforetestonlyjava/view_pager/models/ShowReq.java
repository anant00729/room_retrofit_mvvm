package com.an2t.beforetestonlyjava.view_pager.models;

public class ShowReq {

    private String BannerType;
    private Integer Latitude;
    private Integer Longitude;
    private Integer LanguageID;
    private String CountryID;

    public String getBannerType() {
        return BannerType;
    }

    public void setBannerType(String bannerType) {
        BannerType = bannerType;
    }

    public Integer getLatitude() {
        return Latitude;
    }

    public void setLatitude(Integer latitude) {
        Latitude = latitude;
    }

    public Integer getLongitude() {
        return Longitude;
    }

    public void setLongitude(Integer longitude) {
        Longitude = longitude;
    }

    public Integer getLanguageID() {
        return LanguageID;
    }

    public void setLanguageID(Integer languageID) {
        LanguageID = languageID;
    }

    public String getCountryID() {
        return CountryID;
    }

    public void setCountryID(String countryID) {
        CountryID = countryID;
    }
}
