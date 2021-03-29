package com.example.retrofit_movies.data;


import com.example.retrofit_movies.models.FilmModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmsStorage {

    public static void getFilmById(String id, Result result) {
        RetrofitBuilder.getInstance().getFilmById(id).enqueue(new Callback<FilmModel>() {
            @Override
            public void onResponse(Call<FilmModel> call, Response<FilmModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    result.onSuccess(response.body());
                } else {
                    result.onFailure(String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<FilmModel> call, Throwable t) {
                result.onFailure(t.getLocalizedMessage());
            }
        });
    }

    public static void getAllFilms(AllFilmsResult result) {
        RetrofitBuilder.getInstance().getAllFilms().enqueue(new Callback<List<FilmModel>>() {
            @Override
            public void onResponse(Call<List<FilmModel>> call, Response<List<FilmModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    result.onSuccess(response.body());
                } else {
                    result.onFailure(String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<FilmModel>> call, Throwable t) {
                result.onFailure(t.getLocalizedMessage());
            }
        });
    }

    public interface Result {
        void onSuccess(FilmModel film);
        void onFailure(String errorMsg);
    }

    public interface AllFilmsResult{
        void onSuccess(List<FilmModel> films);
        void onFailure(String errMsg);
    }
}
