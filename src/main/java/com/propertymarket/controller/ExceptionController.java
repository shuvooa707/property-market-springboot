package com.propertymarket.controller;


import com.propertymarket.dto.AddressDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<?> handleError(Throwable throwable) {

        return ResponseEntity.ok(throwable.getStackTrace());
    }
}
