package com.springbootapp.exception;

public class ResponseError {
    int status;
    String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseError(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
