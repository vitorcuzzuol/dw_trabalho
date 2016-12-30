package br.com.uff.servlet;


import br.com.uff.model.Passageiro;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class Checkin extends HttpServlet {

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idReserva = request.getParameter("idReserva");

        HttpSession session = request.getSession();

        List<Passageiro> passageiros = (List<Passageiro>)session.getAttribute("passageirosNaCompra");

        Boolean naoEncontrouPassageiros = true;

        for(Passageiro passageiro: passageiros){
            if(passageiro.getCpf().equals(idReserva)){
                request.setAttribute("passageiroEmCheckin",passageiro);
                RequestDispatcher dispatcher = request.getRequestDispatcher("bilhete-aereo.jsp");
                dispatcher.forward(request, response);
                naoEncontrouPassageiros = false;
            }
        }

        if(naoEncontrouPassageiros){
            RequestDispatcher dispatcher = request.getRequestDispatcher("checkin.jsp");
            request.setAttribute("mensagemRetorno", "Usuario nao encontrado. Verifique o codigo de reserva.");
            dispatcher.forward(request, response);
        }

    }
}
