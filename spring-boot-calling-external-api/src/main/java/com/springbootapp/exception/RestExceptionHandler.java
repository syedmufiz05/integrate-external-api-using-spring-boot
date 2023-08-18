package com.springbootapp.exception;

import com.springbootapp.dto.BadRequestException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler({BadRequestException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public HttpEntity<ResponseError> handleBadRequestException(BadRequestException ex) {
        return new HttpEntity<>(new ResponseError(400, ex.getMessage().replace("\"","")));
    }
}
