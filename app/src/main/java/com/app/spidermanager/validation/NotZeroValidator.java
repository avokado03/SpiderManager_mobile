package com.app.spidermanager.validation;

import static com.app.spidermanager.validation.ErrorMessages.zero_value_message;

import android.widget.TextView;

public class NotZeroValidator extends TextValidator{
    public NotZeroValidator(TextView textView) {
        super(textView);
    }

    @Override
    public void validate(TextView textView, String text){
        boolean result = ValidationHelpers.isZero(text);
        if (result) textView.setError(zero_value_message);
    }
}
