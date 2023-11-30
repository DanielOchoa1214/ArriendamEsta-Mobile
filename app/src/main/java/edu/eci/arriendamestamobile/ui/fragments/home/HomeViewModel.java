package edu.eci.arriendamestamobile.ui.fragments.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.Map;

import edu.eci.arriendamestamobile.model.Property;
import edu.eci.arriendamestamobile.repository.impl.PropertyRepository;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<List<Property>> propertiesHome = new MutableLiveData<>();
    private final PropertyRepository repository = PropertyRepository.getInstance();

    public HomeViewModel(Map<String, String> filters) {
        getProperties(filters);
    }

    public void getProperties(Map<String, String> filters) {
        propertiesHome = repository.getPropertiesHome(filters);
    }

    public LiveData<List<Property>> getProperties() {
        return propertiesHome;
    }
}