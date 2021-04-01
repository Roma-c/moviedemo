package com.androidTest.movieDemo.di;

import android.app.Application;

import com.androidTest.movieDemo.di.modules.FragmentBuildersModule;
import com.androidTest.movieDemo.di.modules.AppModule;
import com.androidTest.movieDemo.di.modules.NetworkModule;
import com.androidTest.movieDemo.di.modules.ViewModelFactoryModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, FragmentBuildersModule.class
, AppModule.class, ViewModelFactoryModule.class, NetworkModule.class})
public interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
