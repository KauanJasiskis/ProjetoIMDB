package br.com.adatech.IMDB.infra.repositorio;

import br.com.adatech.IMDB.Modelo.Filme;
import br.com.adatech.IMDB.infra.banco.BancoDeDados;

import java.rmi.AlreadyBoundException;
import java.util.ArrayList;
import java.util.List;

public class FilmeRepositorio extends AbstractRepositorio{



    public FilmeRepositorio(BancoDeDados bancoDeDados) {
        super(bancoDeDados);
    }
    public List consultarPorNomeFilme(String nomeFilme){
        List filmes = listar();
        List filmesFiltrados = new ArrayList();
        for(Object objeto : filmes) {
            Filme filme = (Filme) objeto;
            if(compararPorNomeFilmeNomeIgual(filme,nomeFilme)){
                filmesFiltrados.add(filme);
            }
            else if(!compararPorNomeFilmeNomeIgual(filme,nomeFilme)){
                if(filme.getNome().toLowerCase().startsWith(nomeFilme.toLowerCase().substring(0,2))){
                   filmesFiltrados.add(filme);
                }
            }
        }
        return filmesFiltrados;
    }
    public Filme consultarFilmeUnico(String nomeFilme){
        List filmes = listar();
        Filme filmeEncontrado = null;
        for(Object objeto : filmes){
            Filme filme = (Filme) objeto;
            if(compararPorNomeFilme(filme,nomeFilme)){
                filmeEncontrado = filme;
            }
        }
        return filmeEncontrado;
    }

    @Override
    protected Class classeModelo() {
        return Filme.class;
    }


    protected Boolean compararPorNomeFilme(Filme filme,String nome){
        return filme != null
                && filme.getNome() != null
                && filme.getNome().equals(nome);
    }
    protected Boolean compararPorNomeFilmeNomeIgual(Filme filme,String nome){
        return filme != null
                && filme.getNome() != null
                && filme.getNome().equalsIgnoreCase(nome);
    }


    }


