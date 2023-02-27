package com.technical.offer.api.constraints;

import com.technical.offer.api.constraints.validators.GenderValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = GenderValidator.class)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Gender {
    String message() default "{com.technical.offer.api.constraints.Gender.message}";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};
}
