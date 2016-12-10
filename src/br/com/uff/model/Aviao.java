package br.com.uff.model;

import com.sun.istack.internal.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Aviao {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Nullable
    @OneToMany (mappedBy = "aviao")
    private List<Poltrona> poltronasDoAviao = new ArrayList<>();

    @Nullable
    private String modelo;

    @Nullable
    @OneToOne
    private Voo voo;

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Poltrona> getPoltronasDoAviao() {
        return poltronasDoAviao;
    }

    public void setPoltronasDoAviao(Poltrona poltrona) {

        poltronasDoAviao.add(poltrona);
    }

    public void setPoltronasDoAviao(List<Poltrona> poltronasDoAviao) {
        this.poltronasDoAviao = poltronasDoAviao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
