package com.localproducts.exceptions;

public class RecordNotValidException extends RuntimeException {
    public RecordNotValidException(String message) {
        super(message);
    }
}
