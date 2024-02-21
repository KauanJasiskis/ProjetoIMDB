package br.com.adatech.IMDB.View.diretor;

import br.com.adatech.IMDB.Modelo.Ator;
import br.com.adatech.IMDB.Modelo.Diretor;
import br.com.adatech.IMDB.View.FormataData;
import br.com.adatech.IMDB.service.exception.ModeloInvalidoException;
import br.com.adatech.IMDB.service.services.AtorService;
import br.com.adatech.IMDB.service.services.DiretorService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CadastrarDiretorView {
    private DiretorService service;

    public CadastrarDiretorView(DiretorService service){
        this.service = service;
    }

    public void execute(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o nome do diretor");
        String nome = scanner.nextLine();
        System.out.println("Agora informe a data de nascimento do diretor no formato dd/MM/yyyy");
        String dataString = scanner.nextLine();
        LocalDate data = FormataData.formatarData(dataString);
        Diretor diretor = new Diretor(nome,data);
        try {
            service.criar(diretor);
        }catch (ModeloInvalidoException exception){
            System.out.println(exception.getMessage());
            execute();
        }
    }
}

