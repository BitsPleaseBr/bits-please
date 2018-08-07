package control.extras;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import com.google.common.base.Charsets;
import com.google.common.io.Files;

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

  public String getTemplateHTMLConfirmacao() {
    String endereco = getTemplatePath() + "ConfirmationEmail";
    return getStringFromDocument(endereco);
  }

  /**
   * Retorna uma string de um documento a partir do endereço dele.
   * Google Guava FTW
   * @param endereco
   * O endereço do caminho do arquivo a ser convertido
   * @return
   * String do conteúdo de texto do arquivo.
   */
  public static String getStringFromDocument(String endereco) {

    try {
      return Files.asCharSource(new File(endereco), Charsets.UTF_8).read();
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  private String getTemplatePath() {
    return getPath() + "/templates/";
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
