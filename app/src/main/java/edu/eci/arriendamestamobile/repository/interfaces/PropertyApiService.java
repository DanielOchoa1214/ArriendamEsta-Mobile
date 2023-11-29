package edu.eci.arriendamestamobile.repository.interfaces;

import edu.eci.arriendamestamobile.model.Property;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PropertyApiService {

    @GET("v1/property/{id}")
    Call<Property> getPropertyById(@Path("id") String id);

}
