package edu.eci.arriendamestamobile.repository.utils;

import edu.eci.arriendamestamobile.repository.interfaces.AuthApiService;
import edu.eci.arriendamestamobile.repository.interfaces.PropertyApiService;
import edu.eci.arriendamestamobile.repository.interfaces.ReviewsApiService;
import edu.eci.arriendamestamobile.repository.interfaces.UserApiService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private static final String BASE_URL = "http://localhost:8080/";
    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static UserApiService getUserInterface() {
        return retrofit.create(UserApiService.class);
    }

    public static ReviewsApiService getReviewInterface(){
        return retrofit.create(ReviewsApiService.class);
    }

    public static PropertyApiService getPropertyInterface(){
        return retrofit.create(PropertyApiService.class);
    }

    public static AuthApiService getAuthInterface(){
        return retrofit.create(AuthApiService.class);
    }
}
