package com.chstore.ca.employee.feign;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Optional;

import static org.springframework.util.StringUtils.isEmpty;

@Getter
public final class SystemError implements Serializable {

    private final String system;
    private final String code;
    private final String message;
    private final HttpStatus httpstatus;

    public static final SystemError NONE = new SystemError(
            "",
            "",
            "",
            null
    );

    private SystemError(final String system,
                        final String code,
                        final String message,
                        final HttpStatus httpstatus) {
        this.system = system;
        this.code = code;
        this.message = message;
        this.httpstatus = httpstatus;
    }

    public static SystemError of(final String system,
                                 final String code,
                                 final String message,
                                 final HttpStatus httpstatus) {
        return new SystemError(system, code, message, httpstatus);
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getSystem() {
        return system;
    }

    public Optional<HttpStatus> getHttpStatus() {
        return Optional.ofNullable(httpstatus);
    }

    public boolean isUnknown() {
        return isEmpty(system) && isEmpty(message) && isEmpty(code) && httpstatus == null;
    }
}
