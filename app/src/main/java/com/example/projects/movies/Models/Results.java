package com.example.projects.movies.Models;

import com.google.gson.annotations.SerializedName;

public class Results {
    @SerializedName("id")
    public int id;
    @SerializedName("original_title")
    public String original_title;
    @SerializedName("overview")
    public String overview;
    @SerializedName("poster_path")
    public String poster_path;
    @SerializedName("release_date")
    public String release_date;
    @SerializedName("vote_average")
    public float vote_average;
    @SerializedName("vote_count")
    public int vote_count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }
}
