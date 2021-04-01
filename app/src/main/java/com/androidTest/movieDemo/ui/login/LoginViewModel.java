package com.androidTest.movieDemo.ui.login;

import com.androidTest.movieDemo.ui.base.BaseViewModel;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class LoginViewModel extends BaseViewModel {


    private CompositeDisposable disposable;


    @Inject
    public LoginViewModel() {

        disposable = new CompositeDisposable();
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null) {
            disposable.clear();
            disposable = null;
        }
    }
}
