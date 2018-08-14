<%@page import="model.bean.info.UserInfo"%>
<%@page import="model.dao.StatementFactory"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="model.bean.info.Tabela"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%

	String cpf = request.getParameter("cpf").replaceAll("\\D", "");
	
	StatementFactory sf = new StatementFactory();
	ResultSet rs = sf.setTabela(Tabela.User).setTipo(sf.SELECT).setInfos(UserInfo.Situacao).setCondition(UserInfo.CPF).setConditionValue(cpf).create().executeQuery();
	
	if (rs.next()) {
	  if (rs.getInt(1) > 3) {
	    out.print(true);
	  } else {
	    out.print(false);
	  }
	} else {
	  out.println(false);
	}
%>