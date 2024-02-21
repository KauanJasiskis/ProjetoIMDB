package br.com.adatech.IMDB.infra.repositorio;

import br.com.adatech.IMDB.Modelo.Ator;
import br.com.adatech.IMDB.Modelo.Diretor;
import br.com.adatech.IMDB.infra.banco.BancoDeDados;

import java.util.List;

public class AtorRepositorio extends AbstractRepositorio{

    public AtorRepositorio(BancoDeDados bancoDeDados) {
        super(bancoDeDados);
    }
    public Ator consultarPorNomeAtor(String nomeAtor) {
        List atores = listar();
        Ator atorEncontrado = null;
        for (Object objeto : atores) {
            Ator ator = (Ator) objeto;
            if (compararPorNomeDiretor(ator, nomeAtor)) {
               atorEncontrado = ator;
                break;
            }
        }
        return atorEncontrado;
    }



    protected Boolean compararPorNomeDiretor(Ator ator, String nome){
        return ator != null
                && ator.getNome()!= null
                && nome != null
                && ator.getNome().contains(nome);
    }



    @Override
    protected Class classeModelo() {
        return Ator.class;
    }
}
