package com.app.spidermanager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.app.spidermanager.adapters.NotificationsAdapter;
import com.app.spidermanager.databinding.NotificationsFragmentBinding;
import com.app.spidermanager.models.NotificationItemModel;

import java.util.ArrayList;

// TODO: Доделать навигацию и заполнение
public class NotificationFragment extends Fragment {
    private NotificationsFragmentBinding binding;
    private final ArrayList<NotificationItemModel> itemModels;

    public NotificationFragment() {
        this.itemModels = new ArrayList<>();
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = NotificationsFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buildSpiderList();
    }

    private void buildSpiderList() {
        RecyclerView recyclerView = requireView().findViewById(R.id.notifications_list);
        setData();

    /* NavHostFragment.findNavController(NotificationFragment.this)
                        .navigate(R.id.action_NotificationFragment_to_SpiderFragment);*/
        NotificationsAdapter adapter = new NotificationsAdapter(this.requireContext(), itemModels);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setData() {

    }

}
