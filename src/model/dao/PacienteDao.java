package model.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import model.bean.PacienteBean;
import model.bean.UserBean;
import model.bean.info.Info;
import model.bean.info.PacienteInfo;
import model.bean.info.Tabela;

public class PacienteDao extends UserDao {


  public PacienteDao() {

    this.tabela = Tabela.Paciente;
  }


  public PacienteDao cadastrar(PacienteBean bean) {

    int id = super.cadastrar(bean);

    bean.setInfo(PacienteInfo.IDUser, id);

    try {

      mapToInsertStatement(bean.getInfosPac()).execute();
    } catch (SQLException e) {

      System.out.println("Erro ao cadastrar paciente \n" + bean.toString());
      e.printStackTrace();
    }

    return this;
  }

  public PacienteDao alterar(PacienteBean bean) {

    super.alterar(bean);

    try {

      mapToUpdateStatement(bean.getInfosPac(), PacienteInfo.IDUser).execute();
    } catch (SQLException e) {

      System.out.println(
          "Não foi possível alterar o paciente com id " + bean.getInfo(PacienteInfo.IDUser));
      e.printStackTrace();
    }

    return this;
  }

  public PacienteBean selecionar(int id) {

    return selecionar(PacienteInfo.IDUser, id);
  }

  public PacienteBean selecionar(Info condition, Object conditionValue) {

    UserBean ub = super.selecionar(condition, conditionValue);

    PacienteBean pb = new PacienteBean();
    pb.getInfosUser().putAll(ub.getInfosUser());

    try {

      ResultSet rs =
          infoToSelectStatement(condition, conditionValue, PacienteInfo.values()).executeQuery();

      while (rs.next()) {

        ResultSetMetaData rsmd = rs.getMetaData();

        for (int i = 1; i <= rsmd.getColumnCount(); i++) {

          String colName = rsmd.getColumnName(i);

          for (PacienteInfo info : PacienteInfo.values()) {

            if (info.getCampo().equals(colName))
              pb.setInfo(info, rs.getObject(i));
            break;
          }
        }
      }

    } catch (SQLException e) {

      System.out.println("Não foi possível selecionar o paciente usando a condição " + condition
          + " com  o valor " + conditionValue);
      e.printStackTrace();
    }

    return null;
  }
}