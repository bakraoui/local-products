package com.localproducts.exceptions;

public class RecordExistException extends RuntimeException {
    public RecordExistException(String message) {
        super(message);
    }
}
