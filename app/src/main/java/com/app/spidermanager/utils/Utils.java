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

    /**
     * Преобразует массив байтов
     * в изображение
     *
     * @param array  массив байтов
     * @param width  ширина изображения
     * @param height высота изображения
     * @return изображение с заданными шириной и высотой
     */
    public static Bitmap getBitmapFromArray(byte[] array, int width, int height) {
        Bitmap bitmap = BitmapFactory.decodeByteArray(array, 0, array.length);
        return Bitmap.createScaledBitmap(bitmap, width, height, false);
    }

    public static Drawable getDrawableFromArray(byte[] array) {
        BitmapDrawable result = null;
        try {
            if (array.length != 0)
                result = new BitmapDrawable(Resources.getSystem(),
                        BitmapFactory.decodeByteArray(array, 0, array.length));
        } catch (NullPointerException ignored) {}
        return result;
    }

    public static Drawable getDrawableFromBitmap(Bitmap img) {
        return new BitmapDrawable(Resources.getSystem(), img);
    }

    public static byte[] getByteArrayFromDrawable(Drawable img) {
        if (img == null) return null;
        Bitmap bitmap = ((BitmapDrawable) img).getBitmap();
        bitmap = Bitmap.createScaledBitmap(bitmap,
                (int) (bitmap.getWidth() * 0.3), (int) (bitmap.getHeight() * 0.3), true);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        return stream.toByteArray();
    }

    // region Даты
    public static String dateToString(int year, int month, int day) {
        Calendar newDate = Calendar.getInstance();
        newDate.set(year, month, day);
        return dateToString(newDate.getTime());
    }

    @SuppressLint("SimpleDateFormat")
    public static String dateToString(Date date) {
        return new SimpleDateFormat("dd.MM.yyyy").format(date);
    }

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
