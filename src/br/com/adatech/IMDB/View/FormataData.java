package br.com.adatech.IMDB.View;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormataData {

    public static LocalDate formatarData(String string){
        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataLancamento  = LocalDate.parse(string,formatar);
        return dataLancamento;
    }
}
