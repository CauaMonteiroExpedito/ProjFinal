<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
<title> Cadastro de Aeroporto</title>
</head>
<body>
	<%@include file="/WEB-INF/visao/cabecalho_aeroporto.jsp"%>
	<form name="cadastroAeroporto" method="post" action="cadastroAeroporto">
		<hr>
		<table border="0">
			<tr>
				<td width="20%" align="right">Nome:</td>
				<td><input type="text" name="nome" value="" /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Quantidade de Terminais:</td>
				<td><input type="text" name="quantidadeTerminais" value="" /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Tamanho da Área Total:</td>
				<td><input type="text" name="tamanhoAreaTotal" value="" /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Capacidade de Aviões:</td>
				<td><input type="text" name="capacidadeAvioes" value="" /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Torres de Controle:</td>
				<td><input type="text" name="torresControle" value="" /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Pistas de Voo:</td>
				<td><input type="text" name="pistasVoo" value="" /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Localização:</td>
				<td><input type="text" name="localizacao" value="" /></td>
			</tr>
		</table>
		<hr>
		<input type="submit" name="btngravar" value="Gravar" /> 
		<input type="reset" name="btnlimpar" value="Limpar" />
	</form>
	<br>
	<%@ include file="/WEB-INF/visao/rodape_aeroporto.jsp"%>

</body>
</html>