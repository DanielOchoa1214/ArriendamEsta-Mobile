package edu.eci.arriendamestamobile.ui.profileInfo;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import edu.eci.arriendamestamobile.databinding.FragmentProfileInfoBinding;

public class ProfileInfoFragment extends Fragment {

    private FragmentProfileInfoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ProfileInfoViewModel profileInfoViewModel = new ViewModelProvider(this).get(ProfileInfoViewModel.class);

        binding = FragmentProfileInfoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        setFragmentContents(profileInfoViewModel);

        return root;
    }

    private void setFragmentContents(ProfileInfoViewModel profileInfoViewModel){
        profileInfoViewModel.getUserInfo().observe(getViewLifecycleOwner(), userInfo -> {
            TextView emailRowValue = binding.emailRowValue;
            emailRowValue.setText(userInfo.getEmail());

            TextView contactRowValue = binding.contactRowValue;
            contactRowValue.setText(userInfo.getPhoneNumber());

            TextView ageRowValue = binding.ageRowValue;
            ageRowValue.setText(getAge(userInfo.getBirthDate()));

            TextView genderRowValue = binding.genderRowValue;
            genderRowValue.setText(userInfo.getGender());
        });
    }

    private int getAge(Date birthDate){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return Period.between(birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now()).getYears();
        }
        return 0;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
