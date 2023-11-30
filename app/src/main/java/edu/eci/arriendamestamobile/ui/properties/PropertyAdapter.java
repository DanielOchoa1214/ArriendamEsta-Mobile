package edu.eci.arriendamestamobile.ui.properties;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.eci.arriendamestamobile.R;
import edu.eci.arriendamestamobile.model.Property;

public class PropertyAdapter extends RecyclerView.Adapter<PropertyAdapter.PropertyItemViewHolder> {

    private List<Property> propertyList;
    private Context context;

    public PropertyAdapter(List<Property> propertyList, Context context) {
        this.propertyList = propertyList;
        this.context = context;
    }

    @NonNull
    @Override
    public PropertyItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View adapterLayout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.property_item, parent, false);
        return new PropertyItemViewHolder(adapterLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull PropertyItemViewHolder holder, int position) {
        Property property = propertyList.get(position);
        holder.title.setText(property.getTitle());
        holder.location.setText(property.getLocation());
        holder.square_meters.setText(String.valueOf(property.getSquareMeters()));
        holder.price.setText(String.valueOf(property.getPrice()));
    }

    @Override
    public int getItemCount() {
        return propertyList.size();
    }

    public class PropertyItemViewHolder extends RecyclerView.ViewHolder {

        protected TextView title;
        protected TextView location;
        protected TextView square_meters;
        protected TextView price;

        public PropertyItemViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.property_name);
            location = view.findViewById(R.id.location_value);
            square_meters = view.findViewById(R.id.square_meters_value);
            price = view.findViewById(R.id.price_value);
        }

    }
}
