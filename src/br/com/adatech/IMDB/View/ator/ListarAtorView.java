package br.com.adatech.IMDB.View.ator;

import br.com.adatech.IMDB.Modelo.Ator;
import br.com.adatech.IMDB.Modelo.Filme;
import br.com.adatech.IMDB.service.services.AtorService;
import br.com.adatech.IMDB.service.services.FilmeService;

import java.util.List;

public class ListarAtorView {
    private AtorService service;

    public ListarAtorView(AtorService service){
        this.service = service;

    }
    public void execute(){
        List atores = service.listar();
        for(Object objeto : atores){
            Ator ator = (Ator) objeto;
            System.out.println(ator);
        }
}

}
