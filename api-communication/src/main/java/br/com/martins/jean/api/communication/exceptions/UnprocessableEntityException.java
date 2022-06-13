package br.com.martins.jean.api.communication.exceptions;

public class UnprocessableEntityException extends RuntimeException{

    public UnprocessableEntityException(String message) {
        super(message);
    }

}
