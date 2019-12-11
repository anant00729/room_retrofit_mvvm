package com.an2t.beforetestonlyjava.view_pager.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShowRes {


    @SerializedName("Status")
    @Expose
    private Boolean status;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Shows")
    @Expose
    private List<CatShow> shows = null;


    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<CatShow> getShows() {
        return shows;
    }

    public void setShows(List<CatShow> shows) {
        this.shows = shows;
    }
}
