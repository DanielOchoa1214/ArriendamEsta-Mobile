package edu.eci.arriendamestamobile.ui.fragments.notifications.subnotificationfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import edu.eci.arriendamestamobile.databinding.FragmentNotificationsBinding;
import edu.eci.arriendamestamobile.databinding.FragmentSubNotificationsBinding;
import edu.eci.arriendamestamobile.ui.fragments.notifications.NotificationsFragment;
import edu.eci.arriendamestamobile.ui.fragments.notifications.NotificationsViewModel;
import edu.eci.arriendamestamobile.ui.fragments.properties.PropertyAdapter;
import edu.eci.arriendamestamobile.ui.fragments.properties.PropertyViewModel;
import edu.eci.arriendamestamobile.ui.fragments.utils.NotificationViewModelFactory;
import edu.eci.arriendamestamobile.ui.utils.PropertyViewModelFactory;

public class NotificationsSubFragment extends Fragment {
    private FragmentSubNotificationsBinding binding;
    private Map<String, String> filters = new HashMap<>();

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

        NotificationsViewModel notificationsViewModel = new ViewModelProvider(this,
                new NotificationViewModelFactory(this.requireActivity().getApplication(), filters))
                .get(NotificationsViewModel.class);

        notificationsViewModel.getPetitions().observe(getViewLifecycleOwner(), petitions -> {
            RecyclerView recyclerView = binding.petitionList;
            recyclerView.setAdapter(new NotificationAdapter(petitions,  this.getContext()));
        });

        return root;
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
