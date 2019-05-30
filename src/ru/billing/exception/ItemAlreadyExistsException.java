package ru.billing.exception;

public class ItemAlreadyExistsException extends Exception {
    public ItemAlreadyExistsException(String message) {
        super(message);
    }

    public ItemAlreadyExistsException() {
        super("Default ItemAlreadyExistsException message");
    }
}
