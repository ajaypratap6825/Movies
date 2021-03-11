package com.example.projects.movies.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projects.movies.Models.Results;
import com.example.projects.movies.Models.Trailers;
import com.example.projects.movies.R;

import java.util.ArrayList;

public class TrailersAdapter extends RecyclerView.Adapter<TrailersAdapter.TrailerHolder> {
    ArrayList<Trailers> list;

    public TrailersAdapter(ArrayList<Trailers> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public TrailerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.trailer_list, parent, false);
        return new TrailerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrailerHolder holder, int position) {
        String url = "<iframe width=\"100%\" height=\"100%\" src=\"https://www" + ".youtube.com/embed/" + list.get(position).getKey()+
               "\" frameborder=\"0\" allowfullscreen></iframe>";
        holder.webView.loadData(url,"text/html","UTF-8");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TrailerHolder extends RecyclerView.ViewHolder {
        WebView webView;
        public TrailerHolder(@NonNull View itemView) {
            super(itemView);
            webView = itemView.findViewById(R.id.webView);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebChromeClient(new WebChromeClient());
        }
    }
}
