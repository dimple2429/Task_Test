package com.example.task_test.appInterface;

import com.example.task_test.Model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("movies.json")
    Call<List<Movie>> getMovie();

}
