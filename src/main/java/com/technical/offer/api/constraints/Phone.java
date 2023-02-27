package com.technical.offer.api.constraints;

import com.technical.offer.api.constraints.validators.PhoneFormatValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = PhoneFormatValidator.class)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Phone {
    String message() default "{com.technical.offer.api.constraints.Phone.message}";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};
}
