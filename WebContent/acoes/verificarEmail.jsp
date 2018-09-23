<%@page import="s3.api.access.MethodCallerFactory"%>
<%

	String email = request.getParameter("email");

	out.print(MethodCallerFactory.verificarEmail(email).call().getHashBody().get("valido"));
%>