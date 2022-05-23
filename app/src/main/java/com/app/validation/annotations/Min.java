package com.app.validation.annotations;

import com.app.validation.rules.MinRule;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация "Минимальное значение"
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
@RuleUsed(value = MinRule.class)
public @interface Min {
    int    value();
    String message() default "Должно быть больше минимального значения";
}
