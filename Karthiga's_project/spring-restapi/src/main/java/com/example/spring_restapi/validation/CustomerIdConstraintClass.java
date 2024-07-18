package com.example.spring_restapi.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomerIdConstraintClass implements ConstraintValidator<CustomerIdConstraint, String> {

    @Override
    public void initialize(CustomerIdConstraint custId) {
    }

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		System.out.println("Customer id validation!!");
		return value.startsWith("c");
	}

}
