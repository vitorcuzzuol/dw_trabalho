package br.com.uff.model;

import com.sun.istack.internal.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by pedro.lohmann on 08/12/2016.
 */
@Entity
public class Passageiro {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Nullable
    private Integer cpf;
    @Nullable
    private String nome;
    @Nullable
    private String endereco;
    @Nullable
    private Integer telefone;

    @Nullable
    @Temporal(TemporalType.DATE)
    private Date dataNasc;

    //Aqui vamos guardar todos os ingressos para voos dentro da lista passagensCompradas
    @Nullable
    @OneToOne
    private Passagem passagemComprada;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Passagem getPassagemComprada() {
        return passagemComprada;
    }

    public void setPassagemComprada(Passagem passagemComprada) {
        this.passagemComprada = passagemComprada;
    }
}
