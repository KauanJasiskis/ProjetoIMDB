package br.com.adatech.IMDB.View.Artista;

import br.com.adatech.IMDB.Modelo.Ator;
import br.com.adatech.IMDB.Modelo.Diretor;
import br.com.adatech.IMDB.Modelo.Roteirista;
import br.com.adatech.IMDB.View.AbstractMenuView;
import br.com.adatech.IMDB.View.ator.CadastraAtorView;
import br.com.adatech.IMDB.View.diretor.CadastrarDiretorView;
import br.com.adatech.IMDB.View.roteirista.CadastrarRoteiristaView;
import br.com.adatech.IMDB.service.services.AtorService;
import br.com.adatech.IMDB.service.services.DiretorService;
import br.com.adatech.IMDB.service.services.RoteiristaService;

import java.util.Date;

public class CadastraArtistaView extends AbstractMenuView {

    private AtorService atorService;
    private DiretorService diretorService;

    private RoteiristaService roteiristaService;



    public CadastraArtistaView(AtorService atorService,DiretorService diretorService, RoteiristaService roteiristaService) {
        super(new String[]{
                "Qual tipo de Artista voce deseja cadastrar",
                "1 - Ator",
                "2 - Diretor",
                "3 - Roteirista",
        });
        this.atorService = atorService;
        this.diretorService = diretorService;
        this.roteiristaService = roteiristaService;
    };

    ;

    @Override
    protected Boolean validOption(Integer option) {
        return option >= 1 && option <=3;
    }

    @Override
    protected void executeOption(Integer option) {
        switch (option){
            case 1 -> new CadastraAtorView(this.atorService).execute();
                case 2 -> new CadastrarDiretorView(this.diretorService).execute();
                    case 3 -> new CadastrarRoteiristaView(this.roteiristaService).execute();
        }

    }
}
