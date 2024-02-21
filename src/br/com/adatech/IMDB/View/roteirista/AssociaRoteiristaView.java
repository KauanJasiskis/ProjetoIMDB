package br.com.adatech.IMDB.View.roteirista;

import br.com.adatech.IMDB.Modelo.Filme;
import br.com.adatech.IMDB.service.services.AtorService;
import br.com.adatech.IMDB.service.services.FilmeService;
import br.com.adatech.IMDB.service.services.RoteiristaService;

import java.util.Scanner;

public class AssociaRoteiristaView {
    private RoteiristaService roteiristaService;
    private FilmeService filmeService;

    public AssociaRoteiristaView(RoteiristaService roteiristaService,FilmeService filmeService){
        this.roteiristaService = roteiristaService;
        this.filmeService = filmeService;


    }
    public void execute(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do roteirista que deseja associar");
        String nomeRoteirista = scanner.nextLine();
        System.out.println("Digite o nome do filme que deseja que o roteirista seja associado");;
        String nomeFilme = scanner.nextLine();
        Filme filmeParaAssociar = null;
        if(roteiristaService.buscaRoteiristaUnico(nomeRoteirista)!= null && filmeService.filmeUnico(nomeFilme) != null){
            filmeParaAssociar = filmeService.filmeUnico(nomeFilme);
            filmeParaAssociar.adicionarRoteirista(roteiristaService.buscaRoteiristaUnico(nomeRoteirista));
            filmeService.atualizar(filmeParaAssociar);
        }
        ;

    }

}

