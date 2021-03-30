package com.example.retrofit_movies.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.retrofit_movies.data.FilmsStorage;
import com.example.retrofit_movies.databinding.ActivityFilmDetailsBinding;
import com.example.retrofit_movies.models.FilmModel;


public class FilmDetailsActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private ActivityFilmDetailsBinding binding;
    private final String FILM_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFilmDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        binding.progress.setVisibility(View.VISIBLE);

        setContentView(view);
        loadInfo(getIntent().getStringExtra(FILM_ID));
    }

    private void loadInfo(String id) {
        FilmsStorage.getFilmById(id, new FilmsStorage.Result() {
            @Override
            public void onSuccess(FilmModel film) {
                binding.progress.setVisibility(View.GONE);
                binding.linearTv.setVisibility(View.VISIBLE);
                setFilmInfo(film);
            }

            @Override
            public void onFailure(String errorMsg) {

            }
        });
    }

    private void setFilmInfo(FilmModel filmModel) {
        binding.tvFilmTitle.setText(filmModel.getTitle());
        binding.tvFilmDescription.setText(filmModel.getDescription());
        binding.tvFilmDirector.setText(filmModel.getDirector());
        binding.tvFilmProducer.setText(filmModel.getProducer());
        binding.tvFilmRating.setText(filmModel.getRtScore());
        binding.tvFilmReleaseDate.setText(filmModel.getReleaseDate());

    }
}