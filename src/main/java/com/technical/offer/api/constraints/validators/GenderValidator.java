package com.technical.offer.api.constraints.validators;

import com.technical.offer.api.constraints.Gender;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.EnumUtils;

public class GenderValidator implements ConstraintValidator<Gender, String> {

    @Override
    public boolean isValid(String string, ConstraintValidatorContext constraintValidatorContext) {

            if (string != null && string.length() > 0) {
                return EnumUtils.isValidEnum(com.technical.offer.api.enumeration.Gender.class, string.toUpperCase());
            }
            return true;
    }
}
