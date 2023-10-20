package com.example.demo.common.exception;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
	
	private int status;
	private String message;
	private LocalDateTime timestamp;
	
	public ErrorResponse(ErrorCode errorCode) {
		this.message = errorCode.getMessage();
		this.status = errorCode.getStatus();
		this.timestamp = LocalDateTime.now();
	}

}
