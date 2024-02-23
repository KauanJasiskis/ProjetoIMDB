package br.com.adatech.IMDB.View;

import br.com.adatech.IMDB.View.Artista.AssociarArtistaView;
import br.com.adatech.IMDB.View.Artista.CadastraArtistaView;
import br.com.adatech.IMDB.View.Artista.ListarArtistaView;
import br.com.adatech.IMDB.View.filme.AvaliaFilmeView;
import br.com.adatech.IMDB.View.filme.CadastraFilmeView;
import br.com.adatech.IMDB.View.filme.ListarFilmeView;
import br.com.adatech.IMDB.View.filme.PesquisarFilmeView;
import br.com.adatech.IMDB.service.services.AtorService;
import br.com.adatech.IMDB.service.services.DiretorService;
import br.com.adatech.IMDB.service.services.FilmeService;
import br.com.adatech.IMDB.service.services.RoteiristaService;


public class Menu extends AbstractMenuView {
    private FilmeService filmeService;
    private AtorService atorService;
    private DiretorService diretorService;
    private RoteiristaService roteiristaService;


    public Menu(FilmeService filmeService,AtorService atorService,DiretorService diretorService,RoteiristaService roteiristaService) {
        super(new String[]{
                "BEM VINDO AO IMDB!",



                "1 - Cadastrar Filme",
                "2 - Cadastrar Artista",
                "3 - Avaliar Filme",
                "4 - Associar Artista",
                "5 - Pesquisar Filme",
                "6 - Listar Filmes",
                "7 - Listar Artista",
                "0 - Sair",
                "Selecione uma Opcao: ",

        });
        this.filmeService = filmeService;
        this.atorService = atorService;
        this.diretorService = diretorService;
        this.roteiristaService = roteiristaService;
    }
    @Override
    protected Boolean validOption(Integer option) {
        return option >= 0 && option <= 7;
    }

    @Override
    protected void executeOption(Integer option) {
        switch (option){
            case 1 -> new CadastraFilmeView(filmeService).execute();
            case 2 -> new CadastraArtistaView(atorService,diretorService,roteiristaService).execute();
            case 3 -> new AvaliaFilmeView(filmeService).execute();
            case 4 -> new AssociarArtistaView(filmeService,atorService,diretorService,roteiristaService).execute();
            case 5 -> new PesquisarFilmeView(filmeService).execute();
            case 6 -> new ListarFilmeView(filmeService).execute();
            case 7 -> new ListarArtistaView(filmeService,atorService,diretorService,roteiristaService).execute();
            case 0 -> System.exit(1);
            default -> System.out.println("Opcao indisponivel");
        }
        execute();

    }
}




















