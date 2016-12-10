package br.com.uff.servlet;

import br.com.uff.model.Voo;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class Home extends HttpServlet {
    @Override
    /*Essa servlet vai ser carregada assim que o sistema iniciar, para criar o atributo "carrinho" na session
    Esse carrinho será um ArrayList, para que um usuário possa comprar mais de uma passagem. */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("carrinho") == null){
            session.setAttribute("carrinho", new ArrayList<Voo>());
        }
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
