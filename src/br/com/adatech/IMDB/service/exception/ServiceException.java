package br.com.adatech.IMDB.service.exception;


public class ServiceException extends Exception {

    public ServiceException(String message, Exception cause) {
        super(message, cause);
    }
}
