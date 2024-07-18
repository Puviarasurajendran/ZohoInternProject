package com.example.spring_restapi.exception;

public class CustomizedException extends RuntimeException{

	 public CustomizedException(String message){
	        super(message);
	       System.out.println("CustomizedException");
	    }
}
