package edu.eci.arriendamestamobile.ui.profile;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import edu.eci.arriendamestamobile.ui.profileInfo.ProfileInfoFragment;
import edu.eci.arriendamestamobile.ui.properties.PropertiesFragment;
import edu.eci.arriendamestamobile.ui.reviews.ReviewFragment;

public class ProfileViewPagerAdapter extends FragmentStateAdapter {
    private String id;
    private String target;
    public ProfileViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public ProfileViewPagerAdapter(@NonNull FragmentActivity fragmentActivity, String id, String target) {
        super(fragmentActivity);
        this.id = id;
        this.target = target;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return ReviewFragment.getInstance(target, id);
            case 2:
                return new PropertiesFragment();
            default:
                return new ProfileInfoFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
