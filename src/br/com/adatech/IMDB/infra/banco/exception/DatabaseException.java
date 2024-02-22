package br.com.adatech.IMDB.infra.banco.exception;

public class DatabaseException extends Exception {

    public DatabaseException(String message) {
        super(message);
    }
}