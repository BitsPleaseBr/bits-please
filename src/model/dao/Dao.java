package model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map.Entry;
import model.bean.info.Info;
import model.conexao.ConnectionFactory;

public abstract class Dao {


  protected String tabela;


  protected PreparedStatement mapToInsertStatement(HashMap<? extends Info, Object> mapa) {

    return mapToInsertStatement(tabela, mapa);
  }

  protected PreparedStatement mapToInsertStatement(String tabela,
      HashMap<? extends Info, Object> mapa) {

    PreparedStatement ps = createStatement(estruturarInsert(tabela, mapa));

    prepareStatement(ps, mapa);

    return ps;
  }


  protected PreparedStatement infoToSelectStatement(Info condition, Object conditionValue,
      Info... infos) {

    return infoToSelectStatement(tabela, condition, conditionValue, infos);
  }

  protected PreparedStatement infoToSelectStatement(String tabela, Info condition,
      Object conditionValue, Info... infos) {

    PreparedStatement ps = createStatement(estruturarSelect(tabela, condition, infos));

    try {

      ps.setObject(1, conditionValue);
    } catch (SQLException e) {

      e.printStackTrace();
    }

    return ps;
  }


  protected PreparedStatement mapToUpdateStatement(HashMap<? extends Info, Object> mapa,
      Info condition) {

    return mapToUpdateStatement(tabela, mapa, condition);
  }

  protected PreparedStatement mapToUpdateStatement(String tabela,
      HashMap<? extends Info, Object> mapa, Info condition) {

    PreparedStatement ps = createStatement(estruturarUpdate(tabela, mapa, condition));

    prepareUpdateStatement(ps, mapa, condition);

    return ps;
  }


  protected PreparedStatement createStatement(String comando) {

    try {

      return ConnectionFactory.getConnection().prepareStatement(comando,
          Statement.RETURN_GENERATED_KEYS);
    } catch (SQLException e) {

      System.out.println("Erro ao criar Statement \n" + comando);
      e.printStackTrace();
    }

    return null;
  }

  protected void prepareStatement(PreparedStatement ps, HashMap<? extends Info, Object> mapa) {

    try {

      int i = 1;

      for (Entry<? extends Info, Object> entrada : mapa.entrySet()) {

        ps.setObject(i, entrada.getValue());

        i++;
      }
    } catch (SQLException e) {

      System.out.println("Erro ao definir valores");
      e.printStackTrace();
    }
  }

  protected void prepareUpdateStatement(PreparedStatement ps, HashMap<? extends Info, Object> mapa,
      Info condition) {

    int i = 1;

    try {

      for (Entry<? extends Info, Object> entrada : mapa.entrySet()) {

        if (entrada.getKey().equals(condition))
          continue;

        ps.setObject(i, entrada.getValue());

        i++;
      }

      ps.setObject(i, mapa.get(condition));

    } catch (SQLException e) {

      System.out.println("Erro ao definir valores");
      e.printStackTrace();
    }
  }


  protected String estruturarInsert(String tabela, HashMap<? extends Info, Object> mapa) {

    String insert = "insert into " + tabela + "(" + getInsertCampos(mapa) + ") values ("
        + getInsertValues(mapa.entrySet().size()) + ")";

    return insert;
  }

  protected String estruturarSelect(String tabela, Info condition, Info... infos) {

    return "select " + getSelectCampos(condition, infos) + " from " + tabela + " where "
        + condition.getCampo() + " = ?";
  }

  protected String estruturarUpdate(String tabela, HashMap<? extends Info, Object> mapa,
      Info condition) {

    return "update " + tabela + " set " + getCamposAndValues(mapa, condition) + " where "
        + condition.getCampo() + " = ?";
  }


  protected String getInsertCampos(HashMap<? extends Info, Object> mapa) {

    String campos = "";

    int i = 0;

    for (Entry<? extends Info, Object> entrada : mapa.entrySet()) {

      campos += ((Info) entrada.getKey()).getCampo();
      campos += i < mapa.entrySet().size() - 1 ? ", " : "";

      i++;
    }

    return campos;
  }

  protected String getInsertValues(int length) {

    String values = "";

    for (int i = 0; i < length; i++) {

      values += "?";
      values += i < length - 1 ? ", " : "";
    }

    return values;
  }

  protected String getSelectCampos(Info condition, Info... infos) {

    String campos = "";

    int i = 1;

    for (Info info : infos) {

      if (info.equals(condition))
        continue;

      campos += info.getCampo();
      campos += i < infos.length - 1 ? ", " : "";

      i++;
    }

    return campos;
  }

  protected String getCamposAndValues(HashMap<? extends Info, Object> mapa, Info condition) {

    String camposAndValues = "";

    int i = 0;

    for (Entry<? extends Info, Object> entrada : mapa.entrySet()) {

      if (entrada.getKey().equals(condition))
        continue;

      camposAndValues += ((Info) entrada.getKey()).getCampo() + " = ";
      camposAndValues += entrada.getValue();

      camposAndValues += i < mapa.entrySet().size() - 1 ? ", " : "";

      i++;
    }

    return camposAndValues;
  }
}
