package com.example.CinemaRoom.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;


@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {PurchaseException.class})
    public ResponseEntity<Object> handlePurchaseInfoException(PurchaseException purchaseException){
        FormatException formatException = new FormatException(purchaseException.getMessage());

        return new ResponseEntity<>(formatException, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {StatisticsException.class})
    public ResponseEntity<Object> handleStatisticsInfoException(StatisticsException statisticsException){
        FormatException formatException = new FormatException(statisticsException.getMessage());

        return new ResponseEntity<>(formatException, HttpStatus.UNAUTHORIZED);
    }
}
