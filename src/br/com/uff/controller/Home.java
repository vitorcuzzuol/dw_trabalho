package br.com.uff.controller;

import br.com.uff.model.*;
import br.com.uff.service.Dao;

import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class Home extends HttpServlet {
    @Override
    /*Essa controller vai ser carregada assim que o sistema iniciar, para criar o atributo "carrinho" na session
    Esse carrinho ser� um ArrayList, para que um usu�rio possa comprar mais de uma passagem. */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            HttpSession session = req.getSession();
            Usuario usuario = (Usuario)session.getAttribute("usuarioLogado");
            Dao dao = new Dao();

            List<AvaliacaoAmigos> avaliacaoAmigos = dao.buscaAvaliacaoAmigosPeloId(usuario.getId());
            System.out.println("Criou a Lista");
            session.setAttribute("avaliacaoAmigos", avaliacaoAmigos);

            List<AvaliacaoHospedeiroxhospede> avaliacaoHospedeiroxhospede
                    = dao.buscaAvaliacaoHospedeiroxHospedePeloId(usuario.getId());
            session.setAttribute("avaliacaoHospedeiroxhospede", avaliacaoHospedeiroxhospede);

            List<AvaliacaoHospedexhospedeiro> avaliacaoHospedexhospedeiro
                    = dao.buscaAvaliacaoHospedexHospedeiroPeloId(usuario.getId());
            session.setAttribute("avaliacaoHospedexhospedeiro", avaliacaoHospedexhospedeiro);

            List<AvaliacaoOrganizadorxparticipante> avaliacaoOrganizadorxparticipante
                    = dao.buscaAvaliacaoOrganizadorxParticipantePeloId(usuario.getId());
            session.setAttribute("avaliacaoOrganizadorxparticipante", avaliacaoOrganizadorxparticipante);

            List<AvaliacaoParticipantexorganizador> avaliacaoParticipantexorganizador
                    = dao.buscaAvaliacaoParticipantexOrganizadorPeloId(usuario.getId());
            session.setAttribute("avaliacaoParticipantexorganizador", avaliacaoParticipantexorganizador);

            RequestDispatcher dispatcher = req.getRequestDispatcher("perfilLogado.jsp");
            dispatcher.forward(req, resp);
            }    catch (NoResultException e) {
           //Informa que não encontrou o usuario. Retornamos para a tela de login.
                req.setAttribute("mensagemRetorno", "Usuario nao encontrado. Digite novamente.");
                RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
                dispatcher.forward(req, resp);
            }
    }
}
