package br.com.adatech.IMDB.View.roteirista;

import br.com.adatech.IMDB.Modelo.Ator;
import br.com.adatech.IMDB.Modelo.Diretor;
import br.com.adatech.IMDB.Modelo.Roteirista;
import br.com.adatech.IMDB.View.FormataData;
import br.com.adatech.IMDB.View.ScannerSingleton;
import br.com.adatech.IMDB.service.exception.ModeloInvalidoException;
import br.com.adatech.IMDB.service.exception.ServiceException;
import br.com.adatech.IMDB.service.services.DiretorService;
import br.com.adatech.IMDB.service.services.RoteiristaService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CadastrarRoteiristaView {
    private RoteiristaService service;

    public CadastrarRoteiristaView(RoteiristaService service) {
        this.service = service;
    }

    public void execute() {
        System.out.println("Informe o nome do Roteirista: ");
        String nome = ScannerSingleton.instance().getScanner().nextLine();
        LocalDate data = null;
        Roteirista roteirista = null;
        try {
            System.out.println("Agora informe a data de nascimento do roteirista no formato dd/MM/yyyy: ");
            String dataString = ScannerSingleton.instance().getScanner().nextLine();
            data = FormataData.formatarData(dataString);
        } catch (DateTimeParseException exception) {
            System.err.println("Formato de data invalido");
        }
        try {
            roteirista = new Roteirista(nome, data);
        } catch (Exception exception) {
            System.err.println("Excecao nao tratada");
            execute();
        }
        try {
            service.criar(roteirista);
            System.out.println("ROTEIRISTA CADASTRADO COM SUCESSO!!!");
        } catch (ModeloInvalidoException exception) {
            System.out.println(exception.getMessage());
            execute();
        } catch (ServiceException exception) {
            System.err.println("Ocorreu um erro tente novamente mais tarde");
            execute();
        }

    }
}
