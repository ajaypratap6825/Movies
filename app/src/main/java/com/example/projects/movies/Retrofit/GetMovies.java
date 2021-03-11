package com.example.projects.movies.Retrofit;

import com.example.projects.movies.Models.MovieReviews;
import com.example.projects.movies.Models.MovieTrailers;
import com.example.projects.movies.Models.Movies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetMovies {

    @GET("3/movie/popular?api_key=4e44d9029b1270a757cddc766a1bcb63&language=en-US&page=1")
    Call<Movies> getMoviesData();

    @GET("3/movie/{id}/videos?api_key=4e44d9029b1270a757cddc766a1bcb63&language=en-US")
    Call<MovieTrailers> getTrailers(@Path("id") int id);

    @GET("3/movie/{id}/reviews?api_key=4e44d9029b1270a757cddc766a1bcb63&language=en-US&page=1")
    Call<MovieReviews> getReviews(@Path("id") int id);

}
