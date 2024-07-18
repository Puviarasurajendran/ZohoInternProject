package com.example.spring_restapi.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target({ TYPE, FIELD, METHOD })
@Constraint(validatedBy = CustomerIdConstraintClass.class)
public @interface CustomerIdConstraint {
	String message() default "Invalid customer ID.Id should starts with \'c\'";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
