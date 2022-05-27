package com.app.spidermanager.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

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
}
