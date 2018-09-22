<%@page import="control.MainController"%>
<%

	String email = request.getParameter("email");
	String senha = request.getParameter("senha");
	
	int retorno = new MainController().login(email, senha);
	
	if(retorno == -1){
		response.sendRedirect("../pages/login.jsp");
	}else{
		response.sendRedirect("../pages/dashboard.jsp");
	}
%>