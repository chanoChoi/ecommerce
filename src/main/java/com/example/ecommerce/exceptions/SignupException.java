package com.example.ecommerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SignupException extends RuntimeException {
    public SignupException(String message, Throwable cause) {
        super(message, cause);
    }
    public SignupException(String message) {
        super(message);
    }
    public SignupException(Throwable cause) {
        super(cause);
    }
}
