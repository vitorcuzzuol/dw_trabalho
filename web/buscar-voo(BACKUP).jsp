<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
- Clientes não poderão comprar passagens no mesmo dia
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pesquisar Voos</title>

    <%--Imports do framework Materialize e Jquery. No import, temos que capturar o CSS e o JavaScript --%>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="assets/plugins/materialize/css/materialize.min.css">
    <link rel="stylesheet" href="assets/plugins/jquery-ui-1.12.1.custom/jquery-ui.css">
    <script src="assets/plugins/jquery-ui-1.12.1.custom/external/jquery/jquery.js"></script>
    <script src="assets/plugins/jquery-ui-1.12.1.custom/jquery-ui.js"></script>
    <script src="assets/plugins/materialize/js/materialize.min.js"></script>

    <!-- Aqui desenvolvi um CSS na mão mesmo, para centralizar o conteúdo da página. -->
    <style>
        .designForm{
            align-content: center;
            padding-left: 420px;
        }
    </style>

</head>
<body>
    <!-- Uso do container para centralizar todo o conteudo da pagina -->
    <div class="container">
        <div align="center">

            <!--Reparar na chamada do URL Pattern da servlet, lá no arquivo web.xml -->
            <form action="buscarVooPersonalizado">
                <br/>
                <!-- Classe CSS configurada para centralizar o conteúdo -->
                <div class="designForm">
                    <!-- Captura de data -->
                    <div class="row">
                        <div class="col s3 m3 l3">
                            <label>DATA DE IDA</label>
                            <input type="date" class="datepicker" name="dataIda" title="dataIda">
                        </div>
                        <div class="col s3 m3 l3">
                            <label>DATA DE VOLTA</label>
                            <input type="date" class="datepicker" name="dataVolta" title="dataVolta">
                        </div>
                    </div>
                    <!-- Captura de Origem -->
                    <div class="row">
                        <div class="col s3 m3 l3">
                            <div class="row">
                                <div class="input-field col s12">
                                    <input type="text" id="autocomplete-input" class="autocomplete" name="localOrigem">
                                    <label for="autocomplete-input">Origem</label>
                                </div>
                            </div>
                        </div>

                    <!-- Captura de Destino -->

                        <div class="col s3 m3 l3">
                            <div class="row">
                                <div class="input-field col s12">
                                    <input type="text" id="autocomplete-input2" class="autocomplete" name="localDestino">
                                    <label for="autocomplete-input2">Destino</label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Escolha de classe do assento -->
                    <div class="row">
                        <div class="input-field col s3 m3 l3" style="margin-left: 14%">
                                <select name="classe">
                                    <option value="1">Economica</option>
                                    <option value="2">Executiva</option>
                                    <option value="3">Primeira Classe</option>
                                </select>
                            <label>Classe Voo</label>
                        </div>

                    </div>
                </div>
                <button type="submit" class="btn waves-effect waves-teal">Buscar</button></td>
            </form>
        </div>

        <h3>Voos Confirmados</h3>

            <table class="striped bordered" >
                <!-- Colunas -->
                <thead>
                    <tr>
                        <th>Número do Voo</th>
                        <th>Data Ida</th>
                        <th>Data Volta</th>
                        <th>Origem</th>
                        <th>Destino</th>
                        <th>Classe</th>
                        <th>Preço</th>
                    </tr>
                </thead>
                <!-- Linhas -->
                <!-- Aqui criamos um Bean (Instância) da classe DAO e no foreach definimos uma variável que vai receber o retorno de algum método da classe.
                    Nesse caso, "retornarTodosOsVoos", que é uma lista. -->
                <jsp:useBean id="dao" class="br.com.uff.service.Dao"/>
                <c:forEach var="voo" items="${dao.retornarTodosOsVoos()}">
                <tbody >
                    <tr>
                        <td>${voo.id}</td>
                        <td>${voo.dataIda}</td>
                        <td>${voo.dataVolta}</td>
                        <td>${voo.localSaida}</td>
                        <td>${voo.localDestino}</td>
                        <td>${voo.classe.tipoClasse}</td>
                        <td>${voo.classe.preco} </td>
                        <th> <a class="btn-floating waves-effect waves-light blue"><i class="material-icons">add</i></a> </th>
                    </tr>
                </tbody>
            </table>
        </c:forEach>
        <br/>
        <form action="index.jsp">
            <div align="center">
                <button class="btn waves-effect waves-light red" type="submit"> Voltar <i class="material-icons right">call_missed</i></button>
            </div>
        </form>
    </div>

<script>
//  Inicialização dos módulos de Javascript
    $(document).ready(function() {
        $('select').material_select();
    });

//  Chamada da função de autocomplete dos locais de origem e destino
    $( function() {
        var availableTags = [
            "Rio de Janeiro",
            "Sao Paulo",
            "Recife",
            "Belo Horizonte",
            "Salvador",
            "Vitoria",
            "Natal"
        ];
        $( "#locais" ).autocomplete({
            source: availableTags
        });
    } );
</script>

</body>
</html>



<!--
        EXPLICAÇÃO JSTL, FOREACH
https://www.caelum.com.br/apostila-java-web/usando-taglibs/#7-6-foreach

-->
