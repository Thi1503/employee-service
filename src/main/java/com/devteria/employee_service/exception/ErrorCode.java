package com.devteria.employee_service.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {

    /// Đầu 1xx bắt lỗi Exception
    COMPANY_EXISTED(102, "Công ty đã tồn tại", HttpStatus.BAD_REQUEST),
    COMPANY_NOT_FOUND(103, "Không tìm thấy công ty", HttpStatus.NOT_FOUND),
    COMPANY_NAME_REQUIRED(104, "Tên công ty là bắt buộc", HttpStatus.BAD_REQUEST),
    COMPANY_ID_REQUIRED(105, "Thiếu ID công ty", HttpStatus.BAD_REQUEST),
    COMPANY_DELETE_FAILED(106, "Không thể xóa công ty", HttpStatus.INTERNAL_SERVER_ERROR),
    DEPARTMENT_NOT_FOUND(107, "Không tìm thấy phòng ban", HttpStatus.NOT_FOUND),
    DEPARTMENT_EXISTED(108, "Phòng ban đã tồn tại", HttpStatus.BAD_REQUEST),



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
