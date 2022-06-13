package com.app.spidermanager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.app.spidermanager.adapters.NotificationsAdapter;
import com.app.spidermanager.databinding.NotificationsFragmentBinding;
import com.app.spidermanager.mapping.NotificationItemModelToUpdNotificationModelMapper;
import com.app.spidermanager.models.NotificationItemModel;
import com.app.spidermanager.models.NotificationListModel;
import com.app.spidermanager.services.NotificationsService;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Фрагмент для отображения и обновления списка оповещений
 */
public class NotificationFragment extends Fragment {
    private NotificationsFragmentBinding binding;
    private NotificationListModel modelBinding;
    private NotificationsService service;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        binding = NotificationsFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        service = new NotificationsService(getContext());
        setBinding();
        buildNotificationList();

        binding.buttonBack.setOnClickListener(v ->
                NavHostFragment.findNavController(NotificationFragment.this)
                .navigate(R.id.action_NotificationsFragment_to_SpidersFragment));
        binding.buttonSave.setOnClickListener(v -> save());
    }

    /**
     * Построение списка оповещений
     */
    private void buildNotificationList() {
        RecyclerView recyclerView = requireView().findViewById(R.id.notifications_list);
        NotificationsAdapter adapter = new NotificationsAdapter(this.requireContext(), modelBinding);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    /**
     * Назначение модели привязки
     */
    private void setBinding() {
        modelBinding = new NotificationListModel();
        modelBinding.setItems(service.getAll());
    }

    /**
     * Сохранение оповещений
     */
    private void save(){
        try{
            ArrayList<NotificationItemModel> items = modelBinding.getItems();
            if(items.size() > 0)
                service.update(items.stream().
                        map(n -> new NotificationItemModelToUpdNotificationModelMapper().map(n)).
                        collect(Collectors.toList()));
            Toast.makeText(getContext(), "Сохранено", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(getContext(), "Cохранение не удалось, проверьте введенные данные",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
