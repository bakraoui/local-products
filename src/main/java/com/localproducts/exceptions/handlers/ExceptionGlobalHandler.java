package com.localproducts.exceptions.handlers;

import com.localproducts.exceptions.RecordExistException;
import com.localproducts.exceptions.RecordNotExistException;
import com.localproducts.exceptions.RecordNotValidException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionGlobalHandler  {

    @ExceptionHandler(RecordNotExistException.class)
    public ResponseEntity<Error> handleRecordNotExistException(RecordNotExistException exception) {
        Error error = Error.builder()
                .status(HttpStatus.NOT_FOUND)
                .message(exception.getMessage())
                .build();
        return ResponseEntity.ok(error);
    }


    @ExceptionHandler(RecordExistException.class)
    public ResponseEntity<Error> handleRecordExistException(RecordExistException exception) {
        Error error = Error.builder()
                .status(HttpStatus.CONFLICT)
                .message(exception.getMessage())
                .build();
        return ResponseEntity.ok(error);
    }

    @ExceptionHandler(RecordNotValidException.class)
    public ResponseEntity<Error> handleRecordNotValidException(RecordNotValidException exception) {
        Error error = Error.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message(exception.getMessage())
                .build();
        return ResponseEntity.ok(error);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Error> handleRuntimeException(RuntimeException exception) {
        Error error = Error.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message(exception.getMessage())
                .build();
        return ResponseEntity.ok(error);
    }


}


