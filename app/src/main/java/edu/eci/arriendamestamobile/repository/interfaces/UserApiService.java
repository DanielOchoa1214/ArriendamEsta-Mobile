package edu.eci.arriendamestamobile.repository.interfaces;

import edu.eci.arriendamestamobile.model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserApiService extends Service{

    @GET("v1/user/{id}")
    Call<User> getUserById(@Path("id") String id);
}
