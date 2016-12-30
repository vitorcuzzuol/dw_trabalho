package br.com.uff.servlet;

import br.com.uff.model.Voo;
import br.com.uff.service.Dao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class AdicionaVoo extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Capturamos os dados que precisamos para encontrar encontrar o Voo.
        Integer idVoo = Integer.valueOf(request.getParameter("id"));
        Dao dao = new Dao();
        Voo voo = dao.buscarVooPeloId(idVoo);
        Boolean vooJaInserido = false;

        //Capuramos a lista atual de voos selecionados para compra e acrescentamos mais um voo na vari�vel "carrinho" da session.
        HttpSession session = request.getSession();
        List<Voo> voosSelecionados = (List<Voo>) session.getAttribute("carrinho");
        for(Voo voo1: voosSelecionados){
            if (voo1.getId() == voo.getId()) {
                vooJaInserido = true;
            }
        }
        if (!vooJaInserido){
            voosSelecionados.add(voo);
            session.setAttribute("carrinho",voosSelecionados);
            RequestDispatcher dispatcher = request.getRequestDispatcher("voo-adicionado.jsp");
            dispatcher.forward(request, response);
        } else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("carrinho-de-compras.jsp");
            dispatcher.forward(request, response);
        }


    }

}

