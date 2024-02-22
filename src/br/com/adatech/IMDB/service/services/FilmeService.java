package br.com.adatech.IMDB.service.services;

import br.com.adatech.IMDB.Modelo.Filme;
import br.com.adatech.IMDB.infra.repositorio.FilmeRepositorio;
import br.com.adatech.IMDB.infra.repositorio.exception.RepositorioException;
import br.com.adatech.IMDB.service.exception.ModeloInvalidoException;
import br.com.adatech.IMDB.service.exception.ServiceException;

import java.util.List;

public class FilmeService {
    private FilmeRepositorio repositorio;

    public FilmeService(FilmeRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void criar(Filme filme) throws ServiceException {
        if (filme == null) {
            throw new ModeloInvalidoException("Filme nao pode ser nulo");
        }
        if (filme.getNome() == null || filme.getNome().trim().isEmpty()) {
            throw new ModeloInvalidoException("Nome do Filme nao pode ser nulo");
        }
        if (filme.getDataDeLancamento() == null) {
            throw new ModeloInvalidoException("Data de lancamento do filme nao pode ser nula");
        }
        try {
            repositorio.gravar(filme);
        } catch (RepositorioException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }

    }

    public void atualizar(Filme filme) throws ServiceException {
        if (filme == null) {
            throw new ModeloInvalidoException("Filme nao pode ser nulo");
        }
        if (filme.getNome() == null) {
            throw new ModeloInvalidoException("Nome do filme não pode ser nulo");
        }
        if (filme.getDataDeLancamento() == null) {
            throw new ModeloInvalidoException("Data de lancamento do filme nao pode ser nula");
        }
        Filme jaExistente = repositorio.consultarFilmeUnico(filme.getNome());
        if (jaExistente == null) {
            throw new ModeloInvalidoException("Filme não encontrado");
        }
        try {
            repositorio.gravar(filme);
        } catch (RepositorioException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }

    }

    public List listar() {
        return repositorio.listar();
    }

    public List filmesPesquisado(String filmeInformado) {
        return repositorio.consultarPorNomeFilme(filmeInformado);
    }

    public Filme filmeUnico(String filmeInformado) {
        return repositorio.consultarFilmeUnico(filmeInformado);
    }

}
