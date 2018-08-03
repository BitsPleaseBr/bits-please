package model.dao;

import java.sql.SQLException;
import model.bean.MedicoBean;
import model.bean.info.MedicoInfo;

public class ProfissionalDao extends UserDao {


  public ProfissionalDao() {

    this.tabela = "TB_Profissional";
  }


  public ProfissionalDao cadastrar(MedicoBean bean) {

    int id = super.cadastrar(bean);

    bean.setInfo(MedicoInfo.IDUser, id);

    try {

      mapToInsertStatement(bean.getInfosPro()).execute();
    } catch (SQLException e) {

      System.out.println("Erro ao cadastrar profissional \n" + bean.toString());
      e.printStackTrace();
    }

    return this;
  }
}
