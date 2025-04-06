<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="controle.TecnicoDao,modelo.Tecnico,java.text.*,java.util.*" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
<title>Alteração de Tecnicos</title>
</head>
<body>
    <%@include file="/WEB-INF/visao/cabecalho_tecnico.jsp" %>
	<%
	String identificador = request.getParameter("identificador");
	int id = Integer.parseInt(identificador);
	
	
	
	// monta um objeto contato
	Tecnico tecnico = new Tecnico();
	tecnico.setId((long) id);

	// salva o contato
	TecnicoDao dao = new TecnicoDao();
	tecnico = dao.pesquisa(id);
	%>
	<form name="alttecnico" method="post" action="alteraTecnico">
	   <hr>
		<table border="0">
		    <tr>
				<td width="20%" align="right">Identificador:</td> 
				<td><input type="text" name="id" value="<%=tecnico.getId()%>" readonly/></td>
			</tr>
		    <tr>
				<td width="20%" align="right">Nome:</td> 
				<td><input type="text" name="nome" value="<%=tecnico.getNome()%>" /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Cpf:</td> 
				<td><input type="text" name="cpf" value="<%=tecnico.getCpf()%>" /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Telefone:</td> 
				<td><input type="text" name="telefone" value="<%=tecnico.getTelefone()%>" /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Setor:</td> 
				<td><input type="text" name="setor" value="<%=tecnico.getSetor()%>" /></td>
			</tr>
			
		</table>
		<hr>
        <input type="submit" name="btngravar" value="Alterar" />
        <!-- <input type="reset" name="btnlimpar" value="Limpar" /> -->
	</form>
	<br>
	<%@include file="/WEB-INF/visao/rodape_tecnico.jsp" %>
</body>
</html>
