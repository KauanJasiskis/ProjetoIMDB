package br.com.adatech.IMDB.Modelo;

import br.com.adatech.IMDB.Modelo.Artista;

import java.time.LocalDate;

public class Ator extends Artista {
   public Ator(){}
    public Ator(
            String nome,
            LocalDate dataNascimento
    ){
        super(nome,dataNascimento);
   }

    @Override
    public String toString() {
        return  "\nNome: " + getNome() +
                "\nData de nascimento: " + getDataDeNasicmento() +
                "\nFilmes Trabalhados: " + getFilmesTrabalhados();


    }
}
