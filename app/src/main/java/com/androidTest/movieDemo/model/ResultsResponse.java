package com.androidTest.movieDemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultsResponse {

    @SerializedName("results")
    @Expose
    private List<Results.Movie> results;

    public List<Results.Movie> getResults() {
        return results;
    }


}
