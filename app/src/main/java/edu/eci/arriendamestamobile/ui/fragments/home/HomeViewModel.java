package edu.eci.arriendamestamobile.ui.fragments.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.Map;

import edu.eci.arriendamestamobile.model.Property;
import edu.eci.arriendamestamobile.repository.impl.PropertyRepository;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<List<Property>> properties = new MutableLiveData<>();
    private final PropertyRepository repository = PropertyRepository.getInstance();

    public HomeViewModel(Map<String, String> filters) {
        getProperties(filters);
    }

    public void getProperties(Map<String, String> filters) {
        properties = repository.getProperties(filters);
    }

    public LiveData<List<Property>> getProperties() {
        return properties;
    }
}