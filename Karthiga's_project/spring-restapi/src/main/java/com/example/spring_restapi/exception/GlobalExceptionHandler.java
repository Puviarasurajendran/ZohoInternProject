package com.example.spring_restapi.exception;

import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.spring_restapi.service.Response;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler({ CustomerAlreadyExistsException.class,MailNotFoundException.class,CustomizedException.class })
	public ResponseEntity<?> handleCustomException(Exception exception) {
		System.out.println("CustomException");
		return new ResponseEntity<>(
				new Response(exception.getMessage(),(StringBuilder)null),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ HttpRequestMethodNotSupportedException.class })
	public ResponseEntity<Object> handleHttpRequestMethodNotSupportedException(
			HttpRequestMethodNotSupportedException exception) {
		System.out.println("HttpRequestMethodNotSupportedException " + exception.getMessage());

		return new ResponseEntity<>(new Response("Path variable not found", (StringBuilder) null),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ MissingServletRequestParameterException.class })
	public ResponseEntity<Response> handleMissingServletRequestParameterException(
			MissingServletRequestParameterException exception) {
		System.out.println("HttpMissingServletRequestParameterException");
		return new ResponseEntity<>(
				new Response("Required field not found", new StringBuilder(exception.getParameterName())),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({HttpMessageNotReadableException.class, HttpMediaTypeNotSupportedException.class,ValidationException.class})
	public ResponseEntity<Response> handleMissingOrMalformedRequestBodyException(Exception exception) {
		System.out.println("MissingOrMalformedRequestBodyException");
		return new ResponseEntity<>(
				new Response("Missing or malformed request body", (StringBuilder)null),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ RuntimeException.class })
	public ResponseEntity<Object> handleRuntimeException(RuntimeException exception) {
		System.out.println("RuntimeException:"+exception.getLocalizedMessage());
		exception.printStackTrace();
		return new ResponseEntity<>(
				new Response(exception.getMessage(), (StringBuilder)null),
				HttpStatus.BAD_REQUEST);
	}
}
