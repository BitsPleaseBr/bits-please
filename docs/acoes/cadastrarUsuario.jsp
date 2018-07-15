<%@page import="br.com.jsp.dao.UsuarioDao"%>
<%

	String nome = request.getParameter("nome");
	String email = request.getParameter("email");
	String senha = request.getParameter("senha");
	int nivel = Integer.parseInt(request.getParameter("nivel"));
	

	new UsuarioDao().cadastrarusuario(nome, email, senha, nivel);
	
	response.sendRedirect("../painel.jsp");

%>