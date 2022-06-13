package com.app.spidermanager.utils;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Класс со вспомогательными методами
 */
public class Utils {

    // region Изображения

    /**
     * Получить Drawable-ресурс из байт-массива
     */
    public static Drawable getDrawableFromArray(byte[] array) {
        BitmapDrawable result = null;
        try {
            if (array.length != 0)
                result = new BitmapDrawable(Resources.getSystem(),
                        BitmapFactory.decodeByteArray(array, 0, array.length));
        } catch (NullPointerException ignored) {}
        return result;
    }

    /**
     * Получить Drawable-ресурс из Bitmap-изображения
     */
    public static Drawable getDrawableFromBitmap(Bitmap img) {
        return new BitmapDrawable(Resources.getSystem(), img);
    }

    /**
     * Преобразовать Drawable-ресурс в байт-массив
     */
    public static byte[] getByteArrayFromDrawable(Drawable img) {
        if (img == null) return null;
        Bitmap bitmap = ((BitmapDrawable) img).getBitmap();
        bitmap = Bitmap.createScaledBitmap(bitmap,
                (int) (bitmap.getWidth() * 0.3), (int) (bitmap.getHeight() * 0.3), true);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        return stream.toByteArray();
    }
    // endregion

    // region Даты

    /**
     * Получение даты в виде строки формата дд.мм.гггг
     */
    public static String dateToString(int year, int month, int day) {
        Calendar newDate = Calendar.getInstance();
        newDate.set(year, month, day);
        return dateToString(newDate.getTime());
    }

    /**
     * Получение даты в виде строки формата дд.мм.гггг
     */
    @SuppressLint("SimpleDateFormat")
    public static String dateToString(Date date) {
        return new SimpleDateFormat("dd.MM.yyyy").format(date);
    }

    /**
     * Преобразование строки формата дд.мм.гггг в дату
     */
    public static Date stringToDate(String value) {
        Date date = new Date();
        try {
            @SuppressLint("SimpleDateFormat")
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            date = format.parse(value);
        } catch (ParseException e) {
            Log.e("DEBUG", e.getMessage());
        }
        return date;
    }
    // endregion


}
