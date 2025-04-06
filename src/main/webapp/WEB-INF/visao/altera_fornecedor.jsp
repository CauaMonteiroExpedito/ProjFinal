<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="controle.FornecedorDao,modelo.Fornecedor,java.text.*,java.util.*" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
<title>Alteração de Fornecedor</title>
</head>
<body>
    <%@include file="/WEB-INF/visao/cabecalho_fornecedor.jsp" %>
	<%
	String identificador = request.getParameter("identificador");
			int id = Integer.parseInt(identificador);
			
			
			
			// monta um objeto contato
			Fornecedor fornecedor = new Fornecedor();
			fornecedor.setId((long) id);

			// salva o contato
			FornecedorDao dao = new FornecedorDao();
			fornecedor = dao.pesquisa(id);
	%>
	<form name="altfornecedor" method="post" action="alteraFornecedor">
	   <hr>
		<table border="0">
		    <tr>
				<td width="20%" align="right">Identificador:</td> 
				<td><input type="text" name="id" value="<%=fornecedor.getId()%>" readonly/></td>
			</tr>
		    <tr>
				<td width="20%" align="right">Nome:</td> 
				<td><input type="text" name="nome" value="<%=fornecedor.getNome()%>" /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Cnpj:</td> 
				<td><input type="text" name="cnpj" value="<%=fornecedor.getCnpj()%>" /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Telefone:</td> 
				<td><input type="text" name="telefone" value="<%=fornecedor.getTelefone()%>" /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Email:</td> 
				<td><input type="text" name="email" value="<%=fornecedor.getEmail()%>" /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Endereço:</td> 
				<td><input type="text" name="endereco" value="<%=fornecedor.getEndereco()%>" /></td>
			</tr>
			
		</table>
		<hr>
        <input type="submit" name="btngravar" value="Alterar" />
        <!-- <input type="reset" name="btnlimpar" value="Limpar" /> -->
	</form>
	<br>
	<%@include file="/WEB-INF/visao/rodape_fornecedor.jsp" %>
</body>
</html>
