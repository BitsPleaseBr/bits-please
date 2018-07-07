package model;

import java.sql.Connection;
import com.mysql.cj.jdbc.DatabaseMetaData;
import model.conexao.ConnectionFactory;

public class ConnectionTest {

  public static void main(String[] args) {
    if (testeConexaoAmazonBitsPlease()) {
      System.out.println("Conexão com bits please no amazon criada");
    } else {
      System.out.println("Falha ao criar conexão com bits please no amazon");
    }
  }
  
  public static boolean testeConexaoAmazonBitsPlease() {
    try {
      Connection conexao = ConnectionFactory.getConnection();
      DatabaseMetaData metaDados = (DatabaseMetaData) conexao.getMetaData();
      System.out.println(metaDados.getDatabaseProductName() + ", " + metaDados.getDatabaseProductVersion() + ", " + metaDados.getDatabaseMajorVersion());
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

}
