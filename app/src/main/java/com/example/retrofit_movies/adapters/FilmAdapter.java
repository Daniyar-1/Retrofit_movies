package com.example.retrofit_movies.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit_movies.R;
import com.example.retrofit_movies.models.FilmModel;

import java.util.ArrayList;
import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.ViewHolder> {
    private final List<FilmModel> filmList = new ArrayList<>();
    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.film_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(filmList.get(position));
    }

    @Override
    public int getItemCount() {
        return filmList.size();
    }

    public void setFilmList(List<FilmModel> films) {
        filmList.addAll(films);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvFilmTitle;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFilmTitle = itemView.findViewById(R.id.tv_film);
        }

        public void bind(FilmModel filmModel) {
            tvFilmTitle.setText(filmModel.getTitle());
            itemView.setOnClickListener(v -> onClickListener.onClick(filmList.get(getAdapterPosition())));
        }
    }
    public interface OnClickListener {
        void onClick(FilmModel film);
    }
}
