package com.example.demo.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NotFoundException extends RuntimeException {
	
    private final ErrorCode errorCode;
    private final String message;
}