package com.example.projects.movies.Models;

import com.google.gson.annotations.SerializedName;

public class Reviews {
    @SerializedName("author")
    public String author;
    @SerializedName("content")
    public String content;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
