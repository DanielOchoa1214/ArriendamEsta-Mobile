package edu.eci.arriendamestamobile.ui.fragments.utils;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.Map;

import edu.eci.arriendamestamobile.ui.fragments.home.HomeViewModel;
import edu.eci.arriendamestamobile.ui.fragments.properties.PropertyViewModel;

public class HomeViewModelFactory implements ViewModelProvider.Factory {
    private Application app;
    private Map<String, String> filters;

    public HomeViewModelFactory(Application app, Map<String, String> filters) {
        this.app = app;
        this.filters = filters;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new HomeViewModel(filters);
    }
}
