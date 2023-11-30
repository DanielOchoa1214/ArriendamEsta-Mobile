package edu.eci.arriendamestamobile.repository.interfaces;

import java.util.List;
import java.util.Map;

import edu.eci.arriendamestamobile.model.Property;
import edu.eci.arriendamestamobile.model.Review;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface PropertyApiService {

    @GET("v1/property")
    Call<List<Property>> getProperties(@QueryMap Map<String, String> filters);

    @GET("v1/property/{id}")
    Call<Property> getPropertyById(@Path("id") String id);
}
