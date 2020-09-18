package com.dating.common;

public class CheckBasicException extends RuntimeException{
    private String message;
    public CheckBasicException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CheckBasicException{" +
                "message='" + message + '\'' +
                '}';
    }
}
