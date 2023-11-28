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
        Review r1 = new Review();
        r1.setName("Zenitsu");
        r1.setContent("Le pongo 5 estrellas solo porque me quiero comer a su hermana");
        r1.setStars(5);
        Review r2 = new Review();
        r2.setName("Inosuke");
        r2.setContent("1 estrellas porque no quiere pelear conmigo todo el tiempo");
        r2.setStars(1);
        Review r3 = new Review();
        r3.setName("Musan Kibutsuyi");
        r3.setContent("me quiere matar :(");
        r3.setStars(0);
        Review r4 = new Review();
        r4.setName("Uzui");
        r4.setContent("4 estrellas me cae muy bien");
        r4.setStars(4);
        return Arrays.asList(r1, r2, r3, r4);
    }
}
