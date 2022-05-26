package com.app.validation.rules;

import com.app.validation.annotations.NotNull;

/**
 * Правило аннотации
 * "Не null"
 */
public class NotNullRule extends AnnotationRuleBase<NotNull,Object> {

    protected NotNullRule(NotNull ruleAnnotation) {
        super(ruleAnnotation);
    }

    @Override
    public boolean IsValid(Object dataField) {
        return dataField != null;
    }
}
