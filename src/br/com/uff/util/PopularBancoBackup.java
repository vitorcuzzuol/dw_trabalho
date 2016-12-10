package br.com.uff.util;

import br.com.uff.model.*;
import br.com.uff.util.JPAUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PopularBancoBackup {



    public static void main(String[] args) throws ParseException {

         /*
            Abrindo conexão com o banco. Chamamos o EntityManager que vai cuidar das transações com o banco.
            Lembrando, criar o BANCO DE DADOS chamado "sistema_aeroporto_dw"
         */
        EntityManager manager = new JPAUtil().getEntityManager();

        /*
            Estado Managed: Dados estão sincronizados com o banco. Esse é o objetivo.
            Estado Transient: Os dados ainda não estão no banco
            Estado Detached: Já existem dados no banco, mas os dados da entidade estão desatualizados. Para resolver, precisamos fazer um Merge.
         */

        try{
            EntityTransaction transaction = manager.getTransaction();


            transaction.begin();


            Aviao aviao1 = new Aviao();
            manager.persist(aviao1);

            Aviao aviao2 = new Aviao();
            manager.persist(aviao2);

            Aviao aviao3 = new Aviao();
            manager.persist(aviao3);

            Aviao aviao4 = new Aviao();
            manager.persist(aviao4);

            Aviao aviao5 = new Aviao();
            manager.persist(aviao5);

            Aviao aviao6 = new Aviao();
            manager.persist(aviao6);

            Aviao aviao7 = new Aviao();
            manager.persist(aviao7);

            Aviao aviao8 = new Aviao();
            manager.persist(aviao8);

            Aviao aviao9 = new Aviao();
            manager.persist(aviao9);

            Aviao aviao10 = new Aviao();
            manager.persist(aviao10);

//ADICIONANDO 10 POLTRONAS PARA O AVIÃO 1
/*
            Poltrona poltrona1 = new Poltrona();
            poltrona1.setIdPoltrona(1);
            poltrona1.setStatusPoltrona(StatusPoltrona.DISPONIVEL);
            aviao1.setPoltronasDoAviao(poltrona1);
            poltrona1.setPoltronaAviao(aviao1);
            manager.merge(poltrona1);

            Poltrona poltrona2 = new Poltrona();
            poltrona2.setIdPoltrona(2);
            poltrona2.setStatusPoltrona(StatusPoltrona.DISPONIVEL);
            aviao1.setPoltronasDoAviao(poltrona2);
            poltrona2.setPoltronaAviao(aviao1);
            manager.merge(poltrona2);

            Poltrona poltrona3 = new Poltrona();
            poltrona3.setIdPoltrona(3);
            poltrona3.setStatusPoltrona(StatusPoltrona.DISPONIVEL);
            aviao1.setPoltronasDoAviao(poltrona3);
            poltrona3.setPoltronaAviao(aviao1);
            manager.merge(poltrona3);

            Poltrona poltrona4 = new Poltrona();
            poltrona4.setIdPoltrona(4);
            poltrona4.setStatusPoltrona(StatusPoltrona.DISPONIVEL);
            aviao1.setPoltronasDoAviao(poltrona4);
            poltrona4.setPoltronaAviao(aviao1);
            manager.merge(poltrona4);

            Poltrona poltrona5 = new Poltrona();
            poltrona5.setIdPoltrona(5);
            poltrona5.setStatusPoltrona(StatusPoltrona.DISPONIVEL);
            aviao1.setPoltronasDoAviao(poltrona5);
            poltrona5.setPoltronaAviao(aviao1);
            manager.merge(poltrona5);

            Poltrona poltrona6 = new Poltrona();
            poltrona6.setIdPoltrona(6);
            poltrona6.setStatusPoltrona(StatusPoltrona.DISPONIVEL);
            aviao1.setPoltronasDoAviao(poltrona6);
            poltrona6.setPoltronaAviao(aviao1);
            manager.merge(poltrona6);

            Poltrona poltrona7 = new Poltrona();
            poltrona7.setIdPoltrona(7);
            poltrona7.setStatusPoltrona(StatusPoltrona.DISPONIVEL);
            aviao1.setPoltronasDoAviao(poltrona7);
            poltrona7.setPoltronaAviao(aviao1);
            manager.merge(poltrona7);

            Poltrona poltrona8 = new Poltrona();
            poltrona8.setIdPoltrona(8);
            poltrona8.setStatusPoltrona(StatusPoltrona.DISPONIVEL);
            aviao1.setPoltronasDoAviao(poltrona8);
            poltrona8.setPoltronaAviao(aviao1);
            manager.merge(poltrona8);

            Poltrona poltrona9 = new Poltrona();
            poltrona9.setIdPoltrona(9);
            poltrona9.setStatusPoltrona(StatusPoltrona.DISPONIVEL);
            aviao1.setPoltronasDoAviao(poltrona9);
            poltrona9.setPoltronaAviao(aviao1);
            manager.merge(poltrona9);

            Poltrona poltrona10 = new Poltrona();
            poltrona10.setIdPoltrona(10);
            poltrona10.setStatusPoltrona(StatusPoltrona.DISPONIVEL);
            aviao1.setPoltronasDoAviao(poltrona10);
            poltrona10.setPoltronaAviao(aviao1);
            manager.merge(poltrona10);

//ADICIONANDO AS CLASSES DISPONÍVEIS PARA OS VOOS

            Classe classeEconomica = new Classe();
            classeEconomica.setPreco(100);
            classeEconomica.setTipoClasse(TipoClasse.ECONOMICA);

            Classe classeExecutiva = new Classe();
            classeExecutiva.setPreco(200);
            classeExecutiva.setTipoClasse(TipoClasse.EXECUTIVA);

            Classe classePrimeiraClasse = new Classe();
            classePrimeiraClasse.setPreco(300);
            classePrimeiraClasse.setTipoClasse(TipoClasse.PRIMEIRA_CLASSE);

            manager.persist(classePrimeiraClasse);
            manager.persist((classeEconomica));
            manager.persist(classeExecutiva);


// ADICIONANDO OS VOOS DISPONIVEIS NO SISTEMA

            Voo voo1 = new Voo();
            voo1.setDuracao(24);
            voo1.setNumParadas(3);
            voo1.setClasse(classeExecutiva);
            voo1.setDataIda(retornaDataFormatada("2016-01-01"));
            voo1.setDataVolta(retornaDataFormatada("2016-01-10"));
            voo1.setLocalSaida("Bahia");
            voo1.setLocalDestino("Maranhao");
            voo1.setAviao(aviao1);
            aviao1.setVoo(voo1);
            manager.persist(voo1);

            Voo voo2 = new Voo();
            voo2.setDuracao(2);
            voo2.setNumParadas(0);
            voo2.setClasse(classeEconomica);
            voo2.setDataIda(retornaDataFormatada("2016-12-20"));
            voo2.setDataVolta(retornaDataFormatada("2016-12-23"));
            voo2.setLocalSaida("Rio de Janeiro");
            voo2.setLocalDestino("Sao Paulo");
            voo2.setAviao(aviao2);
            aviao2.setVoo(voo2);
            manager.persist(voo2);

            Voo voo3 = new Voo();
            voo3.setDuracao(2);
            voo3.setNumParadas(0);
            voo3.setClasse(classePrimeiraClasse);
            voo3.setDataIda(retornaDataFormatada("2016-12-20"));
            voo3.setDataVolta(retornaDataFormatada("2016-12-23"));
            voo3.setLocalSaida("Sao Paulo");
            voo3.setLocalDestino("Rio de Janeiro");
            voo3.setAviao(aviao3);
            aviao3.setVoo(voo3);
            manager.persist(voo3);

            Voo voo4 = new Voo();
            voo4.setDuracao(10);
            voo4.setNumParadas(1);
            voo4.setClasse(classeEconomica);
            voo4.setDataIda(retornaDataFormatada("2016-12-20"));
            voo4.setDataVolta(retornaDataFormatada("2016-12-23"));
            voo4.setLocalSaida("Rio de Janeiro");
            voo4.setLocalDestino("Santa Catarina");
            voo4.setAviao(aviao4);
            aviao4.setVoo(voo4);
            manager.persist(voo4);

            Voo voo5 = new Voo();
            voo5.setDuracao(24);
            voo5.setNumParadas(3);
            voo5.setClasse(classePrimeiraClasse);
            voo5.setDataIda(retornaDataFormatada("2016-12-20"));
            voo5.setDataVolta(retornaDataFormatada("2016-12-23"));
            voo5.setLocalSaida("Rio de Janeiro");
            voo5.setLocalDestino("Bangkok");
            voo5.setAviao(aviao5);
            aviao5.setVoo(voo5);
            manager.persist(voo5);

            Voo voo6 = new Voo();
            voo6.setDuracao(5);
            voo6.setNumParadas(0);
            voo6.setClasse(classeEconomica);
            voo6.setDataIda(retornaDataFormatada("2016-12-20"));
            voo6.setDataVolta(retornaDataFormatada("2016-12-23"));
            voo6.setLocalSaida("Rio de Janeiro");
            voo6.setLocalDestino("Curitiba");
            voo6.setAviao(aviao6);
            aviao6.setVoo(voo6);
            manager.persist(voo6);

            Voo voo7 = new Voo();
            voo7.setDuracao(20);
            voo7.setNumParadas(1);
            voo7.setClasse(classeExecutiva);
            voo7.setDataIda(retornaDataFormatada("2016-12-20"));
            voo7.setDataVolta(retornaDataFormatada("2016-12-23"));
            voo7.setLocalSaida("Rio de Janeiro");
            voo7.setLocalDestino("Miami");
            voo7.setAviao(aviao7);
            aviao7.setVoo(voo7);
            manager.persist(voo7);

            Voo voo8 = new Voo();
            voo8.setDuracao(24);
            voo8.setNumParadas(2);
            voo8.setClasse(classePrimeiraClasse);
            voo8.setDataIda(retornaDataFormatada("2016-12-20"));
            voo8.setDataVolta(retornaDataFormatada("2016-12-23"));
            voo8.setLocalSaida("Rio de Janeiro");
            voo8.setLocalDestino("Londres");
            voo8.setAviao(aviao8);
            aviao8.setVoo(voo8);
            manager.persist(voo8);

            Voo voo9 = new Voo();
            voo9.setDuracao(20);
            voo9.setNumParadas(2);
            voo9.setClasse(classeExecutiva);
            voo9.setDataIda(retornaDataFormatada("2016-12-20"));
            voo9.setDataVolta(retornaDataFormatada("2016-12-23"));
            voo9.setLocalSaida("Rio de Janeiro");
            voo9.setLocalDestino("Nova Zelandia");
            voo9.setAviao(aviao9);
            aviao9.setVoo(voo9);
            manager.persist(voo9);

            Voo voo10 = new Voo();
            voo10.setDuracao(10);
            voo10.setNumParadas(1);
            voo10.setClasse(classeEconomica);
            voo10.setDataIda(retornaDataFormatada("2016-12-20"));
            voo10.setDataVolta(retornaDataFormatada("2016-12-23"));
            voo10.setLocalSaida("Rio de Janeiro");
            voo10.setLocalDestino("Mexico");
            voo10.setAviao(aviao10);
            aviao10.setVoo(voo10);
            manager.persist(voo10);
*/

//ADICIONANDO OS USUARIOS DO SISTEMA
/*
            Usuario usuario1 = new Usuario();
            usuario1.setNome("Joao da Silva");
            usuario1.setEmail("joao@uff.br");
            usuario1.setEndereco("Rua Sao Jose, 456");
            usuario1.setCpf(1235465678);
            usuario1.setSenha(1234);
            usuario1.setTelefone(27092435);
            usuario1.setDataNasc(retornaDataFormatada("1994-05-10"));

*/
          /*  usuario1.setVoo(voo1);
            voo1.setUsuarios(usuario1);

            usuario1.setPoltrona(poltrona1);
            poltrona1.setStatusPoltrona(StatusPoltrona.OCUPADO);
            poltrona1.setUsuario(usuario1); */
/*
            manager.persist(usuario1);
            //manager.merge(voo1);
            //manager.merge(poltrona1);

            Usuario usuario2 = new Usuario();
            usuario2.setNome("Pedro Alfradique");
            usuario2.setEmail("pedro@uff.br");
            usuario2.setEndereco("Rua Doutor Sardinha, 432");
            usuario2.setCpf(1432854959);
            usuario2.setTelefone(262923885);
            usuario2.setSenha(1234);
            usuario2.setDataNasc(retornaDataFormatada("1995-03-06"));

            /*
            usuario2.setVoo(voo1);
            usuario2.setPoltrona(poltrona2);
            poltrona2.setUsuario(usuario2);
            poltrona2.setStatusPoltrona(StatusPoltrona.OCUPADO);
            *//*
            manager.persist(usuario2);
            //manager.merge(voo1);
            //manager.merge(poltrona2);

            Usuario usuario3 = new Usuario();
            usuario3.setNome("Bruno Hilario");
            usuario3.setEmail("bruno@uff.br");
            usuario3.setEndereco("Rua Presidente Pedreira, 56");
            usuario3.setCpf(1928374759);
            usuario3.setTelefone(27098754);
            usuario3.setSenha(1234);
            usuario3.setDataNasc(retornaDataFormatada("1980-06-28"));

            /*usuario3.setVoo(voo1);
            usuario3.setPoltrona(poltrona5);
            poltrona5.setUsuario(usuario3);
            poltrona5.setStatusPoltrona(StatusPoltrona.OCUPADO); */
/*
            manager.persist(usuario3);
            //manager.merge(voo1);
            //manager.merge(poltrona5);

            Usuario usuario4 = new Usuario();
            usuario4.setNome("Caio Serra");
            usuario4.setEmail("caio@uff.br");
            usuario4.setEndereco("Rua Alvares de Azevedo, 25");
            usuario4.setCpf(1749387485);
            usuario4.setTelefone(26092435);
            usuario4.setSenha(1234);
            usuario4.setDataNasc(retornaDataFormatada("1996-07-10"));

            /*usuario4.setVoo(voo1);
            usuario4.setPoltrona(poltrona8);
            poltrona8.setUsuario(usuario4);
            poltrona8.setStatusPoltrona(StatusPoltrona.OCUPADO);
            */
     /*       manager.persist(usuario4);
            //manager.merge(voo1);
            //manager.merge(poltrona8);

*/


//ENVIANDO OS DADOS PARA O BANCO

            transaction.commit();


        } catch (Exception e) {
            e.printStackTrace();
            if (manager.isOpen()) {
                manager.getTransaction().rollback();
            }
        } finally {
            if (manager.isOpen()) {
                manager.close();
            }
        }
        System.exit(0);
    }


    //Método para converter uma data em String para Date
    public static Date retornaDataFormatada(String stringData) throws ParseException {

        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date dataSql = new java.sql.Date(myFormat.parse(stringData).getTime());

        return (dataSql);
    }

}