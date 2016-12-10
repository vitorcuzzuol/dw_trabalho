<%@ page import="br.com.uff.model.Voo" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pesquisar Voos</title>

    <jsp:include page="imports-design.jsp"></jsp:include>

    <!-- Aqui desenvolvi um CSS na mão mesmo, para centralizar o conteúdo da página. -->
    <style>
        .designForm{
            align-content: center;
            padding-left: 420px;
        }
    </style>

</head>
<body>

    <jsp:include page="header.jsp"/>
    <%
        List<Voo> carrinho = (List<Voo>) session.getAttribute("carrinho");
    %>
    <c:choose>
        <c:when test="${sessionScope.voosIda.isEmpty() and sessionScope.voosVolta.isEmpty()}">
            <div align="center">
                <h3 style="align-items: center"> Nenhum voo encontrado. </h3>
            </div>

            <form action="index.jsp">
                <div align="center">
                    <button class="btn waves-effect waves-light red" type="submit"> Voltar <i class="material-icons right">call_missed</i></button>
                </div>
            </form>
        </c:when>

        <c:otherwise>
            <h3 align="center"> Voos encontrados para Ida: </h3>
            <table class="striped bordered" style="table-layout: fixed">
                <!-- Colunas -->
                <thead>
                <tr>
                    <th>Número do Voo</th>
                    <th>Data Voo</th>
                    <th>Origem</th>
                    <th>Destino</th>
                    <th>Preço</th>
                    <th>Comprar</th>
                </tr>
                </thead>
                <!-- Aqui criamos um Bean (Instância) da classe DAO e no foreach definimos uma variável que vai receber o retorno de algum método da classe.
                Nesse caso, "retornarTodosOsVoos", que é uma lista. -->

                <c:forEach var="voo" items="${requestScope.voosIda}">
                    <!-- Detalhe que não é importante, apenas para fins de layout da tabela. -->
                    <thead>
                    <th></th>
                  </thead>
                    <!-- Linhas -->
                    <tbody >
                    <tr>
                        <td>${voo.id}</td>
                        <td><fmt:formatDate value="${voo.data}" pattern="dd/MM/yyyy" /></td>
                        <td>${voo.localOrigem}</td>
                        <td>${voo.localDestino}</td>
                        <td>${voo.preco}</td>
                        <th> <a class="btn-floating waves-effect waves-light blue"><i class="material-icons">add</i></a> </th>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>

            <h3 align="center"> Voos encontrados para a Volta: </h3>
            <table class="striped bordered" style="table-layout: fixed">
                <!-- Colunas -->
                <thead>
                <tr>
                    <th>Número do Voo</th>
                    <th>Data Voo</th>
                    <th>Origem</th>
                    <th>Destino</th>
                    <th>Preço</th>
                    <th>Comprar</th>
                </tr>
                </thead>
                <!-- Aqui criamos um Bean (Instância) da classe DAO e no foreach definimos uma variável que vai receber o retorno de algum método da classe.
                Nesse caso, "retornarTodosOsVoos", que é uma lista. -->

                <c:forEach var="voo" items="${requestScope.voosVolta}">
                    <!-- Detalhe que não é importante, apenas para fins de layout da tabela. -->
                    <thead>
                    <th></th>
                    </thead>
                    <!-- Linhas -->
                    <tbody >
                    <tr>
                        <td>${voo.id}</td>
                        <td><fmt:formatDate value="${voo.data}" pattern="dd/MM/yyyy" /></td>
                        <td>${voo.localOrigem}</td>
                        <td>${voo.localDestino}</td>
                        <td>${voo.preco}</td>
                        <th> <a href="/adicionarVoo?id=${voo.id}" name="vooId" class="btn-floating waves-effect waves-light blue"><i class="material-icons">add</i></a> </th>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>

            <br/>
            <form action="index.jsp">
                <div align="center">
                    <button class="btn waves-effect waves-light red" type="submit"> Voltar <i class="material-icons right">call_missed</i></button>
                </div>
            </form>
        </c:otherwise>
    </c:choose>

<script>
//  Inicialização dos módulos de Javascript
    $(document).ready(function() {
        $('select').material_select();
    });
</script>

</body>
</html>

