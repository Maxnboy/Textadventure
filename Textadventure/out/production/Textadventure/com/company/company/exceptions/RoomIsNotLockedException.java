package com.company.exceptions;

public class RoomIsNotLockedException extends Exception{

    @Override
    public String getMessage() {
        return "This Room is already unlocked";
    }
}
