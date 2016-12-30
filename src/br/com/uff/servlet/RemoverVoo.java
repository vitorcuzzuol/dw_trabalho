package br.com.uff.servlet;

import br.com.uff.model.Poltrona;
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

        //Capturando as poltronas escolhidas anteriormente pelo usuário.
        List<Poltrona> poltronas = (List<Poltrona>) session.getAttribute("poltronasUsuario");


        //Verificando se o usuário já escolheu poltronas. Caso tenha escolhido, vamos alterar a disponibilidade da poltrona para DISPONIVEL novamente.
        if(!(null == session.getAttribute("poltronasUsuarioIda")) || !(null == session.getAttribute("poltronasUsuarioVolta"))){
            if("IDA".equals(voo.getTipoVoo().getDescricao())){
                List<Poltrona> poltronasIda = (List<Poltrona>) session.getAttribute("poltronasUsuarioIda");
                dao.setarPoltronaDisponivel(poltronasIda,voo.getTipoVoo().getDescricao());
                poltronas.remove(poltronasIda);
                session.removeAttribute("poltronasUsuarioIda");
            } else {
                List<Poltrona> poltronasVolta = (List<Poltrona>) session.getAttribute("poltronasUsuarioVolta");
                dao.setarPoltronaDisponivel(poltronasVolta,voo.getTipoVoo().getDescricao());
                poltronas.remove(poltronasVolta);
                session.removeAttribute("poltronasUsuarioVolta");
            }
        }
        voosSelecionados.remove(voo);
        if(voosSelecionados.isEmpty()){
            session.invalidate();
        } else {
            session.setAttribute("carrinho",voosSelecionados);
        }


        RequestDispatcher dispatcher = request.getRequestDispatcher("carrinho-de-compras.jsp");
        dispatcher.forward(request, response);
    }
}
