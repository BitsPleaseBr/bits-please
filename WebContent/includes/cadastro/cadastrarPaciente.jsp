<%@page import="control.dao.Dao"%>
<%@page import="control.dao.PacienteDao"%>
<%@page import="control.info.UserInfo"%>
<%@page import="control.bean.PacienteBean"%>
<%

	PacienteBean pb = new PacienteBean();
	
	//Setando informações de um usuário comum
	pb.setInfo(UserInfo.Nome, request.getParameter("nome"));
	pb.setInfo(UserInfo.Sobrenome, request.getParameter("sobrenome"));
	pb.setInfo(UserInfo.CPF, request.getParameter("cpf"));
	pb.setInfo(UserInfo.DataNasc, request.getParameter("data"));
	pb.setInfo(UserInfo.Telefone, request.getParameter("telefone"));
	pb.setInfo(UserInfo.Email, request.getParameter("email"));
	pb.setInfo(UserInfo.Senha, request.getParameter("senha"));
	
	//Inserindo no banco de dados
	//O método ainda não existe mas em breve vai talvez
	new Dao().inserir(pb, "");
%>