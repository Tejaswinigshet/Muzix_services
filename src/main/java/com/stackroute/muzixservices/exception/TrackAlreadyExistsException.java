package com.stackroute.muzixservices.exception;
public class TrackAlreadyExistsException extends Exception {
    private String message;

    public TrackAlreadyExistsException() {}

    public TrackAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
