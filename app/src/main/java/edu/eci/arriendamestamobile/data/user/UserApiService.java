package edu.eci.arriendamestamobile.data.user;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserApiService {

    @GET("v1/user/{id}")
    Call<User> getUserById(@Path("id") String id);
}
