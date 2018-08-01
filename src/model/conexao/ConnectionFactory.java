package model.conexao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import control.extras.PropertiesManager;

/**
 * @author Diogo Classe para criar uma conexão com o banco de dados. Não pode ser instanciada.
 */
public class ConnectionFactory {
  
  // Constantes para acessar o banco de dados
  private static String prefixoConnection = "";
  private static String urlBD = "";
  private static String porta = "";
  private static String nomeBD = "";
  private static String connectionURL = "";
  private static String user = "";
  private static String password = "";

  static {
    
    Properties pr = new PropertiesManager().getConnectionProperties();
    
    prefixoConnection = pr.getProperty("prefixoConnection");
    urlBD = pr.getProperty("urlBD");
    porta = pr.getProperty("porta");
    nomeBD = pr.getProperty("nomeBD");
    connectionURL = prefixoConnection + urlBD + porta + nomeBD;
    user = pr.getProperty("user");
    password = pr.getProperty("password");
  }
  
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
  
  public static String getLocation() {
    
    String nomeClasse = "ConnectionFactory.class";
    String path = new File(nomeClasse).getPath();
    
    int lengthNome = nomeClasse.length();
    
    System.out.println(path);
    System.out.println(path.substring(0, path.length() - lengthNome));
    
    return path.substring(0, path.length() - lengthNome);
  }

  private ConnectionFactory() {
    
  }
}