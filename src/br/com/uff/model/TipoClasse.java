package br.com.uff.model;

/**
 * Created by pedro on 23/11/16.
 */
public enum TipoClasse {

    ECONOMICA("Econômica"),
    EXECUTIVA("Executiva"),
    PRIMEIRA_CLASSE("Primeira Classe");

    private String descricao;

    TipoClasse(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
