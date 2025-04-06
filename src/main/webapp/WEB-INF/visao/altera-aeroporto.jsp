<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="controle.AeroportoDao,modelo.Aeroportos,java.text.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alteração de Aeroporto</title>
</head>
<body>

	<%@ include file="/WEB-INF/visao/cabecalho_aeroporto.jsp"%>
	<%
	String identificador = request.getParameter("identificador");
	int id = Integer.parseInt(identificador);

	// monta um objeto aeroporto
	Aeroportos aeroporto = new Aeroportos();
	aeroporto.setId(id);

	// salva o aeroporto
	AeroportoDao dao = new AeroportoDao();
	aeroporto = dao.pesquisa(id);
	%>
	<form name="alterarAeroporto" method="post" action="alteraAeroporto">
		<hr>
		<table border="0">
			<tr>
				<td width="20%" align="right">Identificador:</td>
				<td><input type="text" name="id" value="<%=aeroporto.getId()%>"
					readonly /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Nome:</td>
				<td><input type="text" name="nome"
					value="<%=aeroporto.getNome()%>" /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Quantidade de Terminais:</td>
				<td><input type="text" name="quantidadeTerminais"
					value="<%=aeroporto.getQuantidadeTerminais()%>" /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Tamanho da Área Total:</td>
				<td><input type="text" name="tamanhoAreaTotal"
					value="<%=aeroporto.getTamanhoAreaTotal()%>" /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Capacidade de Aviões:</td>
				<td><input type="text" name="capacidadeAvioes"
					value="<%=aeroporto.getCapacidadeAvioes()%>" /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Torres de Controle:</td>
				<td><input type="text" name="torresControle"
					value="<%=aeroporto.getTorresControle()%>" /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Pistas de Voo:</td>
				<td><input type="text" name="pistasVoo"
					value="<%=aeroporto.getPistasVoo()%>" /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Localização:</td>
				<td><input type="text" name="localizacao"
					value="<%=aeroporto.getLocalizacao()%>" /></td>
			</tr>
		</table>
		<hr>
		
		<input type="submit" name="btngravar" value="Alterar" /> 
		<!-- <input type="reset" name="btnlimpar" value="Limpar" /> -->
	
	</form>
	<br>
	<%@ include file="/WEB-INF/visao/rodape_aeroporto.jsp"%>
</body>
</html>