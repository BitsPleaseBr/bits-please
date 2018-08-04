<%@page import="java.sql.ResultSet"%>
<%@page import="model.bean.info.UserInfo"%>
<%@page import="model.bean.info.Tabela"%>
<%@page import="model.dao.StatementFactory"%>
<%
	
	String email = request.getParameter("email");

	StatementFactory sf = new StatementFactory();

	ResultSet rs = sf.setTabela(Tabela.User).setTipo(sf.SELECT).setInfos(UserInfo.ID).setCondition(UserInfo.Email).setConditionValue(email).create().executeQuery();

	out.print(rs.next());
%>