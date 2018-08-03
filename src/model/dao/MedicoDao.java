package model.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import model.bean.EnderecoBean;
import model.bean.MedicoBean;
import model.bean.TelefoneBean;
import model.bean.UserBean;
import model.bean.info.EnderecoInfo;
import model.bean.info.Info;
import model.bean.info.MedicoInfo;
import model.bean.info.Tabela;
import model.bean.info.TelefoneInfo;

public class MedicoDao extends UserDao {


  public MedicoDao() {

    this.tabela = Tabela.Medico;
  }


  public MedicoDao cadastrar(MedicoBean bean) {

    int id = super.cadastrar(bean);

    bean.setInfo(MedicoInfo.IDUser, id);

    try {

      mapToInsertStatement(bean.getInfosMed()).execute();
      
      for (EnderecoBean eb : bean.getEnderecos()) {
        
        eb.setInfo(EnderecoInfo.IDUser, id);
        mapToInsertStatement(Tabela.Endereco, eb.getInfos()).execute();
      }
      
      for (TelefoneBean tb : bean.getTelefones()) {
        
        tb.setInfo(TelefoneInfo.IDUser, id);
        mapToInsertStatement(Tabela.Telefone, tb.getInfos()).execute();
      }
      
    } catch (SQLException e) {

      System.out.println("Erro ao cadastrar profissional \n" + bean.toString());
      e.printStackTrace();
    }

    return this;
  }

  public MedicoDao alterar(MedicoBean bean) {

    super.alterar(bean);

    try {

      mapToUpdateStatement(bean.getInfosMed(), MedicoInfo.IDUser).execute();
    } catch (SQLException e) {

      System.out.println(
          "Não foi possível alterar o médico com id " + bean.getInfo(MedicoInfo.IDUser));
      e.printStackTrace();
    }

    return this;
  }

  public MedicoBean selecionar(int id) {

    return selecionar(MedicoInfo.IDUser, id);
  }

  public MedicoBean selecionar(Info condition, Object conditionValue) {

    UserBean ub = super.selecionar(condition, conditionValue);

    MedicoBean pb = new MedicoBean();
    pb.getInfosUser().putAll(ub.getInfosUser());

    try {

      ResultSet rs =
          infoToSelectStatement(condition, conditionValue, MedicoInfo.values()).executeQuery();

      while (rs.next()) {

        ResultSetMetaData rsmd = rs.getMetaData();

        for (int i = 1; i <= rsmd.getColumnCount(); i++) {

          String colName = rsmd.getColumnName(i);

          for (MedicoInfo info : MedicoInfo.values()) {

            if (info.getCampo().equals(colName))
              pb.setInfo(info, rs.getObject(i));
            break;
          }
        }
      }

    } catch (SQLException e) {

      System.out.println("Não foi possível selecionar o médico usando a condição " + condition
          + " com  o valor " + conditionValue);
      e.printStackTrace();
    }

    return null;
  }

}
