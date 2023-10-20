package com.example.demo.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
	
	/* 200 OK : 성공 */
	SUCCESS(200,"요청에 성공하였습니다."),

	/* 400 BAD_REQUEST : 잘못된 요청 */
    INVALID_PARAMETER(400, "파라미터 값을 확인해주세요."),

	/* 404 NOT_FOUND : Resource 를 찾을 수 없음 */
	RESOURCE_NOT_FOUND(404, "해당 정보를 찾을 수 없습니다."),

	/* 409 CONFLICT : 데이터 중복 */
	DUPLICATE_RESOURCE(409, "데이터가 이미 존재합니다"),

	/* 500 INTERNAL_SERVER_ERROR */
	SERVER_ERROR(500, "예기치 못한 오류가 발생하였습니다.");

	private final int status;
	private final String message;

}