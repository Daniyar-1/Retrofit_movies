package com.example.retrofit_movies.data;
import com.example.retrofit_movies.models.FilmModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GhibliApi {

    @GET("/films/{id}")
    Call<FilmModel> getFilmById(@Path("id") String id);

    @GET("/films")
    Call<List<FilmModel>> getAllFilms();
}
