package br.com.adatech.IMDB.View.roteirista;

import br.com.adatech.IMDB.Modelo.Filme;
import br.com.adatech.IMDB.Modelo.Roteirista;
import br.com.adatech.IMDB.View.ScannerSingleton;
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
        ;
        String nomeFilme = ScannerSingleton.instance().getScanner().nextLine();
        Filme filmeParaAssociar = null;
        Roteirista roteiristaParaAssociar = null;
        filmeParaAssociar = filmeService.filmeUnico(nomeFilme);
        roteiristaParaAssociar = roteiristaService.buscaRoteiristaUnico(nomeRoteirista);
        filmeParaAssociar.adicionarRoteirista(roteiristaService.buscaRoteiristaUnico(nomeRoteirista));
        roteiristaParaAssociar.adicionarFilmesTrabalhados(filmeParaAssociar);
        filmeService.atualizar(filmeParaAssociar);
        roteiristaService.atualizar(roteiristaParaAssociar);
        System.out.println("Roteirista adicionado com sucesso");
    }

    ;

}



