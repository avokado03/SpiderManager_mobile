package com.app.validation.rules;

import com.app.validation.annotations.Min;

/**
 * Правило "Не меньше, чем"
 */
public class MinRule extends AnnotationRuleBase <Min, Integer> {

    protected MinRule(Min ruleAnnotation) {
        super(ruleAnnotation);
    }


    @Override
    public boolean IsValid(Integer dataField) {
        if (dataField == null)
            throw new IllegalArgumentException("Значение не должно быть равно null");
        return dataField >= ruleAnnotation.value();
    }
}
