package com.springbootapp.dto;

public class BadRequestException extends BaseClassException {
    Integer status;

    public BadRequestException(Integer status, String message) {
        super(message);
        this.status = status;
    }
}
