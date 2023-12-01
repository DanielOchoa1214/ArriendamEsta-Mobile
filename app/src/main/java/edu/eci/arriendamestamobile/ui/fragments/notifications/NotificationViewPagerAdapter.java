package edu.eci.arriendamestamobile.ui.fragments.notifications;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.HashMap;
import java.util.Map;

import edu.eci.arriendamestamobile.ui.fragments.notifications.subnotificationfragment.NotificationsSubFragment;

public class NotificationViewPagerAdapter extends FragmentStateAdapter {
    private String id;

    public NotificationViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public NotificationViewPagerAdapter(@NonNull FragmentActivity fragmentActivity, String id) {
        super(fragmentActivity);
        this.id = id;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Map<String, String> filters = new HashMap<>();
        switch (position){
            case 1:
                filters.put("homeOwnerId", id);
                return NotificationsSubFragment.getInstance(filters);
            default:
                filters.put("authorId", id);
                return NotificationsSubFragment.getInstance(filters);
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

