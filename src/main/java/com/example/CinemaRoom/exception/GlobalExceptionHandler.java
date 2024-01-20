package com.example.CinemaRoom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {PurchaseException.class})
    public ResponseEntity<Object> handlePurchaseInfoException(PurchaseException purchaseException){
        FormatException formatException = new FormatException(purchaseException.getMessage());

        return new ResponseEntity<>(formatException, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = {UnauthorizedException.class})
    public ResponseEntity<Object> handleStatisticsInfoException(UnauthorizedException unauthorizedException){
        FormatException formatException = new FormatException(unauthorizedException.getMessage());
        return new ResponseEntity<>(formatException, HttpStatus.UNAUTHORIZED);
    }
}
