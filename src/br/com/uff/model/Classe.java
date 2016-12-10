package br.com.uff.model;

import com.sun.istack.internal.Nullable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Classe {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Nullable
    @Enumerated(EnumType.STRING)
    private TipoClasse tipoClasse;


    //Uma classe possui várias poltronas
    @Nullable
    @OneToMany (mappedBy = "classe")
    private List<Poltrona> poltrona = new ArrayList<>();

    @Nullable
    public TipoClasse getTipoClasse() {
        return tipoClasse;
    }

    public void setTipoClasse(TipoClasse tipoClasse) {
        this.tipoClasse = tipoClasse;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Poltrona> getPoltrona() {
        return poltrona;
    }

    public void setPoltrona(Poltrona poltrona) {
        this.poltrona.add(poltrona);
    }

}
