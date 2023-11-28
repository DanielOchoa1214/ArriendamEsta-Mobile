package edu.eci.arriendamestamobile.repository.impl;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import edu.eci.arriendamestamobile.model.Review;
import edu.eci.arriendamestamobile.repository.interfaces.ReviewsApiService;
import edu.eci.arriendamestamobile.repository.utils.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReviewsRepository {

    private static final ReviewsApiService reviewsApiService = RetrofitService.getReviewInterface();
    private final MutableLiveData<List<Review>> reviews = new MutableLiveData<>(placeholderReview());
    private static ReviewsRepository repository;

    public static ReviewsRepository getInstance(){
        if(repository == null) repository = new ReviewsRepository();
        return repository;
    }

    public MutableLiveData<List<Review>> getReviews(String target, String id){
        Call<List<Review>> reviewsCall = reviewsApiService.getReviews(target, id);
        reviewsCall.enqueue(new Callback<List<Review>>() {
            @Override
            public void onResponse(Call<List<Review>> call, Response<List<Review>> response) {
                reviews.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Review>> call, Throwable t) {
                Log.d("Log.DEBUG", "Me ñañe", t);
            }
        });
        return reviews;
    }


    private List<Review> placeholderReview(){
        Review r = new Review();
        r.setName("Zenitsu");
        r.setContent("Le pongo 5 estrellas solo porque me quiero comer a su hermana");
        r.setStars(5);
        return Collections.singletonList(r);
    }
}
