package br.com.adatech.IMDB.View.ator;

import br.com.adatech.IMDB.Modelo.Ator;
import br.com.adatech.IMDB.Modelo.Filme;
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do ator que deseja associar");
        String nomeAtor = scanner.nextLine();
        System.out.println("Digite o nome do filme que deseja que o ator seja associado");;
        String nomeFilme = scanner.nextLine();
        Filme filmeParaAssociar = null;
        Ator atorParaAssociar = null;
        if(atorService.buscaAtorUnico(nomeAtor)!= null && filmeService.filmeUnico(nomeFilme) != null){
            filmeParaAssociar = filmeService.filmeUnico(nomeFilme);
            atorParaAssociar = atorService.buscaAtorUnico(nomeAtor);
            filmeParaAssociar.adicionarAtor(atorService.buscaAtorUnico(nomeAtor));
            atorParaAssociar.adicionarFilmesTrabalhados(filmeParaAssociar);
            filmeService.atualizar(filmeParaAssociar);
            atorService.atualizar(atorParaAssociar);

            System.out.println("Ator associado com sucesso");
        }
        else{
            System.out.println("Erro");
        }
        ;

    }

}
