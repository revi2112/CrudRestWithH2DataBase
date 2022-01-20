package com.example.springboot.h2crud.springbootfirst.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalErrorHandler {
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc){
			
			CustomerErrorResponse error = new CustomerErrorResponse();
			error.setStatus(HttpStatus.NOT_FOUND.value());
			error.setMessage(exc.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
		
			return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
			//just return jackson will take care of printing 
			//error - body
			//status code
	}
		//others
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception exc){
			
			CustomerErrorResponse error = new CustomerErrorResponse();
			error.setStatus(HttpStatus.BAD_REQUEST.value());
			error.setMessage(exc.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
		
			return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
			//just return jackson will take care of printing 
			//error - body
			//status code
	}
}
