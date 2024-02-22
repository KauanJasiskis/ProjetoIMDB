package br.com.adatech.IMDB.service.services;

import br.com.adatech.IMDB.Modelo.Diretor;
import br.com.adatech.IMDB.Modelo.Filme;
import br.com.adatech.IMDB.infra.repositorio.DiretorRepositorio;
import br.com.adatech.IMDB.infra.repositorio.FilmeRepositorio;
import br.com.adatech.IMDB.infra.repositorio.exception.RepositorioException;
import br.com.adatech.IMDB.service.exception.ModeloInvalidoException;
import br.com.adatech.IMDB.service.exception.ServiceException;

import java.util.List;

public class DiretorService {
    private DiretorRepositorio repositorio;

    public DiretorService(DiretorRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void criar(Diretor diretor) throws ServiceException {
        if (diretor == null) {
            throw new ModeloInvalidoException("Diretor nao pode ser nulo");
        }
        if (diretor.getNome() == null || diretor.getNome().trim().isEmpty()) {
            throw new ModeloInvalidoException("Nome do diretor nao pode ser nulo");
        }
        if (diretor.getDataDeNasicmento() == null) {
            throw new ModeloInvalidoException("Data de nascimento nao pode ser nula");
        }
        try {
            repositorio.gravar(diretor);
        } catch (RepositorioException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }

    }

    public void atualizar(Diretor diretor) throws ServiceException {
        if (diretor == null) {
            throw new ModeloInvalidoException("Diretor nao pode ser nulo");
        }
        if (diretor.getNome() == null) {
            throw new ModeloInvalidoException("Nome do Diretor não pode ser nulo");
        }
        if (diretor.getDataDeNasicmento() == null) {
            throw new ModeloInvalidoException("Data de nascimento nao pode ser nula");
        }
        Diretor jaExistente = (Diretor) repositorio.consultarPorNomeDiretor(diretor.getNome());
        if (jaExistente == null) {
            throw new ModeloInvalidoException("Diretor não encontrado");
        }
        try {
            repositorio.gravar(diretor);
        } catch (RepositorioException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }

    }

    public List listar() {
        return repositorio.listar();
    }

    public Diretor buscaDiretorUnico(String nome) {
        return repositorio.consultarPorNomeDiretor(nome);

    }
}
