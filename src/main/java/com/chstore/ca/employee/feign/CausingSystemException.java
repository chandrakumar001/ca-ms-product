package com.chstore.ca.employee.feign;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class CausingSystemException extends Exception {

    public CausingSystemException(
            String message,
            Exception exception) {
        super(message, exception);
    }
}