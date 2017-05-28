<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%--
- Clientes não poderão comprar passagens no mesmo dia
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Couch&Running</title>

    <!-- Aqui desenvolvi um CSS na mão mesmo, para centralizar o conteúdo da página. -->
    <style>
        .designForm{
            align-content: center;
            padding-left: 25%;
        }
    </style>

</head>
<body>
<h1>Couch&Running</h1>
    <!-- Uso do container para centralizar todo o conteudo da pagina -->
        <div align="center">
          <a href="login.jsp">
              <button type="button">Entrar</button>
          </a>
          <a href="login.jsp">
              <button type="button">Cadastre-se</button>
          </a>
        </div>
</body>
</html>

<!--
        EXPLICAÇÃO JSTL, FOREACH
https://www.caelum.com.br/apostila-java-web/usando-taglibs/#7-6-foreach

-->
