package com.app.spidermanager.validation;

import com.app.spidermanager.models.CreateSpiderModel;

public class CreateSpiderModelValidator {
    public static boolean validate (CreateSpiderModel model) {
        return ValidationHelpers.isEmpty(model.getName())
                || ValidationHelpers.isEmpty(model.getType())
                || ValidationHelpers.isZero(model.getAge());
    }
}
