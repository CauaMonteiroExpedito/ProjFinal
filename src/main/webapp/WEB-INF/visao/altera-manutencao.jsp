<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="controle.ManutencaoDao,modelo.Manutencao,java.text.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Altera Manutencao</title>
</head>
<body>

	<%@ include file="/WEB-INF/visao/cabecalho_manutencao.jsp"%>
	<%
	String identificador = request.getParameter("identificador");
	int id = Integer.parseInt(identificador);

	SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
	
	// monta um objeto aeroporto
	Manutencao manutencao = new Manutencao();
	manutencao.setId(id);

	// salva o aeroporto
	ManutencaoDao dao = new ManutencaoDao();
	manutencao = dao.pesquisa(id);
	%>
	<form name="alterarManutencao" method="post" action="alteraManutencao">
		<hr>
		<table border="0">
			<tr>
				<td width="20%" align="right">Identificador:</td>
				<td><input type="text" name="id" value="<%=manutencao.getId()%>"
					readonly /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Horimetro:</td>
				<td><input type="text" name="horimetro"
					value="<%=manutencao.getHorimetro()%>" /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Id Tecnico:</td>
				<td><input type="text" name="idtecnico"
					value="<%=manutencao.getIdTecnico()%>" /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Id Equipamento:</td>
				<td><input type="text" name="idequipamento"
					value="<%=manutencao.getIdEquipamento()%>" /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Motivo:</td>
				<td><input type="text" name="motivo"
					value="<%=manutencao.getMotivo()%>" /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Data:</td>
			<td><input type="text" name="data" value="<%=data.format(manutencao.getData().getTime())%>" /></td>
			</tr>
			
		</table>
		<hr>
		
		<input type="submit" name="btngravar" value="Alterar" /> 
		<!-- <input type="reset" name="btnlimpar" value="Limpar" /> -->
	
	</form>
	<br>
	<%@ include file="/WEB-INF/visao/rodape_manutencao.jsp"%>
</body>
</html>