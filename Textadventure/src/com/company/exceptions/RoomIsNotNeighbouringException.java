package com.company.exceptions;

public class RoomIsNotNeighbouringException extends Exception{

    @Override
    public String getMessage() {

        return "This room is not accessible from here";

    }
}
