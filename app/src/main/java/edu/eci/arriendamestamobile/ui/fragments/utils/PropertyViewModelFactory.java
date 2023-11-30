package edu.eci.arriendamestamobile.ui.utils;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.Map;

import edu.eci.arriendamestamobile.ui.properties.PropertyViewModel;


public class PropertyViewModelFactory implements ViewModelProvider.Factory {

    private Application app;
    private Map<String, String> filters;

    public PropertyViewModelFactory(Application app, Map<String, String> filters) {
        this.app = app;
        this.filters = filters;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new PropertyViewModel(filters);
    }
}
