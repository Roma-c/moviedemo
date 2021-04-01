package com.androidTest.movieDemo.ui.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.androidTest.movieDemo.data.remote.repo.MovieRepo;
import com.androidTest.movieDemo.model.ResultsResponse;
import com.androidTest.movieDemo.model.Results;
import com.androidTest.movieDemo.ui.base.BaseViewModel;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import javax.inject.Inject;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MovieListViewModel extends BaseViewModel {

    private final MovieRepo movieRepo;
    private CompositeDisposable disposable;
    private MutableLiveData<List<Results.Movie>> movieList = new MutableLiveData<>();

    @Inject
    public MovieListViewModel(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
        disposable = new CompositeDisposable();
    }

    public LiveData<List<Results.Movie>> getMovieList() {
        return movieList;
    }


    public void loadData() {

        disposable.add(movieRepo.fetchMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(s -> loadingStatus.setValue(true))
                .doAfterTerminate(() -> loadingStatus.setValue(false))
                .subscribeWith(new DisposableSingleObserver<ResultsResponse>() {

                    @Override
                    public void onSuccess(ResultsResponse resultsResponse) {
                       movieList.setValue(resultsResponse.getResults());

                    }

                    @Override
                    public void onError(Throwable e) {
                       e.printStackTrace();
                       onError.setValue(e);
                    }
                }));

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
