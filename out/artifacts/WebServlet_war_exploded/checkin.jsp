
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Check-in</title>
</head>
<body>
    <div align="center">
        <p> Para efetuar seu checkin, primeiramente você deve inserir o código referente ao seu vôo.</p><br>
        <h3> Entre com o código da sua reserva </h3><br>
        <form action="checkin-usuario" method="post">
            Código: <input type="text" name="id-reserva"><br><br>
            <input type="submit" value="Fazer Check-In"/>
        </form><br><br>
        <form action="index.jsp">
            <input type="submit" value="Voltar para o Menu">
        </form>
    </div>
</body>
</html>
