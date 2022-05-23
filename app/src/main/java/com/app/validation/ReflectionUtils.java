package com.app.validation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Вспомогательный класс для
 * работы с рефлексией
 */
public class ReflectionUtils {

    /**
     * Получение значения атрибута аннотации
     */
    @SuppressWarnings("unchecked")
    public static <T> T getAttributeValue(final Annotation annotation, final String attributeName,
                                   final Class<T> attributeDataType) {

        T attributeValue = null;
        Class<? extends Annotation> annotationType = annotation.annotationType();
        Method attributeMethod = getAttributeMethod(annotationType, attributeName);

        if (attributeMethod == null) {
            String message = String.format("Не удалось найти атрибут '%s' в аннотации '%s'.",
                    attributeName, annotationType.getName());
            throw new IllegalStateException(message);
        } else {
            try {
                Object result = attributeMethod.invoke(annotation);
                attributeValue = attributeDataType.isPrimitive()
                        ? (T) result
                        : attributeDataType.cast(result);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

            return attributeValue;
        }
    }

    /**
     * Получает метод-атрибут в составе аннотации
     */
    public static Method getAttributeMethod(final Class<? extends Annotation> annotationType,
                                     final String attributeName) {
        Method attributeMethod = null;
        try {
            attributeMethod = annotationType.getMethod(attributeName);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return attributeMethod;
    }
}
