package ru.billing.exception;

public class CatalogLoadException extends Exception {
    public CatalogLoadException(String message) {
        super(message);
    }

    public CatalogLoadException() {
        super("Default CatalogLoadException message");
    }

    public CatalogLoadException (Exception e){
      super(e);
    }
}
