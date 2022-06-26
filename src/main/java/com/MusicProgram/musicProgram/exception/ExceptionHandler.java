package com.MusicProgram.musicProgram.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(CustomNotNullException.class)
	public ResponseEntity<?> customNotNull(CustomNotNullException customNotNullException) {
		List<String> detail = new ArrayList<>();
		detail.add(customNotNullException.getMessage());
		ErrorResponse errorResponse = new ErrorResponse("Will not null ", detail);
		return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(CustomNotFoundException.class)
	public ResponseEntity<?> customNotFound(CustomNotFoundException customNotFoundException) {
		List<String> detail = new ArrayList<>();
		detail.add(customNotFoundException.getMessage());
		ErrorResponse errorResponse = new ErrorResponse("Not Found", detail);
		return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(InternalServerError.class)
	public ResponseEntity<?> ınternalServer(InternalServerError internalServerError) {
		List<String> detail = new ArrayList<>();
		detail.add(internalServerError.getMessage());
		ErrorResponse errorResponse = new ErrorResponse("Değer Bulunamadı", detail);
		return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(NullPointerException.class)
	public ResponseEntity<?> nullPoint(NullPointerException nullPointerException) {
		List<String> detail = new ArrayList<>();
		detail.add(nullPointerException.getMessage());
		ErrorResponse errorResponse = new ErrorResponse("Null Değer Döndürüyor", detail);
		return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);

	}

}
