package com.betelgeuse.corp.apijson.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.betelgeuse.corp.apijson.R;
import com.betelgeuse.corp.apijson.moduls.Movie;
import com.bumptech.glide.Glide;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter <MovieAdapter.MovieViewHolder>{
    List<Movie> Movies;
    int TemplateLayout;
    Context context;

    public MovieAdapter(Context context, int templateLayout, List<Movie> movies) {
        Movies = movies;
        TemplateLayout = templateLayout;
        this.context = context;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(TemplateLayout, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        holder.Title.setText(this.Movies.get(position).title);
        holder.Year.setText(this.Movies.get(position).year);
        holder.Type.setText(this.Movies.get(position).type);
//        holder.Poster.(this.Movies.get(position).title);
        Glide.with(context).load(this.Movies.get(position).poster).into(holder.Poster);
    }

    @Override
    public int getItemCount() {
        return this.Movies.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder{
        TextView Title;
        TextView Year;
        TextView Type;
        ImageView Poster;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            Poster = itemView.findViewById(R.id.Poster);
            Title = itemView.findViewById(R.id.TitleName);
            Year = itemView.findViewById(R.id.YearDate);
            Type = itemView.findViewById(R.id.TypeName);
        }
    }
}
