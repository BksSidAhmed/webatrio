package com.backend.webatrio.exception;

public class AgeTooHighException extends RuntimeException {

    public AgeTooHighException(String message) {
        super(message);
    }
}
