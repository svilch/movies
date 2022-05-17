package com.movies.movies.exception;

public class DuplicateRecordException extends RuntimeException {
    public DuplicateRecordException(String message) {
        super(message);
    }
}