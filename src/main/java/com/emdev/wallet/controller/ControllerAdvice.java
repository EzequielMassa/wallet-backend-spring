package com.emdev.wallet.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.emdev.wallet.dto.ErrorDTO;
import com.emdev.wallet.exceptions.RequestException;

@RestControllerAdvice
public class ControllerAdvice {
	@ExceptionHandler(value = RequestException.class)
	public ResponseEntity<ErrorDTO> requestExceptionHandler(RequestException ex) {
		ErrorDTO error = ErrorDTO.builder().code(ex.getCode()).message(ex.getMessage()).build();
		return new ResponseEntity<>(error, ex.getHttpStatus());
	}
}
