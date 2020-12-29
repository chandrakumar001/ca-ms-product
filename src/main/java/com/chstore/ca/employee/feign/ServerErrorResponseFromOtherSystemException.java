package com.chstore.ca.employee.feign;

import org.springframework.http.HttpStatus;

public class ServerErrorResponseFromOtherSystemException extends Exception {

    public ServerErrorResponseFromOtherSystemException(HttpStatus valueOf,
                                                       Exception defaultException) {
        System.out.println("Find 500 Error" + defaultException);
    }
}