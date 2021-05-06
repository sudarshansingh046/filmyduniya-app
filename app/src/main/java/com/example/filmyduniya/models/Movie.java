package com.example.filmyduniya.models;

public class Movie {

    private String coverPhoto;
    private String description;
    private String thumbnail;
    private String title;
    private String streamingLink;

    public Movie() {
    }

    public Movie(String title, String thumbnail, String coverPhoto) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.coverPhoto = coverPhoto;
    }

    public Movie(String title, String thumbnail) {
        this.title = title;
        this.thumbnail = thumbnail;
    }

    public Movie(String coverPhoto, String description, String thumbnail, String title, String streamingLink) {
        this.coverPhoto = coverPhoto;
        this.description = description;
        this.thumbnail = thumbnail;
        this.title = title;
        this.streamingLink = streamingLink;
    }

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStreamingLink() {
        return streamingLink;
    }

    public void setStreamingLink(String streamingLink) {
        this.streamingLink = streamingLink;
    }
}
