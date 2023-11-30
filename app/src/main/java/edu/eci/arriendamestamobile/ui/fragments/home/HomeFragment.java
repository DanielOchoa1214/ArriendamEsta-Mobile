package edu.eci.arriendamestamobile.ui.fragments.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import edu.eci.arriendamestamobile.ui.home.HomeViewModel;
import edu.eci.arriendamestamobile.R;
import edu.eci.arriendamestamobile.databinding.FragmentHomeBinding;
import edu.eci.arriendamestamobile.ui.properties.PropertyAdapter;
import edu.eci.arriendamestamobile.ui.properties.PropertyViewModel;
import edu.eci.arriendamestamobile.ui.utils.PropertyViewModelFactory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private PropertyViewModel propertyViewModel;
    private Map<String, String> filters;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        propertyViewModel = new ViewModelProvider(this,
                new PropertyViewModelFactory(this.requireActivity().getApplication(), filters))
                .get(PropertyViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        Spinner spinnerLocations = binding.spinnerLocations;

        //Adapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.
                createFromResource(container.getContext(), R.array.locations, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerLocations.setAdapter(adapter);
        //

        propertyViewModel.getProperties().observe(getViewLifecycleOwner(), properties -> {
            RecyclerView recyclerView = binding.propertyList;
            recyclerView.setAdapter(new PropertyAdapter(properties, this.getContext()));
        });

        //addlistener
        binding.searchButton.setOnClickListener(v -> updateListProperties());

        return binding.getRoot();
    }

    public void updateListProperties() {
        try {
            filters.put("location", binding.spinnerLocations.getSelectedItem().toString());
            filters.put("squareMeters", binding.minSquareMeters.toString());
            filters.put("price", binding.minPrice.toString());
            propertyViewModel.getProperties(filters);
        } catch (Exception e) {
            propertyViewModel.getProperties();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}