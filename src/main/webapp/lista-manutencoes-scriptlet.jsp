<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="controle.ManutencaoDao, modelo.Manutencao, java.text.*, java.util.* "%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Controle de equipamentos</title>
<script language="javascript">
 function valida(id) {
	document.listaManutencoes.identificador.value = id;
 }
</script>
</head>
<body>

	<%@ include file="/WEB-INF/visao/cabecalho_manutencao.jsp"%>
 	<form name="listaManutencoes" method="post" action="controleManutencao"> 
		<hr>
		<table border="0" class="zebra">
			<tr>
				<td width="5%" align="center">Id</td>
				<td width="20%" align="center">Horimetro</td>
				<td width="5%" align="center">Id Tecnico</td>
				<td width="5%" align="center">Id Equipamento</td>
				<td width="5%" align="center">Motivo </td>
				<td width="5%" align="center">Data</td>
				<td align="center" colspan="2">Operações</td>
			
			</tr>
			<%
			ManutencaoDao dao = new ManutencaoDao();
			List<Manutencao> manutencao = dao.getLista();
			SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
			
			for (Manutencao manutencoes : manutencao) {
			%>
			<tr> 
				<td width="5%" align="center"><%=manutencoes.getId()%></td>
				<td width="20%"><%=manutencoes.getHorimetro()%></td>
				<td width="5%"><%=manutencoes.getIdTecnico()%></td>
				<td width="5%"><%=manutencoes.getIdEquipamento()%></td>
				<td width="5%"><%=manutencoes.getMotivo()%></td>
			    <td width="20%"align="center"><%=data.format(manutencoes.getData().getTime())%></td>
				<td align="center"><input type="submit" name="operacao" value="Alterar" onclick="valida(<%=manutencoes.getId()%>);"></td>
				<td align="center"><input type="submit" name="operacao"	value="Excluir" onclick="valida(<%=manutencoes.getId()%>);"></td>
 			</tr> 
			<%
			}
			%>
		</table>
		<hr>
		<input type="hidden" name="identificador" value="0"> 
		<input type="Submit" name="operacao" value="Nova Manutencao">
	</form>
	<a href="index.jsp">Retornar</a>
	
 </body> 
 </html> 