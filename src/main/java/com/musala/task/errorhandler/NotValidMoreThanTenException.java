package com.musala.task.errorhandler;

import org.springframework.http.HttpStatus;

public class NotValidMoreThanTenException extends ApiException {
    HttpStatus status;
    public NotValidMoreThanTenException(String message) {
        super(message);
    }

    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
