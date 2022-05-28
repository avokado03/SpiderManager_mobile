package com.app.spidermanager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
    private final ArrayList<SpiderItemModel> itemModels;

    public SpiderFragment() {
        this.itemModels = new ArrayList<>();
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = SpidersFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buildSpiderList();
    }

    private void buildSpiderList() {
        RecyclerView recyclerView = requireView().findViewById(R.id.spiders_list);
        setData();
        SpidersAdapter.OnSpiderClickListener listener = (model, position) ->
                NavHostFragment.findNavController(SpiderFragment.this)
                .navigate(R.id.action_SpidersFragment_to_SecondFragment);
        SpidersAdapter adapter = new SpidersAdapter(this.requireContext(), listener, itemModels);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setData() {
        itemModels.add(new SpiderItemModel("Name1", "Type1",
                "12/02/20", null,
                ContextCompat.getDrawable(this.requireContext(), R.drawable.male_icon_foreground)));
        itemModels.add(new SpiderItemModel("Name2", "Type2",
                "12/02/21", null,
                ContextCompat.getDrawable(this.requireContext(), R.drawable.female_icon_foreground)));
        itemModels.add(new SpiderItemModel("Name3", "Type3",
                "12/02/20", null,
                ContextCompat.getDrawable(this.requireContext(), R.drawable.unknown_sex_icon_foreground)));
    }
}