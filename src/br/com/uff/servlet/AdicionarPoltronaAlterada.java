package br.com.uff.servlet;

import br.com.uff.model.Passageiro;
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
import java.util.ArrayList;
import java.util.List;

public class AdicionarPoltronaAlterada extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer idVoo = Integer.valueOf(request.getParameter("vooId"));
        String tipoVoo = request.getParameter("tipoVoo");
        HttpSession session = request.getSession();

        String[] idPoltronas = request.getParameterValues("idPoltrona");
        Passageiro passageiroEmQuestao = (Passageiro)session.getAttribute("passageiroEmQuestao");

        Dao dao = new Dao();
        Voo voo = dao.buscarVooPeloId(idVoo);
        dao.setarPoltronaEmCompra(idPoltronas,tipoVoo);

        //Esse cara vai guardar todas as poltronas que forem escolhidas pelo usuário.
        List<Poltrona> poltronasUsuarioAlterada = new ArrayList<>();

//        session.removeAttribute("poltronasUsuario");
        session.setAttribute("poltronasUsuarioAlterada",poltronasUsuarioAlterada);


        if (tipoVoo.equals("IDA")){
//            Poltrona poltronaEscolhidas = dao.buscarPoltronaPeloId(idPoltrona);
            List<Poltrona> poltronasEscolhidas = dao.buscarPoltronasPeloId(idPoltronas);
            voo.setPoltrona(poltronasEscolhidas);
            poltronasUsuarioAlterada.addAll(poltronasEscolhidas);
            passageiroEmQuestao.setPoltronasReservadas(poltronasEscolhidas);
            session.setAttribute("poltronasUsuarioIdaAlterado",poltronasEscolhidas);
        } else if (tipoVoo.equals("VOLTA")){
            List<Poltrona> poltronasEscolhidas = dao.buscarPoltronasPeloId(idPoltronas);
            voo.setPoltrona(poltronasEscolhidas);
            poltronasUsuarioAlterada.addAll(poltronasEscolhidas);
            passageiroEmQuestao.setPoltronasReservadas(poltronasEscolhidas);
            session.setAttribute("poltronasUsuarioVoltaAlterado",poltronasEscolhidas);
        }
        session.setAttribute("poltronasUsuarioAlterado",poltronasUsuarioAlterada);
        session.setAttribute("passageiroEmQuestao",passageiroEmQuestao);
        List<Passageiro> passageirosNaCompra= (List<Passageiro>) session.getAttribute("passageirosNaCompra");

        List<Passageiro> passageirosNaCompraAtualizado = new ArrayList<>();
        for(Passageiro passageiro: passageirosNaCompra){
            if(passageiro.getId() != passageiroEmQuestao.getId()){
                passageirosNaCompraAtualizado.add(passageiro);
            }
        }
        passageirosNaCompraAtualizado.add(passageiroEmQuestao);
        passageirosNaCompra = passageirosNaCompraAtualizado;
        session.setAttribute("passageirosNaCompra",passageirosNaCompra);

        RequestDispatcher dispatcher = request.getRequestDispatcher("telaUsuario.jsp");
        dispatcher.forward(request, response);


    }
}
