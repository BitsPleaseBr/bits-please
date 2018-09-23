<%@page import="model.bean.info.TelefoneInfo"%>
<%@page import="model.bean.TelefoneBean"%>
<%@page import="model.bean.info.EnderecoInfo"%>
<%@page import="model.bean.EnderecoBean"%>
<%@page import="control.crypto.PswdStorage"%>
<%@page import="model.dao.MedicoDao"%>
<%@page import="model.bean.info.UserInfo"%>
<%@page import="model.bean.info.MedicoInfo"%>
<%@page import="model.bean.MedicoBean"%>
<%@page import="s3.api.access.MethodCallerFactory"%>
<%
  MedicoBean pb = new MedicoBean();

  //Obtendo email e senha
  String email = request.getParameter("emailPro");
  String senha = request.getParameter("senhaPro");

  //Setando informações de um usuário comum
  pb.setInfo(UserInfo.Nome, request.getParameter("nome"));
  pb.setInfo(UserInfo.Sobrenome, request.getParameter("sobrenome"));
  pb.setInfo(UserInfo.CPF, request.getParameter("cpf"));
  pb.setInfo(UserInfo.DataNascimento, request.getParameter("data"));
  pb.setInfo(UserInfo.Email, email);
  pb.setInfo(UserInfo.Senha, senha);

  //Setando informações de um médico
  pb.setInfo(MedicoInfo.CRM, request.getParameter("crm"));
  pb.setInfo(MedicoInfo.Pais, request.getParameter("pais"));

  //Adicionando endereços do médico
  String[] enderecoInfo =
      new String[] {"cep", "cidade", "bairro", "rua", "numero", "complemento"};
  String[] enderecoInfoComplemento = new String[] {"Resi", "Come"};

  String[] endInfos = new String[] {"Cep", "Cidade", "Bairro", "Rua", "Numero", "Complemento"};

  for (int enderecoInfoIndex = 0; enderecoInfoIndex < 2; enderecoInfoIndex++) {

    EnderecoBean eb = new EnderecoBean();
    eb.setInfo(EnderecoInfo.Tipo, enderecoInfoIndex == 0 ? eb.RESIDENCIAL : eb.COMERCIAL);

    for (int infoIndex = 0; infoIndex < enderecoInfo.length; infoIndex++) {

      String info = endInfos[infoIndex];
      String parameter =
          enderecoInfo[enderecoInfoIndex] + enderecoInfoComplemento[enderecoInfoIndex];

      eb.setInfo(EnderecoInfo.valueOf(info), request.getParameter(parameter));
    }

    pb.addEndereco(eb);
  }

  //Adicionando telefones do médico
  TelefoneBean telefone = new TelefoneBean();
  telefone.setInfo(TelefoneInfo.Tipo, telefone.TELEFONE);
  telefone.setInfo(TelefoneInfo.Numero, request.getParameter("telefone"));

  pb.addTelefone(telefone);

  TelefoneBean celular = new TelefoneBean();
  telefone.setInfo(TelefoneInfo.Tipo, telefone.CELULAR);
  telefone.setInfo(TelefoneInfo.Numero, request.getParameter("celular"));

  pb.addTelefone(celular);

  //Cadastra o médico
  out.print(MethodCallerFactory.cadastrarUser(pb).call().getResponse().getBody());

  response.sendRedirect("../index.jsp");
%>