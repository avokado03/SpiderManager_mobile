package com.app.validation.annotations;

import com.app.validation.rules.MaxRule;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * "Аннотация "Максимальное значение"
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
@RuleUsed(value = MaxRule.class)
public @interface Max {
    int value();
    String message() default "Должно быть меньше максимального значения";
}
