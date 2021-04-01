package com.androidTest.movieDemo.di.modules;

import android.app.Application;
import android.content.Context;

import com.androidTest.movieDemo.data.remote.APIService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class AppModule {


    @Provides
    @Singleton
    static APIService provideApi(Retrofit retrofit) {
        return retrofit.create(APIService.class);
    }

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }


}
