package com.app.spidermanager.utils;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

import com.app.spidermanager.R;

import java.util.Calendar;
import java.util.Date;

/**
 * Утилитарные методы для создания диалогов
 */
public class DialogUtils {
    /**
     * Создает диалог подтверждения действия для представления
     * @param context Контекст
     * @param acceptHandler Обработчик подтверждения
     * @return Dialog
     */
    public static Dialog createConfirmDialog(Context context,
                                             DialogInterface.OnClickListener acceptHandler){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.confirm_dialog_title)
                .setCancelable(true)
                .setPositiveButton(R.string.confirm_dialog_accept, acceptHandler)
                .setNegativeButton(R.string.confirm_dialog_decline, (dialog, id) -> dialog.cancel());

        return builder.create();
    }

    /**
     * Создает диалог выбора даты
     * @param context Контекст
     * @param setHandler Обработчик завершения выбора
     * @return Dialog
     */
    public static Dialog createDatePickerDialog(
            Context context, DatePickerDialog.OnDateSetListener setHandler){
        Calendar now = Calendar.getInstance();
        return new DatePickerDialog(context, setHandler, now.get(Calendar.YEAR),
                now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));
    }
}
