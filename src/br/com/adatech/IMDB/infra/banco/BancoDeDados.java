package br.com.adatech.IMDB.infra.banco;

import br.com.adatech.IMDB.infra.banco.exception.DatabaseException;

import java.util.*;

public class BancoDeDados {

    private static final Map OBJETOS = new HashMap();


    public void inserirObjeto(Object objeto) throws DatabaseException {
        Set objetos = colecaoDeObjetos(objeto.getClass());
        objetos.add(objeto);
        }
    public List buscarObjetosPorTipo(Class clazz){
        Set objetos = colecaoDeObjetos(clazz);
        return new ArrayList(objetos);
    }
    private Set colecaoDeObjetos(Class clazz){
        Set objetos = (Set) BancoDeDados.OBJETOS.get(clazz);
        if(objetos == null){
            objetos = new HashSet();
            BancoDeDados.OBJETOS.put(clazz,objetos);
        }
        return objetos;
    }
}
