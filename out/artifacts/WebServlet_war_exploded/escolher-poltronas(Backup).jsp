<%@ page import="br.com.uff.model.Poltrona" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Escolher Poltronas</title>
    <jsp:include page="imports-design.jsp"></jsp:include>
    <jsp:include page="header.jsp"/>
    <%--<c:set var="precoTotalVoos" scope="session" value="${(sessionScope.precoTotalVoos - sessionScope.precoTotalVoos)}"> </c:set>--%>


</head>
<body>
    <h3 align="center"> Escolha de poltronas </h3>
    <table class="striped bordered" style="table-layout: fixed">
    <!-- Colunas -->
    <thead>
    <tr>
    <th>Número do Voo</th>
    <th>Data Voo</th>
    <th>Origem</th>
    <th>Destino</th>
    <th>Número Poltrona</th>
    </tr>
    </thead>

    <!-- Aqui criamos um Bean (Instância) da classe DAO e no foreach definimos uma variável que vai receber o retorno de algum método da classe.
    Nesse caso, "retornarTodosOsVoos", que é uma lista. -->
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
            <jsp:useBean id="dao" class="br.com.uff.service.Dao"/>
            <c:choose>
                <c:when test="${vooCarrinho.tipoVoo eq 'IDA'}">
                    <c:choose>
                        <c:when test="${empty sessionScope.poltronasUsuarioIda}" >
                            <!-- Pegar poltronas da session. Buscar a poltrona para o avião correto. -->
                            <td>
                                <form action="escolherPoltrona" method="post">
                                    <div class="input-field col s12" style="padding-right: 15%">
                                        <select name="idPoltrona">
                                            <c:forEach var="poltronasDisponiveis" items="${dao.buscarPoltronaIdaDisponivelVoo(vooCarrinho.id)}">
                                                <option value="${poltronasDisponiveis.idPoltrona}">${poltronasDisponiveis.idPoltrona} -- ${poltronasDisponiveis.getClasse().getTipoClasse().getDescricao()}</option>
                                            </c:forEach>
                                        </select>
                                            <%--<button type='submit' name='btn_login' class='col s12 btn btn-large waves-effect indigo'>Login</button>--%>
                                        <input type="hidden" name="vooId" value="${vooCarrinho.id}"/>
                                        <input type="hidden" name="tipoVoo" value="${vooCarrinho.tipoVoo}"/>
                                        <button type="submit" name="adicionarPoltrona" class="btn-floating waves-effect waves-light blue"><i class="material-icons">add</i></button>
                                            <%--<a href="/escolherPoltrona?id=${vooCarrinho.id}" name="vooId" class="btn-floating waves-effect waves-light blue"><i class="material-icons">add</i></a>--%>
                                    </div>
                                </form>
                            </td>
                        </c:when>
                        <c:otherwise>
                            <td>
                                ${sessionScope.poltronasUsuarioIda.getIdPoltrona()}
                            </td>
                        </c:otherwise>
                    </c:choose>
                </c:when>
                <c:otherwise>
                    <c:choose>
                        <c:when test="${empty sessionScope.poltronasUsuarioVolta}">
                            <td>
                                <form action="escolherPoltrona" method="post">
                                    <div class="input-field col s12" style="padding-right: 15%">
                                        <select name="idPoltrona">
                                            <c:forEach var="poltronasDisponiveis" items="${dao.buscarPoltronaVoltaDisponivelVoo(vooCarrinho.id)}">
                                                <option value="${poltronasDisponiveis.idPoltrona}">${poltronasDisponiveis.idPoltrona} -- ${poltronasDisponiveis.getClasse().getTipoClasse().getDescricao()}</option>
                                            </c:forEach>
                                        </select>
                                            <%--<button type='submit' name='btn_login' class='col s12 btn btn-large waves-effect indigo'>Login</button>--%>
                                        <input type="hidden" name="vooId" value="${vooCarrinho.id}"/>
                                        <input type="hidden" name="tipoVoo" value="${vooCarrinho.tipoVoo}"/>
                                        <button type="submit" name="adicionarPoltrona" class="btn-floating waves-effect waves-light blue"><i class="material-icons">add</i></button>
                                            <%--<a href="/escolherPoltrona?id=${vooCarrinho.id}" name="vooId" class="btn-floating waves-effect waves-light blue"><i class="material-icons">add</i></a>--%>
                                    </div>
                                </form>
                            </td>
                        </c:when>
                        <c:otherwise>
                            <td>
                                    ${sessionScope.poltronasUsuarioVolta.getIdPoltrona()}
                            </td>
                        </c:otherwise>
                    </c:choose>
                </c:otherwise>
            </c:choose>
        </tr>
        </tbody>
    </c:forEach>

    </table>
    <p align="center" style="font-size: 20px; font-family: 'Arial Black'"> Preço total:  <td>R$ ${dao.calcularPrecoPoltronas(sessionScope.carrinho,sessionScope.poltronasUsuario)}</td></p>
    <br>


    <c:if test="${dao.escolhaPoltronasFinalizado(sessionScope.carrinho,sessionScope.poltronasUsuario)}">
        <div align="center">
            <form action="pagamento.jsp" method="post">
                <button type="submit" class="btn waves-effect waves-teal blue">Prosseguir para pagamento</button></td>
            </form>
        </div>
    </c:if>


    <form action="carrinho-de-compras.jsp">
        <div align="center">
            <button class="btn waves-effect waves-light red" type="submit"> Voltar para o carrinho <i class="material-icons right">call_missed</i></button>
        </div>
    </form>

<script>
    $(document).ready(function() {
    $('select').material_select();
    });
</script>
</body>
</html>
