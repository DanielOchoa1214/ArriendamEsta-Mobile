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

public class NotificationRequestAdapter extends RecyclerView.Adapter<NotificationRequestAdapter.PetitionRequestItemViewHolder> {

    private List<Petition> petitionList;
    private Context context;

    public NotificationRequestAdapter(List<Petition> petitionList, Context context) {
        this.petitionList = petitionList;
        this.context = context;
    }

    @NonNull
    @Override
    public PetitionRequestItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View adapterLayout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.petition_request_item, parent, false);
        return new PetitionRequestItemViewHolder(adapterLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull PetitionRequestItemViewHolder holder, int position) {
        Petition petition = petitionList.get(position);
        holder.ownerId.setText(petition.getOwnerId());
        holder.propertyId.setText(petition.getPropertyId());
        holder.content.setText(String.valueOf(petition.getContent()));
    }

    @Override
    public int getItemCount() {
        return petitionList.size();
    }

    public class PetitionRequestItemViewHolder extends RecyclerView.ViewHolder {

        protected TextView ownerId;
        protected TextView propertyId;
        protected TextView content;

        public PetitionRequestItemViewHolder(View view) {
            super(view);
            ownerId = view.findViewById(R.id.owner_value);
            propertyId = view.findViewById(R.id.property_value);
            content = view.findViewById(R.id.content_value);
        }

    }
}
