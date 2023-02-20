package com.technical.offer.api.constraints;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

public class CountryValidator implements ConstraintValidator<Country, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        return Objects.equals(s.toLowerCase(), new String("france"));
    }
}
