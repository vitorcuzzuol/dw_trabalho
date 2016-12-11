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
import java.util.Iterator;
import java.util.List;

public class RemoverVoo extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Capturamos os dados que precisamos para encontrar encontrar o Voo.
        Integer idVoo = Integer.valueOf(request.getParameter("id"));
        Dao dao = new Dao();
        Voo voo = dao.buscarVooPeloId(idVoo);

        HttpSession session = request.getSession();
        List<Voo> voosSelecionados = (List<Voo>) session.getAttribute("carrinho");

        for (int i = 0; i < voosSelecionados.size(); i++) {
            if(voosSelecionados.get(i).getId().equals(idVoo)){
                voosSelecionados.remove(i);
            }
        }
        voosSelecionados.remove(voo);
        //session.removeAttribute("carrinho");
        session.setAttribute("carrinho",voosSelecionados);

        RequestDispatcher dispatcher = request.getRequestDispatcher("carrinho-de-compras.jsp");
        dispatcher.forward(request, response);
    }
}
