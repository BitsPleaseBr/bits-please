<%@page import="control.crypto.PswdStorage"%>
<%@page import="model.dao.ProfissionalDao"%>
<%@page import="model.bean.info.UserInfo"%>
<%@page import="model.bean.info.MedicoInfo"%>
<%@page import="model.bean.MedicoBean"%>
<%
  MedicoBean pb = new MedicoBean();

	//Obtendo email e senha
	String email = request.getParameter("emailPro");
	String senha = request.getParameter("senhaPro");

	//Setando informações de um usuário comum
	pb.setInfo(UserInfo.Nome, request.getParameter("nome"));
	pb.setInfo(UserInfo.Sobrenome, request.getParameter("sobrenome"));
	pb.setInfo(UserInfo.CPF, request.getParameter("cpf"));
	pb.setInfo(UserInfo.DataNasc, request.getParameter("data"));
	pb.setInfo(UserInfo.Email, email);
	pb.setInfo(UserInfo.Senha, PswdStorage.clientPswdHash(senha, email));
	
	//Setando informações de um médico
	String[] parIndex = new String[] {"cepResi", "cidadeResi", "bairroResi", "ruaResi", "numeroResi", "complementoResi", "celular",
									  "cepCome", "cidadeCome", "bairroCome", "ruaCome", "numeroCome", "complementoCome", "telefone",
									  "pais", "uf", "crm", "especializacao"};
	
	MedicoInfo[] enums = new MedicoInfo[] {MedicoInfo.CepResidencial, MedicoInfo.CidadeResidencial, MedicoInfo.BairroResidencial, 
										   MedicoInfo.RuaResidencial, MedicoInfo.NumeroResidencial, MedicoInfo.ComplementoResidencial, MedicoInfo.Celular,
										   MedicoInfo.CepComercial, MedicoInfo.CidadeComercial, MedicoInfo.BairroComercial,
										   MedicoInfo.RuaComercial, MedicoInfo.NumeroComercial, MedicoInfo.ComplementoComercial, MedicoInfo.TelefoneComercial,
										   MedicoInfo.Pais, MedicoInfo.UF, MedicoInfo.CRM, MedicoInfo.Especializacao};

	for (int i = 0; i < parIndex.length; i++) {
		
		if (parIndex[i].equals("especializacao"))
			continue;
		
		pb.setInfo(enums[i], request.getParameter(parIndex[i]));
	}
	
  //Cadastra o médico
	new ProfissionalDao().cadastrar(pb);
	
	response.sendRedirect("../index.jsp");
%>