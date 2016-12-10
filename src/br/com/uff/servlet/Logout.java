package br.com.uff.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Logout extends HttpServlet{

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Aqui iremos remover o usuário da sessão e redirecionar para a página inicial
        HttpSession session = request.getSession();
        //session.removeAttribute("usuarioLogado");
        session.invalidate();
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);


        /*

         Um detalhe, se for inspecionar os elementos da página pelo navegador será percebido que o cookie JSESSIONID foi criado e que após o logout ele continua lá.
         Entretanto, apesar do cookia continuar existindo, o atributo usuarioLogado está vazio.

        */
    }
}

