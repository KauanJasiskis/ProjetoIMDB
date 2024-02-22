package br.com.adatech.IMDB.service.services;

import br.com.adatech.IMDB.Modelo.Ator;
import br.com.adatech.IMDB.Modelo.Roteirista;
import br.com.adatech.IMDB.infra.repositorio.RoteiristaRepositorio;
import br.com.adatech.IMDB.infra.repositorio.exception.RepositorioException;
import br.com.adatech.IMDB.service.exception.ModeloInvalidoException;
import br.com.adatech.IMDB.service.exception.ServiceException;

import java.util.List;

public class RoteiristaService {
    private RoteiristaRepositorio repositorio;

    public RoteiristaService(RoteiristaRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void criar(Roteirista roteirista) throws ServiceException {
        if (roteirista == null) {
            throw new ModeloInvalidoException("Roteirista nao pode ser nulo");
        }
        if (roteirista.getNome() == null) {
            throw new ModeloInvalidoException("Roteirista nao pode ser nulo");
        }
        if (roteirista.getDataDeNasicmento() == null) {
            throw new ModeloInvalidoException("Data de nascimento nao pode ser nulo");
        }
        try {
            repositorio.gravar(roteirista);
        } catch (RepositorioException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }

    }

    public void atualizar(Roteirista roteirista) throws ServiceException {
        if (roteirista == null) {
            throw new ModeloInvalidoException("Roteirista nao pode ser nulo");
        }
        if (roteirista.getNome() == null) {
            throw new ModeloInvalidoException("Roteirista nao pode ser nulo");
        }
        if (roteirista.getDataDeNasicmento() == null) {
            throw new ModeloInvalidoException("Data de nascimento nao pode ser nulo");
        }
        Roteirista jaExistente = (Roteirista) repositorio.consultarPorNomerRoteirista(roteirista.getNome());
        if (jaExistente == null) {
            throw new ModeloInvalidoException("Roteirista não encontrado");
        }
        try {
            repositorio.gravar(roteirista);
        } catch (RepositorioException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }

    }

    public List listar() {
        return repositorio.listar();
    }

    public Roteirista buscaRoteiristaUnico(String nome) {
        return repositorio.consultarPorNomerRoteirista(nome);
    }
}
