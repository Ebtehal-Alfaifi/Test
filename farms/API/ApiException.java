package com.example.farms.API;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}
