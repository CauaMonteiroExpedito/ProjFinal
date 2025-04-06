<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="controle.FornecedorDao,modelo.Fornecedor,java.text.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PROJETO FINAL</title>
<script language="javascript">
function valida(id) {
	document.listafornecedores.identificador.value = id;
}
</script>
</head>
<body>
	<%@include file="/WEB-INF/visao/cabecalho_fornecedor.jsp" %> 
	<form name="listafornecedores" method="post" action="controleFornecedor">
		<hr>
		<table border="0" class="zebra">
		    <tr>
				<td width="5%"  align="center">Id</td>
				<td width="20%" align="center">Nome</td>
				<td width="20%" align="center">Cnpj</td>
				<td width="20%" align="center">Telefone</td>
				<td width="20%" align="center">Email</td>
				<td width="20%" align="center">Endereco</td>
				<td align="center" colspan="2">Operações</td>
			</tr>
			<%
			FornecedorDao dao = new FornecedorDao();
					List<Fornecedor> fornecedores = dao.getLista();
					

					for (Fornecedor fornecedor : fornecedores) {
			%>
			<tr>	
				<td width="5%" align="center"><%=fornecedor.getId()%></td>
				<td width="20%"><%=fornecedor.getNome()%></td>
				<td width="20%"><%=fornecedor.getCnpj()%></td>
				<td width="20%"><%=fornecedor.getTelefone()%></td>
				<td width="20%"><%=fornecedor.getEmail()%></td>
				<td width="20%"><%=fornecedor.getEndereco()%></td>				
				
				<td align="center"><input type="submit" name="operacao" value="Alterar" onclick="valida(<%=fornecedor.getId()%>);"></td>
				<td align="center"><input type="submit" name="operacao" value="Excluir" onclick="valida(<%=fornecedor.getId()%>);"></td>
			</tr>
			<%
			}
			%>
		</table>
		<hr>
		<input type="hidden" name="identificador" value="0">
		<input type="Submit" name="operacao" value="Novo Fornecedor">
	</form>
	<a href="index.jsp">Retornar</a>
</body>
</html>