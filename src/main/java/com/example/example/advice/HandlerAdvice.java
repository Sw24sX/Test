package com.example.example.advice;

import com.example.example.controller.dto.ExampleDto;
import com.example.example.exception.ExampleException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.ResponseEntity.status;

@RestControllerAdvice
public class HandlerAdvice {
    @ExceptionHandler(ExampleException.class)
    private ResponseEntity<ExampleDto> handleException(ExampleException ex) {
        var result = new ExampleDto();
        result.setName(ex.getMessage());
        result.setAge(0);
        return status(HttpStatus.BAD_REQUEST).body(result);
    }
}
