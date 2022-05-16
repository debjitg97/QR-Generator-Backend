package com.ganguli.qrgenerator.exception;

public class BadRequestException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public BadRequestException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
