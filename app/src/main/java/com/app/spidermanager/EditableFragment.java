package com.app.spidermanager;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.EditText;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.app.spidermanager.utils.DialogUtils;
import com.app.spidermanager.utils.Utils;

import java.io.IOException;

/**
 * Базовый класс для фрагментов, изменяющих сущность "Паук"
 */
public abstract class EditableFragment extends Fragment {

    protected ActivityResultLauncher<Intent> activityResultLauncher;

    /**
     * Установка даты с помощью диалога
     */
    protected void setDate(EditText editText){
        Dialog dialog = DialogUtils.createDatePickerDialog(
                this.requireContext(), (picker, year, month, day) ->
                        editText.setText(Utils.dateToString(year,month,day)));
        dialog.show();
    }

    /**
     * Перенос установленного изображения в модель
     */
    protected abstract void onSetImage(Bitmap bitmap);

    /**
     * Выбор изображения
     */
    protected void setImageBitmap(Fragment fragment) {
        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            Uri selected = data.getData();
                            try {
                                Bitmap bitmap = MediaStore.Images.Media.getBitmap(
                                        fragment.getActivity().getContentResolver(), selected);
                                onSetImage(bitmap);
                            } catch (IOException e) {
                                Log.i("DEBUG", "activityResultLauncher - IOException");
                            }
                        }
                    }
                }
        );
    }

    /**
     * Ф.интерфейс для проверки разрешений
     */
    protected interface SuccessPermissionCheck{
        void Invoke();
    }

    /**
     * Проверка разрешений
     */
    protected void checkPermission(String permissionName, SuccessPermissionCheck delegate){
        int permission = ContextCompat.checkSelfPermission(
                requireContext(), permissionName);
        if(permission != PackageManager.PERMISSION_GRANTED)
        {
            delegate.Invoke();
        }
        else{
            ActivityCompat.requestPermissions(requireActivity(),
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    2000);
        }
    }
}
