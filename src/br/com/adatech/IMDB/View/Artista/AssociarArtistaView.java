package br.com.adatech.IMDB.View.Artista;

import br.com.adatech.IMDB.View.AbstractMenuView;
import br.com.adatech.IMDB.View.ator.AssociaAtorView;
import br.com.adatech.IMDB.View.diretor.AssociaDiretorView;
import br.com.adatech.IMDB.View.roteirista.AssociaRoteiristaView;
import br.com.adatech.IMDB.infra.repositorio.AbstractRepositorio;
import br.com.adatech.IMDB.infra.repositorio.RoteiristaRepositorio;
import br.com.adatech.IMDB.service.services.AtorService;
import br.com.adatech.IMDB.service.services.DiretorService;
import br.com.adatech.IMDB.service.services.FilmeService;
import br.com.adatech.IMDB.service.services.RoteiristaService;

public class AssociarArtistaView extends AbstractMenuView {
    private FilmeService filmeService;
    private AtorService atorService;
    private DiretorService diretorService;
    private RoteiristaService roteiristaService;


    public AssociarArtistaView(FilmeService filmeService,AtorService atorService,DiretorService diretorService, RoteiristaService roteiristaService) {
        super(new String[]{
                "Informe o tipo de artista que deseja Associar",
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
        return option >= 1 && option <= 3;
    }

    @Override
    protected void executeOption(Integer option) {
        switch (option) {
            case 1 -> new AssociaAtorView(this.atorService,this.filmeService).execute();
            case 2 -> new AssociaDiretorView(this.diretorService,this.filmeService).execute();
            case 3 -> new AssociaRoteiristaView(this.roteiristaService,this.filmeService).execute();
        }

    }
}
