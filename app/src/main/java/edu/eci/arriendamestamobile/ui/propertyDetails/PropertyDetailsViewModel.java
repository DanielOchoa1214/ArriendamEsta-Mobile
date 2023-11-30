package edu.eci.arriendamestamobile.ui.propertyDetails;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.HashMap;

import edu.eci.arriendamestamobile.model.Property;
import edu.eci.arriendamestamobile.repository.impl.PropertyRepository;

public class PropertyDetailsViewModel extends ViewModel {

    private MutableLiveData<Property> property;
    private final PropertyRepository repository = PropertyRepository.getInstance();

    public PropertyDetailsViewModel(){
        getPropertyById("u1");
    }
    public void getPropertyById(String id){
        property = repository.getPropertyById(id);
    }

    public LiveData<Property> getProperty(){
        return property;
    }
}
