package edu.eci.arriendamestamobile.ui.fragments.utils;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.Map;

import edu.eci.arriendamestamobile.ui.fragments.home.HomeViewModel;
import edu.eci.arriendamestamobile.ui.fragments.notifications.NotificationsViewModel;

public class NotificationViewModelFactory implements ViewModelProvider.Factory {
    private Application app;
    private Map<String, String> filters;

    public NotificationViewModelFactory(Application app, Map<String, String> filters) {
        this.app = app;
        this.filters = filters;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new NotificationsViewModel(filters);
    }
}
