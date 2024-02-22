package br.com.adatech.IMDB.View.filme;

import br.com.adatech.IMDB.Modelo.Filme;
import br.com.adatech.IMDB.View.ScannerSingleton;
import br.com.adatech.IMDB.service.exception.ServiceException;
import br.com.adatech.IMDB.service.services.FilmeService;

import java.util.Scanner;

public class AvaliaFilmeView {
    private FilmeService service;

    public AvaliaFilmeView(FilmeService service){
        this.service = service;
    }

    public void execute(){
        System.out.println("Digite o nome do filme que deseja avaliar");
        String filmeInformado =  ScannerSingleton.instance().getScanner().nextLine();
        if(service.filmeUnico(filmeInformado)!= null) {
            System.out.println("Digite a nota de avaliacao de 0 a 10");
            Double nota =  ScannerSingleton.instance().getScanner().nextDouble();
            Filme filmeAvaliado = service.filmeUnico(filmeInformado);
            filmeAvaliado.setNotaGeral(nota);
            try {
                service.atualizar(filmeAvaliado);
            }catch (ServiceException exception){
            System.err.println("Ocorreu um erro tente novamente mais tarde");
            execute();
        }
        }

    }
}
