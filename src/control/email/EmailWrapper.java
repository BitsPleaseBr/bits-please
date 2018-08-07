package control.email;

import java.util.stream.Collectors;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;
import control.crypto.BCrypt;
import control.extras.PropertiesManager;
import model.bean.PacienteBean;
import model.bean.info.PacienteInfo;
import model.bean.info.UserInfo;

/**
 * @author Diogo
 *
 */
public class EmailWrapper {
  private static String htmlEmailConfirmacao(String hash) {
    String htmlEmail = new PropertiesManager().getTemplateHTMLConfirmacao();
    htmlEmail = String.format(htmlEmail, hash);
    return htmlEmail;
  }
  
  public static void enviarEmailConfirmacao(PacienteBean paciente) {
    String id = String.valueOf(paciente.getInfo(PacienteInfo.IDUser));
    // Concatena todos os dados do usuário em uma só string. Essa string será hasheada para criar a ID de confirmação.
    String hash = paciente.getInfos().values().stream().map(a -> String.valueOf(a)).collect(Collectors.joining());
    hash = BCrypt.hashpw(hash, BCrypt.gensalt());
    hash = id + "$" + hash;
    String corpo = htmlEmailConfirmacao(hash);
    String endereco = String.valueOf(paciente.getInfo(UserInfo.Email));
    sendHTMLEmail(endereco, corpo);
  }
  
  public static void sendHTMLEmail(String endereco, String corpo) {
    // Create the email message
    HtmlEmail email = new HtmlEmail();
    email.setHostName("smtp.googlemail.com");
    email.setSmtpPort(465);
    email.setSSLOnConnect(true);
    email.setAuthenticator(new DefaultAuthenticator("bitspleasebr", "b1tspl34s3"));
    try {
      email.addTo(endereco);
      email.setFrom("bitspleasebr@gmail.com");
    } catch (EmailException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    email.setSubject("Email de Confirmação de Cadastro");

    try {
      // set the html message
      email.setHtmlMsg(corpo);

      // set the alternative message
      email.setTextMsg("Your email client does not support HTML messages");

      // send the email
      email.send();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public static void sendEmail() {
    Email email = new SimpleEmail();

    email.setHostName("smtp.googlemail.com");
    email.setSmtpPort(465);
    email.setAuthenticator(new DefaultAuthenticator("bitspleasebr", "b1tspl34s3"));
    email.setSSLOnConnect(true);
    try {
      email.setFrom("bitspleasebr@gmail.com");
      email.setSubject("TestMail");
      email.setMsg("This is a test mail ... :-)");
      email.addTo("diogodklein@gmail.com");
      email.send();
    } catch (Exception e) {

    }
  }
}
