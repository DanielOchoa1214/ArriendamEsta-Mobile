package edu.eci.arriendamestamobile.ui.utils;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import edu.eci.arriendamestamobile.ui.reviews.ReviewsViewModel;

public class ReviewsViewModelFactory implements ViewModelProvider.Factory {
    private Application app;
    private final String targetParam;
    private final String idParam;

    public ReviewsViewModelFactory(Application app, String targetParam, String idParam) {
        this.app = app;
        this.targetParam = targetParam;
        this.idParam = idParam;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass){
        return (T) new ReviewsViewModel(targetParam, idParam);
    }
}
