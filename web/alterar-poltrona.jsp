<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Alterar Poltrona</title>
    <jsp:include page="imports-design.jsp"></jsp:include>
    <jsp:include page="header.jsp"/>
</head>
<body>

<h5 align="center">Alteração de Poltronas</h5>
<br>

<table class="striped bordered" style="table-layout: fixed">
    <!-- Colunas -->
    <thead>
    <tr>
        <th>Passageiro</th>
        <th>Número do Voo</th>
        <th>Data Voo</th>
        <th>Origem</th>
        <th>Destino</th>
        <th>Número Poltrona</th>
    </tr>
    </thead>
    <c:forEach var="vooCarrinho" items="${sessionScope.carrinho}">
        <thead>
        <th></th>
        </thead>
        <!-- Linhas -->
        <tbody >
        <tr>
            <td>${sessionScope.passageiroEmQuestao.nome}</td>
            <td>${vooCarrinho.id}</td>
            <td><fmt:formatDate value="${vooCarrinho.data}" pattern="dd/MM/yyyy" /></td>
            <td>${vooCarrinho.localOrigem}</td>
            <td>${vooCarrinho.localDestino}</td>
            <jsp:useBean id="dao" class="br.com.uff.service.Dao"/>
            <c:if test="${vooCarrinho.tipoVoo eq 'IDA'}">

                    <td>
                        <form action="adicionarPoltronaAlterada" method="post">
                            <div class="input-field col s12" style="padding-right: 15%">
                                <div class="input-field col s12">
                                    <select multiple name="idPoltrona">
                                        <c:forEach var="poltronasDisponiveis" items="${dao.buscarPoltronaIdaDisponivelVoo(vooCarrinho.id)}">
                                            <option value="${poltronasDisponiveis.idPoltrona}">${poltronasDisponiveis.idPoltrona} -- ${poltronasDisponiveis.getClasse().getTipoClasse().getDescricao()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <input type="hidden" name="vooId" value="${vooCarrinho.id}"/>
                                <input type="hidden" name="tipoVoo" value="${vooCarrinho.tipoVoo}"/>
                                <button type="submit" name="adicionarPoltronaAlterada" class="btn-floating waves-effect waves-light blue"><i class="material-icons">add</i></button>
                            </div>
                        </form>
                    </td>

            </c:if>
            <c:if test="${vooCarrinho.tipoVoo eq 'VOLTA'}">
                    <td>
                        <form action="escolherPoltrona" method="post">
                            <div class="input-field col s12" style="padding-right: 15%">
                                <div class="input-field col s12">
                                    <select multiple name="idPoltrona">
                                        <c:forEach var="poltronasDisponiveis" items="${dao.buscarPoltronaIdaDisponivelVoo(vooCarrinho.id)}">
                                            <option value="${poltronasDisponiveis.idPoltrona}">${poltronasDisponiveis.idPoltrona} -- ${poltronasDisponiveis.getClasse().getTipoClasse().getDescricao()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <input type="hidden" name="vooId" value="${vooCarrinho.id}"/>
                                <input type="hidden" name="tipoVoo" value="${vooCarrinho.tipoVoo}"/>
                                <button type="submit" name="adicionarPoltronaAlterada" class="btn-floating waves-effect waves-light blue"><i class="material-icons">add</i></button>
                            </div>
                        </form>
                    </td>
                </c:if>

        </tr>
        </tbody>
    </c:forEach>

</table>

<script>
    $(document).ready(function() {
        $('select').material_select();
    });
</script>
</body>
</html>
