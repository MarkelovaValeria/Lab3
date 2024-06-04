package com.example.Lab3.order;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FullNameValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidFullName {
    String message() default "{order.fullName.invalid}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
