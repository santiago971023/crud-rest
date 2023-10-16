package com.practice.restaurant.infraestructure.exceptionhandler;

public enum ExceptionResponse {

    RESTAURANT_NOT_FOUND("No restaurant was found with that name"),
    RESTAURANT_ALREADY_EXIST("There is already a restaurant with that name"),
    NO_DATA_FOUND("No data found for the request petition");

    private String message;

    ExceptionResponse(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

}
