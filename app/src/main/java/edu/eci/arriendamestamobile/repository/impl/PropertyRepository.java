package edu.eci.arriendamestamobile.repository.impl;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import edu.eci.arriendamestamobile.model.Property;

import edu.eci.arriendamestamobile.repository.interfaces.PropertyApiService;
import edu.eci.arriendamestamobile.repository.utils.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PropertyRepository {

    private static final PropertyApiService propertyApiService = RetrofitService.getPropertyInterface();
    private static PropertyRepository repository;
    private MutableLiveData<List<Property>> properties = new MutableLiveData<>(placeholderProperties());
    private MutableLiveData<List<Property>> propertiesProfile = new MutableLiveData<>(placeholderProperties());
    private final MutableLiveData<Property> property = new MutableLiveData<>(placeholderProperty());
    public static PropertyRepository getInstance(){
        if(repository == null) repository = new PropertyRepository();
        return repository;
    }

    public MutableLiveData<List<Property>> getPropertiesProfile(Map<String, String> filters) {
        //Log.d("Properties Repository", filters.toString());
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

    public MutableLiveData<List<Property>> getPropertiesHome(Map<String, String> filters) {
        //Log.d("Properties Repository", filters.toString());
        Call<List<Property>> reviewsCall = propertyApiService.getProperties(filters);
        reviewsCall.enqueue(new Callback<List<Property>>() {
            @Override
            public void onResponse(Call<List<Property>> call, Response<List<Property>> response) {
                Log.d("PropertyRepository", response.body().toString());
                propertiesProfile.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Property>> call, Throwable t) {
                Log.d("Log.DEBUG", "Me ñañe", t);
            }
        });
        return propertiesProfile;
    }

    public MutableLiveData<Property> getPropertyById(String id){
        Call<Property> propertyCall = propertyApiService.getPropertyById(id);
        propertyCall.enqueue(new Callback<Property>(){
            @Override
            public void onResponse(Call<Property> call, Response<Property> response) {
                property.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Property> call, Throwable t) {
                Log.d("Log.DEBUG", "Toy dañado en property", t);
            }
        });
        return property;
    }


    private List<Property> placeholderProperties(){
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

    private Property placeholderProperty(){
        Property p = new Property();
        p.setTitle("Barbie House");
        p.setId("p1");
        p.setDescription("Casa con tantas habitaciones como barbies hay." +
                "El agua falsa y los accesorios no vienen incluidos, todos" +
                "los detalles en la casa son rosados de diferentes tonos," +
                "el precio del canon de arrendamiento no incluye administracion");
        p.setLocation("Barbieland");
        p.setStateProperty("Disponible");
        p.setPrice(10000000);
        p.setSquareMeters(1200);
        p.setHomeOwnerId("u1");
        return p;
    }
}
