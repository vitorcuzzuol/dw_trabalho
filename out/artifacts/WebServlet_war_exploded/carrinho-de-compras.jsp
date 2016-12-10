<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

<head>
    <title>Meu Carrinho</title>

</head>
    <jsp:include page="imports-design.jsp"></jsp:include>



</head>
<body>
    <jsp:include page="header.jsp"/>
    <!-- Mostrar voos selecionados -->
    <table class="striped">
        <thead>
        <tr>
            <th data-field="id">Name</th>
            <th data-field="name">Item Name</th>
            <th data-field="price">Item Price</th>
        </tr>
        </thead>

        <tbody>
        <tr>
            <td>Alvin</td>
            <td>Eclair</td>
            <td>$0.87</td>
        </tr>
        <tr>
            <td>Alan</td>
            <td>Jellybean</td>
            <td>$3.76</td>
        </tr>
        <tr>
            <td>Jonathan</td>
            <td>Lollipop</td>
            <td>$7.00</td>
        </tr>
        </tbody>
    </table>

    <!-- Mostrar preços avulsos dos voos-->
    <!-- Mostrar somatório para valor parcial total -->
    <!-- Mostrar link para escolha de poltrona-->


</body>
</html>
