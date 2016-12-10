package br.com.uff.servlet;

import br.com.uff.model.Voo;
import br.com.uff.service.Dao;
import br.com.uff.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static br.com.uff.util.PopularBanco.retornaDataFormatada;


public class BuscaVoos extends HttpServlet {

   protected void doPost (HttpServletRequest request, HttpServletResponse response) {
       try {
           //Capturando os parâmetros informados pelo usuário
           String stringDataIda = request.getParameter("dataIda");
           String stringDataVolta = request.getParameter("dataVolta");
           String localOrigem = request.getParameter("localOrigem");
           String localDestino = request.getParameter("localDestino");

           //Declarando variáveis
           EntityManager manager = new JPAUtil().getEntityManager();
           Dao dao = new Dao();
           List<Voo> voosIda = new ArrayList<>();
           List<Voo> voosVolta = new ArrayList<>();

           //Tratando os dados da requisição
           Date dataIda = retornaDataFormatada(stringDataIda);
           Date dataVolta = retornaDataFormatada(stringDataVolta);

          /* Capturamos a data de ida e volta e buscamos um voo para a ida e outro voo para a volta, setando uma variável no request.
           Esse request será capturado com "requestScope". Reparar, invertemos o
           local de origem e destino nas consultas para verificar se existe um voo de ida e volta para o mesmo lugar. */
           voosIda = dao.retornarVoo(dataIda,localOrigem,localDestino);
           voosVolta = dao.retornarVoo(dataVolta,localDestino,localOrigem);
           request.setAttribute("voosIda",voosIda);
           request.setAttribute("voosVolta",voosVolta);



           HttpSession session = request.getSession();
           session.setAttribute("voosIda", voosIda);
           session.setAttribute("voosVolta",voosVolta);

           RequestDispatcher dispatcher = request.getRequestDispatcher("buscar-voo-personalizado.jsp");
           dispatcher.forward(request, response);


       } catch (ParseException | IOException | ServletException e) {
           e.printStackTrace();
       }

   }



}
