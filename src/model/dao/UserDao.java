package model.dao;

import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import control.crypto.PswdStorage;
import model.bean.UserBean;
import model.conexao.ConnectionFactory;

public abstract class UserDao extends Dao {


  protected int cadastrar(UserBean user) {

    PreparedStatement ps = mapToStatement(user.getInfosUser(), "TB_User");

    try {
      ps.executeUpdate();
    } catch (SQLException e) {

      System.out.println("Erro ao cadastrar usuário \n" + user.toString());
      e.printStackTrace();
    }

    try {
      ResultSet rs = ps.getGeneratedKeys();

      if (rs.next())
        return rs.getInt(1);
    } catch (SQLException e) {

      System.out.println("Erro ao obter id do usuário cadastrado \n" + user.toString());
      e.printStackTrace();
    }

    return -1;
  }

  public int login(String email, String senha) {
	  
	  String select = "select idUser, senhaUser from TB_User where emailUser = ?";
	  
	  try {
		  
		  PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(select);
		  
		  ps.setString(1, email);
		  
		  ResultSet rs = ps.executeQuery();
		  
		  while(rs.next()) {
			  
			  Blob senhaServer = rs.getBlob(2);
			  int length = (int) senhaServer.length();
			  
			  if (PswdStorage.compararHashClient(senha, senhaServer.getBytes(1, length)))
				  return rs.getInt(1);
		  }
			  
		  
	  } catch (SQLException e) {
		 
		  e.printStackTrace();
		  return -2;
	  }
	  
	  return -1;
  }
}