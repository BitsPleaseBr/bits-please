<%@page import="br.com.jsp.bean.UsuarioBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
	
<%

	UsuarioBean usuario = new UsuarioBean();

	usuario = (UsuarioBean) session.getAttribute("usuario");
		
	if(usuario == null){
		usuario = new UsuarioBean();
		response.sendRedirect("index.jsp");
	}
	
%>
	
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8>
		<title>JSP</title>
		
		<script src="js/jquery.js"></script>
		
		<link href="css/bootstrap.css" rel="stylesheet">
		<script src="js/bootstrap.js"></script>
		
		<link href="css/estilos.css" rel="stylesheet">
		
		<script src="js/validarFormularios.js"></script>
	</head>
	
	<body>
	
	<header>
		<h1>
			<% out.print(usuario.getNomeUsuario()); %>
		</h1>
	
		<nav>
			<a href="painel.jsp">Inicío</a>
			<a href="produtos.jsp">Produtos</a>
			<a href="sair.jsp">Sair</a>
			
			
		</nav>
	</header>