package br.com.adatech.IMDB.View.roteirista;

import br.com.adatech.IMDB.Modelo.Ator;
import br.com.adatech.IMDB.Modelo.Diretor;
import br.com.adatech.IMDB.Modelo.Filme;
import br.com.adatech.IMDB.Modelo.Roteirista;
import br.com.adatech.IMDB.service.services.DiretorService;
import br.com.adatech.IMDB.service.services.RoteiristaService;

import java.util.List;

public class ListarRoteiristaView {
    private RoteiristaService service;

    public ListarRoteiristaView(RoteiristaService service) {
        this.service = service;

    }

    public void execute() {
        List roteiristas = service.listar();
        for (Object objeto : roteiristas) {
            Roteirista roteirista = (Roteirista) objeto;
            System.out.println(roteirista);
        }
    }
}
