package edu.eci.arriendamestamobile.repository.interfaces;

import java.util.List;

import edu.eci.arriendamestamobile.model.Review;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ReviewsApiService {

    @GET("v1/review/{target}/{id}")
    Call<List<Review>> getReviews(@Path("target") String target, @Path("id") String id);
}
