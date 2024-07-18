package com.example.spring_restapi.exception;

public class CustomerAlreadyExistsException extends RuntimeException{
	 public CustomerAlreadyExistsException(String message){
	        super(message);
	       System.out.println("CustomerAlreadyExistsException");
	    }
}
