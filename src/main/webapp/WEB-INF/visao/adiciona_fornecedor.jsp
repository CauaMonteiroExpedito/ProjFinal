<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
<title> Cadastro de Fornecedor</title>
</head>
<body>
    <%@include file="/WEB-INF/visao/cabecalho_fornecedor.jsp" %>
	<form name="cadfornecedor" method="post" action="adicionaFornecedor">
	   <hr>
		<table border="0">
		    <tr>
				<td width="20%" align="right">Nome:</td> 
				<td> <input type="text" name="nome" value="" /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Cnpj:</td> 
				<td><input type="text" name="cnpj" value="" /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Telefone:</td> 
				<td><input type="text" name="telefone" value="" /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Email:</td> 
				<td><input type="text" name="email" value="" />
			</tr>
			<tr>
				<td width="20%" align="right">Endereço:</td> 
				<td><input type="text" name="endereco" value="" />
			</tr>
		</table>
		<hr>
        <input type="submit" name="btngravar" value="Gravar" />
        <input type="reset" name="btnlimpar" value="Limpar" />
	</form>
	<br>
	<%@include file="/WEB-INF/visao/rodape_fornecedor.jsp" %>
</body>
</html>