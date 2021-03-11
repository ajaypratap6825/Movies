package com.example.projects.movies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.projects.movies.Adapters.MovieAdapter;
import com.example.projects.movies.Models.Movies;
import com.example.projects.movies.Models.Results;
import com.example.projects.movies.Retrofit.GetMovies;
import com.example.projects.movies.Retrofit.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetMovies service = RetrofitInstance.getRetrofitInstance().create(GetMovies.class);
        Call<Movies> call = service.getMoviesData();
        call.enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {
                generateMovies(response.body().getResults());
            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateMovies(ArrayList<Results> results) {
        RecyclerView rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
        MovieAdapter adapter = new MovieAdapter(results);
        rv.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        adapter.setOnItemClickListener(new MovieAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Results results) {
                int id = results.getId();
                Intent intent = new Intent(MainActivity.this, MovieDescActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("title", results.getOriginal_title());
                intent.putExtra("description", results.getOverview());
                startActivity(intent);
            }
        });
    }
}