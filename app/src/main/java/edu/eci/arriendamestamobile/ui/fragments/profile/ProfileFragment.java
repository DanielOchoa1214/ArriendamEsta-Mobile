package edu.eci.arriendamestamobile.ui.fragments.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import edu.eci.arriendamestamobile.databinding.FragmentProfileBinding;
import edu.eci.arriendamestamobile.persistence.databases.AppDatabase;
import edu.eci.arriendamestamobile.ui.activities.LaunchActivity;
import edu.eci.arriendamestamobile.ui.activities.MainActivity;
import edu.eci.arriendamestamobile.ui.activities.login.LoginActivity;
import edu.eci.arriendamestamobile.ui.fragments.utils.SessionInfo;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;
    private String userId;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ProfileViewModel profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);

        binding = FragmentProfileBinding.inflate(inflater, container, false);

        setLogOutListener();
        setFragmentContent(profileViewModel);
        setUpTabs();

        return binding.getRoot();
    }

    private void setUpTabs() {
        TabLayout tabLayout = binding.profileTabs;
        ViewPager2 viewPager2 = binding.profileViewPager;
        ProfileViewPagerAdapter viewPagerAdapter = new ProfileViewPagerAdapter(this.requireActivity(), SessionInfo.SESSION_ID, "user");
        viewPager2.setAdapter(viewPagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Objects.requireNonNull(tabLayout.getTabAt(position)).select();
            }
        });
    }

    private void setFragmentContent(ProfileViewModel profileViewModel) {
        profileViewModel.getUser().observe(getViewLifecycleOwner(), user -> {
            TextView profileName = binding.profileName;
            profileName.setText(user.getName());
        });
    }

    private void setLogOutListener(){
        binding.logoutBtn.setOnClickListener(v -> {
            Executor executor = Executors.newSingleThreadExecutor();
            executor.execute(() -> {
                AppDatabase db = AppDatabase.getInstance(getContext());
                db.clearAllTables();
            });
            SessionInfo.SESSION_ID = "";
            Intent toLogin = new Intent(getActivity(), LoginActivity.class);
            startActivity(toLogin);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
