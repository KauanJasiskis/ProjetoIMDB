package br.com.adatech.IMDB.View.filme;

import br.com.adatech.IMDB.Modelo.Filme;
import br.com.adatech.IMDB.View.FormataData;
import br.com.adatech.IMDB.View.ScannerSingleton;
import br.com.adatech.IMDB.service.exception.ModeloInvalidoException;
import br.com.adatech.IMDB.service.exception.ServiceException;
import br.com.adatech.IMDB.service.services.FilmeService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        System.out.println("Agora infomre a data de lancamento do filme no formato dd/MM/yyyy");
        String dataString = ScannerSingleton.instance().getScanner().nextLine();
        LocalDate data = FormataData.formatarData(dataString);
        Filme filme = new Filme(nome, data);
        try {
            service.criar(filme);
        } catch (ModeloInvalidoException exception) {
            System.out.println(exception.getMessage());
            execute();
        } catch (ServiceException exception) {
            System.err.println("Ocorreu um erro tente novamente mais tarde");
            execute();
        }
    }
}
