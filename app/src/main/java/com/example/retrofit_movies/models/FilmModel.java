package com.example.retrofit_movies.models;

import com.google.gson.annotations.SerializedName;

public class FilmModel {

    @SerializedName("id")
    private String id;

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("director")
    private String director;

    @SerializedName("producer")
    private String producer;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("rt_score")
    private String rtScore;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRtScore() {
        return rtScore;
    }

    public void setRtScore(String rtScore) {
        this.rtScore = rtScore;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id ='" + id + '\'' +
                ", title ='" + title + '\'' +
                ", description ='" + description + '\'' +
                ", director ='" + director + '\'' +
                ", producer ='" + producer + '\'' +
                ", releaseDate ='" + releaseDate + '\'' +
                ", rtScore ='" + rtScore + '\'' +
                '}';
    }
}
