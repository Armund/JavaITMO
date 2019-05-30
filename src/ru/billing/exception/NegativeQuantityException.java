package ru.billing.exception;

public class NegativeQuantityException extends Exception {
    public NegativeQuantityException(String message) {
        super(message);
    }

    public NegativeQuantityException() {
        super("Default NegativeQuantityException message");
    }
}
