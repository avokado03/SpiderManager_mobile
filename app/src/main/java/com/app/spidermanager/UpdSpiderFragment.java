package com.app.spidermanager;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.fragment.NavHostFragment;

import com.app.spidermanager.base.EditableFragment;
import com.app.spidermanager.databinding.UpdSpiderFragmentBinding;

public class UpdSpiderFragment extends EditableFragment {

    private UpdSpiderFragmentBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = UpdSpiderFragmentBinding.inflate(inflater, container, false);
        setImageBitmap(binding.updPhoto, UpdSpiderFragment.this);

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonBack.setOnClickListener(v -> {
                NavHostFragment.findNavController(UpdSpiderFragment.this)
                .navigate(R.id.action_UpdSpiderFragment_to_SpidersFragment);
        });

        // TODO:
        // дописать комменты
        // посмотреть валидацию
        binding.updFeedingDateEdit.setOnClickListener(v -> setDate(binding.updFeedingDateEdit));

        binding.updMoltingDateEdit.setOnClickListener(v -> setDate(binding.updMoltingDateEdit));

        binding.updPhoto.setOnClickListener(v ->
                checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE, () -> {
                    Intent intent = new Intent(Intent.ACTION_PICK,
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    activityResultLauncher.launch(intent);
            })
        );
    }


}