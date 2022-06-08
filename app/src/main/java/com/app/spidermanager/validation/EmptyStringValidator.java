package com.app.spidermanager.validation;

import android.widget.TextView;

public class EmptyStringValidator extends TextValidator{
    public EmptyStringValidator(TextView textView) {
        super(textView);
    }

    @Override
    public void validate(TextView textView, String text) {
        boolean result = ValidationHelpers.isEmpty(text);
        if(result)
            textView.setError(ErrorMessages.not_empty_message);
    }
}
