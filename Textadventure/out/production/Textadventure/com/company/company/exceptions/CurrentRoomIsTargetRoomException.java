package com.company.exceptions;

public class CurrentRoomIsTargetRoomException extends Exception {

    @Override
    public String getMessage() {

        return "I am already in this room";

    }

}
