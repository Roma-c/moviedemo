package com.androidTest.movieDemo.data.remote;

import com.androidTest.movieDemo.model.ResultsResponse;
import com.androidTest.movieDemo.util.Constants;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface APIService {

    @GET(Constants.MOVIES)
    Single<ResultsResponse> getMovies();
}
