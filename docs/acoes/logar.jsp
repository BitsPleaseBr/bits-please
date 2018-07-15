<%@page import="br.com.jsp.dao.UsuarioDao"%>
<%@page import="br.com.jsp.bean.UsuarioBean"%>
<%

	String email = request.getParameter("email");
	String senha = request.getParameter("senha");
	
	UsuarioBean usuario = new UsuarioBean();
	
	usuario = new UsuarioDao().login(email, senha);
	
	if(usuario.getIdUsuario() == 0){
		response.sendRedirect("../index.jsp?login=falha");
	}else{
		
		session.setAttribute("usuario", usuario);
		response.sendRedirect("../painel.jsp");
	}
	
%>