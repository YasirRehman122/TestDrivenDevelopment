package com.example.learningmockito.exception;

public class EmailNotificationException extends RuntimeException{
    public EmailNotificationException(String message){
        super(message);
    }
}
