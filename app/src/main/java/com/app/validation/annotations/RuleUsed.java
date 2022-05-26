package com.app.validation.annotations;

import com.app.validation.rules.AnnotationRuleBase;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Указывает, какое правило
 * использовать с аннотацией валидации
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.ANNOTATION_TYPE)
public @interface RuleUsed {
    Class<? extends AnnotationRuleBase> value();
}
