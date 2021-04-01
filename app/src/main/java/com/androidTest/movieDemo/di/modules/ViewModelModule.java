package com.androidTest.movieDemo.di.modules;

import androidx.lifecycle.ViewModel;

import com.androidTest.movieDemo.di.keys.ViewModelKey;
import com.androidTest.movieDemo.ui.movie.MovieListViewModel;
import com.androidTest.movieDemo.ui.login.LoginViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MovieListViewModel.class)
    public abstract ViewModel bindPostViewModel(MovieListViewModel postViewModel);


    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel.class)
    public abstract ViewModel bindLoginViewModel(LoginViewModel loginViewModel);

}
