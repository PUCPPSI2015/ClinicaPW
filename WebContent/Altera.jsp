<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
	function alterar(){
		document.getElementById("action").value="alterar";
	}
</script>
<head>
<title>App Alterar- PW</title>
</head>

<body>
	<form action="pessoa" method="post">
		<input type="hidden" id="action" name="action" value="" />
		<div align="left">
			<label id="nome">Nome:</label><input id="nome" name="nome" type="text" size="45">
		</div>
		<div align="left">
			<label id="senha">Senha:</label><input id="senha" name="senha" type="password" size="45">
		</div>
		<div align="left">
			<label id="CEP">CEP:</label><input id="CEP" name="CEP" type="text" size="45">
		</div>
		<div align="left">
			<label id="Numero">Numero:</label><input id="Numero" name="Numero" type="text" size="45">
		</div>
		<div align="left">
			<label id="complemento">Complemento:</label><input id="complemento" name="complemento" type="text" size="45">
		</div>
		<div align="left">
			<label id="id">ID:</label><input id="id" name="id" type="text" size="45">
		</div>
		<br>
		
		<div align="left">
			<button id="alterar_subimit" onclick="alterar();" value="alterar">Alterar</button>
		</div>
		<br>
	</form>
	
	<div align="center">
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Senha</th>
				<th>CEP</th>
				<th>Numero</th>
				<th>Complemento</th>
			</tr>
			<!-- percorre Pacientes montando linha na tabela -->
			<c:forEach var="pessoa" items="${dao.listaTudo()}">
				<tr>
					<td>${pessoa.id }</td>
					<td>${pessoa.nome }</td>
					<td>${pessoa.senha }</td>
					<td>${pessoa.CEP }</td>
					<td>${pessoa.Numero }</td>
					<td>${pessoa.complemento }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>