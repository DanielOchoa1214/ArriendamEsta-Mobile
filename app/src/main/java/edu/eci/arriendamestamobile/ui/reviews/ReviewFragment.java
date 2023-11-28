package edu.eci.arriendamestamobile.ui.reviews;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

import edu.eci.arriendamestamobile.databinding.FragmentProfileReviewsBinding;
import edu.eci.arriendamestamobile.ui.profileInfo.ProfileInfoViewModel;
import edu.eci.arriendamestamobile.ui.utils.ReviewsViewModelFactory;

public class ReviewFragment extends Fragment {

    private FragmentProfileReviewsBinding binding;
    private String target;
    private String id;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments();
        if (args != null) {
            target = args.getString("target", "user");
            id = args.getString("id", "u1");
        }
        ReviewsViewModel reviewsViewModel = new ViewModelProvider(this,
                new ReviewsViewModelFactory(this.requireActivity().getApplication(), target, id))
                .get(ReviewsViewModel.class);

        binding = FragmentProfileReviewsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        reviewsViewModel.getReviews().observe(getViewLifecycleOwner(), reviews -> {
            RecyclerView recyclerView = binding.reviewsList;
            recyclerView.setAdapter(new ReviewAdapter(this.getContext(), reviews));
        });

        return root;
    }

    public static ReviewFragment getInstance(String target, String id){
        ReviewFragment r = new ReviewFragment();
        Bundle args = new Bundle();
        args.putString("target", target);
        args.putString("id", id);
        r.setArguments(args);
        return r;
    }
}
