package com.app.validation;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.app.validation.annotations.RuleUsed;
import com.app.validation.rules.AnnotationRuleBase;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("SuspiciousMethodCalls")
public class Validator<T> {

    private final T modelForValidating;

    public Validator(T modelForValidating) {
        this.modelForValidating = modelForValidating;
    }

    public T getModelForValidating() {
        return modelForValidating;
    }

    /**
     * Валидирует модель
     * @return Список сообщений об ошибках
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public ArrayList<String> validate (){
        ArrayList<String> errors = new ArrayList<>();
        Field[] fields = modelForValidating.getClass().getFields();
        for (int i = 0; i < fields.length; i++) {
                ArrayList<Annotation> fieldAnnotations = getAnnotationsFromField(fields[i]);

        }
        return  errors;
    }

    /**
     * Собирает список аннотаций у поля
     * модели, если они есть
     * @param field Поле модели
     * @return Список аннотаций
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    private ArrayList<Annotation> getAnnotationsFromField(final Field field) {
        ArrayList<Annotation> annotations =
                new ArrayList<>(Arrays.asList(field.getDeclaredAnnotations()));
        if (!annotations.isEmpty())
            annotations.removeIf(this::isValidationAnnotation);
        return annotations;
    }

    /**
     * Проверяет, является ли эта аннотация
     * пренадлежащей валидатору
     * @param annotation Экземпляр аннотации
     * @return Результат да/нет
     */
    private boolean isValidationAnnotation(final Annotation annotation) {
        return !new ArrayList<>(Arrays.asList(annotation.getClass().getAnnotations()))
                .contains(RuleUsed.class);
    }

    /**
     * Получает правило валидации у аннотации
     * @param ruleAnnotation Аннотация валидации
     * @return Класс правила валидации
     */
    private Class<? extends AnnotationRuleBase> getRuleType(final Annotation ruleAnnotation) {
        RuleUsed validateUsing = ruleAnnotation.annotationType()
                .getAnnotation(RuleUsed.class);
        return validateUsing != null ? validateUsing.value() : null;
    }
}
