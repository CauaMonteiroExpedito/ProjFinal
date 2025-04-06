<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
<title> Cadastro de Técnico</title>
</head>
<body>
    <%@include file="/WEB-INF/visao/cabecalho_tecnico.jsp" %>
	<form name="cadtecnico" method="post" action="adicionaTecnico">
	   <hr>
		<table border="0">
		    <tr>
				<td width="20%" align="right">Nome:</td> 
				<td> <input type="text" name="nome" value="" /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Cpf:</td> 
				<td><input type="text" name="cpf" value="" /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Telefone:</td> 
				<td><input type="text" name="telefone" value="" /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Setor:</td> 
				<td><input type="text" name="setor" value="" />
			</tr>
		</table>
		<hr>
        <input type="submit" name="btngravar" value="Gravar" />
        <input type="reset" name="btnlimpar" value="Limpar" />
	</form>
	<br>
	<%@include file="/WEB-INF/visao/rodape_tecnico.jsp" %>
</body>
</html>