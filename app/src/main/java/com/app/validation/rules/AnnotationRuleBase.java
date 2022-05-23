package com.app.validation.rules;

import com.app.validation.ReflectionUtils;

import java.lang.annotation.Annotation;

public abstract class AnnotationRuleBase <T extends Annotation, V> {

    protected final T ruleAnnotation;

    protected AnnotationRuleBase(final T ruleAnnotation) {
        if (ruleAnnotation == null) {
            throw new IllegalArgumentException("Отсутствует аннотация валидации");
        }
        this.ruleAnnotation = ruleAnnotation;
    }

    /**
     * Валидирует переданные данные
     * @param dataField Валидируемое поле
     * @return Результат валидации
     */
    public abstract boolean IsValid(V dataField);


    /**
     * @return Возвращает сообщение
     * аннотации
     */
    public String getMessage ()
    {
        return ReflectionUtils.
                getAttributeValue(ruleAnnotation, "message", String.class);
    }
}
