package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

  public static int login(String email, String senha) {
	  
	  String select = "select from TB_Users idUser where emailUser = ? and senhaUser = ?";
	  
	  try {
		  
		  PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(select);
		  
		  ps.setString(1, email);
		  ps.setString(2, senha);
		  
		  ResultSet rs = ps.executeQuery();
		  
		  while(rs.next())
			  return rs.getInt(1);
		  
	  } catch (SQLException e) {
		  
		  System.out.println("Não foi possível logar o usuário usando o email " + email + " e a senha " + senha);
		  e.printStackTrace();
	  }
	  
	  return -1;
  }
}