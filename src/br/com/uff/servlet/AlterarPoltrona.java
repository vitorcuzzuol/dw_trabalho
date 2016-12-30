package br.com.uff.servlet;

import br.com.uff.model.Passageiro;
import br.com.uff.model.Poltrona;
import br.com.uff.service.Dao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AlterarPoltrona extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //Capturando poltronas selecionadas pelo usuário
        String[] poltronas = request.getParameterValues("poltronasUsuario");
        String poltronasSemFormatacao = poltronas[0].toString();
        String[] poltronasSemFormatacao2 = poltronasSemFormatacao.split(" ");
        List<String> poltronasFormatadas = new ArrayList<>();
        for (Integer i=2; i<poltronasSemFormatacao2.length; i = i + 4){
            poltronasFormatadas.add(poltronasSemFormatacao2[i]);
        }

        Dao dao = new Dao();
        HttpSession session = request.getSession();
        List<Poltrona> poltronasIda = (List<Poltrona>)session.getAttribute("poltronasUsuarioIda");
        List<Poltrona> poltronasVolta = (List<Poltrona>)session.getAttribute("poltronasUsuarioVolta");
        List<Passageiro> passageiros = (List<Passageiro>) session.getAttribute("passageirosNaCompra");

        //Verificando se as poltronas e alteração são de IDA e alterando o status delas para Disponivel, permitindo que o usuário as escolhe novamente, caso deseje.
        Integer idPoltronaEmAlteracao = 0;
        if(poltronasIda != null){
            for(String poltrona: poltronasFormatadas){
                // 10 11
                while(idPoltronaEmAlteracao <= 30){
                    if (String.valueOf(idPoltronaEmAlteracao).equals(poltrona)){
                        Poltrona poltrona1 = new Poltrona();
                        poltrona1.setIdPoltrona(Integer.parseInt(poltrona));
                        dao.setarPoltronasDisponivel(poltrona1);
                        ++idPoltronaEmAlteracao;
                        break;
                    } else{
                        idPoltronaEmAlteracao++;
                    }
                }
            }
           // session.removeAttribute("poltronasUsuarioIda");
        }


        //Verificando se as poltronas e alteração são de VOLTA e alterando o status delas para Disponivel, permitindo que o usuário as escolhe novamente, caso deseje.
        if(poltronasVolta != null){
            for(String poltrona: poltronasFormatadas){
                while(idPoltronaEmAlteracao <= 30){
                    if (String.valueOf(idPoltronaEmAlteracao).equals(poltrona)){
                        Poltrona poltrona1 = new Poltrona();
                        poltrona1.setIdPoltrona(Integer.parseInt(poltrona));
                        dao.setarPoltronasDisponivel(poltrona1);
                        ++idPoltronaEmAlteracao;
                    } else{
                        idPoltronaEmAlteracao++;
                    }
                }
            }
            //session.removeAttribute("poltronasUsuarioVolta");

        }


        //Encontrando o passageiro que deseja alterar suas poltronas
        Integer idPassageiro =  Integer.valueOf(request.getParameter("id"));
        Passageiro passageiroEmQuestao = new Passageiro();
        for(Passageiro passageiro: passageiros){
            if (passageiro.getId() == idPassageiro){
                passageiroEmQuestao = passageiro;
            }
        }
        session.setAttribute("passageiroEmQuestao",passageiroEmQuestao);
        session.setAttribute("poltronaSofreuAlteracao",1);

        RequestDispatcher dispatcher = request.getRequestDispatcher("alterar-poltrona.jsp");
        dispatcher.forward(request, response);
    }
}
