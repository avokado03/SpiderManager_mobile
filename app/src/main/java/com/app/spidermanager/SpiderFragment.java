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

import java.util.ArrayList;

public class SpiderFragment extends Fragment {

    private SpidersFragmentBinding binding;
    private ArrayList<SpiderItemModel> itemModels;

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
        itemModels = new ArrayList<>();
        buildSpiderList();
    }

    private void buildSpiderList() {
        RecyclerView recyclerView = requireView().findViewById(R.id.spiders_list);
        setData();
        SpidersAdapter.OnSpiderClickListener listener = (model, position) ->
                NavHostFragment.findNavController(SpiderFragment.this)
                .navigate(R.id.action_SpidersFragment_to_UpdSpiderFragment);
        SpidersAdapter adapter = new SpidersAdapter(this.requireContext(), listener, itemModels);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setData() {
        itemModels.add(new SpiderItemModel( 1,"Name1", 5, "Type1",
                "12/02/20","12/02/20", null,
                true));
        itemModels.add(new SpiderItemModel(2,"Name2", 3, "Type2",
                "12/02/20","12/02/21", null,
                false));
        itemModels.add(new SpiderItemModel(3,"Name3",7, "Type3",
                "12/02/20","12/02/20", null,
                true));
    }
}