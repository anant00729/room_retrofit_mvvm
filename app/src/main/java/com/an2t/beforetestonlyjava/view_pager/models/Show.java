package com.an2t.beforetestonlyjava.view_pager.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Show implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("ContetlangID")
    @Expose
    private String contetlangID;
    @SerializedName("movie_card_img")
    @Expose
    private String movieCardImg;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("release")
    @Expose
    private String release;
    @SerializedName("nextreleased")
    @Expose
    private String nextreleased;
    @SerializedName("flagname")
    @Expose
    private String flagname;
    @SerializedName("rated")
    @Expose
    private String rated;
    @SerializedName("runtime")
    @Expose
    private String runtime;
    @SerializedName("favourite")
    @Expose
    private Boolean favourite;
    @SerializedName("plot")
    @Expose
    private String plot;
    @SerializedName("genre")
    @Expose
    private String genre;
    @SerializedName("IMDBRating")
    @Expose
    private String iMDBRating;
    @SerializedName("format")
    @Expose
    private String format;
    @SerializedName("formatlanguage")
    @Expose
    private String formatlanguage;
    @SerializedName("linkid")
    @Expose
    private String linkid;
    @SerializedName("video")
    @Expose
    private String video;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getContetlangID() {
        return contetlangID;
    }

    public void setContetlangID(String contetlangID) {
        this.contetlangID = contetlangID;
    }

    public String getMovieCardImg() {
        return movieCardImg;
    }

    public void setMovieCardImg(String movieCardImg) {
        this.movieCardImg = movieCardImg;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getNextreleased() {
        return nextreleased;
    }

    public void setNextreleased(String nextreleased) {
        this.nextreleased = nextreleased;
    }

    public String getFlagname() {
        return flagname;
    }

    public void setFlagname(String flagname) {
        this.flagname = flagname;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public Boolean getFavourite() {
        return favourite;
    }

    public void setFavourite(Boolean favourite) {
        this.favourite = favourite;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getIMDBRating() {
        return iMDBRating;
    }

    public void setIMDBRating(String iMDBRating) {
        this.iMDBRating = iMDBRating;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getFormatlanguage() {
        return formatlanguage;
    }

    public void setFormatlanguage(String formatlanguage) {
        this.formatlanguage = formatlanguage;
    }

    public String getLinkid() {
        return linkid;
    }

    public void setLinkid(String linkid) {
        this.linkid = linkid;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.title);
        dest.writeString(this.lang);
        dest.writeString(this.contetlangID);
        dest.writeString(this.movieCardImg);
        dest.writeString(this.rating);
        dest.writeString(this.release);
        dest.writeString(this.nextreleased);
        dest.writeString(this.flagname);
        dest.writeString(this.rated);
        dest.writeString(this.runtime);
        dest.writeValue(this.favourite);
        dest.writeString(this.plot);
        dest.writeString(this.genre);
        dest.writeString(this.iMDBRating);
        dest.writeString(this.format);
        dest.writeString(this.formatlanguage);
        dest.writeString(this.linkid);
        dest.writeString(this.video);
    }

    public Show() {
    }

    protected Show(Parcel in) {
        this.id = in.readString();
        this.title = in.readString();
        this.lang = in.readString();
        this.contetlangID = in.readString();
        this.movieCardImg = in.readString();
        this.rating = in.readString();
        this.release = in.readString();
        this.nextreleased = in.readString();
        this.flagname = in.readString();
        this.rated = in.readString();
        this.runtime = in.readString();
        this.favourite = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.plot = in.readString();
        this.genre = in.readString();
        this.iMDBRating = in.readString();
        this.format = in.readString();
        this.formatlanguage = in.readString();
        this.linkid = in.readString();
        this.video = in.readString();
    }

    public static final Parcelable.Creator<Show> CREATOR = new Parcelable.Creator<Show>() {
        @Override
        public Show createFromParcel(Parcel source) {
            return new Show(source);
        }

        @Override
        public Show[] newArray(int size) {
            return new Show[size];
        }
    };
}
