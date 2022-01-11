package com.company.exceptions;

public class ItemIsStaticException extends Exception{

    @Override
    public String getMessage() {
        return "This item is too heavy to carry";
    }
}
