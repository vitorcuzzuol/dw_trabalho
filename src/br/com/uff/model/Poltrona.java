package br.com.uff.model;

import com.sun.istack.internal.Nullable;

import javax.persistence.*;

@Entity
public class Poltrona {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idPoltrona;

    /*  Como usamos o tipo ENUM, temos que usar a anotação Enumerated.
        Como queremos guardar esse valor como uma string no banco de dados, passamos o parâmetro EnumType.String. */
    @Nullable
    @Enumerated(EnumType.STRING)
    private StatusPoltrona statusPoltronaIda;

    @Nullable
    @Enumerated(EnumType.STRING)
    private StatusPoltrona statusPoltronaVolta;

    @ManyToOne
    private Aviao aviao;

    @ManyToOne
    private Voo voo;

    @OneToOne
    private Passagem passagemIda;

    @OneToOne
    private Passagem passagemVolta;

    @ManyToOne
    private Classe classe;


    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }


    public Integer getIdPoltrona() {
        return idPoltrona;
    }

    public void setIdPoltrona(Integer idPoltrona) {
        this.idPoltrona = idPoltrona;
    }

    public Aviao getAviao() {
        return aviao;
    }

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }

    public Passagem getPassagemIda() {
        return passagemIda;
    }

    public void setPassagemIda(Passagem passagemIda) {
        this.passagemIda = passagemIda;
    }

    public Passagem getPassagemVolta() {
        return passagemVolta;
    }

    public void setPassagemVolta(Passagem passagemVolta) {
        this.passagemVolta = passagemVolta;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public StatusPoltrona getStatusPoltronaIda() {
        return statusPoltronaIda;
    }

    public void setStatusPoltronaIda(StatusPoltrona statusPoltronaIda) {
        this.statusPoltronaIda = statusPoltronaIda;
    }

    public StatusPoltrona getStatusPoltronaVolta() {
        return statusPoltronaVolta;
    }

    public void setStatusPoltronaVolta(StatusPoltrona statusPoltronaVolta) {
        this.statusPoltronaVolta = statusPoltronaVolta;
    }
}
