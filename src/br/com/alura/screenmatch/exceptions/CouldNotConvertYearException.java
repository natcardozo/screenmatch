package br.com.alura.screenmatch.exceptions;

public class CouldNotConvertYearException extends RuntimeException {
    private String message;

    public CouldNotConvertYearException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
