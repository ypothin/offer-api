package com.technical.offer.api.constraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = CountryValidator.class)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Country {
    String message() default "{com.technical.offer.api.constraints.Country.message}";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};
}
