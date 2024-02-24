package br.com.adatech.IMDB.View.roteirista;

import br.com.adatech.IMDB.Modelo.Filme;
import br.com.adatech.IMDB.Modelo.Roteirista;
import br.com.adatech.IMDB.View.ScannerSingleton;
import br.com.adatech.IMDB.service.exception.ServiceException;
import br.com.adatech.IMDB.service.services.AtorService;
import br.com.adatech.IMDB.service.services.FilmeService;
import br.com.adatech.IMDB.service.services.RoteiristaService;

import java.util.Scanner;

public class AssociaRoteiristaView {
    private RoteiristaService roteiristaService;
    private FilmeService filmeService;

    public AssociaRoteiristaView(RoteiristaService roteiristaService, FilmeService filmeService) {
        this.roteiristaService = roteiristaService;
        this.filmeService = filmeService;


    }

    public void execute() {
        System.out.println("Digite o nome do roteirista que deseja associar");
        String nomeRoteirista = ScannerSingleton.instance().getScanner().nextLine();
        System.out.println("Digite o nome do filme que deseja que o roteirista seja associado");
        String nomeFilme = ScannerSingleton.instance().getScanner().nextLine();
        try {
            filmeService.associarRoteirista(nomeFilme, nomeRoteirista);
            System.out.println("DIRETOR ASSOCIADO COM SUCESSO!!!");
        } catch (ServiceException exception) {
            System.err.println("Erro");
        }
    }


}

