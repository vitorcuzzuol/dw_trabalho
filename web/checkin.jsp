
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Check-in</title>
    <jsp:include page="imports-design.jsp"></jsp:include>
    <jsp:include page="header.jsp"/>
</head>
<body>
<!-- Código da reserva = cpfUsuario
 -->
    <div class="container" align="center">
            <div class="row">
                <form action="checkin" method="post">
                    <h5> Entre com o código da sua reserva </h5><br>
                    <div class="input-field col s3 M3 L3">
                        <input id="nome" type="text" class="validate" name="idReserva">
                        <label for="nome">Código da Reserva</label>
                        <button type="submit" class="btn waves-effect waves-teal blue">Confirmar Check-In</button>
                        <br><br>
                        <a href="telaUsuario.jsp" class="waves-effect waves-light btn red"> Voltar</a>
                        <br><br>
                        <p style="font-family: 'Arial Black'; font-size: 15px">${mensagemRetorno}</p>
                    </div>
                </form>
        </div>
    </div>
</body>
</html>
