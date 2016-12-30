<%@ page import="br.com.uff.model.Poltrona" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pagamento</title>
    <jsp:include page="imports-design.jsp"></jsp:include>
    <script src="assets/plugins/jQuery-Formatter/lib/jquery.formatter.min.js"></script>
    <jsp:include page="header.jsp"/>

    <style>
        .designForm{
            align-content: center;
            padding-left: 25%;
        }
    </style>

</head>
<body>
    <c:choose>
        <c:when test="${not empty sessionScope.usuarioLogado}">
            <div class="container">
                <div class="designForm">
                    <h5> Entre com seus dados</h5>
                    <h5> Escolha sua poltrona</h5>
                    <h5> Informe o número do cartão de crédito </h5>
                    <p align="center" style="font-size: 20px; font-family: 'Arial Black'"> ${mensagemRetornoPoltrona} </p>
                    <jsp:useBean id="dao" class="br.com.uff.service.Dao" scope="session"/>
                    <form action="validarPagamento" method="post" class="col s10 m10 l10">
                        <c:forEach var="i" begin="1" end="${sessionScope.numeroAdultos}">
                            <p align="center" style="font-size: 20px; font-family: 'Arial Black'"> Passageiro ${i} </p>
                            <div class="row">
                                <div class="input-field col s10 m10 l10">
                                    <i class="material-icons prefix">account_circle</i>
                                    <input id="nome" type="text" class="validate" name="nome${i}">
                                    <label for="nome">Nome Completo:</label>
                                </div>
                                <br>
                                <div class="input-field col col s10 m10 l10">
                                    <i class="material-icons prefix">phone</i>
                                    <input type="text" class="validate" name="telefone${i}" id="telefone">
                                    <label for="telefone">Telefone</label>
                                </div>
                                <br>
                                <div class="input-field col s10 m10 l10">
                                    <i class="material-icons prefix">&#xE069;</i>
                                    <input id="nacionalidade" type="text" class="validate" name="nacionalidade${i}">
                                    <label for="nacionalidade">Nacionalidade</label>
                                </div>
                                <br>
                                <div class="input-field col s10 m10 l10">
                                    <i class="material-icons prefix">&#xE060;</i>
                                    <input id="cpf" type="number" class="validate" name="cpf${i}">
                                    <label for="cpf">CPF</label>
                                </div>
                                <br>
                                <div class="input-field col s10 m10 l10">
                                    <i class="material-icons prefix">&#xE914;</i>
                                    <select class="validate" name="deficiente${i}">
                                        <option value="Nao">Não</option>
                                        <option value="Sim">Sim</option>
                                    </select>
                                    <label>Deficiente</label>
                                </div>
                                <div class="input-field col s10 m10 l10">
                                    <div class="row">
                                        <p style="font-size: 10px; font-family: 'Arial Black'; padding-left: 40%"> Poltrona(s) Selecionada(s)</p>
                                    </div>
                                    <i class="material-icons prefix">&#xE8F8;</i>
                                    <select multiple name="poltronasPassageiro${i}">
                                    <br>
                                    <c:forEach var="poltronasDisponiveis" items="${sessionScope.poltronasUsuario}">
                                        <option value="${poltronasDisponiveis.idPoltrona}">${poltronasDisponiveis.idPoltrona} -- ${poltronasDisponiveis.getClasse().getTipoClasse().getDescricao()}</option>
                                    </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </c:forEach>
                        <div class="row" style="padding-left: 30%">
                            <div class="input-field col s6">
                                <input id="creditCard" type="text" name="cartaoDeCredito">
                                <label for="creditCard" class="active">Credit Card</label>
                                <button type="submit" class="btn waves-effect waves-teal blue">Confirmar Pagamento</button></td>
                                <p align="center" style="font-size: 15px; font-family: 'Arial Black'"> ${mensagemRetornoCartao} </p>
                            </div>
                        </div>
                    </form>
                    <br><br><br><br><br><br><br><br><br><br><br><br>
                </div>
            </div>
        </c:when>
        <c:otherwise>
            <c:redirect url="login.jsp"/>
        </c:otherwise>
    </c:choose>



<script>
    $(document).ready(function() {
        $('select').material_select();
    });

    $('#creditCard').formatter({
        'pattern': '{{9999}}-{{9999}}-{{9999}}-{{9999}}'
    });

    $('#telefone').formatter({
        'pattern': '{{9999}}-{{9999}}'
    });

</script>

</body>
</html>
