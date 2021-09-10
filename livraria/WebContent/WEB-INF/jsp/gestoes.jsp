<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Livraria</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body class="container">
	<h1 class="text-center">CADASTRO DE AUTORES</h1>
	<form action="<C:url value="/gestoes"/>" method="POST">
		<div class="form-group">
			<label for="nome">Nome</label>
			<input id="nome" class="form-control" name="nome">
		</div>
		<div class="form-group">
			<label for="email">Email</label>
			<input id="email" class="form-control" name="email">
		</div>
		<div class="form-group">
			<label for="dataNascimento">Data de Nascimento</label>
			<input id="dataNascimento" class="form-control" name="dataNascimento"> 
		</div>
		<div class="form-group">
			<label for="miniCurriculo">Mini curriculo</label>
			<input id="miniCurriculo" class="form-control" name="miniCurriculo">
		</div>
		
		<input type="submit" value="Gravar" class="mt-2 btn-primary">
	</form>
	
	<h1 class="text-center">LISTA DE AUTORES</h1>
	<table class="table table-hover table-striped table-bordered">
		<thead>
			<tr>
				<th>NOME</th>
				<th>EMAIL</th>
				<th>DATA NASCIMENTO</th>
			</tr>
		</thead>
		<tbody>
			<C:forEach items="${gestoes}" var="t">
				<tr>
					<td>${t.nome}</td>
					<td>${t.email}</td>
					<td>${t.dataNascimento}</td>
				</tr>
			</C:forEach>
		</tbody>
	</table>
</body>
</html>