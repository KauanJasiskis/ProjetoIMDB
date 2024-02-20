package br.com.adatech.IMDB.Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Artista extends Pessoa {
    private List<Filme> filmesTrabalhados = new ArrayList<>();
    public Artista(){};

    public Artista(String nome, LocalDate dataNasicmento){
        super(nome,dataNasicmento);

    }
    public List<String> getFilmesTrabalhados(){
        List<String> nomeDosFilmes = new ArrayList<>();
        for(Filme filme : filmesTrabalhados){
            nomeDosFilmes.add(filme.getNome());
        }
        return Collections.unmodifiableList(nomeDosFilmes);

    }
    public void adicionarFilmesTrabalhados(Filme filme){
        filmesTrabalhados.add(filme);

    }


}
