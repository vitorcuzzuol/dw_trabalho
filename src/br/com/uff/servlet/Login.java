package br.com.uff.servlet;

import br.com.uff.model.Usuario;
import br.com.uff.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login extends HttpServlet{

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Sempre que carregarmos a classe, vamos capturar a sessão do usuário, para verificar se o campo "usuario.logado" da Session está preenchido.

        //Captura de parâmetros e acesso ao banco, com a query.
        String emailInformado = request.getParameter("email");
        String senhaInformada = request.getParameter("senha");
        try {
            EntityManager manager = new JPAUtil().getEntityManager();
            Query consulta = manager.createQuery("select user from Usuario user where user.email = :pEmail"
                    + " and user.senha= :pSenha");
            consulta.setParameter("pEmail", emailInformado);
            consulta.setParameter("pSenha", (Integer.valueOf(senhaInformada)));

            Usuario usuarioEncontrado = (Usuario) consulta.getSingleResult();

            //Já que encontramos o usuário, vamos iniciar a Session
            HttpSession session = request.getSession();
            session.setAttribute("usuarioLogado", usuarioEncontrado);


            // Caso o usuário seja encontrado, nenhuma exceção é lançada. Vamos então iniciar a session e redirecionar para a tela do usuário.
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);


        } catch (NoResultException e){
            //Informa que não encontrou o usuario. Retornamos para a tela de login.
            request.setAttribute("mensagemRetorno", "Usuario nao encontrado. Digite novamente.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
