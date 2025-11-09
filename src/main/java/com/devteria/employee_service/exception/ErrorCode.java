package com.devteria.employee_service.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {

    /// Đầu 1xx bắt lỗi Exception
    POSITION_EXISTED(110,"Position already exists",HttpStatus.BAD_REQUEST),
    POSITION_NOT_FOUND(111,"Position not found", HttpStatus.NOT_FOUND),



    /// Đầu 2xx bắt lỗi auth
//    UNCATEGORIZED_EXCEPTION(299, "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),
//    UNAUTHENTICATED(201, "Unauthenticated", HttpStatus.UNAUTHORIZED),
//    UNAUTHORIZED(202, "You do not have permission", HttpStatus.FORBIDDEN),

    ///  Đầu 3xx bắt lỗi validate
//    INVALID_PASSWORD(301, "Password must be at least {min} characters", HttpStatus.BAD_REQUEST),
//    INVALID_DOB(302, "Your age must be at least {min}", HttpStatus.BAD_REQUEST),
//    INVALID_KEY(303, "Uncategorized error", HttpStatus.BAD_REQUEST),
    ;

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    private final int code;
    private final String message;
    private final HttpStatusCode statusCode;
}
