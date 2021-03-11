package com.example.projects.movies;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projects.movies.Adapters.ReviewsAdapter;
import com.example.projects.movies.Adapters.TrailersAdapter;
import com.example.projects.movies.Models.MovieReviews;
import com.example.projects.movies.Models.MovieTrailers;
import com.example.projects.movies.Models.Reviews;
import com.example.projects.movies.Models.Trailers;
import com.example.projects.movies.Retrofit.GetMovies;
import com.example.projects.movies.Retrofit.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDescActivity extends AppCompatActivity {
    ToggleButton toggleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_desc);

        toggleButton = findViewById(R.id.favorites);
        toggleButton.setText(null);
        toggleButton.setTextOn(null);
        toggleButton.setTextOff(null);
        toggleButton.setChecked(false);
        toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.star_grey));
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.star_yellow));
                else
                    toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.star_grey));
            }
        });

        Intent intent = getIntent();
        int id = intent.getIntExtra("id",0);
        String title = intent.getStringExtra("title");
        String description = intent.getStringExtra("description");

        GetMovies service = RetrofitInstance.getRetrofitInstance().create(GetMovies.class);
        Call<MovieTrailers> call = service.getTrailers(id);
        call.enqueue(new Callback<MovieTrailers>() {
            @Override
            public void onResponse(Call<MovieTrailers> call, Response<MovieTrailers> response) {
                generateTrailers(response.body().getResults());
            }

            @Override
            public void onFailure(Call<MovieTrailers> call, Throwable t) {
                Toast.makeText(MovieDescActivity.this, "Something went wrong!!", Toast.LENGTH_SHORT).show();
            }
        });

        Call<MovieReviews> call2 = service.getReviews(id);
        call2.enqueue(new Callback<MovieReviews>() {
            @Override
            public void onResponse(Call<MovieReviews> call, Response<MovieReviews> response) {
                generateReviews(response.body().getResults());
            }

            @Override
            public void onFailure(Call<MovieReviews> call, Throwable t) {
                Toast.makeText(MovieDescActivity.this, "Something went wrong!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateReviews(ArrayList<Reviews> results) {
        RecyclerView rv = findViewById(R.id.rv2);
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rv.setHasFixedSize(true);
        ReviewsAdapter adapter = new ReviewsAdapter(results);
        rv.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }

    private void generateTrailers(ArrayList<Trailers> results) {
        RecyclerView rv = findViewById(R.id.rv1);
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rv.setHasFixedSize(true);
        TrailersAdapter adapter = new TrailersAdapter(results);
        rv.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }

}