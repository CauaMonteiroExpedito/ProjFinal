<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="controle.EquipamentoDAO, modelo.Equipamento, java.text.*, java.util.* " %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sistema de controle de equipamentos em aeroportos</title>
<script language="javascript">
function valida(id) {
	document.listaequipamentos.identificador.value = id;
}
</script>
</head>
<body>
	<%@include file="/WEB-INF/visao/cabecalho_equipamento.jsp" %> 
	<form name="listaequipamentos" method="post" action="controleEquipamento">
		<hr>
		<table border="0" class="zebra">
		    <tr>
				<td width="5%"  align="center">Id</td>
				<td width="20%" align="center">Nome do Equipamento</td>
				<td width="20%" align="center">Preco da compra</td>
				<td width="20%" align="center">Validade</td>
				<td width="20%" align="center">Lote</td>
				<td width="20%" align="center">Quantidade</td>
				<td width="20%" align="center">Marca</td>
				<td width="20%" align="center">Tecnico responsavel</td>
				<td align="center" colspan="2">Operações</td>
			</tr>
			<%
			EquipamentoDAO dao = new EquipamentoDAO();
			List<Equipamento> equipamentos = dao.getLista();
			SimpleDateFormat datacompra = new SimpleDateFormat("dd/MM/yyyy");

			for (Equipamento equipamento : equipamentos) {
			%>
			<tr>	
				<td width="5%" align="center"><%=equipamento.getId()%></td>
				<td width="20%"><%=equipamento.getNomeEquipamento()%></td>
				<td width="20%"><%=equipamento.getPrecoCompra()%></td>
				<td width="20%"><%=equipamento.getValidade()%></td>
				<td width="20%"><%=equipamento.getLote()%></td>
				<td width="20%"><%=equipamento.getQuantidade()%></td>
				<td width="20%"><%=equipamento.getMarca()%></td>
				<td width="20%"><%=equipamento.getTecnicoResponsavel()%></td>
				
				<td width="20%"align="center"><%=datacompra.format(equipamento.getDataCompra().getTime())%></td>
				<td align="center"><input type="submit" name="operacao" value="Alterar" onclick="valida(<%=equipamento.getId()%>);"></td>
				<td align="center"><input type="submit" name="operacao" value="Excluir" onclick="valida(<%=equipamento.getId()%>);"></td>
			</tr>
			<%
			}
			%>
		</table>
		<hr>
		<input type="hidden" name="identificador" value="0">
		<input type="Submit" name="operacao" value="Novo Equipamento">
	</form>
	<a href="index.jsp">Retornar</a>
</body>
</html>