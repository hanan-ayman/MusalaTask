package com.musala.task.errorhandler;

import org.springframework.http.HttpStatus;

public abstract class ApiException extends RuntimeException {
    HttpStatus status;
    String message;

    public ApiException(String message) {
        super(message);
    }
    public abstract HttpStatus getStatus();
}
