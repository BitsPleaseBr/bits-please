<%@page import="model.dao.MedicoDao"%>
<%@page import="model.bean.info.TelefoneInfo"%>
<%@page import="model.bean.TelefoneBean"%>
<%@page import="model.bean.info.EnderecoInfo"%>
<%@page import="model.bean.EnderecoBean"%>
<%@page import="control.crypto.PswdStorage"%>
<%@page import="model.bean.info.UserInfo"%>
<%@page import="model.bean.info.MedicoInfo"%>
<%@page import="model.bean.MedicoBean"%>
<%
  	MedicoBean pb = new MedicoBean();
	//Obtendo email e senha
	String email = request.getParameter("email");
	String senha = request.getParameter("senha");
	//Setando informações de um usuário comum
	pb.setInfo(UserInfo.Nome, request.getParameter("nome"));
	pb.setInfo(UserInfo.Sobrenome, request.getParameter("sobrenome"));
	pb.setInfo(UserInfo.CPF, request.getParameter("cpf"));
	pb.setInfo(UserInfo.DataNascimento, request.getParameter("data"));
	pb.setInfo(UserInfo.Email, email);
	pb.setInfo(UserInfo.Senha, PswdStorage.clientPswdHash(senha, email));
	
	//Obtendo informações do médico
	pb.setInfo(MedicoInfo.CRM, request.getParameter("crm"));
	pb.setInfo(MedicoInfo.UF, request.getParameter("uf"));
	pb.setInfo(MedicoInfo.Pais, request.getParameter("pais"));
	
	//Obtendo informações de endereço residencial
	EnderecoBean ebr = new EnderecoBean();
	ebr.setInfo(EnderecoInfo.Tipo, ebr.RESIDENCIAL);
	ebr.setInfo(EnderecoInfo.Cep, request.getParameter("cepResi"));
	ebr.setInfo(EnderecoInfo.Cidade, request.getParameter("cidadeResi"));
	ebr.setInfo(EnderecoInfo.Bairro, request.getParameter("bairroResi"));
	ebr.setInfo(EnderecoInfo.Rua, request.getParameter("ruaResi"));
	ebr.setInfo(EnderecoInfo.Numero, request.getParameter("numeroResi"));
	ebr.setInfo(EnderecoInfo.Complemento, request.getParameter("complementoResi"));
	
	//Obtendo informações de endereço comercial
	EnderecoBean ebc = new EnderecoBean();
	ebc.setInfo(EnderecoInfo.Tipo, ebc.COMERCIAL);
	ebc.setInfo(EnderecoInfo.Cep, request.getParameter("cepCome"));
	ebc.setInfo(EnderecoInfo.Cidade, request.getParameter("cidadeCome"));
	ebc.setInfo(EnderecoInfo.Bairro, request.getParameter("bairroCome"));
	ebc.setInfo(EnderecoInfo.Rua, request.getParameter("ruaCome"));
	ebc.setInfo(EnderecoInfo.Numero, request.getParameter("numeroCome"));
	ebc.setInfo(EnderecoInfo.Complemento, request.getParameter("complementoCome"));
	
	//Obtendo informações de celular
	TelefoneBean tbc = new TelefoneBean();
	tbc.setInfo(TelefoneInfo.Tipo, tbc.CELULAR);
	tbc.setInfo(TelefoneInfo.Numero, request.getParameter("celular"));
	
	//Obtendo informações de telefone comercial
	TelefoneBean tbt = new TelefoneBean();
	tbt.setInfo(TelefoneInfo.Tipo, tbt.TELEFONE);
	tbt.setInfo(TelefoneInfo.Numero, request.getParameter("telefone"));
	
	//Adicionando informações de telefones e endereços ao médico
	pb.addEndereco(ebr).addEndereco(ebc).addTelefone(tbc).addTelefone(tbt);
	
  	//Cadastra o médico
	new MedicoDao().cadastrar(pb);
	
	response.sendRedirect("../pages/login.html");
%>