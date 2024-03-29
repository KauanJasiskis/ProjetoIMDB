package br.com.adatech.IMDB.View.ator;

import br.com.adatech.IMDB.Modelo.Ator;
import br.com.adatech.IMDB.Modelo.Filme;
import br.com.adatech.IMDB.View.FormataData;
import br.com.adatech.IMDB.View.ScannerSingleton;
import br.com.adatech.IMDB.service.exception.ModeloInvalidoException;
import br.com.adatech.IMDB.service.exception.ServiceException;
import br.com.adatech.IMDB.service.services.AtorService;
import br.com.adatech.IMDB.service.services.FilmeService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
        LocalDate data = null;
        Ator ator = null;
        try {
            System.out.println("Agora informe a data de nascimento do ator no formato dd/MM/yyyy");
            String dataString =  ScannerSingleton.instance().getScanner().nextLine();
            data = FormataData.formatarData(dataString);
        }catch (DateTimeParseException exception) {
            System.err.println("Formato de data invalido");
        }
        try {
           ator = new Ator(nome, data);
        }catch (Exception exception){
            System.err.println("Excecao nao tratada");
            execute();
        }
        try {
            service.criar(ator);
            System.out.println("ATOR CADASTRADO COM SUCESSO!!!");
        }catch (ModeloInvalidoException exception){
            System.out.println(exception.getMessage());
            execute();
        }
        catch (ServiceException exception){
            System.err.println("Ocorreu um erro tente novamente mais tarde");
            execute();
        }

    }
}

