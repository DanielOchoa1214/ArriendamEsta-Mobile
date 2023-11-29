package edu.eci.arriendamestamobile.ui.propertyDetails;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.eci.arriendamestamobile.R;
import edu.eci.arriendamestamobile.databinding.FragmentPropertiesBinding;
import edu.eci.arriendamestamobile.databinding.FragmentPropertyDetailsBinding;
import edu.eci.arriendamestamobile.ui.profile.ProfileViewModel;

public class PropertyDetailsFragment extends Fragment {

    private FragmentPropertyDetailsBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        PropertyDetailsViewModel propertyDetailsViewModel = new PropertyDetailsViewModel();

        binding = FragmentPropertyDetailsBinding.inflate(inflater, container, false);

        setFragmentContent(propertyDetailsViewModel);
        return inflater.inflate(R.layout.fragment_properties, container, false);
    }

    private void setFragmentContent(PropertyDetailsViewModel propertyDetailsViewModel){
        propertyDetailsViewModel.getProperty().observe(getViewLifecycleOwner(), property -> {
            TextView profileName = binding.propertyDetailsHeader;
            profileName.setText(property.getTitle());
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}