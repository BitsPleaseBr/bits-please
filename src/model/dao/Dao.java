package model.dao;

import java.sql.PreparedStatement;
import java.util.HashMap;
import model.bean.info.Info;
import model.bean.info.Tabela;

public abstract class Dao {


  protected Tabela tabela;


  protected PreparedStatement mapToInsertStatement(HashMap<? extends Info, Object> mapa) {

    return mapToInsertStatement(tabela, mapa);
  }

  protected PreparedStatement mapToInsertStatement(Tabela tabela,
      HashMap<? extends Info, Object> mapa) {

    StatementFactory sf = new StatementFactory();
    
    return sf.setTabela(tabela).setTipo(sf.INSERT).setMap(mapa).create();
  }


  protected PreparedStatement infoToSelectStatement(Info condition, Object conditionValue,
      Info... infos) {

    return infoToSelectStatement(tabela, condition, conditionValue, infos);
  }

  protected PreparedStatement infoToSelectStatement(Tabela tabela, Info condition,
      Object conditionValue, Info... infos) {

    StatementFactory sf = new StatementFactory();

    return sf.setTabela(tabela).setTipo(sf.SELECT).setInfos(infos).setCondition(condition).setConditionValue(conditionValue).create();
  }


  protected PreparedStatement mapToUpdateStatement(HashMap<? extends Info, Object> mapa,
      Info condition) {

    return mapToUpdateStatement(tabela, mapa, condition);
  }

  protected PreparedStatement mapToUpdateStatement(Tabela tabela,
      HashMap<? extends Info, Object> mapa, Info condition) {

    StatementFactory sf = new StatementFactory();

    return sf.setTabela(tabela).setTipo(sf.UPDATE).setMap(mapa).setCondition(condition).create();
  }
}