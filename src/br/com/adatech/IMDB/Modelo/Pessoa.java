package br.com.adatech.IMDB.Modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Pessoa {

    private String nome;
    private LocalDate dataDeNasicmento;

    public Pessoa() {
    }

    public Pessoa(
            String nome,
            LocalDate dataDeNasicmento
    ) {
        this.nome = nome;
        this.dataDeNasicmento = dataDeNasicmento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataDeNasicmento() {
        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataDeNasicmento.format(formatar);
    }

    public void setDataDeNasicmento(LocalDate dataDeNasicmento) {
        this.dataDeNasicmento = dataDeNasicmento;
    }

    @Override
    public String toString() {
        return "br.com.adatech.IMDB.Modelo.Pessoa{" +
                "nome='" + nome + '\'' +
                ", dataDeNasicmento=" + dataDeNasicmento +
                '}';
    }
}
