package br.com.adatech.IMDB.View.Artista;

import br.com.adatech.IMDB.View.AbstractMenuView;
import br.com.adatech.IMDB.View.ator.ListarAtorView;
import br.com.adatech.IMDB.View.diretor.ListarDiretorView;
import br.com.adatech.IMDB.View.roteirista.ListarRoteiristaView;
import br.com.adatech.IMDB.service.services.AtorService;
import br.com.adatech.IMDB.service.services.DiretorService;
import br.com.adatech.IMDB.service.services.FilmeService;
import br.com.adatech.IMDB.service.services.RoteiristaService;

public class ListarArtistaView extends AbstractMenuView {
    private FilmeService filmeService;
    private AtorService atorService;
    private DiretorService diretorService;
    private RoteiristaService roteiristaService;


    public ListarArtistaView(FilmeService filmeService,AtorService atorService,DiretorService diretorService, RoteiristaService roteiristaService) {
        super(new String[]{
                "Informe o tipo de artista que deseja listar",
                "1 - Ator",
                "2 - Diretor",
                "3 - Roteirista",

        });
        this.filmeService = filmeService;
        this.atorService = atorService;
        this.diretorService = diretorService;
        this.roteiristaService = roteiristaService;
    }

    @Override
    protected Boolean validOption(Integer option) {
        return option >= 1 && option <=3;
    }

    @Override
    protected void executeOption(Integer option) {
        switch (option){
            case 1 -> new ListarAtorView(this.atorService).execute();
            case 2 -> new ListarDiretorView(this.diretorService).execute();
            case 3 -> new ListarRoteiristaView(this.roteiristaService).execute();
            default-> System.out.println("Opcao indisponivel");
        }

    }
}
