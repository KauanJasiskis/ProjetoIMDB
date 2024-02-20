package br.com.adatech.IMDB.Controle;

import br.com.adatech.IMDB.Modelo.Ator;
import br.com.adatech.IMDB.Modelo.Diretor;
import br.com.adatech.IMDB.Modelo.Filme;
import br.com.adatech.IMDB.Modelo.Roteirista;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControladorMenu {
    private static List<Filme> filmes = new ArrayList<>();
    private static List<Ator> atores = new ArrayList<>();
    private static List<Diretor> diretores = new ArrayList<>();

    private static List<Roteirista> roteiristas = new ArrayList<>();
    public void logicaMenu(Integer opcao,Scanner sc) {
        sc.nextLine();
        switch (opcao) {
            case 1 -> menuCadastrarFilme(sc);
            case 2 -> menuCadastrarArtista(sc);
            case 3 -> menuAvaliarFilme(sc);
            case 4 -> menuAssociarArtista(sc);
            case 5 -> menuPesquisarFilme(sc);
            case 6 -> menuListarFilme(sc);
            case 7 -> menuListarArtista(sc);
            case 8 -> System.exit(0);
            default -> System.out.println("Entrada invalida");
        }
    }
        public void menuCadastrarFilme(Scanner sc) {
            DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            boolean verificador = true;
            while (verificador) {
                System.out.println("Digite o nome do filme: ");
                String nome = sc.nextLine();
                System.out.println("Agora digite a data de lancamento do filme no formato dd/MM/yyyy");
                String dataString = sc.nextLine();
                LocalDate dataLancamento = LocalDate.parse(dataString, formatar);
                filmes.add(Services.cadastraFilme(nome, dataLancamento));
                System.out.println("Deseja cadastrar outro filme? ");
                System.out.println("1 - SIM");
                System.out.println("2 - NAO");
                Integer decisao = sc.nextInt();
                sc.nextLine();
                verificador = decisao.equals(1);
            }
        }
        public void menuCadastrarArtista(Scanner sc){
            DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            boolean verificador = true;
            while(verificador){
                System.out.println("Qual tipo de Artista voce deseja cadastrar");
                System.out.println("1 - Ator");
                System.out.println("2 - Diretor");
                System.out.println("3 - Roteirista");
                Integer decisao = sc.nextInt();
                sc.nextLine();
                if (decisao.equals(1)) {
                    System.out.println("Digite o nome do Ator: ");
                    String nome = sc.nextLine();
                    System.out.println("Agora digite a data de nascimento do ator no formato dd/MM/yyyy");
                    String dataString = sc.nextLine();
                    LocalDate dataNascimento = LocalDate.parse(dataString, formatar);
                    atores.add(Services.cadastraAtor(nome, dataNascimento));
                }
                else if(decisao.equals(2)){
                    System.out.println("Digite o nome do Diretor: ");
                    String nome = sc.nextLine();
                    System.out.println("Agora digite a data de nascimento do diretor no formato dd/MM/yyyy");
                    String dataString = sc.nextLine();
                    LocalDate dataNascimento = LocalDate.parse(dataString, formatar);
                    diretores.add(Services.cadastraDiretor(nome, dataNascimento));
                }
                else if(decisao.equals(3)){
                    System.out.println("Digite o nome do Roteirista: ");
                    String nome = sc.nextLine();
                    System.out.println("Agora digite a data de nascimento do roteirista no formato dd/MM/yyyy");
                    String dataString = sc.nextLine();
                    LocalDate dataNascimento = LocalDate.parse(dataString, formatar);
                    roteiristas.add(Services.cadastraRoteirista(nome, dataNascimento));
                }
                System.out.println("Deseja cadastrar outro Artista?");
                System.out.println("1 - SIM");
                System.out.println("2 - NAO");
                decisao = sc.nextInt();
                verificador = decisao.equals(1);
            }


        }
        public void menuAvaliarFilme(Scanner sc) {
            System.out.println("Digite o filme que deseja avaliar");
            String nomeFilme = sc.nextLine();
            for (Filme filme : filmes) {
                if (nomeFilme.equalsIgnoreCase(filme.getNome())) {
                    System.out.println("Digite a nota que deseja atribuir ao filme");
                    Double notaAtribuida = sc.nextDouble();
                    Services.avaliarFilme(filme, notaAtribuida);
                }
            }
        }
        public void menuAssociarArtista(Scanner sc) {
            System.out.println("Digite o nome do filme que deseja que os artistas sejam associados");
            String nomeFilme = sc.nextLine();
            System.out.println("Agora digite o nome do artista que deseja que seja associado");
            String nomeArtista = sc.nextLine();
            System.out.println("Esse artista e um: ");
            System.out.println("1 - Ator");
            System.out.println("2 - Diretor");
            System.out.println("3 - Roteirista");
            Integer decisao = sc.nextInt();
            if (decisao.equals(1)) {
                if (Services.eAtor(nomeArtista, atores)) {
                    Services.associarAtores(filmes, atores, nomeFilme, nomeArtista);
                } else {
                    System.out.println("NAO E UM ATOR");
                }
            } else if (decisao.equals(2)) {
                if (Services.eDiretor(nomeArtista, diretores)) {
                    Services.associarDiretores(filmes, diretores, nomeFilme, nomeArtista);
                } else {
                    System.out.println("NAO E UM DIRETOR!!!");
                }
            } else if (decisao.equals(3)) {
                if (Services.eRoteirista(nomeArtista, roteiristas)) {
                    Services.associarRoteirista(filmes, roteiristas, nomeFilme, nomeArtista);
                } else {
                    System.out.println("NAO E UM ROTEIRISTA");
                }
            } else {
                System.out.println("Escolha inválida");
            }
        }
        private void menuPesquisarFilme(Scanner sc){
            System.out.println("Digite o nome do filme que deseja procurar: ");
            String nomeFilme = sc.nextLine();
            System.out.println(Services.pesquisarFilme(filmes, nomeFilme));

        }
        private void menuListarFilme(Scanner sc) {
            if (filmes.isEmpty()) {
                System.out.println("NENHUM FILME CADASTRADO AINDA!!!");
            } else {

                Services.listaFilme(filmes);
            }
        }
        private void menuListarArtista(Scanner sc){
            System.out.println("Deseja ver a lista de qual tipo de artista");
            System.out.println("1 - Ator");
            System.out.println("2 - Diretor");
            System.out.println("3 - Roteirista");
            Integer decisao = sc.nextInt();
            if (decisao.equals(1)) {
                if (atores.isEmpty()) {
                    System.out.println("NENHUM ATOR CADASTRADO AINDA!!!");
                }
                Services.listaAtores(atores);
            } else if (decisao.equals(2)) {
                if (diretores.isEmpty()) {
                    System.out.println("NENHUM DIRETOR CADASTRADO AINDA!!!");
                }
                Services.listaDiretores(diretores);
            } else if (decisao.equals(3)) {
                if (roteiristas.isEmpty()) {
                    System.out.println("NENHUM ROTEIRISTA CADASTRADO AINDA!!!");
                }
                Services.listaRoteiristas(roteiristas);
            }


        }

    }

