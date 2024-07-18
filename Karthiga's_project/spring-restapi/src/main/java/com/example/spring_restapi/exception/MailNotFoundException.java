package com.example.spring_restapi.exception;

public class MailNotFoundException extends RuntimeException{
	 public MailNotFoundException(String message){
	        super(message);
	       System.out.println("MailNotFoundException");
	    }
}