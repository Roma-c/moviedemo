package com.androidTest.movieDemo.data.remote.repo;

import com.androidTest.movieDemo.data.remote.APIService;
import com.androidTest.movieDemo.model.ResultsResponse;

import javax.inject.Inject;

import io.reactivex.Single;

public class MovieRepo {

    private final APIService api;

    @Inject
    public MovieRepo(APIService api) {
        this.api = api;
    }

    public Single<ResultsResponse> fetchMovies(){
        return api.getMovies();
    }


  }
