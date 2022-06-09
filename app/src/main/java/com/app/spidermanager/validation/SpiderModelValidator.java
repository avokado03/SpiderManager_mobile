package com.app.spidermanager.validation;

import com.app.spidermanager.models.CreateSpiderModel;
import com.app.spidermanager.models.UpdSpiderModel;

public class SpiderModelValidator {
    public static boolean validateCreateModel (CreateSpiderModel model) {
        return validate(model.getName(), model.getType(), model.getAge());
    }

    public static boolean validateUpdateModel (UpdSpiderModel model) {
        return validate(model.getName(), model.getType(), model.getAge());
    }

    private static boolean validate (String name, String type, String age){
        return ValidationHelpers.isEmpty(name)
                || ValidationHelpers.isEmpty(type)
                || ValidationHelpers.isZero(age);
    }
}
