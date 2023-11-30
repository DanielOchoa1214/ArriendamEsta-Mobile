package edu.eci.arriendamestamobile.repository.impl;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import edu.eci.arriendamestamobile.model.Property;
import edu.eci.arriendamestamobile.model.Review;
import edu.eci.arriendamestamobile.repository.interfaces.PropertyApiService;
import edu.eci.arriendamestamobile.repository.utils.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PropertyRepository {

    private static final PropertyApiService propertyApiService = RetrofitService.getPropertyInterface();
    private static PropertyRepository repository;
    private MutableLiveData<List<Property>> properties = new MutableLiveData<>(placeholderProperty());
    public static PropertyRepository getInstance(){
        if(repository == null) repository = new PropertyRepository();
        return repository;
    }

    public MutableLiveData<List<Property>> getProperties(Map<String, String> filters){
        Call<List<Property>> reviewsCall = propertyApiService.getProperties(filters);
        reviewsCall.enqueue(new Callback<List<Property>>() {
            @Override
            public void onResponse(Call<List<Property>> call, Response<List<Property>> response) {
                Log.d("PropertyRepository", response.body().toString());
                properties.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Property>> call, Throwable t) {
                Log.d("Log.DEBUG", "Me ñañe", t);
            }
        });
        return properties;
    }

    private List<Property> placeholderProperty(){
        Property p1 = new Property();
        p1.setTitle("Casoplon");
        p1.setDescription("Le pongo 5 estrellas solo porque si");
        p1.setLocation("Suba");
        p1.setSquareMeters(1000);
        p1.setPrice(1000);
        Property p2 = new Property();
        p2.setTitle("Casoplon 2");
        p2.setDescription("Le pongo 5 estrellas solo porque si");
        p2.setLocation("Suba");
        p2.setSquareMeters(1000);
        p2.setPrice(1000);
        Property p3 = new Property();
        p3.setTitle("Casoplon 3");
        p3.setDescription("Le pongo 5 estrellas solo porque si");
        p3.setLocation("Suba");
        p3.setSquareMeters(1000);
        p3.setPrice(1000);
        Property p4 = new Property();
        p4.setTitle("Casoplon 4");
        p4.setDescription("Le pongo 5 estrellas solo porque si");
        p4.setLocation("Suba");
        p4.setSquareMeters(1000);
        p4.setPrice(1000);
        return Arrays.asList(p1, p2, p3, p4);
    }
}
