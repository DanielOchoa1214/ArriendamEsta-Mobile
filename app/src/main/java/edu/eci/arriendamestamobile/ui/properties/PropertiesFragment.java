package edu.eci.arriendamestamobile.ui.properties;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import edu.eci.arriendamestamobile.R;
import edu.eci.arriendamestamobile.databinding.FragmentProfileReviewsBinding;
import edu.eci.arriendamestamobile.databinding.FragmentPropertiesBinding;
import edu.eci.arriendamestamobile.model.Property;
import edu.eci.arriendamestamobile.repository.impl.PropertyRepository;
import edu.eci.arriendamestamobile.ui.reviews.ReviewAdapter;
import edu.eci.arriendamestamobile.ui.reviews.ReviewFragment;
import edu.eci.arriendamestamobile.ui.reviews.ReviewsViewModel;
import edu.eci.arriendamestamobile.ui.utils.PropertyViewModelFactory;
import edu.eci.arriendamestamobile.ui.utils.ReviewsViewModelFactory;

public class PropertiesFragment extends Fragment {

    private Map<String, String> filters;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle args = getArguments();
        if (args != null) {

            ArrayList<String> keys = args.getStringArrayList("keys");
            ArrayList<String> values = args.getStringArrayList("values");

            filters = IntStream.range(0, keys.size())
                    .boxed()
                    .collect(Collectors.toMap(keys::get, values::get));
        }

        FragmentPropertiesBinding binding = FragmentPropertiesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        PropertyViewModel propertyViewModel = new ViewModelProvider(this,
                new PropertyViewModelFactory(this.requireActivity().getApplication(), filters))
                .get(PropertyViewModel.class);

        propertyViewModel.getProperties().observe(getViewLifecycleOwner(), properties -> {
            RecyclerView recyclerView = binding.propertyList;
            recyclerView.setAdapter(new PropertyAdapter(properties, this.getContext()));
        });

        return root;
    }


    //Dependiendo de los argumentos crea la instancia correspondiente
    public static PropertiesFragment getInstance(Map<String, String> filters) {
        PropertiesFragment p = new PropertiesFragment();
        Bundle args = new Bundle();
        args.putStringArrayList("keys", new ArrayList<>(filters.keySet()));
        args.putStringArrayList("values", new ArrayList<>(filters.values()));
        p.setArguments(new Bundle());
        return p;
    }
}