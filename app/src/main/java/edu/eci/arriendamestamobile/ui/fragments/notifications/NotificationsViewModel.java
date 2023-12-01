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

    private MutableLiveData<List<Petition>> requestPetitions = new MutableLiveData<>();
    private MutableLiveData<List<Petition>> receivePetitions = new MutableLiveData<>();
    private final PetitionRepository repository = PetitionRepository.getInstance();

    public MutableLiveData<List<Petition>> getRequestPetition(Map<String, String> filters) {
        return requestPetitions = repository.getPetitions(filters);
    }

    public MutableLiveData<List<Petition>> getReceivePetition(Map<String, String> filters) {
        return receivePetitions = repository.getPetitions(filters);
    }


}