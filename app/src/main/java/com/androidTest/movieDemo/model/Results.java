package com.androidTest.movieDemo.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Results extends BaseObservable {

      public class Movie extends BaseObservable {

        @SerializedName("title")
        @Expose
        private String name;




        @SerializedName("poster_path")
        @Expose
        private String image;



        @SerializedName("rank")
        @Expose
        private String rank;


        public String getRank() {
            return rank;
        }

        public void setRank(String rnk) {
           rank = rnk;
        }



        @Bindable
        public String getImage() {
            return "http://image.tmdb.org/t/p/w185"+image;
        }

        @Bindable
        public String getName() {
            return name;
        }


    }
}


