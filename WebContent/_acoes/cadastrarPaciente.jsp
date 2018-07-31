<%@page import="control.crypto.PswdStorage"%>
<%@page import="model.dao.PacienteDao"%>
<%@page import="model.info.UserInfo"%>
<%@page import="model.bean.PacienteBean"%>
<%
  PacienteBean pb = new PacienteBean();

  //Setando informações de um usuário comum
  String email = request.getParameter("emailPac");
  String senha = request.getParameter("senhaPac");

  pb.setInfo(UserInfo.Nome, request.getParameter("nome"));
  pb.setInfo(UserInfo.Sobrenome, request.getParameter("sobrenome"));
  pb.setInfo(UserInfo.CPF, request.getParameter("cpf"));
  pb.setInfo(UserInfo.DataNasc, request.getParameter("data"));
  pb.setInfo(UserInfo.Email, email);
  pb.setInfo(UserInfo.Senha, PswdStorage.clientPswdHash(senha, email));

  //Inserindo no banco de dados
  new PacienteDao().cadastrar(pb);

  response.sendRedirect("../index.jsp");
%>