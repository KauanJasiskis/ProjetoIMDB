package br.com.adatech.IMDB.View.diretor;

import br.com.adatech.IMDB.Modelo.Ator;
import br.com.adatech.IMDB.Modelo.Diretor;
import br.com.adatech.IMDB.service.services.AtorService;
import br.com.adatech.IMDB.service.services.DiretorService;

import java.util.List;

public class ListarDiretorView {
    private DiretorService service;

    public ListarDiretorView(DiretorService service) {
        this.service = service;

    }

    public void execute() {
        List diretores = service.listar();
        for (Object objeto : diretores) {
            Diretor diretor = (Diretor) objeto;
            System.out.println(diretor);
        }

    }
}


