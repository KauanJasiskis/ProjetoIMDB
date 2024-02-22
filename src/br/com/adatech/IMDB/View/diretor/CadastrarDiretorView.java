package br.com.adatech.IMDB.View.diretor;

import br.com.adatech.IMDB.Modelo.Ator;
import br.com.adatech.IMDB.Modelo.Diretor;
import br.com.adatech.IMDB.View.FormataData;
import br.com.adatech.IMDB.View.ScannerSingleton;
import br.com.adatech.IMDB.service.exception.ModeloInvalidoException;
import br.com.adatech.IMDB.service.exception.ServiceException;
import br.com.adatech.IMDB.service.services.AtorService;
import br.com.adatech.IMDB.service.services.DiretorService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CadastrarDiretorView {
    private DiretorService service;

    public CadastrarDiretorView(DiretorService service) {
        this.service = service;
    }

    public void execute() {
        System.out.println("Informe o nome do Diretor");
        String nome =  ScannerSingleton.instance().getScanner().nextLine();
        LocalDate data = null;
        Diretor diretor = null;
        try {
            System.out.println("Agora informe a data de nascimento do diretor no formato dd/MM/yyyy");
            String dataString =  ScannerSingleton.instance().getScanner().nextLine();
            data = FormataData.formatarData(dataString);
        }catch (DateTimeParseException exception) {
            System.err.println("Formato de data invalido");
        }
        try {
             diretor = new Diretor(nome, data);
        }catch (Exception exception){
            System.err.println("Excecao nao tratada");
            execute();
        }
        try {
            service.criar(diretor);
            System.out.println("DIRETOR CADASTRADO COM SUCESSO!!!");
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




