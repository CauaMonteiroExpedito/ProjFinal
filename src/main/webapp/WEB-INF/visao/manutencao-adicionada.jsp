<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manutencoes</title>
</head>
<body>

<%@include file="/WEB-INF/visao/cabecalho_manutencao.jsp" %>
   <hr>
   <h2>Manutencao ${param.nome} adicionada com sucesso.</h2><br><br>
   <hr>
   <%@include file="/WEB-INF/visao/rodape_manutencao.jsp" %>

</body>
</html>