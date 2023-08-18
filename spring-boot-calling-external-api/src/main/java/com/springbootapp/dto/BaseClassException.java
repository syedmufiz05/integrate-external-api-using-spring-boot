package com.springbootapp.dto;

public abstract class BaseClassException extends RuntimeException {
    BaseClassException(String message) {
        super(message);
    }

    BaseClassException(Throwable e) {
        super(e);
    }

    BaseClassException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseClassException() {
    }
}