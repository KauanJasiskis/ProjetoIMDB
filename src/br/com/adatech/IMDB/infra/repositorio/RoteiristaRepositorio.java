package br.com.adatech.IMDB.infra.repositorio;

import br.com.adatech.IMDB.Modelo.Diretor;
import br.com.adatech.IMDB.Modelo.Roteirista;
import br.com.adatech.IMDB.infra.banco.BancoDeDados;

import java.util.List;

public class RoteiristaRepositorio extends AbstractRepositorio{
    public RoteiristaRepositorio(BancoDeDados bancoDeDados) {
        super(bancoDeDados);
    }
    public Roteirista consultarPorNomerRoteirista(String nomeRoteirista){
        List roteiristas = listar();
        Roteirista roteiristaEncontrado =  null;
        for (Object objeto : roteiristas) {
            Roteirista roteirista = (Roteirista) objeto;
            if (compararPorNomeRoteirista(roteirista,nomeRoteirista)) {
                roteiristaEncontrado = roteirista;
                break;
            }
        }
        return roteiristaEncontrado;
    }

    protected Boolean compararPorNomeRoteirista(Roteirista roteirista, String nome){
        return roteirista != null
                && roteirista.getNome()!= null
                && nome != null
                && roteirista.getNome().contains(nome);
    }

    @Override
    protected Class classeModelo() {
        return Roteirista.class;
    }
}
