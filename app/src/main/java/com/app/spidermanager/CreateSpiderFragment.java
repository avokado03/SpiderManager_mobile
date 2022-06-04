package com.app.spidermanager;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewbinding.ViewBinding;

import com.app.spidermanager.base.EditableFragment;
import com.app.spidermanager.databinding.CreateSpiderFragmentBinding;

public class CreateSpiderFragment extends EditableFragment {

    private CreateSpiderFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = CreateSpiderFragmentBinding.inflate(inflater, container, false);
        setImageBitmap(binding.createPhoto, CreateSpiderFragment.this);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonBack.setOnClickListener(v ->
                NavHostFragment.findNavController(CreateSpiderFragment.this)
                .navigate(R.id.action_CreateSpiderFragment_to_SpidersFragment));

        binding.createFeedingDateEdit.setOnClickListener(v -> setDate(binding.createFeedingDateEdit));

        binding.createMoltingDateEdit.setOnClickListener(v -> setDate(binding.createMoltingDateEdit));

        binding.createPhoto.setOnClickListener(v ->
                checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE, () -> {
                    Intent intent = new Intent(Intent.ACTION_PICK,
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    activityResultLauncher.launch(intent);
            })
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
