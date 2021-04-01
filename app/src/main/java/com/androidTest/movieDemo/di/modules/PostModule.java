package com.androidTest.movieDemo.di.modules;

import com.androidTest.movieDemo.data.remote.APIService;
import com.androidTest.movieDemo.data.remote.repo.MovieRepo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PostModule {

    @Singleton
    @Provides
    static MovieRepo provideNoteRepo(APIService noteAPI){
        return new MovieRepo(noteAPI);
    }
}
