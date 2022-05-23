package com.app.validation.annotations;

import com.app.validation.rules.NotEmptyOrWhitespaceRule;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для проверки строк на
 * пустоту и пробелы
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
@RuleUsed(value = NotEmptyOrWhitespaceRule.class)
public @interface NotEmptyOrWhitespace {
    String message() default "Строка пуста или состоит из пробелов";
}
