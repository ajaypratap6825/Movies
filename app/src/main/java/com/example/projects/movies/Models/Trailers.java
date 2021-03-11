package com.example.projects.movies.Models;

import com.google.gson.annotations.SerializedName;

public class Trailers {
    @SerializedName("key")
    public String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
