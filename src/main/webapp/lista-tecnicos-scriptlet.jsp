<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="controle.TecnicoDao, modelo.Tecnico, java.text.*, java.util.* " %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PROJETO FINAL</title>
<script language="javascript">
function valida(id) {
	document.listatecnicos.identificador.value = id;
}
</script>
</head>
<body>
	<%@include file="/WEB-INF/visao/cabecalho_tecnico.jsp" %> 
	<form name="listatecnicos" method="post" action="controleTecnico">
		<hr>
		<table border="0" class="zebra">
		    <tr>
				<td width="5%"  align="center">Id</td>
				<td width="20%" align="center">Nome</td>
				<td width="20%" align="center">Cpf</td>
				<td width="20%" align="center">Telefone</td>
				<td width="20%" align="center">Setor</td>
				<td align="center" colspan="2">Operações</td>
			</tr>
			<%
			TecnicoDao dao = new TecnicoDao();
			List<Tecnico> tecnicos = dao.getLista();
			

			for (Tecnico tecnico : tecnicos) {
			%>
			<tr>	
				<td width="5%" align="center"><%=tecnico.getId()%></td>
				<td width="20%"><%=tecnico.getNome()%></td>
				<td width="20%"><%=tecnico.getCpf()%></td>
				<td width="20%"><%=tecnico.getTelefone()%></td>
				<td width="20%"><%=tecnico.getSetor()%></td>
				
				<td align="center"><input type="submit" name="operacao" value="Alterar" onclick="valida(<%=tecnico.getId()%>);"></td>
				<td align="center"><input type="submit" name="operacao" value="Excluir" onclick="valida(<%=tecnico.getId()%>);"></td>
			</tr>
			<%
			}
			%>
		</table>
		<hr>
		<input type="hidden" name="identificador" value="0">
		<input type="Submit" name="operacao" value="Novo Tecnico">
	</form>
	<a href="index.jsp">Retornar</a>
</body>
</html>