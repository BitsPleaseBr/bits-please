<%@page import="model.dao.PacienteDao"%>
<%@page import="model.info.UserInfo"%>
<%@page import="model.bean.PacienteBean"%>
<%

	PacienteBean pb = new PacienteBean();
	
	//Setando informações de um usuário comum
	pb.setInfo(UserInfo.Nome, request.getParameter("nome"));
	pb.setInfo(UserInfo.Sobrenome, request.getParameter("sobrenome"));
	pb.setInfo(UserInfo.CPF, request.getParameter("cpf"));
	pb.setInfo(UserInfo.DataNasc, request.getParameter("data"));
	pb.setInfo(UserInfo.Email, request.getParameter("emailPac"));
	pb.setInfo(UserInfo.Senha, request.getParameter("senhaPac"));
	
	//Inserindo no banco de dados
	//O método ainda não existe mas em breve vai talvez
	new PacienteDao().cadastrar(pb);
%>