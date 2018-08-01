package model.dao;

import java.sql.SQLException;
import model.bean.ProfissionalBean;
import model.info.ProfissionalInfo;

public class ProfissionalDao extends UserDao {


  public ProfissionalDao() {

    this.tabela = "TB_Profissional";
  }


  public ProfissionalDao cadastrar(ProfissionalBean bean) {

    int id = super.cadastrar(bean);

    bean.setInfo(ProfissionalInfo.IDUser, id);

    try {

      mapToInsertStatement(bean.getInfosPro()).execute();
    } catch (SQLException e) {

      System.out.println("Erro ao cadastrar profissional \n" + bean.toString());
      e.printStackTrace();
    }

    return this;
  }
}
