package edu.eci.arriendamestamobile.repository.interfaces;


import edu.eci.arriendamestamobile.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AuthApiService {

    @POST("v1/auth")
    Call<User> login(@Body User user);
}
