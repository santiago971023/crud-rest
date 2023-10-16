package com.practice.restaurant.infraestructure.exceptionhandler;

import com.practice.restaurant.infraestructure.exception.NoDataFoundException;
import com.practice.restaurant.infraestructure.exception.RestaurantAlreadyExistException;
import com.practice.restaurant.infraestructure.exception.RestaurantNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    private static final String MESSAGE = "Message";

    @ExceptionHandler(RestaurantAlreadyExistException.class)
    public ResponseEntity<Map<String, String>> handlerRestaurantAlreadyExistException(
            RestaurantAlreadyExistException restaurantAlreadyExistException){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.RESTAURANT_ALREADY_EXIST.getMessage()));
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Map<String, String>> handlerNoDataFoundException(
            NoDataFoundException noDataFoundException){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.NO_DATA_FOUND.getMessage()));
    }

    @ExceptionHandler(RestaurantNotFoundException.class)
    public ResponseEntity<Map<String, String>> handlerRestaurantNotFoundException(
            RestaurantNotFoundException restaurantNotFoundException){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.RESTAURANT_NOT_FOUND.getMessage()));
    }

}
