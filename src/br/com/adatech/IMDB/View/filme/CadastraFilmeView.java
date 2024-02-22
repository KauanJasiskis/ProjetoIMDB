package br.com.adatech.IMDB.View.filme;

import br.com.adatech.IMDB.Modelo.Ator;
import br.com.adatech.IMDB.Modelo.Filme;
import br.com.adatech.IMDB.View.FormataData;
import br.com.adatech.IMDB.View.ScannerSingleton;
import br.com.adatech.IMDB.service.exception.ModeloInvalidoException;
import br.com.adatech.IMDB.service.exception.ServiceException;
import br.com.adatech.IMDB.service.services.FilmeService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Formattable;
import java.util.Scanner;

public class CadastraFilmeView {
    private FilmeService service;

    public CadastraFilmeView(FilmeService service) {
        this.service = service;
    }

    public void execute() {
        System.out.println("Informe o nome do filme");
        String nome = ScannerSingleton.instance().getScanner().nextLine();
        Filme filme = null;
        LocalDate data = null;
        try {
            System.out.println("Agora informe a data de lancamento do filme no formato dd/MM/yyyy");
            String dataString = ScannerSingleton.instance().getScanner().nextLine();
            data = FormataData.formatarData(dataString);
        } catch (DateTimeParseException exception) {
            System.err.println("Formato de data invalido");
        }
        try {
            filme = new Filme(nome,data);
        } catch (Exception exception) {
            System.err.println("Excecao nao tratada");
            execute();
        }
        try {
            service.criar(filme);
            System.out.println("FILME CADASTRADO COM SUCESSO!!!");
        } catch (ModeloInvalidoException exception) {
            System.out.println(exception.getMessage());
            execute();
        } catch (ServiceException exception) {
            System.err.println("Ocorreu um erro tente novamente mais tarde");
            execute();
        }

    }
}
