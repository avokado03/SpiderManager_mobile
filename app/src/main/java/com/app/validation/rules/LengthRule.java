package com.app.validation.rules;

import com.app.validation.annotations.Length;

/**
 * Правило "Длина строки от-до"
 */
public class LengthRule extends AnnotationRuleBase<Length, String> {

    protected LengthRule(Length ruleAnnotation) {
        super(ruleAnnotation);
    }

    @Override
    public boolean IsValid(String dataField) {
        if (dataField == null)
            throw new IllegalArgumentException("Строка не должна быть равна null");

        int min = ruleAnnotation.min();
        int max = ruleAnnotation.max();
        if (min > max)
            throw new IllegalArgumentException("Неверно указана длина строки");

        int strLength = dataField.length();
        return min <= strLength && max >= strLength;
    }
}
