package edu.eci.arriendamestamobile.ui.fragments.notifications.subnotificationfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import edu.eci.arriendamestamobile.databinding.FragmentSubNotificationsBinding;
import edu.eci.arriendamestamobile.ui.fragments.notifications.NotificationsViewModel;

public class NotificationsSubFragment extends Fragment {
    private FragmentSubNotificationsBinding binding;
    private Map<String, String> filters = new HashMap<>();

    private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments();

        if (args != null) {

            ArrayList<String> keys = args.getStringArrayList("keys");
            ArrayList<String> values = args.getStringArrayList("values");

            filters = IntStream.range(0, keys.size())
                    .boxed()
                    .collect(Collectors.toMap(keys::get, values::get));
        }

        binding = FragmentSubNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        notificationsViewModel = new NotificationsViewModel();

        injectRecyclerView(filters);

        return root;
    }

    private void injectRecyclerView(Map<String, String> filters) {
        if (filters.containsKey("ownerId")) {
            notificationsViewModel.getReceivePetition(filters).observe(getViewLifecycleOwner(), petitions -> {
                RecyclerView recyclerView = binding.petitionList;
                recyclerView.setAdapter(new NotificationReceiveAdapter(petitions,  this.getContext()));
            });
        } else {
            notificationsViewModel.getRequestPetition(filters).observe(getViewLifecycleOwner(), petitions -> {
                RecyclerView recyclerView = binding.petitionList;
                recyclerView.setAdapter(new NotificationRequestAdapter(petitions,  this.getContext()));
            });
        }
    }

    public static NotificationsSubFragment getInstance(Map<String, String> filters) {
        NotificationsSubFragment n = new NotificationsSubFragment();
        Bundle args = new Bundle();
        args.putStringArrayList("keys", new ArrayList<>(filters.keySet()));
        args.putStringArrayList("values", new ArrayList<>(filters.values()));
        n.setArguments(args);
        return n;
    }
}
