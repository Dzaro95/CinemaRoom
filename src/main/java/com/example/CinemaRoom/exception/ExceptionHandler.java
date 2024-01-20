package com.example.CinemaRoom.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {PurchaseInfoException.class})
    public ResponseEntity<Object> handlePurchaseInfoException(PurchaseInfoException purchaseInfoException){
        FormatException formatException = new FormatException(purchaseInfoException.getMessage());

        return new ResponseEntity<>(formatException, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {StatisticsInfoException.class})
    public ResponseEntity<Object> handleStatisticsInfoException(StatisticsInfoException statisticsInfoException){
        FormatException formatException = new FormatException(statisticsInfoException.getMessage());

        return new ResponseEntity<>(formatException, HttpStatus.UNAUTHORIZED);
    }
}
