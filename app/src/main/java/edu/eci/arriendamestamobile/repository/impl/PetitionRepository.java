package edu.eci.arriendamestamobile.repository.impl;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import edu.eci.arriendamestamobile.model.Petition;
import edu.eci.arriendamestamobile.model.Property;
import edu.eci.arriendamestamobile.repository.interfaces.PetitionApiService;
import edu.eci.arriendamestamobile.repository.interfaces.PropertyApiService;
import edu.eci.arriendamestamobile.repository.utils.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PetitionRepository {
    private static final PetitionApiService petitionApiService = RetrofitService.getPetitionInterface();
    private static PetitionRepository repository;
    private MutableLiveData<List<Petition>> receivePetitions = new MutableLiveData<>(placeholderProperties());
    private MutableLiveData<List<Petition>> requestPetitions = new MutableLiveData<>(placeholderProperties());
    public static PetitionRepository getInstance(){
        if(repository == null) repository = new PetitionRepository();
        return repository;
    }

    public MutableLiveData<List<Petition>> getPetitions(Map<String, String> filters) {
        if (filters.containsKey("ownerId")) {
            return petitions(receivePetitions, filters);
        } else {
            return petitions(requestPetitions, filters);
        }
    }

    private MutableLiveData<List<Petition>> petitions(MutableLiveData<List<Petition>> petitionsList, Map<String, String> filters) {
        Call<List<Petition>> reviewsCall = petitionApiService.getPetitions(filters);
        reviewsCall.enqueue(new Callback<List<Petition>>() {
            @Override
            public void onResponse(Call<List<Petition>> call, Response<List<Petition>> response) {
                Log.d("Petition request", response.body().toString());
                petitionsList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Petition>> call, Throwable t) {
                Log.d("Log.DEBUG", "Me ñañe", t);
            }
        });
        return petitionsList;
    }

    private List<Petition> placeholderProperties(){
        Petition p1 = new Petition("p1", false, "Me puedes alquilar la casa", "u1", "u2", "p1");
        Petition p2 = new Petition("p2", false, "Me puedes alquilar la casa", "u2", "u2", "p1");
        Petition p3 = new Petition("p3", false, "Me puedes alquilar la casa", "u3", "u2", "p1");
        return Arrays.asList(p1, p2, p3);
    }
}
