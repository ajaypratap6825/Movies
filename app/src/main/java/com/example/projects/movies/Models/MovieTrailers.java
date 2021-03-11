package com.example.projects.movies.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MovieTrailers {
    @SerializedName("results")
public ArrayList<Trailers> results = new ArrayList<Trailers>();

    public ArrayList<Trailers> getResults() {
        return results;
    }

    public void setResults(ArrayList<Trailers> results) {
        this.results = results;
    }
}
