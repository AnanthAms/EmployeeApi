package com.example.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GloabalException {

	@ExceptionHandler(AgeException.class)
	public ResponseEntity<String> res(Exception ae){
		return new ResponseEntity<>(ae.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(NameNotFoundException.class)
	public ResponseEntity<String> re(Exception ae){
		return new ResponseEntity<>(ae.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DateTimeException.class)
    public ResponseEntity<String> handleDateTimeException(DateTimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(StartWithException.class)
	public ResponseEntity<String> abc(Exception s){
		return new ResponseEntity<>(s.getMessage(),HttpStatus.NOT_FOUND);
	}
}
