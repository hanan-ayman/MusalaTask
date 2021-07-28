package com.musala.task.errorhandler;

import org.springframework.http.HttpStatus;

public class NotValidIPv4AddressException extends ApiException {
    HttpStatus status;
    public NotValidIPv4AddressException(String message) {
        super(message);
    }

    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
