<%@ page import="java.util.List" %>
<%@ page import="br.com.uff.model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%Usuario usuario = (Usuario) session.getAttribute("perfilAmigo");
    Endereco endereco = usuario.getEndereco();%>
<head>
    <title>Couch&Running</title>
</head>
<body>

<h1><%out.println(usuario.getNome());%></h1>
<img src="fotos/<%out.println(usuario.getFoto_perfil());%>">
<br>
<h2>Dados Pessoais:</h2>
<p>E-mail: <%out.println(usuario.getEmail()); %></p>
<p>Data de Nascimento: <%out.println(usuario.getData_nascimento()); %></p>
<p>Esporte Favorito: <%out.println(usuario.getEsporte_fav()); %></p>

<h4>Avaliações de Amigos</h4>
<%
    List<AvaliacaoAmigos> avaliacaoAmigos
            = (List<AvaliacaoAmigos>)session.getAttribute("avaliacaoAmigosPerfil");
    Usuario avaliador;

    for (AvaliacaoAmigos a : avaliacaoAmigos) {
        avaliador = a.getAvaliador();

%>
<tr>
    <td><img src="fotos/<%out.println(avaliador.getFoto_perfil());%>"></td>
    <td><a href="/perfil?id=<%out.println(avaliador.getId());%>"><%out.println(avaliador.getNome());%></a></td>
    <br><td>Nota: <%out.println(a.getNota());%></td>
    <br><td>Descrição: <%out.println(a.getDescricao());%></td>
</tr>
<%}%>
<h4>Avaliações como Hóspede</h4>
<%
    List<AvaliacaoHospedeiroxhospede> avaliacaoHospedeiroxhospedes
            = (List<AvaliacaoHospedeiroxhospede>)session.getAttribute("avaliacaoHospedeiroxhospedePerfil");
    Usuario avaliadorHospedeiro;

    for (AvaliacaoHospedeiroxhospede a : avaliacaoHospedeiroxhospedes) {
        avaliadorHospedeiro = a.getAvaliador();

%>
<tr>
    <td><img src="fotos/<%out.println(avaliadorHospedeiro.getFoto_perfil());%>"></td>
    <td><a href="perfil?id=<%out.println(avaliadorHospedeiro.getId());%>"><%out.println(avaliadorHospedeiro.getNome());%></a></td>
    <br><td>Descrição: <%out.println(a.getDescricao());%></td>
    <br><td>Nota: <%out.println(a.getNota());%></td>
</tr>
<%}%>

<h4>Avaliações como Hospedeiro</h4>
<%
    List<AvaliacaoHospedexhospedeiro> avaliacaoHospedexhospedeiro
            = (List<AvaliacaoHospedexhospedeiro>)session.getAttribute("avaliacaoHospedexhospedeiroPerfil");
    Usuario avaliadorHospede;

    for (AvaliacaoHospedexhospedeiro a : avaliacaoHospedexhospedeiro) {
        avaliadorHospede = a.getAvaliador();

%>
<tr>
    <td><img src="fotos/<%out.println(avaliadorHospede.getFoto_perfil());%>"></td>
    <td><a href="perfil?id=<%out.println(avaliadorHospede.getId());%>"><%out.println(avaliadorHospede.getNome());%></a></td>
    <br><td>Descrição: <%out.println(a.getDescricao());%></td>
    <br><td>Nota: <%out.println(a.getNota());%></td>
</tr>
<%}%>

<h4>Avaliações como Particiante do Evento:</h4>
<%
    List<AvaliacaoOrganizadorxparticipante> avaliacaoOrganizadorxparticipante
            = (List<AvaliacaoOrganizadorxparticipante>)session.getAttribute("avaliacaoOrganizadorxparticipantePerfil");
    Usuario avaliadorOrganizador;

    for (AvaliacaoOrganizadorxparticipante a : avaliacaoOrganizadorxparticipante) {
        avaliadorOrganizador = a.getAvaliador();

%>
<tr>
    <td><img src="fotos/<%out.println(avaliadorOrganizador.getFoto_perfil());%>"></td>
    <td><a href="perfil?id=<%out.println(avaliadorOrganizador.getId());%>"><%out.println(avaliadorOrganizador.getNome());%></a></td>
    <br><td>Descrição: <%out.println(a.getDescricao());%></td>
    <br><td>Nota: <%out.println(a.getNota());%></td>
</tr>
<%}%>

<h4>Avaliações como Organizador do Evento:</h4>
<%
    List<AvaliacaoParticipantexorganizador> avaliacaoParticipantexorganizadorte
            = (List<AvaliacaoParticipantexorganizador>)session.getAttribute("avaliacaoParticipantexorganizadorPerfil");
    Usuario avaliadorParticipante;

    for (AvaliacaoParticipantexorganizador a : avaliacaoParticipantexorganizadorte) {
        avaliadorParticipante = a.getAvaliador();

%>
<tr>
    <td><img src="fotos/<%out.println(avaliadorParticipante.getFoto_perfil());%>"></td>
    <td><a href="perfil?id=<%out.println(avaliadorParticipante.getId());%>"><%out.println(avaliadorParticipante.getNome());%></a></td>
    <br><td>Descrição: <%out.println(a.getDescricao());%></td>
    <br><td>Nota: <%out.println(a.getNota());%></td>
</tr>
<%}%>
</body>
</html>