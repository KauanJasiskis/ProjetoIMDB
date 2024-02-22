package br.com.adatech.IMDB.service.services;

import br.com.adatech.IMDB.Modelo.Ator;
import br.com.adatech.IMDB.Modelo.Diretor;
import br.com.adatech.IMDB.infra.repositorio.AtorRepositorio;
import br.com.adatech.IMDB.infra.repositorio.exception.RepositorioException;
import br.com.adatech.IMDB.service.exception.ModeloInvalidoException;
import br.com.adatech.IMDB.service.exception.ServiceException;

import java.util.List;

public class AtorService
{
    private AtorRepositorio repositorio;
    public AtorService(AtorRepositorio repositorio){
        this.repositorio = repositorio;
    }
    public void criar(Ator ator) throws ServiceException {
        if(ator == null){
            throw new ModeloInvalidoException("Ator nao pode ser nulo");
        }
        if(ator.getNome()==null){
            throw new ModeloInvalidoException("Nome do ator nao pode ser nulo");
        }
        if(ator.getDataDeNasicmento() == null){
            throw new ModeloInvalidoException("Data de nascimento nao pode ser nulo");
        }
        try {
            repositorio.gravar(ator);
        }catch (RepositorioException exception){
            throw new ServiceException(exception.getMessage(),exception);
        }

    }
    public void atualizar(Ator ator) throws ServiceException{
        if (ator == null) {
            throw new ModeloInvalidoException("Ator nao pode ser nulo");
        }
        if (ator.getNome() == null) {
            throw new ModeloInvalidoException("Nome do Ator não pode ser nulo");
        }
        if(ator.getDataDeNasicmento() == null) {
            throw new ModeloInvalidoException("Data de nascimento nao pode ser nula");
        }
        Ator jaExistente = (Ator) repositorio.consultarPorNomeAtor(ator.getNome());
        if (jaExistente == null) {
            throw new ModeloInvalidoException("Ator não encontrado");
        }
        try {
            repositorio.gravar(jaExistente);
        }catch (RepositorioException exception){
            throw new ServiceException(exception.getMessage(),exception);
        }
    }
    public List listar(){
        return repositorio.listar();
    }
    public Ator buscaAtorUnico(String nome){
        return repositorio.consultarPorNomeAtor(nome);
    }
}

