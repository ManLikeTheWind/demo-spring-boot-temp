package com.dongxiang.demospringboot10globalexception.exception;

public class CustomException extends RuntimeException {
    private static final long servialVersionID=1l;

    private int code;

    public CustomException() {
        super();
    }

    public CustomException(String message, int code) {
        super(message);
        this.code = code;
    }



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
