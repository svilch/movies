package com.movies.movies.exception;

public class NotFoundRecordException extends RuntimeException {
    public NotFoundRecordException(String message) {
        super(message);
    }
}
