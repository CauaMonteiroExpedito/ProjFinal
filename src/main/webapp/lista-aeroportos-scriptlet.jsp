<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="controle.AeroportoDao, modelo.Aeroportos, java.text.*, java.util.* "%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script language="javascript">
 function valida(id) {
	document.listaAeroportos.identificador.value = id;
 }
</script>
</head>
<body>

	<%@ include file="/WEB-INF/visao/cabecalho_aeroporto.jsp"%>
 	<form name="listaAeroportos" method="post" action="controleAeroporto"> 
		<hr>
		<table border="0" class="zebra">
			<tr>
				<td width="5%" align="center">Id</td>
				<td width="20%" align="center">Nome</td>
				<td width="5%" align="center">Quantidade de Terminais</td>
				<td width="5%" align="center">Tamanho da �rea Total</td>
				<td width="5%" align="center">Capacidade de Avi�es</td>
				<td width="5%" align="center">Torres de Controle</td>
				<td width="5%" align="center">Pistas de Voo</td>
				<td width="20%" align="center">Localiza��o</td>
				<td align="center" colspan="2">Opera��es</td>
			</tr>
			<%
			AeroportoDao dao = new AeroportoDao();
			List<Aeroportos> aeroportos = dao.getLista();
			for (Aeroportos aeroporto : aeroportos) {
			%>
			<tr> 
				<td width="5%" align="center"><%=aeroporto.getId()%></td>
				<td width="20%"><%=aeroporto.getNome()%></td>
				<td width="5%"><%=aeroporto.getQuantidadeTerminais()%></td>
				<td width="5%"><%=aeroporto.getTamanhoAreaTotal()%></td>
				<td width="5%"><%=aeroporto.getCapacidadeAvioes()%></td>
				<td width="5%"><%=aeroporto.getTorresControle()%></td>
				<td width="5%"><%=aeroporto.getPistasVoo()%></td>
				<td width="20%"><%=aeroporto.getLocalizacao()%></td>
				<td align="center"><input type="submit" name="operacao" value="Alterar" onclick="valida(<%=aeroporto.getId()%>);"></td>
				<td align="center"><input type="submit" name="operacao"	value="Excluir" onclick="valida(<%=aeroporto.getId()%>);"></td>
 			</tr> 
			<%
			}
			%>
		</table>
		<hr>
		<input type="hidden" name="identificador" value="0"> 
		<input type="Submit" name="operacao" value="Novo Aeroporto">
	</form>
	<a href="index.jsp">Retornar</a>
	
 </body> 
 </html> 