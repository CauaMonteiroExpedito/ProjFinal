<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
<title>Erro de gravação</title>
</head>
<body>
   <%@include file="/WEB-INF/visao/cabecalho_tecnico.jsp" %>
   <hr>
   <h2>Erro ao excluir o tecnico ${param.nome}.</h2><br><br>
   <hr>
   <%@include file="/WEB-INF/visao/rodape_tecnico.jsp" %>
</body>
</html>
