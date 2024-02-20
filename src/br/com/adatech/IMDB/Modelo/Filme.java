package br.com.adatech.IMDB.Modelo;

import br.com.adatech.IMDB.Controle.Services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Filme {
    private String nome;
    private LocalDate dataDeLancamento;
    private List<Diretor> diretores = new ArrayList<>();
    private List<Ator> atores = new ArrayList<>();
    private List<Roteirista> roteiristas = new ArrayList<>();
    private Double notaGeral = 0.0;
    private Integer vezesAvaliado = 0;

    private Double notaFinal = 0.0;
    public Filme(){}

    public Filme(
            String nome,
            LocalDate dataDeLancamento,
            List<Diretor> diretores,
            List<Ator> atores,
            List<Roteirista> roteiristas
    ) {
        this.nome = nome;
        this.dataDeLancamento = dataDeLancamento;
        this.diretores = diretores;
        this.atores = atores;
        this.roteiristas = roteiristas;
    }

    public Filme(
            String nome,
            LocalDate dataDeLancamento) {
        this(nome, dataDeLancamento, null, null, null);
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataDeLancamento() {
        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataDeLancamento.format(formatar);
    }

    public void setDataDeLancamento(LocalDate dataDeLancamento) {
        this.dataDeLancamento = dataDeLancamento;
    }

    public List<Diretor> getDiretores() {
        return Collections.unmodifiableList(diretores);
    }

    public void adicionarDiretores(Diretor diretor){
        diretores.add(diretor);
    }

    public List<Ator> getAtores() {
        return Collections.unmodifiableList(atores);
    }

    public void adicionarAtores(Ator ator){
        atores.add(ator);
    }

    public List<Roteirista> getRoteiristas() {

        return Collections.unmodifiableList(roteiristas);
    }

    public void adicionarRoteirista(Roteirista roteirista){
        roteiristas.add(roteirista);
    }
    public void setNota(Double notaAvaliacao){
        this.notaGeral += notaAvaliacao;
        vezesAvaliado += 1;
    }

    public Double getNotaGeral() {
        return notaGeral;
    }

    public Integer getVezesAvaliado() {
        return vezesAvaliado;
    }
    public Double getNotaFinal(Filme filme) {
        if(notaGeral.equals(0.0)){
            return 0.0;
        }
        return Services.cauculaNotaGeralFilme(filme);
    }

    @Override
    public String toString() {
        StringBuilder sbAtores = new StringBuilder();
        if(!atores.isEmpty()) {
            for (Ator ator : atores) {
                sbAtores.append(ator.getNome()).append(",");
            }
            sbAtores.delete(sbAtores.length() - 1, sbAtores.length());
        }
        else {
            sbAtores.append("Ainda nao existem atores associados a esse filme");
    }
        StringBuilder sbDiretores = new StringBuilder();
        if(!diretores.isEmpty()) {
            for (Diretor diretor : diretores) {
                sbDiretores.append(diretor.getNome()).append(",");
            }
            sbDiretores.delete(sbDiretores.length() - 1, sbDiretores.length());
        }
        else {
            sbDiretores.append("Ainda nao existem diretores associados a esse filme");
        }
        StringBuilder sbRoteiristas = new StringBuilder();
        if(!roteiristas.isEmpty()) {
            for (Roteirista roteirista : roteiristas) {
                sbRoteiristas.append(roteirista.getNome()).append(",");
            }
            sbRoteiristas.delete(sbRoteiristas.length() - 1, sbRoteiristas.length());
        }
        else {
            sbRoteiristas.append("Ainda nao existem roteiristas associados a esse filme");
        }

        return "\nNome do filme = '" + nome + '\'' +
                " \nDataDeLancamento = " + getDataDeLancamento() +
                " \nDiretor = " + sbDiretores +
                " \nAtores = " + sbAtores +
                " \nRoteirista = " + sbRoteiristas +
                " \nFilme = " + getNotaFinal(this) + " Vezes avaliado: " + vezesAvaliado;

    }

    }



