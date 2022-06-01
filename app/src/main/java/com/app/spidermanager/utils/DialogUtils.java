package com.app.spidermanager.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

import com.app.spidermanager.R;

public class DialogUtils {
    /**
     * Создает диалог подтверждения действия для представления
     * @param context Контекст
     * @param acceptHandler Обработчик подтверждения
     * @return Dialog
     */
    public static Dialog createConfirmDialog(Context context, DialogInterface.OnClickListener acceptHandler){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.confirm_dialog_title)
                .setCancelable(true)
                .setPositiveButton(R.string.confirm_dialog_accept, acceptHandler)
                .setNegativeButton(R.string.confirm_dialog_decline, (dialog, id) -> dialog.cancel());

        return builder.create();
    }
}
