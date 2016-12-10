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

        //Capuramos a lista atual de voos selecionados para compra e acrescentamos mais um voo na variável "carrinho" da session.
        HttpSession session = request.getSession();
        List<Voo> voosSelecionados = (List<Voo>) session.getAttribute("carrinho");
        voosSelecionados.add(voo);
        session.setAttribute("carrinho",voosSelecionados);


        RequestDispatcher dispatcher = request.getRequestDispatcher("voo-adicionado.jsp");
        dispatcher.forward(request, response);
    }
}
