package br.com.adatech.IMDB.View.filme;

import br.com.adatech.IMDB.Modelo.Filme;
import br.com.adatech.IMDB.service.services.FilmeService;

import java.util.Scanner;

public class AvaliaFilmeView {
    private FilmeService service;

    public AvaliaFilmeView(FilmeService service){
        this.service = service;
    }

    public void execute(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do filme que deseja avaliar");
        String filmeInformado = scanner.nextLine();
        if(service.filmeUnico(filmeInformado)!= null) {
            System.out.println("Digite a nota de avaliacao de 0 a 10");
            Double nota = scanner.nextDouble();
            Filme filmeAvaliado = service.filmeUnico(filmeInformado);
            filmeAvaliado.setNotaGeral(nota);
            service.atualizar(filmeAvaliado);
        }

    }
}