package br.com.adatech.IMDB.Modelo;

import br.com.adatech.IMDB.Modelo.Artista;

import java.time.LocalDate;

public class Diretor extends Artista {
    public Diretor(){}
        public Diretor(
                String nome,
                LocalDate dataNascimento
        ){
            super(nome,dataNascimento);
        }



    }


