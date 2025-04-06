<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
<title> Cadastro de Equipamento</title>
</head>
<body>
    <%@include file="/WEB-INF/visao/cabecalho_equipamento.jsp" %>
	<form name="cadequipamento" method="post" action="adicionaEquipamento">
	   <hr>
		<table border="0">
		    <tr>
				<td width="20%" align="right">Nome do equipamento:</td> 
				<td> <input type="text" name="nomeequipamento" value="" /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Data da compra:</td> 
				<td><input type="text" name="datacompra" value="" /></td>
			</tr>
			
			<tr>
				<td width="20%" align="right">Preco da compra:</td> 
				<td><input type="text" name="precocompra" value="" /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Validade:</td> 
				<td><input type="text" name="validade" value="" /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Lote:</td> 
				<td><input type="text" name="lote" value="" />
			</tr>
			<tr>
			<td width="20%" align="right">Quantidade:</td> 
				<td><input type="text" name="quantidade" value="" />
			</tr>
			<tr>
			<td width="20%" align="right">Marca:</td> 
				<td><input type="text" name="marca" value="" />
			</tr>
			<tr>
			<td width="20%" align="right">Tecnico Responsavel:</td> 
				<td><input type="text" name="tecnicoresponsavel" value="" />
			</tr>
		</table>
		<hr>
        <input type="submit" name="btngravar" value="Gravar" />
        <input type="reset" name="btnlimpar" value="Limpar" />
	</form>
	<br>
	<%@include file="/WEB-INF/visao/rodape_equipamento.jsp" %>
</body>
</html>