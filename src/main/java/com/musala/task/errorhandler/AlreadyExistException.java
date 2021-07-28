package com.musala.task.errorhandler;

import org.springframework.http.HttpStatus;

public class AlreadyExistException extends ApiException {
    HttpStatus status;
    public AlreadyExistException(String message) {
        super(message);
    }

    public HttpStatus getStatus() {
        return HttpStatus.CONFLICT;
    }
}
