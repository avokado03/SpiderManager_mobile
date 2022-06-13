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
import androidx.navigation.fragment.NavHostFragment;

import com.app.spidermanager.databinding.UpdSpiderFragmentBinding;
import com.app.spidermanager.models.UpdSpiderModel;
import com.app.spidermanager.services.SpidersService;
import com.app.spidermanager.utils.Utils;
import com.app.spidermanager.validation.EmptyStringValidator;
import com.app.spidermanager.validation.NotZeroValidator;
import com.app.spidermanager.validation.SpiderModelValidator;
import com.app.spidermanager.validation.TextValidator;

/**
 * Фрагмент для обновления карточки паука
 */
public class UpdSpiderFragment extends EditableFragment {

    private UpdSpiderFragmentBinding binding;
    private UpdSpiderModel modelBinding;
    private SpidersService service;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = UpdSpiderFragmentBinding.inflate(inflater, container, false);
        setImageBitmap(UpdSpiderFragment.this);
        return binding.getRoot();
    }

    @Override
    protected void onSetImage(Bitmap bitmap) {
        binding.updPhoto.setImageBitmap(bitmap);
        modelBinding.setPhoto(Utils.getDrawableFromBitmap(bitmap));
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int spiderId = getArguments().getInt("spiderId");
        service = new SpidersService(getContext());
        setBinding(spiderId);
        binding.buttonBack.setOnClickListener(v ->
                NavHostFragment.findNavController(UpdSpiderFragment.this)
        .navigate(R.id.action_UpdSpiderFragment_to_SpidersFragment));

        binding.updFeedingDateEdit.setOnClickListener(v -> setDate(binding.updFeedingDateEdit));

        binding.updMoltingDateEdit.setOnClickListener(v -> setDate(binding.updMoltingDateEdit));

        binding.updPhoto.setOnClickListener(v ->
                checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE, () -> {
                    Intent intent = new Intent(Intent.ACTION_PICK,
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    activityResultLauncher.launch(intent);
            })
        );

        binding.buttonSave.setEnabled(false);
        binding.buttonSave.setOnClickListener(v -> save());
        binding.updNameEdit.addTextChangedListener(new EmptyStringValidator(binding.updNameEdit));
        binding.updTypeEdit.addTextChangedListener(new EmptyStringValidator(binding.updTypeEdit));
        binding.updAgeEdit.addTextChangedListener(new NotZeroValidator(binding.updAgeEdit));
        binding.updNameEdit.addTextChangedListener(new TextValidator(binding.updNameEdit) {
            @Override
            public void validate(TextView textView, String text) {
                validateUpdate();
            }
        });
        binding.updTypeEdit.addTextChangedListener(new TextValidator(binding.updTypeEdit) {
            @Override
            public void validate(TextView textView, String text) {
                validateUpdate();
            }
        });
        binding.updAgeEdit.addTextChangedListener(new TextValidator(binding.updAgeEdit) {
            @Override
            public void validate(TextView textView, String text) {
                validateUpdate();
            }
        });

    }

    /**
     * Назначение состояния кнопки на основе валидности модели
     */
    public void validateUpdate() {
        boolean validationModelResult = SpiderModelValidator.validateUpdateModel(modelBinding);
        binding.buttonSave.setEnabled(!validationModelResult);
    }

    /**
     * Назначение модели привязки
     */
    private void setBinding(int spiderId){
        modelBinding = service.getById(spiderId);
        binding.setSpider(modelBinding);
    }

    /**
     * Сохранение результата
     */
    private void save(){
        try {
            UpdSpiderModel id = service.update(modelBinding);
            Toast.makeText(this.getContext(), "Сохранено",
                    Toast.LENGTH_SHORT).show();
        } catch (Exception ex) {
            Log.i("UPDATE SPIDER", ex.getMessage());
            Toast.makeText(this.getContext(), "Ошибка!",
                    Toast.LENGTH_SHORT).show();
        }

    }
}