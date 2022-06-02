package com.app.spidermanager;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.app.spidermanager.databinding.UpdSpiderFragmentBinding;
import com.app.spidermanager.utils.DialogUtils;
import com.app.spidermanager.utils.Utils;

import java.io.IOException;

public class UpdSpiderFragment extends Fragment {

    private UpdSpiderFragmentBinding binding;
    private ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = UpdSpiderFragmentBinding.inflate(inflater, container, false);
        setImageBitmap(binding.updPhoto);

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonBack.setOnClickListener(v ->
                NavHostFragment.findNavController(UpdSpiderFragment.this)
                .navigate(R.id.action_UpdSpiderFragment_to_SpidersFragment));

        // TODO: Вынести проверку пермишенов
        // добавить базовый класс для фрагментов пауков
        // дописать комменты
        // посмотреть валидацию
        binding.updFeedingDateEdit.setOnClickListener(v -> setDate(binding.updFeedingDateEdit));

        binding.updMoltingDateEdit.setOnClickListener(v -> setDate(binding.updMoltingDateEdit));

        binding.updPhoto.setOnClickListener(v -> {
            int permission = ContextCompat.checkSelfPermission(
                    requireContext(), Manifest.permission.READ_EXTERNAL_STORAGE);
            if(permission != PackageManager.PERMISSION_GRANTED)
            {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                activityResultLauncher.launch(intent);
            }
            else{
                ActivityCompat.requestPermissions(requireActivity(),
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        2000);
            }
        });
    }

    public void setDate(EditText editText){
        Dialog dialog = DialogUtils.createDatePickerDialog(
                this.requireContext(), (picker, year, month, day) ->
                        editText.setText(Utils.getFormattedDateString(year,month,day)));
        dialog.show();
    }

    public void setImageBitmap(ImageView imageView) {
        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            Uri selected = data.getData();
                            try {
                                Bitmap bitmap = MediaStore.Images.Media.getBitmap(
                                        UpdSpiderFragment.this.
                                                getActivity().getContentResolver(), selected);
                                imageView.setImageBitmap(bitmap);
                            } catch (IOException e) {
                                Log.i("DEBUG", "activityResultLauncher - IOException");
                            }
                        }
                    }
                }
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}