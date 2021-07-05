package com.demo.exception;

//@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "A car can be selected by exactly one ONLINE Driver.")
public class CarAlreadyInUseException extends Exception {

    public CarAlreadyInUseException(String message) {
        super(message);
    }
}
