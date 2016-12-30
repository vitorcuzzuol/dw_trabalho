<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pagamento Sucesso</title>
    <jsp:include page="imports-design.jsp"></jsp:include>
    <jsp:include page="header.jsp"/>
    <style>
        .designForm{
            align-content: center;
            padding-left: 25%;
        }
    </style>
</head>
<body>
    <div class="container">
        <p style="font-family: 'Arial Black'; font-size: 15px">Pagamento Efetuado com sucesso! </p>
        <br>
        <p style="font-family: 'Arial Black'; font-size: 15px">Guardamos os seus dados. Para verificá-los, continue pelo link abaixo. </p>
        <br>
        <form action="telaUsuario.jsp" method="post" class="designForm">
            <button type="submit" class="btn waves-effect waves-teal blue">Acessar Tela do Usuário</button></td>
        </form>
    </div>


    <script>
        $(document).ready(function() {
            $('select').material_select();
        });
    </script>
</body>
</html>
