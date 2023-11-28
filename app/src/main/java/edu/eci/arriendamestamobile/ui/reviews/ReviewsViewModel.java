package edu.eci.arriendamestamobile.ui.reviews;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import edu.eci.arriendamestamobile.model.Review;
import edu.eci.arriendamestamobile.repository.impl.ReviewsRepository;

public class ReviewsViewModel extends ViewModel {

    private MutableLiveData<List<Review>> reviews = new MutableLiveData<>();
    private final ReviewsRepository repository = ReviewsRepository.getInstance();

    public ReviewsViewModel(String target, String id){
        getReviews(target, id);
    }

    public void getReviews(String target, String id){
        reviews = repository.getReviews(target, id);
    }
    public LiveData<List<Review>> getReviews() {
        return reviews;
    }
}
