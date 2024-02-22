package br.com.adatech.IMDB.infra.repositorio;

import br.com.adatech.IMDB.infra.banco.BancoDeDados;
import br.com.adatech.IMDB.infra.banco.exception.DatabaseException;
import br.com.adatech.IMDB.infra.repositorio.exception.RepositorioException;

import java.util.Collections;
import java.util.List;

public abstract class AbstractRepositorio
{
    protected BancoDeDados bancoDeDados;

    public AbstractRepositorio(BancoDeDados bancoDeDados){
        this.bancoDeDados = bancoDeDados;
    }
    public void gravar(Object objeto)throws RepositorioException {
        try {
            this.bancoDeDados.inserirObjeto(objeto);
        }catch (DatabaseException exception){
            throw new RepositorioException(exception.getMessage(),exception);
        }
    }
    public List listar(){
        List objetosPresentesNoBanco = this.bancoDeDados.buscarObjetosPorTipo(classeModelo());
            return Collections.unmodifiableList(objetosPresentesNoBanco);
    }

    protected abstract Class classeModelo();
}
