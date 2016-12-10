<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Central do Usuário</title>
    <jsp:include page="imports-design.jsp"></jsp:include>
    <Style>
        .center {
        text-align: center;
        }
    </Style>
</head>
<body>


    <c:if test="${not empty sessionScope.usuarioLogado}">
        <div class="center">
            <br>
            <br>
            <!-- Aqui o parâmetro usuarioLogado foi setado na servlet Login, onde passamos um objeto Usuario. Assim, podemos chamar o método getNome() -->
            <p> Usuário Logado: ${sessionScope.usuarioLogado.getNome()}</p>
            <br>
            <p> Buscar vôo</p>
            <form action="index.jsp" method="post">
                <input type="submit" value="Buscar"/>
            </form>
            <br>
            <p> Check-in</p>
            <form action="checkin.jsp" method="post">
                <input type="submit" value="Check-In"/>
            </form>
            <br>
            <p> Alterar assentos do vôo</p>
            <form action="alterarPoltrona.jsp" method="post">
                <input type="submit" value="Alterar Poltrona"/>
            </form>
            <br>
            <form action="logout" method="post">
                <input type="submit" value="Sair"/>
            </form>
            <br>
            <p> Vôo Adquirido </p>
            ---------------------
            Tabela de voos comprados
            ---------------------
        </div>
    </c:if>

    <c:if test="${empty sessionScope.usuarioLogado}">
        <c:redirect url="login.jsp"/>
    </c:if>


</body>
</html>
