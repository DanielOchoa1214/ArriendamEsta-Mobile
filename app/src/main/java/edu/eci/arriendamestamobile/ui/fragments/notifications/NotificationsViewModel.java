package edu.eci.arriendamestamobile.ui.fragments.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.eci.arriendamestamobile.model.Petition;
import edu.eci.arriendamestamobile.model.Property;
import edu.eci.arriendamestamobile.repository.impl.PetitionRepository;
import edu.eci.arriendamestamobile.repository.impl.PropertyRepository;

public class NotificationsViewModel extends ViewModel {

    private MutableLiveData<List<Petition>> petitions = new MutableLiveData<>();
    private final PetitionRepository repository = PetitionRepository.getInstance();

    public NotificationsViewModel(Map<String, String> filters) {
        getPetitions(filters);
    }

    public void getPetitions(Map<String, String> filters) {
        petitions = repository.getPetitions(filters);
    }

    public LiveData<List<Petition>> getPetitions() {
        return petitions;
    }

}