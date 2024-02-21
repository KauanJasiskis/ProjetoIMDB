package br.com.adatech.IMDB.View.filme;

import br.com.adatech.IMDB.Modelo.Filme;
import br.com.adatech.IMDB.infra.repositorio.FilmeRepositorio;
import br.com.adatech.IMDB.service.services.FilmeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PesquisarFilmeView {
    private FilmeService service;

    public PesquisarFilmeView(FilmeService service){
        this.service = service;
    }

    public void execute(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do filme que deseja pesquisar: ");
        String filmeInformado = scanner.nextLine();
        List filmesEncontrados =  service.filmesPesquisado(filmeInformado);
        for(Object objeto: filmesEncontrados){
            Filme filme = (Filme) objeto;
            System.out.println(filme);

        }



    }
}
