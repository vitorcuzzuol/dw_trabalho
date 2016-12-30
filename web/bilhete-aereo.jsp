<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bilhete Aereo</title>
    <jsp:include page="imports-design.jsp"></jsp:include>
    <jsp:include page="header.jsp"/>
</head>
<body>

    <jsp:useBean id="dao" class="br.com.uff.service.Dao"></jsp:useBean>
    <c:forEach var="passageiro" items="${sessionScope.passageirosNaCompra}" >
        <c:if test="${requestScope.passageiroEmCheckin.cpf.equals(passageiro.cpf)}">
            <c:forEach var="voo" items="${passageiro.getVoos()}">
                <c:forEach var="poltrona" items="${requestScope.passageiroEmCheckin.poltronasReservadas}" >
                    <c:if test="${poltrona.voo.id == voo.id}">
                        <div class="row" align="center" style="padding-left: 34%">
                            <div class="col s12 m6" >
                                <div class="card blue-grey darken-1">
                                    <div class="card-content white-text">
                                        <span class="card-title">Cartao de Embarque de ${passageiro.nome}</span>
                                        <p style="font-family: 'Verdana';color: #ffffff; font-size: 19px"> Dados do Passageiro e Voo:</p><br>
                                        <p style="font-family: 'Verdana';color: #ffffff; font-size: 15px">Voo: ${voo.id} </p><br>
                                        <p style="font-family: 'Verdana';color: #ffffff; font-size: 15px">Local de Origem: ${voo.localOrigem} </p><br>
                                        <p style="font-family: 'Verdana';color: #ffffff; font-size: 15px">Local de Destino: ${voo.localDestino} </p><br>
                                        <p style="font-family: 'Verdana';color: #ffffff; font-size: 15px"> Poltrona(s) : ${poltrona.idPoltrona}</p><br>
                                        <p style="font-family: 'Verdana';color: #ffffff; font-size: 15px">Telefone: ${passageiro.telefone} </p><br>
                                        <p style="font-family: 'Verdana';color: #ffffff; font-size: 15px">CPF:  ${passageiro.cpf}</p><br>
                                        <p style="font-family: 'Verdana';color: #ffffff; font-size: 15px">Nacionalidade: ${passageiro.nacionalidade}</p><br>
                                        <p style="font-family: 'Verdana';color: #ffffff; font-size: 15px">Deficiente? ${passageiro.deficiente}</p><br>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </c:forEach>
        </c:if>
    </c:forEach>
    <br><br>
    <div class="row" style="padding-left: 43%">
        <form action="telaUsuario.jsp" method="post">
            <button type="submit" class="btn waves-effect waves-teal red">Voltar para Tela do Usuario</button></td>
        </form>
    </div>

</body>
</html>
