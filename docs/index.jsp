<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
		
		<script src="js/jquery.js"></script>
		
		<link href="css/bootstrap.css" rel="stylesheet">
		<script src="js/bootstrap.js"></script>
		
		<link href="css/estilos.css" rel="stylesheet">
		
		<script src="js/validarFormularios.js"></script>
	</head>
	
	<body>
	
		<%
		
			if(request.getParameter("login") != null){
				out.print("<div class='alert alert-danger'>Dados incorretos</div>");	
			}
		
		%>

		<form method="post" action="acoes/logar.jsp" class="formularioLogin" onsubmit="return validaLogin()">
		
			<div class="alert alert-danger" id="mensagem"></div>
			
			<input type="email" placeholder="E-mail" class="form-control" name="email" id="email">
			<input type="password" placeholder="Senha" class="form-control" name="senha" id="senha">
			<input type="submit" class="btn btn-primary">
		
		</form>

	</body>
</html>