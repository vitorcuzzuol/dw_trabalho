<!-- O IntelliJ importa automaticamente o caminho java.sun.com/jstl/fmt, mas o correto é : java.sun.com/jsp/jstl/fmt -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

<head>
    <title>Meu Carrinho</title>

</head>
    <jsp:include page="imports-design.jsp"></jsp:include>
    <jsp:useBean id="dao" class="br.com.uff.service.Dao" scope="session"/>

</head>
<body>
    <jsp:include page="header.jsp"/>

    <c:if test="${empty sessionScope.carrinho}">
        <!-- Caso não exista nenhum voo no carrinho -->
        <div class="container">
            <p align="center" style="padding: 10%;font-size: 20px; font-family: 'Arial Black'"> Nenhum voo selecionado </p>
        <form action="index.jsp">
            <div align="center">
                <button class="btn waves-effect waves-light red" type="submit"> Escolher um Voo <i class="material-icons right">call_missed</i></button>
            </div>
        </form>
        </div>
    </c:if>

    <c:if test="${not empty sessionScope.carrinho}">
        <h3 align="center"> Voos selecionados até o momento:  </h3>
        <table class="striped bordered" style="table-layout: fixed">
            <!-- Colunas -->
            <thead>
            <tr>
                <th>Número do Voo</th>
                <th>Data Voo</th>
                <th>Origem</th>
                <th>Destino</th>
                <th>Preço</th>
                <th>Remover</th>
            </tr>
            </thead>

            <c:forEach var="vooCarrinho" items="${sessionScope.carrinho}">
                <!-- Detalhe que não é importante, apenas para fins de layout da tabela. -->
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
                    <td>${vooCarrinho.preco}</td>
                    <td> <a href="/removerVoo?id=${vooCarrinho.id}" name="vooId" class="btn-floating waves-effect waves-light red"><i class="material-icons">delete</i></a> </td>
                    <c:set var="precoTotalVoos" scope="session" value="${(sessionScope.precoTotalVoos + vooCarrinho.preco)}"> </c:set> <!-- Incrementa o contador do preço total dos voos, na session. -->
                </tr>
                </tbody>
            </c:forEach>
        </table>
        <p align="center" style="font-size: 20px; font-family: 'Arial Black'"> Preço total de Voos, com taxas inclusas: <td> R$ ${dao.calcularPrecoVoos(sessionScope.carrinho)}</td> </p>
        <p align="center" style="font-family: 'Arial'; font-size: 20px"> Número de passageiros informado: ${sessionScope.numeroAdultos}</p>

        <br>
        <div align="center">
            <form action="escolher-poltronas.jsp" method="post">
                <button type="submit" class="btn waves-effect waves-teal blue">Escolher Poltronas</button></td>
            </form>
        </div>
        <br>
        <form action="index.jsp">
            <div align="center">
                <button class="btn waves-effect waves-light red" type="submit"> Voltar para a tela inicial <i class="material-icons right">call_missed</i></button>
            </div>
        </form>
    </c:if>

</body>
</html>
