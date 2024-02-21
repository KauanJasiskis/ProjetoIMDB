package br.com.adatech.IMDB.Modelo;

import br.com.adatech.IMDB.View.FormataData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Filme {
    private String nome;
    private LocalDate dataDeLancamento;
    private List<Roteirista> roteiristas = new ArrayList<>();
    private List<Ator> atores = new ArrayList<>();
    private List<Diretor> diretores = new ArrayList<>();


    private Double notaGeral = 0.0;
    private Integer vezesAvaliado = 0;

    private Double notaFinal = 0.0;

    public Filme() {
    }

    public Filme(
            String nome,
            LocalDate dataDeLancamento){
        this.nome = nome;
        this.dataDeLancamento = dataDeLancamento;
    }







    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataDeLancamento() {
       return dataDeLancamento;
    }

    public void setDataDeLancamento(LocalDate dataDeLancamento) {
        this.dataDeLancamento = dataDeLancamento;
    }


    public Double getNotaGeral() {
        return notaGeral;
    }

    public void setNotaGeral(Double notaGeral) {
        this.notaGeral += notaGeral;
        this.vezesAvaliado = vezesAvaliado + 1;
    }

    public void adicionarAtor(Ator ator) {
        atores.add(ator);
    }

    public void adicionarDiretor(Diretor diretor) {
        diretores.add(diretor);
    }

    public void adicionarRoteirista(Roteirista roteirista) {
        roteiristas.add(roteirista);
    }

    public List<String> getRoteiristas() {
        List<String> nomeDosRoteiristas = new ArrayList<>();
        for (Roteirista roteirista : roteiristas){
            nomeDosRoteiristas.add(roteirista.getNome());
        }
         return Collections.unmodifiableList(nomeDosRoteiristas);
    }

    public List<String> getAtores() {
        List<String> nomeDosAtores = new ArrayList<>();
        for (Ator ator : atores){
            nomeDosAtores.add(ator.getNome());
        }
        return Collections.unmodifiableList(nomeDosAtores);
    }
    public List<String> getDiretores() {
        List<String> nomeDosDiretores = new ArrayList<>();
        for(Diretor diretor : diretores){
            ;nomeDosDiretores.add(diretor.getNome());
        }
        return Collections.unmodifiableList(nomeDosDiretores);

    }

    public Integer getVezesAvaliado() {
        return vezesAvaliado;
    }

    public void setVezesAvaliado(Integer vezesAvaliado) {
        this.vezesAvaliado = vezesAvaliado;
    }

    public Double getNotaFinal() {
        if(notaGeral.equals(0.0)){
            return 0.0;
        }
        else {
            return notaGeral / vezesAvaliado;
        }
    }

    public void setNotaFinal(Double notaFinal) {
        this.notaFinal = notaFinal;
    }
    @Override
    public String toString() {
        String string = "Nome: " + getNome();
        if(getAtores()== null || getAtores().isEmpty()){
            string += "\nAtores: Ainda não existem Atores associados a este autor";
        } else {
            string += "\nAtores: " + getAtores();
        }
        if(getDiretores() == null || getDiretores().isEmpty()) {
            string += "\nDiretores: Ainda não existem Diretores associados a este autor";
        } else {
            string += "\nDiretores: " + getDiretores();
        }
        if(getAtores()== null || getDiretores().isEmpty()){
            string += "\nRoteiristas: Ainda não existem Atores associados a este autor";
        } else {
            string += "\nRoteiristas: " + getRoteiristas();
        }
        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        string += "\nData de lancamento: " + getDataDeLancamento().format(formatar);
        return string;
    }
}





