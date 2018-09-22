<%@page import="s3.api.access.MethodCallerFactory"%>
<%

	String email = request.getParameter("email");
	String senha = request.getParameter("senha");
	
	out.print(MethodCallerFactory.gerarToken(email, senha).call().getBody());
%>