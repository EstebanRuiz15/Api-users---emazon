package com.emazon.api_users.aplication.exceptions;

public class ErrorNotAuthenticated extends RuntimeException {
    public ErrorNotAuthenticated(String message){
        super(message);
    }
}
