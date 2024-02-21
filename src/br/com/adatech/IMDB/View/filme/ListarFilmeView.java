package br.com.adatech.IMDB.View.filme;

import br.com.adatech.IMDB.Modelo.Filme;
import br.com.adatech.IMDB.service.services.FilmeService;

import java.util.List;

public class ListarFilmeView {
    private FilmeService service;

    public ListarFilmeView(FilmeService service){
        this.service = service;

    }
    public void execute(){
        List filmes = service.listar();
        for(Object objeto : filmes){
            Filme filme = (Filme) objeto;
            System.out.println("Nome: " + filme.getNome());
            System.out.println("Nota geral: " + filme.getNotaFinal() + " Vezes Avaliado: " + filme.getVezesAvaliado());
        }


    }
}
