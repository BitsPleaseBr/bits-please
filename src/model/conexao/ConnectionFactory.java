package model.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Diogo Classe para criar uma conexão com o banco de dados. Não pode ser instanciada.
 */
public class ConnectionFactory {
  // Constantes para acessar o banco de dados
  private static final String prefixoConnection = "jdbc:mysql://";
  private static final String urlBD = "bits-please.c6g4ywjszepf.sa-east-1.rds.amazonaws.com";
  private static final String porta = ":3306";
  private static final String nomeBD = "/bitsplease";
  private static final String connectionURL = prefixoConnection + urlBD + porta + nomeBD;
  private static final String user = "bitsadmin";
  private static final String password = "nullpointerexception123";

  /**
   * Método para retornar a conexão com o banco de dados
   * 
   * @return Uma instância da conexão com o banco de dados se ela foi bem sucedida, caso contrário
   *         retorna null.
   */
  public static Connection getConnection() {

    // Variável para retornar a conexão
    Connection conexao = null;

    // Realizar a conexão
    try {
      conexao = DriverManager.getConnection(connectionURL, user, password);
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
    return conexao;
  }
  
  private ConnectionFactory() {
    
  }
}
