package edu.eci.arriendamestamobile.repository.interfaces;

import java.util.List;
import java.util.Map;

import edu.eci.arriendamestamobile.model.Petition;
import edu.eci.arriendamestamobile.model.Property;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface PetitionApiService {

    @GET("v1/petition")
    Call<List<Petition>> getPetitions(@QueryMap Map<String, String> filters);

}
