<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
<title>Alteração de Fornecedor</title>
</head>
<body>
   <%@include file="/WEB-INF/visao/cabecalho_fornecedor.jsp" %>
   <hr>
   <h2>Fornecedor ${param.nome} alterado com sucesso.</h2><br>
   <hr>
   <%@include file="/WEB-INF/visao/rodape_fornecedor.jsp" %>
</body>
</html>