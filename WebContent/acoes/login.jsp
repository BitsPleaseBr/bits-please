<%@page import="control.MainController"%>
<%

	String email = request.getParameter("email");
	String senha = request.getParameter("senha");
	
	out.print(new MainController().login(email, senha));
%>