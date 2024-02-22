package br.com.adatech.IMDB.View.ator;

import br.com.adatech.IMDB.Modelo.Ator;
import br.com.adatech.IMDB.Modelo.Filme;
import br.com.adatech.IMDB.View.ScannerSingleton;
import br.com.adatech.IMDB.service.services.AtorService;
import br.com.adatech.IMDB.service.services.FilmeService;

import java.util.Scanner;

public class AssociaAtorView {
    private AtorService atorService;
    private FilmeService filmeService;

    public AssociaAtorView(AtorService atorService,FilmeService filmeService){
        this.atorService = atorService;
        this.filmeService = filmeService;


    }
    public void execute(){
        System.out.println("Digite o nome do ator que deseja associar");
        String nomeAtor =  ScannerSingleton.instance().getScanner().nextLine();
        System.out.println("Digite o nome do filme que deseja que o ator seja associado");;
        String nomeFilme =  ScannerSingleton.instance().getScanner().nextLine();
        Filme filmeParaAssociar = null;
        Ator atorParaAssociar = null;
            filmeParaAssociar = filmeService.filmeUnico(nomeFilme);
            atorParaAssociar = atorService.buscaAtorUnico(nomeAtor);
            filmeParaAssociar.adicionarAtor(atorService.buscaAtorUnico(nomeAtor));
            atorParaAssociar.adicionarFilmesTrabalhados(filmeParaAssociar);
            filmeService.atualizar(filmeParaAssociar);
            atorService.atualizar(atorParaAssociar);
            System.out.println("Ator associado com sucesso");
    }

}
