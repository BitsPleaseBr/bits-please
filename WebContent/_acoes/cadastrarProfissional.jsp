<%@page import="model.dao.ProfissionalDao"%>
<%@page import="model.info.UserInfo"%>
<%@page import="model.info.ProfissionalInfo"%>
<%@page import="model.bean.ProfissionalBean" %>
<%
  ProfissionalBean pb = new ProfissionalBean();

	//Setando informações de um usuário comum
	pb.setInfo(UserInfo.Nome, request.getParameter("nome"));
	pb.setInfo(UserInfo.Sobrenome, request.getParameter("sobrenome"));
	pb.setInfo(UserInfo.CPF, request.getParameter("cpf"));
	pb.setInfo(UserInfo.DataNasc, request.getParameter("data"));
	pb.setInfo(UserInfo.Telefone, request.getParameter("telefone"));
	pb.setInfo(UserInfo.Email, request.getParameter("emailPro"));
	pb.setInfo(UserInfo.Senha, request.getParameter("senhaPro"));
	
	//Setando informações de um médico
	String[] parIndex = new String[] {"cepResi", "cidadeResi", "bairroResi", "ruaResi", "numeroResi", "complementoResi", "telefoneResi",
									  "cepCome", "cidadeCome", "bairroCome", "ruaCome", "numeroCome", "complementoCome", "telefoneCome",
									  "pais", "uf", "crm", "especializacao"};
	
	ProfissionalInfo[] enums = new ProfissionalInfo[] {ProfissionalInfo.CepResidencial, ProfissionalInfo.CidadeResidencial, ProfissionalInfo.BairroResidencial, 
										   ProfissionalInfo.RuaResidencial, ProfissionalInfo.NumeroResidencial, ProfissionalInfo.ComplementoResidencial, ProfissionalInfo.TelefoneResidencial,
										   ProfissionalInfo.CepComercial, ProfissionalInfo.CidadeComercial, ProfissionalInfo.BairroComercial,
										   ProfissionalInfo.RuaComercial, ProfissionalInfo.NumeroComercial, ProfissionalInfo.ComplementoComercial, ProfissionalInfo.TelefoneComercial,
										   ProfissionalInfo.Pais, ProfissionalInfo.UF, ProfissionalInfo.CRM, ProfissionalInfo.Especializacao};
	
	for (int i = 0; i < enums.length; i++) {
		
		pb.setInfo(enums[i], request.getParameter(parIndex[i]));
	}
	
	//O MedicoDao ainda naão existe, e talvez demore um pouco, mas em tese é isso aqui
	new ProfissionalDao().cadastrar(pb);
%>