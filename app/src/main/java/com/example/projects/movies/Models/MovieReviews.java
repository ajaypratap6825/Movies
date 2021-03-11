package com.example.projects.movies.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MovieReviews {
    @SerializedName("results")
    public ArrayList<Reviews> results = new ArrayList<Reviews>();

    public ArrayList<Reviews> getResults() {
        return results;
    }

    public void setResults(ArrayList<Reviews> results) {
        this.results = results;
    }
}
