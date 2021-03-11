package com.example.projects.movies.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projects.movies.Models.Movies;
import com.example.projects.movies.Models.Results;
import com.example.projects.movies.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {
    ArrayList<Results> list;
    private OnItemClickListener listener;

    public MovieAdapter(ArrayList<Results> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list, parent, false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieHolder holder, int position) {

        String url = "https://image.tmdb.org/t/p/w500"+list.get(position).getPoster_path();
        Picasso.get().load(url).fit().centerCrop().into(holder.image);
        holder.date.setText("Date - "+list.get(position).getRelease_date());
        holder.vote.setText("Vote - "+list.get(position).getVote_average());
        holder.voteCount.setText("Votes - "+list.get(position).getVote_count());
        holder.title.setText(list.get(position).getOriginal_title());
        holder.description.setText(list.get(position).getOverview());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView date, vote, voteCount, title, description;
        public MovieHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            date = itemView.findViewById(R.id.date);
            vote = itemView.findViewById(R.id.vote);
            voteCount = itemView.findViewById(R.id.voteCount);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(list.get(position));
                    }
                }
            });

        }
    }
    public interface OnItemClickListener {
        void onItemClick(Results results);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}

