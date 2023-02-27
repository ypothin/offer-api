package com.technical.offer.api.constraints.validators;

import com.technical.offer.api.constraints.Phone;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PhoneFormatValidator implements ConstraintValidator<Phone, String> {

    @Override
    public boolean isValid(String stringPhone, ConstraintValidatorContext constraintValidatorContext) {

        if (stringPhone != null && stringPhone.length() > 0) {
            String regex = "^(?:(?:\\+|00)33|0)\\s*[1-9](?:[\\s.-]*\\d{2}){4}$";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(stringPhone);
            return m.matches();
        }

        return true;
    }
}
