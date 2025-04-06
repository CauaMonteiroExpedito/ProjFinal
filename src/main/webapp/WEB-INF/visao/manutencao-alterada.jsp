<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
<title>Manutencao Alterada</title>
</head>
<body>
   <%@include file="/WEB-INF/visao/cabecalho_manutencao.jsp" %>
   <hr>
   <h2>Manutencao ${param.nome} alterada com sucesso.</h2><br><br>
   <hr>
   <%@include file="/WEB-INF/visao/rodape_manutencao.jsp" %>
</body>
</html>