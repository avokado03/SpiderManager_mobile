package com.app.spidermanager.validation;

/**
 * Вспомогательные медоты валидации
 */
public class ValidationHelpers {
    public static boolean isZero(String text){
        if (text == null) return true;
        return text.equals("0") || isEmpty(text);
    }

    public static boolean isEmpty (String text) {
        if (text == null) return true;
        return text.isEmpty() || text.trim().isEmpty();
    }
}
