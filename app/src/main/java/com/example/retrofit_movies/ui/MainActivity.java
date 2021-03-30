package com.example.retrofit_movies.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.retrofit_movies.R;
import com.example.retrofit_movies.adapters.FilmAdapter;
import com.example.retrofit_movies.data.FilmsStorage;
import com.example.retrofit_movies.models.FilmModel;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FilmAdapter filmAdapter;
    private ProgressBar progressBar;
    private final String FILM_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_film);
        progressBar = findViewById(R.id.progress);
        progressBar.setVisibility(View.VISIBLE);


        FilmsStorage.getAllFilms(new FilmsStorage.AllFilmsResult() {
            @Override
            public void onSuccess(List<FilmModel> films) {
                progressBar.setVisibility(View.GONE);
                filmAdapter.setFilmList(films);
            }

            @Override
            public void onFailure(String errMsg) {

            }
        });
        init();

    }
    private void init() {
        filmAdapter = new FilmAdapter();
        recyclerView.setAdapter(filmAdapter);
        filmAdapter.setOnClickListener(film -> {
            Intent intent = new Intent(this, FilmDetailsActivity.class);
            intent.putExtra(FILM_ID, film.getId());
            startActivity(intent);
        });
    }
}