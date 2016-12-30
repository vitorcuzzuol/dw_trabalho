<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav role="navigation" style="background-color: #26a69a;">
    <div class="nav-wrapper container"><a id="logo-container" href="index.jsp" class="brand-logo">Viajando.com</a>
        <ul class="right hide-on-med-and-down">
            <c:choose>
                <c:when test="${not empty sessionScope.usuarioLogado}">
                    <li><a href="telaUsuario.jsp">Usuário: ${sessionScope.usuarioLogado.getNome()}</a></li>
                    <li><a href="#"><form action="logout" method="post" name="logoutForm" onclick="javascript:document.logoutForm.submit();">Sair</form></a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="login.jsp" onclick="javascript:document.loginForm.submit();">Login</a>
                    </li>
                </c:otherwise>
            </c:choose>
            <li> <a href="carrinho-de-compras.jsp"><i class="large material-icons" style="color:white;">shopping_cart</i>${carrinho.size()} vôos selecionados.</a></li>
        </ul>
    </div>
</nav>
