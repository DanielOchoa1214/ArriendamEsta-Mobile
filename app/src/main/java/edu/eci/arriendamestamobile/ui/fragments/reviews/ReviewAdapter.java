package edu.eci.arriendamestamobile.ui.fragments.reviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.eci.arriendamestamobile.R;
import edu.eci.arriendamestamobile.model.Review;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>{

    private List<Review> reviewList;
    private Context context;

    public ReviewAdapter(Context context, List<Review> reviewList) {
        this.reviewList = reviewList;
        this.context = context;
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View adapterLayout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.revirew_item, parent, false);
        return new ReviewViewHolder(adapterLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        Review review = reviewList.get(position);
        holder.reviewAuthor.setText(review.getName());
        holder.content.setText(review.getContent());
        holder.score.setText(String.valueOf(review.getStars()));
    }

    @Override
    public int getItemCount() {
        return reviewList.size();
    }

    public class ReviewViewHolder extends RecyclerView.ViewHolder {
        private View view;
        private TextView reviewAuthor;
        private TextView content;
        private TextView score;

        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);
            reviewAuthor = itemView.findViewById(R.id.review_author);
            content = itemView.findViewById(R.id.review_content);
            score = itemView.findViewById(R.id.review_score);
        }
    }
}
