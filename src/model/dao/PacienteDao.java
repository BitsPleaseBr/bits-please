package model.dao;

import java.sql.SQLException;
import model.bean.PacienteBean;
import model.bean.info.PacienteInfo;

public class PacienteDao extends UserDao {


  public PacienteDao() {

    this.tabela = "TB_Paciente";
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
}
