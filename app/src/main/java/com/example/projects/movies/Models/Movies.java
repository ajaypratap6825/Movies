package com.example.projects.movies.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Movies {
    @SerializedName("results")
    public ArrayList<Results> results = new ArrayList<Results>();

    public ArrayList<Results> getResults() {
        return results;
    }

    public void setResults(ArrayList<Results> results) {
        this.results = results;
    }
}
