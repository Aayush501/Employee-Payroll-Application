package com.bridgelabz.employeepayrollapp.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionHandlers {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException m) {
        return new ResponseEntity<>("Values you have entered, are not valid !!! Please Try Again !!!", HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(EmployeeNotFound.class)
    public ResponseEntity<String> handleEmployeeNotFoundException(EmployeeNotFound e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
