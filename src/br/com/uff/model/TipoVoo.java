package br.com.uff.model;

/**
 * Created by pedro on 11/12/16.
 */
public enum TipoVoo {

    IDA("IDA"), VOLTA("VOLTA");

    private String descricao;

    TipoVoo(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}



