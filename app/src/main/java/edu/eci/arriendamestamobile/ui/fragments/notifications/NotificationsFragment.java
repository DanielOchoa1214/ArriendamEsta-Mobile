package edu.eci.arriendamestamobile.ui.fragments.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import edu.eci.arriendamestamobile.databinding.FragmentNotificationsBinding;
import edu.eci.arriendamestamobile.ui.fragments.profile.ProfileViewPagerAdapter;
import edu.eci.arriendamestamobile.ui.fragments.properties.PropertiesFragment;
import edu.eci.arriendamestamobile.ui.fragments.properties.PropertyAdapter;
import edu.eci.arriendamestamobile.ui.fragments.utils.SessionInfo;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    private Map<String, String> filters = new HashMap<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        setUpTabs();

        return root;
    }

    private void setUpTabs() {
        TabLayout tabLayout = binding.notificationsTabs;
        ViewPager2 viewPager2 = binding.notificationViewPager;
        NotificationViewPagerAdapter viewPagerAdapter = new NotificationViewPagerAdapter(this.requireActivity(), SessionInfo.SESSION_ID);
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


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}