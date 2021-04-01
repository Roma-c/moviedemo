package com.androidTest.movieDemo.di.modules;

import androidx.lifecycle.ViewModelProvider;

import com.androidTest.movieDemo.ui.ViewModelFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory modelProvider);


}
