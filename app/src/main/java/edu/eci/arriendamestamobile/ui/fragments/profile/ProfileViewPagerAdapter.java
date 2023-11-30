package edu.eci.arriendamestamobile.ui.fragments.profile;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;


import java.util.HashMap;
import java.util.Map;

import edu.eci.arriendamestamobile.ui.fragments.profileInfo.ProfileInfoFragment;
import edu.eci.arriendamestamobile.ui.fragments.properties.PropertiesFragment;
import edu.eci.arriendamestamobile.ui.fragments.reviews.ReviewFragment;
import edu.eci.arriendamestamobile.ui.propertyDetails.PropertyDetailsFragment;

public class ProfileViewPagerAdapter extends FragmentStateAdapter {
    private String id;
    private String target;
    private Map<String, String> filters = new HashMap<>();
    public ProfileViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public ProfileViewPagerAdapter(@NonNull FragmentActivity fragmentActivity, String id, String target) {
        super(fragmentActivity);
        this.id = id;
        this.target = target;
        this.filters.put("homeOwnerId", id);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return ReviewFragment.getInstance(target, id);
            case 2:
                return PropertiesFragment.getInstance(filters);
            default:
                return new ProfileInfoFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
