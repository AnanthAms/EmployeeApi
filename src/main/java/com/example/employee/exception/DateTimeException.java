package com.example.employee.exception;

public class DateTimeException extends Exception {

	public DateTimeException (String message) {
		super(message);
	}
	
	 public DateTimeException(String message, Throwable cause) {
	        super(message, cause);
	    }

}
