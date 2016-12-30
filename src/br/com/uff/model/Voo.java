package br.com.uff.model;

import com.sun.istack.internal.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Voo {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Nullable
    @OneToOne
    private Aviao aviao;

    @Nullable
    @Enumerated(EnumType.STRING)
    private TipoVoo tipoVoo;

    @Nullable
    @Temporal(TemporalType.DATE)
    private Date data;

    @Nullable
    @OneToOne
    private Aeroporto aeroporto;

    @Nullable
    private String localOrigem;

    @Nullable
    private String localDestino;

    @Nullable
    private int duracao;
    private int numParadas;
    private Double preco;

    @Nullable
    @OneToMany
    private List<Passageiro> passageiros;

    @Nullable
    @OneToMany (mappedBy = "voo")
    private List<Poltrona> poltronas = new ArrayList<>();

    @Nullable
    @OneToMany (mappedBy = "vooIda")
    private List<Passagem> passagensIda = new ArrayList<>();

    @Nullable
    @OneToMany (mappedBy = "vooVolta")
    private List<Passagem> passagensVolta = new ArrayList<>();

    public List<Poltrona> getPoltronas() {
        return poltronas;
    }

    public void setPoltrona(Poltrona poltrona) {
        this.poltronas.add(poltrona);
    }

    public void setPoltrona(List<Poltrona> poltronas){
        this.poltronas = poltronas;
    }

    public List<Passageiro> getPassageiros() {
        return passageiros;
    }

    public void setPassageiros(List<Passageiro> passageiros) {
        this.passageiros = passageiros;
    }

    public void setPoltronas(List<Poltrona> poltronas) {
        this.poltronas = poltronas;
    }

    public TipoVoo getTipoVoo() {
        return tipoVoo;
    }

    public void setTipoVoo(TipoVoo tipoVoo) {
        this.tipoVoo = tipoVoo;
    }

    public Aviao getAviao() {
        return aviao;
    }

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }

    public String getLocalDestino() {
        return localDestino;
    }

    public void setLocalDestino(String localDestino) {
        this.localDestino = localDestino;
    }

    public String getLocalOrigem() {

        return localOrigem;
    }

    public void setLocalOrigem(String localOrigem) {
        this.localOrigem = localOrigem;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getNumParadas() {
        return numParadas;
    }

    public void setNumParadas(int numParadas) {
        this.numParadas = numParadas;
    }

    public Aeroporto getAeroporto() {
        return aeroporto;
    }

    public void setAeroporto(Aeroporto aeroporto) {
        this.aeroporto = aeroporto;
    }

    public List<Passagem> getPassagensIda() {
        return passagensIda;
    }

    public void setPassagensIda(List<Passagem> passagensIda) {
        this.passagensIda = passagensIda;
    }

    public List<Passagem> getPassagensVolta() {
        return passagensVolta;
    }

    public void setPassagensVolta(List<Passagem> passagensVolta) {
        this.passagensVolta = passagensVolta;
    }

    public void setPassagensIda(Passagem passagemComprada) {
        this.passagensIda.add(passagemComprada);
    }


    public void setPassagensVolta(Passagem passagemComprada) {
        this.passagensVolta.add(passagemComprada);
    }


}
