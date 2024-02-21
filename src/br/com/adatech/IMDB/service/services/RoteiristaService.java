package br.com.adatech.IMDB.service.services;

import br.com.adatech.IMDB.Modelo.Ator;
import br.com.adatech.IMDB.Modelo.Roteirista;
import br.com.adatech.IMDB.infra.repositorio.RoteiristaRepositorio;
import br.com.adatech.IMDB.service.exception.ModeloInvalidoException;

import java.util.List;

public class RoteiristaService {
    private RoteiristaRepositorio repositorio;

    public RoteiristaService(RoteiristaRepositorio repositorio){
        this.repositorio = repositorio;
    }

    public void criar(Roteirista roteirista){
        if(roteirista == null){
            throw new RuntimeException("Roteirista nao pode ser nulo");
        }
        if(roteirista.getNome()==null){
            throw new RuntimeException("Roteirista nao pode ser nulo");
        }
        if(roteirista.getDataDeNasicmento() == null){
            throw new RuntimeException("Data de nascimento nao pode ser nulo");
        }
        repositorio.gravar(roteirista);

    }
    public void atualizar(Roteirista roteirista) {
        if(roteirista == null){
            throw new RuntimeException("Roteirista nao pode ser nulo");
        }
        if(roteirista.getNome()==null){
            throw new RuntimeException("Roteirista nao pode ser nulo");
        }
        if(roteirista.getDataDeNasicmento() == null){
            throw new RuntimeException("Data de nascimento nao pode ser nulo");
        }
        Roteirista jaExistente = (Roteirista) repositorio.consultarPorNomerRoteirista(roteirista.getNome());
        if (jaExistente == null) {
            throw new ModeloInvalidoException("Roteirista não encontrado");
        }
        repositorio.gravar(jaExistente);
    }
    public List listar(){
        return repositorio.listar();
    }
    public Roteirista buscaRoteiristaUnico(String nome){
        return repositorio.consultarPorNomerRoteirista(nome);
    }
}
