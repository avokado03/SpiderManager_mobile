package com.app.spidermanager;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.fragment.NavHostFragment;

import com.app.spidermanager.base.EditableFragment;
import com.app.spidermanager.databinding.CreateSpiderFragmentBinding;
import com.app.spidermanager.models.CreateSpiderModel;
import com.app.spidermanager.services.SpidersService;
import com.app.spidermanager.utils.Utils;
import com.app.spidermanager.validation.CreateSpiderModelValidator;
import com.app.spidermanager.validation.EmptyStringValidator;
import com.app.spidermanager.validation.NotZeroValidator;
import com.app.spidermanager.validation.TextValidator;

public class CreateSpiderFragment extends EditableFragment {

    private CreateSpiderFragmentBinding binding;
    private CreateSpiderModel modelBinding;
    private SpidersService service;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = CreateSpiderFragmentBinding.inflate(inflater, container, false);
        setImageBitmap(CreateSpiderFragment.this);
        return binding.getRoot();
    }

    @Override
    protected void onSetImage(Bitmap bitmap) {
        binding.createPhoto.setImageBitmap(bitmap);
        modelBinding.setPhoto(Utils.getDrawableFromBitmap(bitmap));
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

        binding.buttonCreate.setEnabled(false);
        binding.buttonCreate.setOnClickListener(v -> save());
        binding.createNameEdit.addTextChangedListener(new EmptyStringValidator(binding.createNameEdit));
        binding.createTypeEdit.addTextChangedListener(new EmptyStringValidator(binding.createTypeEdit));
        binding.createAgeEdit.addTextChangedListener(new NotZeroValidator(binding.createAgeEdit));

        binding.createNameEdit.addTextChangedListener(new SpiderValidate(binding.createNameEdit));
        binding.createTypeEdit.addTextChangedListener(new SpiderValidate(binding.createTypeEdit));
        binding.createAgeEdit.addTextChangedListener(new SpiderValidate(binding.createAgeEdit));

        binding.setSpider(modelBinding);
    }

    class SpiderValidate extends TextValidator {
        public SpiderValidate(TextView textView) {
            super(textView);
        }

        @Override
        public void validate(TextView textView, String text) {
            boolean validationModelResult = CreateSpiderModelValidator.validate(modelBinding);
            binding.buttonCreate.setEnabled(!validationModelResult);
        }
    }

    private void save() {
        Log.i("SPIDER_CREATE_MODEL_NAME", modelBinding.getName());
        try {
            service.create(modelBinding);
            Toast.makeText(this.getContext(), "Сохранено",
                    Toast.LENGTH_SHORT).show();
        } catch (Exception ex) {
            Log.i("CREATE SPIDER", ex.getMessage());
            Toast.makeText(this.getContext(), "Программистка дура",
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
