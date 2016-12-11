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
        <h5> O que você deseja fazer? </h5>
        <br>
        <form action="carrinho-de-compras.jsp" method="post">
            <button type="submit" class="btn waves-effect waves-teal orange">Ir para o carrinho</button></td>
        </form>
        <form action="" method="post">
            <button type="submit" class="btn waves-effect waves-teal blue">Escolher Poltrona</button></td>
        </form>
        <br>
        <a href="index.jsp" class="waves-effect waves-light btn green"> Adicionar mais voos </a> </th>

    </div>
</body>
</html>
