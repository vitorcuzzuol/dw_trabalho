package br.com.uff.model;

import com.sun.istack.internal.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Nullable
    @OneToMany (mappedBy = "numeroVenda")
    private List<Passagem> numPassagensCompradas = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Passagem> getNumPassagensCompradas() {
        return numPassagensCompradas;
    }

    public void setNumPassagensCompradas(Passagem novaPassagem) {
        this.numPassagensCompradas.add(novaPassagem);
    }
}
