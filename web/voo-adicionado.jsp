<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Voo Adicionado</title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <jsp:include page="imports-design.jsp"></jsp:include>
    <div class="container" align="center">
        <br>
        <h5> Voo adicionado ao carrinho.</h5>
        <br>
        <c:choose>
            <c:when test="${empty sessionScope.numeroAdultos}">
                <h5> Informe o numero de adultos que irão compor esta compra</h5>
                <form action="adicionarPassageiros" method="post">
                    <div class="row">
                        <div class="input-field col s3 m3 l3" style="margin-left: 37%">
                            <input placeholder="Numero de Adultos" name="numeroAdultos" type="number" required>
                        </div>
                    </div>
                    <button type="submit" class="btn waves-effect waves-teal purple">Confirmar número de Adultos</button>
                </form>
            </c:when>
            <c:otherwise>
                <p style="font-family: 'Arial Black'; font-size: 20px"> Número de passageiros informado: ${sessionScope.numeroAdultos}</p>
                <h5> O que você deseja fazer? </h5>
                <br>
                <form action="carrinho-de-compras.jsp" method="post">
                    <button type="submit" class="btn waves-effect waves-teal orange">Ir para o carrinho</button>
                </form>
                <form action="escolher-poltronas.jsp" method="post">
                    <button type="submit" class="btn waves-effect waves-teal blue">Escolher Poltrona</button>
                </form>
                <br>
                <a href="index.jsp" class="waves-effect waves-light btn green"> Adicionar mais voos </a>
            </c:otherwise>
        </c:choose>


    </div>
</body>
</html>
