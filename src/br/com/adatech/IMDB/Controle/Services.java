package br.com.adatech.IMDB.Controle;

import br.com.adatech.IMDB.Modelo.Ator;
import br.com.adatech.IMDB.Modelo.Diretor;
import br.com.adatech.IMDB.Modelo.Filme;
import br.com.adatech.IMDB.Modelo.Roteirista;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Services {
    public static Filme cadastraFilme(String nome, LocalDate dataLancamento) {
        Filme filme = new Filme();
        filme.setNome(nome);
        filme.setDataDeLancamento(dataLancamento);
        return filme;

    }

    public static Ator cadastraAtor(String nome, LocalDate dataNascimento) {
        Ator ator = new Ator();
        ator.setNome(nome);
        ator.setDataDeNasicmento(dataNascimento);
        return ator;
    }

    public static Roteirista cadastraRoteirista(String nome, LocalDate dataNascimento) {
        Roteirista roteirista = new Roteirista();
        roteirista.setNome(nome);
        roteirista.setDataDeNasicmento(dataNascimento);
        return roteirista;
    }

    public static Diretor cadastraDiretor(String nome, LocalDate dataNascimento) {
        Diretor diretor = new Diretor();
        diretor.setNome(nome);
        diretor.setDataDeNasicmento(dataNascimento);
        return diretor;
    }

    public static void avaliarFilme(Filme filme, Double nota) {
        filme.setNota(nota);

    }

    public static Double cauculaNotaGeralFilme(Filme filme) {
        return filme.getNotaGeral() / filme.getVezesAvaliado();

    }

    public static void listaFilme(List<Filme> filmes) {
        for (Filme filme : filmes) {
            System.out.println(filme);
        }
    }

    public static void listaAtores(List<Ator> atores) {
        for (Ator ator : atores) {
            System.out.println(ator);
        }
    }
    public static void listaDiretores(List<Diretor> diretores){
        for(Diretor diretor : diretores){
            System.out.println(diretor);
        }
    }
    public static void listaRoteiristas(List<Roteirista> roteiristas){
        for(Roteirista roteirista : roteiristas){
            System.out.println(roteirista);
        }
    }

    public static void associarAtores(List<Filme> filmes, List<Ator> atores, String nomeFilme, String nomeArtista) {
        for (Filme filme : filmes) {
            if (nomeFilme.equalsIgnoreCase(filme.getNome())) {
                for (Ator ator : atores) {
                    if (nomeArtista.equalsIgnoreCase(ator.getNome())) {
                        filme.adicionarAtores(ator);
                        ator.adicionarFilmesTrabalhados(filme);
                    }


                }
            }
        }
    }



    public static void associarRoteirista(List<Filme> filmes, List<Roteirista> roteiristas, String nomeFilme, String nomeArtista) {
        for (Filme filme : filmes) {
            if (nomeFilme.equalsIgnoreCase(filme.getNome())) {
                for (Roteirista roteirista : roteiristas) {
                    if (nomeArtista.equalsIgnoreCase(roteirista.getNome())) {
                        filme.adicionarRoteirista(roteirista);
                        roteirista.adicionarFilmesTrabalhados(filme);
                    }


                }
            }
        }
    }

    public static void associarDiretores(List<Filme> filmes, List<Diretor> diretores, String nomeFilme, String nomeArtista) {
        for (Filme filme : filmes) {
            if (nomeFilme.equalsIgnoreCase(filme.getNome())) {
                for (Diretor diretor : diretores) {
                    if (nomeArtista.equalsIgnoreCase(diretor.getNome())) {
                        filme.adicionarDiretores(diretor);
                        diretor.adicionarFilmesTrabalhados(filme);
                    }


                }
            }
        }
    }

    public static List<Filme> pesquisarFilme(List<Filme> filmes, String nomeFilme) {
        List<Filme> filmesEncontrados = new ArrayList<>();
        boolean encontrouFilmeIgual = false;
        for (Filme filme : filmes) {
            if (nomeFilme.equalsIgnoreCase(filme.getNome())) {
                filmesEncontrados.add(filme);
                encontrouFilmeIgual = true;
            }
        }
            if(!encontrouFilmeIgual){
                for(Filme filme : filmes){
                    if(filme.getNome().toLowerCase().startsWith(nomeFilme.toLowerCase().substring(0,2))){
                        filmesEncontrados.add(filme);

                }


            }
        }
        return filmesEncontrados;



        }
        public static boolean eAtor(String nome,List<Ator> atores) {
            for (Ator ator : atores) {
                if (nome.equalsIgnoreCase(ator.getNome())) {
                    return true;
                }
            }
            return false;
        }
    public static boolean eDiretor(String nome,List<Diretor> diretores) {
        for (Diretor diretor : diretores) {
            if (nome.equalsIgnoreCase(diretor.getNome())) {
                return true;
            }
        }
        return false;
    }
    public static boolean eRoteirista(String nome,List<Roteirista> roteiristas) {
        for (Roteirista roteirista : roteiristas) {
            if (nome.equalsIgnoreCase(roteirista.getNome())) {
                return true;
            }
        }
        return false;
    }




    public static void limpaConsole(){
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("bash", "-c", "clear").inheritIO().start().waitFor();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
