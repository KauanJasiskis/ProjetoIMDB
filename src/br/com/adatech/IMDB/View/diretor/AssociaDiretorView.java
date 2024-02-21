package br.com.adatech.IMDB.View.diretor;

import br.com.adatech.IMDB.Modelo.Diretor;
import br.com.adatech.IMDB.Modelo.Filme;
import br.com.adatech.IMDB.service.services.AtorService;
import br.com.adatech.IMDB.service.services.DiretorService;
import br.com.adatech.IMDB.service.services.FilmeService;

import java.util.Scanner;

public class AssociaDiretorView {
    private DiretorService diretorService;
    private FilmeService filmeService;

    public AssociaDiretorView(DiretorService diretorService,FilmeService filmeService){
        this.diretorService = diretorService;
        this.filmeService = filmeService;


    }
    public void execute(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do diretor que deseja associar");
        String nomeDiretor = scanner.nextLine();
        System.out.println("Digite o nome do filme que deseja que o ator seja associado");;
        String nomeFilme = scanner.nextLine();
        Filme filmeParaAssociar = null;
        Diretor diretorParaAssociar = null;
        if(diretorService.buscaDiretorUnico(nomeDiretor)!= null && filmeService.filmeUnico(nomeFilme) != null){
            filmeParaAssociar = filmeService.filmeUnico(nomeFilme);
            diretorParaAssociar = diretorService.buscaDiretorUnico(nomeDiretor);
            filmeParaAssociar.adicionarDiretor(diretorService.buscaDiretorUnico(nomeDiretor));
            diretorParaAssociar.adicionarFilmesTrabalhados(filmeParaAssociar);
            filmeService.atualizar(filmeParaAssociar);
            diretorService.atualizar(diretorParaAssociar);
        }
        ;

    }

}

