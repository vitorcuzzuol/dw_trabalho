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
    private String cpf;
    @Nullable
    private String nome;
    @Nullable
    private String endereco;
    @Nullable
    private String telefone;

    @Nullable
    private String nacionalidade;

    @Nullable
    @Temporal(TemporalType.DATE)
    private Date dataNasc;

    @Nullable
    private String deficiente;

    //Aqui vamos guardar todos os ingressos para voos dentro da lista passagensCompradas
    @Nullable
    @OneToOne
    private Passagem passagemComprada;

    @Nullable
    private String idReserva;

    @Nullable
    @ManyToMany
    private List<Voo> voos = new ArrayList<>();

    @Nullable
    @OneToMany
    private List<Poltrona> poltronasReservadas = new ArrayList<>();

    @Nullable
    @OneToOne
    private Poltrona poltronaIda;

    @Nullable
    @OneToOne
    private Poltrona poltronaVolta;

    public List<Voo> setVoos(Voo voo){
        this.voos.add(voo);
        return voos;
    }

    public List<Voo> getVoos() {
        return voos;
    }

    public void setVoos(List<Voo> voos) {
        this.voos = voos;
    }

    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public String getDeficiente() {
        return deficiente;
    }

    public void setDeficiente(String deficiente) {
        this.deficiente = deficiente;
    }

    public List<Poltrona> getPoltronasReservadas() {
        return poltronasReservadas;
    }

    public void setPoltronasReservadas(List<Poltrona> poltronasReservadas) {
        this.poltronasReservadas = poltronasReservadas;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Poltrona getPoltronaIda() {
        return poltronaIda;
    }

    public void setPoltronaIda(Poltrona poltronaIda) {
        this.poltronaIda = poltronaIda;
    }

    public Poltrona getPoltronaVolta() {
        return poltronaVolta;
    }

    public void setPoltronaVolta(Poltrona poltronaVolta) {
        this.poltronaVolta = poltronaVolta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
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
