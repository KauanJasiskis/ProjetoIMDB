package br.com.adatech.IMDB.infra.repositorio;

import br.com.adatech.IMDB.Modelo.Diretor;
import br.com.adatech.IMDB.Modelo.Filme;
import br.com.adatech.IMDB.infra.banco.BancoDeDados;

import java.util.ArrayList;
import java.util.List;

public class DiretorRepositorio extends AbstractRepositorio{
    public DiretorRepositorio(BancoDeDados bancoDeDados) {
        super(bancoDeDados);
    }
    public Diretor consultarPorNomeDiretor(String nomeDiretor) {
        List diretores = listar();
        Diretor diretorEncontrado = null;
        for (Object objeto : diretores) {
            Diretor diretor = (Diretor) objeto;
            if (compararPorNomeDiretor(diretor, nomeDiretor)) {
                diretorEncontrado = diretor;
                break;
            }
        }
        return diretorEncontrado;
    }


    protected Boolean compararPorNomeDiretor(Diretor diretor, String nome){
        return diretor != null
                && diretor.getNome()!= null
                && nome != null
                && diretor.getNome().contains(nome);
    }


    @Override
    protected Class classeModelo() {
        return Diretor.class;
    }
}
