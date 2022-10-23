package com.edrone.exercise.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(JobNotFoundException.class)
    public ResponseEntity<Object> handleJobProductNotFoundException(JobNotFoundException exception){
        return new ResponseEntity<>("Job with given id doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TooMuchStringsException.class)
    public ResponseEntity<Object> handleTooMuchStringException(TooMuchStringsException exception){
        return new ResponseEntity<>("You can't make that many strings", HttpStatus.BAD_REQUEST);
    }

}
