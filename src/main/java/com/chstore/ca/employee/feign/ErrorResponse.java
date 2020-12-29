package com.chstore.ca.employee.feign;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Getter
@Setter
public class ErrorResponse {

    private final String system;
    private final String code;
    private final String message;
    private final HttpStatus httpstatus;

    private ErrorResponse(final String system,
                          final String code,
                          final String message,
                          final HttpStatus httpstatus) {
        this.system = system;
        this.code = code;
        this.message = message;
        this.httpstatus = httpstatus;
    }

    public static ErrorResponse of(final String system,
                                   final String code,
                                   final String message,
                                   final HttpStatus httpstatus) {
        return new ErrorResponse(system, code, message, httpstatus);
    }
}
