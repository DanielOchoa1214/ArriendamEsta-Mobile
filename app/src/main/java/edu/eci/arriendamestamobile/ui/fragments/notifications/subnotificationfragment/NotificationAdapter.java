package edu.eci.arriendamestamobile.ui.fragments.notifications.subnotificationfragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.eci.arriendamestamobile.R;
import edu.eci.arriendamestamobile.model.Petition;
import edu.eci.arriendamestamobile.model.Property;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.PetitionItemViewHolder> {

    private List<Petition> petitionList;
    private Context context;

    public NotificationAdapter(List<Petition> petitionList, Context context) {
        this.petitionList = petitionList;
        this.context = context;
    }

    @NonNull
    @Override
    public PetitionItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View adapterLayout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.petition_item, parent, false);
        return new PetitionItemViewHolder(adapterLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull PetitionItemViewHolder holder, int position) {
        Petition petition = petitionList.get(position);
        holder.authorId.setText(petition.getAuthorId());
        holder.propertyId.setText(petition.getPropertyId());
        holder.content.setText(String.valueOf(petition.getContent()));
    }

    @Override
    public int getItemCount() {
        return petitionList.size();
    }

    public class PetitionItemViewHolder extends RecyclerView.ViewHolder {

        protected TextView authorId;
        protected TextView propertyId;
        protected TextView content;

        public PetitionItemViewHolder(View view) {
            super(view);
            authorId = view.findViewById(R.id.author_value);
            propertyId = view.findViewById(R.id.property_value);
            content = view.findViewById(R.id.content_value);
        }

    }
}
