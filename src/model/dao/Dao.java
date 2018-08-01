package model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map.Entry;
import model.conexao.ConnectionFactory;
import model.info.Info;

public abstract class Dao {


  protected String tabela;
  protected String primaryKeyField;
  

  protected PreparedStatement mapToInsertStatement(HashMap<? extends Info, Object> mapa) {

    return mapToInsertStatement(tabela, mapa);
  }

  protected PreparedStatement mapToInsertStatement(String tabela, HashMap<? extends Info, Object> mapa) {

    PreparedStatement ps = createStatement(estruturarInsert(mapa, tabela));

    prepararStatement(ps, mapa);

    return ps;
  }

  
  protected PreparedStatement infoArrayToSelectStatement(Info...infos) {
    
    return infoArrayToSelectStatement(tabela, infos);
  }
  
  protected PreparedStatement infoArrayToSelectStatement(String tabela, Info... infos) {
    
    PreparedStatement ps = createStatement(estruturarSelect(tabela, infos));
    
    
    
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
  
  protected void prepararStatement(PreparedStatement ps, HashMap<? extends Info, Object> mapa) {

    try {

      int i = 1;

      for (Entry<? extends Info, Object> entrada : mapa.entrySet()) {

        ps.setObject(i, entrada.getValue());

        i++;
      }
    } catch (SQLException e) {

      System.out.println("Erro ao definir valores");
    }
  }

  
  protected String estruturarInsert(HashMap<? extends Info, Object> mapa, String tabela) {

    String insert = "insert into " + tabela + "(" + getCampos(mapa) + ") values ("
        + getValues(mapa.entrySet().size()) + ")";

    return insert;
  }

  protected String estruturarSelect(String tabela, Info...infos) {
    
    String select = "select " + getCampos(infos) + " from " + tabela + " where " + primaryKeyField + "=";
    
    
    
    return select;
  }
  
  
  protected String getCampos(HashMap<? extends Info, Object> mapa) {

    String campos = "";

    int i = 0;

    for (Entry<? extends Info, Object> entrada : mapa.entrySet()) {

      campos += ((Info) entrada.getKey()).getCampo();
      campos += i < mapa.entrySet().size() - 1 ? ", " : "";

      i++;
    }

    return campos;
  }

  protected String getCampos(Info...infos) {
    
    String campos = "";

    int i = 0;

    for (Info info : infos) {

      campos += info.getCampo();
      campos += i < infos.length - 1 ? ", " : "";

      i++;
    }

    return campos;
  }
  
  protected String getValues(int length) {

    String values = "";

    for (int i = 0; i < length; i++) {

      values += "?";
      values += i < length - 1 ? ", " : "";
    }

    return values;
  }
}