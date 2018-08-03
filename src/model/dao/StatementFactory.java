package model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map.Entry;
import model.conexao.ConnectionFactory;
import model.bean.info.Info;
import model.bean.info.Tabela;

public class StatementFactory {


  public final int INSERT = 1, SELECT = 2, UPDATE = 3;

  private String tabela;
  private int tipo;
  private HashMap<? extends Info, Object> mapa = new HashMap<>();
  private Info[] infos;
  private Info condition;
  private Object conditionValue;
  private PreparedStatement ps; 
  
  
  public PreparedStatement create() {
    
    instantiateStatement().prepareStatement();
    
    return ps;
  }
  
  
  private StatementFactory instantiateStatement() {
    
    try {

      ps = ConnectionFactory.getConnection().prepareStatement(estruturarComando(),
          Statement.RETURN_GENERATED_KEYS);
    } catch (SQLException e) {

      System.out.println("Erro ao criar Statement \n" + estruturarComando());
      e.printStackTrace();
    }
    
    return this;
  }
  
  private StatementFactory prepareStatement() {
    
    try {
      
      int i = 1;
      
      switch (tipo) {
        
        case INSERT: {

          for (Entry<? extends Info, Object> entrada : mapa.entrySet()) {

            ps.setObject(i, entrada.getValue());

            i++;
          }
          break;
        }
        
        case SELECT: {
          
          ps.setObject(1, conditionValue);
          break;
        }
        
        case UPDATE: {
          
          for (Entry<? extends Info, Object> entrada : mapa.entrySet()) {

            if (entrada.getKey().equals(condition))
              continue;
            
            ps.setObject(i, entrada.getValue());

            i++;
          }

          ps.setObject(i, mapa.get(condition));
          break;
        }
      }
    } catch(SQLException e) {
      
      System.out.println("Erro ao definir valores");
      e.printStackTrace();
    }
    
    return this;
  }

  private String estruturarComando() {

    String comando = "";

    switch (tipo) {

      case INSERT: {

        comando = "insert into " + tabela + "(" + getCampos() + ") values (" + getValues() + ")";
        break;
      }
      
      case SELECT: {
        
        comando = "select " + getCampos() + " from " + tabela + " where " + condition.getCampo() + " = ?";
        break;
      }
      
      case UPDATE: {
        
        comando = "update " + tabela + " set " + getCamposAndValues() + " where " + condition.getCampo() + " = ?";
        break;
      }
    }
    
    return comando;
  }


  private String getCampos() {

    String campos = "";

    int i = 0;

    switch (tipo) {

      case INSERT: {

        for (Entry<? extends Info, Object> entrada : mapa.entrySet()) {

          campos += ((Info) entrada.getKey()).getCampo();
          campos += i < mapa.entrySet().size() - 1 ? ", " : "";

          i++;
        }
        break;
      }

      case SELECT: {

        for (Info info : infos) {

          if (info.equals(condition))
            continue;

          campos += info.getCampo();
          campos += i < infos.length - 1 ? ", " : "";

          i++;
        }
        break;
      }
    }

    return campos;
  }

  private String getCamposAndValues() {

    String camposAndValues = "";

    int i = 0;

    for (Entry<? extends Info, Object> entrada : mapa.entrySet()) {

      if (entrada.getKey().equals(condition))
        continue;

      camposAndValues += ((Info) entrada.getKey()).getCampo() + " = ";
      camposAndValues += "?";

      camposAndValues += i < mapa.entrySet().size() - 2 ? ", " : "";

      i++;
    }

    return camposAndValues;
  }

  private String getValues() {
    
    String values = "";
    
    switch (tipo) {
      
      case INSERT: {

          int length = mapa.entrySet().size();

          for (int i = 0; i < length; i++) {

            values += "?";
            values += i < length - 1 ? ", " : "";
          }

          break;
        }
    }
    
    return values;
  }


  public StatementFactory setTabela(Tabela tabela) {

    this.tabela = tabela.getNome();

    return this;
  }

  public StatementFactory setTipo(int tipo) {

    this.tipo = tipo;

    return this;
  }

  public StatementFactory setCondition(Info condition) {

    this.condition = condition;

    return this;
  }

  public StatementFactory setConditionValue(Object value) {
    
    this.conditionValue = value;
    
    return this;
  }
  
  public StatementFactory setMap(HashMap<? extends Info, Object> mapa) {

    this.mapa = mapa;

    return this;
  }

  public StatementFactory setInfos(Info... infos) {

    this.infos = infos;

    return this;
  }
}