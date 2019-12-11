package com.an2t.beforetestonlyjava.view_pager.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CatShow {

    @SerializedName("cat_id")
    @Expose
    private String catId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("show")
    @Expose
    private List<Show> show = null;

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Show> getShow() {
        return show;
    }

    public void setShow(List<Show> show) {
        this.show = show;
    }
}
