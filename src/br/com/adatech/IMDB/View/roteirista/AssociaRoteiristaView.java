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
        Filme filmeParaAssociar = null;
        Roteirista roteiristaParaAssociar = null;
        try {
            filmeParaAssociar = filmeService.filmeUnico(nomeFilme);
            roteiristaParaAssociar = roteiristaService.buscaRoteiristaUnico(nomeRoteirista);
            if (roteiristaParaAssociar != null && filmeParaAssociar != null) {
                filmeParaAssociar.adicionarRoteirista(roteiristaParaAssociar);
                roteiristaParaAssociar.adicionarFilmesTrabalhados(filmeParaAssociar);
                try {
                    filmeService.atualizar(filmeParaAssociar);
                    roteiristaService.atualizar(roteiristaParaAssociar);
                    System.out.println("Roteirista associado com sucesso");
                } catch (ServiceException exception) {
                    System.err.println("Ocorreu um erro tente novamente mais tarde");
                    execute();
                }
            } else if(roteiristaParaAssociar == null) {
                System.err.println("Roteirista não encontrado");
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

