package control.extras;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {

  
  public Properties getConnectionProperties() {
    
    Properties pr = new Properties();
    try {
      
      FileInputStream fs = new FileInputStream(getCredenciaisPath() + "connectionProperties");
      
      try {
        pr.load(fs);
      } catch (IOException e) {
        
        System.out.println("Não foi possível ler o arquivo connectionProperties");
        e.printStackTrace();
      }
      
    } catch (FileNotFoundException e) {

      System.out.println("Não foi possível encontrar o arquivo connectionProperties");
      e.printStackTrace();
    }
    
    return pr;
  }
  
  private String getCredenciaisPath() {
    
    return getPath() + "/credenciais/";
  }
  
  private String getPath() {
    
    String nomeClasse = "PropertiesManager.class";
    String path = getClass().getResource(nomeClasse).getPath();
    int pathLength = path.length();
    
    String classePath = "/classes/control/extras/PropertiesManager.class";
    int classePathLength = classePath.length();
    
    return path.substring(0, pathLength - classePathLength).replaceAll("%20", " ");
  }
}