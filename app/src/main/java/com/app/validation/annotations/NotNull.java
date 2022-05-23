package com.app.validation.annotations;

import com.app.validation.rules.NotNullRule;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация "Не NULL"
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
@RuleUsed(value = NotNullRule.class)
public @interface NotNull {
    String message()  default "Значение не может быть null";
}
