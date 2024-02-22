package br.com.adatech.IMDB.infra.repositorio.exception;

public class RepositorioException extends Exception {

    public RepositorioException(String message, Exception cause) {
        super(message, cause);
    }

}