package br.com.uff.servlet;


import br.com.uff.model.Passageiro;
import br.com.uff.model.Poltrona;
import br.com.uff.model.Voo;
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

public class AdicionarPoltrona extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer idVoo = Integer.valueOf(request.getParameter("vooId"));
//        Integer idPoltrona = Integer.valueOf(request.getParameter("idPoltrona"));

        String[] idPoltronas = request.getParameterValues("idPoltrona");
        String tipoVoo = request.getParameter("tipoVoo");
        Dao dao = new Dao();
        Voo voo = dao.buscarVooPeloId(idVoo);

        /*
        for (String tmpNumeroAssento : idPoltronas) {
                    assentosIda.add(daoAS.getAssentoPorId(Integer.parseInt(tmpNumeroAssento)));
         */

        //Setando no banco de dados qual poltrona foi comprada
        dao.setarPoltronaEmCompra(idPoltronas,tipoVoo);

        //Setando a poltrona comprada na session
        HttpSession session = request.getSession();

       //Esse cara vai guardar todas as poltronas que forem escolhidas pelo usuário.
        List<Poltrona> poltronasUsuario = new ArrayList<>();
        if (session.getAttribute("poltronasUsuario") != null){
            poltronasUsuario = (List<Poltrona>) session.getAttribute("poltronasUsuario");
        }

        if (tipoVoo.equals("IDA")){
//            Poltrona poltronaEscolhidas = dao.buscarPoltronaPeloId(idPoltrona);
            List<Poltrona> poltronasEscolhidas = dao.buscarPoltronasPeloId(idPoltronas);
            voo.setPoltrona(poltronasEscolhidas);
            poltronasUsuario.addAll(poltronasEscolhidas);
            session.setAttribute("poltronasUsuarioIda",poltronasEscolhidas);
        } else if (tipoVoo.equals("VOLTA")){
            List<Poltrona> poltronasEscolhidas = dao.buscarPoltronasPeloId(idPoltronas);
            voo.setPoltrona(poltronasEscolhidas);
            poltronasUsuario.addAll(poltronasEscolhidas);
            session.setAttribute("poltronasUsuarioVolta",poltronasEscolhidas);
        }

        session.setAttribute("poltronasUsuario",poltronasUsuario);

        RequestDispatcher dispatcher = request.getRequestDispatcher("escolher-poltronas.jsp");
        dispatcher.forward(request, response);
        }



    }

