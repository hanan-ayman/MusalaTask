package com.musala.task.errorhandler;

import org.springframework.http.HttpStatus;

public class NotFoundException extends ApiException {
    HttpStatus status;
    public NotFoundException(String message) {
        super(message);
    }

    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
