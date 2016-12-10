package br.com.uff.util;

import br.com.uff.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PopularBanco {

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

            //ADICIONANDO AEROPORTOS AO SISTEMA (OK)
            //ADICIONANDO AEROPORTOS AO SISTEMA (OK)
            //ADICIONANDO AEROPORTOS AO SISTEMA (OK)
            //ADICIONANDO AEROPORTOS AO SISTEMA (OK)
            //ADICIONANDO AEROPORTOS AO SISTEMA (OK)

            Aeroporto aeroporto1 = new Aeroporto();
            aeroporto1.setId(1);
            aeroporto1.setNomeAeroporto("Galeao");
            aeroporto1.setTaxa(50.00);
            manager.merge(aeroporto1);

            Aeroporto aeroporto2 = new Aeroporto();
            aeroporto2.setId(2);
            aeroporto2.setNomeAeroporto("Augusto Severo");
            aeroporto2.setTaxa(40.00);
            manager.merge(aeroporto2);

            Aeroporto aeroporto3 = new Aeroporto();
            aeroporto3.setId(3);
            aeroporto3.setNomeAeroporto("Congonhas");
            aeroporto3.setTaxa(90.00);
            manager.merge(aeroporto3);

            Aeroporto aeroporto4 = new Aeroporto();
            aeroporto4.setId(4);
            aeroporto4.setNomeAeroporto("Cumbica");
            aeroporto4.setTaxa(60.00);
            manager.merge(aeroporto4);

            //ADICIONANDO AS CLASSES DISPONÍVEIS PARA OS VOOS (3)
            //ADICIONANDO AS CLASSES DISPONÍVEIS PARA OS VOOS (3)
            //ADICIONANDO AS CLASSES DISPONÍVEIS PARA OS VOOS (3)
            //ADICIONANDO AS CLASSES DISPONÍVEIS PARA OS VOOS (3)
            //ADICIONANDO AS CLASSES DISPONÍVEIS PARA OS VOOS (3)

            Classe classeEconomica = new Classe();
            classeEconomica.setId(1);
            classeEconomica.setTipoClasse(TipoClasse.ECONOMICA);

            Classe classePrimeiraClasse = new Classe();
            classePrimeiraClasse.setId(2);
            classePrimeiraClasse.setTipoClasse(TipoClasse.PRIMEIRA_CLASSE);

            Classe classeExecutiva = new Classe();
            classeExecutiva.setId(3);
            classeExecutiva.setTipoClasse(TipoClasse.EXECUTIVA);

            manager.merge(classeEconomica);
            manager.merge(classePrimeiraClasse);
            manager.merge(classeExecutiva);



            //ADIOCIONANDO USUÁRIOS AO SISTEMA (1)
            //ADIOCIONANDO USUÁRIOS AO SISTEMA (1)
            //ADIOCIONANDO USUÁRIOS AO SISTEMA (1)
            //ADIOCIONANDO USUÁRIOS AO SISTEMA (1)
            //ADIOCIONANDO USUÁRIOS AO SISTEMA (1)


            Usuario usuario1 = new Usuario();
            usuario1.setEmail("joao@uff.br");
            usuario1.setNome("Joao");
            usuario1.setSenha(1234);
            manager.persist(usuario1);

            Usuario usuario2 = new Usuario();
            usuario2.setEmail("pedro@uff.br");
            usuario2.setNome("Pedro");
            usuario2.setSenha(1234);
            manager.persist(usuario2);

            Usuario usuario3 = new Usuario();
            usuario3.setEmail("bruno@uff.br");
            usuario3.setNome("Bruno");
            usuario3.setSenha(1234);
            manager.persist(usuario3);

            Usuario usuario4 = new Usuario();
            usuario4.setEmail("caio@uff.br");
            usuario4.setNome("Caio");
            usuario4.setSenha(1234);
            manager.persist(usuario4);



            //ADICIONANDO AVIÕES PARA O SISTEMA (5)
            //ADICIONANDO AVIÕES PARA O SISTEMA (5)
            //ADICIONANDO AVIÕES PARA O SISTEMA (5)
            //ADICIONANDO AVIÕES PARA O SISTEMA (5)
            //ADICIONANDO AVIÕES PARA O SISTEMA (5)

            Aviao aviao1 = new Aviao();
            aviao1.setId(1);
            aviao1.setModelo("Super Constelation L-1049");
            manager.merge(aviao1);

            Aviao aviao2 = new Aviao();
            aviao2.setId(2);
            aviao2.setModelo("Airbus A320" );
            manager.merge(aviao2);



            //ADICIONANDO PASSAGEIROS AO SISTEMA
            //ADICIONANDO PASSAGEIROS AO SISTEMA
            //ADICIONANDO PASSAGEIROS AO SISTEMA
            //ADICIONANDO PASSAGEIROS AO SISTEMA
            //ADICIONANDO PASSAGEIROS AO SISTEMA

            Passageiro passageiro1 = new Passageiro();
            passageiro1.setNome("Joao da Silva");
            passageiro1.setEndereco("Rua Sao Jose, 456");
            passageiro1.setCpf(1235465678);
            passageiro1.setTelefone(27092435);
            passageiro1.setDataNasc(retornaDataFormatada("1994-05-10"));
            manager.persist(passageiro1);

            Passageiro passageiro2 = new Passageiro();
            passageiro2.setNome("Pedro Alfradique");
            passageiro2.setEndereco("Rua Doutor Sardinha, 432");
            passageiro2.setCpf(1432854959);
            passageiro2.setTelefone(262923885);
            passageiro2.setDataNasc(retornaDataFormatada("1995-03-06"));
            manager.persist(passageiro2);


            Passageiro passageiro3 = new Passageiro();
            passageiro3.setNome("Bruno Hilario");
            passageiro3.setEndereco("Rua Presidente Pedreira, 56");
            passageiro3.setCpf(1928374759);
            passageiro3.setTelefone(27098754);
            passageiro3.setDataNasc(retornaDataFormatada("1980-06-28"));
            manager.persist(passageiro3);

            Passageiro passageiro4 = new Passageiro();
            passageiro4.setNome("Caio Serra");
            passageiro4.setEndereco("Rua Alvares de Azevedo, 25");
            passageiro4.setCpf(1749387485);
            passageiro4.setTelefone(26092435);
            passageiro4.setDataNasc(retornaDataFormatada("1996-07-10"));
            manager.persist(passageiro4);


            //ADICIONANDO VOOS AO SISTEMA(2)
            //ADICIONANDO VOOS AO SISTEMA(2)
            //ADICIONANDO VOOS AO SISTEMA(2)
            //ADICIONANDO VOOS AO SISTEMA(2)

            //Funcionamento: Para uma passagem de ida e volta, são gerados dois objetos Voo, um Voo pro destino e um Voo pra volta.

            Voo voo1Ida = new Voo();
            voo1Ida.setId(1);
            voo1Ida.setDuracao(24);
            voo1Ida.setNumParadas(3);
            voo1Ida.setAeroporto(aeroporto1);
            voo1Ida.setData(retornaDataFormatada("2016-01-01"));
            voo1Ida.setLocalOrigem("Bahia");
            voo1Ida.setLocalDestino("Maranhao");
            voo1Ida.setPreco(200.00);
            voo1Ida.setAviao(aviao1);
            aviao1.setVoo(voo1Ida);
            manager.merge(voo1Ida);
            manager.merge(aviao1);

            Voo voo1Volta = new Voo();
            voo1Volta.setId(2);
            voo1Volta.setDuracao(24);
            voo1Volta.setNumParadas(3);
            voo1Volta.setAeroporto(aeroporto1);
            voo1Volta.setData(retornaDataFormatada("2016-01-10"));
            voo1Volta.setLocalOrigem("Maranhao");
            voo1Volta.setLocalDestino("Bahia");
            voo1Volta.setPreco(200.00);
            voo1Volta.setAviao(aviao2);
            aviao2.setVoo(voo1Volta);
            manager.merge(voo1Volta);
            manager.merge(aviao2);


            Voo voo2Ida = new Voo();
            voo2Ida.setId(3);
            voo2Ida.setDuracao(30);
            voo2Ida.setNumParadas(2);
            voo2Ida.setAeroporto(aeroporto1);
            voo2Ida.setData(retornaDataFormatada("2016-01-01"));
            voo2Ida.setLocalOrigem("Rio de Janeiro");
            voo2Ida.setLocalDestino("Sao Paulo");
            voo2Ida.setPreco(250.00);
            manager.merge(voo2Ida);

            Voo voo2Volta = new Voo();
            voo2Volta.setId(4);
            voo2Volta.setDuracao(30);
            voo2Volta.setNumParadas(2);
            voo2Volta.setAeroporto(aeroporto1);
            voo2Volta.setData(retornaDataFormatada("2016-01-10"));
            voo2Volta.setLocalOrigem("Sao Paulo");
            voo2Volta.setLocalDestino("Rio de Janeiro");
            voo2Volta.setPreco(250.00);
            manager.merge(voo2Volta);


            //ADICIONANDO POLTRONAS AO SISTEMA
            //ADICIONANDO POLTRONAS AO SISTEMA
            //ADICIONANDO POLTRONAS AO SISTEMA
            //ADICIONANDO POLTRONAS AO SISTEMA
            //ADICIONANDO POLTRONAS AO SISTEMA

            Poltrona poltrona1 = new Poltrona();
            poltrona1.setIdPoltrona(1);
            //poltrona1.setPreco(100.00);
            poltrona1.setStatusPoltronaIda(StatusPoltrona.DISPONIVEL);
            poltrona1.setStatusPoltronaVolta(StatusPoltrona.DISPONIVEL);
            poltrona1.setClasse(classeEconomica);
            classeEconomica.setPoltrona(poltrona1);
            poltrona1.setAviao(aviao1);
            aviao1.setPoltronasDoAviao(poltrona1);
            manager.merge(poltrona1);

            Poltrona poltrona2 = new Poltrona();
            poltrona2.setIdPoltrona(2);
            //poltrona2.setPreco(150.00);
            poltrona2.setStatusPoltronaIda(StatusPoltrona.DISPONIVEL);
            poltrona2.setStatusPoltronaVolta(StatusPoltrona.DISPONIVEL);
            poltrona2.setClasse(classeExecutiva);
            classeExecutiva.setPoltrona(poltrona2);
            poltrona2.setAviao(aviao1);
            aviao1.setPoltronasDoAviao(poltrona2);
            manager.merge(poltrona2);

            Poltrona poltrona3 = new Poltrona();
            poltrona3.setIdPoltrona(3);
            //poltrona3.setPreco(160.00);
            poltrona3.setStatusPoltronaIda(StatusPoltrona.DISPONIVEL);
            poltrona3.setStatusPoltronaVolta(StatusPoltrona.DISPONIVEL);
            poltrona3.setClasse(classePrimeiraClasse);
            classePrimeiraClasse.setPoltrona(poltrona3);
            poltrona3.setAviao(aviao1);
            aviao1.setPoltronasDoAviao(poltrona3);
            manager.merge(poltrona3);

            Poltrona poltrona4 = new Poltrona();
            poltrona4.setIdPoltrona(4);
            //poltrona4.setPreco(150.00);
            poltrona4.setStatusPoltronaIda(StatusPoltrona.DISPONIVEL);
            poltrona4.setStatusPoltronaVolta(StatusPoltrona.DISPONIVEL);
            poltrona4.setClasse(classeEconomica);
            classeEconomica.setPoltrona(poltrona4);
            poltrona4.setAviao(aviao1);
            aviao1.setPoltronasDoAviao(poltrona4);
            manager.merge(poltrona4);

            //CRIANDO 5 POLTRONAS EXECUTIVAS PARA O AVIAO 1
            Poltrona poltrona5 = new Poltrona();
            poltrona5.setStatusPoltronaIda(StatusPoltrona.DISPONIVEL);
            poltrona5.setStatusPoltronaVolta(StatusPoltrona.DISPONIVEL);
            poltrona5.setAviao(aviao1);
            aviao1.setPoltronasDoAviao(poltrona5);
            poltrona5.setIdPoltrona(5);
            poltrona5.setClasse(classeExecutiva);
            classeExecutiva.setPoltrona(poltrona5);
            manager.merge(poltrona5);


            Poltrona poltrona6 = new Poltrona();
            poltrona6.setStatusPoltronaIda(StatusPoltrona.DISPONIVEL);
            poltrona6.setStatusPoltronaVolta(StatusPoltrona.DISPONIVEL);
            poltrona6.setAviao(aviao1);
            aviao1.setPoltronasDoAviao(poltrona6);
            poltrona6.setIdPoltrona(6);
            poltrona6.setClasse(classeExecutiva);
            classeExecutiva.setPoltrona(poltrona6);
            manager.merge(poltrona6);


            Poltrona poltrona7 = new Poltrona();
            poltrona7.setStatusPoltronaIda(StatusPoltrona.DISPONIVEL);
            poltrona7.setStatusPoltronaVolta(StatusPoltrona.DISPONIVEL);
            poltrona7.setAviao(aviao1);
            aviao1.setPoltronasDoAviao(poltrona7);
            poltrona7.setIdPoltrona(7);
            poltrona7.setClasse(classeExecutiva);
            classeExecutiva.setPoltrona(poltrona7);
            manager.merge(poltrona7);

            Poltrona poltrona8 = new Poltrona();
            poltrona8.setStatusPoltronaIda(StatusPoltrona.DISPONIVEL);
            poltrona8.setStatusPoltronaVolta(StatusPoltrona.DISPONIVEL);
            poltrona8.setAviao(aviao1);
            aviao1.setPoltronasDoAviao(poltrona8);
            poltrona8.setIdPoltrona(8);
            poltrona8.setClasse(classeExecutiva);
            classeExecutiva.setPoltrona(poltrona8);
            manager.merge(poltrona8);

            Poltrona poltrona9 = new Poltrona();
            poltrona9.setStatusPoltronaIda(StatusPoltrona.DISPONIVEL);
            poltrona9.setStatusPoltronaVolta(StatusPoltrona.DISPONIVEL);
            poltrona9.setAviao(aviao1);
            aviao1.setPoltronasDoAviao(poltrona9);
            poltrona9.setIdPoltrona(9);
            poltrona9.setClasse(classeExecutiva);
            classeExecutiva.setPoltrona(poltrona9);
            manager.merge(poltrona9);

            Poltrona poltrona10 = new Poltrona();
            poltrona10.setStatusPoltronaIda(StatusPoltrona.DISPONIVEL);
            poltrona10.setStatusPoltronaVolta(StatusPoltrona.DISPONIVEL);
            poltrona10.setAviao(aviao1);
            aviao1.setPoltronasDoAviao(poltrona10);
            poltrona10.setIdPoltrona(10);
            poltrona10.setClasse(classeExecutiva);
            classeExecutiva.setPoltrona(poltrona10);
            manager.merge(poltrona10);

            /*Anotações:

                         Aviao1 --> A entidade possui apenas determinadas poltronas.
                         As poltronas pertencerão a uma passagem. Essa passagem possui um Voo.

                         Poltrona 1 --> Aviao1
                         Poltrona 2 --> Aviao1
                         Poltrona 3 --> Aviao1
                         Poltrona 4 --> Aviao1

            //Sobre a passagem 1:

                         Passageiro --> Passageiro1
                         Poltrona 1 --> passagem1
                         Poltrona 3 --> passagem1

                         Poltrona1 --> passagem1
                         Poltrona2 --> passagem1

                         Voo1Ida   --> passagem1
                         Voo1Volta --> passagem1


            */

            //ADICIONANDO PASSAGENS PARA O SISTEMA
            //ADICIONANDO PASSAGENS PARA O SISTEMA
            //ADICIONANDO PASSAGENS PARA O SISTEMA
            //ADICIONANDO PASSAGENS PARA O SISTEMA
            //ADICIONANDO PASSAGENS PARA O SISTEMA


            Passagem passagem1 = new Passagem();
            passagem1.setId(1);
            manager.merge(passagem1);
            passagem1.setPoltronaIda(poltrona1);
            poltrona1.setPassagemIda(passagem1);
            poltrona1.setStatusPoltronaIda(StatusPoltrona.OCUPADO);
            passagem1.setPoltronaVolta(poltrona3);
            poltrona3.setPassagemVolta(passagem1);
            passagem1.setPassageiro(passageiro1);
            poltrona3.setStatusPoltronaVolta(StatusPoltrona.OCUPADO);
            passageiro1.setPassagemComprada(passagem1);
            passagem1.setVooIda(voo1Ida);
            voo1Ida.setPassagensIda(passagem1);
            passagem1.setVooVolta(voo1Volta);
            voo1Volta.setPassagensVolta(passagem1);
            manager.merge(passagem1);
            manager.merge(poltrona1);
            manager.merge(poltrona3);


            /*
            *
            *   Sobre a passagem 2:
            *
            *            Passageiro --> passageiro2
                         Poltrona2 --> passagem2
                         Poltrona4 --> passagem2

                         Voo2Ida   --> passagem2
                         Voo2Volta --> passagem2

            *
            * */

            Passagem passagem2 = new Passagem();
            passagem2.setId(2);
            passagem2.setPoltronaIda(poltrona4);
            poltrona4.setPassagemIda(passagem2);
            poltrona4.setStatusPoltronaIda(StatusPoltrona.OCUPADO);
            passagem2.setPoltronaVolta(poltrona4);
            poltrona4.setPassagemVolta(passagem2);
            poltrona4.setStatusPoltronaVolta(StatusPoltrona.OCUPADO);
            passagem2.setPassageiro(passageiro2);
            passageiro2.setPassagemComprada(passagem2);
            passagem2.setVooIda(voo2Ida);
            voo2Ida.setPassagensIda(passagem2);
            passagem2.setVooVolta(voo2Volta);
            voo2Volta.setPassagensVolta(passagem2);
            manager.merge(passagem2);
            manager.merge(poltrona4);
            manager.merge(poltrona2);


            /* MODELO DE INSERÇÃO DE PASSAGENS

            Passagem passagem2 = new Passagem();
            passagem2.setId(2);

            passagem2.setPoltronaIda();
            passagem2.setPoltronaVolta();

            passagem2.setPassageiro();

            passagem2.setVooIda();
            passagem2.setVooVolta();

            manager.merge(passagem2);

            */

            Venda venda1 = new Venda();
            venda1.setId(1);
            venda1.setNumPassagensCompradas(passagem1);
            passagem1.setNumeroVenda(venda1);
            venda1.setNumPassagensCompradas(passagem2);
            passagem2.setNumeroVenda(venda1);
            manager.merge(venda1);
            manager.merge(passagem1);
            manager.merge(passagem2);

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



