<%@page import="control.info.UserInfo"%>
<%@page import="control.info.MedicoInfo"%>
<%@page import="control.bean.MedicoBean" %>
<% 

	MedicoBean pb = new MedicoBean();

	//Setando informações de um usuário comum
	pb.setInfo(UserInfo.Nome, request.getParameter("nome"));
	pb.setInfo(UserInfo.Sobrenome, request.getParameter("sobrenome"));
	pb.setInfo(UserInfo.CPF, request.getParameter("cpf"));
	pb.setInfo(UserInfo.DataNasc, request.getParameter("data"));
	pb.setInfo(UserInfo.Telefone, request.getParameter("telefone"));
	pb.setInfo(UserInfo.Email, request.getParameter("email"));
	pb.setInfo(UserInfo.Senha, request.getParameter("senha"));
	
	//Setando informações de um médico
	String[] parIndex = new String[] {"cepResidencial", "cidadeResidencial", "bairroResidencial", "ruaResidencial", "numeroResidencial", "complementoResidencial", "telefoneResidencial",
									  "cepComercial", "cidadeComercial", "bairroComercial", "ruaComercial", "numeroComercial", "complementoComercial", "telefoneComercial",
									  "pais", "uf", "crm", "especializacao"};
	
	MedicoInfo[] enums = new MedicoInfo[] {MedicoInfo.CepResidencial, MedicoInfo.CidadeResidencial, MedicoInfo.BairroResidencial, 
										   MedicoInfo.RuaResidencial, MedicoInfo.NumeroResidencial, MedicoInfo.ComplementoComercial, MedicoInfo.TelefoneResidencial,
										   MedicoInfo.CepComercial, MedicoInfo.CidadeComercial, MedicoInfo.BairroComercial,
										   MedicoInfo.RuaComercial, MedicoInfo.NumeroComercial, MedicoInfo.ComplementoComercial, MedicoInfo.TelefoneComercial,
										   MedicoInfo.Pais, MedicoInfo.UF, MedicoInfo.CRM, MedicoInfo.Especializacao};
	
	for (int i = 0; i < enums.length; i++) {
		
		pb.setInfo(enums[i], request.getParameter(parIndex[i]));
	}
	
	//O MedicoDao ainda naão existe, e talvez demore um pouco, mas em tese é isso aqui
	new MedicoDao().inserir(pb);
%>