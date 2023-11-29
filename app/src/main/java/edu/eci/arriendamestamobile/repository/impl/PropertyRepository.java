package edu.eci.arriendamestamobile.repository.impl;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import edu.eci.arriendamestamobile.model.Property;
import edu.eci.arriendamestamobile.repository.interfaces.PropertyApiService;
import edu.eci.arriendamestamobile.repository.utils.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PropertyRepository {

    private static final PropertyApiService propertyApiService = RetrofitService.getPropertyInterface();
    private final MutableLiveData<Property> property = new MutableLiveData<>(placeholderProperty());
    private static PropertyRepository repository;

    public static PropertyRepository getInstance(){
        if (repository == null) repository = new PropertyRepository();
        return repository;
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
