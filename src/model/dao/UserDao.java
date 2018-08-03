package model.dao;

import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import control.crypto.PswdStorage;
import model.bean.UserBean;
import model.bean.info.Info;
import model.bean.info.Tabela;
import model.bean.info.UserInfo;

public abstract class UserDao extends Dao {


  protected int cadastrar(UserBean bean) {

    PreparedStatement ps = mapToInsertStatement(Tabela.User, bean.getInfosUser());

    try {
      ps.executeUpdate();
    } catch (SQLException e) {

      System.out.println("Erro ao cadastrar usuário \n" + bean.toString());
      e.printStackTrace();
    }

    try {
      ResultSet rs = ps.getGeneratedKeys();

      if (rs.next())
        return rs.getInt(1);
    } catch (SQLException e) {

      System.out.println("Erro ao obter id do usuário cadastrado \n" + bean.toString());
      e.printStackTrace();
    }

    return -1;
  }

  protected UserDao alterar(UserBean bean) {

    try {

      mapToUpdateStatement(Tabela.User, bean.getInfosUser(), UserInfo.ID).execute();
    } catch (SQLException e) {

      System.out.println("Não foi possível alterar o usuário com id " + bean.getInfo(UserInfo.ID));
      e.printStackTrace();
    }

    return this;
  }

  protected UserBean selecionar(Info condition, Object conditionValue) {
    
    try {

      ResultSet rs =
          infoToSelectStatement(Tabela.User, UserInfo.ID, conditionValue, UserInfo.values()).executeQuery();

      while (rs.next()) {

        UserBean bean = new UserBean();
        
        ResultSetMetaData rsmd = rs.getMetaData();

        for (int i = 1; i <= rsmd.getColumnCount(); i++) {

          String colName = rsmd.getColumnName(i);
          
          for (UserInfo info : UserInfo.values()) {
            
            if (info.getCampo().equals(colName))
              bean.setInfo(info, rs.getObject(i)); break;
          }
        }
        
        return bean;
      }

    } catch (SQLException e) {

      System.out.println("Não foi possível selecionar o usuário usando a condição " + condition
          + " com  o valor " + conditionValue);
      e.printStackTrace();
    }

    return null;
  }

  public int login(String email, String senha) {

    try {

      StatementFactory sf = new StatementFactory();

      ResultSet rs =
          sf.setTabela(Tabela.User).setTipo(sf.SELECT).setInfos(UserInfo.ID, UserInfo.Senha)
              .setCondition(UserInfo.Email).setConditionValue(email).create().executeQuery();

      while (rs.next()) {

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
