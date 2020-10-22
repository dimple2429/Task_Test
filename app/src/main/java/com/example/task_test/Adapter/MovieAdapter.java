package com.example.task_test.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.task_test.Model.Movie;
import com.example.task_test.R;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {
    List<Movie> movieList;
    Context context;

    public MovieAdapter(List<Movie> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.tvTitle.setText(movie.getTitle());
        holder.tvYear.setText(movie.getReleaseYear());
        holder.tvRating.setText(movie.getRating());
        Glide.with(context)
                .load(movie.getImage())
                .centerCrop()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle;
        public TextView tvYear;
        public TextView tvRating;
        public ImageView imageView;

        public MyViewHolder(View view) {
            super(view);
            tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            tvYear = (TextView) view.findViewById(R.id.tvYear);
            tvRating = (TextView) view.findViewById(R.id.tvRating);
            imageView = (ImageView) view.findViewById(R.id.imageView);
        }
    }
}
