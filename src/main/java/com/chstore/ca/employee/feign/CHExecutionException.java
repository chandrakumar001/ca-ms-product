package com.chstore.ca.employee.feign;

public class CHExecutionException extends Throwable {

    private final String code;
    private final String message;

    CHExecutionException(final String code, final String description) {
        this.code = code;
        this.message = description;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

}
