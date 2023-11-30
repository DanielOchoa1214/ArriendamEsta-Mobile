package edu.eci.arriendamestamobile.ui.fragments.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import edu.eci.arriendamestamobile.R;
import edu.eci.arriendamestamobile.databinding.FragmentHomeBinding;
import edu.eci.arriendamestamobile.ui.fragments.properties.PropertyAdapter;
import edu.eci.arriendamestamobile.ui.fragments.properties.PropertyViewModel;
import edu.eci.arriendamestamobile.ui.fragments.utils.HomeViewModelFactory;
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

import java.util.HashMap;
import java.util.Map;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;
    private Map<String, String> filters = new HashMap<>();


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this,
                new HomeViewModelFactory(this.requireActivity().getApplication(), filters))
                .get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        Spinner spinnerLocations = binding.spinnerLocations;

        //Adapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.
                createFromResource(container.getContext(), R.array.locations, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerLocations.setAdapter(adapter);
        //

        homeViewModel.getProperties().observe(getViewLifecycleOwner(), properties -> {
            RecyclerView recyclerView = binding.propertyList;
            recyclerView.setAdapter(new PropertyAdapter(properties, this.getContext()));
        });

        //addlistener
        binding.searchButton.setOnClickListener(v -> updateListProperties());

        return binding.getRoot();
    }

    public void updateListProperties() {
        filters = new HashMap<>();

        if (!binding.spinnerLocations.getSelectedItem().toString().equals("Ninguno")) {
            filters.put("location", binding.spinnerLocations.getSelectedItem().toString());
        }
        filters.put("squareMeters", binding.minSquareMeters.getText().toString().equals("") ? "0" : binding.minSquareMeters.getText().toString());
        filters.put("price", binding.minPrice.getText().toString().equals("") ? "0" : binding.minPrice.getText().toString());

        homeViewModel.getProperties(filters);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}