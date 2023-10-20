package com.example.demo.common.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.common.exception.BadRequestException;
import com.example.demo.common.exception.ConflictException;
import com.example.demo.common.exception.ErrorCode;
import com.example.demo.common.exception.ErrorResponse;
import com.example.demo.common.exception.NotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	
	/* 400 에러 */
    @ExceptionHandler(BadRequestException.class)
    protected ResponseEntity<ErrorResponse> badRequestException(BadRequestException e) {
    	log.error("badRequestException: ", e.getErrorCode());
    	ErrorResponse response = new ErrorResponse(ErrorCode.INVALID_PARAMETER);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
	
    /* 404 에러 */
    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<ErrorResponse> notFoundException(NotFoundException e) {
    	log.error("notFoundException: ", e.getErrorCode());
    	ErrorResponse response = new ErrorResponse(ErrorCode.RESOURCE_NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    
    /* 409 에러 */
    @ExceptionHandler(ConflictException.class)
    protected ResponseEntity<ErrorResponse> conflictException(ConflictException e) {
    	log.error("conflictException: ", e.getErrorCode());
    	ErrorResponse response = new ErrorResponse(ErrorCode.DUPLICATE_RESOURCE);
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
	
    /* 500 에러 */
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<ErrorResponse> handleException(Exception e) {
		log.error("handleException: ", e.getMessage());
		ErrorResponse response = new ErrorResponse(ErrorCode.SERVER_ERROR);
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
