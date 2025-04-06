<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
<title>Adiciona Manutencao</title>
</head>
<body>
	<%@include file="/WEB-INF/visao/cabecalho_manutencao.jsp"%>
	<form name="cadastroManutencao" method="post" action="cadastroManutencao">
		<hr>
		<table border="0">
			<tr>
				<td width="20%" align="right">Horimetro:</td>
				<td><input type="text" name="horimetro" value="" /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Id Tecnico:</td>
				<td><input type="text" name="idtecnico" value="" /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Id Equipamento:</td>
				<td><input type="text" name="idequipamento" value="" /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Motivo:</td>
				<td><input type="text" name="motivo" value="" /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Data:</td>
				<td><input type="text" name="data" value="" /></td>
			</tr>
		</table>
		<hr>
		<input type="submit" name="btngravar" value="Gravar" /> 
		<input type="reset" name="btnlimpar" value="Limpar" />
	</form>
	<br>
	<%@ include file="/WEB-INF/visao/rodape_manutencao.jsp"%>

</body>
</html>