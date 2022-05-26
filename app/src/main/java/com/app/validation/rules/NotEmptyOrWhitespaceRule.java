package com.app.validation.rules;

import com.app.validation.annotations.NotEmptyOrWhitespace;

/**
 * Правило "Строка не пустая и не состоит из пробелов"
 */
public class NotEmptyOrWhitespaceRule extends
        AnnotationRuleBase<NotEmptyOrWhitespace, String> {

    protected NotEmptyOrWhitespaceRule(NotEmptyOrWhitespace ruleAnnotation) {
        super(ruleAnnotation);
    }

    @Override
    public boolean IsValid(String dataField) {
        if (dataField == null)
            throw new IllegalArgumentException("Строка не должна быть равна null");
        return !(dataField.isEmpty() || dataField.trim().isEmpty());
    }
}
