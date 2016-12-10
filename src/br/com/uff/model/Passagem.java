package br.com.uff.model;

import com.sun.istack.internal.Nullable;

import javax.persistence.*;

@Entity
public class Passagem {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    //Várias passagens existem em um Voo. Mas nesse caso, permitimos apenas que o bitlhete possua um Voo de Ida.
    @Nullable
    @ManyToOne
    private Voo vooIda;

    @Nullable
    @ManyToOne
    private Voo vooVolta;

    @Nullable
    @OneToOne
    private Poltrona poltronaIda;

    @Nullable
    @OneToOne
    private Poltrona poltronaVolta;

    @Nullable
    @OneToOne
    private Passageiro passageiro;

    @ManyToOne
    private Venda numeroVenda;

    public Venda getNumeroVenda() {
        return numeroVenda;
    }

    public void setNumeroVenda(Venda numeroVenda) {
        this.numeroVenda = numeroVenda;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Voo getVooIda() {
        return vooIda;
    }

    public void setVooIda(Voo vooIda) {
        this.vooIda = vooIda;
    }

    public Voo getVooVolta() {
        return vooVolta;
    }

    public void setVooVolta(Voo vooVolta) {
        this.vooVolta = vooVolta;
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

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }
}
