package com.company.exceptions;

public class GivenKeyIsNotNeededKeyException extends Exception {

    @Override
    public String getMessage() {
        return "you do not have the key to unlock this";
    }
}
