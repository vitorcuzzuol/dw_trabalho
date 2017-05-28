package br.com.uff.controller;


import br.com.uff.model.*;
import br.com.uff.service.Dao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class Perfil extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            Integer idUsuario = Integer.parseInt(req.getParameter("id"));
            Dao dao = new Dao();
            Usuario usuario = dao.buscarUsuarioPeloId(idUsuario);
            HttpSession session = req.getSession();
            session.setAttribute("perfilAmigo", usuario);
            List<AvaliacaoAmigos> avaliacaoAmigos = dao.buscaAvaliacaoAmigosPeloId(usuario.getId());
            session.setAttribute("avaliacaoAmigosPerfil", avaliacaoAmigos);

            List<AvaliacaoHospedeiroxhospede> avaliacaoHospedeiroxhospede
                    = dao.buscaAvaliacaoHospedeiroxHospedePeloId(usuario.getId());
            session.setAttribute("avaliacaoHospedeiroxhospedePerfil", avaliacaoHospedeiroxhospede);

            List<AvaliacaoHospedexhospedeiro> avaliacaoHospedexhospedeiro
                    = dao.buscaAvaliacaoHospedexHospedeiroPeloId(usuario.getId());
            session.setAttribute("avaliacaoHospedexhospedeiroPerfil", avaliacaoHospedexhospedeiro);

            List<AvaliacaoOrganizadorxparticipante> avaliacaoOrganizadorxparticipante
                    = dao.buscaAvaliacaoOrganizadorxParticipantePeloId(usuario.getId());
            session.setAttribute("avaliacaoOrganizadorxparticipantePerfil", avaliacaoOrganizadorxparticipante);

            List<AvaliacaoParticipantexorganizador> avaliacaoParticipantexorganizador
                    = dao.buscaAvaliacaoParticipantexOrganizadorPeloId(usuario.getId());
            session.setAttribute("avaliacaoParticipantexorganizadorPerfil", avaliacaoParticipantexorganizador);

            RequestDispatcher dispatcher = req.getRequestDispatcher("perfilAmigo.jsp");
            dispatcher.forward(req, resp);
        }catch (Exception e){

        }
    }
}
