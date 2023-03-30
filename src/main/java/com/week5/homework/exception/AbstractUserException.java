package com.week5.homework.exception;

public abstract class AbstractUserException extends RuntimeException{
    private String message;

    AbstractUserException(String msg){
        super(msg);
        this.message = msg;
    }
}
