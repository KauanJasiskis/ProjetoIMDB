package br.com.adatech.IMDB.View;

import java.util.Scanner;

public abstract class AbstractMenuView {
    private String[] options;

    public AbstractMenuView(String[] options) {
        this.options = options;
    }

    public void execute(){
        for (String option : options) {
            System.out.println(option);
        }

        Integer option =  ScannerSingleton.instance().getScanner().nextInt();
        ScannerSingleton.instance().getScanner().nextLine();
        if (validOption(option)) {
            executeOption(option);
        } else {
            System.out.println("Opção invalida");
            execute();
        }
    }

    protected abstract Boolean validOption(Integer option);

    protected abstract void executeOption(Integer option);

}

