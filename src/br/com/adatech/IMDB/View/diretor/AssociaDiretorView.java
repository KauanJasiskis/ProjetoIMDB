package br.com.adatech.IMDB.View.diretor;

import br.com.adatech.IMDB.Modelo.Diretor;
import br.com.adatech.IMDB.Modelo.Filme;
import br.com.adatech.IMDB.View.ScannerSingleton;
import br.com.adatech.IMDB.service.exception.ServiceException;
import br.com.adatech.IMDB.service.services.AtorService;
import br.com.adatech.IMDB.service.services.DiretorService;
import br.com.adatech.IMDB.service.services.FilmeService;

import java.sql.SQLOutput;
import java.util.Scanner;

public class AssociaDiretorView {
    private DiretorService diretorService;
    private FilmeService filmeService;

    public AssociaDiretorView(DiretorService diretorService, FilmeService filmeService) {
        this.diretorService = diretorService;
        this.filmeService = filmeService;


    }

    public void execute() {
        System.out.println("Digite o nome do diretor que deseja associar");
        String nomeDiretor = ScannerSingleton.instance().getScanner().nextLine();
        System.out.println("Digite o nome do filme que deseja que o ator seja associado");
        String nomeFilme = ScannerSingleton.instance().getScanner().nextLine();
        Filme filmeParaAssociar = null;
        Diretor diretorParaAssociar = null;
        try {
            filmeParaAssociar = filmeService.filmeUnico(nomeFilme);
            diretorParaAssociar = diretorService.buscaDiretorUnico(nomeDiretor);
            if (diretorParaAssociar != null && filmeParaAssociar != null) {
                filmeParaAssociar.adicionarDiretor(diretorParaAssociar);
                diretorParaAssociar.adicionarFilmesTrabalhados(filmeParaAssociar);
                try {
                    filmeService.atualizar(filmeParaAssociar);
                    diretorService.atualizar(diretorParaAssociar);
                    System.out.println("Diretor associado com sucesso");
                } catch (ServiceException exception) {
                    System.err.println("Ocorreu um erro tente novamente mais tarde");
                    execute();
                }
            } else if(diretorParaAssociar == null) {
                System.err.println("Diretor não encontrado");
                execute();
            }
            else if(filmeParaAssociar == null){
                System.err.println("Filme nao encontrado");
                execute();
            }
        }catch (Exception exception){
            System.err.println("Exception nao esperada");
        }
    }


}



