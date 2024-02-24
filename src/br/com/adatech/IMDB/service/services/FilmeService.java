package br.com.adatech.IMDB.service.services;

import br.com.adatech.IMDB.Modelo.Ator;
import br.com.adatech.IMDB.Modelo.Diretor;
import br.com.adatech.IMDB.Modelo.Filme;
import br.com.adatech.IMDB.Modelo.Roteirista;
import br.com.adatech.IMDB.infra.repositorio.AtorRepositorio;
import br.com.adatech.IMDB.infra.repositorio.DiretorRepositorio;
import br.com.adatech.IMDB.infra.repositorio.FilmeRepositorio;
import br.com.adatech.IMDB.infra.repositorio.RoteiristaRepositorio;
import br.com.adatech.IMDB.infra.repositorio.exception.RepositorioException;
import br.com.adatech.IMDB.service.exception.ModeloInvalidoException;
import br.com.adatech.IMDB.service.exception.ServiceException;

import java.util.List;

public class FilmeService {
    private FilmeRepositorio repositorio;

    private AtorRepositorio atorRepositorio;

    private DiretorRepositorio diretorRepositorio;

    private RoteiristaRepositorio roteiristaRepositorio;


    public FilmeService(FilmeRepositorio repositorio, AtorRepositorio atorRepositorio, DiretorRepositorio diretorRepositorio, RoteiristaRepositorio roteiristaRepositorio) {
        this.repositorio = repositorio;
        this.atorRepositorio = atorRepositorio;
        this.diretorRepositorio = diretorRepositorio;
        this.roteiristaRepositorio = roteiristaRepositorio;
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

    public void associarAtor(String nomeFilme, String nomeAtor) throws ServiceException {
        Filme filmeParaAssociar = null;
        Ator atorParaAssociar = null;
        filmeParaAssociar = filmeUnico(nomeFilme);
        atorParaAssociar = atorRepositorio.consultarPorNomeAtor(nomeAtor);
        if (atorParaAssociar != null && filmeParaAssociar != null) {
            filmeParaAssociar.adicionarAtor(atorParaAssociar);
            atorParaAssociar.adicionarFilmesTrabalhados(filmeParaAssociar);
            try {
                atualizar(filmeParaAssociar);
                atorRepositorio.gravar(atorParaAssociar);
            } catch (RepositorioException repositorioException) {
                throw new ServiceException(repositorioException.getMessage(), repositorioException);
            }
        }
    }

    public void associarDiretor(String nomeFilme, String nomeDiretor) throws ServiceException {
        Filme filmeParaAssociar = null;
        Diretor diretorParaAssociar = null;
        filmeParaAssociar = filmeUnico(nomeFilme);
        diretorParaAssociar = diretorRepositorio.consultarPorNomeDiretor(nomeDiretor);
        if (diretorParaAssociar != null && filmeParaAssociar != null) {
            filmeParaAssociar.adicionarDiretor(diretorParaAssociar);
            diretorParaAssociar.adicionarFilmesTrabalhados(filmeParaAssociar);
            try {
                atualizar(filmeParaAssociar);
                diretorRepositorio.gravar(diretorParaAssociar);
            } catch (RepositorioException repositorioException) {
                throw new ServiceException(repositorioException.getMessage(), repositorioException);
            }
        }
    }

    public void associarRoteirista(String nomeFilme, String nomeRoteirista) throws ServiceException {
        Filme filmeParaAssociar = null;
        Roteirista roteiristaParaAssociar = null;
        filmeParaAssociar = filmeUnico(nomeFilme);
        roteiristaParaAssociar = roteiristaRepositorio.consultarPorNomerRoteirista(nomeRoteirista);
        if (roteiristaParaAssociar != null && filmeParaAssociar != null) {
            filmeParaAssociar.adicionarRoteirista(roteiristaParaAssociar);
            roteiristaParaAssociar.adicionarFilmesTrabalhados(filmeParaAssociar);
            try {
                atualizar(filmeParaAssociar);
                roteiristaRepositorio.gravar(roteiristaParaAssociar);
            } catch (RepositorioException repositorioException) {
                throw new ServiceException(repositorioException.getMessage(), repositorioException);
            }
        }
    }

}















