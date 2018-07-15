<%@page import="br.com.jsp.dao.UsuarioDao"%>
<%

	int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));

	new UsuarioDao().editarUsuario(idUsuario);
	
	response.sendRedirect("../painel.jsp");

%>