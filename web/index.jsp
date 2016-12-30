<%@ page import="br.com.uff.model.Voo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%--
- Clientes não poderão comprar passagens no mesmo dia
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pesquisar Voos</title>

    <jsp:include page="imports-design.jsp"></jsp:include>

    <!-- Aqui desenvolvi um CSS na mão mesmo, para centralizar o conteúdo da página. -->
    <style>
        .designForm{
            align-content: center;
            padding-left: 25%;
        }
    </style>

</head>
<body>
    <!--Scriptlet para criar lista de voos no carrinho. Esse carrinho será uma variável na sessão. -->
    <!--JSTL estava dando erro na criação... -->
    <%
        if(session.getAttribute("carrinho") == null){
            session.setAttribute("carrinho", new ArrayList<Voo>());
        }
        List<Voo> carrinho = (List<Voo>) session.getAttribute("carrinho");
    %>

    <jsp:include page="header.jsp"/>

    <br>
    <!-- Uso do container para centralizar todo o conteudo da pagina -->
        <div align="center">
            <!--Reparar na chamada do URL Pattern da servlet, lá no arquivo web.xml -->
            <h3 align="center" style="margin-left: 30%">Filtro de voo</h3>
            <form action="buscarVooPersonalizado" method="post" style="">
                <br/>
                <!-- Classe CSS configurada para centralizar o conteúdo -->
                <div class="designForm">
                    <!-- Captura de data -->
                    <div class="row">
                        <div class="col s4 m4 l4">
                            <label>DATA DE IDA</label>
                            <input type="date" class="datepicker" name="dataIda" title="dataIda" required>
                        </div>
                        <div class="col s4 m4 l4">
                            <label>DATA DE VOLTA</label>
                            <input type="date" class="datepicker" name="dataVolta" title="dataVolta" required>
                        </div>
                    </div>
                    <!-- Captura de Origem -->
                    <div class="row">
                        <div class="input-field col s4 m4">
                            <select name="localOrigem">
                                <option value="Rio de Janeiro">Rio de Janeiro</option>
                                <option value="Sao Paulo">Sao Paulo</option>
                                <option value="Bahia">Bahia</option>
                                <option value="Maranhao">Maranhao</option>
                            </select>
                            <label>Local de Saída</label>
                        </div>
                        <!-- Captura de Destino -->
                        <div class="input-field col s4 m4">
                            <select name="localDestino">
                                <option value="Sao Paulo">Sao Paulo</option>
                                <option value="Santa Catarina">Santa Catarina</option>
                                <option value="Bangkok">Bangkok</option>
                                <option value="Miami">Miami</option>
                                <option value="Curitiba">Curitiba</option>
                                <option value="Londres">Londres</option>
                                <option value="Nova Zelandia">Nova Zelandia</option>
                                <option value="Mexico">Mexico</option>
                                <option value="Maranhao">Maranhao</option>
                                <option value="Bahia">Bahia</option>
                            </select>
                            <label>Local de Destino</label>
                        </div>
                    </div>
                </div>
                <button type="submit" class="btn waves-effect waves-teal">Filtrar Voos</button></td>
            </form>
        </div>

        <h3 align="center">Voos existentes no sistema</h3>
        <table class="striped bordered" style="table-layout: fixed; width:100%;">
            <!-- Colunas -->
            <thead>
            <tr>
                <th>Número do Voo</th>
                <th>Data Voo</th>
                <th>Origem</th>
                <th>Destino</th>
                <th>Preço</th>
                <th>Comprar</th>
            </tr>
            </thead>
            <!-- Aqui criamos um Bean (Instância) da classe DAO e no foreach definimos uma variável que vai receber o retorno de algum método da classe.
            Nesse caso, "retornarTodosOsVoos", que é uma lista. -->
            <jsp:useBean id="dao" class="br.com.uff.service.Dao"/>
            <c:forEach var="voo" items="${dao.retornarTodosOsVoos()}">
                <!-- Detalhe que não é importante, apenas para fins de layout da tabela. -->
                <thead>
                <th></th>
                </thead>
                <!-- Linhas -->
                <tbody >
                    <tr>
                        <td>${voo.id}</td>
                        <td><fmt:formatDate value="${voo.data}" pattern="dd/MM/yyyy" /></td>
                        <td>${voo.localOrigem}</td>
                        <td>${voo.localDestino}</td>
                        <td>${voo.preco}</td>
                        <th> <a href="/adicionarVoo?id=${voo.id}" name="vooId" class="btn-floating waves-effect waves-light blue"><i class="material-icons">add</i></a> </th>
                    </tr>
                </tbody>
            </c:forEach>
        </table>
        <br/>

<script>
//  Inicialização dos módulos de Javascript
    $(document).ready(function() {
        $('select').material_select();
    });



</script>

</body>
</html>

<!--
        EXPLICAÇÃO JSTL, FOREACH
https://www.caelum.com.br/apostila-java-web/usando-taglibs/#7-6-foreach

-->
