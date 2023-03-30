package com.week5.homework.exception;

public class UserNotFoundException extends AbstractUserException{
    public UserNotFoundException(String msg) {
        super(msg);
    }
}

