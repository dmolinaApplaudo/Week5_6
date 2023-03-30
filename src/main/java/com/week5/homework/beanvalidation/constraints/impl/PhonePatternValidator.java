package com.week5.homework.beanvalidation.constraints.impl;

import com.week5.homework.beanvalidation.constraints.PhonePattern;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhonePatternValidator implements ConstraintValidator<PhonePattern,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s == null) return false;
        if(s.isBlank()) return false;
        if(s.length() != 12) return false;
        if(s.charAt(0) != '+') return false;
        String countryCode = s.substring(1,4);
        if(!countryCode.matches("^\\d{3}$")) return false;
        String phoneNumber = s.substring(4,12);
        if(!phoneNumber.matches("^\\d{8}$")) return false;
        return true;
    }
}
