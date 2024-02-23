package com.terranova.exception;

public class ForeignKeyException extends Exception{
    public ForeignKeyException(String err) {
        System.out.println(err);
    }

}
