package com.localproducts.exceptions;

public class RecordNotExistException extends RuntimeException{

    public RecordNotExistException(String message) {
        super(message);
    }
}
