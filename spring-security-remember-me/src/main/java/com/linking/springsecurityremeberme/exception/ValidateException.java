package com.linking.springsecurityremeberme.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.AuthenticationException;

public class ValidateException extends AuthenticationException {
    @Getter
    @Setter
    private String code;

    @Getter
    @Setter
    private String msg;

    @Getter
    @Setter
    private Exception exception;

    public ValidateException(String msg) {
        super(msg);
    }

    public ValidateException(String msg, Throwable t) {
        super(msg, t);
    }
}
