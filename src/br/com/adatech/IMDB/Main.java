package br.com.adatech.IMDB;

import br.com.adatech.IMDB.View.Menu;
import br.com.adatech.IMDB.infra.banco.BancoDeDados;
import br.com.adatech.IMDB.infra.repositorio.AtorRepositorio;
import br.com.adatech.IMDB.infra.repositorio.DiretorRepositorio;
import br.com.adatech.IMDB.infra.repositorio.FilmeRepositorio;
import br.com.adatech.IMDB.infra.repositorio.RoteiristaRepositorio;
import br.com.adatech.IMDB.service.services.AtorService;
import br.com.adatech.IMDB.service.services.DiretorService;
import br.com.adatech.IMDB.service.services.FilmeService;
import br.com.adatech.IMDB.service.services.RoteiristaService;



public class Main {
    public static void main(String[] args) {
        BancoDeDados bancoDeDados = new BancoDeDados();
        FilmeRepositorio filmeRepositorio = new FilmeRepositorio(bancoDeDados);
        AtorRepositorio atorRepositorio = new AtorRepositorio(bancoDeDados);
        DiretorRepositorio diretorRepositorio = new DiretorRepositorio(bancoDeDados);
        RoteiristaRepositorio roteiristaRepositorio = new RoteiristaRepositorio(bancoDeDados);

        FilmeService filmeService = new FilmeService(filmeRepositorio);
        AtorService atorService = new AtorService(atorRepositorio);
        DiretorService diretorService = new DiretorService(diretorRepositorio);
        RoteiristaService roteiristaService = new RoteiristaService(roteiristaRepositorio);

        Menu menuPrincipal = new Menu(filmeService,atorService,diretorService,roteiristaService);
        menuPrincipal.execute();





    }

}