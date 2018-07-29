package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.bean.UserBean;

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
}
