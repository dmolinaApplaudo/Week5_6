package com.week5.homework.exception;

public class UserAlreadyExistsException extends AbstractUserException{
    public UserAlreadyExistsException(String msg) {
        super(msg);
    }
}
