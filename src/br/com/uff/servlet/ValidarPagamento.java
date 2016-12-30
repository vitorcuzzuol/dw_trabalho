package br.com.uff.servlet;

import br.com.uff.model.Passageiro;
import br.com.uff.model.Passagem;
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

public class ValidarPagamento extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String cartaoCredito = request.getParameter("cartaoDeCredito");
        if(cartaoCredito.isEmpty()){
            request.setAttribute("mensagemRetornoCartao", "Cartão não informado. Por favor, insira o numero do cartão.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("pagamento.jsp");
            dispatcher.forward(request, response);
        }
        List<Passageiro> passageirosCompra = new ArrayList<>();
        Dao dao = new Dao();


        Integer numeroAdultos = ((Integer) session.getAttribute("numeroAdultos"));
        for (int numeroPassageiro = 1; numeroPassageiro<=numeroAdultos; numeroPassageiro++){
            List<Poltrona> poltronasPassageiro = new ArrayList<>();
            Passageiro passageiro = new Passageiro();

            //Adicionando as poltronas selecionadas para cada passageiro.
            String[] idPoltronas = request.getParameterValues(("poltronasPassageiro" + numeroPassageiro));
            poltronasPassageiro.addAll(dao.buscarPoltronasPeloId(idPoltronas));
            passageiro.setPoltronasReservadas(poltronasPassageiro);

            //Adicionando informações do passageiro.

            passageiro.setId(numeroPassageiro);

            String nomePassageiro = request.getParameter(("nome" + numeroPassageiro));
            passageiro.setNome(nomePassageiro);

            String telefonePassageiro = request.getParameter(("telefone" + numeroPassageiro));
            passageiro.setTelefone(telefonePassageiro);

            String cpfPassageiro = request.getParameter(("cpf" + numeroPassageiro));
            passageiro.setCpf(cpfPassageiro);

            String nacionalidadePassageiro = request.getParameter(("nacionalidade" + numeroPassageiro));
            passageiro.setNacionalidade(nacionalidadePassageiro);

            String deficiente = request.getParameter(("deficiente" + numeroPassageiro));
            passageiro.setDeficiente(deficiente);

            List<Voo> voos = (List<Voo>) session.getAttribute("carrinho");
            for(Voo voo: voos){
                List<Poltrona> poltronasDoVoo = dao.buscarPoltronasVoo(voo);
                List<Poltrona> poltronasDoPassageiro = passageiro.getPoltronasReservadas();
                for(Poltrona poltrona: poltronasDoVoo){
                    for(Poltrona poltrona1: poltronasDoPassageiro){
                        if(poltrona1.getIdPoltrona() == poltrona.getIdPoltrona()){
                            passageiro.setVoos(voo);
                        }
                    }
                }
            }

            passageiro.setIdReserva(passageiro.getCpf());



            passageirosCompra.add(passageiro);
            session.setAttribute("passageirosNaCompra",passageirosCompra);



        }

        //Verificar se algum passageiro não possui poltrona.
        for(Passageiro passageiro: passageirosCompra){
            if(passageiro.getPoltronasReservadas().isEmpty()){
                request.setAttribute("mensagemRetornoPoltrona", "Verifique se todos os usuários possuem pelo menos uma poltrona.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("pagamento.jsp");
                dispatcher.forward(request, response);
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("pagamento-sucesso.jsp");
        dispatcher.forward(request, response);


    }
}
