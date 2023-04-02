package com.example.example.controller.advice;

import com.example.example.controller.advice.dto.ErrorMessage;
import com.example.example.controller.advice.dto.ValidationErrorMessage;
import com.example.example.service.exception.NotFoundException;
import com.example.example.service.exception.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler({ServiceException.class, NotFoundException.class})
    public ResponseEntity<ErrorMessage> handleException(RuntimeException exception) {
        var result = new ErrorMessage(exception.getMessage());
        return status(HttpStatus.BAD_REQUEST).body(result);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationErrorMessage>> handleException(MethodArgumentNotValidException exception) {
        var result = exception.getBindingResult().getFieldErrors().stream()
                .map(x -> new ValidationErrorMessage(x.getField(), x.getDefaultMessage()))
                .toList();
        return status(HttpStatus.BAD_REQUEST).body(result);
    }
}
