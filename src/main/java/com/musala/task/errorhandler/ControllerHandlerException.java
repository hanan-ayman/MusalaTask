package com.musala.task.errorhandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerHandlerException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorDetails> handlerExceptionAPIGeneric(ApiException ex , WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(ex.getMessage() , request.getDescription(false));
        return new ResponseEntity<ErrorDetails>(errorDetails , ex.getStatus());
    }
}
