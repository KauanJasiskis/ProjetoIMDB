package br.com.adatech.IMDB.service.exception;

public class ModeloInvalidoException extends RuntimeException{
    public ModeloInvalidoException(String mensagem){
        super(mensagem);
    }
}
