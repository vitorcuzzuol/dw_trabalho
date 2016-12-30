<%@ page import="br.com.uff.model.Passageiro" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Central do Usuário</title>
    <jsp:include page="imports-design.jsp"></jsp:include>
    <jsp:include page="header.jsp"/>
    <Style>
        .center {
        text-align: center;
        }
    </Style>
</head>
<body>

    <!--
    Variáveis na Session: "carrinho"                = voos escolhidos na compra.
                          "poltronasUsuario "       = Todas as poltronas, tanto de ida quanto de volta, da compra.
                          "poltronasUsuarioIda"     = Poltronas de Ida escolhidas na compra
                          "poltronasUsuarioVolta"   = Poltronas de volta escolhidas na compra
                          "numeroAdultos"           = Número de adultros escolhidos na compra
                          "passageirosNaCompra"     = Passageiros na compra

    -->

    <c:if test="${not empty sessionScope.usuarioLogado}">
        <div class="center">
            <br>
            <br>

            <jsp:useBean id="dao" class="br.com.uff.service.Dao"/>

            <!--TABELA DE INFORMAÇÕES DOS VOOS E DAS POLTRONAS ESCOLHIDAS -->
            <h5 align="center" style="padding-left: 34%"> Informações do Voo</h5>
            <br>
            <table class="striped bordered" style="table-layout: fixed">
                <!-- Colunas -->
                <thead>
                <tr>
                    <th>Número do Voo</th>
                    <th>Data Voo</th>
                    <th>Origem</th>
                    <th>Destino</th>
                </tr>
                </thead>
                <c:forEach var="vooCarrinho" items="${sessionScope.carrinho}">
                    <thead>
                    <th></th>
                    </thead>
                    <!-- Linhas -->
                    <tbody >
                    <tr>
                        <td>${vooCarrinho.id}</td>
                        <td><fmt:formatDate value="${vooCarrinho.data}" pattern="dd/MM/yyyy" /></td>
                        <td>${vooCarrinho.localOrigem}</td>
                        <td>${vooCarrinho.localDestino}</td>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
            <br><br><br><br>

            <!--TABELA DE PASSAGEIROS -->
            <h5 align="center">Dados do(s) Passageiro(s)</h5>
            <br>
            <table class="striped bordered" style="table-layout: fixed; width:100%;">
                <!-- Colunas -->
                <thead>
                <tr>
                    <th>Nome</th>
                    <th>Telefone</th>
                    <th>CPF</th>
                    <th>Nacionalidade</th>
                    <th>Deficiente</th>
                    <th>Poltrona</th>
                    <th>Alterar Poltrona</th>
                </tr>
                </thead>
                <c:forEach var="passageiro" items="${sessionScope.passageirosNaCompra}" >
                    <!-- Detalhe que não é importante, apenas para fins de layout da tabela. -->
                    <thead>
                    <th></th>
                    </thead>
                    <!-- Linhas -->
                    <tbody >
                    <tr>
                        <td>${passageiro.nome}</td>
                        <td>${passageiro.telefone}</td>
                        <td>${passageiro.cpf}</td>
                        <td>${passageiro.nacionalidade}</td>
                        <td>${passageiro.deficiente}</td>
                        <td>${dao.buscarPoltronasEscolhidasString(passageiro.getPoltronasReservadas())}</td>
                        <th> <a href="/alterarPoltrona?id=${passageiro.id}&idReserva=${passageiro.idReserva}&nome=${passageiro.nome}&poltronasUsuario=${dao.buscarPoltronasEscolhidasString(passageiro.getPoltronasReservadas())}" name="poltronaPassageiro" class="btn-floating waves-effect waves-light blue"><i class="material-icons">&#xE150;</i></a> </th>
                        <%--<th> <a href="/adicionarVoo?id=${voo.id}" name="vooId" class="btn-floating waves-effect waves-light blue"><i class="material-icons">add</i></a> </th>--%>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>

            <br>

            <form action="checkin.jsp" method="post">
                <button type="submit" class="btn waves-effect waves-teal blue">Check-In</button></td>
            </form>
            <br>

            <form action="logout" method="post">
                <button type="submit" class="btn waves-effect waves-teal red">Sair</button></td>
            </form>
            <br><br><br><br>
        </div>
    </c:if>

    <c:if test="${empty sessionScope.usuarioLogado}">
        <c:redirect url="login.jsp"/>
    </c:if>


</body>
</html>
