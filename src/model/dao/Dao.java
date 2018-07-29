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


  protected PreparedStatement mapToStatement(HashMap<? extends Info, Object> mapa) {

    return mapToStatement(mapa, tabela);
  }

  protected PreparedStatement mapToStatement(HashMap<? extends Info, Object> mapa, String tabela) {

    PreparedStatement ps = createStatement(createInsert(mapa, tabela));

    prepararStatement(ps, mapa);

    return ps;
  }

  protected void prepararStatement(PreparedStatement ps, HashMap<? extends Info, Object> mapa) {

    try {

      int i = 1;

      for (Entry<? extends Info, Object> entrada : mapa.entrySet()) {

        ps.setObject(i, entrada.getValue());

        i++;
      }
    } catch (SQLException e) {

      System.out.println("Erro ao definir valores para o cadastro");
    }
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

  protected String createInsert(HashMap<? extends Info, Object> mapa, String tabela) {

    String insert = "insert into " + tabela + "(";
    String values = " values (";

    int i = 0;

    for (Entry<? extends Info, Object> entrada : mapa.entrySet()) {

      insert += ((Info) entrada.getKey()).getCampo();
      insert += i < mapa.entrySet().size() - 1 ? ", " : ")";

      values += "?";
      values += i < mapa.entrySet().size() - 1 ? ", " : ")";

      i++;
    }

    insert += values;

    return insert;
  }
}
