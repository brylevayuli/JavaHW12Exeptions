package org.example;

public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException(String msg) {
        super(msg);
    }
}
