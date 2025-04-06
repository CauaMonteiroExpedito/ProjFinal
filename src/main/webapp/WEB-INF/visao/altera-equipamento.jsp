<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="controle.EquipamentoDAO,modelo.Equipamento,java.text.*,java.util.*" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
<title>Alteração de Equipamentos</title>
</head>
<body>
    <%@include file="/WEB-INF/visao/cabecalho_equipamento.jsp" %>
	<%
	String identificador = request.getParameter("identificador");
	int id = Integer.parseInt(identificador);
	
	SimpleDateFormat DataCompra = new SimpleDateFormat("dd/MM/yyyy");
	
	Equipamento equipamento = new Equipamento();
	equipamento.setId((long) id); 

	EquipamentoDAO dao = new EquipamentoDAO();
	equipamento = dao.pesquisa(id);
	%>
	<form name="altequipamento" method="post" action="alteraEquipamento">
	   <hr>
		<table border="0">
		    <tr>
				<td width="20%" align="right">Identificador:</td> 
				<td><input type="text" name="identificador" value="<%=equipamento.getId()%>" readonly/></td>
			</tr>
		    <tr>
				<td width="20%" align="right">Nome do equipamento:</td> 
				<td> <input type="text" name="nomeequipamento" value="<%=equipamento.getNomeEquipamento()%>"  /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Data da compra:</td> 
				<td><input type="text" name="datacompra" value="<%=DataCompra.format(equipamento.getDataCompra().getTime())%>" /></td>
			</tr>
			
			<tr>
				<td width="20%" align="right">Preco da compra:</td> 
				<td><input type="text" name="precocompra" value="<%=equipamento.getPrecoCompra()%>"  /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Validade:</td> 
				<td><input type="text" name="validade" value="<%=equipamento.getValidade()%>"  /></td>
			</tr>
			<tr>
				<td width="20%" align="right">Lote:</td> 
				<td><input type="text" name="lote" value="<%=equipamento.getLote()%>"  />
			</tr>
			<tr>
			<td width="20%" align="right">Quantidade:</td> 
				<td><input type="text" name="quantidade" value="<%=equipamento.getQuantidade()%>"  />
			</tr>
			<tr>
			<td width="20%" align="right">Marca:</td> 
				<td><input type="text" name="marca" value="<%=equipamento.getMarca()%>" />
			</tr>
			<tr>
			<td width="20%" align="right">Tecnico Responsavel:</td> 
				<td><input type="text" name="tecnicoresponsavel" value="<%=equipamento.getTecnicoResponsavel()%>" />
			</tr>
		</table>
		<hr>
        <input type="submit" name="btngravar" value="Alterar" />
        <!-- <input type="reset" name="btnlimpar" value="Limpar" /> -->
	</form>
	<br>
	<%@include file="/WEB-INF/visao/rodape_equipamento.jsp" %>
</body>
</html>
