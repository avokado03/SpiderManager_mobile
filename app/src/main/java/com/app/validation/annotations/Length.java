package com.app.validation.annotations;

import com.app.validation.rules.LengthRule;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация "Длина строки"
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
@RuleUsed(value = LengthRule.class)
public @interface Length {
    int    min();
    int    max();
    String message() default "Длина строки должна находиться между " +
            "минимальным и максимальным значениями";
}
