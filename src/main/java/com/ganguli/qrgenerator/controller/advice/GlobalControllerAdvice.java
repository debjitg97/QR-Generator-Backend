package com.ganguli.qrgenerator.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ganguli.qrgenerator.dto.ErrorResponseDTO;
import com.ganguli.qrgenerator.exception.BadRequestException;

@RestControllerAdvice
public class GlobalControllerAdvice {
	@ExceptionHandler(value = { BadRequestException.class })
	public ResponseEntity<ErrorResponseDTO> badRequest(BadRequestException ex) {
		return new ResponseEntity<>(new ErrorResponseDTO(ex.getMessage(), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<ErrorResponseDTO> generalException(Exception ex) {
		return new ResponseEntity<>(new ErrorResponseDTO(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
