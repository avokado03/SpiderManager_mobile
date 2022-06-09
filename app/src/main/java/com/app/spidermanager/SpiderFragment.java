package com.app.spidermanager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.app.spidermanager.adapters.SpidersAdapter;
import com.app.spidermanager.databinding.SpidersFragmentBinding;
import com.app.spidermanager.models.SpiderItemModel;
import com.app.spidermanager.models.SpiderListModel;
import com.app.spidermanager.services.SpidersService;

import java.util.ArrayList;

public class SpiderFragment extends Fragment {

    private SpidersFragmentBinding binding;
    private SpiderListModel<SpiderItemModel> bindingModel;
    private SpidersService spidersService;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = SpidersFragmentBinding.inflate(inflater, container, false);

        binding.buttonAddSpider.setOnClickListener(v ->
                NavHostFragment.findNavController(SpiderFragment.this)
                .navigate(R.id.action_SpidersFragment_to_CreateSpiderFragment));
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        spidersService = new SpidersService(getContext());
        setBindingModel();
        buildSpiderList();
    }

    private void buildSpiderList() {
        RecyclerView recyclerView = requireView().findViewById(R.id.spiders_list);
        SpidersAdapter.OnSpiderClickListener listener = (model, position) -> {
                Bundle bundle = new Bundle();
                bundle.putInt("spiderId", model.getId());
                NavHostFragment.findNavController(SpiderFragment.this)
                .navigate(R.id.action_SpidersFragment_to_UpdSpiderFragment, bundle);
        };
        SpidersAdapter adapter = new SpidersAdapter(this.requireContext(), listener, bindingModel);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setBindingModel(){
        ArrayList<SpiderItemModel> items = spidersService.getAll();
        bindingModel = new SpiderListModel<>(items);
    }
}