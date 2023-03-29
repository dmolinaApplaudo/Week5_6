package com.week5.homework.beanvalidation.constraints;

import com.week5.homework.beanvalidation.constraints.impl.PhonePatternValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhonePatternValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PhonePattern {
    String message() default "Phone Number Must Follow this Pattern +503XXXXXXXX";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
