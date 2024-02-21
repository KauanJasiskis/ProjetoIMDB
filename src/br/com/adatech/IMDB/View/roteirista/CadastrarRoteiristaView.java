package br.com.adatech.IMDB.View.roteirista;

import br.com.adatech.IMDB.Modelo.Ator;
import br.com.adatech.IMDB.Modelo.Diretor;
import br.com.adatech.IMDB.Modelo.Roteirista;
import br.com.adatech.IMDB.View.FormataData;
import br.com.adatech.IMDB.service.exception.ModeloInvalidoException;
import br.com.adatech.IMDB.service.services.DiretorService;
import br.com.adatech.IMDB.service.services.RoteiristaService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CadastrarRoteiristaView
{
    private RoteiristaService service;

    public CadastrarRoteiristaView(RoteiristaService service){
        this.service = service;
    }

    public void execute(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o nome do Roteirista");
        String nome = scanner.nextLine();
        System.out.println("Agora informe a data de nascimento do Roteirista no formato dd/MM/yyyy");
        String dataString = scanner.nextLine();
        LocalDate data = FormataData.formatarData(dataString);
        Roteirista roteirista = new Roteirista(nome,data);
        try {
            service.criar(roteirista);
        }catch (ModeloInvalidoException exception){
            System.out.println(exception.getMessage());
            execute();
        }
    }
}
