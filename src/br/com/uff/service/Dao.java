package br.com.uff.service;

import br.com.uff.model.Voo;
import br.com.uff.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Dao {

    private EntityManager manager = new JPAUtil().getEntityManager();

    public List<Voo> retornarTodosOsVoos ( ) {

        List<Voo> voosEncontrados = new ArrayList<>();
        voosEncontrados  = manager.createQuery("select voo from Voo voo",Voo.class).getResultList();
        return voosEncontrados;
    }

    public List<Voo> retornarVoo(Date data, String localOrigem, String localDestino){
        //Consulta passando os filtros para busca do voo, retornando uma lista com os voos encontrados
        List<Voo> voosFiltrados = new ArrayList<>();
        String jpql = "select voo from Voo voo " + "where voo.data= ?1 and voo.localOrigem= ?2 and voo.localDestino= ?3";
        voosFiltrados  = manager.createQuery(jpql,Voo.class)
                                        .setParameter(1,data)
                                        .setParameter(2,localOrigem)
                                        .setParameter(3,localDestino)
                                        .getResultList();
        return voosFiltrados;
    }

    public Voo buscarVooPeloId (Integer idVoo){
        Voo vooEncontrado;
        String jpql = "select voo from Voo voo" +" where voo.id= ?1";
        vooEncontrado = manager.createQuery(jpql,Voo.class)
                                        .setParameter(1,idVoo).getSingleResult();
        return vooEncontrado;
    }
}
