package br.com.adatech.IMDB.View;

import br.com.adatech.IMDB.Controle.ControladorMenu;
import br.com.adatech.IMDB.Controle.Services;
import br.com.adatech.IMDB.Modelo.Ator;
import br.com.adatech.IMDB.Modelo.Diretor;
import br.com.adatech.IMDB.Modelo.Filme;
import br.com.adatech.IMDB.Modelo.Roteirista;

import javax.naming.ldap.Control;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Menu {
    private static List<Filme> filmes = new ArrayList<>();
    private static List<Ator> atores = new ArrayList<>();
    private static List<Diretor> diretores = new ArrayList<>();

    private static List<Roteirista> roteiristas = new ArrayList<>();


    public void apresentaMenu() {
        ControladorMenu cntrlMenu = new ControladorMenu();
        Scanner sc = new Scanner(System.in);
        Integer opcao;
        do {
            System.out.println("BEM VINDO AO IMDB!");
            System.out.println("Selecione uma Opcao: ");
            System.out.println("1 - Cadastrar Filme ");
            System.out.println("2 - Cadastrar Artista");
            System.out.println("3 - Avaliar Filme");
            System.out.println("4 - Associar Artista");
            System.out.println("5 - Pesquisar Filme");
            System.out.println("6 - Listar Filmes");
            System.out.println("7 - Listar Artista");
            System.out.println("8 - Sair");
            opcao = sc.nextInt();
            cntrlMenu.logicaMenu(opcao,sc);
        } while (!opcao.equals(8));
        sc.close();
    }
}




















