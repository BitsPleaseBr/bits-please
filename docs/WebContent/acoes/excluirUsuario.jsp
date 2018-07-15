<%@page import="br.com.jsp.dao.UsuarioDao"%>
<%

	int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));

	new UsuarioDao().excluirUsuario(idUsuario);
	
	response.sendRedirect("../painel.jsp");

%>