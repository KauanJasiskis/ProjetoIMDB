package br.com.adatech.IMDB.View.ator;

import br.com.adatech.IMDB.Modelo.Ator;
import br.com.adatech.IMDB.Modelo.Filme;
import br.com.adatech.IMDB.View.FormataData;
import br.com.adatech.IMDB.View.ScannerSingleton;
import br.com.adatech.IMDB.service.exception.ModeloInvalidoException;
import br.com.adatech.IMDB.service.services.AtorService;
import br.com.adatech.IMDB.service.services.FilmeService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CadastraAtorView
{
    private AtorService service;

    public CadastraAtorView(AtorService service){
        this.service = service;
    }

    public void execute(){
        System.out.println("Informe o nome do ator");
        String nome =  ScannerSingleton.instance().getScanner().nextLine();
        System.out.println("Agora informe a data de nascimento do ator no formato dd/MM/yyyy");
        String dataString =  ScannerSingleton.instance().getScanner().nextLine();
        LocalDate data = FormataData.formatarData(dataString);
        Ator ator = new Ator(nome,data);
        try {
            service.criar(ator);
        }catch (ModeloInvalidoException exception){
            System.out.println(exception.getMessage());
            execute();
        }
    }
}

