package com.app.spidermanager.utils;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

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
     * @param array массив байтов
     * @param width ширина изображения
     * @param height высота изображения
     * @return изображение с заданными шириной и высотой
     */
    public static Bitmap getBitmapFromArray(byte[] array, int width, int height){
        Bitmap bitmap = BitmapFactory.decodeByteArray(array,0, array.length);
        return Bitmap.createScaledBitmap(bitmap, width, height, false);
    }

    // region Даты
        public static String dateToString(int year, int month, int day){
            Calendar newDate = Calendar.getInstance();
            newDate.set(year,month,day);
            return dateToString(newDate.getTime());
        }

        @SuppressLint("SimpleDateFormat")
        public static String dateToString(Date date){
            return new SimpleDateFormat("dd.MM.yyyy").format(date);
        }
    // endregion
}
