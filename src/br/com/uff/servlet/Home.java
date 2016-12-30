package br.com.uff.servlet;

import br.com.uff.model.Classe;
import br.com.uff.model.Poltrona;
import br.com.uff.model.Voo;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Home extends HttpServlet {
    @Override
    /*Essa servlet vai ser carregada assim que o sistema iniciar, para criar o atributo "carrinho" na session
    Esse carrinho ser� um ArrayList, para que um usu�rio possa comprar mais de uma passagem. */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("carrinho") == null){
            session.setAttribute("carrinho", new ArrayList<Voo>());

            //Criando campo para precificação de voos na session, para retornar o preço total dos voos.
            Double precoVoosCarrinho = 0.0;
            session.setAttribute("precoTotalVoos", precoVoosCarrinho);

            //Criando a lista de poltronas do usuário.
            List<Poltrona> poltronasUsuario = new ArrayList<>();
            session.setAttribute("poltronasUsuario",poltronasUsuario);

            Double precoPoltronas = 0.0;
            session.setAttribute("precoPoltronas",precoPoltronas);


        }
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
