package com.app.spidermanager;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.fragment.NavHostFragment;

import com.app.spidermanager.base.EditableFragment;
import com.app.spidermanager.databinding.CreateSpiderFragmentBinding;
import com.app.spidermanager.models.CreateSpiderModel;
import com.app.spidermanager.services.SpidersService;
import com.app.spidermanager.validation.EmptyStringValidator;
import com.app.spidermanager.validation.NotZeroValidator;

public class CreateSpiderFragment extends EditableFragment {

    private CreateSpiderFragmentBinding binding;
    private CreateSpiderModel modelBinding;
    private SpidersService service;

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

        service = new SpidersService(view.getContext());
        modelBinding = new CreateSpiderModel();

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

        binding.buttonCreate.setOnClickListener(v -> save());

        binding.createNameEdit.addTextChangedListener(new EmptyStringValidator(binding.createNameEdit));
        binding.createTypeEdit.addTextChangedListener(new EmptyStringValidator(binding.createTypeEdit));
        binding.createAgeEdit.addTextChangedListener(new NotZeroValidator(binding.createAgeEdit));

        binding.setSpider(modelBinding);
    }

    private void save(){
        Log.i("SPIDER_CREATE_MODEL_NAME", modelBinding.getName());
        service.create(modelBinding);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
