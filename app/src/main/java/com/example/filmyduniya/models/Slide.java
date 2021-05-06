package com.example.filmyduniya.models;

public class Slide {

    private String Image ;
    private String Title;
    private String Video;
    // Add more field depand on whay you wa&nt ...


    public Slide(String image, String title, String video) {
        this.Image = image;
        this.Title = title;
        this.Video = video;
    }

    public Slide() {
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getVideo() {
        return Video;
    }

    public void setVideo(String video) {
        Video = video;
    }
}
