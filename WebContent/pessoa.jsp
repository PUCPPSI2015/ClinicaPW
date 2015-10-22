<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
	function gravar(){
		document.getElementById("action").value="gravar";
	}
	function excluir(){
		document.getElementById("action").value="excluir";
	}
</script>
<head>
<title>App Cadastro - PW</title>
</head>

<body>
	<form action="pessoa" method="post">
		<input type="hidden" id="action" name="action" value="" />
		<div align="center">
			<label id="id">ID:</label><input id="id" name="id" type="text" size="5">
		</div>
		<div align="center">
			<label id="nome">Nome:</label><input id="nome" name="nome" type="text" size="45">
		</div>
		<div align="center">
			<label id="CEP">CEP:</label><input id="CEP" name="CEP" type="text" size="45">
		</div>
		<div align="center">
			<label id="Numero">Numero:</label><input id="Numero" name="Numero" type="text" size="45">
		</div>
		<div align="center">
			<label id="complemento">Complemento:</label><input id="complemento" name="complemento" type="text" size="45">
		</div>
		<br>
		
		<div align="center">
			<button id="gravar_subimit" onclick="gravar();" value="gravar">Gravar</button>
			<button id="excluir_subimit" onclick="excluir();" value="excluir">Excluir</button>
		</div>
		<br>
	</form>
	
	<div align="center">
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>CEP</th>
				<th>Numero</th>
				<th>Complemento</th>
			</tr>
			<!-- percorre Pacientes montando linha na tabela -->
			<c:forEach var="pessoa" items="${dao.listaTudo()}">
				<tr>
					<td>${pessoa.id }</td>
					<td>${pessoa.nome }</td>
					<td>${pessoa.CEP }</td>
					<td>${pessoa.Numero }</td>
					<td>${pessoa.complemento }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>