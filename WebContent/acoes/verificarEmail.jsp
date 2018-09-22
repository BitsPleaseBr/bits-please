<%@page import="s3.api.access.MethodCallerFactory"%>
<%@page import="java.util.HashMap"%>
<%

	String email = request.getParameter("email");

	out.print(MethodCallerFactory.verificarEmail(email).call().getHashBody().get("valido"));
%>