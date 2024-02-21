package br.com.adatech.IMDB.infra.repositorio;

import br.com.adatech.IMDB.infra.banco.BancoDeDados;

import java.util.Collections;
import java.util.List;

public abstract class AbstractRepositorio
{
    protected BancoDeDados bancoDeDados;

    public AbstractRepositorio(BancoDeDados bancoDeDados){
        this.bancoDeDados = bancoDeDados;
    }
    public void gravar(Object objeto){
        this.bancoDeDados.inserirObjeto(objeto);
    }
    public List listar(){
        List objetosPresentesNoBanco = this.bancoDeDados.buscarObjetosPorTipo(classeModelo());
            return Collections.unmodifiableList(objetosPresentesNoBanco);
    }

    protected abstract Class classeModelo();
}
