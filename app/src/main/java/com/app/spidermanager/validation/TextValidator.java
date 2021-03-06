package com.app.spidermanager.validation;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.TextView;

/**
 * Базовый класс для валидаторов
 */
public abstract class TextValidator implements TextWatcher{
    private final TextView textView;


    public TextValidator(TextView textView) {
        this.textView = textView;
    }

    /**
     * Валидирует полученное значение
     */
    public abstract void validate(TextView textView, String text);

    @Override
    final public void afterTextChanged(Editable s) {
        String text = textView.getText().toString();
        validate(textView, text);
    }

    @Override
    final public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    final public void onTextChanged(CharSequence s, int start, int before, int count) {

    }
}
