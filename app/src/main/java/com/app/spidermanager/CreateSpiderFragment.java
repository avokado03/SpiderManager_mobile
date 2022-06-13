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

import com.app.spidermanager.databinding.CreateSpiderFragmentBinding;
import com.app.spidermanager.models.CreateSpiderModel;
import com.app.spidermanager.services.SpidersService;
import com.app.spidermanager.utils.Utils;
import com.app.spidermanager.validation.SpiderModelValidator;
import com.app.spidermanager.validation.EmptyStringValidator;
import com.app.spidermanager.validation.NotZeroValidator;
import com.app.spidermanager.validation.TextValidator;

/**
 * Фрагмент для создания карточки паука
 */
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
        modelBinding.setName("test");
        modelBinding.setAge("12");
        modelBinding.setType("test");
        modelBinding.setLastFeedingDate("10.05.2022");
        modelBinding.setLastMoltingDate("10.05.2022");

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

        binding.createNameEdit.addTextChangedListener(new TextValidator(binding.createNameEdit) {
            @Override
            public void validate(TextView textView, String text) {
                validateCreation();
            }
        });
        binding.createTypeEdit.addTextChangedListener(new TextValidator(binding.createTypeEdit) {
            @Override
            public void validate(TextView textView, String text) {
                validateCreation();
            }
        });
        binding.createAgeEdit.addTextChangedListener(new TextValidator(binding.createAgeEdit) {
            @Override
            public void validate(TextView textView, String text) {
                validateCreation();
            }
        });

        binding.setSpider(modelBinding);
    }

    /**
     * Устанавливает состояние кнопки в зависимости от валидности модели
     */
    public void validateCreation() {
        boolean validationModelResult = SpiderModelValidator.validateCreateModel(modelBinding);
        binding.buttonCreate.setEnabled(!validationModelResult);
    }

    /**
     * Сохраненение новой карточки в БД
     */
    private void save() {
        Log.i("SPIDER_CREATE_MODEL_NAME", modelBinding.getName());
        try {
            int id = service.create(modelBinding);
            Toast.makeText(this.getContext(), String.format("Сохранено, ID = %s", id),
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
