package com.example.Lab3.order;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FullNameValidator implements ConstraintValidator<ValidFullName, String> {
    @Override
    public void initialize(ValidFullName fullName) {
    }

    @Override
    public boolean isValid(String fullNameField, ConstraintValidatorContext context) {
        if (fullNameField == null || fullNameField.trim().isEmpty()) {
            return false;
        }
        String[] parts = fullNameField.trim().split("\\s+");
        return parts.length >= 2;
    }
}
