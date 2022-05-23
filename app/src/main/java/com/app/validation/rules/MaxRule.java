package com.app.validation.rules;

import com.app.validation.annotations.Max;

/**
 * Правило "Не больше, чем"
 */
public class MaxRule extends AnnotationRuleBase <Max, Integer> {
    protected MaxRule(Max ruleAnnotation) {
        super(ruleAnnotation);
    }

    @Override
    public boolean IsValid(Integer dataField) {
        if (dataField == null)
            throw new IllegalArgumentException("Значение не должно быть равно null");
        return dataField <= ruleAnnotation.value();
    }
}
