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

public class NotificationReceiveAdapter extends RecyclerView.Adapter<NotificationReceiveAdapter.PetitionRecieveItemViewHolder> {

    private List<Petition> petitionList;
    private Context context;

    public NotificationReceiveAdapter(List<Petition> petitionList, Context context) {
        this.petitionList = petitionList;
        this.context = context;
    }

    @NonNull
    @Override
    public PetitionRecieveItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View adapterLayout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.petition_recieve_item, parent, false);
        return new PetitionRecieveItemViewHolder(adapterLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull PetitionRecieveItemViewHolder holder, int position) {
        Petition petition = petitionList.get(position);
        holder.authorId.setText(petition.getAuthorId());
        holder.propertyId.setText(petition.getPropertyId());
        holder.content.setText(String.valueOf(petition.getContent()));
    }

    @Override
    public int getItemCount() {
        return petitionList.size();
    }

    public class PetitionRecieveItemViewHolder extends RecyclerView.ViewHolder {

        protected TextView authorId;
        protected TextView propertyId;
        protected TextView content;

        public PetitionRecieveItemViewHolder(View view) {
            super(view);
            authorId = view.findViewById(R.id.owner_value);
            propertyId = view.findViewById(R.id.property_value);
            content = view.findViewById(R.id.content_value);
        }

    }
}
