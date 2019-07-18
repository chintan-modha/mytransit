package com.mytransit.train.exception;

public class TrainNotFoundException extends RuntimeException {

    public TrainNotFoundException(Throwable cause) {
        super(cause);
    }

    public TrainNotFoundException(String message) {
        super(message);
    }

    public TrainNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
