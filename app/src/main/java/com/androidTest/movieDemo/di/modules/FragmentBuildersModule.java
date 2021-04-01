package com.androidTest.movieDemo.di.modules;
import com.androidTest.movieDemo.ui.movie.MovieFragment;
import com.androidTest.movieDemo.ui.login.LoginFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(includes = {PostModule.class})
public abstract class FragmentBuildersModule {

    @ContributesAndroidInjector(modules = {ViewModelModule.class})
    abstract MovieFragment contributeNoteFragment();


    @ContributesAndroidInjector(modules = {ViewModelModule.class})
    abstract LoginFragment contributeLoginFragment();

}
